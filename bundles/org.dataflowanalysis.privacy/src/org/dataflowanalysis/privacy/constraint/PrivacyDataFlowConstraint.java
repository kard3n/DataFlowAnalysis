package org.dataflowanalysis.privacy.constraint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.dataflowanalysis.analysis.core.DataCharacteristic;
import org.dataflowanalysis.analysis.core.FlowGraphCollection;
import org.dataflowanalysis.analysis.dfd.core.DFDCharacteristicValue;
import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.dfd.datadictionary.PinRelation;
import org.dataflowanalysis.dfd.dataflowdiagram.Node;
import org.dataflowanalysis.privacy.constraint.violation.AbstractPrivacyConstraintViolation;
import org.dataflowanalysis.privacy.constraint.violation.ConsentPrivacyConstraintViolation;
import org.dataflowanalysis.privacy.constraint.violation.NodeCombinationPrivacyConstraintViolation;
import org.dataflowanalysis.privacy.constraint.violation.PinCombinationPrivacyConstraintViolation;
import org.dataflowanalysis.privacy.privacymodel.DataContext;
import org.dataflowanalysis.privacy.privacymodel.DataContextLabel;
import org.dataflowanalysis.privacy.privacymodel.DataItem;
import org.dataflowanalysis.privacy.privacymodel.DataItemLabel;
import org.dataflowanalysis.privacy.privacymodel.DataState;
import org.dataflowanalysis.privacy.privacymodel.DataStateLabel;
import org.dataflowanalysis.privacy.privacymodel.Functionality;
import org.dataflowanalysis.privacy.privacymodel.FunctionalityLabel;
import org.dataflowanalysis.privacy.privacymodel.RoleLabel;
import org.dataflowanalysis.privacy.privacymodel.UserDataCombination;

public class PrivacyDataFlowConstraint {
	private static final Logger logger = LoggerManager.getLogger(PrivacyDataFlowConstraint.class);

	public static HashSet<AbstractPrivacyConstraintViolation> findViolations(FlowGraphCollection flowGraphs,
			boolean checkNodeLevelInference, boolean considerOutputPins) {
		return findViolations(flowGraphs.getTransposeFlowGraphs(), checkNodeLevelInference, considerOutputPins);
	}

	/**
	 * For an item, holds its state and context. A state set can be associated with
	 * multiple context sets: when state sets are joined, the context is maintained
	 * separate
	 */
	public record ItemInformation(Set<DataState> state, Set<Set<DataContext>> context) {
		/**
		 * Creates a shallow clone of the input
		 * 
		 * @param input
		 * @return
		 */
		public ItemInformation cloneShallow() {
			return new ItemInformation(new HashSet<>(this.state),
					new HashSet<>(this.context.stream().map(set -> new HashSet<>(set)).toList()));
		}
	}

	/**
	 * Detects and returns all privacy violations over the given flow graphs
	 * 
	 * @param flowGraphs
	 * @param checkNodeLevelInference If inference should be simulated on a node
	 *                                level
	 * @param considerOutputPins      If the data from output pins should be checked
	 *                                for validity. Output pins part of a pin
	 *                                relations will always be considered
	 * @return
	 */
	public static HashSet<AbstractPrivacyConstraintViolation> findViolations(
			List<? extends AbstractTransposeFlowGraph> flowGraphs, boolean checkNodeLevelInference,
			boolean considerOutputPins) {
		HashSet<AbstractPrivacyConstraintViolation> violations = new HashSet<>();

		// # Step 1: determine all vertices (by their ID) of the flow graphs
		// Map ID of the vertex (ID of the referenced element), with the versions that
		// exist in the flowgraphs
		HashMap<String, LinkedList<AbstractVertex<?>>> vertexInstances = computeVertices(flowGraphs);

		// Step two: calculate worst-case scenarios for every pin
		for (var entry : vertexInstances.entrySet()) { // go over vertices

			boolean nodeRepresentsUser = nodeRepresentsUser(entry.getValue().getFirst().getAllVertexCharacteristics());

			if (nodeRepresentsUser) {
				// The vertex represents a user: group vertex instances by their functionalities
				// and check if the received data is allowed. Don't check for consent (will
				// always be met) or inference

				// Group by functionalities. A single user can generate multiple TFGs due to
				// branching
				HashMap<HashSet<FunctionalityLabel>, ArrayList<AbstractVertex<?>>> verticesByFunctionalities = groupByFunctionalities(
						entry.getValue());

				for (var vertexGroup : verticesByFunctionalities.entrySet()) {
					HashMap<String, HashSet<HashSet<CharacteristicValue>>> pinToCharacteristics = new HashMap<>();
					for (var vertex : vertexGroup.getValue()) {

						List<DataCharacteristic> currentCharacteristics = ((DFDVertex) vertex)
								.getAllIncomingDataCharacteristics();
						if (considerOutputPins) {
							currentCharacteristics.addAll(((DFDVertex) vertex).getAllOutgoingDataCharacteristics());
						}

						var newCharacteristicsPerPin = groupIncomingCharacteristicsByPin(currentCharacteristics);

						for (var newCharacteristics : newCharacteristicsPerPin.entrySet()) {
							pinToCharacteristics.computeIfAbsent(newCharacteristics.getKey(),
									k -> new HashSet<HashSet<CharacteristicValue>>());
							pinToCharacteristics.get(newCharacteristics.getKey()).add(newCharacteristics.getValue());
						}
					}

					for (var pin : pinToCharacteristics.entrySet()) {
						var dataItemToDataState = groupDataInformationByItem(pin.getValue());

						var possibleCombinations = calculateItemToDataStateCombinations(dataItemToDataState);
						// Check that each of the possible combinations is allowed
						var vertexFunctionalities = vertexGroup.getKey().stream().map(v -> v.getFunctionality())
								.toList();
						String vertexName = ((DFDVertex) vertexGroup.getValue().get(0)).getName();
						for (var combination : possibleCombinations) {
							if (!combinationAllowedByFunctionalities(combination, vertexFunctionalities)) {
								violations.add(new NodeCombinationPrivacyConstraintViolation(vertexName,
										"The user-representing vertex " + vertexName
												+ " has received a data combination in pin " + pin.getKey()
												+ " not allowed for any of its functionalities.\nReceived combination: "
												+ itemInformationToString(combination)
												+ "\nFunctionalities of the vertex: " + vertexFunctionalities.stream()
														.map(co -> functionalityToString(co)).toList(),
										combination, vertexFunctionalities));
							}
						}

					}

				}

			} else { // Logic for normal nodes: all instances have the same associated
						// functionalities
				// group CharacteristicValue lists by pin (DataCharacteristic.variableName)
				HashMap<String, HashSet<HashSet<CharacteristicValue>>> pinToCharacteristics = new HashMap<>();
				DFDVertex vert = null;
				// Calculate all groups of related pins
				List<HashSet<String>> pinRelationGroups = null;
				Set<String> pinsInGroups = null;
				List<FunctionalityLabel> vertexFunctionalityLabels = null;

				for (var vertBase : entry.getValue()) {
					// Go through the instances of the vertex from every TFG, and add the grouped
					// information of their pins
					if (vert == null) {
						vert = (DFDVertex) vertBase;
						pinRelationGroups = calculatePinRelationGroups(
								vert.getReferencedElement().getBehavior().getPinRelations());
						pinsInGroups = pinRelationGroups.stream().flatMap(Set::stream).collect(Collectors.toSet());
						vertexFunctionalityLabels = extractFunctionalityLabels(vertBase.getAllVertexCharacteristics());
					}

					List<DataCharacteristic> currentCharacteristics = ((DFDVertex) vertBase)
							.getAllIncomingDataCharacteristics();
					if (considerOutputPins) {
						currentCharacteristics.addAll(((DFDVertex) vertBase).getAllOutgoingDataCharacteristics());
					} else {
						// Only add pins that are in a pin relation group
						var pinsInGroupsFinal = pinsInGroups;
						currentCharacteristics.addAll(((DFDVertex) vertBase).getAllOutgoingDataCharacteristics()
								.stream().filter(i -> pinsInGroupsFinal.contains(i.getVariableName())).toList());
					}

					var newCharacteristicsPerPin = groupIncomingCharacteristicsByPin(currentCharacteristics);
					for (var newCharacteristics : newCharacteristicsPerPin.entrySet()) {
						pinToCharacteristics.computeIfAbsent(newCharacteristics.getKey(),
								k -> new HashSet<HashSet<CharacteristicValue>>());
						pinToCharacteristics.get(newCharacteristics.getKey()).add(newCharacteristics.getValue());
					}
				}
				
				// Check for missing consent
				for(var characteristicsOfPin: pinToCharacteristics.entrySet()) {
					for(var receivedCombination: characteristicsOfPin.getValue()) {
						// Go through the lists of CharacteristicValues, and check that all
						// functionalities of the node (in form of functionalities)
						// are present in it -> check that the user has consented to all functionalities
						// of this node
						if (!allFunctionalitiesConsentedTo(receivedCombination, vertexFunctionalityLabels)) {
							// Ignore output pins if considerOutputPins is disabled
							if(!considerOutputPins && vert.getReferencedElement().getBehavior().getOutPin().stream().anyMatch(ch -> ch.getId().equals(characteristicsOfPin.getKey()))) {
								continue;
							}
							
							List<Functionality> consentedFunctionalities = extractFunctionalityLabels(
									receivedCombination).stream().map(label -> label.getFunctionality())
									.toList();
							List<Functionality> vertexFunctionalities = vertexFunctionalityLabels.stream()
									.map(label -> label.getFunctionality()).toList();

							violations.add(new ConsentPrivacyConstraintViolation(vert.getName(), "The vertex "
									+ vert.getName() + " can receive data in pin " + characteristicsOfPin.getKey()
									+ " from a user who has not consented to its functionalities. \nFunctionalities consented to by user: "
									+ consentedFunctionalities.stream().map(func -> func.getEntityName()).toList()
									+ "\nFunctionalities of the vertex: "
									+ vertexFunctionalities.stream().map(func -> func.getEntityName()).toList()
									+ "\nReceived input labels: "
									+ receivedCombination.stream().map(i -> i.toString()).toList(),
									characteristicsOfPin.getKey(), consentedFunctionalities, vertexFunctionalities));
						}
					}
				}

				// Get all consent options
				List<Functionality> functionalities = extractFunctionalityLabels(vert.getAllVertexCharacteristics())
						.stream().map(label -> label.getFunctionality()).toList();

				// List of all combinations from the pins, grouped by the pin they originate
				// from
				HashMap<String, List<HashMap<DataItem, ItemInformation>>> nodeLevelCombinations = new HashMap<>();

				// Evaluate every pin by itself: check that only data from users who have
				// consented to this node's functionalities reached this pin,
				// and that the data combinations are allowed as part of this node's
				// functionalities
				for (var pin : pinToCharacteristics.entrySet()) {
					// Create worst-case scenarios for this pin by creating the smallest subset of
					// DataStates possible for each data item, using the following rule:
					// Two DataState sets can be combined to their intersection, if their
					// intersection is not empty.
					// If two sets contain DataStates that can not be related to each other, those
					// sets can not be unified

					var dataItemToDataState = groupDataInformationByItem(pin.getValue());
					dataItemToDataState.keySet().forEach(item -> {
						dataItemToDataState.put(item, reduceDataStateSets(dataItemToDataState.get(item)));
					});

					var possibleCombinations = calculateItemToDataStateCombinations(dataItemToDataState);
					nodeLevelCombinations.put(pin.getKey(), possibleCombinations);
					// Check that each of the possible combinations is allowed

					for (var combination : possibleCombinations) {

						if (!combinationAllowedByFunctionalities(combination, functionalities)) {
							// Ignore output pins if considerOutputPins is disabled
							if(!considerOutputPins && vert.getReferencedElement().getBehavior().getOutPin().stream().anyMatch(ch -> ch.getId().equals(pin.getKey()))) {
								continue;
							}

							violations.add(new PinCombinationPrivacyConstraintViolation(vert.getName(), "The vertex "
									+ vert.getName() + " has received a data combination in pin " + pin.getKey()
									+ " or could infere one not allowed for any of its functionalities.\nReceived combination: "
									+ itemInformationToString(combination) + "\nFunctionalities of the vertex: "
									+ functionalities.stream().map(co -> functionalityToString(co)).toList(),
									pin.getKey(), combination, functionalities));
						}

					}

				}

				// For all pins marked as related, combine their combinations
				List<HashMap<DataItem, ItemInformation>> finalCombinations = new LinkedList<>();

				// Unite the combinations of related pins
				for (var pinGroup : pinRelationGroups) {
					List<HashMap<DataItem, ItemInformation>> newCombinations = new LinkedList<>();
					for (String pin : pinGroup) {
						var combination = nodeLevelCombinations.get(pin);
						if (combination == null) {
							logger.warn("The pin " + pin + " in node " + vert.getName()
									+ " is a member of a pin relation, but no information for it was received as part of the node's incoming or outgoing data characteristics.");
							continue;
						}
						if (newCombinations.isEmpty()) {
							newCombinations.addAll(nodeLevelCombinations.get(pin));
						} else {
							newCombinations = dataCombinationProduct(newCombinations, nodeLevelCombinations.get(pin));
						}
						nodeLevelCombinations.remove(pin);
					}
					finalCombinations.addAll(newCombinations);
				}

				// Add all combinations from pins that are not in a relation
				for (var remainingPinCombinations : nodeLevelCombinations.values()) {
					finalCombinations.addAll(remainingPinCombinations);
				}

				// Evaluate inference at the node level
				if (checkNodeLevelInference) {
					violations.addAll(verifyDataTupleConformance(uniteItemTuples(finalCombinations), functionalities,
							vert.getName()));
				}
			}

		}

		return violations;
	}

	private static List<HashSet<String>> calculatePinRelationGroups(List<PinRelation> relations) {
		LinkedList<HashSet<String>> pinGroups = new LinkedList<>();
		for (var relation : relations) {
			boolean wasAdded = false;
			String nameOne = relation.getInputPin().getId();
			String nameTwo = relation.getOutputPin().getId();
			for (var group : pinGroups) {

				if (group.contains(nameOne) || group.contains(nameTwo)) {
					wasAdded = true;
					group.add(nameOne);
					group.add(nameTwo);
					break;
				}
			}
			if (!wasAdded) {
				HashSet<String> newGroup = new HashSet<>();
				newGroup.add(nameOne);
				newGroup.add(nameTwo);
				pinGroups.add(newGroup);
			}
		}

		return pinGroups;
	}

	/**
	 * Calculates the cartesian product of the two combinations, combining each
	 * combination with all of those from the other set.
	 * 
	 * @param combinationsOne
	 * @param combinationsTwo
	 * @return
	 */
	private static List<HashMap<DataItem, ItemInformation>> dataCombinationProduct(
			List<HashMap<DataItem, ItemInformation>> combinationsOne,
			List<HashMap<DataItem, ItemInformation>> combinationsTwo) {

		List<HashMap<DataItem, ItemInformation>> result = new LinkedList<>();

		// Return if either list is empty
		if (combinationsOne.isEmpty() || combinationsTwo.isEmpty()) {
			return result;
		}

		for (HashMap<DataItem, ItemInformation> combOne : combinationsOne) {
			for (HashMap<DataItem, ItemInformation> combTwo : combinationsTwo) {

				HashMap<DataItem, ItemInformation> mergedComb = new HashMap<>();

				combOne.forEach((key, value) -> mergedComb.put(key, value.cloneShallow()));

				// Iterate through the second set to either merge or add items
				combTwo.forEach((key, infoTwo) -> {
					if (mergedComb.containsKey(key)) {
						ItemInformation infoOne = mergedComb.get(key);

						// State: Calculate the intersection
						Set<DataState> joinedState = new HashSet<>(infoOne.state());
						joinedState.retainAll(infoTwo.state());

						// Context: Simply add the sets together
						Set<Set<DataContext>> joinedContext = new HashSet<>(infoOne.context());
						joinedContext.addAll(infoTwo.context());

						// Replace the item with the newly joined ItemInformation
						mergedComb.put(key, new ItemInformation(joinedState, joinedContext));
					} else {
						// The item only exists in the second combination, just add its clone
						mergedComb.put(key, infoTwo.cloneShallow());
					}
				});

				// Add the resulting combined HashMap to the final list
				result.add(mergedComb);
			}
		}

		return result;
	}

	/**
	 * Groups the vertex instances of every TFG by their ID
	 * 
	 * @param tfgs The list of TFGs whose vertices to group
	 * @return A Map, which for every vertex ID contains a list of vertex instances
	 *         with that same ID
	 */
	private static HashMap<String, LinkedList<AbstractVertex<?>>> computeVertices(
			List<? extends AbstractTransposeFlowGraph> tfgs) {
		HashMap<String, LinkedList<AbstractVertex<?>>> vertexInstances = new HashMap<>();
		tfgs.forEach(tfg -> {
			tfg.getVertices().forEach(vertex -> {
				// Note: this only works if a Node is referenced. Might not work with PCM models
				vertexInstances.computeIfAbsent(((Node) vertex.getReferencedElement()).getId(), k -> new LinkedList<>())
						.add(vertex);
			});
		});

		return vertexInstances;
	}

	/**
	 * Groups the lists of incoming data characteristics of the vertex to their
	 * origin input pin
	 * 
	 * @param incomingCharacteristics The incoming characteristics of the vertex
	 *                                whose CharacteristicValues to group
	 * @return A HashMap whose key is the ID of a pin, and the value the set of
	 *         CharacteristicValues that can reach said pin
	 */
	public static HashMap<String, HashSet<CharacteristicValue>> groupIncomingCharacteristicsByPin(
			List<DataCharacteristic> incomingCharacteristics) {
		HashMap<String, HashSet<CharacteristicValue>> pinToIncomingCharacteristics = new HashMap<>();
		// Each pin will only be present once per vertex since TFGs are split if a pin
		// receives more than one input flow
		incomingCharacteristics.forEach(incoming -> {
			pinToIncomingCharacteristics.put(incoming.getVariableName(),
					new HashSet<CharacteristicValue>(incoming.getAllCharacteristics()));
		});

		return pinToIncomingCharacteristics;
	}

	/**
	 * Given a list of a pin's incoming characteristics, checks that the passed
	 * Node's functionalities are included for each of the incoming items.
	 * 
	 * @param pinIncomingCharacteristics The incoming characteristics of a pin
	 * @param vertexFunctionalities      The functionalities of the vertex
	 * @return False if a violation is found, otherwise true
	 */
	public static boolean allFunctionalitiesConsentedTo(HashSet<CharacteristicValue> pinIncomingCharacteristics,
			List<FunctionalityLabel> vertexFunctionalities) {

		// Check that the incoming labels contain at least one data item
		if (pinIncomingCharacteristics.stream()
				.filter(i -> ((DFDCharacteristicValue) i).getLabel() instanceof DataItemLabel).count() == 0) {
			return true;
		}

		if (!extractFunctionalityLabels(pinIncomingCharacteristics).containsAll(vertexFunctionalities)) {
			return false;
		}
		return true;
	}

	/**
	 * Returns all ConsentLabels of the passed list
	 * 
	 * @param labels List of characteristicValues
	 * @return The labels of type ConsentLabel part of a CharacteristicValue of the
	 *         passed list
	 */
	private static List<FunctionalityLabel> extractFunctionalityLabels(Collection<CharacteristicValue> labels) {
		return labels.stream().map(cv -> ((DFDCharacteristicValue) cv)).filter(cv -> {
			return cv.getLabel() instanceof FunctionalityLabel;
		}).map(cv -> ((FunctionalityLabel) cv.getLabel())).toList();
	}

	/**
	 * Taking a set of sets of CharacteristicValues, extracts the data items for
	 * each, and associates them with that set's DataStates.
	 * 
	 * @param values
	 * @return
	 */
	private static HashMap<DataItem, List<ItemInformation>> groupDataInformationByItem(
			HashSet<HashSet<CharacteristicValue>> values) {
		HashMap<DataItem, List<ItemInformation>> itemToStates = new HashMap<>();
		for (var characSet : values) {
			var dataStates = extractDataStates(characSet);
			var dataContexts = extractDataContexts(characSet);
			var dataItems = extractDataItems(characSet);

			dataItems.forEach(item -> {
				itemToStates.computeIfAbsent(item, k -> new LinkedList<>())
						.add(new ItemInformation(new HashSet<>(dataStates), Set.of(new HashSet<>(dataContexts))));
			});
		}

		return itemToStates;
	}

	/**
	 * * Checks if a node represents a user (has a role associated) * * @param
	 * labels List of characteristicValues * @return True when the labels contain at
	 * least one role label
	 */
	private static boolean nodeRepresentsUser(Collection<CharacteristicValue> labels) {
		return labels.stream().map(cv -> ((DFDCharacteristicValue) cv)).filter(cv -> {
			return cv.getLabel() instanceof RoleLabel;
		}).count() > 0;
	}

	/**
	 * From the given list of CharacteristicValues, extract all DataStates
	 * associated with its DataStateLabels
	 * 
	 * @param labels list of CharacteristicValue whose DataStates to extract
	 * @return A list of DataStates
	 */
	public static List<DataState> extractDataStates(Collection<CharacteristicValue> labels) {
		return labels.stream().map(cv -> ((DFDCharacteristicValue) cv)).filter(cv -> {
			return cv.getLabel() instanceof DataStateLabel;
		}).map(cv -> ((DataStateLabel) cv.getLabel()).getDataState()).toList();
	}

	/**
	 * From the given list of CharacteristicValues, extract all DataContexts
	 * associated with its DataContextLabels
	 * 
	 * @param labels list of CharacteristicValue whose DataContexts to extract
	 * @return A list of DataContexts
	 */
	public static List<DataContext> extractDataContexts(Collection<CharacteristicValue> labels) {
		return labels.stream().map(cv -> ((DFDCharacteristicValue) cv)).filter(cv -> {
			return cv.getLabel() instanceof DataContextLabel;
		}).map(cv -> ((DataContextLabel) cv.getLabel()).getDataContext()).toList();
	}

	/**
	 * From the given list of CharacteristicValues, extract all DataItems associated
	 * with its DataItemLabels
	 * 
	 * @param labels list of CharacteristicValue whose DataItems to extract
	 * @return A list of DataItems
	 */
	public static List<DataItem> extractDataItems(Collection<CharacteristicValue> labels) {
		return labels.stream().map(cv -> ((DFDCharacteristicValue) cv)).filter(cv -> {
			return cv.getLabel() instanceof DataItemLabel;
		}).map(cv -> ((DataItemLabel) cv.getLabel()).getDataItem()).toList();
	}

	/**
	 * Constructs the largest possible sets of the data states of the passed
	 * ItemInformations by creating their intersection. If two sets contain a
	 * DataState that can not be associated to a DataState of the other set, the
	 * intersection of those two sets can not be created in that iteration as their
	 * data can not be related. The context of the resulting ItemInfos is the
	 * combined one of those that were combined into it.
	 * 
	 * @param states
	 * @return
	 */
	public static List<ItemInformation> reduceDataStateSets(List<ItemInformation> info) {
		// If less than two, we can't do intersections
		if (info.size() < 2)
			return info;

		List<ItemInformation> reducedState = new LinkedList<>();
		info.forEach(stateList -> {
			reducedState.add(stateList.cloneShallow());
		});

		boolean stateChanged = true;
		while (stateChanged) {
			stateChanged = false;
			if (reducedState.size() < 2)
				break;
			for (int i = 0; i < reducedState.size() && !stateChanged; i++) {
				// Try to intersect with this set with each other of the sets
				// If the intersection is possible, the original sets are removed and the
				// intersection added

				var itemInfo = reducedState.get(i);
				for (var otherItemInfo : reducedState) {
					if (itemInfo == otherItemInfo)
						continue;
					if (stateSetsCanBeIntersected(itemInfo.state, otherItemInfo.state)) {
						var intersection = new HashSet<>(itemInfo.state);
						intersection.retainAll(otherItemInfo.state);
						reducedState.remove(itemInfo);
						reducedState.remove(otherItemInfo);
						// Add to the beginning. This set is reduced and therewith more likely to be
						// able to intersect with other entries
						var newContext = itemInfo.context;
						newContext.addAll(otherItemInfo.context);
						reducedState.add(0, new ItemInformation(intersection, newContext));
						stateChanged = true;
						break;
					}
				}
			}
		}

		return reducedState;
	}

	/**
	 * Checks that both sets don't contain a DataState that can not be related with
	 * a DataState of the other set
	 * 
	 * @param setOne The first set
	 * @param setTwo The second set
	 * @return True if the sets may be intersected to create a worse-case set
	 */
	public static boolean stateSetsCanBeIntersected(Set<DataState> setOne, Set<DataState> setTwo) {
		if (setOne.equals(setTwo))
			return true; // Quick check: if equal, they can be intersected

		var intersection = new HashSet<>(setOne);
		intersection.retainAll(setTwo);

		// Check for DataState non-relatability
		boolean setOneUnrelatable = false;
		boolean setTwoUnrelatable = false;
		for (var stateOne : setOne) {
			if (setOneUnrelatable && setTwoUnrelatable)
				break;

			for (var stateTwo : setTwo) {
				if (stateOne.getNotRelatableWith().contains(stateTwo)) {
					setTwoUnrelatable = true;
				}
				if (stateTwo.getNotRelatableWith().contains(stateOne)) {
					setOneUnrelatable = true;
				}
			}
		}

		return !(setOneUnrelatable && setTwoUnrelatable);
	}

	/**
	 * Iteratively computes all possible combinations of
	 * {@code Map<DataItem, ItemInformation>} for the input
	 * 
	 * @param input A map linking DataItems to their possible ItemInformations.
	 * @return A List<HashMap<DataItem, ItemInformation>>, created recursively
	 */
	public static List<HashMap<DataItem, ItemInformation>> calculateItemToDataStateCombinations(
			HashMap<DataItem, List<ItemInformation>> input) {
		return calculateItemToDataStateCombinations(input, new HashMap<>());
	}

	/**
	 * Iteratively computes all possible combinations of Map<DataItem,
	 * ItemInformation> for the input
	 * 
	 * @param input          A map linking DataItems to their possible
	 *                       ItemInformations. Should only include DataItems which
	 *                       have not yet been added to the startingResult
	 * @param startingResult The intermediary result from the previous iteration
	 * @return A List<HashMap<DataItem, ItemInformation>>, created recursively
	 */
	public static List<HashMap<DataItem, ItemInformation>> calculateItemToDataStateCombinations(
			HashMap<DataItem, List<ItemInformation>> input, HashMap<DataItem, ItemInformation> startingResult) {
		List<HashMap<DataItem, ItemInformation>> result = new ArrayList<>();

		for (var entry : input.entrySet()) {
			if (entry.getValue().size() == 0) {
				startingResult.put(entry.getKey(), new ItemInformation(new HashSet<>(), new HashSet<>()));
			} else if (entry.getValue().size() == 1) {
				startingResult.put(entry.getKey(), entry.getValue().get(0));
			} else {
				// more than one element
				for (int i = 0; i < entry.getValue().size(); i++) {
					@SuppressWarnings("unchecked")
					var newIn = (HashMap<DataItem, List<ItemInformation>>) input.clone();
					newIn.remove(entry.getKey()); // Remove current entry. It has been treated by us, should not be
													// passed to the next list
					@SuppressWarnings("unchecked")
					var newStarting = (HashMap<DataItem, ItemInformation>) startingResult.clone();
					newStarting.put(entry.getKey(), entry.getValue().get(i));
					result.addAll(calculateItemToDataStateCombinations(newIn, newStarting));
				}
				return result; // delegated calculation of entries to others, return
			}
		}

		result.add(startingResult);
		return result;
	}

	/**
	 * Checks that the dataCombination is compatible with at least one of the
	 * functionalities
	 * 
	 * @param dataCombination     The combination that should be checked for
	 *                            compatibility
	 * @param nodeFunctionalities The functionalities, the combination should be
	 *                            compatible with
	 * @return True if the combination is allowed by the functionalities
	 */
	public static boolean combinationAllowedByFunctionalities(HashMap<DataItem, ItemInformation> dataCombination,
			List<Functionality> nodeFunctionalities) {
		if (dataCombination.isEmpty()) {
			return true;
		}

		var functionalityCopy = (List<Functionality>) new LinkedList<>(nodeFunctionalities);

		// Filter all functionalities, removing those that don't have a data combination
		// that allows for all items of the received data combinations
		functionalityCopy = functionalityCopy.stream().filter(co -> {
			// Check that the current functionality has at least one permitted data
			// combination that is
			// compatible with the received one
			return co.getAllowsFor().stream().filter(udc -> {
				for (var receivedItem : dataCombination.entrySet()) {
					if (!combinationAllowsItem(udc, receivedItem.getKey(), receivedItem.getValue()))
						return false;
				}
				return true;
			}).count() > 0;
		}).toList();

		return !functionalityCopy.isEmpty();
	}

	/**
	 * Checks that the passed data item is compatible with the data combination.
	 * This means that it itself must included in the combination, the combination's
	 * list of states for the item must be a sublist of the item's states and the
	 * combination's list of contexts must be a subset of all context sets of the
	 * item.
	 * 
	 * @param combination A data combination of the privacy model
	 * @param item        The item to check for
	 * @param itemInfo    The information of the item. Contains both state and
	 *                    context
	 * @return
	 */
	public static boolean combinationAllowsItem(UserDataCombination combination, DataItem item,
			ItemInformation itemInfo) {
		var combinationMembersOfItemWithCorrectState = combination.getMembers().stream()
				.filter(member -> member.getItem().equals(item) && itemInfo.state.containsAll(member.getState()))
				.toList();
		if (combinationMembersOfItemWithCorrectState.size() == 0)
			return false;

		// Special case: empty context
		if (itemInfo.context.isEmpty()) {
			return combinationMembersOfItemWithCorrectState.stream().anyMatch(combMember -> combMember.getContext().isEmpty());
		}

		return itemInfo.context.stream().allMatch(contextSet -> {
			logger.error(contextSet);
			combinationMembersOfItemWithCorrectState.stream().forEach(combMember -> logger.warn(combMember.getContext()));
			return combinationMembersOfItemWithCorrectState.stream()
					.anyMatch(combMember -> contextSet.containsAll(combMember.getContext()));
		});
	}

	/**
	 * Given the combinations, creates the biggest sets possible by checking for
	 * inference through overlaps
	 * 
	 * @param combinations The input sets
	 * @return The expanded sets
	 */
	public static List<HashMap<DataItem, ItemInformation>> uniteItemTuples(
			List<HashMap<DataItem, ItemInformation>> inputCombinations) {
		List<HashMap<DataItem, ItemInformation>> result = new ArrayList<>(inputCombinations);

		boolean stateChanged = true;
		while (stateChanged) {
			stateChanged = false;
			for (int x = 0; x < result.size(); x++) {
				for (int y = 0; y < result.size(); y++) {
					if (x == y)
						continue;
					// Get intersection of items (ignoring state)
					var combinationOne = result.get(x);
					var combinationTwo = result.get(y);
					Set<DataItem> intersection = new HashSet<>(combinationOne.keySet());
					intersection.retainAll(combinationTwo.keySet());
					if (intersection.size() == 0)
						continue; // Empty intersection: sets can't be combined

					// Check which of the items of the intersection cannot be related
					List<DataItem> nonRelatable = intersection.stream()
							.filter(item -> !stateSetsCanBeIntersected(combinationOne.get(item).state,
									combinationTwo.get(item).state))
							.toList();

					// If all items of the intersection are unrelatable: cannot do intersection
					// (inference)
					if (intersection.size() == nonRelatable.size())
						continue;

					// Create a new base combination, including all items that were both not in the
					// intersection and are unrelatable
					HashMap<DataItem, ItemInformation> baseNewCombination = new HashMap<>();
					for (var item : combinationOne.entrySet()) {
						if (!nonRelatable.contains(item.getKey()))
							baseNewCombination.put(item.getKey(), item.getValue().cloneShallow());
					}

					boolean stateWasReduced = false;
					for (var item : combinationTwo.entrySet()) {
						if (!nonRelatable.contains(item.getKey())) {
							if (!baseNewCombination.containsKey(item.getKey())) {
								baseNewCombination.put(item.getKey(), item.getValue().cloneShallow());
							} else {
								if (baseNewCombination.get(item.getKey()).state.retainAll(item.getValue().state)) {
									baseNewCombination.get(item.getKey()).context.addAll(item.getValue().context);
									stateWasReduced = true;
								}
							}
						}
					}

					// Intersection has the same elements as both combinations and no state was
					// reduced: no reduction can be done
					if (!stateWasReduced && intersection.equals(combinationOne.keySet())
							&& intersection.equals(combinationTwo.keySet())) {
						continue;
					}

					List<HashMap<DataItem, ItemInformation>> newCombinations = new LinkedList<>();
					newCombinations.add(baseNewCombination);

					// Add non-relatable entries of the intersection to the new combinations
					// For each one, duplicate the old set: one for item one, and one for item two
					for (var item : nonRelatable) {
						List<HashMap<DataItem, ItemInformation>> secondStateNewCombinations = new LinkedList<>();
						// Create copy of new combinations, and add the item with the second state set
						// to it
						for (var entry : newCombinations) {
							HashMap<DataItem, ItemInformation> newMap = new HashMap<>();
							for (var itemEntry : entry.entrySet()) {
								newMap.put(itemEntry.getKey(), itemEntry.getValue().cloneShallow());
							}
							newMap.put(item, combinationTwo.get(item));
							secondStateNewCombinations.add(newMap);
						}
						// Add the item with the first state set to the new combinations
						for (var entry : newCombinations) {
							entry.put(item, combinationOne.get(item));
						}

						// Add the secondStateNewCombinations to newCombinations
						newCombinations.addAll(secondStateNewCombinations);
					}

					// Remove old and add new
					result.remove(combinationOne);
					result.remove(combinationTwo);
					result.addAll(newCombinations);

					stateChanged = true;
					break;

				}

				if (stateChanged)
					break;
			}
		}

		return result;
	}

	/**
	 * Groups the passed vertices by their functionalities
	 * 
	 * @param vertices The vertices to group
	 * @return The grouped vertices
	 */
	public static HashMap<HashSet<FunctionalityLabel>, ArrayList<AbstractVertex<?>>> groupByFunctionalities(
			List<AbstractVertex<?>> vertices) {
		HashMap<HashSet<FunctionalityLabel>, ArrayList<AbstractVertex<?>>> result = new HashMap<>();
		for (var vertex : vertices) {
			var labels = new HashSet<FunctionalityLabel>(
					extractFunctionalityLabels(vertex.getAllVertexCharacteristics()));
			result.computeIfAbsent(labels, k -> new ArrayList<>());

			result.get(labels).add(vertex);
		}

		return result;
	}

	/**
	 * Verifies that all data item tuples are allowed by the functionalities
	 * 
	 * @param combinationTuples   The combination tuples as received or derived by
	 *                            the node
	 * @param nodeFunctionalities The functionalities options of the node
	 * @return
	 */
	public static List<AbstractPrivacyConstraintViolation> verifyDataTupleConformance(
			List<HashMap<DataItem, ItemInformation>> combinationTuples, List<Functionality> nodeFunctionalities,
			String vertexName) {
		List<AbstractPrivacyConstraintViolation> detectedViolations = new LinkedList<>();

		for (var combination : combinationTuples) {
			if (!combinationAllowedByFunctionalities(combination, nodeFunctionalities)) {
				detectedViolations.add(new NodeCombinationPrivacyConstraintViolation(vertexName,
						"The vertex/node \"" + vertexName
								+ "\" could derive information not authorized by any of its functionalities."
								+ "\n\tDetected combination: " + itemInformationToString(combination)
								+ "\n\tVertex functionalities: "
								+ nodeFunctionalities.stream().map(co -> functionalityToString(co)).toList(),
						combination, nodeFunctionalities));
			}
		}
		return detectedViolations;
	}

	/**
	 * Converts a data combination to a human-readable format
	 */
	public static String itemInformationToString(HashMap<DataItem, ItemInformation> input) {
		return input.entrySet().stream()
				.map(entry -> entry.getKey().getEntityName() + ": {state: {"
						+ entry.getValue().state.stream().map(state -> state.getEntityName()).toList() + "}, context: {"
						+ entry.getValue().context.stream()
								.map(contl -> contl.stream().map(cont -> cont.getEntityName()).toList()).toList()
						+ "}}")
				.toList().toString();
	}

	/**
	 * Converts a functionality to a human-readable form
	 */
	public static String functionalityToString(Functionality input) {
		return "\n\t" + input.getEntityName() + ". Allows for: " + input.getAllowsFor().stream().map(af -> "\n\t\t"
				+ af.getEntityName() + ":"
				+ af.getMembers().stream().map(member -> member.getItem().getEntityName() + ": {state: {"
						+ member.getState().stream().map(state -> state.getEntityName()).toList() + "}, context: {"
						+ member.getContext().stream().map(contl -> contl.getEntityName()).toList() + "}}").toList())
				.toList();
	}
}

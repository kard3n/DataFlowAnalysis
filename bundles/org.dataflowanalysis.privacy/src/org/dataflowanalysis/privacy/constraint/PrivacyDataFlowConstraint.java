package org.dataflowanalysis.privacy.constraint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.dataflowanalysis.analysis.core.DataCharacteristic;
import org.dataflowanalysis.analysis.core.FlowGraphCollection;
import org.dataflowanalysis.analysis.dfd.core.DFDCharacteristicValue;
import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.dfd.dataflowdiagram.Node;
import org.dataflowanalysis.privacy.consentmodel.ConsentLabel;
import org.dataflowanalysis.privacy.consentmodel.ConsentOption;
import org.dataflowanalysis.privacy.consentmodel.DataItem;
import org.dataflowanalysis.privacy.consentmodel.DataItemLabel;
import org.dataflowanalysis.privacy.consentmodel.DataState;
import org.dataflowanalysis.privacy.consentmodel.DataStateLabel;
import org.dataflowanalysis.privacy.consentmodel.UserDataCombination;

public class PrivacyDataFlowConstraint {
	private static final Logger logger = LoggerManager.getLogger(PrivacyDataFlowConstraint.class);

	public static HashSet<PrivacyConstraintViolation> findViolations(FlowGraphCollection flowGraphs,
			boolean checkNodeLevelInference) {
		return findViolations(flowGraphs.getTransposeFlowGraphs(), checkNodeLevelInference);
	}

	public static HashSet<PrivacyConstraintViolation> findViolations(
			List<? extends AbstractTransposeFlowGraph> flowGraphs, boolean checkNodeLevelInference) {
		HashSet<PrivacyConstraintViolation> violations = new HashSet<>();

		// # Step 1: determine all vertices (by their ID) of the flow graphs
		// Map ID of the vertex (ID of the referenced element), with the versions that
		// exist in the flowgraphs
		HashMap<String, LinkedList<AbstractVertex>> vertexInstances = computeVertices(flowGraphs);

		// Step two: calculate worst-case scenarios for every pin
		for (var entry : vertexInstances.entrySet()) { // go over vertices
			// group CharacteristicValue lists by pin (DataCharacteristic.variableName)
			DFDVertex vert = null;
			HashMap<String, HashSet<HashSet<CharacteristicValue>>> pinToCharacteristics = new HashMap<>();
			for (var vertBase : entry.getValue()) {
				// Go through the instances of the vertex from every TFG, and add the grouped
				// information of their pins
				if (vert == null)
					vert = (DFDVertex) vertBase;
				var newCharacteristicsPerPin = groupIncomingCharacteristicsByPin(
						((DFDVertex) vertBase).getAllIncomingDataCharacteristics());
				for (var newCharacteristics : newCharacteristicsPerPin.entrySet()) {
					pinToCharacteristics.computeIfAbsent(newCharacteristics.getKey(),
							k -> new HashSet<HashSet<CharacteristicValue>>());
					for (var newChar : newCharacteristics.getValue()) {
						pinToCharacteristics.get(newCharacteristics.getKey()).add(newChar);
					}

				}
			}

			// Get all consent options
			List<ConsentOption> consentOptions = extractConsentLabels(vert.getAllVertexCharacteristics()).stream()
					.map(label -> label.getConsentOption()).toList();

			// List of all combinations from the pins
			List<HashMap<DataItem, Set<DataState>>> nodeLevelCombinations = new LinkedList<>();

			// Evaluate every pin by itself: check that only data from users who have
			// consented to this node's functionalities reached this pin,
			// and that the data combinations are allowed as part of this node's
			// functionalities
			for (var pin : pinToCharacteristics.entrySet()) {
				// Go through the lists of CharacteristicValues, and check that all
				// functionalities of the node (in form of ConsentOptions)
				// are present in it -> check that the user has consented to all functionalities
				// of this node
				violations.addAll(allFunctionalitiesConsentedTo(pin.getValue(), vert.getAllVertexCharacteristics(),
						vert.getName()));

				// Create worst-case scenarios for this pin by creating the smallest subset of
				// DataStates possible for each data item, using the following rule:
				// Two DataState sets can be combined to their intersection, if their
				// intersection is not empty.
				// If two sets contain DataStates that can not be related to each other, those
				// sets can not be unified
				var dataItemToDataState = groupDataStateByItem(pin.getValue());
				dataItemToDataState.keySet().forEach(pinName -> {
					dataItemToDataState.put(pinName, reduceDataStateSets(dataItemToDataState.get(pinName)));
				});

				var possibleCombinations = calculateItemToDataStateCombinations(dataItemToDataState);
				nodeLevelCombinations.addAll(possibleCombinations);
				// Check that each of the possible combination is allowed
				for (var combination : possibleCombinations) {
					if (!combinationAllowedByConsentOptions(combination, consentOptions)) {
						violations.add(new PrivacyConstraintViolation(vert.getName(), "The vertex " + vert.getName()
								+ " has received a data combination in pin " + pin.getKey()
								+ " or could infere one not allowed for any of its consent options/functionalities.\nReceived combination: "
								+ dataCombinatioToString(combination) + "\nConsent options of the vertex: "
								+ consentOptions.stream().map(co -> consentOptionToString(co)).toList()));
					}
				}

			}

			// Evaluate inference at the node level
			if (checkNodeLevelInference) {
				violations.addAll(verifyDataTupleConformance(uniteItemTuples(nodeLevelCombinations), consentOptions,
						vert.getName()));
			}
		}

		return violations;
	}

	/**
	 * Groups the vertex instances of every TFG by their ID
	 * 
	 * @param tfgs The list of TFGs whose vertices to group
	 * @return A Map, which for every vertex ID contains a list of vertex instances
	 *         with that same ID
	 */
	private static HashMap<String, LinkedList<AbstractVertex>> computeVertices(
			List<? extends AbstractTransposeFlowGraph> tfgs) {
		HashMap<String, LinkedList<AbstractVertex>> vertexInstances = new HashMap<>();
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
	 * @param vertex The vertex whose CharacteristicValues to group
	 * @return A HashMap whose key is the ID of a pin, and the value the set of
	 *         different lists of CharacteristicValues that can reach said pin
	 */
	public static HashMap<String, HashSet<HashSet<CharacteristicValue>>> groupIncomingCharacteristicsByPin(
			List<DataCharacteristic> incomingCharacteristics) {
		HashMap<String, HashSet<HashSet<CharacteristicValue>>> pinToIncomingCharacteristics = new HashMap<>();
		incomingCharacteristics.forEach(incoming -> {
			pinToIncomingCharacteristics.computeIfAbsent(incoming.getVariableName(), k -> new HashSet<>())
					.add(new HashSet<CharacteristicValue>(incoming.getAllCharacteristics()));
		});

		return pinToIncomingCharacteristics;
	}

	/**
	 * Given a list of a pin's incoming characteristics, checks that the passed
	 * Node's consent options are included for each of the incoming items.
	 * 
	 * @param pinIncomingCharacteristics The incoming characteristics of a pin
	 * @param vertexCharacteristics      The characteristics of the vertex
	 * @param vertex                     The name of the vertex (for including it in
	 *                                   the violations)
	 * @return A list of all violations found
	 */
	public static HashSet<PrivacyConstraintViolation> allFunctionalitiesConsentedTo(
			HashSet<HashSet<CharacteristicValue>> pinIncomingCharacteristics,
			List<CharacteristicValue> vertexCharacteristics, String vertexName) {
		HashSet<PrivacyConstraintViolation> violations = new HashSet<>();
		List<ConsentLabel> vertexFunctionalities = extractConsentLabels(vertexCharacteristics);
		for (var incoming : pinIncomingCharacteristics) {
			// Check that the incoming labels contain at least one data item
			if(incoming.stream().filter(i -> ((DFDCharacteristicValue)i).getLabel() instanceof DataItemLabel ).count() == 0) {
				continue;
			}
			
			if (!extractConsentLabels(incoming).containsAll(vertexFunctionalities)) {
				// TODO: maybe include more information such as role, ...
				violations.add(new PrivacyConstraintViolation(vertexName, "The vertex " + vertexName
						+ " can receive data from a user which has not consented to its functionalities. \nFunctionalities consented to by user: "
						+ extractConsentLabels(incoming).stream().map(label -> label.getConsentOption().getEntityName())
								.toList()
						+ "\nFunctionalities of the vertex: "
						+ vertexFunctionalities.stream().map(label -> label.getConsentOption().getEntityName()).toList()
						+ "\nReceived input labels: " + incoming.stream().map(i -> i.toString()).toList()));
			}
		}

		return violations;
	}

	/**
	 * Returns all ConsentLabels of the passed list
	 * 
	 * @param labels List of characteristicValues
	 * @return The labels of type ConsentLabel part of a CharacteristicValue of the
	 *         passed list
	 */
	private static List<ConsentLabel> extractConsentLabels(Collection<CharacteristicValue> labels) {
		return labels.stream().map(cv -> ((DFDCharacteristicValue) cv)).filter(cv -> {
			return cv.getLabel() instanceof ConsentLabel;
		}).map(cv -> ((ConsentLabel) cv.getLabel())).toList();
	}

	/**
	 * Taking a set of sets of CharacteristicValues, extracts the data items for
	 * each, and associates them with that set's DataStates.
	 * 
	 * @param values
	 * @return
	 */
	private static HashMap<DataItem, List<Set<DataState>>> groupDataStateByItem(
			HashSet<HashSet<CharacteristicValue>> values) {
		HashMap<DataItem, List<Set<DataState>>> itemToStates = new HashMap<>();
		for (var characSet : values) {
			var dataStates = extractDataStates(characSet);
			var dataItems = extractDataItems(characSet);

			dataItems.forEach(item -> {
				itemToStates.computeIfAbsent(item, k -> new LinkedList<>()).add(new HashSet<>(dataStates));
			});
		}

		return itemToStates;
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
	 * Constructs the largest possible sets of the given data states by creating
	 * their intersection. If two sets contain a DataState that can not be
	 * associated to a DataState of the other set, the intersection of those two
	 * sets can not be created in that iteration as their data can not be related
	 * 
	 * @param states
	 * @return
	 */
	public static List<Set<DataState>> reduceDataStateSets(List<Set<DataState>> states) {
		// If less than two, we can't do intersections
		if (states.size() < 2)
			return states.stream().map(i -> ((Set<DataState>) new HashSet<>(i))).toList();

		List<Set<DataState>> reducedState = new LinkedList<>();
		states.forEach(stateList -> {
			reducedState.add(new HashSet<>(stateList));
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

				var stateList = reducedState.get(i);
				for (var otherStateList : reducedState) {
					if (stateList == otherStateList)
						continue;
					if (stateSetsCanBeIntersected(stateList, otherStateList)) {
						var intersection = new HashSet<>(stateList);
						intersection.retainAll(otherStateList);
						reducedState.remove(stateList);
						reducedState.remove(otherStateList);
						// Add to the beginning. This set is reduced and therewith more likely to be
						// able to intersect with other entries
						reducedState.add(0, intersection);
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
	 * Iteratively computes all possible combinations of Map<DataItem,
	 * Set<DataState>> for the input
	 * 
	 * @param input A map linking DataItems to their possible DataStates.
	 * @return A List<HashMap<DataItem, Set<DataState>>>, created recursively
	 */
	public static List<HashMap<DataItem, Set<DataState>>> calculateItemToDataStateCombinations(
			HashMap<DataItem, List<Set<DataState>>> input) {
		return calculateItemToDataStateCombinations(input, new HashMap<>());
	}

	/**
	 * Iteratively computes all possible combinations of Map<DataItem,
	 * Set<DataState>> for the input
	 * 
	 * @param input          A map linking DataItems to their possible DataStates.
	 *                       Should only include DataItems which have not yet been
	 *                       added to the startingResult
	 * @param startingResult The intermediary result from the previous iteration
	 * @return A List<HashMap<DataItem, Set<DataState>>>, created recursively
	 */
	public static List<HashMap<DataItem, Set<DataState>>> calculateItemToDataStateCombinations(
			HashMap<DataItem, List<Set<DataState>>> input, HashMap<DataItem, Set<DataState>> startingResult) {
		List<HashMap<DataItem, Set<DataState>>> result = new ArrayList<>();

		for (var entry : input.entrySet()) {
			if (entry.getValue().size() == 0) {
				startingResult.put(entry.getKey(), new HashSet<>());
			} else if (entry.getValue().size() == 1) {
				startingResult.put(entry.getKey(), entry.getValue().get(0));
			} else {
				// more than one element
				for (int i = 0; i < entry.getValue().size(); i++) {
					@SuppressWarnings("unchecked")
					var newIn = (HashMap<DataItem, List<Set<DataState>>>) input.clone();
					newIn.remove(entry.getKey()); // Remove current entry. It has been treated by us, should not be
													// passed to the next list
					@SuppressWarnings("unchecked")
					var newStarting = (HashMap<DataItem, Set<DataState>>) startingResult.clone();
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
	 * consentOptions
	 * 
	 * @param dataCombination    The combination that should be checked for
	 *                           compatibility
	 * @param nodeConsentOptions The consent options, with which the combination
	 *                           should be compatible with
	 * @return True is the combination is allowed by the consent options
	 */
	public static boolean combinationAllowedByConsentOptions(HashMap<DataItem, Set<DataState>> dataCombination,
			List<ConsentOption> nodeConsentOptions) {
		var consentOptionCopy = (List<ConsentOption>) new LinkedList<>(nodeConsentOptions);

		// Filter all consent options, removing those that don't have a data combination
		// that allows for all items of the received data combinations
		consentOptionCopy = consentOptionCopy.stream().filter(co -> {
			// Check that the CO has at least one permitted data combination that is
			// compatible with the received one
			return co.getAllowsFor().stream().filter(udc -> {
				for (var receivedItem : dataCombination.entrySet()) {
					if (!combinationAllowsItem(udc, receivedItem.getKey(), receivedItem.getValue()))
						return false;
				}
				return true;
			}).count() > 0;
		}).toList();

		return !consentOptionCopy.isEmpty();
	}

	/**
	 * Checks that the passed data item is compatible with the data combination.
	 * This means that it itself must included in the combination, and that the
	 * combinations list of state for the item must be a sublist of the item's
	 * states
	 * 
	 * @param combination A data combination of the consent model
	 * @param item        The item to check for
	 * @param itemState   The state the item has
	 * @return
	 */
	public static boolean combinationAllowsItem(UserDataCombination combination, DataItem item,
			Set<DataState> itemState) {
		var combinationMembersOfItem = combination.getMembers().stream().filter(member -> member.getItem().equals(item))
				.toList();
		if (combinationMembersOfItem.size() == 0)
			return false;
		for (var member : combinationMembersOfItem) {
			if (itemState.containsAll(member.getState()))
				return true;
		}
		return false;
	}

	/**
	 * Given the combinations, creates the biggest sets possible by checking for
	 * inference through overlaps
	 * 
	 * @param combinations The input sets
	 * @return The expanded sets
	 */
	public static List<HashMap<DataItem, Set<DataState>>> uniteItemTuples(
			List<HashMap<DataItem, Set<DataState>>> inputCombinations) {
		List<HashMap<DataItem, Set<DataState>>> result = new ArrayList<>(inputCombinations);

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
					List<DataItem> nonRelatable = intersection.stream().filter(
							item -> !stateSetsCanBeIntersected(combinationOne.get(item), combinationTwo.get(item)))
							.toList();

					// If all items of the intersection are unrelatable: cannot do intersection
					// (inference)
					if (intersection.size() == nonRelatable.size())
						continue;

					// Create a new base combination, including all items that were both not in the
					// intersection and are unrelatable
					HashMap<DataItem, Set<DataState>> baseNewCombination = new HashMap<>();
					for (var item : combinationOne.entrySet()) {
						if (!nonRelatable.contains(item.getKey()))
							baseNewCombination.put(item.getKey(), new HashSet<>(item.getValue()));
					}

					boolean stateWasReduced = false;
					for (var item : combinationTwo.entrySet()) {
						if (!nonRelatable.contains(item.getKey())) {
							if (!baseNewCombination.containsKey(item.getKey())) {
								baseNewCombination.put(item.getKey(), new HashSet<>(item.getValue()));
							} else {
								if (baseNewCombination.get(item.getKey()).retainAll(item.getValue())) {
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

					List<HashMap<DataItem, Set<DataState>>> newCombinations = new LinkedList<>();
					newCombinations.add(baseNewCombination);

					// Add non-relatable entries of the intersection to the new combinations
					// For each one, duplicate the old set: one for item one, and one for item two
					for (var item : nonRelatable) {
						List<HashMap<DataItem, Set<DataState>>> secondStateNewCombinations = new LinkedList<>();
						// Create copy of new combinations, and add the item with the second state set
						// to it
						for (var entry : newCombinations) {
							HashMap<DataItem, Set<DataState>> newMap = new HashMap<>();
							for (var itemEntry : entry.entrySet()) {
								newMap.put(itemEntry.getKey(), new HashSet<DataState>(itemEntry.getValue()));
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
	 * Verifies that all data item tuples are allowed by the consent options
	 * 
	 * @param combinationTuples  The combination tuples as received or derived by
	 *                           the node
	 * @param nodeConsentOptions The consent options of the node
	 * @return
	 */
	public static List<PrivacyConstraintViolation> verifyDataTupleConformance(
			List<HashMap<DataItem, Set<DataState>>> combinationTuples, List<ConsentOption> nodeConsentOptions,
			String vertexName) {
		List<PrivacyConstraintViolation> detectedViolations = new LinkedList<>();

		for (var combination : combinationTuples) {
			if (!combinationAllowedByConsentOptions(combination, nodeConsentOptions)) {
				detectedViolations.add(new PrivacyConstraintViolation(vertexName,
						"The vertex/node \"" + vertexName
								+ "\" received or could derive information not authorized by its consent options."
								+ "\n\tDetected combination: " + dataCombinatioToString(combination)
								+ "\n\tVertex consent options: "
								+ nodeConsentOptions.stream().map(co -> consentOptionToString(co)).toList()));
			}
		}
		return detectedViolations;
	}

	/**
	 * Converts a data combination to a human-readable format
	 */
	public static String dataCombinatioToString(HashMap<DataItem, Set<DataState>> input) {
		return input.entrySet().stream().map(entry -> entry.getKey().getEntityName() + ":"
				+ entry.getValue().stream().map(state -> state.getEntityName()).toList()).toList().toString();
	}

	/**
	 * Converts a consent option to a human-readable form
	 */
	public static String consentOptionToString(ConsentOption input) {
		return "\n"
				+ input.getEntityName() + ":\n\tAllowsFor: " + input
						.getAllowsFor().stream().map(
								af -> af.getEntityName()
										+ ":" + af
												.getMembers().stream().map(
														member -> member.getItem().getEntityName() + ":"
																+ member.getState().stream()
																		.map(state -> state.getEntityName()).toList())
												.toList())
						.toList();
	}
}

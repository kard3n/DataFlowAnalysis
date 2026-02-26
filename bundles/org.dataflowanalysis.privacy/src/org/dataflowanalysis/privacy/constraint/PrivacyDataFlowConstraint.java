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
import org.dataflowanalysis.analysis.core.FlowGraphCollection;
import org.dataflowanalysis.analysis.dfd.core.DFDCharacteristicValue;
import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.dfd.dataflowdiagram.Node;
import org.dataflowanalysis.privacy.consentmodel.ConsentLabel;
import org.dataflowanalysis.privacy.consentmodel.DataItem;
import org.dataflowanalysis.privacy.consentmodel.DataItemLabel;
import org.dataflowanalysis.privacy.consentmodel.DataState;
import org.dataflowanalysis.privacy.consentmodel.DataStateLabel;

public class PrivacyDataFlowConstraint {
	private static final Logger logger = LoggerManager.getLogger(PrivacyDataFlowConstraint.class);

	public static HashSet<PrivacyConstraintViolation> findViolations(FlowGraphCollection flowGraphs) {
		return findViolations(flowGraphs.getTransposeFlowGraphs());
	}

	public static HashSet<PrivacyConstraintViolation> findViolations(
			List<? extends AbstractTransposeFlowGraph> flowGraphs) {
		HashSet<PrivacyConstraintViolation> violations = new HashSet<>();

		// # Step 1: determine all vertices (by their ID) of the flow graphs
		// Map ID of the vertex (ID of the referenced element), with the versions that
		// exist in the flowgraphs
		HashMap<String, LinkedList<AbstractVertex>> vertexInstances = computeVertices(flowGraphs);

		// Step two: calculate worst-case scenarios for every pin
		for (var entry : vertexInstances.entrySet()) { // go over vertices
			// group CharacteristicValue lists by pin (DataCharacteristic.variableName)
			entry.getValue().forEach(vert -> {
				var pinToCharacteristics = groupIncomingCharacteristicsByPin(((DFDVertex) vert));

				// Evaluate every pin by itself: check that only data from users who have
				// consented to this node's functionalities reached this pin,
				// and that the data combinations are allowed as part of this node's
				// functionalities
				for (var pin : pinToCharacteristics.entrySet()) {
					// Go through the lists of CharacteristicValues, and check that all
					// functionalities of the node (in form of ConsentOptions)
					// are present in it -> check that the user has consented to all functionalities
					// of this node
					violations.addAll(allFunctionalitiesConsentedTo(pin.getValue(), ((DFDVertex) vert)));

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
					// Check that every possible combination is allowed
					// TODO

				}

			});
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
	private static HashMap<String, HashSet<HashSet<CharacteristicValue>>> groupIncomingCharacteristicsByPin(
			DFDVertex vertex) {
		HashMap<String, HashSet<HashSet<CharacteristicValue>>> pinToIncomingCharacteristics = new HashMap<>();
		vertex.getAllIncomingDataCharacteristics().forEach(incoming -> {
			pinToIncomingCharacteristics.computeIfAbsent(incoming.getVariableName(), k -> new HashSet<>())
					.add(new HashSet<CharacteristicValue>(incoming.getAllCharacteristics()));
			;
		});

		return pinToIncomingCharacteristics;
	}

	private static HashSet<PrivacyConstraintViolation> allFunctionalitiesConsentedTo(
			HashSet<HashSet<CharacteristicValue>> pinIncomingCharacteristics, DFDVertex vertex) {
		HashSet<PrivacyConstraintViolation> violations = new HashSet<>();
		List<ConsentLabel> vertexFunctionalities = extractConsentLabels(vertex.getAllVertexCharacteristics());
		for (var incoming : pinIncomingCharacteristics) {
			if (!extractConsentLabels(incoming).containsAll(vertexFunctionalities)) {
				// TODO: maybe include more information such as role, ...
				violations.add(new PrivacyConstraintViolation(vertex.getName(),
						"The vertex can receive data from user which have not consented to its functionalities. \nFunctionalities consentet to by user: "
								+ extractConsentLabels(incoming) + "\nFunctionalities of the vertex: "
								+ vertexFunctionalities));
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
				// If the intersection possible, the original sets are removed and the intersection added
				
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
	 * Checks if the intersection of both sets is not empty, and that both sets
	 * don't contain a DataState that is can not related with a DataState of the
	 * other set
	 * 
	 * @param setOne   The first set
	 * @param stateTwo The second set
	 * @return True if the sets may be intersected to create a worse-case set
	 */
	public static boolean stateSetsCanBeIntersected(Set<DataState> setOne, Set<DataState> setTwo) {
		if(setOne.equals(setTwo)) return true; // Quick check: if equal, they can be intersected
		
		var intersection = new HashSet<>(setOne);
		intersection.retainAll(setTwo);
		if (intersection.size() < 1)
			return false;

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
}
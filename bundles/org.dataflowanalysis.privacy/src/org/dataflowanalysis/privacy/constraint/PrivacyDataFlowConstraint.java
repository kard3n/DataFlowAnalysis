package org.dataflowanalysis.privacy.constraint;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.core.AbstractVertex;
import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.dataflowanalysis.analysis.core.FlowGraphCollection;
import org.dataflowanalysis.analysis.dfd.core.DFDCharacteristicValue;
import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.dataflowanalysis.dfd.dataflowdiagram.Node;
import org.dataflowanalysis.privacy.consentmodel.ConsentLabel;
import org.dataflowanalysis.privacy.consentmodel.DataItem;
import org.dataflowanalysis.privacy.consentmodel.DataState;

public class PrivacyDataFlowConstraint {
	public HashSet<PrivacyConstraintViolation> findViolations(FlowGraphCollection flowGraphs){
		HashSet<PrivacyConstraintViolation> violations = new HashSet<>();
		
		//# Step 1: determine all vertices (by their ID) of the flow graphs
		// Map ID of the vertex (ID of the referenced element), with the versions that exist in the flowgraphs
		HashMap<String, LinkedList<AbstractVertex>> vertexInstances = this.computeVertices(flowGraphs.getTransposeFlowGraphs());
		
		// Step two: calculate worst-case scenarios for every pin
		for(var entry: vertexInstances.entrySet()) { // go over vertices
			// group CharacteristicValue lists by pin (DataCharacteristic.variableName)
			entry.getValue().forEach(vert -> {
				var pinToCharacteristics = this.groupIncomingCharacteristicsByPin(((DFDVertex)vert));
				
				// Evaluate every pin by itself: check that only data from users who have consented to this node's functionalities reached this pin,
				// and that the data combinations are allowed as part of this node's functionalities
				for(var pin: pinToCharacteristics.entrySet()) {
					// Go through the lists of CharacteristicValues, and check that all functionalities of the node (in form of ConsentOptions)
					// are present in it -> check that the user has consented to all functionalities of this node
					violations.addAll(this.allFunctionalitiesConsentedTo(pin.getValue(), ((DFDVertex)vert)));
					
					// Create worst-case scenarios for this pin by creating the smallest subset of DataStates possible for each data item, using the following rule:
					// Two DataState sets can be combined to their intersection, if their intersection is not empty.
					// If two sets contain DataStates that can not be related to each other, those sets can not be unified
					var dataItemToDataState = this.groupDataStateByItem(pin.getValue());
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
	private HashMap<String, LinkedList<AbstractVertex>> computeVertices(
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
	private HashMap<String, HashSet<HashSet<CharacteristicValue>>> groupIncomingCharacteristicsByPin(DFDVertex vertex) {
		HashMap<String, HashSet<HashSet<CharacteristicValue>>> pinToIncomingCharacteristics = new HashMap<>();
		vertex.getAllIncomingDataCharacteristics().forEach(incoming -> {
			pinToIncomingCharacteristics.computeIfAbsent(incoming.getVariableName(), k -> new HashSet<>())
					.add(new HashSet<CharacteristicValue>(incoming.getAllCharacteristics()));
			;
		});

		return pinToIncomingCharacteristics;
	}

	private HashSet<PrivacyConstraintViolation> allFunctionalitiesConsentedTo(
			HashSet<HashSet<CharacteristicValue>> pinIncomingCharacteristics, DFDVertex vertex) {
		HashSet<PrivacyConstraintViolation> violations = new HashSet<>();
		List<ConsentLabel> vertexFunctionalities = this.extractConsentLabels(vertex.getAllVertexCharacteristics());
		for (var incoming : pinIncomingCharacteristics) {
			if (!this.extractConsentLabels(incoming).containsAll(vertexFunctionalities)) {
				// TODO: maybe include more information such as role, ...
				violations.add(new PrivacyConstraintViolation(vertex.getName(),
						"The vertex can receive data from user which have not consented to its functionalities. \nFunctionalities consentet to by user: "
								+ this.extractConsentLabels(incoming) + "\nFunctionalities of the vertex: "
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
	private List<ConsentLabel> extractConsentLabels(Collection<CharacteristicValue> labels) {
		return labels.stream().map(cv -> ((DFDCharacteristicValue) cv)).filter(cv -> {
			return cv.getLabel() instanceof ConsentLabel;
		}).map(cv -> ((ConsentLabel) cv.getLabel())).toList();
	}
	
	/**
	 * Taking a set of sets of CharacteristicValues, extracts the data items for each, and associates them with that sets DataStates
	 * @param values
	 * @return
	 */
	private HashMap<DataItem, HashSet<DataState>> groupDataStateByItem(HashSet<HashSet<CharacteristicValue>> values){
		HashMap<DataItem, HashSet<DataState>> itemToStates = new HashMap<>();
		
		return itemToStates;
	}
}

/*
 * List<PrivacyConstraintViolation> result = new LinkedList<>();
 * flowGraphs.getTransposeFlowGraphs().forEach(tfg -> {
 * tfg.getVertices().forEach(vertex -> { // Check that the data is the one
 * permitted for this Vertex. if(vertex instanceof DFDVertex dfdvertex) {
 * 
 * HashMap<String, List<CharacteristicValue>> pinToLabels = new HashMap<>(); //
 * groups Labels by the pin they came from
 * dfdvertex.getAllIncomingDataCharacteristics().forEach(ch -> {
 * pinToLabels.put(ch.getVariableName(), ch.getAllCharacteristics()); }); } });
 * }); return result;
 */
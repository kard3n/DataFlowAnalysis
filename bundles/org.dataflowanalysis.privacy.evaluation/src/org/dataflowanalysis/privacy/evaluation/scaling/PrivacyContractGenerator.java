package org.dataflowanalysis.privacy.evaluation.scaling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.dfd.datadictionary.Behavior;
import org.dataflowanalysis.dfd.datadictionary.Pin;
import org.dataflowanalysis.dfd.datadictionary.SetAssignment;
import org.dataflowanalysis.dfd.datadictionary.datadictionaryFactory;
import org.dataflowanalysis.dfd.dataflowdiagram.Flow;
import org.dataflowanalysis.dfd.dataflowdiagram.Node;
import org.dataflowanalysis.dfd.dataflowdiagram.dataflowdiagramFactory;
import org.dataflowanalysis.privacy.privacymodel.DataItem;
import org.dataflowanalysis.privacy.privacymodel.DataItemLabel;
import org.dataflowanalysis.privacy.privacymodel.DataItemLabelType;
import org.dataflowanalysis.privacy.privacymodel.Functionality;
import org.dataflowanalysis.privacy.privacymodel.Role;
import org.dataflowanalysis.privacy.privacymodel.RoleLabel;
import org.dataflowanalysis.privacy.privacymodel.RoleLabelType;
import org.dataflowanalysis.privacy.privacymodel.privacymodelFactory;

public class PrivacyContractGenerator {
	private static final Logger logger = LoggerManager.getLogger(PrivacyContractGenerator.class);
	public static Random random = new Random(System.currentTimeMillis());
	public static String charPool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	public static PrivacyModelPackage generateUsers(PrivacyModelPackage input, int amount, String sourceNodeName,
			int maxLabelsPerRole) {

		Node source = null;
		for (var node : input.dfd().getNodes()) {
			if (node.getEntityName().equals(sourceNodeName)) {
				source = node;
				break;
			}
		}
		if (source == null) {
			throw new RuntimeException("Could not find the defined source node in the DFD.");
		}

		List<Functionality> consentOptions = input.cm().getFunctionalityLabelType().getLabels().stream()
				.map(it -> it.getFunctionality()).toList();
		if (consentOptions.size() < maxLabelsPerRole) {
			throw new RuntimeException("The consent model must provide at least maxLabelsPerRole consent options.");
		}

		HashMap<Integer, Long> numLabelsToUsers = new HashMap<>();
		for (int i = 0; i <= maxLabelsPerRole; i++) {
			long previousComb = 0;
			for (int x = 0; x <= i; x++) {
				previousComb += combinations(i, x);
			}
			numLabelsToUsers.put(i, previousComb);

			logger.info(i + ":" + numLabelsToUsers.get(i));
		}

		int usersAdded = 0;

		for (int i = maxLabelsPerRole; i >= 0; i--) {
			long numberResultingUsers = numLabelsToUsers.get(i);
			while (numberResultingUsers + usersAdded <= amount) {
				Role newRole = privacymodelFactory.eINSTANCE.createRole();
				newRole.setEntityName(String.valueOf(usersAdded));

				// Add i labels to the role
				for (int coPos = 0; coPos < i; coPos++) {
					newRole.getOptionallyAllows().add(consentOptions.get(coPos));
				}
				RoleLabel newRoleLabel = privacymodelFactory.eINSTANCE.createRoleLabel();
				newRoleLabel.setRole(newRole);
				input.cm().getRoleLabelType().getLabels().add(newRoleLabel);
				source.getProperties().add(newRoleLabel);
				usersAdded += numberResultingUsers;
			}
		}

		return input;
	}

	/**
	 * 
	 * @param input                  The input model
	 * @param sourceNodeName         The name of the node that should be scaled.
	 *                               Each copy sends a different set of data items.
	 * @param numberSourceNodes      How many times the node should be replicated
	 *                               and adapted
	 * @param dataCombinationSize    The number of labels that each source node
	 *                               sends
	 * @param dataCombinationOverlap The number of labels that should overlap
	 *                               between those sent by two nodes. This is
	 *                               pair-wise.
	 * @param replicateDestinationPins If true, duplicates the destination pin for each new flow.
	 * @return The resulting modified models
	 */
	public static PrivacyModelPackage replicateSourceNode(PrivacyModelPackage input, String sourceNodeName,
			int numberSourceNodes, int dataCombinationSize, int dataCombinationOverlap, boolean replicateDestinationPins) {
		var ddFactory = datadictionaryFactory.eINSTANCE;
		var dfdFactory = dataflowdiagramFactory.eINSTANCE;
		var pmFactory = privacymodelFactory.eINSTANCE;
		
		
		if (dataCombinationOverlap*2 > dataCombinationSize) {
			throw new RuntimeException("The requested overlap is bigger than halve the requested combination size.");
		}

		Node source = null;
		for (var node : input.dfd().getNodes()) {
			if (node.getEntityName().equals(sourceNodeName)) {
				source = node;
				break;
			}
		}
		if (source == null) {
			throw new RuntimeException("Could not find the defined source node in the DFD.");
		}

		final Node sourceCopy = source;
		Flow sourceOutFlow = input.dfd().getFlows().stream().filter(flow -> flow.getSourceNode() == sourceCopy)
				.findFirst()
				.orElseThrow(() -> new RuntimeException("The defined source node does not have an outgoing flow."));
		
		if(input.cm().getDataItemLabelType().size() < 1) {
			throw new RuntimeException("No DataItemLabelType detected.");
		}
		DataItemLabelType itemLabelType = input.cm().getDataItemLabelType().get(0);
		
		if(input.cm().getRoleLabelType() == null) {
			throw new RuntimeException("No RoleItemLabelType detected.");
		}
		RoleLabelType  roleLabelType = input.cm().getRoleLabelType();
		
		ArrayList<DataItemLabel> overlap = new ArrayList<>();
		for(int i = 0; i < dataCombinationOverlap; i++) {
			overlap.add(createUniqueDataItemLabel(itemLabelType));
		}
		
		Role defaultRole = pmFactory.createRole();
		defaultRole.setEntityName("defaultRole");
		RoleLabel defaultRoleLabel = pmFactory.createRoleLabel();
		defaultRoleLabel.setEntityName("defaultRoleLabel");
		defaultRoleLabel.setRole(defaultRole);
		roleLabelType.getLabels().add(defaultRoleLabel);
		
		for(int i = 0; i < numberSourceNodes; i++) {
			// Create behavior
			Behavior behavior = ddFactory.createBehavior();
			Pin outPin = ddFactory.createPin();
			behavior.getOutPin().add(outPin);
			SetAssignment assignment = ddFactory.createSetAssignment();
			assignment.setOutputPin(outPin);
			assignment.getOutputLabels().addAll(overlap);
			overlap.clear();
			for(int x = 0; x < dataCombinationOverlap; x++) {
				overlap.add(createUniqueDataItemLabel(itemLabelType));
			}
			assignment.getOutputLabels().addAll(overlap);
			while(assignment.getOutputLabels().size() < dataCombinationSize) {
				assignment.getOutputLabels().add(createUniqueDataItemLabel(itemLabelType));
			}
			
			behavior.getAssignment().add(assignment);
			
			// Create node
			Node newNode = dfdFactory.createExternal();
			newNode.setEntityName("Node_" + 1);
			newNode.setBehavior(behavior);
			newNode.getProperties().add(defaultRoleLabel);
			
			//create flow
			Flow flow = dfdFactory.createFlow();
			flow.setSourceNode(newNode);
			flow.setSourcePin(outPin);
			Node destNode= sourceOutFlow.getDestinationNode();
			flow.setDestinationNode(destNode);
			
			if (replicateDestinationPins) {
				Pin newDestPin = ddFactory.createPin();
				Behavior destBehavior = destNode.getBehavior();
				if (destBehavior == null) {
					destBehavior = ddFactory.createBehavior();
					destNode.setBehavior(destBehavior);
					input.dd().getBehavior().add(destBehavior);
				}
				destBehavior.getInPin().add(newDestPin);
				flow.setDestinationPin(newDestPin);
			} else {
				flow.setDestinationPin(sourceOutFlow.getDestinationPin());
			}
			
			input.dd().getBehavior().add(behavior);
			input.dfd().getFlows().add(flow);
			input.dfd().getNodes().add(newNode);
		}
		
		
		return input;
	}
	
	/**
	 * @param input                  The input model
	 * @param sourceNodeName         The name of the node whose pins should be
	 *                               scaled
	 * @param numberNewPins      How many times new pins should be added
	 * @param dataCombinationSize    The number of labels that each pin outputs
	 * @param dataCombinationOverlap The number of labels that should overlap
	 *                               between those output by two pins. This is
	 *                               pair-wise.
	 * @param replicateDestinationPins If true, duplicates the destination pin for each new flow.
	 * @return The resulting modified models
	 */
	public static PrivacyModelPackage replicatePinInSourceNode(PrivacyModelPackage input, String sourceNodeName,
			int numberNewPins, int dataCombinationSize, int dataCombinationOverlap, boolean replicateDestinationPins) {
		var ddFactory = datadictionaryFactory.eINSTANCE;
		var dfdFactory = dataflowdiagramFactory.eINSTANCE;
		var pmFactory = privacymodelFactory.eINSTANCE;

		if (dataCombinationOverlap * 2 > dataCombinationSize) {
			throw new RuntimeException("The requested overlap is bigger than halve the requested combination size.");
		}

		Node source = null;
		for (var node : input.dfd().getNodes()) {
			if (node.getEntityName().equals(sourceNodeName)) {
				source = node;
				break;
			}
		}
		
		if (source == null) {
			throw new RuntimeException("Could not find the defined source node in the DFD.");
		}

		final Node sourceCopy = source;
		Flow sourceOutFlow = input.dfd().getFlows().stream().filter(flow -> flow.getSourceNode() == sourceCopy)
				.findFirst()
				.orElseThrow(() -> new RuntimeException("The defined source node does not have an outgoing flow."));

		if (input.cm().getDataItemLabelType().size() < 1) {
			throw new RuntimeException("No DataItemLabelType detected.");
		}
		DataItemLabelType itemLabelType = input.cm().getDataItemLabelType().get(0);

		if (input.cm().getRoleLabelType() == null) {
			throw new RuntimeException("No RoleItemLabelType detected.");
		}
		RoleLabelType roleLabelType = input.cm().getRoleLabelType();

		ArrayList<DataItemLabel> overlap = new ArrayList<>();
		for (int i = 0; i < dataCombinationOverlap; i++) {
			overlap.add(createUniqueDataItemLabel(itemLabelType));
		}

		Role defaultRole = pmFactory.createRole();
		defaultRole.setEntityName("defaultRole");
		RoleLabel defaultRoleLabel = pmFactory.createRoleLabel();
		defaultRoleLabel.setEntityName("defaultRoleLabel");
		defaultRoleLabel.setRole(defaultRole);
		roleLabelType.getLabels().add(defaultRoleLabel);
		
		source.getProperties().add(defaultRoleLabel);

		// Retrieve existing behavior from the original source node, or create one if absent
		Behavior behavior = source.getBehavior();
		if (behavior == null) {
			behavior = ddFactory.createBehavior();
			// Ensure the newly created behavior also gets a unique identifier
			behavior.setEntityName("Behavior_" + sourceNodeName);
			behavior.setId("ID_Behavior_" + sourceNodeName);
			
			source.setBehavior(behavior);
			input.dd().getBehavior().add(behavior);
		}

		for (int i = 0; i < numberNewPins; i++) {
			// Create a sequential suffix for unique identification
			int seqNum = i;
			String suffix = "_" + sourceNodeName + "_" + seqNum;

			// Create new pin and add it to the original node's behavior
			Pin outPin = ddFactory.createPin();
			outPin.setEntityName("OutPin" + suffix);
			outPin.setId("ID_OutPin" + suffix);
			behavior.getOutPin().add(outPin);

			// Create assignment behavior for the pin
			SetAssignment assignment = ddFactory.createSetAssignment();
			assignment.setEntityName("Assignment" + suffix);
			assignment.setId("ID_Assignment" + suffix);
			assignment.setOutputPin(outPin);

			assignment.getOutputLabels().addAll(overlap);
			overlap.clear();
			for (int x = 0; x < dataCombinationOverlap; x++) {
				overlap.add(createUniqueDataItemLabel(itemLabelType));
			}
			assignment.getOutputLabels().addAll(overlap);
			while (assignment.getOutputLabels().size() < dataCombinationSize) {
				assignment.getOutputLabels().add(createUniqueDataItemLabel(itemLabelType));
			}
			
			behavior.getAssignment().add(assignment);

			// Create flow from the new pin to the destination
			Flow flow = dfdFactory.createFlow();
			flow.setEntityName("Flow" + suffix);
			flow.setId("ID_Flow" + suffix);
			
			flow.setSourceNode(source);
			flow.setSourcePin(outPin);
			Node destNode = sourceOutFlow.getDestinationNode();
			flow.setDestinationNode(destNode);
			
			if (replicateDestinationPins) {
				Pin newDestPin = ddFactory.createPin();
				newDestPin.setEntityName("InPin_Dest" + suffix);
				newDestPin.setId("ID_InPin_Dest" + suffix);
				
				Behavior destBehavior = destNode.getBehavior();
				if (destBehavior == null) {
					destBehavior = ddFactory.createBehavior();
					destBehavior.setEntityName("Behavior_" + destNode.getEntityName());
					destBehavior.setId("ID_Behavior_" + destNode.getEntityName());
					
					destNode.setBehavior(destBehavior);
					input.dd().getBehavior().add(destBehavior);
				}
				destBehavior.getInPin().add(newDestPin);
				flow.setDestinationPin(newDestPin);
			} else {
				flow.setDestinationPin(sourceOutFlow.getDestinationPin());
			}

			// Add the new flow to the diagram
			input.dfd().getFlows().add(flow);
		}

		return input;
	}

	/**
	 * Calculates how many permutations of size r can be calculated from a set with
	 * n values.
	 * 
	 * @param n Total amount of possible items
	 * @param r Amount of items in each combinations
	 * @return
	 */
	public static long combinations(int n, int r) {
		if (r < 0 || r > n)
			return 0;
		if (r == 0 || r == n)
			return 1;
		if (r > n / 2)
			r = n - r;

		long result = 1;
		for (int i = 1; i <= r; i++) {
			result = result * (n - i + 1) / i;
		}
		return result;
	}
	
	/**
	 * Creates a new unique data item label and associated data item
	 * @return
	 */
	public static DataItemLabel createUniqueDataItemLabel(DataItemLabelType labelType) {
		String name = generateRandomString(10);
		DataItemLabel label = privacymodelFactory.eINSTANCE.createDataItemLabel();
		label.setEntityName(name + "_label");
		DataItem item = privacymodelFactory.eINSTANCE.createDataItem();
		item.setEntityName(name);
		label.setDataItem(item);
		labelType.getLabels().add(label);
		return label;
	}
	
	public static String generateRandomString(int length) {
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charPool.length());
            randomString.append(charPool.charAt(index));
        }
        return randomString.toString();
    }

}

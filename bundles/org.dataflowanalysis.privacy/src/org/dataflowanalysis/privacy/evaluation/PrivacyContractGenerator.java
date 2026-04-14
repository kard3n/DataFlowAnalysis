package org.dataflowanalysis.privacy.evaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.dfd.datadictionary.Behavior;
import org.dataflowanalysis.dfd.datadictionary.DataDictionary;
import org.dataflowanalysis.dfd.datadictionary.SetAssignment;
import org.dataflowanalysis.dfd.datadictionary.datadictionaryFactory;
import org.dataflowanalysis.dfd.dataflowdiagram.DataFlowDiagram;
import org.dataflowanalysis.dfd.dataflowdiagram.Flow;
import org.dataflowanalysis.dfd.dataflowdiagram.Node;
import org.dataflowanalysis.dfd.dataflowdiagram.dataflowdiagramFactory;
import org.dataflowanalysis.privacy.consentmodel.ConsentModel;
import org.dataflowanalysis.privacy.consentmodel.ConsentOption;
import org.dataflowanalysis.privacy.consentmodel.DataItem;
import org.dataflowanalysis.privacy.consentmodel.DataItemLabel;
import org.dataflowanalysis.privacy.consentmodel.DataItemLabelType;
import org.dataflowanalysis.privacy.consentmodel.Role;
import org.dataflowanalysis.privacy.consentmodel.RoleLabel;
import org.dataflowanalysis.privacy.consentmodel.consentmodelFactory;
import org.dataflowanalysis.privacy.test.PrivacyDataFlowConstrainTest;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

public class PrivacyContractGenerator {
	private static final Logger logger = LoggerManager.getLogger(PrivacyDataFlowConstrainTest.class);
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

		List<ConsentOption> consentOptions = input.cm().getConsentLabelType().getLabels().stream()
				.map(it -> it.getConsentOption()).toList();
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
				Role newRole = consentmodelFactory.eINSTANCE.createRole();
				newRole.setEntityName(String.valueOf(usersAdded));

				// Add i labels to the role
				for (int coPos = 0; coPos < i; coPos++) {
					newRole.getAllows().add(consentOptions.get(coPos));
				}
				RoleLabel newRoleLabel = consentmodelFactory.eINSTANCE.createRoleLabel();
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
	 * @return The resulting modified models
	 */
	public static PrivacyModelPackage generateSourceNodes(PrivacyModelPackage input, String sourceNodeName,
			int numberSourceNodes, int dataCombinationSize, int dataCombinationOverlap) {
		var ddFactory = datadictionaryFactory.eINSTANCE;
		var dfdFactory = dataflowdiagramFactory.eINSTANCE;
		
		
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
			new RuntimeException("No DataItemLabelType detected.");
		}
		
		DataItemLabelType labelType = input.cm().getDataItemLabelType().get(0);

		
		ArrayList<DataItemLabel> overlap = new ArrayList<>();
		for(int i = 0; i < dataCombinationOverlap; i++) {
			overlap.add(createUniqueDataItemLabel(labelType));
		}
		
		for(int i = 0; i < numberSourceNodes; i++) {
			// Create behavior
			Behavior behavior = ddFactory.createBehavior();
			behavior.getOutPin().add(sourceOutFlow.getSourcePin());
			SetAssignment assignment = ddFactory.createSetAssignment();
			assignment.setOutputPin(sourceOutFlow.getSourcePin());
			assignment.getOutputLabels().addAll(overlap);
			overlap.clear();
			for(int x = 0; x < dataCombinationOverlap; x++) {
				overlap.add(createUniqueDataItemLabel(labelType));
			}
			assignment.getOutputLabels().addAll(overlap);
			while(assignment.getOutputLabels().size() < dataCombinationSize) {
				assignment.getOutputLabels().add(createUniqueDataItemLabel(labelType));
			}
			
			// Create node
			Node newNode = dfdFactory.createExternal();
			newNode.setEntityName("Node_" + 1);
			newNode.setBehavior(behavior);
			
			//create flow
			Flow flow = dfdFactory.createFlow();
			flow.setDestinationNode(sourceOutFlow.getDestinationNode());
			flow.setDestinationPin(sourceOutFlow.getDestinationPin());
			flow.setSourceNode(newNode);
			flow.setSourcePin(sourceOutFlow.getSourcePin());
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
		DataItemLabel label = consentmodelFactory.eINSTANCE.createDataItemLabel();
		label.setEntityName(name + "_label");
		DataItem item = consentmodelFactory.eINSTANCE.createDataItem();
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

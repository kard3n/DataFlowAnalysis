package org.dataflowanalysis.privacy.evaluation;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.dfd.datadictionary.DataDictionary;
import org.dataflowanalysis.dfd.dataflowdiagram.DataFlowDiagram;
import org.dataflowanalysis.dfd.dataflowdiagram.Node;
import org.dataflowanalysis.privacy.consentmodel.ConsentModel;
import org.dataflowanalysis.privacy.consentmodel.ConsentOption;
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
			for(int x = 0; x <=i; x++) {
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

}

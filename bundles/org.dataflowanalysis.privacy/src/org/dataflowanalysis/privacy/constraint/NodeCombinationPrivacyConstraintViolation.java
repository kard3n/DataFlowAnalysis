package org.dataflowanalysis.privacy.constraint;

import java.util.List;
import java.util.Map;

import org.dataflowanalysis.privacy.constraint.PrivacyDataFlowConstraint.ItemInformation;
import org.dataflowanalysis.privacy.privacymodel.DataItem;
import org.dataflowanalysis.privacy.privacymodel.Functionality;

public class NodeCombinationPrivacyConstraintViolation extends AbstractPrivacyConstraintViolation {
	String pin;
	Map<DataItem, ItemInformation> receivedCombination;
	List<Functionality> nodeFunctionalities;

	public NodeCombinationPrivacyConstraintViolation(String vertexID, String message,
			Map<DataItem, ItemInformation> receivedCombination, List<Functionality> nodeFunctionalities) {
		super(vertexID, message);

		this.receivedCombination = receivedCombination;
		this.nodeFunctionalities = nodeFunctionalities;
	}

	public Map<DataItem, ItemInformation> getReceivedCombination() {
		return receivedCombination;
	}

	public List<Functionality> getNodeFunctionalities() {
		return nodeFunctionalities;
	}

	public String getPin() {
		return pin;
	}
}

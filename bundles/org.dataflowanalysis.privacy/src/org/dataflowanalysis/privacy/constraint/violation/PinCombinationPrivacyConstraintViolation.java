package org.dataflowanalysis.privacy.constraint.violation;

import java.util.List;
import java.util.Map;

import org.dataflowanalysis.privacy.constraint.PrivacyDataFlowConstraint.ItemInformation;
import org.dataflowanalysis.privacy.privacymodel.DataItem;
import org.dataflowanalysis.privacy.privacymodel.Functionality;

public class PinCombinationPrivacyConstraintViolation extends AbstractPrivacyConstraintViolation {
	String pin;
	Map<DataItem, ItemInformation> receivedCombination;
	List<Functionality> nodeFunctionalities;

	public PinCombinationPrivacyConstraintViolation(String vertexID, String message, String pin,
			Map<DataItem, ItemInformation> receivedCombination, List<Functionality> nodeFunctionalities) {
		super(vertexID, message);

		this.pin = pin;
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

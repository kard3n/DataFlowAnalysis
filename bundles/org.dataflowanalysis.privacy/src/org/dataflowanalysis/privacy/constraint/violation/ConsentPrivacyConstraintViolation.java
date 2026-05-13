package org.dataflowanalysis.privacy.constraint.violation;

import java.util.List;

import org.dataflowanalysis.privacy.privacymodel.Functionality;

public class ConsentPrivacyConstraintViolation extends AbstractPrivacyConstraintViolation {
	List<Functionality> consentedFunctionalities;
	List<Functionality> vertexFunctionalities;
	String pin;

	public ConsentPrivacyConstraintViolation(String vertexID, String message, String pin,
			List<Functionality> consentedFunctionalities, List<Functionality> vertexFunctionalities) {
		super(vertexID, message);

		this.consentedFunctionalities = consentedFunctionalities;
		this.vertexFunctionalities = vertexFunctionalities;
		this.pin = pin;
	}

	public List<Functionality> getConsentedFunctionalities() {
		return consentedFunctionalities;
	}

	public List<Functionality> getVertexFunctionalities() {
		return vertexFunctionalities;
	}
	
	public String getPin() {
		return this.pin;
	}

}

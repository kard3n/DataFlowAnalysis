package org.dataflowanalysis.privacy.constraint;

import java.util.List;

import org.dataflowanalysis.privacy.privacymodel.Functionality;

public class ConsentPrivacyConstraintViolation extends PrivacyConstraintViolation {
	List<Functionality> consentedFunctionalities;
	List<Functionality> vertexFunctionalities;

	public ConsentPrivacyConstraintViolation(String vertexID, String message, String pin,
			List<Functionality> consentedFunctionalities, List<Functionality> vertexFunctionalities) {
		super(vertexID, message);

		this.consentedFunctionalities = consentedFunctionalities;
		this.vertexFunctionalities = vertexFunctionalities;
	}

	public List<Functionality> getConsentedFunctionalities() {
		return consentedFunctionalities;
	}

	public List<Functionality> getVertexFunctionalities() {
		return vertexFunctionalities;
	}

}

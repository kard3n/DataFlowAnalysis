package org.dataflowanalysis.privacy.constraint;

public abstract class PrivacyConstraintViolation{
	private String vertexID;
	private String message;
	
	public PrivacyConstraintViolation(String vertexID, String message) {
		this.vertexID = vertexID;
		this.message = message;
	}

	public String getVertexID() {
		return vertexID;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return message;
	}
	
	
};

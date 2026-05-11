package org.dataflowanalysis.privacy.constraint;

public abstract class AbstractPrivacyConstraintViolation{
	private String vertexID;
	private String message;
	
	public AbstractPrivacyConstraintViolation(String vertexID, String message) {
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
	
	@Override
	public final boolean equals(Object other) {
		if (this == other) return true;
		
		if (!(other instanceof AbstractPrivacyConstraintViolation)) return false;
		
		return message.equals(((AbstractPrivacyConstraintViolation) other).message);
	}

	@Override
	public final int hashCode() {
		return message.hashCode();
	}
};

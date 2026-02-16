/**
 */
package org.dataflowanalysis.privacy.consent_model;

import org.dataflowanalysis.dfd.datadictionary.Label;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.RoleLabel#getRole <em>Role</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getRoleLabel()
 * @model
 * @generated
 */
public interface RoleLabel extends Label {
	/**
	 * Returns the value of the '<em><b>Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' reference.
	 * @see #setRole(Role)
	 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getRoleLabel_Role()
	 * @model required="true"
	 * @generated
	 */
	Role getRole();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.consent_model.RoleLabel#getRole <em>Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' reference.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(Role value);

} // RoleLabel

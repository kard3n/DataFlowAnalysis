/**
 */
package org.dataflowanalysis.privacy.privacymodel;

import org.dataflowanalysis.dfd.datadictionary.AbstractLabel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.RoleLabel#getRole <em>Role</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getRoleLabel()
 * @model
 * @generated
 */
public interface RoleLabel extends AbstractLabel {
	/**
	 * Returns the value of the '<em><b>Role</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' containment reference.
	 * @see #setRole(Role)
	 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getRoleLabel_Role()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Role getRole();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.privacymodel.RoleLabel#getRole <em>Role</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' containment reference.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(Role value);

} // RoleLabel

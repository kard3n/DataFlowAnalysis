/**
 */
package org.dataflowanalysis.privacy.consentmodel;

import org.eclipse.emf.common.util.EList;

import tools.mdsd.modelingfoundations.identifier.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.Role#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.Role#getAllows <em>Allows</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getRole()
 * @model
 * @generated
 */
public interface Role extends Entity {
	/**
	 * Returns the value of the '<em><b>Requires</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consentmodel.ConsentOption}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requires</em>' reference list.
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getRole_Requires()
	 * @model
	 * @generated
	 */
	EList<ConsentOption> getRequires();

	/**
	 * Returns the value of the '<em><b>Allows</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consentmodel.ConsentOption}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allows</em>' reference list.
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getRole_Allows()
	 * @model
	 * @generated
	 */
	EList<ConsentOption> getAllows();

} // Role

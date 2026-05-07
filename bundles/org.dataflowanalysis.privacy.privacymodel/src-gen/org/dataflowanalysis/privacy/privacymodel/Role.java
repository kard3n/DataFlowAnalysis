/**
 */
package org.dataflowanalysis.privacy.privacymodel;

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
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.Role#getAlwaysAllows <em>Always Allows</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.Role#getOptionallyAllows <em>Optionally Allows</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getRole()
 * @model
 * @generated
 */
public interface Role extends Entity {
	/**
	 * Returns the value of the '<em><b>Always Allows</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.privacymodel.Functionality}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Always Allows</em>' reference list.
	 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getRole_AlwaysAllows()
	 * @model
	 * @generated
	 */
	EList<Functionality> getAlwaysAllows();

	/**
	 * Returns the value of the '<em><b>Optionally Allows</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.privacymodel.Functionality}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optionally Allows</em>' reference list.
	 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getRole_OptionallyAllows()
	 * @model
	 * @generated
	 */
	EList<Functionality> getOptionallyAllows();

} // Role

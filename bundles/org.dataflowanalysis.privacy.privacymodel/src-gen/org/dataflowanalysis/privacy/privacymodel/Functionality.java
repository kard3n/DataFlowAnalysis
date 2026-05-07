/**
 */
package org.dataflowanalysis.privacy.privacymodel;

import org.eclipse.emf.common.util.EList;

import tools.mdsd.modelingfoundations.identifier.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Functionality</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.Functionality#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.Functionality#getExcludes <em>Excludes</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.Functionality#getAllowsFor <em>Allows For</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getFunctionality()
 * @model
 * @generated
 */
public interface Functionality extends Entity {
	/**
	 * Returns the value of the '<em><b>Requires</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.privacymodel.Functionality}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requires</em>' reference list.
	 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getFunctionality_Requires()
	 * @model
	 * @generated
	 */
	EList<Functionality> getRequires();

	/**
	 * Returns the value of the '<em><b>Excludes</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.privacymodel.Functionality}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Excludes</em>' reference list.
	 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getFunctionality_Excludes()
	 * @model
	 * @generated
	 */
	EList<Functionality> getExcludes();

	/**
	 * Returns the value of the '<em><b>Allows For</b></em>' containment reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.privacymodel.UserDataCombination}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allows For</em>' containment reference list.
	 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getFunctionality_AllowsFor()
	 * @model containment="true"
	 * @generated
	 */
	EList<UserDataCombination> getAllowsFor();

} // Functionality

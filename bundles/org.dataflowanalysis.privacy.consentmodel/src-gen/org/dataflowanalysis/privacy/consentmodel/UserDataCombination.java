/**
 */
package org.dataflowanalysis.privacy.consentmodel;

import org.eclipse.emf.common.util.EList;

import tools.mdsd.modelingfoundations.identifier.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Data Combination</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.UserDataCombination#getMembers <em>Members</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getUserDataCombination()
 * @model
 * @generated
 */
public interface UserDataCombination extends Entity {
	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consentmodel.StatefulItem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getUserDataCombination_Members()
	 * @model containment="true"
	 * @generated
	 */
	EList<StatefulItem> getMembers();

} // UserDataCombination

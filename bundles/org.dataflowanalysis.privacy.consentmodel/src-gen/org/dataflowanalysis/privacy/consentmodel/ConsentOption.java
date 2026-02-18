/**
 */
package org.dataflowanalysis.privacy.consentmodel;

import org.eclipse.emf.common.util.EList;

import tools.mdsd.modelingfoundations.identifier.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Consent Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.ConsentOption#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.ConsentOption#getExcludes <em>Excludes</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.ConsentOption#getName <em>Name</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.ConsentOption#getAllowsFor <em>Allows For</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getConsentOption()
 * @model
 * @generated
 */
public interface ConsentOption extends Entity {
	/**
	 * Returns the value of the '<em><b>Requires</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consentmodel.ConsentOption}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requires</em>' reference list.
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getConsentOption_Requires()
	 * @model
	 * @generated
	 */
	EList<ConsentOption> getRequires();

	/**
	 * Returns the value of the '<em><b>Excludes</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consentmodel.ConsentOption}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Excludes</em>' reference list.
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getConsentOption_Excludes()
	 * @model
	 * @generated
	 */
	EList<ConsentOption> getExcludes();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getConsentOption_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.consentmodel.ConsentOption#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Allows For</b></em>' containment reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consentmodel.UserDataCombination}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allows For</em>' containment reference list.
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getConsentOption_AllowsFor()
	 * @model containment="true"
	 * @generated
	 */
	EList<UserDataCombination> getAllowsFor();

} // ConsentOption

/**
 */
package org.dataflowanalysis.privacy.consent_model;

import identifier.Entity;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Consented Functionality</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.ConsentedFunctionality#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.ConsentedFunctionality#getExcludes <em>Excludes</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.ConsentedFunctionality#getAllowsFor <em>Allows For</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getConsentedFunctionality()
 * @model
 * @generated
 */
public interface ConsentedFunctionality extends Entity {
	/**
	 * Returns the value of the '<em><b>Requires</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consent_model.ConsentedFunctionality}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requires</em>' reference list.
	 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getConsentedFunctionality_Requires()
	 * @model
	 * @generated
	 */
	EList<ConsentedFunctionality> getRequires();

	/**
	 * Returns the value of the '<em><b>Excludes</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consent_model.ConsentedFunctionality}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Excludes</em>' reference list.
	 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getConsentedFunctionality_Excludes()
	 * @model
	 * @generated
	 */
	EList<ConsentedFunctionality> getExcludes();

	/**
	 * Returns the value of the '<em><b>Allows For</b></em>' containment reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consent_model.UserDataCombination}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allows For</em>' containment reference list.
	 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getConsentedFunctionality_AllowsFor()
	 * @model containment="true"
	 * @generated
	 */
	EList<UserDataCombination> getAllowsFor();

} // ConsentedFunctionality

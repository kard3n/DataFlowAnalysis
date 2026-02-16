/**
 */
package org.dataflowanalysis.privacy.consent_model;

import org.dataflowanalysis.dfd.datadictionary.Label;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Consent Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.ConsentLabel#getConsentedFunctionality <em>Consented Functionality</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getConsentLabel()
 * @model
 * @generated
 */
public interface ConsentLabel extends Label {
	/**
	 * Returns the value of the '<em><b>Consented Functionality</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consented Functionality</em>' reference.
	 * @see #setConsentedFunctionality(ConsentedFunctionality)
	 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getConsentLabel_ConsentedFunctionality()
	 * @model required="true"
	 * @generated
	 */
	ConsentedFunctionality getConsentedFunctionality();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.consent_model.ConsentLabel#getConsentedFunctionality <em>Consented Functionality</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consented Functionality</em>' reference.
	 * @see #getConsentedFunctionality()
	 * @generated
	 */
	void setConsentedFunctionality(ConsentedFunctionality value);

} // ConsentLabel

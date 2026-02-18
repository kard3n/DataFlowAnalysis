/**
 */
package org.dataflowanalysis.privacy.consentmodel;

import org.dataflowanalysis.dfd.datadictionary.AbstractLabel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Consent Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.ConsentLabel#getConsentOption <em>Consent Option</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getConsentLabel()
 * @model
 * @generated
 */
public interface ConsentLabel extends AbstractLabel {
	/**
	 * Returns the value of the '<em><b>Consent Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consent Option</em>' containment reference.
	 * @see #setConsentOption(ConsentOption)
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getConsentLabel_ConsentOption()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ConsentOption getConsentOption();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.consentmodel.ConsentLabel#getConsentOption <em>Consent Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consent Option</em>' containment reference.
	 * @see #getConsentOption()
	 * @generated
	 */
	void setConsentOption(ConsentOption value);

} // ConsentLabel

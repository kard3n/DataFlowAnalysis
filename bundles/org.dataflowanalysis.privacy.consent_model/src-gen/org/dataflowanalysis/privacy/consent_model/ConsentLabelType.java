/**
 */
package org.dataflowanalysis.privacy.consent_model;

import org.dataflowanalysis.dfd.datadictionary.LabelType;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Consent Label Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.ConsentLabelType#getLabels <em>Labels</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getConsentLabelType()
 * @model
 * @generated
 */
public interface ConsentLabelType extends LabelType {
	/**
	 * Returns the value of the '<em><b>Labels</b></em>' containment reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consent_model.ConsentLabel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Labels</em>' containment reference list.
	 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getConsentLabelType_Labels()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ConsentLabel> getLabels();

} // ConsentLabelType

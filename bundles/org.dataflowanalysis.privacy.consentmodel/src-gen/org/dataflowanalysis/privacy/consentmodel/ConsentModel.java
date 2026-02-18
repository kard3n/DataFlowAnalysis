/**
 */
package org.dataflowanalysis.privacy.consentmodel;

import org.eclipse.emf.common.util.EList;

import tools.mdsd.modelingfoundations.identifier.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Consent Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.ConsentModel#getData_states <em>Data states</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.ConsentModel#getRoleLabelType <em>Role Label Type</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.ConsentModel#getConsentLabelType <em>Consent Label Type</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getConsentModel()
 * @model
 * @generated
 */
public interface ConsentModel extends Entity {
	/**
	 * Returns the value of the '<em><b>Data states</b></em>' containment reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consentmodel.DataState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data states</em>' containment reference list.
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getConsentModel_Data_states()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataState> getData_states();

	/**
	 * Returns the value of the '<em><b>Role Label Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Label Type</em>' containment reference.
	 * @see #setRoleLabelType(RoleLabelType)
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getConsentModel_RoleLabelType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RoleLabelType getRoleLabelType();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.consentmodel.ConsentModel#getRoleLabelType <em>Role Label Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role Label Type</em>' containment reference.
	 * @see #getRoleLabelType()
	 * @generated
	 */
	void setRoleLabelType(RoleLabelType value);

	/**
	 * Returns the value of the '<em><b>Consent Label Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consent Label Type</em>' containment reference.
	 * @see #setConsentLabelType(ConsentLabelType)
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getConsentModel_ConsentLabelType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ConsentLabelType getConsentLabelType();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.consentmodel.ConsentModel#getConsentLabelType <em>Consent Label Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consent Label Type</em>' containment reference.
	 * @see #getConsentLabelType()
	 * @generated
	 */
	void setConsentLabelType(ConsentLabelType value);

} // ConsentModel

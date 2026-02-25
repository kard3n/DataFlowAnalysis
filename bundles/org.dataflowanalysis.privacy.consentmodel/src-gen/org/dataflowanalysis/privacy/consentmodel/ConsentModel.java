/**
 */
package org.dataflowanalysis.privacy.consentmodel;

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
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.ConsentModel#getRoleLabelType <em>Role Label Type</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.ConsentModel#getConsentLabelType <em>Consent Label Type</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.ConsentModel#getDataItemLabelType <em>Data Item Label Type</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.ConsentModel#getDataStateLabelType <em>Data State Label Type</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getConsentModel()
 * @model
 * @generated
 */
public interface ConsentModel extends Entity {
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

	/**
	 * Returns the value of the '<em><b>Data Item Label Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Item Label Type</em>' containment reference.
	 * @see #setDataItemLabelType(DataItemLabelType)
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getConsentModel_DataItemLabelType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataItemLabelType getDataItemLabelType();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.consentmodel.ConsentModel#getDataItemLabelType <em>Data Item Label Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Item Label Type</em>' containment reference.
	 * @see #getDataItemLabelType()
	 * @generated
	 */
	void setDataItemLabelType(DataItemLabelType value);

	/**
	 * Returns the value of the '<em><b>Data State Label Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data State Label Type</em>' containment reference.
	 * @see #setDataStateLabelType(DataStateLabelType)
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getConsentModel_DataStateLabelType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataStateLabelType getDataStateLabelType();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.consentmodel.ConsentModel#getDataStateLabelType <em>Data State Label Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data State Label Type</em>' containment reference.
	 * @see #getDataStateLabelType()
	 * @generated
	 */
	void setDataStateLabelType(DataStateLabelType value);

} // ConsentModel

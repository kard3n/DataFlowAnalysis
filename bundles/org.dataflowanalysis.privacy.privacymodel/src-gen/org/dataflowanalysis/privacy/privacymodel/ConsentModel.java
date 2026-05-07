/**
 */
package org.dataflowanalysis.privacy.privacymodel;

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
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.ConsentModel#getRoleLabelType <em>Role Label Type</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.ConsentModel#getConsentLabelType <em>Consent Label Type</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.ConsentModel#getDataItemLabelType <em>Data Item Label Type</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.ConsentModel#getDataStateLabelType <em>Data State Label Type</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.ConsentModel#getDataContextLabelType <em>Data Context Label Type</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getConsentModel()
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
	 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getConsentModel_RoleLabelType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RoleLabelType getRoleLabelType();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.privacymodel.ConsentModel#getRoleLabelType <em>Role Label Type</em>}' containment reference.
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
	 * @see #setConsentLabelType(FunctionalityLabelType)
	 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getConsentModel_ConsentLabelType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FunctionalityLabelType getConsentLabelType();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.privacymodel.ConsentModel#getConsentLabelType <em>Consent Label Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Consent Label Type</em>' containment reference.
	 * @see #getConsentLabelType()
	 * @generated
	 */
	void setConsentLabelType(FunctionalityLabelType value);

	/**
	 * Returns the value of the '<em><b>Data Item Label Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.privacymodel.DataItemLabelType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Item Label Type</em>' containment reference list.
	 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getConsentModel_DataItemLabelType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<DataItemLabelType> getDataItemLabelType();

	/**
	 * Returns the value of the '<em><b>Data State Label Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data State Label Type</em>' containment reference.
	 * @see #setDataStateLabelType(DataStateLabelType)
	 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getConsentModel_DataStateLabelType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataStateLabelType getDataStateLabelType();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.privacymodel.ConsentModel#getDataStateLabelType <em>Data State Label Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data State Label Type</em>' containment reference.
	 * @see #getDataStateLabelType()
	 * @generated
	 */
	void setDataStateLabelType(DataStateLabelType value);

	/**
	 * Returns the value of the '<em><b>Data Context Label Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Context Label Type</em>' containment reference.
	 * @see #setDataContextLabelType(DataContextLabelType)
	 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getConsentModel_DataContextLabelType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataContextLabelType getDataContextLabelType();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.privacymodel.ConsentModel#getDataContextLabelType <em>Data Context Label Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Context Label Type</em>' containment reference.
	 * @see #getDataContextLabelType()
	 * @generated
	 */
	void setDataContextLabelType(DataContextLabelType value);

} // ConsentModel

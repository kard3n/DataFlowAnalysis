/**
 */
package org.dataflowanalysis.privacy.consentmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage
 * @generated
 */
public interface consentmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	consentmodelFactory eINSTANCE = org.dataflowanalysis.privacy.consentmodel.impl.consentmodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Data Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Item</em>'.
	 * @generated
	 */
	DataItem createDataItem();

	/**
	 * Returns a new object of class '<em>Data State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data State</em>'.
	 * @generated
	 */
	DataState createDataState();

	/**
	 * Returns a new object of class '<em>User Data Combination</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User Data Combination</em>'.
	 * @generated
	 */
	UserDataCombination createUserDataCombination();

	/**
	 * Returns a new object of class '<em>Consent Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Consent Option</em>'.
	 * @generated
	 */
	ConsentOption createConsentOption();

	/**
	 * Returns a new object of class '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role</em>'.
	 * @generated
	 */
	Role createRole();

	/**
	 * Returns a new object of class '<em>Consent Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Consent Model</em>'.
	 * @generated
	 */
	ConsentModel createConsentModel();

	/**
	 * Returns a new object of class '<em>Role Label Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role Label Type</em>'.
	 * @generated
	 */
	RoleLabelType createRoleLabelType();

	/**
	 * Returns a new object of class '<em>Consent Label Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Consent Label Type</em>'.
	 * @generated
	 */
	ConsentLabelType createConsentLabelType();

	/**
	 * Returns a new object of class '<em>Role Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Role Label</em>'.
	 * @generated
	 */
	RoleLabel createRoleLabel();

	/**
	 * Returns a new object of class '<em>Consent Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Consent Label</em>'.
	 * @generated
	 */
	ConsentLabel createConsentLabel();

	/**
	 * Returns a new object of class '<em>Data Item Label Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Item Label Type</em>'.
	 * @generated
	 */
	DataItemLabelType createDataItemLabelType();

	/**
	 * Returns a new object of class '<em>Data Item Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Item Label</em>'.
	 * @generated
	 */
	DataItemLabel createDataItemLabel();

	/**
	 * Returns a new object of class '<em>Stateful Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stateful Item</em>'.
	 * @generated
	 */
	StatefulItem createStatefulItem();

	/**
	 * Returns a new object of class '<em>Data State Label Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data State Label Type</em>'.
	 * @generated
	 */
	DataStateLabelType createDataStateLabelType();

	/**
	 * Returns a new object of class '<em>Data State Label</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data State Label</em>'.
	 * @generated
	 */
	DataStateLabel createDataStateLabel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	consentmodelPackage getconsentmodelPackage();

} //consentmodelFactory

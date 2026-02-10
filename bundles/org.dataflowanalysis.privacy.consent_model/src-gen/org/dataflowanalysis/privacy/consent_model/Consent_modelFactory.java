/**
 */
package org.dataflowanalysis.privacy.consent_model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage
 * @generated
 */
public interface Consent_modelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Consent_modelFactory eINSTANCE = org.dataflowanalysis.privacy.consent_model.impl.Consent_modelFactoryImpl.init();

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
	 * Returns a new object of class '<em>Consented Functionality</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Consented Functionality</em>'.
	 * @generated
	 */
	ConsentedFunctionality createConsentedFunctionality();

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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Consent_modelPackage getConsent_modelPackage();

} //Consent_modelFactory

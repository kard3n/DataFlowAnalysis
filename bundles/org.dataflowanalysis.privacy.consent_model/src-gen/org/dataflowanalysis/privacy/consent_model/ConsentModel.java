/**
 */
package org.dataflowanalysis.privacy.consent_model;

import identifier.Entity;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Consent Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.ConsentModel#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.ConsentModel#getFunctionalities <em>Functionalities</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.ConsentModel#getData_states <em>Data states</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getConsentModel()
 * @model
 * @generated
 */
public interface ConsentModel extends Entity {
	/**
	 * Returns the value of the '<em><b>Roles</b></em>' containment reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consent_model.Role}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' containment reference list.
	 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getConsentModel_Roles()
	 * @model containment="true"
	 * @generated
	 */
	EList<Role> getRoles();

	/**
	 * Returns the value of the '<em><b>Functionalities</b></em>' containment reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consent_model.ConsentedFunctionality}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functionalities</em>' containment reference list.
	 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getConsentModel_Functionalities()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConsentedFunctionality> getFunctionalities();

	/**
	 * Returns the value of the '<em><b>Data states</b></em>' containment reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consent_model.DataState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data states</em>' containment reference list.
	 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getConsentModel_Data_states()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataState> getData_states();

} // ConsentModel

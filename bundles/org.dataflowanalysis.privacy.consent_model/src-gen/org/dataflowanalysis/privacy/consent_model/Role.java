/**
 */
package org.dataflowanalysis.privacy.consent_model;

import identifier.Entity;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.Role#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.Role#getAllows <em>Allows</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.Role#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getRole()
 * @model
 * @generated
 */
public interface Role extends Entity {
	/**
	 * Returns the value of the '<em><b>Requires</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consent_model.ConsentedFunctionality}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requires</em>' reference list.
	 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getRole_Requires()
	 * @model
	 * @generated
	 */
	EList<ConsentedFunctionality> getRequires();

	/**
	 * Returns the value of the '<em><b>Allows</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consent_model.ConsentedFunctionality}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allows</em>' reference list.
	 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getRole_Allows()
	 * @model
	 * @generated
	 */
	EList<ConsentedFunctionality> getAllows();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getRole_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.consent_model.Role#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Role

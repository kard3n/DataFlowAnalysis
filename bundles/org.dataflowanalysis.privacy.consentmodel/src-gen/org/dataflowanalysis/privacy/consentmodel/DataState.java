/**
 */
package org.dataflowanalysis.privacy.consentmodel;

import org.eclipse.emf.common.util.EList;

import tools.mdsd.modelingfoundations.identifier.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.DataState#getName <em>Name</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.DataState#getNotRelatableWith <em>Not Relatable With</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getDataState()
 * @model
 * @generated
 */
public interface DataState extends Entity {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getDataState_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.consentmodel.DataState#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Not Relatable With</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consentmodel.DataState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not Relatable With</em>' reference list.
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getDataState_NotRelatableWith()
	 * @model
	 * @generated
	 */
	EList<DataState> getNotRelatableWith();

} // DataState

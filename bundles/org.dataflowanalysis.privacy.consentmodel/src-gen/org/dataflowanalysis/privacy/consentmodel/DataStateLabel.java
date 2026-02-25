/**
 */
package org.dataflowanalysis.privacy.consentmodel;

import org.dataflowanalysis.dfd.datadictionary.AbstractLabel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data State Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.DataStateLabel#getDataState <em>Data State</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getDataStateLabel()
 * @model
 * @generated
 */
public interface DataStateLabel extends AbstractLabel {
	/**
	 * Returns the value of the '<em><b>Data State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data State</em>' containment reference.
	 * @see #setDataState(DataState)
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getDataStateLabel_DataState()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataState getDataState();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.consentmodel.DataStateLabel#getDataState <em>Data State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data State</em>' containment reference.
	 * @see #getDataState()
	 * @generated
	 */
	void setDataState(DataState value);

} // DataStateLabel

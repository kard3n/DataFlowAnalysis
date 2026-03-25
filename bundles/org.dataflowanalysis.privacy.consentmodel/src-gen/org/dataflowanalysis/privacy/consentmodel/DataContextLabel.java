/**
 */
package org.dataflowanalysis.privacy.consentmodel;

import org.dataflowanalysis.dfd.datadictionary.AbstractLabel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Context Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.DataContextLabel#getDataContext <em>Data Context</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getDataContextLabel()
 * @model
 * @generated
 */
public interface DataContextLabel extends AbstractLabel {
	/**
	 * Returns the value of the '<em><b>Data Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Context</em>' containment reference.
	 * @see #setDataContext(DataContext)
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getDataContextLabel_DataContext()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataContext getDataContext();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.consentmodel.DataContextLabel#getDataContext <em>Data Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Context</em>' containment reference.
	 * @see #getDataContext()
	 * @generated
	 */
	void setDataContext(DataContext value);

} // DataContextLabel

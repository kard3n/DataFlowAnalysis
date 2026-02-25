/**
 */
package org.dataflowanalysis.privacy.consentmodel;

import org.dataflowanalysis.dfd.datadictionary.AbstractLabel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Item Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.DataItemLabel#getDataItem <em>Data Item</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getDataItemLabel()
 * @model
 * @generated
 */
public interface DataItemLabel extends AbstractLabel {
	/**
	 * Returns the value of the '<em><b>Data Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Item</em>' containment reference.
	 * @see #setDataItem(DataItem)
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getDataItemLabel_DataItem()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataItem getDataItem();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.consentmodel.DataItemLabel#getDataItem <em>Data Item</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Item</em>' containment reference.
	 * @see #getDataItem()
	 * @generated
	 */
	void setDataItem(DataItem value);

} // DataItemLabel

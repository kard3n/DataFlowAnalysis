/**
 */
package org.dataflowanalysis.privacy.consentmodel;

import org.dataflowanalysis.dfd.datadictionary.AbstractLabelType;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Item Label Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.DataItemLabelType#getLabels <em>Labels</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getDataItemLabelType()
 * @model
 * @generated
 */
public interface DataItemLabelType extends AbstractLabelType {
	/**
	 * Returns the value of the '<em><b>Labels</b></em>' containment reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consentmodel.DataItemLabel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Labels</em>' containment reference list.
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getDataItemLabelType_Labels()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<DataItemLabel> getLabels();

} // DataItemLabelType

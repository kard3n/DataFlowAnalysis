/**
 */
package org.dataflowanalysis.privacy.consentmodel;

import org.dataflowanalysis.dfd.datadictionary.AbstractLabelType;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data State Label Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.DataStateLabelType#getLabels <em>Labels</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getDataStateLabelType()
 * @model
 * @generated
 */
public interface DataStateLabelType extends AbstractLabelType {
	/**
	 * Returns the value of the '<em><b>Labels</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consentmodel.DataStateLabel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Labels</em>' reference list.
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getDataStateLabelType_Labels()
	 * @model
	 * @generated
	 */
	EList<DataStateLabel> getLabels();

} // DataStateLabelType

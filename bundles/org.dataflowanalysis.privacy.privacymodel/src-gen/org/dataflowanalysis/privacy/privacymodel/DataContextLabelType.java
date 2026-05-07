/**
 */
package org.dataflowanalysis.privacy.privacymodel;

import org.dataflowanalysis.dfd.datadictionary.AbstractLabelType;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Context Label Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.DataContextLabelType#getLabels <em>Labels</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getDataContextLabelType()
 * @model
 * @generated
 */
public interface DataContextLabelType extends AbstractLabelType {
	/**
	 * Returns the value of the '<em><b>Labels</b></em>' containment reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.privacymodel.DataContextLabel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Labels</em>' containment reference list.
	 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getDataContextLabelType_Labels()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<DataContextLabel> getLabels();

} // DataContextLabelType

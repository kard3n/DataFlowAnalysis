/**
 */
package org.dataflowanalysis.privacy.consentmodel;

import org.eclipse.emf.common.util.EList;

import tools.mdsd.modelingfoundations.identifier.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.DataItem#getState <em>State</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getDataItem()
 * @model
 * @generated
 */
public interface DataItem extends Entity {
	/**
	 * Returns the value of the '<em><b>State</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consentmodel.DataState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' reference list.
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#getDataItem_State()
	 * @model
	 * @generated
	 */
	EList<DataState> getState();

} // DataItem

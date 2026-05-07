/**
 */
package org.dataflowanalysis.privacy.privacymodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stateful Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.StatefulItem#getState <em>State</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.StatefulItem#getItem <em>Item</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.StatefulItem#getContext <em>Context</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getStatefulItem()
 * @model
 * @generated
 */
public interface StatefulItem extends EObject {
	/**
	 * Returns the value of the '<em><b>State</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.privacymodel.DataState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' reference list.
	 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getStatefulItem_State()
	 * @model
	 * @generated
	 */
	EList<DataState> getState();

	/**
	 * Returns the value of the '<em><b>Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item</em>' reference.
	 * @see #setItem(DataItem)
	 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getStatefulItem_Item()
	 * @model required="true"
	 * @generated
	 */
	DataItem getItem();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.privacymodel.StatefulItem#getItem <em>Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item</em>' reference.
	 * @see #getItem()
	 * @generated
	 */
	void setItem(DataItem value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.privacymodel.DataContext}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' reference list.
	 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getStatefulItem_Context()
	 * @model
	 * @generated
	 */
	EList<DataContext> getContext();

} // StatefulItem

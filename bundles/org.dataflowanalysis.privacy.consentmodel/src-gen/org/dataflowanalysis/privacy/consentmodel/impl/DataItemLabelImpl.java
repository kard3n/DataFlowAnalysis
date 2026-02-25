/**
 */
package org.dataflowanalysis.privacy.consentmodel.impl;

import java.util.Collection;

import org.dataflowanalysis.dfd.datadictionary.impl.AbstractLabelImpl;

import org.dataflowanalysis.privacy.consentmodel.DataItem;
import org.dataflowanalysis.privacy.consentmodel.DataItemLabel;
import org.dataflowanalysis.privacy.consentmodel.consentmodelPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Item Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.impl.DataItemLabelImpl#getDataItem <em>Data Item</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataItemLabelImpl extends AbstractLabelImpl implements DataItemLabel {
	/**
	 * The cached value of the '{@link #getDataItem() <em>Data Item</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataItem()
	 * @generated
	 * @ordered
	 */
	protected EList<DataItem> dataItem;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataItemLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return consentmodelPackage.Literals.DATA_ITEM_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataItem> getDataItem() {
		if (dataItem == null) {
			dataItem = new EObjectContainmentEList<DataItem>(DataItem.class, this,
					consentmodelPackage.DATA_ITEM_LABEL__DATA_ITEM);
		}
		return dataItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case consentmodelPackage.DATA_ITEM_LABEL__DATA_ITEM:
			return ((InternalEList<?>) getDataItem()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case consentmodelPackage.DATA_ITEM_LABEL__DATA_ITEM:
			return getDataItem();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case consentmodelPackage.DATA_ITEM_LABEL__DATA_ITEM:
			getDataItem().clear();
			getDataItem().addAll((Collection<? extends DataItem>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case consentmodelPackage.DATA_ITEM_LABEL__DATA_ITEM:
			getDataItem().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case consentmodelPackage.DATA_ITEM_LABEL__DATA_ITEM:
			return dataItem != null && !dataItem.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataItemLabelImpl

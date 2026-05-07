/**
 */
package org.dataflowanalysis.privacy.privacymodel.impl;

import org.dataflowanalysis.dfd.datadictionary.impl.AbstractLabelImpl;

import org.dataflowanalysis.privacy.privacymodel.DataItem;
import org.dataflowanalysis.privacy.privacymodel.DataItemLabel;
import org.dataflowanalysis.privacy.privacymodel.privacymodelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Item Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.impl.DataItemLabelImpl#getDataItem <em>Data Item</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataItemLabelImpl extends AbstractLabelImpl implements DataItemLabel {
	/**
	 * The cached value of the '{@link #getDataItem() <em>Data Item</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataItem()
	 * @generated
	 * @ordered
	 */
	protected DataItem dataItem;

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
		return privacymodelPackage.Literals.DATA_ITEM_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataItem getDataItem() {
		return dataItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataItem(DataItem newDataItem, NotificationChain msgs) {
		DataItem oldDataItem = dataItem;
		dataItem = newDataItem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					privacymodelPackage.DATA_ITEM_LABEL__DATA_ITEM, oldDataItem, newDataItem);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataItem(DataItem newDataItem) {
		if (newDataItem != dataItem) {
			NotificationChain msgs = null;
			if (dataItem != null)
				msgs = ((InternalEObject) dataItem).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - privacymodelPackage.DATA_ITEM_LABEL__DATA_ITEM, null, msgs);
			if (newDataItem != null)
				msgs = ((InternalEObject) newDataItem).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - privacymodelPackage.DATA_ITEM_LABEL__DATA_ITEM, null, msgs);
			msgs = basicSetDataItem(newDataItem, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, privacymodelPackage.DATA_ITEM_LABEL__DATA_ITEM,
					newDataItem, newDataItem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case privacymodelPackage.DATA_ITEM_LABEL__DATA_ITEM:
			return basicSetDataItem(null, msgs);
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
		case privacymodelPackage.DATA_ITEM_LABEL__DATA_ITEM:
			return getDataItem();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case privacymodelPackage.DATA_ITEM_LABEL__DATA_ITEM:
			setDataItem((DataItem) newValue);
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
		case privacymodelPackage.DATA_ITEM_LABEL__DATA_ITEM:
			setDataItem((DataItem) null);
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
		case privacymodelPackage.DATA_ITEM_LABEL__DATA_ITEM:
			return dataItem != null;
		}
		return super.eIsSet(featureID);
	}

} //DataItemLabelImpl

/**
 */
package org.dataflowanalysis.privacy.privacymodel.impl;

import java.util.Collection;

import org.dataflowanalysis.dfd.datadictionary.impl.AbstractLabelTypeImpl;

import org.dataflowanalysis.privacy.privacymodel.DataItemLabel;
import org.dataflowanalysis.privacy.privacymodel.DataItemLabelType;
import org.dataflowanalysis.privacy.privacymodel.privacymodelPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Item Label Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.impl.DataItemLabelTypeImpl#getLabels <em>Labels</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataItemLabelTypeImpl extends AbstractLabelTypeImpl implements DataItemLabelType {
	/**
	 * The cached value of the '{@link #getLabels() <em>Labels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabels()
	 * @generated
	 * @ordered
	 */
	protected EList<DataItemLabel> labels;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataItemLabelTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return privacymodelPackage.Literals.DATA_ITEM_LABEL_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataItemLabel> getLabels() {
		if (labels == null) {
			labels = new EObjectContainmentEList<DataItemLabel>(DataItemLabel.class, this,
					privacymodelPackage.DATA_ITEM_LABEL_TYPE__LABELS);
		}
		return labels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case privacymodelPackage.DATA_ITEM_LABEL_TYPE__LABELS:
			return ((InternalEList<?>) getLabels()).basicRemove(otherEnd, msgs);
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
		case privacymodelPackage.DATA_ITEM_LABEL_TYPE__LABELS:
			return getLabels();
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
		case privacymodelPackage.DATA_ITEM_LABEL_TYPE__LABELS:
			getLabels().clear();
			getLabels().addAll((Collection<? extends DataItemLabel>) newValue);
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
		case privacymodelPackage.DATA_ITEM_LABEL_TYPE__LABELS:
			getLabels().clear();
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
		case privacymodelPackage.DATA_ITEM_LABEL_TYPE__LABELS:
			return labels != null && !labels.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataItemLabelTypeImpl

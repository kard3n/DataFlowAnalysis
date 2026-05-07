/**
 */
package org.dataflowanalysis.privacy.privacymodel.impl;

import java.util.Collection;

import org.dataflowanalysis.dfd.datadictionary.impl.AbstractLabelTypeImpl;

import org.dataflowanalysis.privacy.privacymodel.DataContextLabel;
import org.dataflowanalysis.privacy.privacymodel.DataContextLabelType;
import org.dataflowanalysis.privacy.privacymodel.privacymodelPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Context Label Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.impl.DataContextLabelTypeImpl#getLabels <em>Labels</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataContextLabelTypeImpl extends AbstractLabelTypeImpl implements DataContextLabelType {
	/**
	 * The cached value of the '{@link #getLabels() <em>Labels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabels()
	 * @generated
	 * @ordered
	 */
	protected EList<DataContextLabel> labels;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataContextLabelTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return privacymodelPackage.Literals.DATA_CONTEXT_LABEL_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataContextLabel> getLabels() {
		if (labels == null) {
			labels = new EObjectContainmentEList<DataContextLabel>(DataContextLabel.class, this,
					privacymodelPackage.DATA_CONTEXT_LABEL_TYPE__LABELS);
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
		case privacymodelPackage.DATA_CONTEXT_LABEL_TYPE__LABELS:
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
		case privacymodelPackage.DATA_CONTEXT_LABEL_TYPE__LABELS:
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
		case privacymodelPackage.DATA_CONTEXT_LABEL_TYPE__LABELS:
			getLabels().clear();
			getLabels().addAll((Collection<? extends DataContextLabel>) newValue);
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
		case privacymodelPackage.DATA_CONTEXT_LABEL_TYPE__LABELS:
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
		case privacymodelPackage.DATA_CONTEXT_LABEL_TYPE__LABELS:
			return labels != null && !labels.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataContextLabelTypeImpl

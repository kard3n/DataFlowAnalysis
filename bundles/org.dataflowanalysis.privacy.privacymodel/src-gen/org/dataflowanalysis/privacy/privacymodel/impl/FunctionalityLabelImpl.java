/**
 */
package org.dataflowanalysis.privacy.privacymodel.impl;

import org.dataflowanalysis.dfd.datadictionary.impl.AbstractLabelImpl;

import org.dataflowanalysis.privacy.privacymodel.Functionality;
import org.dataflowanalysis.privacy.privacymodel.FunctionalityLabel;
import org.dataflowanalysis.privacy.privacymodel.privacymodelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Functionality Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.impl.FunctionalityLabelImpl#getFunctionality <em>Functionality</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionalityLabelImpl extends AbstractLabelImpl implements FunctionalityLabel {
	/**
	 * The cached value of the '{@link #getFunctionality() <em>Functionality</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionality()
	 * @generated
	 * @ordered
	 */
	protected Functionality functionality;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionalityLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return privacymodelPackage.Literals.FUNCTIONALITY_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Functionality getFunctionality() {
		return functionality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunctionality(Functionality newFunctionality, NotificationChain msgs) {
		Functionality oldFunctionality = functionality;
		functionality = newFunctionality;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					privacymodelPackage.FUNCTIONALITY_LABEL__FUNCTIONALITY, oldFunctionality, newFunctionality);
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
	public void setFunctionality(Functionality newFunctionality) {
		if (newFunctionality != functionality) {
			NotificationChain msgs = null;
			if (functionality != null)
				msgs = ((InternalEObject) functionality).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - privacymodelPackage.FUNCTIONALITY_LABEL__FUNCTIONALITY, null, msgs);
			if (newFunctionality != null)
				msgs = ((InternalEObject) newFunctionality).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - privacymodelPackage.FUNCTIONALITY_LABEL__FUNCTIONALITY, null, msgs);
			msgs = basicSetFunctionality(newFunctionality, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					privacymodelPackage.FUNCTIONALITY_LABEL__FUNCTIONALITY, newFunctionality, newFunctionality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case privacymodelPackage.FUNCTIONALITY_LABEL__FUNCTIONALITY:
			return basicSetFunctionality(null, msgs);
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
		case privacymodelPackage.FUNCTIONALITY_LABEL__FUNCTIONALITY:
			return getFunctionality();
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
		case privacymodelPackage.FUNCTIONALITY_LABEL__FUNCTIONALITY:
			setFunctionality((Functionality) newValue);
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
		case privacymodelPackage.FUNCTIONALITY_LABEL__FUNCTIONALITY:
			setFunctionality((Functionality) null);
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
		case privacymodelPackage.FUNCTIONALITY_LABEL__FUNCTIONALITY:
			return functionality != null;
		}
		return super.eIsSet(featureID);
	}

} //FunctionalityLabelImpl

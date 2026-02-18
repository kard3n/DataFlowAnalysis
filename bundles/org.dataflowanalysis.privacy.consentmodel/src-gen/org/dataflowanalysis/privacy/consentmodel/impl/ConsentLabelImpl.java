/**
 */
package org.dataflowanalysis.privacy.consentmodel.impl;

import org.dataflowanalysis.dfd.datadictionary.impl.AbstractLabelImpl;

import org.dataflowanalysis.privacy.consentmodel.ConsentLabel;
import org.dataflowanalysis.privacy.consentmodel.ConsentOption;
import org.dataflowanalysis.privacy.consentmodel.consentmodelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Consent Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.impl.ConsentLabelImpl#getConsentOption <em>Consent Option</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConsentLabelImpl extends AbstractLabelImpl implements ConsentLabel {
	/**
	 * The cached value of the '{@link #getConsentOption() <em>Consent Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsentOption()
	 * @generated
	 * @ordered
	 */
	protected ConsentOption consentOption;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConsentLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return consentmodelPackage.Literals.CONSENT_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConsentOption getConsentOption() {
		return consentOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConsentOption(ConsentOption newConsentOption, NotificationChain msgs) {
		ConsentOption oldConsentOption = consentOption;
		consentOption = newConsentOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					consentmodelPackage.CONSENT_LABEL__CONSENT_OPTION, oldConsentOption, newConsentOption);
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
	public void setConsentOption(ConsentOption newConsentOption) {
		if (newConsentOption != consentOption) {
			NotificationChain msgs = null;
			if (consentOption != null)
				msgs = ((InternalEObject) consentOption).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - consentmodelPackage.CONSENT_LABEL__CONSENT_OPTION, null, msgs);
			if (newConsentOption != null)
				msgs = ((InternalEObject) newConsentOption).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - consentmodelPackage.CONSENT_LABEL__CONSENT_OPTION, null, msgs);
			msgs = basicSetConsentOption(newConsentOption, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, consentmodelPackage.CONSENT_LABEL__CONSENT_OPTION,
					newConsentOption, newConsentOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case consentmodelPackage.CONSENT_LABEL__CONSENT_OPTION:
			return basicSetConsentOption(null, msgs);
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
		case consentmodelPackage.CONSENT_LABEL__CONSENT_OPTION:
			return getConsentOption();
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
		case consentmodelPackage.CONSENT_LABEL__CONSENT_OPTION:
			setConsentOption((ConsentOption) newValue);
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
		case consentmodelPackage.CONSENT_LABEL__CONSENT_OPTION:
			setConsentOption((ConsentOption) null);
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
		case consentmodelPackage.CONSENT_LABEL__CONSENT_OPTION:
			return consentOption != null;
		}
		return super.eIsSet(featureID);
	}

} //ConsentLabelImpl

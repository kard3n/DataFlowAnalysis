/**
 */
package org.dataflowanalysis.privacy.consent_model.impl;

import org.dataflowanalysis.dfd.datadictionary.impl.LabelImpl;

import org.dataflowanalysis.privacy.consent_model.ConsentLabel;
import org.dataflowanalysis.privacy.consent_model.Consent_modelPackage;
import org.dataflowanalysis.privacy.consent_model.ConsentedFunctionality;

import org.eclipse.emf.common.notify.Notification;

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
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentLabelImpl#getConsentedFunctionality <em>Consented Functionality</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConsentLabelImpl extends LabelImpl implements ConsentLabel {
	/**
	 * The cached value of the '{@link #getConsentedFunctionality() <em>Consented Functionality</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsentedFunctionality()
	 * @generated
	 * @ordered
	 */
	protected ConsentedFunctionality consentedFunctionality;

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
		return Consent_modelPackage.Literals.CONSENT_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConsentedFunctionality getConsentedFunctionality() {
		if (consentedFunctionality != null && consentedFunctionality.eIsProxy()) {
			InternalEObject oldConsentedFunctionality = (InternalEObject) consentedFunctionality;
			consentedFunctionality = (ConsentedFunctionality) eResolveProxy(oldConsentedFunctionality);
			if (consentedFunctionality != oldConsentedFunctionality) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Consent_modelPackage.CONSENT_LABEL__CONSENTED_FUNCTIONALITY, oldConsentedFunctionality,
							consentedFunctionality));
			}
		}
		return consentedFunctionality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsentedFunctionality basicGetConsentedFunctionality() {
		return consentedFunctionality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConsentedFunctionality(ConsentedFunctionality newConsentedFunctionality) {
		ConsentedFunctionality oldConsentedFunctionality = consentedFunctionality;
		consentedFunctionality = newConsentedFunctionality;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Consent_modelPackage.CONSENT_LABEL__CONSENTED_FUNCTIONALITY, oldConsentedFunctionality,
					consentedFunctionality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Consent_modelPackage.CONSENT_LABEL__CONSENTED_FUNCTIONALITY:
			if (resolve)
				return getConsentedFunctionality();
			return basicGetConsentedFunctionality();
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
		case Consent_modelPackage.CONSENT_LABEL__CONSENTED_FUNCTIONALITY:
			setConsentedFunctionality((ConsentedFunctionality) newValue);
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
		case Consent_modelPackage.CONSENT_LABEL__CONSENTED_FUNCTIONALITY:
			setConsentedFunctionality((ConsentedFunctionality) null);
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
		case Consent_modelPackage.CONSENT_LABEL__CONSENTED_FUNCTIONALITY:
			return consentedFunctionality != null;
		}
		return super.eIsSet(featureID);
	}

} //ConsentLabelImpl

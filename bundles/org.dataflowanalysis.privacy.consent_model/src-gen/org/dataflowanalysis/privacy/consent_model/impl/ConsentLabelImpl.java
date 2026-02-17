/**
 */
package org.dataflowanalysis.privacy.consent_model.impl;

import org.dataflowanalysis.privacy.consent_model.ConsentLabel;
import org.dataflowanalysis.privacy.consent_model.ConsentOption;
import org.dataflowanalysis.privacy.consent_model.Consent_modelPackage;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

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
public class ConsentLabelImpl extends MinimalEObjectImpl.Container implements ConsentLabel {
	/**
	 * The cached value of the '{@link #getConsentedFunctionality() <em>Consented Functionality</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsentedFunctionality()
	 * @generated
	 * @ordered
	 */
	protected ConsentOption consentedFunctionality;

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
	public ConsentOption getConsentedFunctionality() {
		return consentedFunctionality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConsentedFunctionality(ConsentOption newConsentedFunctionality,
			NotificationChain msgs) {
		ConsentOption oldConsentedFunctionality = consentedFunctionality;
		consentedFunctionality = newConsentedFunctionality;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Consent_modelPackage.CONSENT_LABEL__CONSENTED_FUNCTIONALITY, oldConsentedFunctionality,
					newConsentedFunctionality);
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
	public void setConsentedFunctionality(ConsentOption newConsentedFunctionality) {
		if (newConsentedFunctionality != consentedFunctionality) {
			NotificationChain msgs = null;
			if (consentedFunctionality != null)
				msgs = ((InternalEObject) consentedFunctionality).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Consent_modelPackage.CONSENT_LABEL__CONSENTED_FUNCTIONALITY, null,
						msgs);
			if (newConsentedFunctionality != null)
				msgs = ((InternalEObject) newConsentedFunctionality).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Consent_modelPackage.CONSENT_LABEL__CONSENTED_FUNCTIONALITY, null,
						msgs);
			msgs = basicSetConsentedFunctionality(newConsentedFunctionality, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Consent_modelPackage.CONSENT_LABEL__CONSENTED_FUNCTIONALITY, newConsentedFunctionality,
					newConsentedFunctionality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Consent_modelPackage.CONSENT_LABEL__CONSENTED_FUNCTIONALITY:
			return basicSetConsentedFunctionality(null, msgs);
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
		case Consent_modelPackage.CONSENT_LABEL__CONSENTED_FUNCTIONALITY:
			return getConsentedFunctionality();
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
			setConsentedFunctionality((ConsentOption) newValue);
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
			setConsentedFunctionality((ConsentOption) null);
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

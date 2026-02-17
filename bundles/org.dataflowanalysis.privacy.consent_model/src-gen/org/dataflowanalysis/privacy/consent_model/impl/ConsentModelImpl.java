/**
 */
package org.dataflowanalysis.privacy.consent_model.impl;

import identifier.impl.EntityImpl;
import java.util.Collection;

import org.dataflowanalysis.privacy.consent_model.ConsentLabelType;
import org.dataflowanalysis.privacy.consent_model.ConsentModel;
import org.dataflowanalysis.privacy.consent_model.ConsentOption;
import org.dataflowanalysis.privacy.consent_model.Consent_modelPackage;
import org.dataflowanalysis.privacy.consent_model.DataState;
import org.dataflowanalysis.privacy.consent_model.RoleLabelType;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Consent Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentModelImpl#getFunctionalities <em>Functionalities</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentModelImpl#getData_states <em>Data states</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentModelImpl#getRoleLabelType <em>Role Label Type</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentModelImpl#getConsentLabelType <em>Consent Label Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConsentModelImpl extends EntityImpl implements ConsentModel {
	/**
	 * The cached value of the '{@link #getFunctionalities() <em>Functionalities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionalities()
	 * @generated
	 * @ordered
	 */
	protected EList<ConsentOption> functionalities;

	/**
	 * The cached value of the '{@link #getData_states() <em>Data states</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData_states()
	 * @generated
	 * @ordered
	 */
	protected EList<DataState> data_states;

	/**
	 * The cached value of the '{@link #getRoleLabelType() <em>Role Label Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoleLabelType()
	 * @generated
	 * @ordered
	 */
	protected RoleLabelType roleLabelType;

	/**
	 * The cached value of the '{@link #getConsentLabelType() <em>Consent Label Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsentLabelType()
	 * @generated
	 * @ordered
	 */
	protected ConsentLabelType consentLabelType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConsentModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Consent_modelPackage.Literals.CONSENT_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConsentOption> getFunctionalities() {
		if (functionalities == null) {
			functionalities = new EObjectContainmentEList<ConsentOption>(ConsentOption.class, this,
					Consent_modelPackage.CONSENT_MODEL__FUNCTIONALITIES);
		}
		return functionalities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataState> getData_states() {
		if (data_states == null) {
			data_states = new EObjectContainmentEList<DataState>(DataState.class, this,
					Consent_modelPackage.CONSENT_MODEL__DATA_STATES);
		}
		return data_states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RoleLabelType getRoleLabelType() {
		return roleLabelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoleLabelType(RoleLabelType newRoleLabelType, NotificationChain msgs) {
		RoleLabelType oldRoleLabelType = roleLabelType;
		roleLabelType = newRoleLabelType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Consent_modelPackage.CONSENT_MODEL__ROLE_LABEL_TYPE, oldRoleLabelType, newRoleLabelType);
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
	public void setRoleLabelType(RoleLabelType newRoleLabelType) {
		if (newRoleLabelType != roleLabelType) {
			NotificationChain msgs = null;
			if (roleLabelType != null)
				msgs = ((InternalEObject) roleLabelType).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Consent_modelPackage.CONSENT_MODEL__ROLE_LABEL_TYPE, null, msgs);
			if (newRoleLabelType != null)
				msgs = ((InternalEObject) newRoleLabelType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Consent_modelPackage.CONSENT_MODEL__ROLE_LABEL_TYPE, null, msgs);
			msgs = basicSetRoleLabelType(newRoleLabelType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Consent_modelPackage.CONSENT_MODEL__ROLE_LABEL_TYPE,
					newRoleLabelType, newRoleLabelType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConsentLabelType getConsentLabelType() {
		return consentLabelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConsentLabelType(ConsentLabelType newConsentLabelType, NotificationChain msgs) {
		ConsentLabelType oldConsentLabelType = consentLabelType;
		consentLabelType = newConsentLabelType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Consent_modelPackage.CONSENT_MODEL__CONSENT_LABEL_TYPE, oldConsentLabelType, newConsentLabelType);
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
	public void setConsentLabelType(ConsentLabelType newConsentLabelType) {
		if (newConsentLabelType != consentLabelType) {
			NotificationChain msgs = null;
			if (consentLabelType != null)
				msgs = ((InternalEObject) consentLabelType).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Consent_modelPackage.CONSENT_MODEL__CONSENT_LABEL_TYPE, null, msgs);
			if (newConsentLabelType != null)
				msgs = ((InternalEObject) newConsentLabelType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Consent_modelPackage.CONSENT_MODEL__CONSENT_LABEL_TYPE, null, msgs);
			msgs = basicSetConsentLabelType(newConsentLabelType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					Consent_modelPackage.CONSENT_MODEL__CONSENT_LABEL_TYPE, newConsentLabelType, newConsentLabelType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Consent_modelPackage.CONSENT_MODEL__FUNCTIONALITIES:
			return ((InternalEList<?>) getFunctionalities()).basicRemove(otherEnd, msgs);
		case Consent_modelPackage.CONSENT_MODEL__DATA_STATES:
			return ((InternalEList<?>) getData_states()).basicRemove(otherEnd, msgs);
		case Consent_modelPackage.CONSENT_MODEL__ROLE_LABEL_TYPE:
			return basicSetRoleLabelType(null, msgs);
		case Consent_modelPackage.CONSENT_MODEL__CONSENT_LABEL_TYPE:
			return basicSetConsentLabelType(null, msgs);
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
		case Consent_modelPackage.CONSENT_MODEL__FUNCTIONALITIES:
			return getFunctionalities();
		case Consent_modelPackage.CONSENT_MODEL__DATA_STATES:
			return getData_states();
		case Consent_modelPackage.CONSENT_MODEL__ROLE_LABEL_TYPE:
			return getRoleLabelType();
		case Consent_modelPackage.CONSENT_MODEL__CONSENT_LABEL_TYPE:
			return getConsentLabelType();
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
		case Consent_modelPackage.CONSENT_MODEL__FUNCTIONALITIES:
			getFunctionalities().clear();
			getFunctionalities().addAll((Collection<? extends ConsentOption>) newValue);
			return;
		case Consent_modelPackage.CONSENT_MODEL__DATA_STATES:
			getData_states().clear();
			getData_states().addAll((Collection<? extends DataState>) newValue);
			return;
		case Consent_modelPackage.CONSENT_MODEL__ROLE_LABEL_TYPE:
			setRoleLabelType((RoleLabelType) newValue);
			return;
		case Consent_modelPackage.CONSENT_MODEL__CONSENT_LABEL_TYPE:
			setConsentLabelType((ConsentLabelType) newValue);
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
		case Consent_modelPackage.CONSENT_MODEL__FUNCTIONALITIES:
			getFunctionalities().clear();
			return;
		case Consent_modelPackage.CONSENT_MODEL__DATA_STATES:
			getData_states().clear();
			return;
		case Consent_modelPackage.CONSENT_MODEL__ROLE_LABEL_TYPE:
			setRoleLabelType((RoleLabelType) null);
			return;
		case Consent_modelPackage.CONSENT_MODEL__CONSENT_LABEL_TYPE:
			setConsentLabelType((ConsentLabelType) null);
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
		case Consent_modelPackage.CONSENT_MODEL__FUNCTIONALITIES:
			return functionalities != null && !functionalities.isEmpty();
		case Consent_modelPackage.CONSENT_MODEL__DATA_STATES:
			return data_states != null && !data_states.isEmpty();
		case Consent_modelPackage.CONSENT_MODEL__ROLE_LABEL_TYPE:
			return roleLabelType != null;
		case Consent_modelPackage.CONSENT_MODEL__CONSENT_LABEL_TYPE:
			return consentLabelType != null;
		}
		return super.eIsSet(featureID);
	}

} //ConsentModelImpl

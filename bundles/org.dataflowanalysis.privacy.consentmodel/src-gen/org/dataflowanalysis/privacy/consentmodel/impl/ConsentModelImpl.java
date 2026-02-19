/**
 */
package org.dataflowanalysis.privacy.consentmodel.impl;

import java.util.Collection;

import org.dataflowanalysis.privacy.consentmodel.ConsentLabelType;
import org.dataflowanalysis.privacy.consentmodel.ConsentModel;
import org.dataflowanalysis.privacy.consentmodel.DataItem;
import org.dataflowanalysis.privacy.consentmodel.DataState;
import org.dataflowanalysis.privacy.consentmodel.RoleLabelType;
import org.dataflowanalysis.privacy.consentmodel.consentmodelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tools.mdsd.modelingfoundations.identifier.impl.EntityImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Consent Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.impl.ConsentModelImpl#getData_states <em>Data states</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.impl.ConsentModelImpl#getRoleLabelType <em>Role Label Type</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.impl.ConsentModelImpl#getConsentLabelType <em>Consent Label Type</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.impl.ConsentModelImpl#getDataItems <em>Data Items</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConsentModelImpl extends EntityImpl implements ConsentModel {
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
	 * The cached value of the '{@link #getDataItems() <em>Data Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataItems()
	 * @generated
	 * @ordered
	 */
	protected EList<DataItem> dataItems;

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
		return consentmodelPackage.Literals.CONSENT_MODEL;
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
					consentmodelPackage.CONSENT_MODEL__DATA_STATES);
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
					consentmodelPackage.CONSENT_MODEL__ROLE_LABEL_TYPE, oldRoleLabelType, newRoleLabelType);
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
						EOPPOSITE_FEATURE_BASE - consentmodelPackage.CONSENT_MODEL__ROLE_LABEL_TYPE, null, msgs);
			if (newRoleLabelType != null)
				msgs = ((InternalEObject) newRoleLabelType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - consentmodelPackage.CONSENT_MODEL__ROLE_LABEL_TYPE, null, msgs);
			msgs = basicSetRoleLabelType(newRoleLabelType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, consentmodelPackage.CONSENT_MODEL__ROLE_LABEL_TYPE,
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
					consentmodelPackage.CONSENT_MODEL__CONSENT_LABEL_TYPE, oldConsentLabelType, newConsentLabelType);
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
						EOPPOSITE_FEATURE_BASE - consentmodelPackage.CONSENT_MODEL__CONSENT_LABEL_TYPE, null, msgs);
			if (newConsentLabelType != null)
				msgs = ((InternalEObject) newConsentLabelType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - consentmodelPackage.CONSENT_MODEL__CONSENT_LABEL_TYPE, null, msgs);
			msgs = basicSetConsentLabelType(newConsentLabelType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, consentmodelPackage.CONSENT_MODEL__CONSENT_LABEL_TYPE,
					newConsentLabelType, newConsentLabelType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataItem> getDataItems() {
		if (dataItems == null) {
			dataItems = new EObjectContainmentEList<DataItem>(DataItem.class, this,
					consentmodelPackage.CONSENT_MODEL__DATA_ITEMS);
		}
		return dataItems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case consentmodelPackage.CONSENT_MODEL__DATA_STATES:
			return ((InternalEList<?>) getData_states()).basicRemove(otherEnd, msgs);
		case consentmodelPackage.CONSENT_MODEL__ROLE_LABEL_TYPE:
			return basicSetRoleLabelType(null, msgs);
		case consentmodelPackage.CONSENT_MODEL__CONSENT_LABEL_TYPE:
			return basicSetConsentLabelType(null, msgs);
		case consentmodelPackage.CONSENT_MODEL__DATA_ITEMS:
			return ((InternalEList<?>) getDataItems()).basicRemove(otherEnd, msgs);
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
		case consentmodelPackage.CONSENT_MODEL__DATA_STATES:
			return getData_states();
		case consentmodelPackage.CONSENT_MODEL__ROLE_LABEL_TYPE:
			return getRoleLabelType();
		case consentmodelPackage.CONSENT_MODEL__CONSENT_LABEL_TYPE:
			return getConsentLabelType();
		case consentmodelPackage.CONSENT_MODEL__DATA_ITEMS:
			return getDataItems();
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
		case consentmodelPackage.CONSENT_MODEL__DATA_STATES:
			getData_states().clear();
			getData_states().addAll((Collection<? extends DataState>) newValue);
			return;
		case consentmodelPackage.CONSENT_MODEL__ROLE_LABEL_TYPE:
			setRoleLabelType((RoleLabelType) newValue);
			return;
		case consentmodelPackage.CONSENT_MODEL__CONSENT_LABEL_TYPE:
			setConsentLabelType((ConsentLabelType) newValue);
			return;
		case consentmodelPackage.CONSENT_MODEL__DATA_ITEMS:
			getDataItems().clear();
			getDataItems().addAll((Collection<? extends DataItem>) newValue);
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
		case consentmodelPackage.CONSENT_MODEL__DATA_STATES:
			getData_states().clear();
			return;
		case consentmodelPackage.CONSENT_MODEL__ROLE_LABEL_TYPE:
			setRoleLabelType((RoleLabelType) null);
			return;
		case consentmodelPackage.CONSENT_MODEL__CONSENT_LABEL_TYPE:
			setConsentLabelType((ConsentLabelType) null);
			return;
		case consentmodelPackage.CONSENT_MODEL__DATA_ITEMS:
			getDataItems().clear();
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
		case consentmodelPackage.CONSENT_MODEL__DATA_STATES:
			return data_states != null && !data_states.isEmpty();
		case consentmodelPackage.CONSENT_MODEL__ROLE_LABEL_TYPE:
			return roleLabelType != null;
		case consentmodelPackage.CONSENT_MODEL__CONSENT_LABEL_TYPE:
			return consentLabelType != null;
		case consentmodelPackage.CONSENT_MODEL__DATA_ITEMS:
			return dataItems != null && !dataItems.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConsentModelImpl

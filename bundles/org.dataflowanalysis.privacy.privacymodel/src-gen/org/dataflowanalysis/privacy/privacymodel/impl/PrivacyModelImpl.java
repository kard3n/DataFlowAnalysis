/**
 */
package org.dataflowanalysis.privacy.privacymodel.impl;

import java.util.Collection;

import org.dataflowanalysis.privacy.privacymodel.DataContextLabelType;
import org.dataflowanalysis.privacy.privacymodel.DataItemLabelType;
import org.dataflowanalysis.privacy.privacymodel.DataStateLabelType;
import org.dataflowanalysis.privacy.privacymodel.FunctionalityLabelType;
import org.dataflowanalysis.privacy.privacymodel.PrivacyModel;
import org.dataflowanalysis.privacy.privacymodel.RoleLabelType;
import org.dataflowanalysis.privacy.privacymodel.privacymodelPackage;

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
 * An implementation of the model object '<em><b>Privacy Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.impl.PrivacyModelImpl#getRoleLabelType <em>Role Label Type</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.impl.PrivacyModelImpl#getFunctionalityLabelType <em>Functionality Label Type</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.impl.PrivacyModelImpl#getDataItemLabelType <em>Data Item Label Type</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.impl.PrivacyModelImpl#getDataStateLabelType <em>Data State Label Type</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.impl.PrivacyModelImpl#getDataContextLabelType <em>Data Context Label Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrivacyModelImpl extends EntityImpl implements PrivacyModel {
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
	 * The cached value of the '{@link #getFunctionalityLabelType() <em>Functionality Label Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionalityLabelType()
	 * @generated
	 * @ordered
	 */
	protected FunctionalityLabelType functionalityLabelType;

	/**
	 * The cached value of the '{@link #getDataItemLabelType() <em>Data Item Label Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataItemLabelType()
	 * @generated
	 * @ordered
	 */
	protected EList<DataItemLabelType> dataItemLabelType;

	/**
	 * The cached value of the '{@link #getDataStateLabelType() <em>Data State Label Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataStateLabelType()
	 * @generated
	 * @ordered
	 */
	protected DataStateLabelType dataStateLabelType;

	/**
	 * The cached value of the '{@link #getDataContextLabelType() <em>Data Context Label Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataContextLabelType()
	 * @generated
	 * @ordered
	 */
	protected DataContextLabelType dataContextLabelType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrivacyModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return privacymodelPackage.Literals.PRIVACY_MODEL;
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
					privacymodelPackage.PRIVACY_MODEL__ROLE_LABEL_TYPE, oldRoleLabelType, newRoleLabelType);
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
						EOPPOSITE_FEATURE_BASE - privacymodelPackage.PRIVACY_MODEL__ROLE_LABEL_TYPE, null, msgs);
			if (newRoleLabelType != null)
				msgs = ((InternalEObject) newRoleLabelType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - privacymodelPackage.PRIVACY_MODEL__ROLE_LABEL_TYPE, null, msgs);
			msgs = basicSetRoleLabelType(newRoleLabelType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, privacymodelPackage.PRIVACY_MODEL__ROLE_LABEL_TYPE,
					newRoleLabelType, newRoleLabelType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionalityLabelType getFunctionalityLabelType() {
		return functionalityLabelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunctionalityLabelType(FunctionalityLabelType newFunctionalityLabelType,
			NotificationChain msgs) {
		FunctionalityLabelType oldFunctionalityLabelType = functionalityLabelType;
		functionalityLabelType = newFunctionalityLabelType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					privacymodelPackage.PRIVACY_MODEL__FUNCTIONALITY_LABEL_TYPE, oldFunctionalityLabelType,
					newFunctionalityLabelType);
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
	public void setFunctionalityLabelType(FunctionalityLabelType newFunctionalityLabelType) {
		if (newFunctionalityLabelType != functionalityLabelType) {
			NotificationChain msgs = null;
			if (functionalityLabelType != null)
				msgs = ((InternalEObject) functionalityLabelType).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - privacymodelPackage.PRIVACY_MODEL__FUNCTIONALITY_LABEL_TYPE, null,
						msgs);
			if (newFunctionalityLabelType != null)
				msgs = ((InternalEObject) newFunctionalityLabelType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - privacymodelPackage.PRIVACY_MODEL__FUNCTIONALITY_LABEL_TYPE, null,
						msgs);
			msgs = basicSetFunctionalityLabelType(newFunctionalityLabelType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					privacymodelPackage.PRIVACY_MODEL__FUNCTIONALITY_LABEL_TYPE, newFunctionalityLabelType,
					newFunctionalityLabelType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataItemLabelType> getDataItemLabelType() {
		if (dataItemLabelType == null) {
			dataItemLabelType = new EObjectContainmentEList<DataItemLabelType>(DataItemLabelType.class, this,
					privacymodelPackage.PRIVACY_MODEL__DATA_ITEM_LABEL_TYPE);
		}
		return dataItemLabelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataStateLabelType getDataStateLabelType() {
		return dataStateLabelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataStateLabelType(DataStateLabelType newDataStateLabelType,
			NotificationChain msgs) {
		DataStateLabelType oldDataStateLabelType = dataStateLabelType;
		dataStateLabelType = newDataStateLabelType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					privacymodelPackage.PRIVACY_MODEL__DATA_STATE_LABEL_TYPE, oldDataStateLabelType,
					newDataStateLabelType);
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
	public void setDataStateLabelType(DataStateLabelType newDataStateLabelType) {
		if (newDataStateLabelType != dataStateLabelType) {
			NotificationChain msgs = null;
			if (dataStateLabelType != null)
				msgs = ((InternalEObject) dataStateLabelType).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - privacymodelPackage.PRIVACY_MODEL__DATA_STATE_LABEL_TYPE, null, msgs);
			if (newDataStateLabelType != null)
				msgs = ((InternalEObject) newDataStateLabelType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - privacymodelPackage.PRIVACY_MODEL__DATA_STATE_LABEL_TYPE, null, msgs);
			msgs = basicSetDataStateLabelType(newDataStateLabelType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					privacymodelPackage.PRIVACY_MODEL__DATA_STATE_LABEL_TYPE, newDataStateLabelType,
					newDataStateLabelType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataContextLabelType getDataContextLabelType() {
		return dataContextLabelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataContextLabelType(DataContextLabelType newDataContextLabelType,
			NotificationChain msgs) {
		DataContextLabelType oldDataContextLabelType = dataContextLabelType;
		dataContextLabelType = newDataContextLabelType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					privacymodelPackage.PRIVACY_MODEL__DATA_CONTEXT_LABEL_TYPE, oldDataContextLabelType,
					newDataContextLabelType);
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
	public void setDataContextLabelType(DataContextLabelType newDataContextLabelType) {
		if (newDataContextLabelType != dataContextLabelType) {
			NotificationChain msgs = null;
			if (dataContextLabelType != null)
				msgs = ((InternalEObject) dataContextLabelType).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - privacymodelPackage.PRIVACY_MODEL__DATA_CONTEXT_LABEL_TYPE, null,
						msgs);
			if (newDataContextLabelType != null)
				msgs = ((InternalEObject) newDataContextLabelType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - privacymodelPackage.PRIVACY_MODEL__DATA_CONTEXT_LABEL_TYPE, null,
						msgs);
			msgs = basicSetDataContextLabelType(newDataContextLabelType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					privacymodelPackage.PRIVACY_MODEL__DATA_CONTEXT_LABEL_TYPE, newDataContextLabelType,
					newDataContextLabelType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case privacymodelPackage.PRIVACY_MODEL__ROLE_LABEL_TYPE:
			return basicSetRoleLabelType(null, msgs);
		case privacymodelPackage.PRIVACY_MODEL__FUNCTIONALITY_LABEL_TYPE:
			return basicSetFunctionalityLabelType(null, msgs);
		case privacymodelPackage.PRIVACY_MODEL__DATA_ITEM_LABEL_TYPE:
			return ((InternalEList<?>) getDataItemLabelType()).basicRemove(otherEnd, msgs);
		case privacymodelPackage.PRIVACY_MODEL__DATA_STATE_LABEL_TYPE:
			return basicSetDataStateLabelType(null, msgs);
		case privacymodelPackage.PRIVACY_MODEL__DATA_CONTEXT_LABEL_TYPE:
			return basicSetDataContextLabelType(null, msgs);
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
		case privacymodelPackage.PRIVACY_MODEL__ROLE_LABEL_TYPE:
			return getRoleLabelType();
		case privacymodelPackage.PRIVACY_MODEL__FUNCTIONALITY_LABEL_TYPE:
			return getFunctionalityLabelType();
		case privacymodelPackage.PRIVACY_MODEL__DATA_ITEM_LABEL_TYPE:
			return getDataItemLabelType();
		case privacymodelPackage.PRIVACY_MODEL__DATA_STATE_LABEL_TYPE:
			return getDataStateLabelType();
		case privacymodelPackage.PRIVACY_MODEL__DATA_CONTEXT_LABEL_TYPE:
			return getDataContextLabelType();
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
		case privacymodelPackage.PRIVACY_MODEL__ROLE_LABEL_TYPE:
			setRoleLabelType((RoleLabelType) newValue);
			return;
		case privacymodelPackage.PRIVACY_MODEL__FUNCTIONALITY_LABEL_TYPE:
			setFunctionalityLabelType((FunctionalityLabelType) newValue);
			return;
		case privacymodelPackage.PRIVACY_MODEL__DATA_ITEM_LABEL_TYPE:
			getDataItemLabelType().clear();
			getDataItemLabelType().addAll((Collection<? extends DataItemLabelType>) newValue);
			return;
		case privacymodelPackage.PRIVACY_MODEL__DATA_STATE_LABEL_TYPE:
			setDataStateLabelType((DataStateLabelType) newValue);
			return;
		case privacymodelPackage.PRIVACY_MODEL__DATA_CONTEXT_LABEL_TYPE:
			setDataContextLabelType((DataContextLabelType) newValue);
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
		case privacymodelPackage.PRIVACY_MODEL__ROLE_LABEL_TYPE:
			setRoleLabelType((RoleLabelType) null);
			return;
		case privacymodelPackage.PRIVACY_MODEL__FUNCTIONALITY_LABEL_TYPE:
			setFunctionalityLabelType((FunctionalityLabelType) null);
			return;
		case privacymodelPackage.PRIVACY_MODEL__DATA_ITEM_LABEL_TYPE:
			getDataItemLabelType().clear();
			return;
		case privacymodelPackage.PRIVACY_MODEL__DATA_STATE_LABEL_TYPE:
			setDataStateLabelType((DataStateLabelType) null);
			return;
		case privacymodelPackage.PRIVACY_MODEL__DATA_CONTEXT_LABEL_TYPE:
			setDataContextLabelType((DataContextLabelType) null);
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
		case privacymodelPackage.PRIVACY_MODEL__ROLE_LABEL_TYPE:
			return roleLabelType != null;
		case privacymodelPackage.PRIVACY_MODEL__FUNCTIONALITY_LABEL_TYPE:
			return functionalityLabelType != null;
		case privacymodelPackage.PRIVACY_MODEL__DATA_ITEM_LABEL_TYPE:
			return dataItemLabelType != null && !dataItemLabelType.isEmpty();
		case privacymodelPackage.PRIVACY_MODEL__DATA_STATE_LABEL_TYPE:
			return dataStateLabelType != null;
		case privacymodelPackage.PRIVACY_MODEL__DATA_CONTEXT_LABEL_TYPE:
			return dataContextLabelType != null;
		}
		return super.eIsSet(featureID);
	}

} //PrivacyModelImpl

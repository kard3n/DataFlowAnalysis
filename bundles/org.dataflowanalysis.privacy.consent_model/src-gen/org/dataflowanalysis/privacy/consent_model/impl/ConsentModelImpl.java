/**
 */
package org.dataflowanalysis.privacy.consent_model.impl;

import identifier.impl.EntityImpl;
import java.util.Collection;

import org.dataflowanalysis.privacy.consent_model.ConsentModel;
import org.dataflowanalysis.privacy.consent_model.Consent_modelPackage;
import org.dataflowanalysis.privacy.consent_model.ConsentedFunctionality;
import org.dataflowanalysis.privacy.consent_model.DataState;
import org.dataflowanalysis.privacy.consent_model.Role;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
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
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentModelImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentModelImpl#getFunctionalities <em>Functionalities</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentModelImpl#getData_states <em>Data states</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConsentModelImpl extends EntityImpl implements ConsentModel {
	/**
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<Role> roles;

	/**
	 * The cached value of the '{@link #getFunctionalities() <em>Functionalities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionalities()
	 * @generated
	 * @ordered
	 */
	protected EList<ConsentedFunctionality> functionalities;

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
	public EList<Role> getRoles() {
		if (roles == null) {
			roles = new EObjectContainmentEList<Role>(Role.class, this, Consent_modelPackage.CONSENT_MODEL__ROLES);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConsentedFunctionality> getFunctionalities() {
		if (functionalities == null) {
			functionalities = new EObjectContainmentEList<ConsentedFunctionality>(ConsentedFunctionality.class, this,
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Consent_modelPackage.CONSENT_MODEL__ROLES:
			return ((InternalEList<?>) getRoles()).basicRemove(otherEnd, msgs);
		case Consent_modelPackage.CONSENT_MODEL__FUNCTIONALITIES:
			return ((InternalEList<?>) getFunctionalities()).basicRemove(otherEnd, msgs);
		case Consent_modelPackage.CONSENT_MODEL__DATA_STATES:
			return ((InternalEList<?>) getData_states()).basicRemove(otherEnd, msgs);
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
		case Consent_modelPackage.CONSENT_MODEL__ROLES:
			return getRoles();
		case Consent_modelPackage.CONSENT_MODEL__FUNCTIONALITIES:
			return getFunctionalities();
		case Consent_modelPackage.CONSENT_MODEL__DATA_STATES:
			return getData_states();
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
		case Consent_modelPackage.CONSENT_MODEL__ROLES:
			getRoles().clear();
			getRoles().addAll((Collection<? extends Role>) newValue);
			return;
		case Consent_modelPackage.CONSENT_MODEL__FUNCTIONALITIES:
			getFunctionalities().clear();
			getFunctionalities().addAll((Collection<? extends ConsentedFunctionality>) newValue);
			return;
		case Consent_modelPackage.CONSENT_MODEL__DATA_STATES:
			getData_states().clear();
			getData_states().addAll((Collection<? extends DataState>) newValue);
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
		case Consent_modelPackage.CONSENT_MODEL__ROLES:
			getRoles().clear();
			return;
		case Consent_modelPackage.CONSENT_MODEL__FUNCTIONALITIES:
			getFunctionalities().clear();
			return;
		case Consent_modelPackage.CONSENT_MODEL__DATA_STATES:
			getData_states().clear();
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
		case Consent_modelPackage.CONSENT_MODEL__ROLES:
			return roles != null && !roles.isEmpty();
		case Consent_modelPackage.CONSENT_MODEL__FUNCTIONALITIES:
			return functionalities != null && !functionalities.isEmpty();
		case Consent_modelPackage.CONSENT_MODEL__DATA_STATES:
			return data_states != null && !data_states.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConsentModelImpl

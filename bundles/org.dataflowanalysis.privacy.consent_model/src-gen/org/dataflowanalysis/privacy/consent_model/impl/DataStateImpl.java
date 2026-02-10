/**
 */
package org.dataflowanalysis.privacy.consent_model.impl;

import identifier.impl.EntityImpl;
import java.util.Collection;

import org.dataflowanalysis.privacy.consent_model.Consent_modelPackage;
import org.dataflowanalysis.privacy.consent_model.DataState;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.impl.DataStateImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.impl.DataStateImpl#getNotRelatableWith <em>Not Relatable With</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataStateImpl extends EntityImpl implements DataState {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNotRelatableWith() <em>Not Relatable With</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotRelatableWith()
	 * @generated
	 * @ordered
	 */
	protected EList<DataState> notRelatableWith;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Consent_modelPackage.Literals.DATA_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Consent_modelPackage.DATA_STATE__NAME, oldName,
					name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataState> getNotRelatableWith() {
		if (notRelatableWith == null) {
			notRelatableWith = new EObjectResolvingEList<DataState>(DataState.class, this,
					Consent_modelPackage.DATA_STATE__NOT_RELATABLE_WITH);
		}
		return notRelatableWith;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Consent_modelPackage.DATA_STATE__NAME:
			return getName();
		case Consent_modelPackage.DATA_STATE__NOT_RELATABLE_WITH:
			return getNotRelatableWith();
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
		case Consent_modelPackage.DATA_STATE__NAME:
			setName((String) newValue);
			return;
		case Consent_modelPackage.DATA_STATE__NOT_RELATABLE_WITH:
			getNotRelatableWith().clear();
			getNotRelatableWith().addAll((Collection<? extends DataState>) newValue);
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
		case Consent_modelPackage.DATA_STATE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case Consent_modelPackage.DATA_STATE__NOT_RELATABLE_WITH:
			getNotRelatableWith().clear();
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
		case Consent_modelPackage.DATA_STATE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case Consent_modelPackage.DATA_STATE__NOT_RELATABLE_WITH:
			return notRelatableWith != null && !notRelatableWith.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //DataStateImpl

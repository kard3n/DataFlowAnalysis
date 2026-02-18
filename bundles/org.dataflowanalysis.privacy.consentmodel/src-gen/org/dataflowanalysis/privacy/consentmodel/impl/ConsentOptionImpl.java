/**
 */
package org.dataflowanalysis.privacy.consentmodel.impl;

import java.util.Collection;

import org.dataflowanalysis.privacy.consentmodel.ConsentOption;
import org.dataflowanalysis.privacy.consentmodel.UserDataCombination;
import org.dataflowanalysis.privacy.consentmodel.consentmodelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tools.mdsd.modelingfoundations.identifier.impl.EntityImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Consent Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.impl.ConsentOptionImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.impl.ConsentOptionImpl#getExcludes <em>Excludes</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.impl.ConsentOptionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.impl.ConsentOptionImpl#getAllowsFor <em>Allows For</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConsentOptionImpl extends EntityImpl implements ConsentOption {
	/**
	 * The cached value of the '{@link #getRequires() <em>Requires</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequires()
	 * @generated
	 * @ordered
	 */
	protected EList<ConsentOption> requires;

	/**
	 * The cached value of the '{@link #getExcludes() <em>Excludes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExcludes()
	 * @generated
	 * @ordered
	 */
	protected EList<ConsentOption> excludes;

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
	 * The cached value of the '{@link #getAllowsFor() <em>Allows For</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllowsFor()
	 * @generated
	 * @ordered
	 */
	protected EList<UserDataCombination> allowsFor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConsentOptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return consentmodelPackage.Literals.CONSENT_OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConsentOption> getRequires() {
		if (requires == null) {
			requires = new EObjectResolvingEList<ConsentOption>(ConsentOption.class, this,
					consentmodelPackage.CONSENT_OPTION__REQUIRES);
		}
		return requires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConsentOption> getExcludes() {
		if (excludes == null) {
			excludes = new EObjectResolvingEList<ConsentOption>(ConsentOption.class, this,
					consentmodelPackage.CONSENT_OPTION__EXCLUDES);
		}
		return excludes;
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
			eNotify(new ENotificationImpl(this, Notification.SET, consentmodelPackage.CONSENT_OPTION__NAME, oldName,
					name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UserDataCombination> getAllowsFor() {
		if (allowsFor == null) {
			allowsFor = new EObjectContainmentEList<UserDataCombination>(UserDataCombination.class, this,
					consentmodelPackage.CONSENT_OPTION__ALLOWS_FOR);
		}
		return allowsFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case consentmodelPackage.CONSENT_OPTION__ALLOWS_FOR:
			return ((InternalEList<?>) getAllowsFor()).basicRemove(otherEnd, msgs);
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
		case consentmodelPackage.CONSENT_OPTION__REQUIRES:
			return getRequires();
		case consentmodelPackage.CONSENT_OPTION__EXCLUDES:
			return getExcludes();
		case consentmodelPackage.CONSENT_OPTION__NAME:
			return getName();
		case consentmodelPackage.CONSENT_OPTION__ALLOWS_FOR:
			return getAllowsFor();
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
		case consentmodelPackage.CONSENT_OPTION__REQUIRES:
			getRequires().clear();
			getRequires().addAll((Collection<? extends ConsentOption>) newValue);
			return;
		case consentmodelPackage.CONSENT_OPTION__EXCLUDES:
			getExcludes().clear();
			getExcludes().addAll((Collection<? extends ConsentOption>) newValue);
			return;
		case consentmodelPackage.CONSENT_OPTION__NAME:
			setName((String) newValue);
			return;
		case consentmodelPackage.CONSENT_OPTION__ALLOWS_FOR:
			getAllowsFor().clear();
			getAllowsFor().addAll((Collection<? extends UserDataCombination>) newValue);
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
		case consentmodelPackage.CONSENT_OPTION__REQUIRES:
			getRequires().clear();
			return;
		case consentmodelPackage.CONSENT_OPTION__EXCLUDES:
			getExcludes().clear();
			return;
		case consentmodelPackage.CONSENT_OPTION__NAME:
			setName(NAME_EDEFAULT);
			return;
		case consentmodelPackage.CONSENT_OPTION__ALLOWS_FOR:
			getAllowsFor().clear();
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
		case consentmodelPackage.CONSENT_OPTION__REQUIRES:
			return requires != null && !requires.isEmpty();
		case consentmodelPackage.CONSENT_OPTION__EXCLUDES:
			return excludes != null && !excludes.isEmpty();
		case consentmodelPackage.CONSENT_OPTION__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case consentmodelPackage.CONSENT_OPTION__ALLOWS_FOR:
			return allowsFor != null && !allowsFor.isEmpty();
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

} //ConsentOptionImpl

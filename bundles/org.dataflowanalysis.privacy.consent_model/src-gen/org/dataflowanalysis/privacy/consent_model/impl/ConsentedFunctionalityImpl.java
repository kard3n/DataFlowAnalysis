/**
 */
package org.dataflowanalysis.privacy.consent_model.impl;

import identifier.impl.EntityImpl;
import java.util.Collection;

import org.dataflowanalysis.privacy.consent_model.Consent_modelPackage;
import org.dataflowanalysis.privacy.consent_model.ConsentedFunctionality;
import org.dataflowanalysis.privacy.consent_model.UserDataCombination;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Consented Functionality</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentedFunctionalityImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentedFunctionalityImpl#getExcludes <em>Excludes</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentedFunctionalityImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentedFunctionalityImpl#getAllowsFor <em>Allows For</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConsentedFunctionalityImpl extends EntityImpl implements ConsentedFunctionality {
	/**
	 * The cached value of the '{@link #getRequires() <em>Requires</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequires()
	 * @generated
	 * @ordered
	 */
	protected EList<ConsentedFunctionality> requires;

	/**
	 * The cached value of the '{@link #getExcludes() <em>Excludes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExcludes()
	 * @generated
	 * @ordered
	 */
	protected EList<ConsentedFunctionality> excludes;

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
	protected ConsentedFunctionalityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Consent_modelPackage.Literals.CONSENTED_FUNCTIONALITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConsentedFunctionality> getRequires() {
		if (requires == null) {
			requires = new EObjectResolvingEList<ConsentedFunctionality>(ConsentedFunctionality.class, this,
					Consent_modelPackage.CONSENTED_FUNCTIONALITY__REQUIRES);
		}
		return requires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConsentedFunctionality> getExcludes() {
		if (excludes == null) {
			excludes = new EObjectResolvingEList<ConsentedFunctionality>(ConsentedFunctionality.class, this,
					Consent_modelPackage.CONSENTED_FUNCTIONALITY__EXCLUDES);
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
			eNotify(new ENotificationImpl(this, Notification.SET, Consent_modelPackage.CONSENTED_FUNCTIONALITY__NAME,
					oldName, name));
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
					Consent_modelPackage.CONSENTED_FUNCTIONALITY__ALLOWS_FOR);
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
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY__ALLOWS_FOR:
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
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY__REQUIRES:
			return getRequires();
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY__EXCLUDES:
			return getExcludes();
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY__NAME:
			return getName();
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY__ALLOWS_FOR:
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
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY__REQUIRES:
			getRequires().clear();
			getRequires().addAll((Collection<? extends ConsentedFunctionality>) newValue);
			return;
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY__EXCLUDES:
			getExcludes().clear();
			getExcludes().addAll((Collection<? extends ConsentedFunctionality>) newValue);
			return;
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY__NAME:
			setName((String) newValue);
			return;
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY__ALLOWS_FOR:
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
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY__REQUIRES:
			getRequires().clear();
			return;
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY__EXCLUDES:
			getExcludes().clear();
			return;
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY__NAME:
			setName(NAME_EDEFAULT);
			return;
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY__ALLOWS_FOR:
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
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY__REQUIRES:
			return requires != null && !requires.isEmpty();
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY__EXCLUDES:
			return excludes != null && !excludes.isEmpty();
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY__ALLOWS_FOR:
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

} //ConsentedFunctionalityImpl

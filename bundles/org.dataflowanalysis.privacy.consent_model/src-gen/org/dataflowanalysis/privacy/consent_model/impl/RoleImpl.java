/**
 */
package org.dataflowanalysis.privacy.consent_model.impl;

import identifier.impl.EntityImpl;
import java.util.Collection;

import org.dataflowanalysis.privacy.consent_model.ConsentOption;
import org.dataflowanalysis.privacy.consent_model.Consent_modelPackage;
import org.dataflowanalysis.privacy.consent_model.Role;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.impl.RoleImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.impl.RoleImpl#getAllows <em>Allows</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoleImpl extends EntityImpl implements Role {
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
	 * The cached value of the '{@link #getAllows() <em>Allows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllows()
	 * @generated
	 * @ordered
	 */
	protected EList<ConsentOption> allows;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Consent_modelPackage.Literals.ROLE;
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
					Consent_modelPackage.ROLE__REQUIRES);
		}
		return requires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ConsentOption> getAllows() {
		if (allows == null) {
			allows = new EObjectResolvingEList<ConsentOption>(ConsentOption.class, this,
					Consent_modelPackage.ROLE__ALLOWS);
		}
		return allows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Consent_modelPackage.ROLE__REQUIRES:
			return getRequires();
		case Consent_modelPackage.ROLE__ALLOWS:
			return getAllows();
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
		case Consent_modelPackage.ROLE__REQUIRES:
			getRequires().clear();
			getRequires().addAll((Collection<? extends ConsentOption>) newValue);
			return;
		case Consent_modelPackage.ROLE__ALLOWS:
			getAllows().clear();
			getAllows().addAll((Collection<? extends ConsentOption>) newValue);
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
		case Consent_modelPackage.ROLE__REQUIRES:
			getRequires().clear();
			return;
		case Consent_modelPackage.ROLE__ALLOWS:
			getAllows().clear();
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
		case Consent_modelPackage.ROLE__REQUIRES:
			return requires != null && !requires.isEmpty();
		case Consent_modelPackage.ROLE__ALLOWS:
			return allows != null && !allows.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RoleImpl

/**
 */
package org.dataflowanalysis.privacy.privacymodel.impl;

import java.util.Collection;

import org.dataflowanalysis.privacy.privacymodel.Functionality;
import org.dataflowanalysis.privacy.privacymodel.Role;
import org.dataflowanalysis.privacy.privacymodel.privacymodelPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import tools.mdsd.modelingfoundations.identifier.impl.EntityImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.impl.RoleImpl#getAlwaysAllows <em>Always Allows</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.impl.RoleImpl#getOptionallyAllows <em>Optionally Allows</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoleImpl extends EntityImpl implements Role {
	/**
	 * The cached value of the '{@link #getAlwaysAllows() <em>Always Allows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlwaysAllows()
	 * @generated
	 * @ordered
	 */
	protected EList<Functionality> alwaysAllows;

	/**
	 * The cached value of the '{@link #getOptionallyAllows() <em>Optionally Allows</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionallyAllows()
	 * @generated
	 * @ordered
	 */
	protected EList<Functionality> optionallyAllows;

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
		return privacymodelPackage.Literals.ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Functionality> getAlwaysAllows() {
		if (alwaysAllows == null) {
			alwaysAllows = new EObjectResolvingEList<Functionality>(Functionality.class, this,
					privacymodelPackage.ROLE__ALWAYS_ALLOWS);
		}
		return alwaysAllows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Functionality> getOptionallyAllows() {
		if (optionallyAllows == null) {
			optionallyAllows = new EObjectResolvingEList<Functionality>(Functionality.class, this,
					privacymodelPackage.ROLE__OPTIONALLY_ALLOWS);
		}
		return optionallyAllows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case privacymodelPackage.ROLE__ALWAYS_ALLOWS:
			return getAlwaysAllows();
		case privacymodelPackage.ROLE__OPTIONALLY_ALLOWS:
			return getOptionallyAllows();
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
		case privacymodelPackage.ROLE__ALWAYS_ALLOWS:
			getAlwaysAllows().clear();
			getAlwaysAllows().addAll((Collection<? extends Functionality>) newValue);
			return;
		case privacymodelPackage.ROLE__OPTIONALLY_ALLOWS:
			getOptionallyAllows().clear();
			getOptionallyAllows().addAll((Collection<? extends Functionality>) newValue);
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
		case privacymodelPackage.ROLE__ALWAYS_ALLOWS:
			getAlwaysAllows().clear();
			return;
		case privacymodelPackage.ROLE__OPTIONALLY_ALLOWS:
			getOptionallyAllows().clear();
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
		case privacymodelPackage.ROLE__ALWAYS_ALLOWS:
			return alwaysAllows != null && !alwaysAllows.isEmpty();
		case privacymodelPackage.ROLE__OPTIONALLY_ALLOWS:
			return optionallyAllows != null && !optionallyAllows.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RoleImpl

/**
 */
package org.dataflowanalysis.privacy.consentmodel.impl;

import java.util.Collection;

import org.dataflowanalysis.privacy.consentmodel.ConsentOption;
import org.dataflowanalysis.privacy.consentmodel.Role;
import org.dataflowanalysis.privacy.consentmodel.consentmodelPackage;
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
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.impl.RoleImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.impl.RoleImpl#getAllows <em>Allows</em>}</li>
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
		return consentmodelPackage.Literals.ROLE;
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
					consentmodelPackage.ROLE__REQUIRES);
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
					consentmodelPackage.ROLE__ALLOWS);
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
		case consentmodelPackage.ROLE__REQUIRES:
			return getRequires();
		case consentmodelPackage.ROLE__ALLOWS:
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
		case consentmodelPackage.ROLE__REQUIRES:
			getRequires().clear();
			getRequires().addAll((Collection<? extends ConsentOption>) newValue);
			return;
		case consentmodelPackage.ROLE__ALLOWS:
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
		case consentmodelPackage.ROLE__REQUIRES:
			getRequires().clear();
			return;
		case consentmodelPackage.ROLE__ALLOWS:
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
		case consentmodelPackage.ROLE__REQUIRES:
			return requires != null && !requires.isEmpty();
		case consentmodelPackage.ROLE__ALLOWS:
			return allows != null && !allows.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RoleImpl

/**
 */
package org.dataflowanalysis.privacy.privacymodel.impl;

import java.util.Collection;

import org.dataflowanalysis.privacy.privacymodel.Functionality;
import org.dataflowanalysis.privacy.privacymodel.UserDataCombination;
import org.dataflowanalysis.privacy.privacymodel.privacymodelPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tools.mdsd.modelingfoundations.identifier.impl.EntityImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Functionality</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.impl.FunctionalityImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.impl.FunctionalityImpl#getExcludes <em>Excludes</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.impl.FunctionalityImpl#getAllowsFor <em>Allows For</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionalityImpl extends EntityImpl implements Functionality {
	/**
	 * The cached value of the '{@link #getRequires() <em>Requires</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequires()
	 * @generated
	 * @ordered
	 */
	protected EList<Functionality> requires;

	/**
	 * The cached value of the '{@link #getExcludes() <em>Excludes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExcludes()
	 * @generated
	 * @ordered
	 */
	protected EList<Functionality> excludes;

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
	protected FunctionalityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return privacymodelPackage.Literals.FUNCTIONALITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Functionality> getRequires() {
		if (requires == null) {
			requires = new EObjectResolvingEList<Functionality>(Functionality.class, this,
					privacymodelPackage.FUNCTIONALITY__REQUIRES);
		}
		return requires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Functionality> getExcludes() {
		if (excludes == null) {
			excludes = new EObjectResolvingEList<Functionality>(Functionality.class, this,
					privacymodelPackage.FUNCTIONALITY__EXCLUDES);
		}
		return excludes;
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
					privacymodelPackage.FUNCTIONALITY__ALLOWS_FOR);
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
		case privacymodelPackage.FUNCTIONALITY__ALLOWS_FOR:
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
		case privacymodelPackage.FUNCTIONALITY__REQUIRES:
			return getRequires();
		case privacymodelPackage.FUNCTIONALITY__EXCLUDES:
			return getExcludes();
		case privacymodelPackage.FUNCTIONALITY__ALLOWS_FOR:
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
		case privacymodelPackage.FUNCTIONALITY__REQUIRES:
			getRequires().clear();
			getRequires().addAll((Collection<? extends Functionality>) newValue);
			return;
		case privacymodelPackage.FUNCTIONALITY__EXCLUDES:
			getExcludes().clear();
			getExcludes().addAll((Collection<? extends Functionality>) newValue);
			return;
		case privacymodelPackage.FUNCTIONALITY__ALLOWS_FOR:
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
		case privacymodelPackage.FUNCTIONALITY__REQUIRES:
			getRequires().clear();
			return;
		case privacymodelPackage.FUNCTIONALITY__EXCLUDES:
			getExcludes().clear();
			return;
		case privacymodelPackage.FUNCTIONALITY__ALLOWS_FOR:
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
		case privacymodelPackage.FUNCTIONALITY__REQUIRES:
			return requires != null && !requires.isEmpty();
		case privacymodelPackage.FUNCTIONALITY__EXCLUDES:
			return excludes != null && !excludes.isEmpty();
		case privacymodelPackage.FUNCTIONALITY__ALLOWS_FOR:
			return allowsFor != null && !allowsFor.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FunctionalityImpl

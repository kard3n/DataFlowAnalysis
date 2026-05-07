/**
 */
package org.dataflowanalysis.privacy.privacymodel.impl;

import java.util.Collection;

import org.dataflowanalysis.privacy.privacymodel.DataState;
import org.dataflowanalysis.privacy.privacymodel.privacymodelPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import tools.mdsd.modelingfoundations.identifier.impl.EntityImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.impl.DataStateImpl#getNotRelatableWith <em>Not Relatable With</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataStateImpl extends EntityImpl implements DataState {
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
		return privacymodelPackage.Literals.DATA_STATE;
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
					privacymodelPackage.DATA_STATE__NOT_RELATABLE_WITH);
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
		case privacymodelPackage.DATA_STATE__NOT_RELATABLE_WITH:
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
		case privacymodelPackage.DATA_STATE__NOT_RELATABLE_WITH:
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
		case privacymodelPackage.DATA_STATE__NOT_RELATABLE_WITH:
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
		case privacymodelPackage.DATA_STATE__NOT_RELATABLE_WITH:
			return notRelatableWith != null && !notRelatableWith.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataStateImpl

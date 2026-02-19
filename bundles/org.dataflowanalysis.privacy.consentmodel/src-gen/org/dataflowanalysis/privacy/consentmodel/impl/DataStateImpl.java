/**
 */
package org.dataflowanalysis.privacy.consentmodel.impl;

import java.util.Collection;

import org.dataflowanalysis.privacy.consentmodel.DataState;
import org.dataflowanalysis.privacy.consentmodel.consentmodelPackage;
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
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.impl.DataStateImpl#getNotRelatableWith <em>Not Relatable With</em>}</li>
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
		return consentmodelPackage.Literals.DATA_STATE;
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
					consentmodelPackage.DATA_STATE__NOT_RELATABLE_WITH);
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
		case consentmodelPackage.DATA_STATE__NOT_RELATABLE_WITH:
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
		case consentmodelPackage.DATA_STATE__NOT_RELATABLE_WITH:
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
		case consentmodelPackage.DATA_STATE__NOT_RELATABLE_WITH:
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
		case consentmodelPackage.DATA_STATE__NOT_RELATABLE_WITH:
			return notRelatableWith != null && !notRelatableWith.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DataStateImpl

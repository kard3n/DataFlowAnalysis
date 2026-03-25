/**
 */
package org.dataflowanalysis.privacy.consentmodel.impl;

import org.dataflowanalysis.dfd.datadictionary.impl.AbstractLabelImpl;

import org.dataflowanalysis.privacy.consentmodel.DataContext;
import org.dataflowanalysis.privacy.consentmodel.DataContextLabel;
import org.dataflowanalysis.privacy.consentmodel.consentmodelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Context Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consentmodel.impl.DataContextLabelImpl#getDataContext <em>Data Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataContextLabelImpl extends AbstractLabelImpl implements DataContextLabel {
	/**
	 * The cached value of the '{@link #getDataContext() <em>Data Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataContext()
	 * @generated
	 * @ordered
	 */
	protected DataContext dataContext;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataContextLabelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return consentmodelPackage.Literals.DATA_CONTEXT_LABEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataContext getDataContext() {
		return dataContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataContext(DataContext newDataContext, NotificationChain msgs) {
		DataContext oldDataContext = dataContext;
		dataContext = newDataContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					consentmodelPackage.DATA_CONTEXT_LABEL__DATA_CONTEXT, oldDataContext, newDataContext);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataContext(DataContext newDataContext) {
		if (newDataContext != dataContext) {
			NotificationChain msgs = null;
			if (dataContext != null)
				msgs = ((InternalEObject) dataContext).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - consentmodelPackage.DATA_CONTEXT_LABEL__DATA_CONTEXT, null, msgs);
			if (newDataContext != null)
				msgs = ((InternalEObject) newDataContext).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - consentmodelPackage.DATA_CONTEXT_LABEL__DATA_CONTEXT, null, msgs);
			msgs = basicSetDataContext(newDataContext, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, consentmodelPackage.DATA_CONTEXT_LABEL__DATA_CONTEXT,
					newDataContext, newDataContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case consentmodelPackage.DATA_CONTEXT_LABEL__DATA_CONTEXT:
			return basicSetDataContext(null, msgs);
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
		case consentmodelPackage.DATA_CONTEXT_LABEL__DATA_CONTEXT:
			return getDataContext();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case consentmodelPackage.DATA_CONTEXT_LABEL__DATA_CONTEXT:
			setDataContext((DataContext) newValue);
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
		case consentmodelPackage.DATA_CONTEXT_LABEL__DATA_CONTEXT:
			setDataContext((DataContext) null);
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
		case consentmodelPackage.DATA_CONTEXT_LABEL__DATA_CONTEXT:
			return dataContext != null;
		}
		return super.eIsSet(featureID);
	}

} //DataContextLabelImpl

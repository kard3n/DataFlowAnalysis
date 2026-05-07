/**
 */
package org.dataflowanalysis.privacy.privacymodel.impl;

import java.util.Collection;

import org.dataflowanalysis.privacy.privacymodel.DataContext;
import org.dataflowanalysis.privacy.privacymodel.DataItem;
import org.dataflowanalysis.privacy.privacymodel.DataState;
import org.dataflowanalysis.privacy.privacymodel.StatefulItem;
import org.dataflowanalysis.privacy.privacymodel.privacymodelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stateful Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.impl.StatefulItemImpl#getState <em>State</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.impl.StatefulItemImpl#getItem <em>Item</em>}</li>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.impl.StatefulItemImpl#getContext <em>Context</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StatefulItemImpl extends MinimalEObjectImpl.Container implements StatefulItem {
	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected EList<DataState> state;

	/**
	 * The cached value of the '{@link #getItem() <em>Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItem()
	 * @generated
	 * @ordered
	 */
	protected DataItem item;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected EList<DataContext> context;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatefulItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return privacymodelPackage.Literals.STATEFUL_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataState> getState() {
		if (state == null) {
			state = new EObjectResolvingEList<DataState>(DataState.class, this,
					privacymodelPackage.STATEFUL_ITEM__STATE);
		}
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataItem getItem() {
		if (item != null && item.eIsProxy()) {
			InternalEObject oldItem = (InternalEObject) item;
			item = (DataItem) eResolveProxy(oldItem);
			if (item != oldItem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, privacymodelPackage.STATEFUL_ITEM__ITEM,
							oldItem, item));
			}
		}
		return item;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataItem basicGetItem() {
		return item;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setItem(DataItem newItem) {
		DataItem oldItem = item;
		item = newItem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, privacymodelPackage.STATEFUL_ITEM__ITEM, oldItem,
					item));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataContext> getContext() {
		if (context == null) {
			context = new EObjectResolvingEList<DataContext>(DataContext.class, this,
					privacymodelPackage.STATEFUL_ITEM__CONTEXT);
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case privacymodelPackage.STATEFUL_ITEM__STATE:
			return getState();
		case privacymodelPackage.STATEFUL_ITEM__ITEM:
			if (resolve)
				return getItem();
			return basicGetItem();
		case privacymodelPackage.STATEFUL_ITEM__CONTEXT:
			return getContext();
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
		case privacymodelPackage.STATEFUL_ITEM__STATE:
			getState().clear();
			getState().addAll((Collection<? extends DataState>) newValue);
			return;
		case privacymodelPackage.STATEFUL_ITEM__ITEM:
			setItem((DataItem) newValue);
			return;
		case privacymodelPackage.STATEFUL_ITEM__CONTEXT:
			getContext().clear();
			getContext().addAll((Collection<? extends DataContext>) newValue);
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
		case privacymodelPackage.STATEFUL_ITEM__STATE:
			getState().clear();
			return;
		case privacymodelPackage.STATEFUL_ITEM__ITEM:
			setItem((DataItem) null);
			return;
		case privacymodelPackage.STATEFUL_ITEM__CONTEXT:
			getContext().clear();
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
		case privacymodelPackage.STATEFUL_ITEM__STATE:
			return state != null && !state.isEmpty();
		case privacymodelPackage.STATEFUL_ITEM__ITEM:
			return item != null;
		case privacymodelPackage.STATEFUL_ITEM__CONTEXT:
			return context != null && !context.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StatefulItemImpl

/**
 */
package org.dataflowanalysis.privacy.privacymodel.impl;

import org.dataflowanalysis.privacy.privacymodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class privacymodelFactoryImpl extends EFactoryImpl implements privacymodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static privacymodelFactory init() {
		try {
			privacymodelFactory theprivacymodelFactory = (privacymodelFactory) EPackage.Registry.INSTANCE
					.getEFactory(privacymodelPackage.eNS_URI);
			if (theprivacymodelFactory != null) {
				return theprivacymodelFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new privacymodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public privacymodelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case privacymodelPackage.DATA_ITEM:
			return createDataItem();
		case privacymodelPackage.DATA_STATE:
			return createDataState();
		case privacymodelPackage.USER_DATA_COMBINATION:
			return createUserDataCombination();
		case privacymodelPackage.FUNCTIONALITY:
			return createFunctionality();
		case privacymodelPackage.ROLE:
			return createRole();
		case privacymodelPackage.PRIVACY_MODEL:
			return createPrivacyModel();
		case privacymodelPackage.ROLE_LABEL_TYPE:
			return createRoleLabelType();
		case privacymodelPackage.FUNCTIONALITY_LABEL_TYPE:
			return createFunctionalityLabelType();
		case privacymodelPackage.ROLE_LABEL:
			return createRoleLabel();
		case privacymodelPackage.FUNCTIONALITY_LABEL:
			return createFunctionalityLabel();
		case privacymodelPackage.DATA_ITEM_LABEL_TYPE:
			return createDataItemLabelType();
		case privacymodelPackage.DATA_ITEM_LABEL:
			return createDataItemLabel();
		case privacymodelPackage.STATEFUL_ITEM:
			return createStatefulItem();
		case privacymodelPackage.DATA_STATE_LABEL_TYPE:
			return createDataStateLabelType();
		case privacymodelPackage.DATA_STATE_LABEL:
			return createDataStateLabel();
		case privacymodelPackage.DATA_CONTEXT_LABEL_TYPE:
			return createDataContextLabelType();
		case privacymodelPackage.DATA_CONTEXT_LABEL:
			return createDataContextLabel();
		case privacymodelPackage.DATA_CONTEXT:
			return createDataContext();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataItem createDataItem() {
		DataItemImpl dataItem = new DataItemImpl();
		return dataItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataState createDataState() {
		DataStateImpl dataState = new DataStateImpl();
		return dataState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UserDataCombination createUserDataCombination() {
		UserDataCombinationImpl userDataCombination = new UserDataCombinationImpl();
		return userDataCombination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Functionality createFunctionality() {
		FunctionalityImpl functionality = new FunctionalityImpl();
		return functionality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Role createRole() {
		RoleImpl role = new RoleImpl();
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrivacyModel createPrivacyModel() {
		PrivacyModelImpl privacyModel = new PrivacyModelImpl();
		return privacyModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RoleLabelType createRoleLabelType() {
		RoleLabelTypeImpl roleLabelType = new RoleLabelTypeImpl();
		return roleLabelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionalityLabelType createFunctionalityLabelType() {
		FunctionalityLabelTypeImpl functionalityLabelType = new FunctionalityLabelTypeImpl();
		return functionalityLabelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RoleLabel createRoleLabel() {
		RoleLabelImpl roleLabel = new RoleLabelImpl();
		return roleLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionalityLabel createFunctionalityLabel() {
		FunctionalityLabelImpl functionalityLabel = new FunctionalityLabelImpl();
		return functionalityLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataItemLabelType createDataItemLabelType() {
		DataItemLabelTypeImpl dataItemLabelType = new DataItemLabelTypeImpl();
		return dataItemLabelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataItemLabel createDataItemLabel() {
		DataItemLabelImpl dataItemLabel = new DataItemLabelImpl();
		return dataItemLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StatefulItem createStatefulItem() {
		StatefulItemImpl statefulItem = new StatefulItemImpl();
		return statefulItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataStateLabelType createDataStateLabelType() {
		DataStateLabelTypeImpl dataStateLabelType = new DataStateLabelTypeImpl();
		return dataStateLabelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataStateLabel createDataStateLabel() {
		DataStateLabelImpl dataStateLabel = new DataStateLabelImpl();
		return dataStateLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataContextLabelType createDataContextLabelType() {
		DataContextLabelTypeImpl dataContextLabelType = new DataContextLabelTypeImpl();
		return dataContextLabelType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataContextLabel createDataContextLabel() {
		DataContextLabelImpl dataContextLabel = new DataContextLabelImpl();
		return dataContextLabel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataContext createDataContext() {
		DataContextImpl dataContext = new DataContextImpl();
		return dataContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public privacymodelPackage getprivacymodelPackage() {
		return (privacymodelPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static privacymodelPackage getPackage() {
		return privacymodelPackage.eINSTANCE;
	}

} //privacymodelFactoryImpl

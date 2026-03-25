/**
 */
package org.dataflowanalysis.privacy.consentmodel.impl;

import org.dataflowanalysis.privacy.consentmodel.*;

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
public class consentmodelFactoryImpl extends EFactoryImpl implements consentmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static consentmodelFactory init() {
		try {
			consentmodelFactory theconsentmodelFactory = (consentmodelFactory) EPackage.Registry.INSTANCE
					.getEFactory(consentmodelPackage.eNS_URI);
			if (theconsentmodelFactory != null) {
				return theconsentmodelFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new consentmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public consentmodelFactoryImpl() {
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
		case consentmodelPackage.DATA_ITEM:
			return createDataItem();
		case consentmodelPackage.DATA_STATE:
			return createDataState();
		case consentmodelPackage.USER_DATA_COMBINATION:
			return createUserDataCombination();
		case consentmodelPackage.CONSENT_OPTION:
			return createConsentOption();
		case consentmodelPackage.ROLE:
			return createRole();
		case consentmodelPackage.CONSENT_MODEL:
			return createConsentModel();
		case consentmodelPackage.ROLE_LABEL_TYPE:
			return createRoleLabelType();
		case consentmodelPackage.CONSENT_LABEL_TYPE:
			return createConsentLabelType();
		case consentmodelPackage.ROLE_LABEL:
			return createRoleLabel();
		case consentmodelPackage.CONSENT_LABEL:
			return createConsentLabel();
		case consentmodelPackage.DATA_ITEM_LABEL_TYPE:
			return createDataItemLabelType();
		case consentmodelPackage.DATA_ITEM_LABEL:
			return createDataItemLabel();
		case consentmodelPackage.STATEFUL_ITEM:
			return createStatefulItem();
		case consentmodelPackage.DATA_STATE_LABEL_TYPE:
			return createDataStateLabelType();
		case consentmodelPackage.DATA_STATE_LABEL:
			return createDataStateLabel();
		case consentmodelPackage.DATA_CONTEXT_LABEL_TYPE:
			return createDataContextLabelType();
		case consentmodelPackage.DATA_CONTEXT_LABEL:
			return createDataContextLabel();
		case consentmodelPackage.DATA_CONTEXT:
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
	public ConsentOption createConsentOption() {
		ConsentOptionImpl consentOption = new ConsentOptionImpl();
		return consentOption;
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
	public ConsentModel createConsentModel() {
		ConsentModelImpl consentModel = new ConsentModelImpl();
		return consentModel;
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
	public ConsentLabelType createConsentLabelType() {
		ConsentLabelTypeImpl consentLabelType = new ConsentLabelTypeImpl();
		return consentLabelType;
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
	public ConsentLabel createConsentLabel() {
		ConsentLabelImpl consentLabel = new ConsentLabelImpl();
		return consentLabel;
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
	public consentmodelPackage getconsentmodelPackage() {
		return (consentmodelPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static consentmodelPackage getPackage() {
		return consentmodelPackage.eINSTANCE;
	}

} //consentmodelFactoryImpl

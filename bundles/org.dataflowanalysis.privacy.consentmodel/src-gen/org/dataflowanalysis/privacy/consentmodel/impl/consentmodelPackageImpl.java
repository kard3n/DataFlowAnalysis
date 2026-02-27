/**
 */
package org.dataflowanalysis.privacy.consentmodel.impl;

import org.dataflowanalysis.dfd.datadictionary.datadictionaryPackage;

import org.dataflowanalysis.privacy.consentmodel.ConsentLabel;
import org.dataflowanalysis.privacy.consentmodel.ConsentLabelType;
import org.dataflowanalysis.privacy.consentmodel.ConsentModel;
import org.dataflowanalysis.privacy.consentmodel.ConsentOption;
import org.dataflowanalysis.privacy.consentmodel.DataItem;
import org.dataflowanalysis.privacy.consentmodel.DataItemLabel;
import org.dataflowanalysis.privacy.consentmodel.DataItemLabelType;
import org.dataflowanalysis.privacy.consentmodel.DataState;
import org.dataflowanalysis.privacy.consentmodel.DataStateLabel;
import org.dataflowanalysis.privacy.consentmodel.DataStateLabelType;
import org.dataflowanalysis.privacy.consentmodel.Role;
import org.dataflowanalysis.privacy.consentmodel.RoleLabel;
import org.dataflowanalysis.privacy.consentmodel.RoleLabelType;
import org.dataflowanalysis.privacy.consentmodel.StatefulItem;
import org.dataflowanalysis.privacy.consentmodel.UserDataCombination;
import org.dataflowanalysis.privacy.consentmodel.consentmodelFactory;
import org.dataflowanalysis.privacy.consentmodel.consentmodelPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import tools.mdsd.modelingfoundations.identifier.IdentifierPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class consentmodelPackageImpl extends EPackageImpl implements consentmodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userDataCombinationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass consentOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass consentModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleLabelTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass consentLabelTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass consentLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataItemLabelTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataItemLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statefulItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataStateLabelTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataStateLabelEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private consentmodelPackageImpl() {
		super(eNS_URI, consentmodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link consentmodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static consentmodelPackage init() {
		if (isInited)
			return (consentmodelPackage) EPackage.Registry.INSTANCE.getEPackage(consentmodelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredconsentmodelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		consentmodelPackageImpl theconsentmodelPackage = registeredconsentmodelPackage instanceof consentmodelPackageImpl
				? (consentmodelPackageImpl) registeredconsentmodelPackage
				: new consentmodelPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		datadictionaryPackage.eINSTANCE.eClass();
		IdentifierPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theconsentmodelPackage.createPackageContents();

		// Initialize created meta-data
		theconsentmodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theconsentmodelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(consentmodelPackage.eNS_URI, theconsentmodelPackage);
		return theconsentmodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataItem() {
		return dataItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataState() {
		return dataStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataState_NotRelatableWith() {
		return (EReference) dataStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUserDataCombination() {
		return userDataCombinationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUserDataCombination_Members() {
		return (EReference) userDataCombinationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConsentOption() {
		return consentOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConsentOption_Requires() {
		return (EReference) consentOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConsentOption_Excludes() {
		return (EReference) consentOptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConsentOption_AllowsFor() {
		return (EReference) consentOptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRole() {
		return roleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRole_Requires() {
		return (EReference) roleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRole_Allows() {
		return (EReference) roleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConsentModel() {
		return consentModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConsentModel_RoleLabelType() {
		return (EReference) consentModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConsentModel_ConsentLabelType() {
		return (EReference) consentModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConsentModel_DataItemLabelType() {
		return (EReference) consentModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConsentModel_DataStateLabelType() {
		return (EReference) consentModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRoleLabelType() {
		return roleLabelTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoleLabelType_Labels() {
		return (EReference) roleLabelTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConsentLabelType() {
		return consentLabelTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConsentLabelType_Labels() {
		return (EReference) consentLabelTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRoleLabel() {
		return roleLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRoleLabel_Role() {
		return (EReference) roleLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConsentLabel() {
		return consentLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConsentLabel_ConsentOption() {
		return (EReference) consentLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataItemLabelType() {
		return dataItemLabelTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataItemLabelType_Labels() {
		return (EReference) dataItemLabelTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataItemLabel() {
		return dataItemLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataItemLabel_DataItem() {
		return (EReference) dataItemLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStatefulItem() {
		return statefulItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStatefulItem_State() {
		return (EReference) statefulItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStatefulItem_Item() {
		return (EReference) statefulItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataStateLabelType() {
		return dataStateLabelTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataStateLabelType_Labels() {
		return (EReference) dataStateLabelTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataStateLabel() {
		return dataStateLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataStateLabel_DataState() {
		return (EReference) dataStateLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public consentmodelFactory getconsentmodelFactory() {
		return (consentmodelFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		dataItemEClass = createEClass(DATA_ITEM);

		dataStateEClass = createEClass(DATA_STATE);
		createEReference(dataStateEClass, DATA_STATE__NOT_RELATABLE_WITH);

		userDataCombinationEClass = createEClass(USER_DATA_COMBINATION);
		createEReference(userDataCombinationEClass, USER_DATA_COMBINATION__MEMBERS);

		consentOptionEClass = createEClass(CONSENT_OPTION);
		createEReference(consentOptionEClass, CONSENT_OPTION__REQUIRES);
		createEReference(consentOptionEClass, CONSENT_OPTION__EXCLUDES);
		createEReference(consentOptionEClass, CONSENT_OPTION__ALLOWS_FOR);

		roleEClass = createEClass(ROLE);
		createEReference(roleEClass, ROLE__REQUIRES);
		createEReference(roleEClass, ROLE__ALLOWS);

		consentModelEClass = createEClass(CONSENT_MODEL);
		createEReference(consentModelEClass, CONSENT_MODEL__ROLE_LABEL_TYPE);
		createEReference(consentModelEClass, CONSENT_MODEL__CONSENT_LABEL_TYPE);
		createEReference(consentModelEClass, CONSENT_MODEL__DATA_ITEM_LABEL_TYPE);
		createEReference(consentModelEClass, CONSENT_MODEL__DATA_STATE_LABEL_TYPE);

		roleLabelTypeEClass = createEClass(ROLE_LABEL_TYPE);
		createEReference(roleLabelTypeEClass, ROLE_LABEL_TYPE__LABELS);

		consentLabelTypeEClass = createEClass(CONSENT_LABEL_TYPE);
		createEReference(consentLabelTypeEClass, CONSENT_LABEL_TYPE__LABELS);

		roleLabelEClass = createEClass(ROLE_LABEL);
		createEReference(roleLabelEClass, ROLE_LABEL__ROLE);

		consentLabelEClass = createEClass(CONSENT_LABEL);
		createEReference(consentLabelEClass, CONSENT_LABEL__CONSENT_OPTION);

		dataItemLabelTypeEClass = createEClass(DATA_ITEM_LABEL_TYPE);
		createEReference(dataItemLabelTypeEClass, DATA_ITEM_LABEL_TYPE__LABELS);

		dataItemLabelEClass = createEClass(DATA_ITEM_LABEL);
		createEReference(dataItemLabelEClass, DATA_ITEM_LABEL__DATA_ITEM);

		statefulItemEClass = createEClass(STATEFUL_ITEM);
		createEReference(statefulItemEClass, STATEFUL_ITEM__STATE);
		createEReference(statefulItemEClass, STATEFUL_ITEM__ITEM);

		dataStateLabelTypeEClass = createEClass(DATA_STATE_LABEL_TYPE);
		createEReference(dataStateLabelTypeEClass, DATA_STATE_LABEL_TYPE__LABELS);

		dataStateLabelEClass = createEClass(DATA_STATE_LABEL);
		createEReference(dataStateLabelEClass, DATA_STATE_LABEL__DATA_STATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		IdentifierPackage theIdentifierPackage = (IdentifierPackage) EPackage.Registry.INSTANCE
				.getEPackage(IdentifierPackage.eNS_URI);
		datadictionaryPackage thedatadictionaryPackage = (datadictionaryPackage) EPackage.Registry.INSTANCE
				.getEPackage(datadictionaryPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dataItemEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		dataStateEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		userDataCombinationEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		consentOptionEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		roleEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		consentModelEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		roleLabelTypeEClass.getESuperTypes().add(thedatadictionaryPackage.getAbstractLabelType());
		consentLabelTypeEClass.getESuperTypes().add(thedatadictionaryPackage.getAbstractLabelType());
		roleLabelEClass.getESuperTypes().add(thedatadictionaryPackage.getAbstractLabel());
		consentLabelEClass.getESuperTypes().add(thedatadictionaryPackage.getAbstractLabel());
		dataItemLabelTypeEClass.getESuperTypes().add(thedatadictionaryPackage.getAbstractLabelType());
		dataItemLabelEClass.getESuperTypes().add(thedatadictionaryPackage.getAbstractLabel());
		dataStateLabelTypeEClass.getESuperTypes().add(thedatadictionaryPackage.getAbstractLabelType());
		dataStateLabelEClass.getESuperTypes().add(thedatadictionaryPackage.getAbstractLabel());

		// Initialize classes, features, and operations; add parameters
		initEClass(dataItemEClass, DataItem.class, "DataItem", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataStateEClass, DataState.class, "DataState", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataState_NotRelatableWith(), this.getDataState(), null, "notRelatableWith", null, 0, -1,
				DataState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userDataCombinationEClass, UserDataCombination.class, "UserDataCombination", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserDataCombination_Members(), this.getStatefulItem(), null, "members", null, 0, -1,
				UserDataCombination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(consentOptionEClass, ConsentOption.class, "ConsentOption", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConsentOption_Requires(), this.getConsentOption(), null, "requires", null, 0, -1,
				ConsentOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConsentOption_Excludes(), this.getConsentOption(), null, "excludes", null, 0, -1,
				ConsentOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConsentOption_AllowsFor(), this.getUserDataCombination(), null, "allowsFor", null, 0, -1,
				ConsentOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleEClass, Role.class, "Role", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRole_Requires(), this.getConsentOption(), null, "requires", null, 0, -1, Role.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRole_Allows(), this.getConsentOption(), null, "allows", null, 0, -1, Role.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(consentModelEClass, ConsentModel.class, "ConsentModel", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConsentModel_RoleLabelType(), this.getRoleLabelType(), null, "roleLabelType", null, 1, 1,
				ConsentModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConsentModel_ConsentLabelType(), this.getConsentLabelType(), null, "consentLabelType", null,
				1, 1, ConsentModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConsentModel_DataItemLabelType(), this.getDataItemLabelType(), null, "dataItemLabelType",
				null, 1, 1, ConsentModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConsentModel_DataStateLabelType(), this.getDataStateLabelType(), null, "dataStateLabelType",
				null, 1, 1, ConsentModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleLabelTypeEClass, RoleLabelType.class, "RoleLabelType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleLabelType_Labels(), this.getRoleLabel(), null, "labels", null, 1, -1, RoleLabelType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(consentLabelTypeEClass, ConsentLabelType.class, "ConsentLabelType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConsentLabelType_Labels(), this.getConsentLabel(), null, "labels", null, 1, -1,
				ConsentLabelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleLabelEClass, RoleLabel.class, "RoleLabel", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleLabel_Role(), this.getRole(), null, "role", null, 1, 1, RoleLabel.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(consentLabelEClass, ConsentLabel.class, "ConsentLabel", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConsentLabel_ConsentOption(), this.getConsentOption(), null, "consentOption", null, 1, 1,
				ConsentLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataItemLabelTypeEClass, DataItemLabelType.class, "DataItemLabelType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataItemLabelType_Labels(), this.getDataItemLabel(), null, "labels", null, 1, -1,
				DataItemLabelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataItemLabelEClass, DataItemLabel.class, "DataItemLabel", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataItemLabel_DataItem(), this.getDataItem(), null, "dataItem", null, 1, 1,
				DataItemLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statefulItemEClass, StatefulItem.class, "StatefulItem", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStatefulItem_State(), this.getDataState(), null, "state", null, 0, -1, StatefulItem.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStatefulItem_Item(), this.getDataItem(), null, "item", null, 1, 1, StatefulItem.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataStateLabelTypeEClass, DataStateLabelType.class, "DataStateLabelType", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataStateLabelType_Labels(), this.getDataStateLabel(), null, "labels", null, 1, -1,
				DataStateLabelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataStateLabelEClass, DataStateLabel.class, "DataStateLabel", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataStateLabel_DataState(), this.getDataState(), null, "dataState", null, 1, 1,
				DataStateLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //consentmodelPackageImpl

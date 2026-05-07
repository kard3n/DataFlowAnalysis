/**
 */
package org.dataflowanalysis.privacy.privacymodel.impl;

import org.dataflowanalysis.dfd.datadictionary.datadictionaryPackage;
import org.dataflowanalysis.privacy.privacymodel.DataContext;
import org.dataflowanalysis.privacy.privacymodel.DataContextLabel;
import org.dataflowanalysis.privacy.privacymodel.DataContextLabelType;
import org.dataflowanalysis.privacy.privacymodel.DataItem;
import org.dataflowanalysis.privacy.privacymodel.DataItemLabel;
import org.dataflowanalysis.privacy.privacymodel.DataItemLabelType;
import org.dataflowanalysis.privacy.privacymodel.DataState;
import org.dataflowanalysis.privacy.privacymodel.DataStateLabel;
import org.dataflowanalysis.privacy.privacymodel.DataStateLabelType;
import org.dataflowanalysis.privacy.privacymodel.Functionality;
import org.dataflowanalysis.privacy.privacymodel.FunctionalityLabel;
import org.dataflowanalysis.privacy.privacymodel.FunctionalityLabelType;
import org.dataflowanalysis.privacy.privacymodel.PrivacyModel;
import org.dataflowanalysis.privacy.privacymodel.Role;
import org.dataflowanalysis.privacy.privacymodel.RoleLabel;
import org.dataflowanalysis.privacy.privacymodel.RoleLabelType;
import org.dataflowanalysis.privacy.privacymodel.StatefulItem;
import org.dataflowanalysis.privacy.privacymodel.UserDataCombination;
import org.dataflowanalysis.privacy.privacymodel.privacymodelFactory;
import org.dataflowanalysis.privacy.privacymodel.privacymodelPackage;

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
public class privacymodelPackageImpl extends EPackageImpl implements privacymodelPackage {
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
	private EClass functionalityEClass = null;

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
	private EClass privacyModelEClass = null;

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
	private EClass functionalityLabelTypeEClass = null;

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
	private EClass functionalityLabelEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataContextLabelTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataContextLabelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataContextEClass = null;

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
	 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private privacymodelPackageImpl() {
		super(eNS_URI, privacymodelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link privacymodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static privacymodelPackage init() {
		if (isInited)
			return (privacymodelPackage) EPackage.Registry.INSTANCE.getEPackage(privacymodelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredprivacymodelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		privacymodelPackageImpl theprivacymodelPackage = registeredprivacymodelPackage instanceof privacymodelPackageImpl
				? (privacymodelPackageImpl) registeredprivacymodelPackage
				: new privacymodelPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		datadictionaryPackage.eINSTANCE.eClass();
		IdentifierPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theprivacymodelPackage.createPackageContents();

		// Initialize created meta-data
		theprivacymodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theprivacymodelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(privacymodelPackage.eNS_URI, theprivacymodelPackage);
		return theprivacymodelPackage;
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
	public EClass getFunctionality() {
		return functionalityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionality_Requires() {
		return (EReference) functionalityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionality_Excludes() {
		return (EReference) functionalityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionality_AllowsFor() {
		return (EReference) functionalityEClass.getEStructuralFeatures().get(2);
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
	public EReference getRole_AlwaysAllows() {
		return (EReference) roleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRole_OptionallyAllows() {
		return (EReference) roleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrivacyModel() {
		return privacyModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPrivacyModel_RoleLabelType() {
		return (EReference) privacyModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPrivacyModel_FunctionalityLabelType() {
		return (EReference) privacyModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPrivacyModel_DataItemLabelType() {
		return (EReference) privacyModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPrivacyModel_DataStateLabelType() {
		return (EReference) privacyModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPrivacyModel_DataContextLabelType() {
		return (EReference) privacyModelEClass.getEStructuralFeatures().get(4);
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
	public EClass getFunctionalityLabelType() {
		return functionalityLabelTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionalityLabelType_Labels() {
		return (EReference) functionalityLabelTypeEClass.getEStructuralFeatures().get(0);
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
	public EClass getFunctionalityLabel() {
		return functionalityLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionalityLabel_Functionality() {
		return (EReference) functionalityLabelEClass.getEStructuralFeatures().get(0);
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
	public EReference getStatefulItem_Context() {
		return (EReference) statefulItemEClass.getEStructuralFeatures().get(2);
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
	public EClass getDataContextLabelType() {
		return dataContextLabelTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataContextLabelType_Labels() {
		return (EReference) dataContextLabelTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataContextLabel() {
		return dataContextLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataContextLabel_DataContext() {
		return (EReference) dataContextLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataContext() {
		return dataContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public privacymodelFactory getprivacymodelFactory() {
		return (privacymodelFactory) getEFactoryInstance();
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

		functionalityEClass = createEClass(FUNCTIONALITY);
		createEReference(functionalityEClass, FUNCTIONALITY__REQUIRES);
		createEReference(functionalityEClass, FUNCTIONALITY__EXCLUDES);
		createEReference(functionalityEClass, FUNCTIONALITY__ALLOWS_FOR);

		roleEClass = createEClass(ROLE);
		createEReference(roleEClass, ROLE__ALWAYS_ALLOWS);
		createEReference(roleEClass, ROLE__OPTIONALLY_ALLOWS);

		privacyModelEClass = createEClass(PRIVACY_MODEL);
		createEReference(privacyModelEClass, PRIVACY_MODEL__ROLE_LABEL_TYPE);
		createEReference(privacyModelEClass, PRIVACY_MODEL__FUNCTIONALITY_LABEL_TYPE);
		createEReference(privacyModelEClass, PRIVACY_MODEL__DATA_ITEM_LABEL_TYPE);
		createEReference(privacyModelEClass, PRIVACY_MODEL__DATA_STATE_LABEL_TYPE);
		createEReference(privacyModelEClass, PRIVACY_MODEL__DATA_CONTEXT_LABEL_TYPE);

		roleLabelTypeEClass = createEClass(ROLE_LABEL_TYPE);
		createEReference(roleLabelTypeEClass, ROLE_LABEL_TYPE__LABELS);

		functionalityLabelTypeEClass = createEClass(FUNCTIONALITY_LABEL_TYPE);
		createEReference(functionalityLabelTypeEClass, FUNCTIONALITY_LABEL_TYPE__LABELS);

		roleLabelEClass = createEClass(ROLE_LABEL);
		createEReference(roleLabelEClass, ROLE_LABEL__ROLE);

		functionalityLabelEClass = createEClass(FUNCTIONALITY_LABEL);
		createEReference(functionalityLabelEClass, FUNCTIONALITY_LABEL__FUNCTIONALITY);

		dataItemLabelTypeEClass = createEClass(DATA_ITEM_LABEL_TYPE);
		createEReference(dataItemLabelTypeEClass, DATA_ITEM_LABEL_TYPE__LABELS);

		dataItemLabelEClass = createEClass(DATA_ITEM_LABEL);
		createEReference(dataItemLabelEClass, DATA_ITEM_LABEL__DATA_ITEM);

		statefulItemEClass = createEClass(STATEFUL_ITEM);
		createEReference(statefulItemEClass, STATEFUL_ITEM__STATE);
		createEReference(statefulItemEClass, STATEFUL_ITEM__ITEM);
		createEReference(statefulItemEClass, STATEFUL_ITEM__CONTEXT);

		dataStateLabelTypeEClass = createEClass(DATA_STATE_LABEL_TYPE);
		createEReference(dataStateLabelTypeEClass, DATA_STATE_LABEL_TYPE__LABELS);

		dataStateLabelEClass = createEClass(DATA_STATE_LABEL);
		createEReference(dataStateLabelEClass, DATA_STATE_LABEL__DATA_STATE);

		dataContextLabelTypeEClass = createEClass(DATA_CONTEXT_LABEL_TYPE);
		createEReference(dataContextLabelTypeEClass, DATA_CONTEXT_LABEL_TYPE__LABELS);

		dataContextLabelEClass = createEClass(DATA_CONTEXT_LABEL);
		createEReference(dataContextLabelEClass, DATA_CONTEXT_LABEL__DATA_CONTEXT);

		dataContextEClass = createEClass(DATA_CONTEXT);
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
		functionalityEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		roleEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		privacyModelEClass.getESuperTypes().add(theIdentifierPackage.getEntity());
		roleLabelTypeEClass.getESuperTypes().add(thedatadictionaryPackage.getAbstractLabelType());
		functionalityLabelTypeEClass.getESuperTypes().add(thedatadictionaryPackage.getAbstractLabelType());
		roleLabelEClass.getESuperTypes().add(thedatadictionaryPackage.getAbstractLabel());
		functionalityLabelEClass.getESuperTypes().add(thedatadictionaryPackage.getAbstractLabel());
		dataItemLabelTypeEClass.getESuperTypes().add(thedatadictionaryPackage.getAbstractLabelType());
		dataItemLabelEClass.getESuperTypes().add(thedatadictionaryPackage.getAbstractLabel());
		dataStateLabelTypeEClass.getESuperTypes().add(thedatadictionaryPackage.getAbstractLabelType());
		dataStateLabelEClass.getESuperTypes().add(thedatadictionaryPackage.getAbstractLabel());
		dataContextLabelTypeEClass.getESuperTypes().add(thedatadictionaryPackage.getAbstractLabelType());
		dataContextLabelEClass.getESuperTypes().add(thedatadictionaryPackage.getAbstractLabel());
		dataContextEClass.getESuperTypes().add(theIdentifierPackage.getEntity());

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

		initEClass(functionalityEClass, Functionality.class, "Functionality", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionality_Requires(), this.getFunctionality(), null, "requires", null, 0, -1,
				Functionality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionality_Excludes(), this.getFunctionality(), null, "excludes", null, 0, -1,
				Functionality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionality_AllowsFor(), this.getUserDataCombination(), null, "allowsFor", null, 0, -1,
				Functionality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleEClass, Role.class, "Role", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRole_AlwaysAllows(), this.getFunctionality(), null, "alwaysAllows", null, 0, -1, Role.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRole_OptionallyAllows(), this.getFunctionality(), null, "optionallyAllows", null, 0, -1,
				Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(privacyModelEClass, PrivacyModel.class, "PrivacyModel", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrivacyModel_RoleLabelType(), this.getRoleLabelType(), null, "roleLabelType", null, 1, 1,
				PrivacyModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrivacyModel_FunctionalityLabelType(), this.getFunctionalityLabelType(), null,
				"functionalityLabelType", null, 1, 1, PrivacyModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrivacyModel_DataItemLabelType(), this.getDataItemLabelType(), null, "dataItemLabelType",
				null, 1, -1, PrivacyModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrivacyModel_DataStateLabelType(), this.getDataStateLabelType(), null, "dataStateLabelType",
				null, 1, 1, PrivacyModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrivacyModel_DataContextLabelType(), this.getDataContextLabelType(), null,
				"dataContextLabelType", null, 1, 1, PrivacyModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleLabelTypeEClass, RoleLabelType.class, "RoleLabelType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleLabelType_Labels(), this.getRoleLabel(), null, "labels", null, 1, -1, RoleLabelType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionalityLabelTypeEClass, FunctionalityLabelType.class, "FunctionalityLabelType", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionalityLabelType_Labels(), this.getFunctionalityLabel(), null, "labels", null, 1, -1,
				FunctionalityLabelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleLabelEClass, RoleLabel.class, "RoleLabel", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleLabel_Role(), this.getRole(), null, "role", null, 1, 1, RoleLabel.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(functionalityLabelEClass, FunctionalityLabel.class, "FunctionalityLabel", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionalityLabel_Functionality(), this.getFunctionality(), null, "functionality", null, 1,
				1, FunctionalityLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		initEReference(getStatefulItem_Context(), this.getDataContext(), null, "context", null, 0, -1,
				StatefulItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEClass(dataContextLabelTypeEClass, DataContextLabelType.class, "DataContextLabelType", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataContextLabelType_Labels(), this.getDataContextLabel(), null, "labels", null, 1, -1,
				DataContextLabelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataContextLabelEClass, DataContextLabel.class, "DataContextLabel", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataContextLabel_DataContext(), this.getDataContext(), null, "dataContext", null, 1, 1,
				DataContextLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataContextEClass, DataContext.class, "DataContext", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //privacymodelPackageImpl

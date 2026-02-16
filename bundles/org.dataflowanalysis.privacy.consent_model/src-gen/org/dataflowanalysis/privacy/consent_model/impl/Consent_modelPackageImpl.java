/**
 */
package org.dataflowanalysis.privacy.consent_model.impl;

import identifier.IdentifierPackage;
import identifier.impl.IdentifierPackageImpl;
import org.dataflowanalysis.dfd.datadictionary.datadictionaryPackage;
import org.dataflowanalysis.privacy.consent_model.ConsentLabel;
import org.dataflowanalysis.privacy.consent_model.ConsentLabelType;
import org.dataflowanalysis.privacy.consent_model.ConsentModel;
import org.dataflowanalysis.privacy.consent_model.Consent_modelFactory;
import org.dataflowanalysis.privacy.consent_model.Consent_modelPackage;
import org.dataflowanalysis.privacy.consent_model.ConsentedFunctionality;
import org.dataflowanalysis.privacy.consent_model.DataItem;
import org.dataflowanalysis.privacy.consent_model.DataState;
import org.dataflowanalysis.privacy.consent_model.Role;
import org.dataflowanalysis.privacy.consent_model.RoleLabel;
import org.dataflowanalysis.privacy.consent_model.RoleLabelType;
import org.dataflowanalysis.privacy.consent_model.UserDataCombination;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Consent_modelPackageImpl extends EPackageImpl implements Consent_modelPackage {
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
	private EClass consentedFunctionalityEClass = null;

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
	private EClass roleLabelEClass = null;

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
	private EClass consentLabelEClass = null;

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
	 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Consent_modelPackageImpl() {
		super(eNS_URI, Consent_modelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Consent_modelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Consent_modelPackage init() {
		if (isInited)
			return (Consent_modelPackage) EPackage.Registry.INSTANCE.getEPackage(Consent_modelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredConsent_modelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		Consent_modelPackageImpl theConsent_modelPackage = registeredConsent_modelPackage instanceof Consent_modelPackageImpl
				? (Consent_modelPackageImpl) registeredConsent_modelPackage
				: new Consent_modelPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		datadictionaryPackage.eINSTANCE.eClass();
		tools.mdsd.modelingfoundations.identifier.IdentifierPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);
		IdentifierPackageImpl theIdentifierPackage_1 = (IdentifierPackageImpl) (registeredPackage instanceof IdentifierPackageImpl
				? registeredPackage
				: IdentifierPackage.eINSTANCE);

		// Create package meta-data objects
		theConsent_modelPackage.createPackageContents();
		theIdentifierPackage_1.createPackageContents();

		// Initialize created meta-data
		theConsent_modelPackage.initializePackageContents();
		theIdentifierPackage_1.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConsent_modelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Consent_modelPackage.eNS_URI, theConsent_modelPackage);
		return theConsent_modelPackage;
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
	public EReference getDataItem_State() {
		return (EReference) dataItemEClass.getEStructuralFeatures().get(0);
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
	public EClass getConsentedFunctionality() {
		return consentedFunctionalityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConsentedFunctionality_Requires() {
		return (EReference) consentedFunctionalityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConsentedFunctionality_Excludes() {
		return (EReference) consentedFunctionalityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConsentedFunctionality_AllowsFor() {
		return (EReference) consentedFunctionalityEClass.getEStructuralFeatures().get(2);
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
	public EReference getConsentModel_Roles() {
		return (EReference) consentModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConsentModel_Functionalities() {
		return (EReference) consentModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConsentModel_Data_states() {
		return (EReference) consentModelEClass.getEStructuralFeatures().get(2);
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
	public EClass getConsentLabel() {
		return consentLabelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConsentLabel_ConsentedFunctionality() {
		return (EReference) consentLabelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Consent_modelFactory getConsent_modelFactory() {
		return (Consent_modelFactory) getEFactoryInstance();
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
		createEReference(dataItemEClass, DATA_ITEM__STATE);

		dataStateEClass = createEClass(DATA_STATE);
		createEReference(dataStateEClass, DATA_STATE__NOT_RELATABLE_WITH);

		userDataCombinationEClass = createEClass(USER_DATA_COMBINATION);
		createEReference(userDataCombinationEClass, USER_DATA_COMBINATION__MEMBERS);

		consentedFunctionalityEClass = createEClass(CONSENTED_FUNCTIONALITY);
		createEReference(consentedFunctionalityEClass, CONSENTED_FUNCTIONALITY__REQUIRES);
		createEReference(consentedFunctionalityEClass, CONSENTED_FUNCTIONALITY__EXCLUDES);
		createEReference(consentedFunctionalityEClass, CONSENTED_FUNCTIONALITY__ALLOWS_FOR);

		roleEClass = createEClass(ROLE);
		createEReference(roleEClass, ROLE__REQUIRES);
		createEReference(roleEClass, ROLE__ALLOWS);

		consentModelEClass = createEClass(CONSENT_MODEL);
		createEReference(consentModelEClass, CONSENT_MODEL__ROLES);
		createEReference(consentModelEClass, CONSENT_MODEL__FUNCTIONALITIES);
		createEReference(consentModelEClass, CONSENT_MODEL__DATA_STATES);

		roleLabelTypeEClass = createEClass(ROLE_LABEL_TYPE);
		createEReference(roleLabelTypeEClass, ROLE_LABEL_TYPE__LABELS);

		roleLabelEClass = createEClass(ROLE_LABEL);
		createEReference(roleLabelEClass, ROLE_LABEL__ROLE);

		consentLabelTypeEClass = createEClass(CONSENT_LABEL_TYPE);
		createEReference(consentLabelTypeEClass, CONSENT_LABEL_TYPE__LABELS);

		consentLabelEClass = createEClass(CONSENT_LABEL);
		createEReference(consentLabelEClass, CONSENT_LABEL__CONSENTED_FUNCTIONALITY);
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
		IdentifierPackage theIdentifierPackage_1 = (IdentifierPackage) EPackage.Registry.INSTANCE
				.getEPackage(IdentifierPackage.eNS_URI);
		datadictionaryPackage thedatadictionaryPackage = (datadictionaryPackage) EPackage.Registry.INSTANCE
				.getEPackage(datadictionaryPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dataItemEClass.getESuperTypes().add(theIdentifierPackage_1.getEntity());
		dataStateEClass.getESuperTypes().add(theIdentifierPackage_1.getEntity());
		userDataCombinationEClass.getESuperTypes().add(theIdentifierPackage_1.getEntity());
		consentedFunctionalityEClass.getESuperTypes().add(theIdentifierPackage_1.getEntity());
		roleEClass.getESuperTypes().add(theIdentifierPackage_1.getEntity());
		consentModelEClass.getESuperTypes().add(theIdentifierPackage_1.getEntity());
		roleLabelTypeEClass.getESuperTypes().add(thedatadictionaryPackage.getLabelType());
		roleLabelEClass.getESuperTypes().add(thedatadictionaryPackage.getLabel());
		consentLabelTypeEClass.getESuperTypes().add(thedatadictionaryPackage.getLabelType());
		consentLabelEClass.getESuperTypes().add(thedatadictionaryPackage.getLabel());

		// Initialize classes, features, and operations; add parameters
		initEClass(dataItemEClass, DataItem.class, "DataItem", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataItem_State(), this.getDataState(), null, "state", null, 0, -1, DataItem.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataStateEClass, DataState.class, "DataState", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataState_NotRelatableWith(), this.getDataState(), null, "notRelatableWith", null, 0, -1,
				DataState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userDataCombinationEClass, UserDataCombination.class, "UserDataCombination", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserDataCombination_Members(), this.getDataItem(), null, "members", null, 0, -1,
				UserDataCombination.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(consentedFunctionalityEClass, ConsentedFunctionality.class, "ConsentedFunctionality", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConsentedFunctionality_Requires(), this.getConsentedFunctionality(), null, "requires", null,
				0, -1, ConsentedFunctionality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConsentedFunctionality_Excludes(), this.getConsentedFunctionality(), null, "excludes", null,
				0, -1, ConsentedFunctionality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConsentedFunctionality_AllowsFor(), this.getUserDataCombination(), null, "allowsFor", null, 0,
				-1, ConsentedFunctionality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleEClass, Role.class, "Role", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRole_Requires(), this.getConsentedFunctionality(), null, "requires", null, 0, -1, Role.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRole_Allows(), this.getConsentedFunctionality(), null, "allows", null, 0, -1, Role.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(consentModelEClass, ConsentModel.class, "ConsentModel", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConsentModel_Roles(), this.getRole(), null, "roles", null, 0, -1, ConsentModel.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConsentModel_Functionalities(), this.getConsentedFunctionality(), null, "functionalities",
				null, 0, -1, ConsentModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConsentModel_Data_states(), this.getDataState(), null, "data_states", null, 0, -1,
				ConsentModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleLabelTypeEClass, RoleLabelType.class, "RoleLabelType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleLabelType_Labels(), this.getRoleLabel(), null, "labels", null, 1, -1, RoleLabelType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleLabelEClass, RoleLabel.class, "RoleLabel", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleLabel_Role(), this.getRole(), null, "role", null, 1, 1, RoleLabel.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(consentLabelTypeEClass, ConsentLabelType.class, "ConsentLabelType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConsentLabelType_Labels(), this.getConsentLabel(), null, "labels", null, 1, -1,
				ConsentLabelType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(consentLabelEClass, ConsentLabel.class, "ConsentLabel", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConsentLabel_ConsentedFunctionality(), this.getConsentedFunctionality(), null,
				"consentedFunctionality", null, 1, 1, ConsentLabel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Consent_modelPackageImpl

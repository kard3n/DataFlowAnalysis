/**
 */
package org.dataflowanalysis.privacy.consent_model;

import identifier.IdentifierPackage;
import org.dataflowanalysis.dfd.datadictionary.datadictionaryPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelFactory
 * @model kind="package"
 * @generated
 */
public interface Consent_modelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "consent_model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.dataflowanalysis.org/consent_model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "consent_model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Consent_modelPackage eINSTANCE = org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.consent_model.impl.DataItemImpl <em>Data Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.consent_model.impl.DataItemImpl
	 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getDataItem()
	 * @generated
	 */
	int DATA_ITEM = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM__STATE = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.consent_model.impl.DataStateImpl <em>Data State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.consent_model.impl.DataStateImpl
	 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getDataState()
	 * @generated
	 */
	int DATA_STATE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Not Relatable With</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE__NOT_RELATABLE_WITH = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.consent_model.impl.UserDataCombinationImpl <em>User Data Combination</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.consent_model.impl.UserDataCombinationImpl
	 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getUserDataCombination()
	 * @generated
	 */
	int USER_DATA_COMBINATION = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DATA_COMBINATION__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DATA_COMBINATION__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DATA_COMBINATION__MEMBERS = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Data Combination</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DATA_COMBINATION_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>User Data Combination</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_DATA_COMBINATION_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentOptionImpl <em>Consent Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.consent_model.impl.ConsentOptionImpl
	 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getConsentOption()
	 * @generated
	 */
	int CONSENT_OPTION = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_OPTION__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_OPTION__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_OPTION__REQUIRES = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Excludes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_OPTION__EXCLUDES = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Allows For</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_OPTION__ALLOWS_FOR = IdentifierPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Consent Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_OPTION_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Consent Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_OPTION_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.consent_model.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.consent_model.impl.RoleImpl
	 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__REQUIRES = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Allows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ALLOWS = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentModelImpl <em>Consent Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.consent_model.impl.ConsentModelImpl
	 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getConsentModel()
	 * @generated
	 */
	int CONSENT_MODEL = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_MODEL__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_MODEL__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Functionalities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_MODEL__FUNCTIONALITIES = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data states</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_MODEL__DATA_STATES = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Role Label Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_MODEL__ROLE_LABEL_TYPE = IdentifierPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Consent Label Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_MODEL__CONSENT_LABEL_TYPE = IdentifierPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Consent Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_MODEL_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Consent Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_MODEL_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.consent_model.impl.RoleLabelTypeImpl <em>Role Label Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.consent_model.impl.RoleLabelTypeImpl
	 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getRoleLabelType()
	 * @generated
	 */
	int ROLE_LABEL_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_LABEL_TYPE__ID = datadictionaryPackage.ABSTRACT_LABEL_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_LABEL_TYPE__ENTITY_NAME = datadictionaryPackage.ABSTRACT_LABEL_TYPE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_LABEL_TYPE__LABELS = datadictionaryPackage.ABSTRACT_LABEL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Role Label Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_LABEL_TYPE_FEATURE_COUNT = datadictionaryPackage.ABSTRACT_LABEL_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Role Label Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_LABEL_TYPE_OPERATION_COUNT = datadictionaryPackage.ABSTRACT_LABEL_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.consent_model.impl.RoleLabelImpl <em>Role Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.consent_model.impl.RoleLabelImpl
	 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getRoleLabel()
	 * @generated
	 */
	int ROLE_LABEL = 7;

	/**
	 * The feature id for the '<em><b>Role</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_LABEL__ROLE = 0;

	/**
	 * The number of structural features of the '<em>Role Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_LABEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Role Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_LABEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentLabelTypeImpl <em>Consent Label Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.consent_model.impl.ConsentLabelTypeImpl
	 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getConsentLabelType()
	 * @generated
	 */
	int CONSENT_LABEL_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_LABEL_TYPE__ID = datadictionaryPackage.ABSTRACT_LABEL_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_LABEL_TYPE__ENTITY_NAME = datadictionaryPackage.ABSTRACT_LABEL_TYPE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_LABEL_TYPE__LABELS = datadictionaryPackage.ABSTRACT_LABEL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Consent Label Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_LABEL_TYPE_FEATURE_COUNT = datadictionaryPackage.ABSTRACT_LABEL_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Consent Label Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_LABEL_TYPE_OPERATION_COUNT = datadictionaryPackage.ABSTRACT_LABEL_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentLabelImpl <em>Consent Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.consent_model.impl.ConsentLabelImpl
	 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getConsentLabel()
	 * @generated
	 */
	int CONSENT_LABEL = 9;

	/**
	 * The feature id for the '<em><b>Consented Functionality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_LABEL__CONSENTED_FUNCTIONALITY = 0;

	/**
	 * The number of structural features of the '<em>Consent Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_LABEL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Consent Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_LABEL_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.consent_model.DataItem <em>Data Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Item</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.DataItem
	 * @generated
	 */
	EClass getDataItem();

	/**
	 * Returns the meta object for the reference list '{@link org.dataflowanalysis.privacy.consent_model.DataItem#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>State</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.DataItem#getState()
	 * @see #getDataItem()
	 * @generated
	 */
	EReference getDataItem_State();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.consent_model.DataState <em>Data State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data State</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.DataState
	 * @generated
	 */
	EClass getDataState();

	/**
	 * Returns the meta object for the reference list '{@link org.dataflowanalysis.privacy.consent_model.DataState#getNotRelatableWith <em>Not Relatable With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Not Relatable With</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.DataState#getNotRelatableWith()
	 * @see #getDataState()
	 * @generated
	 */
	EReference getDataState_NotRelatableWith();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.consent_model.UserDataCombination <em>User Data Combination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Data Combination</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.UserDataCombination
	 * @generated
	 */
	EClass getUserDataCombination();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dataflowanalysis.privacy.consent_model.UserDataCombination#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.UserDataCombination#getMembers()
	 * @see #getUserDataCombination()
	 * @generated
	 */
	EReference getUserDataCombination_Members();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.consent_model.ConsentOption <em>Consent Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Consent Option</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.ConsentOption
	 * @generated
	 */
	EClass getConsentOption();

	/**
	 * Returns the meta object for the reference list '{@link org.dataflowanalysis.privacy.consent_model.ConsentOption#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requires</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.ConsentOption#getRequires()
	 * @see #getConsentOption()
	 * @generated
	 */
	EReference getConsentOption_Requires();

	/**
	 * Returns the meta object for the reference list '{@link org.dataflowanalysis.privacy.consent_model.ConsentOption#getExcludes <em>Excludes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Excludes</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.ConsentOption#getExcludes()
	 * @see #getConsentOption()
	 * @generated
	 */
	EReference getConsentOption_Excludes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dataflowanalysis.privacy.consent_model.ConsentOption#getAllowsFor <em>Allows For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Allows For</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.ConsentOption#getAllowsFor()
	 * @see #getConsentOption()
	 * @generated
	 */
	EReference getConsentOption_AllowsFor();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.consent_model.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the reference list '{@link org.dataflowanalysis.privacy.consent_model.Role#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requires</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.Role#getRequires()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_Requires();

	/**
	 * Returns the meta object for the reference list '{@link org.dataflowanalysis.privacy.consent_model.Role#getAllows <em>Allows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Allows</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.Role#getAllows()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_Allows();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.consent_model.ConsentModel <em>Consent Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Consent Model</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.ConsentModel
	 * @generated
	 */
	EClass getConsentModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dataflowanalysis.privacy.consent_model.ConsentModel#getFunctionalities <em>Functionalities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functionalities</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.ConsentModel#getFunctionalities()
	 * @see #getConsentModel()
	 * @generated
	 */
	EReference getConsentModel_Functionalities();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dataflowanalysis.privacy.consent_model.ConsentModel#getData_states <em>Data states</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data states</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.ConsentModel#getData_states()
	 * @see #getConsentModel()
	 * @generated
	 */
	EReference getConsentModel_Data_states();

	/**
	 * Returns the meta object for the containment reference '{@link org.dataflowanalysis.privacy.consent_model.ConsentModel#getRoleLabelType <em>Role Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Role Label Type</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.ConsentModel#getRoleLabelType()
	 * @see #getConsentModel()
	 * @generated
	 */
	EReference getConsentModel_RoleLabelType();

	/**
	 * Returns the meta object for the containment reference '{@link org.dataflowanalysis.privacy.consent_model.ConsentModel#getConsentLabelType <em>Consent Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Consent Label Type</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.ConsentModel#getConsentLabelType()
	 * @see #getConsentModel()
	 * @generated
	 */
	EReference getConsentModel_ConsentLabelType();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.consent_model.RoleLabelType <em>Role Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Label Type</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.RoleLabelType
	 * @generated
	 */
	EClass getRoleLabelType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dataflowanalysis.privacy.consent_model.RoleLabelType#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Labels</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.RoleLabelType#getLabels()
	 * @see #getRoleLabelType()
	 * @generated
	 */
	EReference getRoleLabelType_Labels();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.consent_model.RoleLabel <em>Role Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Label</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.RoleLabel
	 * @generated
	 */
	EClass getRoleLabel();

	/**
	 * Returns the meta object for the containment reference '{@link org.dataflowanalysis.privacy.consent_model.RoleLabel#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Role</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.RoleLabel#getRole()
	 * @see #getRoleLabel()
	 * @generated
	 */
	EReference getRoleLabel_Role();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.consent_model.ConsentLabelType <em>Consent Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Consent Label Type</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.ConsentLabelType
	 * @generated
	 */
	EClass getConsentLabelType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dataflowanalysis.privacy.consent_model.ConsentLabelType#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Labels</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.ConsentLabelType#getLabels()
	 * @see #getConsentLabelType()
	 * @generated
	 */
	EReference getConsentLabelType_Labels();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.consent_model.ConsentLabel <em>Consent Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Consent Label</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.ConsentLabel
	 * @generated
	 */
	EClass getConsentLabel();

	/**
	 * Returns the meta object for the containment reference '{@link org.dataflowanalysis.privacy.consent_model.ConsentLabel#getConsentedFunctionality <em>Consented Functionality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Consented Functionality</em>'.
	 * @see org.dataflowanalysis.privacy.consent_model.ConsentLabel#getConsentedFunctionality()
	 * @see #getConsentLabel()
	 * @generated
	 */
	EReference getConsentLabel_ConsentedFunctionality();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Consent_modelFactory getConsent_modelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.consent_model.impl.DataItemImpl <em>Data Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.consent_model.impl.DataItemImpl
		 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getDataItem()
		 * @generated
		 */
		EClass DATA_ITEM = eINSTANCE.getDataItem();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_ITEM__STATE = eINSTANCE.getDataItem_State();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.consent_model.impl.DataStateImpl <em>Data State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.consent_model.impl.DataStateImpl
		 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getDataState()
		 * @generated
		 */
		EClass DATA_STATE = eINSTANCE.getDataState();

		/**
		 * The meta object literal for the '<em><b>Not Relatable With</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_STATE__NOT_RELATABLE_WITH = eINSTANCE.getDataState_NotRelatableWith();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.consent_model.impl.UserDataCombinationImpl <em>User Data Combination</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.consent_model.impl.UserDataCombinationImpl
		 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getUserDataCombination()
		 * @generated
		 */
		EClass USER_DATA_COMBINATION = eINSTANCE.getUserDataCombination();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USER_DATA_COMBINATION__MEMBERS = eINSTANCE.getUserDataCombination_Members();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentOptionImpl <em>Consent Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.consent_model.impl.ConsentOptionImpl
		 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getConsentOption()
		 * @generated
		 */
		EClass CONSENT_OPTION = eINSTANCE.getConsentOption();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSENT_OPTION__REQUIRES = eINSTANCE.getConsentOption_Requires();

		/**
		 * The meta object literal for the '<em><b>Excludes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSENT_OPTION__EXCLUDES = eINSTANCE.getConsentOption_Excludes();

		/**
		 * The meta object literal for the '<em><b>Allows For</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSENT_OPTION__ALLOWS_FOR = eINSTANCE.getConsentOption_AllowsFor();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.consent_model.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.consent_model.impl.RoleImpl
		 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE__REQUIRES = eINSTANCE.getRole_Requires();

		/**
		 * The meta object literal for the '<em><b>Allows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE__ALLOWS = eINSTANCE.getRole_Allows();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentModelImpl <em>Consent Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.consent_model.impl.ConsentModelImpl
		 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getConsentModel()
		 * @generated
		 */
		EClass CONSENT_MODEL = eINSTANCE.getConsentModel();

		/**
		 * The meta object literal for the '<em><b>Functionalities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSENT_MODEL__FUNCTIONALITIES = eINSTANCE.getConsentModel_Functionalities();

		/**
		 * The meta object literal for the '<em><b>Data states</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSENT_MODEL__DATA_STATES = eINSTANCE.getConsentModel_Data_states();

		/**
		 * The meta object literal for the '<em><b>Role Label Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSENT_MODEL__ROLE_LABEL_TYPE = eINSTANCE.getConsentModel_RoleLabelType();

		/**
		 * The meta object literal for the '<em><b>Consent Label Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSENT_MODEL__CONSENT_LABEL_TYPE = eINSTANCE.getConsentModel_ConsentLabelType();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.consent_model.impl.RoleLabelTypeImpl <em>Role Label Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.consent_model.impl.RoleLabelTypeImpl
		 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getRoleLabelType()
		 * @generated
		 */
		EClass ROLE_LABEL_TYPE = eINSTANCE.getRoleLabelType();

		/**
		 * The meta object literal for the '<em><b>Labels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_LABEL_TYPE__LABELS = eINSTANCE.getRoleLabelType_Labels();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.consent_model.impl.RoleLabelImpl <em>Role Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.consent_model.impl.RoleLabelImpl
		 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getRoleLabel()
		 * @generated
		 */
		EClass ROLE_LABEL = eINSTANCE.getRoleLabel();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_LABEL__ROLE = eINSTANCE.getRoleLabel_Role();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentLabelTypeImpl <em>Consent Label Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.consent_model.impl.ConsentLabelTypeImpl
		 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getConsentLabelType()
		 * @generated
		 */
		EClass CONSENT_LABEL_TYPE = eINSTANCE.getConsentLabelType();

		/**
		 * The meta object literal for the '<em><b>Labels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSENT_LABEL_TYPE__LABELS = eINSTANCE.getConsentLabelType_Labels();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.consent_model.impl.ConsentLabelImpl <em>Consent Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.consent_model.impl.ConsentLabelImpl
		 * @see org.dataflowanalysis.privacy.consent_model.impl.Consent_modelPackageImpl#getConsentLabel()
		 * @generated
		 */
		EClass CONSENT_LABEL = eINSTANCE.getConsentLabel();

		/**
		 * The meta object literal for the '<em><b>Consented Functionality</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSENT_LABEL__CONSENTED_FUNCTIONALITY = eINSTANCE.getConsentLabel_ConsentedFunctionality();

	}

} //Consent_modelPackage

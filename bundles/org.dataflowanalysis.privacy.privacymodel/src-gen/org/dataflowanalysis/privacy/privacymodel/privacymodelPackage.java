/**
 */
package org.dataflowanalysis.privacy.privacymodel;

import org.dataflowanalysis.dfd.datadictionary.datadictionaryPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import tools.mdsd.modelingfoundations.identifier.IdentifierPackage;

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
 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelFactory
 * @model kind="package"
 * @generated
 */
public interface privacymodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "privacymodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.dataflowanalysis.org/privacymodel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "privacymodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	privacymodelPackage eINSTANCE = org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.DataItemImpl <em>Data Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.DataItemImpl
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getDataItem()
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
	 * The number of structural features of the '<em>Data Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Data Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.DataStateImpl <em>Data State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.DataStateImpl
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getDataState()
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
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.UserDataCombinationImpl <em>User Data Combination</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.UserDataCombinationImpl
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getUserDataCombination()
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
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.FunctionalityImpl <em>Functionality</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.FunctionalityImpl
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getFunctionality()
	 * @generated
	 */
	int FUNCTIONALITY = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONALITY__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONALITY__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONALITY__REQUIRES = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Excludes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONALITY__EXCLUDES = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Allows For</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONALITY__ALLOWS_FOR = IdentifierPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Functionality</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONALITY_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Functionality</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONALITY_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.RoleImpl
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getRole()
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
	 * The feature id for the '<em><b>Always Allows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ALWAYS_ALLOWS = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Optionally Allows</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__OPTIONALLY_ALLOWS = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.PrivacyModelImpl <em>Privacy Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.PrivacyModelImpl
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getPrivacyModel()
	 * @generated
	 */
	int PRIVACY_MODEL = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIVACY_MODEL__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIVACY_MODEL__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Role Label Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIVACY_MODEL__ROLE_LABEL_TYPE = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Functionality Label Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIVACY_MODEL__FUNCTIONALITY_LABEL_TYPE = IdentifierPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Data Item Label Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIVACY_MODEL__DATA_ITEM_LABEL_TYPE = IdentifierPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Data State Label Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIVACY_MODEL__DATA_STATE_LABEL_TYPE = IdentifierPackage.ENTITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Data Context Label Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIVACY_MODEL__DATA_CONTEXT_LABEL_TYPE = IdentifierPackage.ENTITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Privacy Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIVACY_MODEL_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Privacy Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIVACY_MODEL_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.RoleLabelTypeImpl <em>Role Label Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.RoleLabelTypeImpl
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getRoleLabelType()
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
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.FunctionalityLabelTypeImpl <em>Functionality Label Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.FunctionalityLabelTypeImpl
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getFunctionalityLabelType()
	 * @generated
	 */
	int FUNCTIONALITY_LABEL_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONALITY_LABEL_TYPE__ID = datadictionaryPackage.ABSTRACT_LABEL_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONALITY_LABEL_TYPE__ENTITY_NAME = datadictionaryPackage.ABSTRACT_LABEL_TYPE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONALITY_LABEL_TYPE__LABELS = datadictionaryPackage.ABSTRACT_LABEL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Functionality Label Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONALITY_LABEL_TYPE_FEATURE_COUNT = datadictionaryPackage.ABSTRACT_LABEL_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Functionality Label Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONALITY_LABEL_TYPE_OPERATION_COUNT = datadictionaryPackage.ABSTRACT_LABEL_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.RoleLabelImpl <em>Role Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.RoleLabelImpl
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getRoleLabel()
	 * @generated
	 */
	int ROLE_LABEL = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_LABEL__ID = datadictionaryPackage.ABSTRACT_LABEL__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_LABEL__ENTITY_NAME = datadictionaryPackage.ABSTRACT_LABEL__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Role</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_LABEL__ROLE = datadictionaryPackage.ABSTRACT_LABEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Role Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_LABEL_FEATURE_COUNT = datadictionaryPackage.ABSTRACT_LABEL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Role Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_LABEL_OPERATION_COUNT = datadictionaryPackage.ABSTRACT_LABEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.FunctionalityLabelImpl <em>Functionality Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.FunctionalityLabelImpl
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getFunctionalityLabel()
	 * @generated
	 */
	int FUNCTIONALITY_LABEL = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONALITY_LABEL__ID = datadictionaryPackage.ABSTRACT_LABEL__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONALITY_LABEL__ENTITY_NAME = datadictionaryPackage.ABSTRACT_LABEL__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Functionality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONALITY_LABEL__FUNCTIONALITY = datadictionaryPackage.ABSTRACT_LABEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Functionality Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONALITY_LABEL_FEATURE_COUNT = datadictionaryPackage.ABSTRACT_LABEL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Functionality Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTIONALITY_LABEL_OPERATION_COUNT = datadictionaryPackage.ABSTRACT_LABEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.DataItemLabelTypeImpl <em>Data Item Label Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.DataItemLabelTypeImpl
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getDataItemLabelType()
	 * @generated
	 */
	int DATA_ITEM_LABEL_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM_LABEL_TYPE__ID = datadictionaryPackage.ABSTRACT_LABEL_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM_LABEL_TYPE__ENTITY_NAME = datadictionaryPackage.ABSTRACT_LABEL_TYPE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM_LABEL_TYPE__LABELS = datadictionaryPackage.ABSTRACT_LABEL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Item Label Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM_LABEL_TYPE_FEATURE_COUNT = datadictionaryPackage.ABSTRACT_LABEL_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Item Label Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM_LABEL_TYPE_OPERATION_COUNT = datadictionaryPackage.ABSTRACT_LABEL_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.DataItemLabelImpl <em>Data Item Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.DataItemLabelImpl
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getDataItemLabel()
	 * @generated
	 */
	int DATA_ITEM_LABEL = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM_LABEL__ID = datadictionaryPackage.ABSTRACT_LABEL__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM_LABEL__ENTITY_NAME = datadictionaryPackage.ABSTRACT_LABEL__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Data Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM_LABEL__DATA_ITEM = datadictionaryPackage.ABSTRACT_LABEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Item Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM_LABEL_FEATURE_COUNT = datadictionaryPackage.ABSTRACT_LABEL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Item Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_ITEM_LABEL_OPERATION_COUNT = datadictionaryPackage.ABSTRACT_LABEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.StatefulItemImpl <em>Stateful Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.StatefulItemImpl
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getStatefulItem()
	 * @generated
	 */
	int STATEFUL_ITEM = 12;

	/**
	 * The feature id for the '<em><b>State</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_ITEM__STATE = 0;

	/**
	 * The feature id for the '<em><b>Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_ITEM__ITEM = 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_ITEM__CONTEXT = 2;

	/**
	 * The number of structural features of the '<em>Stateful Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_ITEM_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Stateful Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_ITEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.DataStateLabelTypeImpl <em>Data State Label Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.DataStateLabelTypeImpl
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getDataStateLabelType()
	 * @generated
	 */
	int DATA_STATE_LABEL_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE_LABEL_TYPE__ID = datadictionaryPackage.ABSTRACT_LABEL_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE_LABEL_TYPE__ENTITY_NAME = datadictionaryPackage.ABSTRACT_LABEL_TYPE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE_LABEL_TYPE__LABELS = datadictionaryPackage.ABSTRACT_LABEL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data State Label Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE_LABEL_TYPE_FEATURE_COUNT = datadictionaryPackage.ABSTRACT_LABEL_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data State Label Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE_LABEL_TYPE_OPERATION_COUNT = datadictionaryPackage.ABSTRACT_LABEL_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.DataStateLabelImpl <em>Data State Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.DataStateLabelImpl
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getDataStateLabel()
	 * @generated
	 */
	int DATA_STATE_LABEL = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE_LABEL__ID = datadictionaryPackage.ABSTRACT_LABEL__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE_LABEL__ENTITY_NAME = datadictionaryPackage.ABSTRACT_LABEL__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Data State</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE_LABEL__DATA_STATE = datadictionaryPackage.ABSTRACT_LABEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data State Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE_LABEL_FEATURE_COUNT = datadictionaryPackage.ABSTRACT_LABEL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data State Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_STATE_LABEL_OPERATION_COUNT = datadictionaryPackage.ABSTRACT_LABEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.DataContextLabelTypeImpl <em>Data Context Label Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.DataContextLabelTypeImpl
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getDataContextLabelType()
	 * @generated
	 */
	int DATA_CONTEXT_LABEL_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_LABEL_TYPE__ID = datadictionaryPackage.ABSTRACT_LABEL_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_LABEL_TYPE__ENTITY_NAME = datadictionaryPackage.ABSTRACT_LABEL_TYPE__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_LABEL_TYPE__LABELS = datadictionaryPackage.ABSTRACT_LABEL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Context Label Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_LABEL_TYPE_FEATURE_COUNT = datadictionaryPackage.ABSTRACT_LABEL_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Context Label Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_LABEL_TYPE_OPERATION_COUNT = datadictionaryPackage.ABSTRACT_LABEL_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.DataContextLabelImpl <em>Data Context Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.DataContextLabelImpl
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getDataContextLabel()
	 * @generated
	 */
	int DATA_CONTEXT_LABEL = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_LABEL__ID = datadictionaryPackage.ABSTRACT_LABEL__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_LABEL__ENTITY_NAME = datadictionaryPackage.ABSTRACT_LABEL__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Data Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_LABEL__DATA_CONTEXT = datadictionaryPackage.ABSTRACT_LABEL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Context Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_LABEL_FEATURE_COUNT = datadictionaryPackage.ABSTRACT_LABEL_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Context Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_LABEL_OPERATION_COUNT = datadictionaryPackage.ABSTRACT_LABEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.DataContextImpl <em>Data Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.DataContextImpl
	 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getDataContext()
	 * @generated
	 */
	int DATA_CONTEXT = 17;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT__ID = IdentifierPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT__ENTITY_NAME = IdentifierPackage.ENTITY__ENTITY_NAME;

	/**
	 * The number of structural features of the '<em>Data Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_FEATURE_COUNT = IdentifierPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Data Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_CONTEXT_OPERATION_COUNT = IdentifierPackage.ENTITY_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.privacymodel.DataItem <em>Data Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Item</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataItem
	 * @generated
	 */
	EClass getDataItem();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.privacymodel.DataState <em>Data State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data State</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataState
	 * @generated
	 */
	EClass getDataState();

	/**
	 * Returns the meta object for the reference list '{@link org.dataflowanalysis.privacy.privacymodel.DataState#getNotRelatableWith <em>Not Relatable With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Not Relatable With</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataState#getNotRelatableWith()
	 * @see #getDataState()
	 * @generated
	 */
	EReference getDataState_NotRelatableWith();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.privacymodel.UserDataCombination <em>User Data Combination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Data Combination</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.UserDataCombination
	 * @generated
	 */
	EClass getUserDataCombination();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dataflowanalysis.privacy.privacymodel.UserDataCombination#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.UserDataCombination#getMembers()
	 * @see #getUserDataCombination()
	 * @generated
	 */
	EReference getUserDataCombination_Members();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.privacymodel.Functionality <em>Functionality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Functionality</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.Functionality
	 * @generated
	 */
	EClass getFunctionality();

	/**
	 * Returns the meta object for the reference list '{@link org.dataflowanalysis.privacy.privacymodel.Functionality#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requires</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.Functionality#getRequires()
	 * @see #getFunctionality()
	 * @generated
	 */
	EReference getFunctionality_Requires();

	/**
	 * Returns the meta object for the reference list '{@link org.dataflowanalysis.privacy.privacymodel.Functionality#getExcludes <em>Excludes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Excludes</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.Functionality#getExcludes()
	 * @see #getFunctionality()
	 * @generated
	 */
	EReference getFunctionality_Excludes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dataflowanalysis.privacy.privacymodel.Functionality#getAllowsFor <em>Allows For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Allows For</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.Functionality#getAllowsFor()
	 * @see #getFunctionality()
	 * @generated
	 */
	EReference getFunctionality_AllowsFor();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.privacymodel.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the reference list '{@link org.dataflowanalysis.privacy.privacymodel.Role#getAlwaysAllows <em>Always Allows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Always Allows</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.Role#getAlwaysAllows()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_AlwaysAllows();

	/**
	 * Returns the meta object for the reference list '{@link org.dataflowanalysis.privacy.privacymodel.Role#getOptionallyAllows <em>Optionally Allows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Optionally Allows</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.Role#getOptionallyAllows()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_OptionallyAllows();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.privacymodel.PrivacyModel <em>Privacy Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Privacy Model</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.PrivacyModel
	 * @generated
	 */
	EClass getPrivacyModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.dataflowanalysis.privacy.privacymodel.PrivacyModel#getRoleLabelType <em>Role Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Role Label Type</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.PrivacyModel#getRoleLabelType()
	 * @see #getPrivacyModel()
	 * @generated
	 */
	EReference getPrivacyModel_RoleLabelType();

	/**
	 * Returns the meta object for the containment reference '{@link org.dataflowanalysis.privacy.privacymodel.PrivacyModel#getFunctionalityLabelType <em>Functionality Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Functionality Label Type</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.PrivacyModel#getFunctionalityLabelType()
	 * @see #getPrivacyModel()
	 * @generated
	 */
	EReference getPrivacyModel_FunctionalityLabelType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dataflowanalysis.privacy.privacymodel.PrivacyModel#getDataItemLabelType <em>Data Item Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Item Label Type</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.PrivacyModel#getDataItemLabelType()
	 * @see #getPrivacyModel()
	 * @generated
	 */
	EReference getPrivacyModel_DataItemLabelType();

	/**
	 * Returns the meta object for the containment reference '{@link org.dataflowanalysis.privacy.privacymodel.PrivacyModel#getDataStateLabelType <em>Data State Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data State Label Type</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.PrivacyModel#getDataStateLabelType()
	 * @see #getPrivacyModel()
	 * @generated
	 */
	EReference getPrivacyModel_DataStateLabelType();

	/**
	 * Returns the meta object for the containment reference '{@link org.dataflowanalysis.privacy.privacymodel.PrivacyModel#getDataContextLabelType <em>Data Context Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Context Label Type</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.PrivacyModel#getDataContextLabelType()
	 * @see #getPrivacyModel()
	 * @generated
	 */
	EReference getPrivacyModel_DataContextLabelType();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.privacymodel.RoleLabelType <em>Role Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Label Type</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.RoleLabelType
	 * @generated
	 */
	EClass getRoleLabelType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dataflowanalysis.privacy.privacymodel.RoleLabelType#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Labels</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.RoleLabelType#getLabels()
	 * @see #getRoleLabelType()
	 * @generated
	 */
	EReference getRoleLabelType_Labels();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.privacymodel.FunctionalityLabelType <em>Functionality Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Functionality Label Type</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.FunctionalityLabelType
	 * @generated
	 */
	EClass getFunctionalityLabelType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dataflowanalysis.privacy.privacymodel.FunctionalityLabelType#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Labels</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.FunctionalityLabelType#getLabels()
	 * @see #getFunctionalityLabelType()
	 * @generated
	 */
	EReference getFunctionalityLabelType_Labels();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.privacymodel.RoleLabel <em>Role Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Label</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.RoleLabel
	 * @generated
	 */
	EClass getRoleLabel();

	/**
	 * Returns the meta object for the containment reference '{@link org.dataflowanalysis.privacy.privacymodel.RoleLabel#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Role</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.RoleLabel#getRole()
	 * @see #getRoleLabel()
	 * @generated
	 */
	EReference getRoleLabel_Role();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.privacymodel.FunctionalityLabel <em>Functionality Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Functionality Label</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.FunctionalityLabel
	 * @generated
	 */
	EClass getFunctionalityLabel();

	/**
	 * Returns the meta object for the containment reference '{@link org.dataflowanalysis.privacy.privacymodel.FunctionalityLabel#getFunctionality <em>Functionality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Functionality</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.FunctionalityLabel#getFunctionality()
	 * @see #getFunctionalityLabel()
	 * @generated
	 */
	EReference getFunctionalityLabel_Functionality();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.privacymodel.DataItemLabelType <em>Data Item Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Item Label Type</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataItemLabelType
	 * @generated
	 */
	EClass getDataItemLabelType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dataflowanalysis.privacy.privacymodel.DataItemLabelType#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Labels</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataItemLabelType#getLabels()
	 * @see #getDataItemLabelType()
	 * @generated
	 */
	EReference getDataItemLabelType_Labels();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.privacymodel.DataItemLabel <em>Data Item Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Item Label</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataItemLabel
	 * @generated
	 */
	EClass getDataItemLabel();

	/**
	 * Returns the meta object for the containment reference '{@link org.dataflowanalysis.privacy.privacymodel.DataItemLabel#getDataItem <em>Data Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Item</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataItemLabel#getDataItem()
	 * @see #getDataItemLabel()
	 * @generated
	 */
	EReference getDataItemLabel_DataItem();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.privacymodel.StatefulItem <em>Stateful Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stateful Item</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.StatefulItem
	 * @generated
	 */
	EClass getStatefulItem();

	/**
	 * Returns the meta object for the reference list '{@link org.dataflowanalysis.privacy.privacymodel.StatefulItem#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>State</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.StatefulItem#getState()
	 * @see #getStatefulItem()
	 * @generated
	 */
	EReference getStatefulItem_State();

	/**
	 * Returns the meta object for the reference '{@link org.dataflowanalysis.privacy.privacymodel.StatefulItem#getItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Item</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.StatefulItem#getItem()
	 * @see #getStatefulItem()
	 * @generated
	 */
	EReference getStatefulItem_Item();

	/**
	 * Returns the meta object for the reference list '{@link org.dataflowanalysis.privacy.privacymodel.StatefulItem#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Context</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.StatefulItem#getContext()
	 * @see #getStatefulItem()
	 * @generated
	 */
	EReference getStatefulItem_Context();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.privacymodel.DataStateLabelType <em>Data State Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data State Label Type</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataStateLabelType
	 * @generated
	 */
	EClass getDataStateLabelType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dataflowanalysis.privacy.privacymodel.DataStateLabelType#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Labels</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataStateLabelType#getLabels()
	 * @see #getDataStateLabelType()
	 * @generated
	 */
	EReference getDataStateLabelType_Labels();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.privacymodel.DataStateLabel <em>Data State Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data State Label</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataStateLabel
	 * @generated
	 */
	EClass getDataStateLabel();

	/**
	 * Returns the meta object for the containment reference '{@link org.dataflowanalysis.privacy.privacymodel.DataStateLabel#getDataState <em>Data State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data State</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataStateLabel#getDataState()
	 * @see #getDataStateLabel()
	 * @generated
	 */
	EReference getDataStateLabel_DataState();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.privacymodel.DataContextLabelType <em>Data Context Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Context Label Type</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataContextLabelType
	 * @generated
	 */
	EClass getDataContextLabelType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.dataflowanalysis.privacy.privacymodel.DataContextLabelType#getLabels <em>Labels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Labels</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataContextLabelType#getLabels()
	 * @see #getDataContextLabelType()
	 * @generated
	 */
	EReference getDataContextLabelType_Labels();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.privacymodel.DataContextLabel <em>Data Context Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Context Label</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataContextLabel
	 * @generated
	 */
	EClass getDataContextLabel();

	/**
	 * Returns the meta object for the containment reference '{@link org.dataflowanalysis.privacy.privacymodel.DataContextLabel#getDataContext <em>Data Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Context</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataContextLabel#getDataContext()
	 * @see #getDataContextLabel()
	 * @generated
	 */
	EReference getDataContextLabel_DataContext();

	/**
	 * Returns the meta object for class '{@link org.dataflowanalysis.privacy.privacymodel.DataContext <em>Data Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Context</em>'.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataContext
	 * @generated
	 */
	EClass getDataContext();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	privacymodelFactory getprivacymodelFactory();

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
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.DataItemImpl <em>Data Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.DataItemImpl
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getDataItem()
		 * @generated
		 */
		EClass DATA_ITEM = eINSTANCE.getDataItem();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.DataStateImpl <em>Data State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.DataStateImpl
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getDataState()
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
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.UserDataCombinationImpl <em>User Data Combination</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.UserDataCombinationImpl
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getUserDataCombination()
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
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.FunctionalityImpl <em>Functionality</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.FunctionalityImpl
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getFunctionality()
		 * @generated
		 */
		EClass FUNCTIONALITY = eINSTANCE.getFunctionality();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONALITY__REQUIRES = eINSTANCE.getFunctionality_Requires();

		/**
		 * The meta object literal for the '<em><b>Excludes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONALITY__EXCLUDES = eINSTANCE.getFunctionality_Excludes();

		/**
		 * The meta object literal for the '<em><b>Allows For</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONALITY__ALLOWS_FOR = eINSTANCE.getFunctionality_AllowsFor();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.RoleImpl
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '<em><b>Always Allows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE__ALWAYS_ALLOWS = eINSTANCE.getRole_AlwaysAllows();

		/**
		 * The meta object literal for the '<em><b>Optionally Allows</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE__OPTIONALLY_ALLOWS = eINSTANCE.getRole_OptionallyAllows();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.PrivacyModelImpl <em>Privacy Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.PrivacyModelImpl
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getPrivacyModel()
		 * @generated
		 */
		EClass PRIVACY_MODEL = eINSTANCE.getPrivacyModel();

		/**
		 * The meta object literal for the '<em><b>Role Label Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIVACY_MODEL__ROLE_LABEL_TYPE = eINSTANCE.getPrivacyModel_RoleLabelType();

		/**
		 * The meta object literal for the '<em><b>Functionality Label Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIVACY_MODEL__FUNCTIONALITY_LABEL_TYPE = eINSTANCE.getPrivacyModel_FunctionalityLabelType();

		/**
		 * The meta object literal for the '<em><b>Data Item Label Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIVACY_MODEL__DATA_ITEM_LABEL_TYPE = eINSTANCE.getPrivacyModel_DataItemLabelType();

		/**
		 * The meta object literal for the '<em><b>Data State Label Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIVACY_MODEL__DATA_STATE_LABEL_TYPE = eINSTANCE.getPrivacyModel_DataStateLabelType();

		/**
		 * The meta object literal for the '<em><b>Data Context Label Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIVACY_MODEL__DATA_CONTEXT_LABEL_TYPE = eINSTANCE.getPrivacyModel_DataContextLabelType();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.RoleLabelTypeImpl <em>Role Label Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.RoleLabelTypeImpl
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getRoleLabelType()
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
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.FunctionalityLabelTypeImpl <em>Functionality Label Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.FunctionalityLabelTypeImpl
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getFunctionalityLabelType()
		 * @generated
		 */
		EClass FUNCTIONALITY_LABEL_TYPE = eINSTANCE.getFunctionalityLabelType();

		/**
		 * The meta object literal for the '<em><b>Labels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONALITY_LABEL_TYPE__LABELS = eINSTANCE.getFunctionalityLabelType_Labels();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.RoleLabelImpl <em>Role Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.RoleLabelImpl
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getRoleLabel()
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
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.FunctionalityLabelImpl <em>Functionality Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.FunctionalityLabelImpl
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getFunctionalityLabel()
		 * @generated
		 */
		EClass FUNCTIONALITY_LABEL = eINSTANCE.getFunctionalityLabel();

		/**
		 * The meta object literal for the '<em><b>Functionality</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTIONALITY_LABEL__FUNCTIONALITY = eINSTANCE.getFunctionalityLabel_Functionality();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.DataItemLabelTypeImpl <em>Data Item Label Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.DataItemLabelTypeImpl
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getDataItemLabelType()
		 * @generated
		 */
		EClass DATA_ITEM_LABEL_TYPE = eINSTANCE.getDataItemLabelType();

		/**
		 * The meta object literal for the '<em><b>Labels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_ITEM_LABEL_TYPE__LABELS = eINSTANCE.getDataItemLabelType_Labels();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.DataItemLabelImpl <em>Data Item Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.DataItemLabelImpl
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getDataItemLabel()
		 * @generated
		 */
		EClass DATA_ITEM_LABEL = eINSTANCE.getDataItemLabel();

		/**
		 * The meta object literal for the '<em><b>Data Item</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_ITEM_LABEL__DATA_ITEM = eINSTANCE.getDataItemLabel_DataItem();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.StatefulItemImpl <em>Stateful Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.StatefulItemImpl
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getStatefulItem()
		 * @generated
		 */
		EClass STATEFUL_ITEM = eINSTANCE.getStatefulItem();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATEFUL_ITEM__STATE = eINSTANCE.getStatefulItem_State();

		/**
		 * The meta object literal for the '<em><b>Item</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATEFUL_ITEM__ITEM = eINSTANCE.getStatefulItem_Item();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATEFUL_ITEM__CONTEXT = eINSTANCE.getStatefulItem_Context();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.DataStateLabelTypeImpl <em>Data State Label Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.DataStateLabelTypeImpl
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getDataStateLabelType()
		 * @generated
		 */
		EClass DATA_STATE_LABEL_TYPE = eINSTANCE.getDataStateLabelType();

		/**
		 * The meta object literal for the '<em><b>Labels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_STATE_LABEL_TYPE__LABELS = eINSTANCE.getDataStateLabelType_Labels();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.DataStateLabelImpl <em>Data State Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.DataStateLabelImpl
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getDataStateLabel()
		 * @generated
		 */
		EClass DATA_STATE_LABEL = eINSTANCE.getDataStateLabel();

		/**
		 * The meta object literal for the '<em><b>Data State</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_STATE_LABEL__DATA_STATE = eINSTANCE.getDataStateLabel_DataState();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.DataContextLabelTypeImpl <em>Data Context Label Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.DataContextLabelTypeImpl
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getDataContextLabelType()
		 * @generated
		 */
		EClass DATA_CONTEXT_LABEL_TYPE = eINSTANCE.getDataContextLabelType();

		/**
		 * The meta object literal for the '<em><b>Labels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CONTEXT_LABEL_TYPE__LABELS = eINSTANCE.getDataContextLabelType_Labels();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.DataContextLabelImpl <em>Data Context Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.DataContextLabelImpl
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getDataContextLabel()
		 * @generated
		 */
		EClass DATA_CONTEXT_LABEL = eINSTANCE.getDataContextLabel();

		/**
		 * The meta object literal for the '<em><b>Data Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_CONTEXT_LABEL__DATA_CONTEXT = eINSTANCE.getDataContextLabel_DataContext();

		/**
		 * The meta object literal for the '{@link org.dataflowanalysis.privacy.privacymodel.impl.DataContextImpl <em>Data Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.DataContextImpl
		 * @see org.dataflowanalysis.privacy.privacymodel.impl.privacymodelPackageImpl#getDataContext()
		 * @generated
		 */
		EClass DATA_CONTEXT = eINSTANCE.getDataContext();

	}

} //privacymodelPackage

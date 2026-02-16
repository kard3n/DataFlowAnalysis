/**
 */
package org.dataflowanalysis.privacy.consent_model.impl;

import org.dataflowanalysis.privacy.consent_model.*;

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
public class Consent_modelFactoryImpl extends EFactoryImpl implements Consent_modelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Consent_modelFactory init() {
		try {
			Consent_modelFactory theConsent_modelFactory = (Consent_modelFactory) EPackage.Registry.INSTANCE
					.getEFactory(Consent_modelPackage.eNS_URI);
			if (theConsent_modelFactory != null) {
				return theConsent_modelFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Consent_modelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Consent_modelFactoryImpl() {
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
		case Consent_modelPackage.DATA_ITEM:
			return createDataItem();
		case Consent_modelPackage.DATA_STATE:
			return createDataState();
		case Consent_modelPackage.USER_DATA_COMBINATION:
			return createUserDataCombination();
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY:
			return createConsentedFunctionality();
		case Consent_modelPackage.ROLE:
			return createRole();
		case Consent_modelPackage.CONSENT_MODEL:
			return createConsentModel();
		case Consent_modelPackage.ROLE_LABEL_TYPE:
			return createRoleLabelType();
		case Consent_modelPackage.ROLE_LABEL:
			return createRoleLabel();
		case Consent_modelPackage.CONSENT_LABEL_TYPE:
			return createConsentLabelType();
		case Consent_modelPackage.CONSENT_LABEL:
			return createConsentLabel();
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
	public ConsentedFunctionality createConsentedFunctionality() {
		ConsentedFunctionalityImpl consentedFunctionality = new ConsentedFunctionalityImpl();
		return consentedFunctionality;
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
	public Consent_modelPackage getConsent_modelPackage() {
		return (Consent_modelPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Consent_modelPackage getPackage() {
		return Consent_modelPackage.eINSTANCE;
	}

} //Consent_modelFactoryImpl

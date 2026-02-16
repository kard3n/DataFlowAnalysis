/**
 */
package org.dataflowanalysis.privacy.consent_model.util;

import identifier.Entity;
import identifier.Identifier;
import identifier.NamedElement;
import org.dataflowanalysis.dfd.datadictionary.Label;
import org.dataflowanalysis.dfd.datadictionary.LabelType;
import org.dataflowanalysis.privacy.consent_model.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage
 * @generated
 */
public class Consent_modelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Consent_modelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Consent_modelSwitch() {
		if (modelPackage == null) {
			modelPackage = Consent_modelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case Consent_modelPackage.DATA_ITEM: {
			DataItem dataItem = (DataItem) theEObject;
			T result = caseDataItem(dataItem);
			if (result == null)
				result = caseEntity(dataItem);
			if (result == null)
				result = caseIdentifier(dataItem);
			if (result == null)
				result = caseNamedElement(dataItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Consent_modelPackage.DATA_STATE: {
			DataState dataState = (DataState) theEObject;
			T result = caseDataState(dataState);
			if (result == null)
				result = caseEntity(dataState);
			if (result == null)
				result = caseIdentifier(dataState);
			if (result == null)
				result = caseNamedElement(dataState);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Consent_modelPackage.USER_DATA_COMBINATION: {
			UserDataCombination userDataCombination = (UserDataCombination) theEObject;
			T result = caseUserDataCombination(userDataCombination);
			if (result == null)
				result = caseEntity(userDataCombination);
			if (result == null)
				result = caseIdentifier(userDataCombination);
			if (result == null)
				result = caseNamedElement(userDataCombination);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Consent_modelPackage.CONSENTED_FUNCTIONALITY: {
			ConsentedFunctionality consentedFunctionality = (ConsentedFunctionality) theEObject;
			T result = caseConsentedFunctionality(consentedFunctionality);
			if (result == null)
				result = caseEntity(consentedFunctionality);
			if (result == null)
				result = caseIdentifier(consentedFunctionality);
			if (result == null)
				result = caseNamedElement(consentedFunctionality);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Consent_modelPackage.ROLE: {
			Role role = (Role) theEObject;
			T result = caseRole(role);
			if (result == null)
				result = caseEntity(role);
			if (result == null)
				result = caseIdentifier(role);
			if (result == null)
				result = caseNamedElement(role);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Consent_modelPackage.CONSENT_MODEL: {
			ConsentModel consentModel = (ConsentModel) theEObject;
			T result = caseConsentModel(consentModel);
			if (result == null)
				result = caseEntity(consentModel);
			if (result == null)
				result = caseIdentifier(consentModel);
			if (result == null)
				result = caseNamedElement(consentModel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Consent_modelPackage.ROLE_LABEL_TYPE: {
			RoleLabelType roleLabelType = (RoleLabelType) theEObject;
			T result = caseRoleLabelType(roleLabelType);
			if (result == null)
				result = caseLabelType(roleLabelType);
			if (result == null)
				result = caseEntity(roleLabelType);
			if (result == null)
				result = caseIdentifier(roleLabelType);
			if (result == null)
				result = caseNamedElement(roleLabelType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Consent_modelPackage.ROLE_LABEL: {
			RoleLabel roleLabel = (RoleLabel) theEObject;
			T result = caseRoleLabel(roleLabel);
			if (result == null)
				result = caseLabel(roleLabel);
			if (result == null)
				result = caseEntity(roleLabel);
			if (result == null)
				result = caseIdentifier(roleLabel);
			if (result == null)
				result = caseNamedElement(roleLabel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Consent_modelPackage.CONSENT_LABEL_TYPE: {
			ConsentLabelType consentLabelType = (ConsentLabelType) theEObject;
			T result = caseConsentLabelType(consentLabelType);
			if (result == null)
				result = caseLabelType(consentLabelType);
			if (result == null)
				result = caseEntity(consentLabelType);
			if (result == null)
				result = caseIdentifier(consentLabelType);
			if (result == null)
				result = caseNamedElement(consentLabelType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case Consent_modelPackage.CONSENT_LABEL: {
			ConsentLabel consentLabel = (ConsentLabel) theEObject;
			T result = caseConsentLabel(consentLabel);
			if (result == null)
				result = caseLabel(consentLabel);
			if (result == null)
				result = caseEntity(consentLabel);
			if (result == null)
				result = caseIdentifier(consentLabel);
			if (result == null)
				result = caseNamedElement(consentLabel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataItem(DataItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataState(DataState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User Data Combination</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User Data Combination</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUserDataCombination(UserDataCombination object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Consented Functionality</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Consented Functionality</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConsentedFunctionality(ConsentedFunctionality object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRole(Role object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Consent Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Consent Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConsentModel(ConsentModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role Label Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role Label Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoleLabelType(RoleLabelType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Role Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoleLabel(RoleLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Consent Label Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Consent Label Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConsentLabelType(ConsentLabelType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Consent Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Consent Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConsentLabel(ConsentLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntity(Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabelType(LabelType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabel(Label object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //Consent_modelSwitch

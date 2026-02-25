/**
 */
package org.dataflowanalysis.privacy.consentmodel.util;

import org.dataflowanalysis.dfd.datadictionary.AbstractLabel;
import org.dataflowanalysis.dfd.datadictionary.AbstractLabelType;

import org.dataflowanalysis.privacy.consentmodel.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import tools.mdsd.modelingfoundations.identifier.Entity;
import tools.mdsd.modelingfoundations.identifier.Identifier;
import tools.mdsd.modelingfoundations.identifier.NamedElement;

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
 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage
 * @generated
 */
public class consentmodelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static consentmodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public consentmodelSwitch() {
		if (modelPackage == null) {
			modelPackage = consentmodelPackage.eINSTANCE;
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
		case consentmodelPackage.DATA_ITEM: {
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
		case consentmodelPackage.DATA_STATE: {
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
		case consentmodelPackage.USER_DATA_COMBINATION: {
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
		case consentmodelPackage.CONSENT_OPTION: {
			ConsentOption consentOption = (ConsentOption) theEObject;
			T result = caseConsentOption(consentOption);
			if (result == null)
				result = caseEntity(consentOption);
			if (result == null)
				result = caseIdentifier(consentOption);
			if (result == null)
				result = caseNamedElement(consentOption);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case consentmodelPackage.ROLE: {
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
		case consentmodelPackage.CONSENT_MODEL: {
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
		case consentmodelPackage.ROLE_LABEL_TYPE: {
			RoleLabelType roleLabelType = (RoleLabelType) theEObject;
			T result = caseRoleLabelType(roleLabelType);
			if (result == null)
				result = caseAbstractLabelType(roleLabelType);
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
		case consentmodelPackage.CONSENT_LABEL_TYPE: {
			ConsentLabelType consentLabelType = (ConsentLabelType) theEObject;
			T result = caseConsentLabelType(consentLabelType);
			if (result == null)
				result = caseAbstractLabelType(consentLabelType);
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
		case consentmodelPackage.ROLE_LABEL: {
			RoleLabel roleLabel = (RoleLabel) theEObject;
			T result = caseRoleLabel(roleLabel);
			if (result == null)
				result = caseAbstractLabel(roleLabel);
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
		case consentmodelPackage.CONSENT_LABEL: {
			ConsentLabel consentLabel = (ConsentLabel) theEObject;
			T result = caseConsentLabel(consentLabel);
			if (result == null)
				result = caseAbstractLabel(consentLabel);
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
		case consentmodelPackage.DATA_ITEM_LABEL_TYPE: {
			DataItemLabelType dataItemLabelType = (DataItemLabelType) theEObject;
			T result = caseDataItemLabelType(dataItemLabelType);
			if (result == null)
				result = caseAbstractLabelType(dataItemLabelType);
			if (result == null)
				result = caseEntity(dataItemLabelType);
			if (result == null)
				result = caseIdentifier(dataItemLabelType);
			if (result == null)
				result = caseNamedElement(dataItemLabelType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case consentmodelPackage.DATA_ITEM_LABEL: {
			DataItemLabel dataItemLabel = (DataItemLabel) theEObject;
			T result = caseDataItemLabel(dataItemLabel);
			if (result == null)
				result = caseAbstractLabel(dataItemLabel);
			if (result == null)
				result = caseEntity(dataItemLabel);
			if (result == null)
				result = caseIdentifier(dataItemLabel);
			if (result == null)
				result = caseNamedElement(dataItemLabel);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case consentmodelPackage.STATEFUL_ITEM: {
			StatefulItem statefulItem = (StatefulItem) theEObject;
			T result = caseStatefulItem(statefulItem);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case consentmodelPackage.DATA_STATE_LABEL_TYPE: {
			DataStateLabelType dataStateLabelType = (DataStateLabelType) theEObject;
			T result = caseDataStateLabelType(dataStateLabelType);
			if (result == null)
				result = caseAbstractLabelType(dataStateLabelType);
			if (result == null)
				result = caseEntity(dataStateLabelType);
			if (result == null)
				result = caseIdentifier(dataStateLabelType);
			if (result == null)
				result = caseNamedElement(dataStateLabelType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case consentmodelPackage.DATA_STATE_LABEL: {
			DataStateLabel dataStateLabel = (DataStateLabel) theEObject;
			T result = caseDataStateLabel(dataStateLabel);
			if (result == null)
				result = caseAbstractLabel(dataStateLabel);
			if (result == null)
				result = caseEntity(dataStateLabel);
			if (result == null)
				result = caseIdentifier(dataStateLabel);
			if (result == null)
				result = caseNamedElement(dataStateLabel);
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
	 * Returns the result of interpreting the object as an instance of '<em>Consent Option</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Consent Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConsentOption(ConsentOption object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Data Item Label Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Item Label Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataItemLabelType(DataItemLabelType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Item Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Item Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataItemLabel(DataItemLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stateful Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stateful Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatefulItem(StatefulItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data State Label Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data State Label Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataStateLabelType(DataStateLabelType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data State Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data State Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataStateLabel(DataStateLabel object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Label Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Label Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractLabelType(AbstractLabelType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractLabel(AbstractLabel object) {
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

} //consentmodelSwitch

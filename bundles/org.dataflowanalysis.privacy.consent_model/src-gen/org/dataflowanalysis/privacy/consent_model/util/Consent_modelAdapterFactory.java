/**
 */
package org.dataflowanalysis.privacy.consent_model.util;

import identifier.Entity;
import identifier.Identifier;
import identifier.NamedElement;
import org.dataflowanalysis.dfd.datadictionary.Label;
import org.dataflowanalysis.dfd.datadictionary.LabelType;
import org.dataflowanalysis.privacy.consent_model.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage
 * @generated
 */
public class Consent_modelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Consent_modelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Consent_modelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Consent_modelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Consent_modelSwitch<Adapter> modelSwitch = new Consent_modelSwitch<Adapter>() {
		@Override
		public Adapter caseDataItem(DataItem object) {
			return createDataItemAdapter();
		}

		@Override
		public Adapter caseDataState(DataState object) {
			return createDataStateAdapter();
		}

		@Override
		public Adapter caseUserDataCombination(UserDataCombination object) {
			return createUserDataCombinationAdapter();
		}

		@Override
		public Adapter caseConsentedFunctionality(ConsentedFunctionality object) {
			return createConsentedFunctionalityAdapter();
		}

		@Override
		public Adapter caseRole(Role object) {
			return createRoleAdapter();
		}

		@Override
		public Adapter caseConsentModel(ConsentModel object) {
			return createConsentModelAdapter();
		}

		@Override
		public Adapter caseRoleLabelType(RoleLabelType object) {
			return createRoleLabelTypeAdapter();
		}

		@Override
		public Adapter caseRoleLabel(RoleLabel object) {
			return createRoleLabelAdapter();
		}

		@Override
		public Adapter caseConsentLabelType(ConsentLabelType object) {
			return createConsentLabelTypeAdapter();
		}

		@Override
		public Adapter caseConsentLabel(ConsentLabel object) {
			return createConsentLabelAdapter();
		}

		@Override
		public Adapter caseIdentifier(Identifier object) {
			return createIdentifierAdapter();
		}

		@Override
		public Adapter caseNamedElement(NamedElement object) {
			return createNamedElementAdapter();
		}

		@Override
		public Adapter caseEntity(Entity object) {
			return createEntityAdapter();
		}

		@Override
		public Adapter caseLabelType(LabelType object) {
			return createLabelTypeAdapter();
		}

		@Override
		public Adapter caseLabel(Label object) {
			return createLabelAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consent_model.DataItem <em>Data Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consent_model.DataItem
	 * @generated
	 */
	public Adapter createDataItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consent_model.DataState <em>Data State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consent_model.DataState
	 * @generated
	 */
	public Adapter createDataStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consent_model.UserDataCombination <em>User Data Combination</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consent_model.UserDataCombination
	 * @generated
	 */
	public Adapter createUserDataCombinationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consent_model.ConsentedFunctionality <em>Consented Functionality</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consent_model.ConsentedFunctionality
	 * @generated
	 */
	public Adapter createConsentedFunctionalityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consent_model.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consent_model.Role
	 * @generated
	 */
	public Adapter createRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consent_model.ConsentModel <em>Consent Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consent_model.ConsentModel
	 * @generated
	 */
	public Adapter createConsentModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consent_model.RoleLabelType <em>Role Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consent_model.RoleLabelType
	 * @generated
	 */
	public Adapter createRoleLabelTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consent_model.RoleLabel <em>Role Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consent_model.RoleLabel
	 * @generated
	 */
	public Adapter createRoleLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consent_model.ConsentLabelType <em>Consent Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consent_model.ConsentLabelType
	 * @generated
	 */
	public Adapter createConsentLabelTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consent_model.ConsentLabel <em>Consent Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consent_model.ConsentLabel
	 * @generated
	 */
	public Adapter createConsentLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link identifier.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see identifier.Identifier
	 * @generated
	 */
	public Adapter createIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link identifier.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see identifier.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link identifier.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see identifier.Entity
	 * @generated
	 */
	public Adapter createEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.dfd.datadictionary.LabelType <em>Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.dfd.datadictionary.LabelType
	 * @generated
	 */
	public Adapter createLabelTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.dfd.datadictionary.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.dfd.datadictionary.Label
	 * @generated
	 */
	public Adapter createLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //Consent_modelAdapterFactory

/**
 */
package org.dataflowanalysis.privacy.consentmodel.util;

import org.dataflowanalysis.dfd.datadictionary.AbstractLabel;
import org.dataflowanalysis.dfd.datadictionary.AbstractLabelType;

import org.dataflowanalysis.privacy.consentmodel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import tools.mdsd.modelingfoundations.identifier.Entity;
import tools.mdsd.modelingfoundations.identifier.Identifier;
import tools.mdsd.modelingfoundations.identifier.NamedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.dataflowanalysis.privacy.consentmodel.consentmodelPackage
 * @generated
 */
public class consentmodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static consentmodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public consentmodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = consentmodelPackage.eINSTANCE;
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
	protected consentmodelSwitch<Adapter> modelSwitch = new consentmodelSwitch<Adapter>() {
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
		public Adapter caseConsentOption(ConsentOption object) {
			return createConsentOptionAdapter();
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
		public Adapter caseConsentLabelType(ConsentLabelType object) {
			return createConsentLabelTypeAdapter();
		}

		@Override
		public Adapter caseRoleLabel(RoleLabel object) {
			return createRoleLabelAdapter();
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
		public Adapter caseAbstractLabelType(AbstractLabelType object) {
			return createAbstractLabelTypeAdapter();
		}

		@Override
		public Adapter caseAbstractLabel(AbstractLabel object) {
			return createAbstractLabelAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consentmodel.DataItem <em>Data Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consentmodel.DataItem
	 * @generated
	 */
	public Adapter createDataItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consentmodel.DataState <em>Data State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consentmodel.DataState
	 * @generated
	 */
	public Adapter createDataStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consentmodel.UserDataCombination <em>User Data Combination</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consentmodel.UserDataCombination
	 * @generated
	 */
	public Adapter createUserDataCombinationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consentmodel.ConsentOption <em>Consent Option</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consentmodel.ConsentOption
	 * @generated
	 */
	public Adapter createConsentOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consentmodel.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consentmodel.Role
	 * @generated
	 */
	public Adapter createRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consentmodel.ConsentModel <em>Consent Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consentmodel.ConsentModel
	 * @generated
	 */
	public Adapter createConsentModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consentmodel.RoleLabelType <em>Role Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consentmodel.RoleLabelType
	 * @generated
	 */
	public Adapter createRoleLabelTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consentmodel.ConsentLabelType <em>Consent Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consentmodel.ConsentLabelType
	 * @generated
	 */
	public Adapter createConsentLabelTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consentmodel.RoleLabel <em>Role Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consentmodel.RoleLabel
	 * @generated
	 */
	public Adapter createRoleLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.consentmodel.ConsentLabel <em>Consent Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.consentmodel.ConsentLabel
	 * @generated
	 */
	public Adapter createConsentLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.mdsd.modelingfoundations.identifier.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.mdsd.modelingfoundations.identifier.Identifier
	 * @generated
	 */
	public Adapter createIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.mdsd.modelingfoundations.identifier.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.mdsd.modelingfoundations.identifier.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link tools.mdsd.modelingfoundations.identifier.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.mdsd.modelingfoundations.identifier.Entity
	 * @generated
	 */
	public Adapter createEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.dfd.datadictionary.AbstractLabelType <em>Abstract Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.dfd.datadictionary.AbstractLabelType
	 * @generated
	 */
	public Adapter createAbstractLabelTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.dfd.datadictionary.AbstractLabel <em>Abstract Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.dfd.datadictionary.AbstractLabel
	 * @generated
	 */
	public Adapter createAbstractLabelAdapter() {
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

} //consentmodelAdapterFactory

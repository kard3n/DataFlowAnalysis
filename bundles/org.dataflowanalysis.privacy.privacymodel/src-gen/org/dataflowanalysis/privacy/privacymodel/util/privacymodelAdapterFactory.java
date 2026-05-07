/**
 */
package org.dataflowanalysis.privacy.privacymodel.util;

import org.dataflowanalysis.dfd.datadictionary.AbstractLabel;
import org.dataflowanalysis.dfd.datadictionary.AbstractLabelType;

import org.dataflowanalysis.privacy.privacymodel.*;

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
 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage
 * @generated
 */
public class privacymodelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static privacymodelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public privacymodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = privacymodelPackage.eINSTANCE;
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
	protected privacymodelSwitch<Adapter> modelSwitch = new privacymodelSwitch<Adapter>() {
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
		public Adapter caseFunctionality(Functionality object) {
			return createFunctionalityAdapter();
		}

		@Override
		public Adapter caseRole(Role object) {
			return createRoleAdapter();
		}

		@Override
		public Adapter casePrivacyModel(PrivacyModel object) {
			return createPrivacyModelAdapter();
		}

		@Override
		public Adapter caseRoleLabelType(RoleLabelType object) {
			return createRoleLabelTypeAdapter();
		}

		@Override
		public Adapter caseFunctionalityLabelType(FunctionalityLabelType object) {
			return createFunctionalityLabelTypeAdapter();
		}

		@Override
		public Adapter caseRoleLabel(RoleLabel object) {
			return createRoleLabelAdapter();
		}

		@Override
		public Adapter caseFunctionalityLabel(FunctionalityLabel object) {
			return createFunctionalityLabelAdapter();
		}

		@Override
		public Adapter caseDataItemLabelType(DataItemLabelType object) {
			return createDataItemLabelTypeAdapter();
		}

		@Override
		public Adapter caseDataItemLabel(DataItemLabel object) {
			return createDataItemLabelAdapter();
		}

		@Override
		public Adapter caseStatefulItem(StatefulItem object) {
			return createStatefulItemAdapter();
		}

		@Override
		public Adapter caseDataStateLabelType(DataStateLabelType object) {
			return createDataStateLabelTypeAdapter();
		}

		@Override
		public Adapter caseDataStateLabel(DataStateLabel object) {
			return createDataStateLabelAdapter();
		}

		@Override
		public Adapter caseDataContextLabelType(DataContextLabelType object) {
			return createDataContextLabelTypeAdapter();
		}

		@Override
		public Adapter caseDataContextLabel(DataContextLabel object) {
			return createDataContextLabelAdapter();
		}

		@Override
		public Adapter caseDataContext(DataContext object) {
			return createDataContextAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.privacymodel.DataItem <em>Data Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataItem
	 * @generated
	 */
	public Adapter createDataItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.privacymodel.DataState <em>Data State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataState
	 * @generated
	 */
	public Adapter createDataStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.privacymodel.UserDataCombination <em>User Data Combination</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.privacymodel.UserDataCombination
	 * @generated
	 */
	public Adapter createUserDataCombinationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.privacymodel.Functionality <em>Functionality</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.privacymodel.Functionality
	 * @generated
	 */
	public Adapter createFunctionalityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.privacymodel.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.privacymodel.Role
	 * @generated
	 */
	public Adapter createRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.privacymodel.PrivacyModel <em>Privacy Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.privacymodel.PrivacyModel
	 * @generated
	 */
	public Adapter createPrivacyModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.privacymodel.RoleLabelType <em>Role Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.privacymodel.RoleLabelType
	 * @generated
	 */
	public Adapter createRoleLabelTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.privacymodel.FunctionalityLabelType <em>Functionality Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.privacymodel.FunctionalityLabelType
	 * @generated
	 */
	public Adapter createFunctionalityLabelTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.privacymodel.RoleLabel <em>Role Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.privacymodel.RoleLabel
	 * @generated
	 */
	public Adapter createRoleLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.privacymodel.FunctionalityLabel <em>Functionality Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.privacymodel.FunctionalityLabel
	 * @generated
	 */
	public Adapter createFunctionalityLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.privacymodel.DataItemLabelType <em>Data Item Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataItemLabelType
	 * @generated
	 */
	public Adapter createDataItemLabelTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.privacymodel.DataItemLabel <em>Data Item Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataItemLabel
	 * @generated
	 */
	public Adapter createDataItemLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.privacymodel.StatefulItem <em>Stateful Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.privacymodel.StatefulItem
	 * @generated
	 */
	public Adapter createStatefulItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.privacymodel.DataStateLabelType <em>Data State Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataStateLabelType
	 * @generated
	 */
	public Adapter createDataStateLabelTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.privacymodel.DataStateLabel <em>Data State Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataStateLabel
	 * @generated
	 */
	public Adapter createDataStateLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.privacymodel.DataContextLabelType <em>Data Context Label Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataContextLabelType
	 * @generated
	 */
	public Adapter createDataContextLabelTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.privacymodel.DataContextLabel <em>Data Context Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataContextLabel
	 * @generated
	 */
	public Adapter createDataContextLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.dataflowanalysis.privacy.privacymodel.DataContext <em>Data Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.dataflowanalysis.privacy.privacymodel.DataContext
	 * @generated
	 */
	public Adapter createDataContextAdapter() {
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

} //privacymodelAdapterFactory

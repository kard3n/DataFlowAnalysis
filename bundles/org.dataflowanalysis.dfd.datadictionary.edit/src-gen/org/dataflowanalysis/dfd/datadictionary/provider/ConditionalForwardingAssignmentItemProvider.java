/**
 */
package org.dataflowanalysis.dfd.datadictionary.provider;

import java.util.Collection;
import java.util.List;

import org.dataflowanalysis.dfd.datadictionary.ConditionalForwardingAssignment;
import org.dataflowanalysis.dfd.datadictionary.datadictionaryFactory;
import org.dataflowanalysis.dfd.datadictionary.datadictionaryPackage;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import tools.mdsd.modelingfoundations.identifier.provider.EntityItemProvider;

/**
 * This is the item provider adapter for a {@link org.dataflowanalysis.dfd.datadictionary.ConditionalForwardingAssignment} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ConditionalForwardingAssignmentItemProvider extends EntityItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalForwardingAssignmentItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addOutputPinPropertyDescriptor(object);
			addTermInputPinsPropertyDescriptor(object);
			addInputPinsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Output Pin feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutputPinPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_AbstractAssignment_outputPin_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_AbstractAssignment_outputPin_feature",
						"_UI_AbstractAssignment_type"),
				datadictionaryPackage.Literals.ABSTRACT_ASSIGNMENT__OUTPUT_PIN, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Term Input Pins feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTermInputPinsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ConditionalForwardingAssignment_termInputPins_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_ConditionalForwardingAssignment_termInputPins_feature",
								"_UI_ConditionalForwardingAssignment_type"),
						datadictionaryPackage.Literals.CONDITIONAL_FORWARDING_ASSIGNMENT__TERM_INPUT_PINS, true, false,
						true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Input Pins feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInputPinsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ConditionalForwardingAssignment_inputPins_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ConditionalForwardingAssignment_inputPins_feature",
						"_UI_ConditionalForwardingAssignment_type"),
				datadictionaryPackage.Literals.CONDITIONAL_FORWARDING_ASSIGNMENT__INPUT_PINS, true, false, true, null,
				null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(datadictionaryPackage.Literals.CONDITIONAL_FORWARDING_ASSIGNMENT__TERM);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ConditionalForwardingAssignment.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ConditionalForwardingAssignment"));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ConditionalForwardingAssignment) object).getId();
		return label == null || label.length() == 0 ? getString("_UI_ConditionalForwardingAssignment_type")
				: getString("_UI_ConditionalForwardingAssignment_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ConditionalForwardingAssignment.class)) {
		case datadictionaryPackage.CONDITIONAL_FORWARDING_ASSIGNMENT__TERM:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors
				.add(createChildParameter(datadictionaryPackage.Literals.CONDITIONAL_FORWARDING_ASSIGNMENT__TERM,
						datadictionaryFactory.eINSTANCE.createTRUE()));

		newChildDescriptors
				.add(createChildParameter(datadictionaryPackage.Literals.CONDITIONAL_FORWARDING_ASSIGNMENT__TERM,
						datadictionaryFactory.eINSTANCE.createAND()));

		newChildDescriptors
				.add(createChildParameter(datadictionaryPackage.Literals.CONDITIONAL_FORWARDING_ASSIGNMENT__TERM,
						datadictionaryFactory.eINSTANCE.createOR()));

		newChildDescriptors
				.add(createChildParameter(datadictionaryPackage.Literals.CONDITIONAL_FORWARDING_ASSIGNMENT__TERM,
						datadictionaryFactory.eINSTANCE.createNOT()));

		newChildDescriptors
				.add(createChildParameter(datadictionaryPackage.Literals.CONDITIONAL_FORWARDING_ASSIGNMENT__TERM,
						datadictionaryFactory.eINSTANCE.createLabelReference()));
	}

}

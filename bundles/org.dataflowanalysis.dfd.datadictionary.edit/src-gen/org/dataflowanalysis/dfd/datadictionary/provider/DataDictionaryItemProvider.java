/**
 */
package org.dataflowanalysis.dfd.datadictionary.provider;

import java.util.Collection;
import java.util.List;
import org.dataflowanalysis.dfd.datadictionary.DataDictionary;
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
 * This is the item provider adapter for a {@link org.dataflowanalysis.dfd.datadictionary.DataDictionary} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class DataDictionaryItemProvider extends EntityItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DataDictionaryItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addConsentModelPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Consent Model feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConsentModelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_DataDictionary_consentModel_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_DataDictionary_consentModel_feature",
						"_UI_DataDictionary_type"),
				datadictionaryPackage.Literals.DATA_DICTIONARY__CONSENT_MODEL, true, false, true, null, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(datadictionaryPackage.Literals.DATA_DICTIONARY__LABEL_TYPES);
			childrenFeatures.add(datadictionaryPackage.Literals.DATA_DICTIONARY__BEHAVIOR);
			childrenFeatures.add(datadictionaryPackage.Literals.DATA_DICTIONARY__CONSENT_LABEL_TYPES);
			childrenFeatures.add(datadictionaryPackage.Literals.DATA_DICTIONARY__ROLE_LABEL_TYPES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns DataDictionary.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/DataDictionary"));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((DataDictionary) object).getEntityName();
		return label == null || label.length() == 0 ? getString("_UI_DataDictionary_type")
				: getString("_UI_DataDictionary_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(DataDictionary.class)) {
		case datadictionaryPackage.DATA_DICTIONARY__LABEL_TYPES:
		case datadictionaryPackage.DATA_DICTIONARY__BEHAVIOR:
		case datadictionaryPackage.DATA_DICTIONARY__CONSENT_LABEL_TYPES:
		case datadictionaryPackage.DATA_DICTIONARY__ROLE_LABEL_TYPES:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(datadictionaryPackage.Literals.DATA_DICTIONARY__LABEL_TYPES,
				datadictionaryFactory.eINSTANCE.createBasicLabelType()));

		newChildDescriptors.add(createChildParameter(datadictionaryPackage.Literals.DATA_DICTIONARY__BEHAVIOR,
				datadictionaryFactory.eINSTANCE.createBehavior()));

		newChildDescriptors
				.add(createChildParameter(datadictionaryPackage.Literals.DATA_DICTIONARY__CONSENT_LABEL_TYPES,
						datadictionaryFactory.eINSTANCE.createConsentLabelType()));

		newChildDescriptors.add(createChildParameter(datadictionaryPackage.Literals.DATA_DICTIONARY__ROLE_LABEL_TYPES,
				datadictionaryFactory.eINSTANCE.createRoleLabelType()));
	}

}

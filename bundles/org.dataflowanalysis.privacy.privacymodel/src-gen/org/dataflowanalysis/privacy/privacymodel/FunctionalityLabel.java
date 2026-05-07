/**
 */
package org.dataflowanalysis.privacy.privacymodel;

import org.dataflowanalysis.dfd.datadictionary.AbstractLabel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Functionality Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.privacymodel.FunctionalityLabel#getFunctionality <em>Functionality</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getFunctionalityLabel()
 * @model
 * @generated
 */
public interface FunctionalityLabel extends AbstractLabel {
	/**
	 * Returns the value of the '<em><b>Functionality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functionality</em>' containment reference.
	 * @see #setFunctionality(Functionality)
	 * @see org.dataflowanalysis.privacy.privacymodel.privacymodelPackage#getFunctionalityLabel_Functionality()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Functionality getFunctionality();

	/**
	 * Sets the value of the '{@link org.dataflowanalysis.privacy.privacymodel.FunctionalityLabel#getFunctionality <em>Functionality</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Functionality</em>' containment reference.
	 * @see #getFunctionality()
	 * @generated
	 */
	void setFunctionality(Functionality value);

} // FunctionalityLabel

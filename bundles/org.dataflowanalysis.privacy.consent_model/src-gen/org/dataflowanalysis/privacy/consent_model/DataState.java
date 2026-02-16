/**
 */
package org.dataflowanalysis.privacy.consent_model;

import identifier.Entity;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.dataflowanalysis.privacy.consent_model.DataState#getNotRelatableWith <em>Not Relatable With</em>}</li>
 * </ul>
 *
 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getDataState()
 * @model
 * @generated
 */
public interface DataState extends Entity {
	/**
	 * Returns the value of the '<em><b>Not Relatable With</b></em>' reference list.
	 * The list contents are of type {@link org.dataflowanalysis.privacy.consent_model.DataState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not Relatable With</em>' reference list.
	 * @see org.dataflowanalysis.privacy.consent_model.Consent_modelPackage#getDataState_NotRelatableWith()
	 * @model
	 * @generated
	 */
	EList<DataState> getNotRelatableWith();

} // DataState

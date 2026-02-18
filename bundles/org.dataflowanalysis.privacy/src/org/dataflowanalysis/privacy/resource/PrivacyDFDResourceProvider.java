package org.dataflowanalysis.privacy.resource;

import org.dataflowanalysis.analysis.dfd.resource.DFDResourceProvider;
import org.dataflowanalysis.privacy.consentmodel.ConsentModel;
import org.dataflowanalysis.privacy.consentmodel.consentmodelPackage;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * This abstract class represents the required model data that is required to run a dfd analysis
 */
public abstract class PrivacyDFDResourceProvider extends DFDResourceProvider {
    @Override
    public void setupResources() {
        super.setupResources();
        this.resources.getPackageRegistry()
        		.put(consentmodelPackage.eNS_URI, consentmodelPackage.eINSTANCE);
        this.resources.getResourceFactoryRegistry()
		        .getExtensionToFactoryMap()
		        .put(consentmodelPackage.eNAME, new XMIResourceFactoryImpl());
    }
    
    /**
     * Returns the consent model that the resource loader has loaded
     * @return Consent model saved in the resources
     */
    public abstract ConsentModel getConsentModel();
    
    /**
     * Determines, whether the resource loader has sufficient resources to run the analysis
     * @return This method returns true, if the analysis can be executed with the resource loader. Otherwise, the method
     * returns false
     */
    @Override
    public boolean sufficientResourcesLoaded() {
        return this.getDataFlowDiagram() != null && this.getDataDictionary() != null && this.getConsentModel() != null;
    }
}

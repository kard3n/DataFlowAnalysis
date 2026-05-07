package org.dataflowanalysis.privacy.resource;

import org.dataflowanalysis.analysis.dfd.resource.DFDResourceProvider;
import org.dataflowanalysis.privacy.privacymodel.PrivacyModel;
import org.dataflowanalysis.privacy.privacymodel.privacymodelPackage;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * This abstract class represents the required model data that is required to run a dfd analysis
 */
public abstract class PrivacyDFDResourceProvider extends DFDResourceProvider {
    @Override
    public void setupResources() {
        super.setupResources();
        this.resources.getPackageRegistry()
        		.put(privacymodelPackage.eNS_URI, privacymodelPackage.eINSTANCE);
        this.resources.getResourceFactoryRegistry()
		        .getExtensionToFactoryMap()
		        .put(privacymodelPackage.eNAME, new XMIResourceFactoryImpl());
    }
    
    /**
     * Returns the privacy model that the resource loader has loaded
     * @return Privacy model saved in the resources
     */
    public abstract PrivacyModel getPrivacyModel();
    
    /**
     * Determines, whether the resource loader has sufficient resources to run the analysis
     * @return This method returns true, if the analysis can be executed with the resource loader. Otherwise, the method
     * returns false
     */
    @Override
    public boolean sufficientResourcesLoaded() {
        return this.getDataFlowDiagram() != null && this.getDataDictionary() != null && this.getPrivacyModel() != null;
    }
}

package org.dataflowanalysis.privacy.resource;

import org.dataflowanalysis.dfd.datadictionary.DataDictionary;
import org.dataflowanalysis.dfd.dataflowdiagram.DataFlowDiagram;
import org.dataflowanalysis.privacy.consentmodel.ConsentModel;

public class PrivacyDFDModelResourceProvider extends PrivacyDFDResourceProvider {

    DataDictionary dataDictionary;
    DataFlowDiagram dataFlowDiagram;
    ConsentModel consentModel;

    public PrivacyDFDModelResourceProvider(DataDictionary dataDictionary, DataFlowDiagram dataFlowDiagram, ConsentModel consentModel) {
        this.dataDictionary = dataDictionary;
        this.dataFlowDiagram = dataFlowDiagram;
        this.consentModel = consentModel;
    }

    @Override
    public DataFlowDiagram getDataFlowDiagram() {
        return this.dataFlowDiagram;
    }

    @Override
    public DataDictionary getDataDictionary() {
        return this.dataDictionary;
    }
    
    @Override
	public ConsentModel getConsentModel() {
		return this.consentModel;
	}

    @Override
    public void loadRequiredResources() {
        return;
    }

}

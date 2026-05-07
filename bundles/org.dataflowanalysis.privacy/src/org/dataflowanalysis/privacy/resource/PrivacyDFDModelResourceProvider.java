package org.dataflowanalysis.privacy.resource;

import org.dataflowanalysis.dfd.datadictionary.DataDictionary;
import org.dataflowanalysis.dfd.dataflowdiagram.DataFlowDiagram;
import org.dataflowanalysis.privacy.privacymodel.PrivacyModel;

public class PrivacyDFDModelResourceProvider extends PrivacyDFDResourceProvider {

    DataDictionary dataDictionary;
    DataFlowDiagram dataFlowDiagram;
    PrivacyModel privacyModel;

    public PrivacyDFDModelResourceProvider(DataDictionary dataDictionary, DataFlowDiagram dataFlowDiagram, PrivacyModel privacyModel) {
        this.dataDictionary = dataDictionary;
        this.dataFlowDiagram = dataFlowDiagram;
        this.privacyModel = privacyModel;
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
	public PrivacyModel getPrivacyModel() {
		return this.privacyModel;
	}

    @Override
    public void loadRequiredResources() {
        return;
    }

}

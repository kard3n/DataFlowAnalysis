package org.dataflowanalysis.privacy.evaluation;

import org.dataflowanalysis.dfd.datadictionary.DataDictionary;
import org.dataflowanalysis.dfd.dataflowdiagram.DataFlowDiagram;
import org.dataflowanalysis.privacy.consentmodel.ConsentModel;

public record PrivacyModelPackage (DataFlowDiagram dfd, DataDictionary dd, ConsentModel cm) {
	
}

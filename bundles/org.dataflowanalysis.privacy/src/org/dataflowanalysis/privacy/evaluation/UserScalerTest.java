package org.dataflowanalysis.privacy.evaluation;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.dfd.core.DFDFlowGraphCollection;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.privacy.Activator;
import org.dataflowanalysis.privacy.PrivacyDFDConfidentialityAnalysis;
import org.dataflowanalysis.privacy.PrivacyDFDDataFlowAnalysisBuilder;
import org.dataflowanalysis.privacy.test.PrivacyDataFlowConstrainTest;
import org.junit.jupiter.api.Test;

public class UserScalerTest {
	public static final String TEST_MODEL_PROJECT_NAME = "org.dataflowanalysis.examplemodels";
	private static final Logger logger = LoggerManager.getLogger(PrivacyDataFlowConstrainTest.class);
	
	@Test
	public void testGenerateUsers() {
		final var consentModelPath = Paths.get("models", "dfd", "PrivacyScalingModels", "base.consentmodel");
		final var dataFlowDiagramPath = Paths.get("models", "dfd", "PrivacyScalingModels" ,"simple_forward.dataflowdiagram");
		final var dataDictionaryPath = Paths.get("models", "dfd", "PrivacyScalingModels", "simple_forward.datadictionary");
		
		ModelManager manager = new ModelManager();
		
		PrivacyModelPackage originalPackage = manager.loadModel(dataFlowDiagramPath, dataDictionaryPath, consentModelPath, TEST_MODEL_PROJECT_NAME);
		
		int numberUsers = 100;
		PrivacyModelPackage modifiedPackage = PrivacyContractGenerator.generateUsers(originalPackage, numberUsers, "Source", 3);
		
		// save model to a directory
		String scaledModelName ="scaled_" + numberUsers;
		String outputDir = "scaled_models";
		manager.savePrivacyPackage(modifiedPackage, Path.of(outputDir), scaledModelName);
		
		PrivacyDFDConfidentialityAnalysis analysis = new PrivacyDFDDataFlowAnalysisBuilder().standalone()
				.modelProjectName("org.dataflowanalysis.privacy")
				// FIX 1: Provide the correct Activator for the privacy project.
				// (Assuming org.dataflowanalysis.privacy has its own Activator class)
				.usePluginActivator(Activator.class) 
				// FIX 2: Append the output directory to the file paths
				.useDataFlowDiagram(outputDir + "/" + scaledModelName + ".dataflowdiagram")
				.useDataDictionary(outputDir + "/" + scaledModelName + ".datadictionary")
				.useConsentModel(outputDir + "/" + scaledModelName + ".consentmodel")
                .build();
                
		analysis.initializeAnalysis();
		
		DFDFlowGraphCollection flowGraphCollection = analysis.findFlowGraphs();
		flowGraphCollection.evaluate();
		logger.info(flowGraphCollection.getTransposeFlowGraphs().size());
	}
}

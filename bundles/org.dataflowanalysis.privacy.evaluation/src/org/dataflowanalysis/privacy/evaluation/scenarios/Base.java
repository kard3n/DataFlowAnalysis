package org.dataflowanalysis.privacy.evaluation.scenarios;

import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.dfd.core.DFDFlowGraphCollection;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.examplemodels.Activator;
import org.dataflowanalysis.privacy.PrivacyDFDConfidentialityAnalysis;
import org.dataflowanalysis.privacy.PrivacyDFDDataFlowAnalysisBuilder;
import org.dataflowanalysis.privacy.constraint.PrivacyDataFlowConstraint;
import org.junit.jupiter.api.Test;

public class Base {
	public static final String TEST_MODEL_PROJECT_NAME = "org.dataflowanalysis.examplemodels";
	private static final Logger logger = LoggerManager.getLogger(Base.class);

	@Test
	public void createsGraphsForRole() {
		final var dataFlowDiagramPath = Paths.get("models", "privacy_dfd", "EvaluationModels", "Base",
				"model.dataflowdiagram");
		final var dataDictionaryPath = Paths.get("models", "privacy_dfd", "EvaluationModels", "Base",
				"model.datadictionary");
		final var privacyModelPath = Paths.get("models", "privacy_dfd", "EvaluationModels", "Base",
				"model.privacymodel");

		PrivacyDFDConfidentialityAnalysis analysis = new PrivacyDFDDataFlowAnalysisBuilder().standalone()
				.modelProjectName("org.dataflowanalysis.examplemodels").usePluginActivator(Activator.class)
				.useDataFlowDiagram(dataFlowDiagramPath.toString()).useDataDictionary(dataDictionaryPath.toString())
				.usePrivacyModel(privacyModelPath.toString()).build();
		analysis.initializeAnalysis();
		DFDFlowGraphCollection flowGraphCollection = analysis.findFlowGraphs();
		flowGraphCollection.evaluate();

		var violations = PrivacyDataFlowConstraint.findViolations(flowGraphCollection, true, false);

		logger.info("Detected violations: " + violations.size());

		for (var violation : violations) {
			logger.info("\n" + violation.getMessage() + "\n\n");
		}
	}

}

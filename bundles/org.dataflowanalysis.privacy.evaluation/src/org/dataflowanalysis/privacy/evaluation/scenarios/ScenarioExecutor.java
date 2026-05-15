package org.dataflowanalysis.privacy.evaluation.scenarios;

import java.nio.file.Paths;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.dfd.core.DFDFlowGraphCollection;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.examplemodels.Activator;
import org.dataflowanalysis.privacy.PrivacyDFDConfidentialityAnalysis;
import org.dataflowanalysis.privacy.PrivacyDFDDataFlowAnalysisBuilder;
import org.dataflowanalysis.privacy.constraint.PrivacyDataFlowConstraint;
import org.junit.jupiter.api.Test;

public class ScenarioExecutor {
	public static final String TEST_MODEL_PROJECT_NAME = "org.dataflowanalysis.examplemodels";
	private static final Logger logger = LoggerManager.getLogger(ScenarioExecutor.class);

	@Test
	public void executeScenario() {
		final int category = 1;
		final int scenario = 2;
		final String study = "MaaS"; // OnlineShop, MaaS, UDS

		final Map<String, String> studyNameToModelName = Map.of("MaaS", "default", "OnlineShop", "online_shop", "UDS",
				"model");

		final var dataFlowDiagramPath = Paths.get("models", "privacy_dfd", "EvaluationModels",
				String.format("C%d_S%d", category, scenario), study,
				String.format("%s.dataflowdiagram", studyNameToModelName.get(study)));
		final var dataDictionaryPath = Paths.get("models", "privacy_dfd", "EvaluationModels",
				String.format("C%d_S%d", category, scenario), study,
				String.format("%s.datadictionary", studyNameToModelName.get(study)));
		final var privacyModelPath = Paths.get("models", "privacy_dfd", "EvaluationModels",
				String.format("C%d_S%d", category, scenario), study,
				String.format("%s.privacymodel", studyNameToModelName.get(study)));

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

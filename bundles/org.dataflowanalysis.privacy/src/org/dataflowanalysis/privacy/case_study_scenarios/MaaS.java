package org.dataflowanalysis.privacy.case_study_scenarios;

import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.dfd.core.DFDFlowGraphCollection;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.examplemodels.Activator;
import org.dataflowanalysis.privacy.PrivacyDFDConfidentialityAnalysis;
import org.dataflowanalysis.privacy.PrivacyDFDDataFlowAnalysisBuilder;
import org.dataflowanalysis.privacy.constraint.PrivacyDataFlowConstraint;
import org.dataflowanalysis.privacy.core.PrivacyDFDTransposeFlowGraphFinder;
import org.dataflowanalysis.privacy.test.PrivacyDataFlowConstrainTest;
import org.junit.jupiter.api.Test;

public class MaaS {
	public static final String TEST_MODEL_PROJECT_NAME = "org.dataflowanalysis.examplemodels";
	private static final Logger logger = LoggerManager.getLogger(PrivacyDataFlowConstrainTest.class);

	@Test
	public void createsGraphsForRole() {
		final var dataFlowDiagramPath = Paths.get("scenarios", "privacy_dfd", "MaaS", "default.dataflowdiagram");
		final var dataDictionaryPath = Paths.get("scenarios", "privacy_dfd", "MaaS", "default.datadictionary");
		final var privacyModelPath = Paths.get("scenarios", "privacy_dfd", "MaaS", "default.privacymodel");

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

package org.dataflowanalysis.privacy.evaluation;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.dfd.core.DFDFlowGraphCollection;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.privacy.Activator;
import org.dataflowanalysis.privacy.PrivacyDFDConfidentialityAnalysis;
import org.dataflowanalysis.privacy.PrivacyDFDDataFlowAnalysisBuilder;
import org.dataflowanalysis.privacy.constraint.PrivacyDataFlowConstraint;
import org.dataflowanalysis.privacy.test.PrivacyDataFlowConstrainTest;
import org.junit.jupiter.api.Test;

public class UserScalerTest {
	public static final String TEST_MODEL_PROJECT_NAME = "org.dataflowanalysis.examplemodels";
	private static final Logger logger = LoggerManager.getLogger(PrivacyDataFlowConstrainTest.class);

	@Test
	public void testGenerateUsers() {
		final var consentModelPath = Paths.get("models", "dfd", "PrivacyScalingModels", "base.consentmodel");
		final var dataFlowDiagramPath = Paths.get("models", "dfd", "PrivacyScalingModels",
				"simple_forward.dataflowdiagram");
		final var dataDictionaryPath = Paths.get("models", "dfd", "PrivacyScalingModels",
				"simple_forward.datadictionary");

		String outputDir = "scaled_models";
		String scaledModelNameBase = "scaled_";
		int numberWarmupRuns = 1; // How many times each scenario should be run before starting the evaluation
		int numberEvaluationRuns = 5; // How many times each scenario should be ran to determine the result
		int[] numberUsers = { 1, 100, 1000, 2000, 5000 };

		ModelManager manager = new ModelManager();

		PrivacyModelPackage originalPackage = manager.loadModel(dataFlowDiagramPath, dataDictionaryPath,
				consentModelPath, TEST_MODEL_PROJECT_NAME);

		for (int currentAmount : numberUsers) {
			PrivacyModelPackage modifiedPackage = PrivacyContractGenerator.generateUsers(originalPackage, currentAmount,
					"Source", 3);
			// save model to a directory
			manager.savePrivacyPackage(modifiedPackage, Path.of(outputDir), scaledModelNameBase + currentAmount);
		}

		String scaledModelName;
		long startFindGraphs;
		long endFindGraphs;
		long startLabelPropagation;
		long endLabelPropagation;
		long startAnalysis;
		long endAnalysis;

		long findGraphsTime;
		long labelPropagationTime;
		long analysisTime;

		long[] resultGraphFind = new long[numberUsers.length];
		long[] resultPropagation = new long[numberUsers.length];
		long[] resultAnalysis = new long[numberUsers.length];
		for (int x = 0; x < numberUsers.length; x++) {
			int currentAmount = numberUsers[x];
			resultGraphFind[x] = 0;
			resultPropagation[x] = 0;
			resultAnalysis[x] = 0;
			scaledModelName = scaledModelNameBase + currentAmount;

			for (int i = 0; i < numberWarmupRuns + numberEvaluationRuns; i++) {
				if (i < numberWarmupRuns) {
					logger.info("Warmup run " + (i + 1) + "/" + numberWarmupRuns + " for size " + currentAmount
							+ " started.");
				} else {
					logger.info("Run " + (i + 1 - numberWarmupRuns) + "/" + numberEvaluationRuns + " for size "
							+ currentAmount + " started.");
				}

				PrivacyDFDConfidentialityAnalysis analysis = new PrivacyDFDDataFlowAnalysisBuilder().standalone()
						.modelProjectName("org.dataflowanalysis.privacy").usePluginActivator(Activator.class)
						.useDataFlowDiagram(outputDir + "/" + scaledModelName + ".dataflowdiagram")
						.useDataDictionary(outputDir + "/" + scaledModelName + ".datadictionary")
						.useConsentModel(outputDir + "/" + scaledModelName + ".consentmodel").build();
				analysis.initializeAnalysis();

				startFindGraphs = System.nanoTime();
				DFDFlowGraphCollection flowGraphCollection = analysis.findFlowGraphs();
				endFindGraphs = System.nanoTime();
				startLabelPropagation = System.nanoTime();
				flowGraphCollection.evaluate();
				endLabelPropagation = System.nanoTime();
				startAnalysis = System.nanoTime();
				var violations = PrivacyDataFlowConstraint.findViolations(flowGraphCollection, true);
				endAnalysis = System.nanoTime();

				findGraphsTime = endFindGraphs - startFindGraphs;
				labelPropagationTime = endLabelPropagation - startLabelPropagation;
				analysisTime = endAnalysis - startAnalysis;
				if (i < numberWarmupRuns) {
					logger.info("Warnup run " + (i + 1) + "/" + numberWarmupRuns + " for size " + currentAmount
							+ " finished.");
				} else {
					logger.info("Run " + (i + 1 - numberWarmupRuns) + "/" + numberEvaluationRuns + " for size "
							+ currentAmount + " finished. TFG Find: " + findGraphsTime + ". Label Propagation: "
							+ labelPropagationTime + ". Analysis: " + analysisTime + ". Violations detected: " + violations.size());
					// Add runtimes
					resultGraphFind[x] += findGraphsTime;
					resultPropagation[x] += labelPropagationTime;
					resultAnalysis[x] += analysisTime;
				}
			}
		}

		for (int x = 0; x < numberUsers.length; x++) {
		    int currentAmount = numberUsers[x];
		    logger.info("### RESULTS (" + currentAmount + " users) ###");
		    
		    resultGraphFind[x] = resultGraphFind[x] / numberEvaluationRuns;
		    resultPropagation[x] = resultPropagation[x] / numberEvaluationRuns;
		    resultAnalysis[x] = resultAnalysis[x] / numberEvaluationRuns;
		    
		    logger.info("\tAverage time for TFG finding: " + resultGraphFind[x] + "ns ("
		            + String.format("%.4f", resultGraphFind[x] / 1000000000.0) + "s)");
		            
		    logger.info("\tAverage time for label propagation: " + resultPropagation[x] + "ns ("
		            + String.format("%.4f", resultPropagation[x] / 1000000000.0) + "s)");
		            
		    logger.info("\tAverage time for privacy analysis: " + resultAnalysis[x] + "ns ("
		            + String.format("%.4f", resultAnalysis[x] / 1000000000.0) + "s)");
		}

	}
}

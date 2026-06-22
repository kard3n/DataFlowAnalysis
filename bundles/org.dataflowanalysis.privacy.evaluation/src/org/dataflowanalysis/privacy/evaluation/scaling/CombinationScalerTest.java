package org.dataflowanalysis.privacy.evaluation.scaling;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.dfd.core.DFDFlowGraphCollection;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.privacy.PrivacyDFDConfidentialityAnalysis;
import org.dataflowanalysis.privacy.PrivacyDFDDataFlowAnalysisBuilder;
import org.dataflowanalysis.privacy.constraint.PrivacyDataFlowConstraint;
import org.dataflowanalysis.privacy.evaluation.Activator;
import org.junit.jupiter.api.Test;

public class CombinationScalerTest {
	public static final String TEST_MODEL_PROJECT_NAME = "org.dataflowanalysis.examplemodels";
	private static final Logger logger = LoggerManager.getLogger(CombinationScalerTest.class);
	
	private enum Mode{
		NODES,
		PINS
	}

	@Test
	public void testGenerateCombinations() {
		final var privacyModelPath = Paths.get("models", "privacy_dfd", "PrivacyScalingModels", "base.privacymodel");
		final var dataFlowDiagramPath = Paths.get("models", "privacy_dfd", "PrivacyScalingModels",
				"simple_forward.dataflowdiagram");
		final var dataDictionaryPath = Paths.get("models", "privacy_dfd", "PrivacyScalingModels",
				"simple_forward.datadictionary");

		String outputDir = "scaled_models";
		String scaledModelNameBase = "scaled_comb_";
		int numberWarmupRuns = 0; // How many times each scenario should be run before starting the evaluation
		int numberEvaluationRuns = 20; // How many times each scenario should be ran to determine the result
		int[] numberCombinations = { 1, 100, 500, 1000, 2500, 5000, 10000 };
		int combinationSize = 6;
		int overlap = 3;
		// NODES = source node is replicated. PINS: new pins are added to the source's behavior.
		Mode mode = Mode.PINS;
		// If set to true, the pins at the destination node are also replicated -> tests node-level inference
		boolean replicateDestinationPins = true;

		ModelManager manager = new ModelManager();

		PrivacyModelPackage originalPackage = manager.loadModel(dataFlowDiagramPath, dataDictionaryPath,
				privacyModelPath, TEST_MODEL_PROJECT_NAME);

		for (int currentAmount : numberCombinations) {
			PrivacyModelPackage modifiedPackage = switch (mode) {
				case NODES -> PrivacyContractGenerator.replicateSourceNode(originalPackage, "Source", currentAmount, combinationSize, overlap, replicateDestinationPins);
				case PINS -> PrivacyContractGenerator.replicatePinInSourceNode(originalPackage, "Source", currentAmount, combinationSize, overlap, replicateDestinationPins);
			};

			// save model to a directory
			manager.savePrivacyPackage(modifiedPackage, Path.of(outputDir), scaledModelNameBase + currentAmount + "_" + mode.name());
		}

		String scaledModelName;
		long startInitialization;
		long endInitialization;
		long startFindGraphs;
		long endFindGraphs;
		long startLabelPropagation;
		long endLabelPropagation;
		long startAnalysis;
		long endAnalysis;

		long initializationTime;
		long findGraphsTime;
		long labelPropagationTime;
		long analysisTime;

		long[] resultInitialization = new long[numberCombinations.length];
		long[] resultGraphFind = new long[numberCombinations.length];
		long[] resultPropagation = new long[numberCombinations.length];
		long[] resultAnalysis = new long[numberCombinations.length];
		for (int x = 0; x < numberCombinations.length; x++) {
			int currentAmount = numberCombinations[x];
			resultGraphFind[x] = 0;
			resultPropagation[x] = 0;
			resultAnalysis[x] = 0;
			scaledModelName = scaledModelNameBase + currentAmount  + "_" + mode.name();

			for (int i = 0; i < numberWarmupRuns + numberEvaluationRuns; i++) {
				if (i < numberWarmupRuns) {
					logger.info("Warmup run " + (i + 1) + "/" + numberWarmupRuns + " for size " + currentAmount
							+ " started.");
				} else {
					logger.info("Run " + (i + 1 - numberWarmupRuns) + "/" + numberEvaluationRuns + " for size "
							+ currentAmount + " started.");
				}

				PrivacyDFDConfidentialityAnalysis analysis = new PrivacyDFDDataFlowAnalysisBuilder().standalone()
						.modelProjectName("org.dataflowanalysis.privacy.evaluation").usePluginActivator(Activator.class)
						.useDataFlowDiagram(outputDir + "/" + scaledModelName + ".dataflowdiagram")
						.useDataDictionary(outputDir + "/" + scaledModelName + ".datadictionary")
						.usePrivacyModel(outputDir + "/" + scaledModelName + ".privacymodel").build();
				
				startInitialization = System.nanoTime();
				analysis.initializeAnalysis(); // If the execution takes a long time: this is causing it
				endInitialization = System.nanoTime();
				
				System.gc();
				try {
					Thread.sleep(2000);
				}
				catch(InterruptedException e){
					logger.warn("Interrupted");
				}
				
				startFindGraphs = System.nanoTime();
				DFDFlowGraphCollection flowGraphCollection = analysis.findFlowGraphs();
				endFindGraphs = System.nanoTime();
				startLabelPropagation = System.nanoTime();
				flowGraphCollection.evaluate();
				endLabelPropagation = System.nanoTime();
				startAnalysis = System.nanoTime();
				var violations = PrivacyDataFlowConstraint.findViolations(flowGraphCollection, true, false);
				endAnalysis = System.nanoTime();

				if (i < numberWarmupRuns) {
					logger.info("Warnup run " + (i + 1) + "/" + numberWarmupRuns + " for size " + currentAmount
							+ " finished.");
				} else {
					initializationTime = endInitialization - startInitialization;
					findGraphsTime = endFindGraphs - startFindGraphs;
					labelPropagationTime = endLabelPropagation - startLabelPropagation;
					analysisTime = endAnalysis - startAnalysis;
					
					
					logger.info("Run " + (i + 1 - numberWarmupRuns) + "/" + numberEvaluationRuns + " for size "
							+ currentAmount + " finished. TFG Find: " + findGraphsTime + ". Label Propagation: "
							+ labelPropagationTime + ". Analysis: " + analysisTime + ". Violations detected: " + violations.size());
					
					// Add runtimes
					resultGraphFind[x] += findGraphsTime;
					resultPropagation[x] += labelPropagationTime;
					resultAnalysis[x] += analysisTime;
					resultInitialization[x] += initializationTime;
				}
			}
		}

		for (int x = 0; x < numberCombinations.length; x++) {
		    int currentAmount = numberCombinations[x];
		    logger.info("### RESULTS (" + currentAmount + " combinations) ###");
		    
		    resultInitialization[x] = resultInitialization[x] / numberEvaluationRuns;
		    resultGraphFind[x] = resultGraphFind[x] / numberEvaluationRuns;
		    resultPropagation[x] = resultPropagation[x] / numberEvaluationRuns;
		    resultAnalysis[x] = resultAnalysis[x] / numberEvaluationRuns;
		    
		    
		    logger.info("\tAverage time for analysis initialization: " + resultInitialization[x] + "ns ("
		            + String.format("%.4f", resultInitialization[x] / 1000000000.0) + "s)");
		    
		    logger.info("\tAverage time for TFG finding: " + resultGraphFind[x] + "ns ("
		            + String.format("%.4f", resultGraphFind[x] / 1000000000.0) + "s)");
		            
		    logger.info("\tAverage time for label propagation: " + resultPropagation[x] + "ns ("
		            + String.format("%.4f", resultPropagation[x] / 1000000000.0) + "s)");
		            
		    logger.info("\tAverage time for privacy analysis: " + resultAnalysis[x] + "ns ("
		            + String.format("%.4f", resultAnalysis[x] / 1000000000.0) + "s)");

			logger.info(
					"Average Total: " + (resultAnalysis[x] + resultPropagation[x] + resultGraphFind[x]) / 1000000000.0
							+ "s. Average Total incl. initialization: "
							+ (resultAnalysis[x] + resultPropagation[x] + resultGraphFind[x] + resultInitialization[x])/ 1000000000.0
							+ "s.");
		}

	}
}

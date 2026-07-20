package org.dataflowanalysis.privacy.evaluation.scenarios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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

    // Simple Pair helper class (compatible with Java 8+)
    public static class Pair<L, R> {
        private final L left;
        private final R right;

        public Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }

        public static <L, R> Pair<L, R> of(L left, R right) {
            return new Pair<>(left, right);
        }

        public L getLeft() { return left; }
        public R getRight() { return right; }
    }

    @Test
    public void executeScenario() throws IOException {
        // 1. Define all scenario pairs (Category, Scenario) to execute
        final List<Pair<Integer, Integer>> scenarios = List.of(
            Pair.of(1, 1),
            Pair.of(1, 2),
            Pair.of(20, 1),
            Pair.of(20, 2),
            Pair.of(21, 1),
            Pair.of(21, 2),
            Pair.of(22, 1),
            Pair.of(22, 2),
            Pair.of(23, 1),
            Pair.of(23, 2),
            Pair.of(24, 1),
            Pair.of(24, 2),
            Pair.of(3, 1),
            Pair.of(3, 2),
            Pair.of(3, 3),
            Pair.of(3, 4)
        );

        
        final List<String> studies = List.of("OnlineShop", "MaaS", "UDS");
        
        final Map<String, String> studyNameToModelName = Map.of(
            "MaaS", "default", 
            "OnlineShop", "online_shop", 
            "UDS", "model"
        );

        final Path baseOutputDir = Paths.get("results_accuracy");

        for (var scenarioPair : scenarios) {
            int category = scenarioPair.getLeft();
            int scenario = scenarioPair.getRight();
            String folderName = String.format("C%d_S%d", category, scenario);

            Path scenarioOutputDir = baseOutputDir.resolve(folderName);
            Files.createDirectories(scenarioOutputDir);

            logger.info("Executing Scenarios for " + folderName);

            
            for (String study : studies) {
                logger.info("Running case study: " + study + " for " + folderName);

                final var dataFlowDiagramPath = Paths.get("models", "privacy_dfd", "EvaluationModels",
                        folderName, study,
                        String.format("%s.dataflowdiagram", studyNameToModelName.get(study)));
                final var dataDictionaryPath = Paths.get("models", "privacy_dfd", "EvaluationModels",
                        folderName, study,
                        String.format("%s.datadictionary", studyNameToModelName.get(study)));
                final var privacyModelPath = Paths.get("models", "privacy_dfd", "EvaluationModels",
                        folderName, study,
                        String.format("%s.privacymodel", studyNameToModelName.get(study)));

                PrivacyDFDConfidentialityAnalysis analysis = new PrivacyDFDDataFlowAnalysisBuilder().standalone()
                        .modelProjectName(TEST_MODEL_PROJECT_NAME).usePluginActivator(Activator.class)
                        .useDataFlowDiagram(dataFlowDiagramPath.toString()).useDataDictionary(dataDictionaryPath.toString())
                        .usePrivacyModel(privacyModelPath.toString()).build();
                
                analysis.initializeAnalysis();
                DFDFlowGraphCollection flowGraphCollection = analysis.findFlowGraphs();
                flowGraphCollection.evaluate();

                var violations = PrivacyDataFlowConstraint.findViolations(flowGraphCollection, false, false);

                StringBuilder outputContent = new StringBuilder();
                outputContent.append("Study: ").append(study).append("\n");
                outputContent.append("Scenario: ").append(folderName).append("\n");
                outputContent.append("Detected violations: ").append(violations.size()).append("\n\n");


                for (var violation : violations) {
                    String violationMsg = violation.getMessage();
                    //logger.info("\n" + violationMsg + "\n\n");
                    outputContent.append(violationMsg).append("\n\n");
                }

                Path resultFile = scenarioOutputDir.resolve(study + ".txt");
                Files.writeString(resultFile, outputContent.toString());
            }
        }
    }
}
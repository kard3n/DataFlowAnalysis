package org.dataflowanalysis.privacy.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.dfd.core.DFDFlowGraphCollection;
import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.dfd.dataflowdiagram.Node;
import org.dataflowanalysis.examplemodels.Activator;
import org.dataflowanalysis.privacy.PrivacyDFDConfidentialityAnalysis;
import org.dataflowanalysis.privacy.PrivacyDFDDataFlowAnalysisBuilder;
import org.dataflowanalysis.privacy.core.PrivacyDFDTransposeFlowGraphFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransposeFinderTest {
	public static final String TEST_MODEL_PROJECT_NAME = "org.dataflowanalysis.examplemodels";
	private static final Logger logger = LoggerManager.getLogger(PrivacyDataFlowConstrainTest.class);

	PrivacyDFDConfidentialityAnalysis analysis;

	@BeforeEach
	public void initAnalysis() {
		final var basicDataFlowDiagramPath = Paths.get("models", "dfd", "SuperBasicPrivacy", "sbp.dataflowdiagram");
		final var basicDataDictionaryPath = Paths.get("models", "dfd", "SuperBasicPrivacy", "sbp.datadictionary");
		final var basicConsentModelPath = Paths.get("models", "dfd", "SuperBasicPrivacy", "sbp.consentmodel");

		this.analysis = new PrivacyDFDDataFlowAnalysisBuilder().standalone().modelProjectName(TEST_MODEL_PROJECT_NAME)
				.usePluginActivator(Activator.class).useDataFlowDiagram(basicDataFlowDiagramPath.toString())
				.useDataDictionary(basicDataDictionaryPath.toString()).useConsentModel(basicConsentModelPath.toString())
				.build();
	}

	@Test
	public void createsGraphsForRole() {
		this.analysis.initializeAnalysis();
		DFDFlowGraphCollection flowGraphCollection = analysis.findFlowGraphs();

		flowGraphCollection.evaluate();

		var flowGraphs = flowGraphCollection.getTransposeFlowGraphs();

		assertEquals(4, flowGraphs.size());

		for (var fg : flowGraphs) {
			fg.getVertices().forEach(vert -> {
				logger.debug("Vert " + ((DFDVertex) vert).getName() + "  char: " + vert
						.getAllIncomingDataCharacteristics().stream().map(i -> i.getAllCharacteristics()).toList());
			});
		}

		List<Set<String>> expectedIncoming = new ArrayList<>(
				List.of(Set.of("exampleLabel", "RoleLabel"), Set.of("exampleLabel", "BasicConsentLabel", "RoleLabel"),
						Set.of("exampleLabel", "exampleLabelTwo", "RoleLabel"),
						Set.of("exampleLabel", "exampleLabelTwo", "BasicConsentLabel", "RoleLabel")));

		for (var fg : flowGraphs) {
			assertTrue(expectedIncoming.remove(new HashSet<>(fg.getSink().getAllIncomingDataCharacteristics().get(0)
					.getAllCharacteristics().stream().map(i -> i.getValueName()).toList())));
		}
	}

}

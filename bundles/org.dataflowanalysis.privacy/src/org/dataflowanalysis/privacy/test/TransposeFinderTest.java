package org.dataflowanalysis.privacy.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Paths;
import java.util.Optional;

import org.dataflowanalysis.analysis.dfd.DFDDataFlowAnalysisBuilder;
import org.dataflowanalysis.analysis.dfd.core.DFDFlowGraphCollection;
import org.dataflowanalysis.examplemodels.Activator;
import org.dataflowanalysis.privacy.PrivacyDFDConfidentialityAnalysis;
import org.dataflowanalysis.privacy.PrivacyDFDDataFlowAnalysisBuilder;
import org.dataflowanalysis.privacy.core.PrivacyDFDTransposeFlowGraphFinder;
import org.dataflowanalysis.privacy.resource.PrivacyDFDResourceProvider;
import org.dataflowanalysis.privacy.resource.PrivacyDFDURIResourceProvider;
import org.eclipse.core.runtime.Plugin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransposeFinderTest {
	public static final String TEST_MODEL_PROJECT_NAME = "org.dataflowanalysis.examplemodels";
	
	PrivacyDFDConfidentialityAnalysis analysis;
	
	@Test
	public void shouldSetPropagationResultCorrectly() {
		// assertDoesNotThrow(() -> vertex.setPropagationResult(incomingCharacteristics,
		// outgoingCharacteristics, vertexCharacteristics));

		/*
		 * LoggerManager.getInstance() .setLevel(Level.OFF);
		 * assertThrowsExactly(IllegalArgumentException.class, () ->
		 * vertex.setPropagationResult(incomingCharacteristics, outgoingCharacteristics,
		 * vertexCharacteristics)); LoggerManager.getInstance() .resetLevel();
		 * 
		 * assertEquals assertTrue
		 */
	}
	
	@BeforeEach
    public void initAnalysis() {
		final var basicDataFlowDiagramPath = Paths.get("models", "dfd", "BasicPrivacy", "basic_privacy.dataflowdiagram");
        final var basicDataDictionaryPath = Paths.get("models", "dfd", "BasicPrivacy", "basic_privacy.datadictionary");
        final var basicConsentModelPath = Paths.get("models", "dfd", "BasicPrivacy", "basic_privacy.consentmodel");
		
		this.analysis = new PrivacyDFDDataFlowAnalysisBuilder()
    			.standalone()
    			.modelProjectName(TEST_MODEL_PROJECT_NAME)
    			.usePluginActivator(Activator.class)
    			.useDataFlowDiagram(basicDataFlowDiagramPath.toString())
    			.useDataDictionary(basicDataDictionaryPath.toString())
    			.useConsentModel(basicConsentModelPath.toString())
    			.build();
    }

	@Test
    public void createsGraphsForRole() {
		this.analysis.initializeAnalysis();
        DFDFlowGraphCollection flowGraph = analysis.findFlowGraphs();
        assertEquals(flowGraph.getTransposeFlowGraphs()
                .size(), 2);
    }

}

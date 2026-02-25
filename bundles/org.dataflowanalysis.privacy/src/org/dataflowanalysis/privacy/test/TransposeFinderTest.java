package org.dataflowanalysis.privacy.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Paths;
import java.util.List;

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
		
		Logger logger = LoggerManager.getLogger(TransposeFinderTest.class);
		flowGraphs.forEach(fg -> {
			fg.getVertices().forEach(vertex -> {
				logger.warn("Current vertex: " + vertex + ". Previous Vertexes: " + vertex.getPreviousElements());
				//if(vertex.getReferencedElement() instanceof Node node) {
				//	logger.warn(node.getBehavior().getAssignment());
				//}
				//logger.warn("Vertex characteristics: " + vertex.getAllVertexCharacteristics());
				//logger.warn(vertex.getAllIncomingDataCharacteristics());
				logger.warn("Data charcteristics VariableName: " + vertex.getAllDataCharacteristics().stream().map(charact -> charact.getVariableName()).toList());
				if(vertex instanceof DFDVertex dfdv) {
					dfdv.getPinDFDVertexMap();
					//dfdv.get
				}
			});
		});
		
		assertEquals(2, flowGraphs.size());

		
		// Check that the first graph's sink has the correct data characteristic
		assert flowGraphs.get(0).getSink().getAllDataCharacteristics().size() == 1;
		assert flowGraphs.get(0).getSink().getAllDataCharacteristics().get(0).getAllCharacteristics().size() == 2;
		List<String> labelsOne = List.of("exampleLabel", "RoleLabel");
		assert flowGraphs.get(0).getSink().getAllDataCharacteristics().get(0).getAllCharacteristics().stream().map(ch -> ch.getValueName()).toList().equals(labelsOne);
		
		// Check that the second graph's sink has the correct data characteristic
		assert flowGraphs.get(1).getSink().getAllDataCharacteristics().size() == 1;
		assert flowGraphs.get(1).getSink().getAllDataCharacteristics().get(0).getAllCharacteristics().size() == 3;
		List<String> labelsTwo = List.of("exampleLabel", "BasicConsentLabel", "RoleLabel");
		assert flowGraphs.get(1).getSink().getAllDataCharacteristics().get(0).getAllCharacteristics().stream().map(ch -> ch.getValueName()).toList().equals(labelsTwo);
	}

}

package org.dataflowanalysis.privacy.interactive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.FlowGraphCollection;
import org.dataflowanalysis.analysis.dfd.DFDConfidentialityAnalysis;
import org.dataflowanalysis.analysis.dfd.DFDDataFlowAnalysisBuilder;
import org.dataflowanalysis.analysis.dsl.AnalysisConstraint;
import org.dataflowanalysis.analysis.dsl.result.DSLResult;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.analysis.utils.StringView;
import org.dataflowanalysis.privacy.PrivacyDFDConfidentialityAnalysis;
import org.dataflowanalysis.privacy.PrivacyDFDDataFlowAnalysisBuilder;
import org.dataflowanalysis.privacy.constraint.PrivacyDataFlowConstraint;
import org.dataflowanalysis.privacy.core.PrivacyDFDTransposeFlowGraphFinder;

/**
 * This class is responsible for the interaction with the analysis via a command
 * line interface (CLI)
 */
public class PrivacyDFDAnalysisCLI {
	private static final Logger logger = LoggerManager.getLogger(PrivacyDFDAnalysisCLI.class);
	private static final String INPUT_INDICATOR = "> ";

	/**
	 * Main entry point of the privacy dfd analysis command line interface
	 * <p/>
	 * If the program is called without any arguments, the command line interface
	 * starts in interactive mode.
	 * <p/>
	 * If the program is called with arguments, the arguments must follow the
	 * following format: 1. Path to a .dataflowdiagram file 2. Path to a
	 * .datadictionary file 3. Either a path to a .dfadsl file or a DSL constraint
	 * as a string
	 * 
	 * @param args Arguments passed to the program via the command line call
	 */
	public static void main(String[] args) {
		if (args.length < 3) {
			logger.error(
					"Please provide either no arguments, or a path to a .dataflowdiagram, .datadictionary and .privacymodel file!");
			System.exit(-1);
		}

		if (!args[0].endsWith(".dataflowdiagram")) {
			logger.error("The first argument should be a path to a .dataflowdiagram file");
			System.exit(-1);
		}
		if (!args[1].endsWith(".datadictionary")) {
			logger.error("The second argument should be a path to a .datadictionary file");
			System.exit(-1);
		}
		if (!args[2].endsWith(".privacymodel")) {
			logger.error("The third argument should be a path to a .privacymodel file");
			System.exit(-1);
		}
		
		boolean nodeInference = false;
		boolean considerOutputPins = false;
		for(int i = 3; i < args.length; i++) {
			if(args[i].startsWith("-nodeInference")) {
				nodeInference = Boolean.valueOf(args[3].split("=")[1]);
			}
			else if(args[i].startsWith("-considerOutputPins")) {
				considerOutputPins = Boolean.valueOf(args[3].split("=")[1]);
			}
		}
		
		

		PrivacyDFDConfidentialityAnalysis analysis = createAnalysis(args[0], args[1], args[2]);

		analysis.initializeAnalysis();
		FlowGraphCollection flowGraphs = analysis.findFlowGraphs();
		flowGraphs.evaluate();
		var violations = PrivacyDataFlowConstraint.findViolations(flowGraphs, nodeInference, considerOutputPins);
		logger.info("### Detected " + violations.size() + " violations ###");
		int i = 0;
		for (var violation: violations) {
			i++;
			logger.info("Violation #" + i + ": " + violation.message());
		}
		System.exit(0);
	}

	/**
	 * Creates a confidentiality analysis using the provided dataflow diagram and
	 * data dictionary path
	 * 
	 * @param dataFlowDiagramPath Path to the dataflow diagram
	 * @param dataDictionaryPath  Path to the data dictionary
	 * @return Returns a confidentiality analysis using the two provided paths
	 */
	private static PrivacyDFDConfidentialityAnalysis createAnalysis(String dataFlowDiagramPath,
			String dataDictionaryPath, String privacyModelPath) {
		return new PrivacyDFDDataFlowAnalysisBuilder().standalone().useDataFlowDiagram(dataFlowDiagramPath)
				.useDataDictionary(dataDictionaryPath).usePrivacyModel(privacyModelPath).build();
	}
}

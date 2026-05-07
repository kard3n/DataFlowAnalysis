package org.dataflowanalysis.privacy;

import java.util.Optional;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.DataFlowConfidentialityAnalysis;
import org.dataflowanalysis.analysis.dfd.core.DFDFlowGraphCollection;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.privacy.core.PrivacyDFDTransposeFlowGraphFinder;
import org.dataflowanalysis.privacy.resource.PrivacyDFDResourceProvider;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import tools.mdsd.library.standalone.initialization.StandaloneInitializationException;
import tools.mdsd.library.standalone.initialization.StandaloneInitializerBuilder;

/**
 * This class represents a top-level DFD privacy analysis
 */
public class PrivacyDFDConfidentialityAnalysis extends DataFlowConfidentialityAnalysis {
	public static final String PLUGIN_PATH = "org.dataflowanalysis.privacy";

	private final Logger logger = LoggerManager.getLogger(PrivacyDFDConfidentialityAnalysis.class);

	protected final PrivacyDFDResourceProvider resourceProvider;
	protected final Optional<Class<? extends Plugin>> modelProjectActivator;
	protected final String modelProjectName;
	protected final Class<? extends PrivacyDFDTransposeFlowGraphFinder> transposeFlowGraphFinderClass;

	public PrivacyDFDConfidentialityAnalysis(PrivacyDFDResourceProvider resourceProvider,
			Optional<Class<? extends Plugin>> modelProjectActivator, String modelProjectName,
			Class<? extends PrivacyDFDTransposeFlowGraphFinder> transposeFlowGraphFinderClass) {
		this.resourceProvider = resourceProvider;
		this.modelProjectActivator = modelProjectActivator;
		this.modelProjectName = modelProjectName;
		this.transposeFlowGraphFinderClass = transposeFlowGraphFinderClass;
	}

	public PrivacyDFDConfidentialityAnalysis(PrivacyDFDResourceProvider resourceProvider,
			Optional<Class<? extends Plugin>> modelProjectActivator, String modelProjectName) {
		this.resourceProvider = resourceProvider;
		this.modelProjectActivator = modelProjectActivator;
		this.modelProjectName = modelProjectName;
		this.transposeFlowGraphFinderClass = PrivacyDFDTransposeFlowGraphFinder.class;
	}

	@Override
	public void initializeAnalysis() {
		this.resourceProvider.setupResources();

		EcorePlugin.ExtensionProcessor.process(null);

		try {
			super.setupLoggers();
			var initializationBuilder = StandaloneInitializerBuilder.builder().registerProjectURI(
					PrivacyDFDConfidentialityAnalysis.class, PrivacyDFDConfidentialityAnalysis.PLUGIN_PATH);

			this.modelProjectActivator.ifPresent(projectActivator -> initializationBuilder
					.registerProjectURI(projectActivator, this.modelProjectName));

			initializationBuilder.build().init();

			logger.info("Successfully initialized standalone environment for the data flow analysis.");

		} catch (StandaloneInitializationException e) {
			logger.error("Could not initialize analysis", e);
			throw new IllegalStateException("Could not initialize analysis");
		}
		this.resourceProvider.loadRequiredResources();
		this.resourceProvider.validate();
		if (!this.resourceProvider.sufficientResourcesLoaded()) {
			logger.error("Insufficient amount of resources loaded");
			throw new IllegalStateException("Could not initialize analysis");
		}
	}

	@Override
	public DFDFlowGraphCollection findFlowGraphs() {

		return new DFDFlowGraphCollection(this.resourceProvider, this.transposeFlowGraphFinderClass);
	}

	@Override
	public void setLoggerLevel(Level level) {
		LoggerManager.getInstance().setLevel(level);
	}
}

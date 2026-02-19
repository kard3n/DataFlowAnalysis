package org.dataflowanalysis.privacy;

import java.nio.file.Paths;
import java.util.Optional;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.DataFlowAnalysisBuilder;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.analysis.utils.ResourceUtils;
import org.dataflowanalysis.privacy.core.PrivacyDFDTransposeFlowGraphFinder;
import org.dataflowanalysis.privacy.resource.PrivacyDFDModelResourceProvider;
import org.dataflowanalysis.privacy.resource.PrivacyDFDResourceProvider;
import org.dataflowanalysis.privacy.resource.PrivacyDFDURIResourceProvider;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.common.util.URI;

/**
 * This class is used to build an instance of {@link PrivacyDFDConfidentialityAnalysis}. The data contained in this class is
 * validated, when calling {@link PrivacyDFDDataFlowAnalysisBuilder#build()} before an analysis object is returned
 */
public class PrivacyDFDDataFlowAnalysisBuilder extends DataFlowAnalysisBuilder {

	protected final Logger logger = LoggerManager.getLogger(PrivacyDFDDataFlowAnalysisBuilder.class);
	
    protected String dataFlowDiagramPath;
    protected String dataDictionaryPath;
    protected String consentModelPath;
    protected Optional<PrivacyDFDResourceProvider> customResourceProvider;
    protected Class<? extends PrivacyDFDTransposeFlowGraphFinder> customTransposeFlowGraphFinderClass;

    /**
     * Constructs a privacy DFD analysis builder with empty values
     */
    public PrivacyDFDDataFlowAnalysisBuilder() {
        this.customResourceProvider = Optional.empty();
        this.customTransposeFlowGraphFinderClass = null;
    }
    
    /**
     * Sets standalone mode of the analysis
     * @return Builder of the analysis
     */
    public PrivacyDFDDataFlowAnalysisBuilder standalone() {
        super.standalone();
        return this;
    }

    /**
     * Sets the data dictionary used by the analysis
     * @return Builder of the analysis
     */
    public PrivacyDFDDataFlowAnalysisBuilder useConsentModel(String consentModelPath) {
        this.consentModelPath = consentModelPath;
        return this;
    }
    
    /**
     * Sets the modeling project name of the analysis
     * @return Builder of the analysis
     */
    public PrivacyDFDDataFlowAnalysisBuilder modelProjectName(String modelProjectName) {
        super.modelProjectName(modelProjectName);
        return this;
    }

    /**
     * Uses a plugin activator class for the given project
     * @param pluginActivator Plugin activator class of the modeling project
     * @return Returns builder object of the analysis
     */
    public PrivacyDFDDataFlowAnalysisBuilder usePluginActivator(Class<? extends Plugin> pluginActivator) {
        super.usePluginActivator(pluginActivator);
        return this;
    }

    /**
     * Sets the data dictionary used by the analysis
     * @return Builder of the analysis
     */
    public PrivacyDFDDataFlowAnalysisBuilder useDataDictionary(String dataDictionaryPath) {
        this.dataDictionaryPath = dataDictionaryPath;
        return this;
    }

    /**
     * Sets the data dictionary used by the analysis
     * @return Builder of the analysis
     */
    public PrivacyDFDDataFlowAnalysisBuilder useDataFlowDiagram(String dataFlowDiagramPath) {
        this.dataFlowDiagramPath = dataFlowDiagramPath;
        return this;
    }

    /**
     * Registers a custom resource provider for the analysis
     * @param resourceProvider Custom resource provider of the analysis
     */
    public PrivacyDFDDataFlowAnalysisBuilder useCustomResourceProvider(PrivacyDFDResourceProvider resourceProvider) {
        this.customResourceProvider = Optional.of(resourceProvider);
        if (resourceProvider instanceof PrivacyDFDModelResourceProvider)
            customResourceProviderIsLoaded = true;
        return this;
    }

    /**
     * Registers a custom TransposeFlowGraphFinder for the analysis
     * @param transposeFlowGraphFinderClass Custom TransposeFlowGraphFinder of the analysis
     */
    public PrivacyDFDDataFlowAnalysisBuilder useTransposeFlowGraphFinder(Class<? extends PrivacyDFDTransposeFlowGraphFinder> transposeFlowGraphFinderClass) {
        this.customTransposeFlowGraphFinderClass = transposeFlowGraphFinderClass;
        return this;
    }


    /**
     * Determines the effective resource provider that should be used by the analysis
     */
    private PrivacyDFDResourceProvider getEffectiveResourceProvider() {
        if (this.customResourceProvider.isEmpty()) {
            URI dataDictionaryUri = this.modelProjectName.isEmpty() ? URI.createFileURI(Paths.get(this.dataDictionaryPath)
                    .toAbsolutePath()
                    .toString()) : ResourceUtils.createRelativePluginURI(this.dataDictionaryPath, this.modelProjectName);
            URI dataFlowDiagramUri = this.modelProjectName.isEmpty() ? URI.createFileURI(Paths.get(this.dataFlowDiagramPath)
                    .toAbsolutePath()
                    .toString()) : ResourceUtils.createRelativePluginURI(this.dataFlowDiagramPath, this.modelProjectName);
            URI consentModelUri = this.modelProjectName.isEmpty() ? URI.createFileURI(Paths.get(this.consentModelPath)
                    .toAbsolutePath()
                    .toString()) : ResourceUtils.createRelativePluginURI(this.consentModelPath, this.modelProjectName);

            return new PrivacyDFDURIResourceProvider(dataFlowDiagramUri, dataDictionaryUri, consentModelUri);
        }
        return this.customResourceProvider.get();
    }

    /**
     * Validates the stored data
     */
    @Override
    protected void validate() {
        super.validate();
        if (this.customResourceProvider.isEmpty() && (this.dataDictionaryPath == null || this.dataDictionaryPath.isEmpty())) {
            logger.error("A data dictionary is required to run the data flow analysis",
                    new IllegalStateException("The DFD analysis requires a data dictionary"));
        }
        if (this.customResourceProvider.isEmpty() && (this.dataFlowDiagramPath == null || this.dataFlowDiagramPath.isEmpty())) {
            logger.error("A data flow diagram is required to run the data flow analysis",
                    new IllegalStateException("The DFD analysis requires a data flow diagram"));
        }
    }

    /**
     * Builds a new analysis from the given data
     */
    public PrivacyDFDConfidentialityAnalysis build() {
        this.validate();
        PrivacyDFDResourceProvider resourceProvider = this.getEffectiveResourceProvider();
        resourceProvider.validate();

        if (customTransposeFlowGraphFinderClass == null)
            return new PrivacyDFDConfidentialityAnalysis(resourceProvider, this.pluginActivator, this.modelProjectName);
        else
            return new PrivacyDFDConfidentialityAnalysis(resourceProvider, this.pluginActivator, this.modelProjectName,
                    this.customTransposeFlowGraphFinderClass);
    }
}

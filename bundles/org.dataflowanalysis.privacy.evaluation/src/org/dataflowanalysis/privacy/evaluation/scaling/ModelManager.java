package org.dataflowanalysis.privacy.evaluation.scaling;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.analysis.utils.ResourceUtils;
import org.dataflowanalysis.examplemodels.Activator;
import org.dataflowanalysis.privacy.PrivacyDFDConfidentialityAnalysis;
import org.dataflowanalysis.privacy.resource.PrivacyDFDURIResourceProvider;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import tools.mdsd.library.standalone.initialization.StandaloneInitializationException;
import tools.mdsd.library.standalone.initialization.StandaloneInitializerBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Optional;

/**
 * Class for loading and saving models
 */
public class ModelManager {
	private static final Logger logger = LoggerManager.getLogger(ModelManager.class);
	protected final Optional<Class<? extends Plugin>> modelProjectActivator;
	
	public ModelManager() {
		modelProjectActivator = Optional.of(Activator.class);
	}
	
	public PrivacyModelPackage loadModel(Path dataFlowDiagramPath, Path dataDictionaryPath, Path privacyModelPath, String modelProjectName) {
		URI dataFlowDiagramUri = modelProjectName.isEmpty() ? URI.createFileURI(dataFlowDiagramPath
                .toAbsolutePath()
                .toString()) : ResourceUtils.createRelativePluginURI(dataFlowDiagramPath.toString(), modelProjectName);
		URI dataDictionaryUri = modelProjectName.isEmpty() ? URI.createFileURI(dataDictionaryPath
                .toAbsolutePath()
                .toString()) : ResourceUtils.createRelativePluginURI(dataDictionaryPath.toString(), modelProjectName);
        URI privacyModelUri = modelProjectName.isEmpty() ? URI.createFileURI(privacyModelPath
                .toAbsolutePath()
                .toString()) : ResourceUtils.createRelativePluginURI(privacyModelPath.toString(), modelProjectName);
        
        
        // Setup environment
        EcorePlugin.ExtensionProcessor.process(null);
        try {
            var initializationBuilder = StandaloneInitializerBuilder.builder()
                    .registerProjectURI(PrivacyDFDConfidentialityAnalysis.class, PrivacyDFDConfidentialityAnalysis.PLUGIN_PATH);

            this.modelProjectActivator
                    .ifPresent(projectActivator -> initializationBuilder.registerProjectURI(projectActivator, modelProjectName));

            initializationBuilder.build()
                    .init();

            logger.info("Successfully initialized standalone environment for the data flow analysis.");

        } catch (StandaloneInitializationException e) {
            logger.error("Could not initialize analysis", e);
            throw new IllegalStateException("Could not initialize analysis");
        }
        
        PrivacyDFDURIResourceProvider provider = new PrivacyDFDURIResourceProvider(dataFlowDiagramUri, dataDictionaryUri, privacyModelUri);
        provider.setupResources();
        provider.loadRequiredResources();
        logger.info(provider.sufficientResourcesLoaded());
        provider.validate();
        
        return new PrivacyModelPackage(provider.getDataFlowDiagram(), provider.getDataDictionary(), provider.getPrivacyModel());
	}

	    /**
	     * Saves the models within a PrivacyModelPackage to a specified output directory.
	     *
	     * @param pkg             The record containing your three models.
	     * @param outputDirectory The path to the folder where files should be saved.
	     * @param baseFilename    The base name for the files (e.g., "modified_model").
	     */
	    public void savePrivacyPackage(PrivacyModelPackage pkg, Path outputDirectory, String baseFilename) {
	        try {
	            // 1. Ensure the output directory exists
	            Files.createDirectories(outputDirectory);

	            // 2. Create a fresh ResourceSet for saving
	            ResourceSet resourceSet = new ResourceSetImpl();
	            
	            // Register the XMI factory for your file extensions (Crucial for standalone Java)
	            resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("dataflowdiagram", new XMIResourceFactoryImpl());
	            resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("datadictionary", new XMIResourceFactoryImpl());
	            resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("privacymodel", new XMIResourceFactoryImpl());

	            // 3. Define the URIs (file paths) for the new files
	            URI dfdUri = URI.createFileURI(outputDirectory.resolve(baseFilename + ".dataflowdiagram").toAbsolutePath().toString());
	            URI ddUri = URI.createFileURI(outputDirectory.resolve(baseFilename + ".datadictionary").toAbsolutePath().toString());
	            URI cmUri = URI.createFileURI(outputDirectory.resolve(baseFilename + ".privacymodel").toAbsolutePath().toString());

	            // 4. Create the Resources
	            Resource dfdResource = resourceSet.createResource(dfdUri);
	            Resource ddResource = resourceSet.createResource(ddUri);
	            Resource cmResource = resourceSet.createResource(cmUri);

	            // 5. Add your model root objects to the contents of the Resources
	            // Note: If they were already in another Resource, this moves them.
	            if (pkg.dfd() != null) dfdResource.getContents().add(pkg.dfd());
	            if (pkg.dd() != null) ddResource.getContents().add(pkg.dd());
	            if (pkg.cm() != null) cmResource.getContents().add(pkg.cm());

	            // 6. Save the files to disk
	            dfdResource.save(Collections.emptyMap());
	            ddResource.save(Collections.emptyMap());
	            cmResource.save(Collections.emptyMap());

	            logger.info("Successfully saved models to: " + outputDirectory.toAbsolutePath());

	        } catch (IOException e) {
	            logger.error("Failed to save models: " + e.getMessage());
	            e.printStackTrace();
	        }
	    
	}
}

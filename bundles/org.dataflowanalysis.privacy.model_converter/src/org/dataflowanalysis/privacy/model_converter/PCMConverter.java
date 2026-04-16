package org.dataflowanalysis.privacy.model_converter;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.analysis.utils.ResourceUtils;
import org.dataflowanalysis.converter.dfd2web.DataFlowDiagramAndDictionary;
import org.dataflowanalysis.converter.pcm2dfd.PCM2DFDConverter;
import org.dataflowanalysis.converter.pcm2dfd.PCMConverterModel;
import org.dataflowanalysis.dfd.datadictionary.DataDictionary;
import org.dataflowanalysis.dfd.dataflowdiagram.DataFlowDiagram;
import org.dataflowanalysis.examplemodels.Activator;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.jupiter.api.Test;

import tools.mdsd.library.standalone.initialization.StandaloneInitializationException;
import tools.mdsd.library.standalone.initialization.StandaloneInitializerBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Optional;

public class PCMConverter {
	@Test
	public void testConvert() {
		String inputModel = "MaaSTicketSystem";
		String inputFile = "MaaS";
		Path outputPath = Paths.get("results_convert");
		
		final var usageModelPath = Paths.get("scenarios", "pcm", inputModel, inputFile + ".usagemodel").toString();
		final var allocationPath = Paths.get("scenarios", "pcm", inputModel, inputFile + ".allocation").toString();
		final var nodeCharPath = Paths.get("scenarios", "pcm", inputModel, inputFile + ".nodecharacteristics")
				.toString();

		PCMConverterModel converterModel = new PCMConverterModel("org.dataflowanalysis.examplemodels", usageModelPath,
				allocationPath, nodeCharPath, Activator.class);
		PCM2DFDConverter converter = new PCM2DFDConverter();
		DataFlowDiagramAndDictionary dfd = converter.convert(converterModel);
		savePackage(dfd, outputPath, "default");
	}

	/**
	 * Saves the models within a PrivacyModelPackage to a specified output
	 * directory.
	 * 
	 * @param pkg             The record containing your three models.
	 * @param outputDirectory The path to the folder where files should be saved.
	 * @param baseFilename    The base name for the files (e.g., "modified_model").
	 */
	public static void savePackage(DataFlowDiagramAndDictionary pkg, Path outputDirectory, String baseFilename) {
		try {
			// 1. Ensure the output directory exists
			Files.createDirectories(outputDirectory);
			// 2. Create a fresh ResourceSet for saving
			ResourceSet resourceSet = new ResourceSetImpl();
			// Register the XMI factory for your file extensions (Crucial for standalone
			// Java)
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("dataflowdiagram",
					new XMIResourceFactoryImpl());
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("datadictionary",
					new XMIResourceFactoryImpl());
			// 3. Define the URIs (file paths) for the new files
			URI dfdUri = URI.createFileURI(
					outputDirectory.resolve(baseFilename + ".dataflowdiagram").toAbsolutePath().toString());
			URI ddUri = URI.createFileURI(
					outputDirectory.resolve(baseFilename + ".datadictionary").toAbsolutePath().toString());
			// 4. Create the Resources
			Resource dfdResource = resourceSet.createResource(dfdUri);
			Resource ddResource = resourceSet.createResource(ddUri);
			// 5. Add your model root objects to the contents of the Resources
			// Note: If they were already in another Resource, this moves them.
			if (pkg.dataFlowDiagram() != null)
				dfdResource.getContents().add(pkg.dataFlowDiagram());
			if (pkg.dataDictionary() != null)
				ddResource.getContents().add(pkg.dataDictionary());
			// 6. Save the files to disk
			dfdResource.save(Collections.emptyMap());
			ddResource.save(Collections.emptyMap());
			System.out.println("Path: " + outputDirectory.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package org.dataflowanalysis.privacy.resource;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.dfd.datadictionary.DataDictionary;
import org.dataflowanalysis.dfd.dataflowdiagram.DataFlowDiagram;
import org.dataflowanalysis.privacy.consentmodel.ConsentModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * This class represents a {@link DFDResourceProvider} that provides the
 * resources to the analysis by loading them via a {@link URI}
 */
public class PrivacyDFDURIResourceProvider extends PrivacyDFDResourceProvider {
	private static final Logger logger = LoggerManager.getLogger(PrivacyDFDURIResourceProvider.class);

	private final URI dataFlowDiagramURI;
	private final URI dataDictionaryURI;
	private final URI consentModelURI;
	private DataFlowDiagram dataFlowDiagram;
	private DataDictionary dataDictionary;
	private ConsentModel consentModel;

	/**
	 * Creates a new resource loader with the given model URIs
	 * 
	 * @param dataFlowDiagramURI URI to the data flow diagram model
	 * @param dataDictionaryURI  URI to the data dictionary model
	 * @param consentModelURI    URI to the consent model
	 */
	public PrivacyDFDURIResourceProvider(URI dataFlowDiagramURI, URI dataDictionaryURI, URI consentModelURI) {
		this.dataFlowDiagramURI = dataFlowDiagramURI;
		this.dataDictionaryURI = dataDictionaryURI;
		this.consentModelURI = consentModelURI;
	}

	@Override
	public void loadRequiredResources() {
		this.dataFlowDiagram = (DataFlowDiagram) this.loadModelContent(dataFlowDiagramURI);
		this.dataDictionary = (DataDictionary) this.loadModelContent(dataDictionaryURI);
		this.consentModel = (ConsentModel) this.loadModelContent(consentModelURI);
		List<Resource> loadedResources;
		do {
			loadedResources = new ArrayList<>(this.resources.getResources());
			loadedResources.forEach(EcoreUtil::resolveAll);
		} while (loadedResources.size() != this.resources.getResources().size());
		EcoreUtil.resolveAll(this.resources);
		for (var resource : this.resources.getResources()) {
			if (!resource.getErrors().isEmpty()) {
				logger.error("Errors occurred during loading a model:");
				logger.error(resource.getErrors().stream().map(Resource.Diagnostic::getMessage).toList());
			}
		}
	}

	@Override
	public DataFlowDiagram getDataFlowDiagram() {
		return this.dataFlowDiagram;
	}

	@Override
	public DataDictionary getDataDictionary() {
		return this.dataDictionary;
	}

	@Override
	public ConsentModel getConsentModel() {
		return this.consentModel;
	}
}

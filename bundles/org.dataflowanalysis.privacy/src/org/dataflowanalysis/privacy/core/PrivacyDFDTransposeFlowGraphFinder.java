package org.dataflowanalysis.privacy.core;

import java.util.*;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.core.TransposeFlowGraphFinder;
import org.dataflowanalysis.analysis.dfd.core.DFDTransposeFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDTransposeFlowGraphFinder;
import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.dataflowanalysis.analysis.dfd.resource.DFDResourceProvider;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.dfd.datadictionary.*;
import org.dataflowanalysis.dfd.dataflowdiagram.*;
import org.dataflowanalysis.privacy.consent_model.ConsentModel;
import org.dataflowanalysis.privacy.consent_model.ConsentedFunctionality;
import org.dataflowanalysis.privacy.consent_model.Role;
import org.dataflowanalysis.privacy.resource.PrivacyDFDResourceProvider;

/**
 * The DFDTransposeFlowGraphFinder determines all transpose flow graphs contained in a model
 */
public class PrivacyDFDTransposeFlowGraphFinder implements TransposeFlowGraphFinder {
    private final Logger logger = LoggerManager.getLogger(TransposeFlowGraphFinder.class);
    protected final DataFlowDiagram dataFlowDiagram;
    protected final ConsentModel consentModel;
    private boolean hasCycles = false;
    private final DataDictionary dataDictionary;

    private Map<Pin, DFDVertex> mapOutPinToExistingVertex = new HashMap<>();

    public PrivacyDFDTransposeFlowGraphFinder(PrivacyDFDResourceProvider resourceProvider) {
        this.dataFlowDiagram = resourceProvider.getDataFlowDiagram();
        this.consentModel = resourceProvider.getConsentModel();
        this.dataDictionary = resourceProvider.getDataDictionary();
    }

    public PrivacyDFDTransposeFlowGraphFinder(DataDictionary dataDictionary,DataFlowDiagram dataFlowDiagram, ConsentModel consentModel) {
    	this.dataDictionary = dataDictionary;
    	this.dataFlowDiagram = dataFlowDiagram;
        this.consentModel = consentModel;
    }

    /**
     * Finds all transpose flow graphs in a dataflowdiagram model instance
     * @return Returns a list of all transpose flow graphs
     */
    @Override
    public List<? extends AbstractTransposeFlowGraph> findTransposeFlowGraphs() {
        return this.findTransposeFlowGraphs(getEndNodes(dataFlowDiagram.getNodes()), List.of());
    }

    @Override
    public List<? extends AbstractTransposeFlowGraph> findTransposeFlowGraphs(List<?> sourceNodes) {
        return this.findTransposeFlowGraphs(getEndNodes(dataFlowDiagram.getNodes()), sourceNodes);
    }

    @Override
    public List<? extends AbstractTransposeFlowGraph> findTransposeFlowGraphs(List<?> sinkNodes, List<?> sourceNodes) {
    	List<DFDTransposeFlowGraph> transposeFlowGraphs = new ArrayList<>();
    	
    	List<Node> sources = sourceNodes.stream()
                .filter(Node.class::isInstance)
                .map(Node.class::cast)
                .toList();
    	
    	// Go over all roles, and calculate all consent combinations for each
    	this.consentModel.getRoles().forEach(role -> {
    		Set<ConsentedFunctionality> required = calculateRequiredFunctionalities(role);
    		
    		// Calculate all combinations taking into account optional consent options
    		List<Set<ConsentedFunctionality>> combinations = new ArrayList<>();
    		combinations.add(required);
    		this.createOptionalCombinations(required, combinations, role.getAllows());
    		
    		
    		if(true) {// TODO: only add labels if the Source has the current role attached to it
    			// Create TFG for every combination
        		combinations.forEach(combination -> {
        			// Adapt source nodes
        			sources.forEach(source -> {
        				this.dataDictionary.getBehavior().forEach(behavior -> {
        					behavior.get
        				})
        				source.getBehavior().getOutPin().forEach(pin -> {
        					
        				});
        			});
        			
        			DFDTransposeFlowGraphFinder finder = new DFDTransposeFlowGraphFinder(this.dataDictionary, this.dataFlowDiagram);
        			transposeFlowGraphs.addAll(finder.findTransposeFlowGraphs(sinkNodes, sources).stream() // TODO change sources to adapted version
        	                .filter(DFDTransposeFlowGraph.class::isInstance)
        	                .map(DFDTransposeFlowGraph.class::cast)
        	                .toList());
        		});
    		}
    		
    	});
        
        

        return transposeFlowGraphs;
    }
    
    /**
     * Calculate all optional combinations possible
     * @param startingEntry The base for the new combinations. Should be the ones required by the role at the beginning.
     * @param existingEntries All already created combinations. New ones will be added to this list.
     * @param allowed All allowed functionalities that combinations can be created with
     */
    protected void createOptionalCombinations(Set<ConsentedFunctionality> startingEntry, List<Set<ConsentedFunctionality>> existingEntries, List<ConsentedFunctionality> allowed){
    	//List<Set<ConsentedFunctionality>> result = new ArrayList<>();
    	allowed.forEach(addition -> {
    		if(!startingEntry.contains(addition) && isCompatible(startingEntry, addition)) {
    			Set<ConsentedFunctionality> newCombination = new HashSet<>(startingEntry); // Copy
    			newCombination.add(addition);
    			if(!existingEntries.contains(newCombination)) {
    				existingEntries.add(newCombination);
    				createOptionalCombinations(newCombination, existingEntries, allowed);
    			}
    			
    		}
    	});
    }
    
    /**
     * Checks if the set conflicts with the new entry (addition)
     * @param set Set to check for
     * @param addition New addition to the set
     * @return True if the new addition is compatible with the set
     */
    protected boolean isCompatible(Set<ConsentedFunctionality> set, ConsentedFunctionality addition) {
    	for(ConsentedFunctionality exclude: addition.getExcludes()) {
    		if(set.contains(exclude)) return false;
    	}
    	for(ConsentedFunctionality entry: set) {
    		if(entry.getExcludes().contains(addition)) return false;
    	}
    	
    	return true;
    }
    
    /**
     * For every entry, checks if all of its dependencies are also included
     * @param set The set to check
     * @return Whether all entries of the set have their requirements met or not.
     */
    protected boolean containsRequired(Set<ConsentedFunctionality> set) {
    	for(ConsentedFunctionality entry: set) {
    		for(ConsentedFunctionality requriement: entry.getRequires()) {
    			if(!set.contains(requriement)) return false;
    		}
    	}
    	return true;
    }
    
    /**
     * Calculates all required functionalities associated with the given role
     * @param role The role whose required functionalities to calculate
     * @return The role's required functionalities, including recursive ones
     */
    protected Set<ConsentedFunctionality> calculateRequiredFunctionalities(Role role){
    	Set<ConsentedFunctionality> result =  new HashSet<>();
    	
    	role.getRequires().forEach(func -> {
    		result.add(func);
    	});
    	
    	return result;
    }
    
    /**
     * Recursively aggregates all functionalities the given one depends on (requires)
     * @param functionality The functionality whose required dependencies to get
     * @return List of all required dependencies
     */
    protected Set<ConsentedFunctionality> getRequired(ConsentedFunctionality functionality){
    	Set<ConsentedFunctionality> result =  new HashSet<>();
    	result.add(functionality);
    	functionality.getRequires().forEach(other -> {
    		result.addAll(getRequired(other));
    	});
    	
    	return result;
    }
    
    
    // TODO inherit for better code reuse
    /**
     * Gets a list of nodes that are sinks of the given list of nodes
     * @param nodes A list of all nodes of which the sinks should be determined
     * @return List of sink nodes reachable by the given list of nodes
     */
    protected List<Node> getEndNodes(List<Node> nodes) {
        var endNodes = nodes.stream()
                .filter(node -> {
                    return node.getBehavior()
                            .getInPin()
                            .stream()
                            .filter(pin -> {
                                return isInputPinUsed(pin, node);
                            })
                            .count() > 0; // If a single input pin is unused we have a sink
                })
                .toList();

        if (endNodes.isEmpty())
            throw new IllegalArgumentException("Error, sink cannot be identified!");

        return endNodes;
    }
    
    /**
     * Checks whether an input Pin is not used by any assignment in the node
     * @param pin Input Pin
     * @param node Node
     * @return
     */
    private boolean isInputPinUsed(Pin pin, Node node) {
        for (AbstractAssignment abstractAssignment : node.getBehavior()
                .getAssignment()) {
            if ((abstractAssignment instanceof ForwardingAssignment forwardingAssignment && forwardingAssignment.getInputPins()
                    .contains(pin)) || (abstractAssignment instanceof Assignment assignment
                            && assignment.getInputPins()
                                    .contains(pin))) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCycles() {
        return hasCycles;
    }

}

package org.dataflowanalysis.privacy.core;

import java.util.*;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.core.TransposeFlowGraphFinder;
import org.dataflowanalysis.analysis.dfd.core.DFDTransposeFlowGraph;
import org.dataflowanalysis.analysis.dfd.core.DFDTransposeFlowGraphFinder;
import org.dataflowanalysis.analysis.dfd.resource.DFDResourceProvider;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.dfd.datadictionary.*;
import org.dataflowanalysis.dfd.dataflowdiagram.*;
import org.dataflowanalysis.privacy.consentmodel.ConsentModel;
import org.dataflowanalysis.privacy.consentmodel.ConsentOption;
import org.dataflowanalysis.privacy.consentmodel.Role;
import org.dataflowanalysis.privacy.resource.PrivacyDFDResourceProvider;

/**
 * The DFDTransposeFlowGraphFinder determines all transpose flow graphs
 * contained in a model
 */
// TODO: inherit from DFDTransposeFlowGraphFinder
public class PrivacyDFDTransposeFlowGraphFinder implements TransposeFlowGraphFinder {
	private final Logger logger = LoggerManager.getLogger(PrivacyDFDTransposeFlowGraphFinder.class);
	protected final DataFlowDiagram dataFlowDiagram;
	protected final ConsentModel consentModel;
	private boolean hasCycles = false;
	private final DataDictionary dataDictionary;

	public PrivacyDFDTransposeFlowGraphFinder(DFDResourceProvider resourceProvider) {
		if (!(resourceProvider instanceof PrivacyDFDResourceProvider)) {
			logger.error("Received wrong type of resource provider.");
			throw new RuntimeException("");
		}
		
		this.dataFlowDiagram = ((PrivacyDFDResourceProvider) resourceProvider).getDataFlowDiagram();
		this.consentModel = ((PrivacyDFDResourceProvider) resourceProvider).getConsentModel();
		this.dataDictionary = ((PrivacyDFDResourceProvider) resourceProvider).getDataDictionary();
	}

	public PrivacyDFDTransposeFlowGraphFinder(DataDictionary dataDictionary, DataFlowDiagram dataFlowDiagram,
			ConsentModel consentModel) {
		
		this.dataDictionary = dataDictionary;
		this.dataFlowDiagram = dataFlowDiagram;
		this.consentModel = consentModel;
	}

	/**
	 * Finds all transpose flow graphs in a dataflowdiagram model instance
	 * 
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

		List<Node> sources = sourceNodes.stream().filter(Node.class::isInstance).map(Node.class::cast).toList();

		// Go over all roles
		this.consentModel.getRoleLabelType().getLabels().forEach(roleLabel -> {
			Role role = roleLabel.getRole();
			// calculate all consent combinations for the current role
			List<Set<ConsentOption>> combinations = this.calculateRoleConsentOptions(role);
			
			logger.info("Final amount of consent combinations for role "+  role.getEntityName() + " : " + combinations.size());

			// Adapt source nodes
			combinations.forEach(combination -> {
				List<AbstractAssignment> modifiedAssignments = new LinkedList<>(); // Holds all assignments we added labels to

				// Make a list of all labels that should be added to each data item for the
				// current consent combination
				ArrayList<AbstractLabel> labelsToAdd = new ArrayList<>(this.consentModel.getConsentLabelType().getLabels().stream()
						.filter(label -> combination.contains(label.getConsentOption()))
						.map(label -> (AbstractLabel) label).toList());
				labelsToAdd.add((AbstractLabel) roleLabel);
				// Add new labels to the behavior
				sources.forEach(source -> {
					// Skip all sources without the current role(label)
					if (source.getProperties().contains((AbstractLabel) roleLabel)) {
						source.getBehavior().getAssignment().forEach(assignment -> {
							if (assignment instanceof Assignment) {
								((Assignment) assignment).getOutputLabels().addAll(labelsToAdd);
								modifiedAssignments.add(assignment);
							}
							// TODO what about the other types? Necessary?
						});
					}
				});

				// Compute and add new DFDs.
				// findTransposeFlowGraphs() should create copies, including of the behavior and
				// assignments
				DFDTransposeFlowGraphFinder finder = new DFDTransposeFlowGraphFinder(this.dataDictionary,
						this.dataFlowDiagram);
				transposeFlowGraphs.addAll(finder.findTransposeFlowGraphs(sinkNodes, sources).stream()
						.filter(DFDTransposeFlowGraph.class::isInstance).map(DFDTransposeFlowGraph.class::cast)
						.toList());

				// Remove labels from the behavior (or to be exact, its assignments)
				modifiedAssignments.forEach(assignment -> {
					if (assignment instanceof Assignment) {
						((Assignment) assignment).getOutputLabels().removeAll(labelsToAdd);
					}
				});
			});

		});

		return transposeFlowGraphs;
	}

	protected List<Set<ConsentOption>> calculateRoleConsentOptions(Role role) {
		Set<ConsentOption> required = calculateRequiredFunctionalities(role);

		// Calculate all combinations taking into account optional consent options
		List<Set<ConsentOption>> combinations = new ArrayList<>();
		combinations.add(required);
		this.createOptionalCombinations(required, combinations, role.getAllows());

		return combinations;
	}

	/**
	 * Calculate all optional combinations possible
	 * 
	 * @param startingEntry   The base for the new combinations. Should be the ones
	 *                        required by the role at the beginning.
	 * @param existingEntries All already created combinations. New ones will be
	 *                        added to this list.
	 * @param allowed         All allowed functionalities that combinations can be
	 *                        created with
	 */
	protected void createOptionalCombinations(Set<ConsentOption> startingEntry,
			List<Set<ConsentOption>> existingEntries, List<ConsentOption> allowed) {
		// List<Set<ConsentedFunctionality>> result = new ArrayList<>();
		allowed.forEach(addition -> {
			if (!startingEntry.contains(addition) && isCompatible(startingEntry, addition)) {
				Set<ConsentOption> newCombination = new HashSet<>(startingEntry); // Copy
				newCombination.add(addition);
				if (!existingEntries.contains(newCombination)) {
					existingEntries.add(newCombination);
					createOptionalCombinations(newCombination, existingEntries, allowed);
				}

			}
		});
	}

	/**
	 * Checks if the set conflicts with the new entry (addition)
	 * 
	 * @param set      Set to check for
	 * @param addition New addition to the set
	 * @return True if the new addition is compatible with the set
	 */
	protected boolean isCompatible(Set<ConsentOption> set, ConsentOption addition) {
		for (ConsentOption exclude : addition.getExcludes()) {
			if (set.contains(exclude))
				return false;
		}
		for (ConsentOption entry : set) {
			if (entry.getExcludes().contains(addition))
				return false;
		}

		return true;
	}

	/**
	 * For every entry, checks if all of its dependencies are also included
	 * 
	 * @param set The set to check
	 * @return Whether all entries of the set have their requirements met or not.
	 */
	protected boolean containsRequired(Set<ConsentOption> set) {
		for (ConsentOption entry : set) {
			for (ConsentOption requriement : entry.getRequires()) {
				if (!set.contains(requriement))
					return false;
			}
		}
		return true;
	}

	/**
	 * Calculates all required functionalities associated with the given role
	 * 
	 * @param role The role whose required functionalities to calculate
	 * @return The role's required functionalities, including recursive ones
	 */
	protected Set<ConsentOption> calculateRequiredFunctionalities(Role role) {
		Set<ConsentOption> result = new HashSet<>();

		role.getRequires().forEach(func -> {
			result.add(func);
		});

		return result;
	}

	/**
	 * Recursively aggregates all functionalities the given one depends on
	 * (requires)
	 * 
	 * @param functionality The functionality whose required dependencies to get
	 * @return List of all required dependencies
	 */
	protected Set<ConsentOption> getRequired(ConsentOption functionality) {
		Set<ConsentOption> result = new HashSet<>();
		result.add(functionality);
		functionality.getRequires().forEach(other -> {
			result.addAll(getRequired(other));
		});

		return result;
	}

	// TODO inherit for better code reuse
	/**
	 * Gets a list of nodes that are sinks of the given list of nodes
	 * 
	 * @param nodes A list of all nodes of which the sinks should be determined
	 * @return List of sink nodes reachable by the given list of nodes
	 */
	protected List<Node> getEndNodes(List<Node> nodes) {
		var endNodes = nodes.stream().filter(node -> {
			return node.getBehavior().getInPin().stream().filter(pin -> {
				return isInputPinUsed(pin, node);
			}).count() > 0; // If a single input pin is unused we have a sink
		}).toList();

		if (endNodes.isEmpty())
			throw new IllegalArgumentException("Error, sink cannot be identified!");

		return endNodes;
	}

	/**
	 * Checks whether an input Pin is not used by any assignment in the node
	 * 
	 * @param pin  Input Pin
	 * @param node Node
	 * @return
	 */
	private boolean isInputPinUsed(Pin pin, Node node) {
		for (AbstractAssignment abstractAssignment : node.getBehavior().getAssignment()) {
			if ((abstractAssignment instanceof ForwardingAssignment forwardingAssignment
					&& forwardingAssignment.getInputPins().contains(pin))
					|| (abstractAssignment instanceof Assignment assignment
							&& assignment.getInputPins().contains(pin))) {
				return false;
			}
		}
		return true;
	}

	public boolean hasCycles() {
		return hasCycles;
	}

}

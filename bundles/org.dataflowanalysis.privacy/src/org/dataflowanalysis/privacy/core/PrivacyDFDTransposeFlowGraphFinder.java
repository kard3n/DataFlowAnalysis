package org.dataflowanalysis.privacy.core;

import java.util.*;
import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.AbstractTransposeFlowGraph;
import org.dataflowanalysis.analysis.core.TransposeFlowGraphFinder;
import org.dataflowanalysis.analysis.dfd.core.DFDTransposeFlowGraphFinder;
import org.dataflowanalysis.analysis.dfd.resource.DFDResourceProvider;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.dfd.datadictionary.*;
import org.dataflowanalysis.dfd.dataflowdiagram.*;
import org.dataflowanalysis.privacy.privacymodel.Functionality;
import org.dataflowanalysis.privacy.privacymodel.PrivacyModel;
import org.dataflowanalysis.privacy.privacymodel.Role;
import org.dataflowanalysis.privacy.privacymodel.RoleLabel;
import org.dataflowanalysis.privacy.resource.PrivacyDFDResourceProvider;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

/**
 * The DFDTransposeFlowGraphFinder determines all transpose flow graphs
 * contained in a model
 */
// TODO: inherit from DFDTransposeFlowGraphFinder
public class PrivacyDFDTransposeFlowGraphFinder implements TransposeFlowGraphFinder {
	private static final Logger logger = LoggerManager.getLogger(PrivacyDFDTransposeFlowGraphFinder.class);
	protected final DataFlowDiagram dataFlowDiagram;
	protected final PrivacyModel privacyModel;
	private final DataDictionary dataDictionary;

	public PrivacyDFDTransposeFlowGraphFinder(DFDResourceProvider resourceProvider) {
		if (!(resourceProvider instanceof PrivacyDFDResourceProvider)) {
			logger.error("Received wrong type of resource provider.");
			throw new RuntimeException("");
		}

		this.dataFlowDiagram = ((PrivacyDFDResourceProvider) resourceProvider).getDataFlowDiagram();
		this.privacyModel = ((PrivacyDFDResourceProvider) resourceProvider).getPrivacyModel();
		this.dataDictionary = ((PrivacyDFDResourceProvider) resourceProvider).getDataDictionary();
	}

	public PrivacyDFDTransposeFlowGraphFinder(DataDictionary dataDictionary, DataFlowDiagram dataFlowDiagram,
			PrivacyModel privacyModel) {

		this.dataDictionary = dataDictionary;
		this.dataFlowDiagram = dataFlowDiagram;
		this.privacyModel = privacyModel;
	}

	/**
	 * Finds all transpose flow graphs in a dataflowdiagram model instance
	 * 
	 * @return Returns a list of all transpose flow graphs
	 */
	@Override
	public List<? extends AbstractTransposeFlowGraph> findTransposeFlowGraphs() {
		return this.findTransposeFlowGraphs(List.of(), List.of());
	}

	@Override
	public List<? extends AbstractTransposeFlowGraph> findTransposeFlowGraphs(List<?> sourceNodes) {
		return this.findTransposeFlowGraphs(List.of(), sourceNodes);
	}

	@Override
	public List<? extends AbstractTransposeFlowGraph> findTransposeFlowGraphs(List<?> sinkNodes, List<?> sourceNodes) {

		List<Node> sources = this.getSourceNodes(dataFlowDiagram.getNodes());

		HashMap<RoleLabel, Set<Set<Functionality>>> roleToCombinations = new HashMap<>();

		List<Flow> flowsToRemove = new ArrayList<>();

		List<Node> nodesToAdd = new ArrayList<>();
		List<Behavior> behaviorToAdd = new ArrayList<>();
		List<Flow> flowsToAdd = new ArrayList<>();

		// Go over all source nodes and replicate them by role x functionalities
		// (consent options)
		for (Node source : sources) {

			List<Flow> flowsFromNode = this.dataFlowDiagram.getFlows().stream()
					.filter(flow -> flow.getSourceNode() == source).toList();
			List<Flow> flowsToNode = this.dataFlowDiagram.getFlows().stream()
					.filter(flow -> flow.getDestinationNode() == source).toList();
			flowsToRemove.addAll(flowsToNode);
			flowsToRemove.addAll(flowsFromNode);

			int instanceNumber = 0;

			List<RoleLabel> roles = source.getProperties().stream().filter(label -> label instanceof RoleLabel)
					.map(label -> (RoleLabel) label).toList();
			for (int r = 0; r < roles.size(); r++) {
				var roleLabel = roles.get(r);
				if (!roleToCombinations.containsKey(roleLabel)) {
					roleToCombinations.put(roleLabel, this.calculateRoleFunctionalityOptions(roleLabel.getRole()));
					logger.debug("Final amount of consented functionality combinations for role "
							+ roleLabel.getRole().getEntityName() + " : " + roleToCombinations.get(roleLabel).size());
				}

				List<Set<Functionality>> currentCombinations = new ArrayList<>(roleToCombinations.get(roleLabel));
				for (int c = 0; c < currentCombinations.size(); c++) {
					Set<Functionality> combination = currentCombinations.get(c);

					// For the last user, the original node is adapted. This is to prevent a bug
					// that occurs when a node is removed and re-added from the DFD's flow diagram
					boolean lastReplication = r == roles.size() - 1 && c == currentCombinations.size() - 1;

					// Copier is created here to prevent it from rewiring everything (including
					// those created by previous iterations) every time
					Copier copier = new Copier();

					Node clonedSource = (lastReplication) ? source : (Node) copier.copy(source); // Copy node
					if (!lastReplication) {
						nodesToAdd.add(clonedSource);
					}
					clonedSource.setEntityName(clonedSource.getEntityName() + "_" + instanceNumber);
					clonedSource.setId(clonedSource.getId() + "_" + instanceNumber);

					ArrayList<AbstractLabel> functionalityLabelsToAdd = new ArrayList<>(
							this.privacyModel.getFunctionalityLabelType().getLabels().stream()
									.filter(label -> combination.contains(label.getFunctionality()))
									.map(label -> (AbstractLabel) label).toList());

					// Add functionality labels to the node's properties
					clonedSource.getProperties().addAll(functionalityLabelsToAdd);

					// Change behavior
					Behavior clonedBehavior = (lastReplication) ? source.getBehavior()
							: (Behavior) copier.copy(source.getBehavior());
					clonedBehavior.setEntityName(clonedBehavior.getEntityName() + "_" + instanceNumber);
					clonedBehavior.setId(clonedBehavior.getId() + "_" + instanceNumber);
					if (!lastReplication) {
						clonedSource.setBehavior(clonedBehavior);
						behaviorToAdd.add(clonedBehavior);
					}

					// Modify behavior
					for(var assignment: clonedBehavior.getAssignment()) {
						assignment.setId(assignment.getId() + "_" + instanceNumber);
						if (assignment instanceof Assignment) {
							((Assignment) assignment).getOutputLabels().addAll(functionalityLabelsToAdd);
							((Assignment) assignment).getOutputLabels().add(roleLabel);
						}

						// Set assignments need to also set user data -> add all user labels to it
						if (assignment instanceof SetAssignment) {
							((SetAssignment) assignment).getOutputLabels().addAll(functionalityLabelsToAdd);
							((SetAssignment) assignment).getOutputLabels().add(roleLabel);
						}

					}

					if (!lastReplication) {
						for (Flow flow : flowsFromNode) {
							Flow clonedFlow = (Flow) copier.copy(flow);
							clonedFlow.setId(clonedFlow.getId() + "_" + instanceNumber);
							clonedFlow.setSourceNode(clonedSource);
							clonedFlow.setSourcePin(clonedBehavior.getOutPin().stream()
									.filter(pin -> pin.getId().equals(flow.getSourcePin().getId())).findFirst().get());
							flowsToAdd.add(clonedFlow);
						}
						for (Flow flow : flowsToNode) {
							Flow clonedFlow = (Flow) copier.copy(flow);
							clonedFlow.setId(clonedFlow.getId() + "_" + instanceNumber);
							clonedFlow.setDestinationNode(clonedSource);
							clonedFlow.setDestinationPin(clonedBehavior.getInPin().stream()
									.filter(pin -> pin.getId().equals(flow.getDestinationPin().getId())).findFirst()
									.get());
							flowsToAdd.add(clonedFlow);
						}
					}

					// Set pin names and ID: this is done for the prevention of a bug
					for (var pin : clonedBehavior.getInPin()) {
						pin.setEntityName(pin.getEntityName() + "_" + instanceNumber);
						pin.setId(pin.getId() + "_" + instanceNumber);
					}

					for (var pin : clonedBehavior.getOutPin()) {
						pin.setEntityName(pin.getEntityName() + "_" + instanceNumber);
						pin.setId(pin.getId() + "_" + instanceNumber);
					}

					instanceNumber++;

					// Wires flows, so that they can be seen in the next iteration
					// If this is executed later, some flow's in- or output pins
					// will be null, since EMF does not consider the different copies to be distinct
					// (even if, from a logical perspective, they are)
					copier.copyReferences();
				}

			}
		}

		this.dataDictionary.getBehavior().addAll(behaviorToAdd);
		this.dataFlowDiagram.getNodes().addAll(nodesToAdd);
		this.dataFlowDiagram.getFlows().addAll(flowsToAdd);

		DFDTransposeFlowGraphFinder finder = new DFDTransposeFlowGraphFinder(this.dataDictionary, this.dataFlowDiagram);
		var result = finder.findTransposeFlowGraphs();

		return result;

	}

	protected Set<Set<Functionality>> calculateRoleFunctionalityOptions(Role role) {
		Set<Functionality> required = calculateRequiredFunctionalities(role);

		// Calculate all combinations taking into account optional functionalities
		Set<Set<Functionality>> combinations = new HashSet<>();
		combinations.add(required);
		this.createOptionalCombinations(required, combinations, role.getOptionallyAllows());

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
	protected void createOptionalCombinations(Set<Functionality> startingEntry, Set<Set<Functionality>> existingEntries,
			List<Functionality> allowed) {
		allowed.forEach(addition -> {
			if (!startingEntry.contains(addition) && isCompatible(startingEntry, addition)) {
				Set<Functionality> newCombination = new HashSet<>(startingEntry); // Copy
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
	protected boolean isCompatible(Set<Functionality> set, Functionality addition) {
		for (Functionality exclude : addition.getExcludes()) {
			if (set.contains(exclude))
				return false;
		}
		for (Functionality entry : set) {
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
	protected boolean containsRequired(Set<Functionality> set) {
		for (Functionality entry : set) {
			for (Functionality requriement : entry.getRequires()) {
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
	protected Set<Functionality> calculateRequiredFunctionalities(Role role) {
		Set<Functionality> result = new HashSet<>();

		role.getAlwaysAllows().forEach(func -> {
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
	protected Set<Functionality> getRequired(Functionality functionality) {
		Set<Functionality> result = new HashSet<>();
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
	protected List<Node> getSinkNodes(List<Node> nodes) {
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
	 * Gets a list of nodes that are sources . A node is a source node if it has an
	 * output pin and a role
	 * 
	 * @param nodes A list of all nodes, whose sources should be determined
	 * @return List of source nodes
	 */
	protected List<Node> getSourceNodes(List<Node> nodes) {
		var sourceNodes = nodes.stream().filter(node -> {

			return node.getBehavior().getOutPin().size() > 0 && node.getProperties().stream().filter(label -> {
				if (label instanceof RoleLabel)
					return true;
				return false;
			}).count() > 0;
		}).toList();

		if (sourceNodes.isEmpty())
			throw new IllegalArgumentException("Error, no source nodes could be identified!");

		return sourceNodes;
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

}

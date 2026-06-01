package org.dataflowanalysis.analysis.tests.integration.dfd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.dataflowanalysis.analysis.dfd.DFDDataFlowAnalysisBuilder;
import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.dataflowanalysis.analysis.dfd.resource.DFDModelResourceProvider;
import org.dataflowanalysis.analysis.tests.integration.dfd.util.DFDTestUtil;
import org.dataflowanalysis.dfd.datadictionary.ConditionalForwardingAssignment;
import org.dataflowanalysis.dfd.datadictionary.DataDictionary;
import org.dataflowanalysis.dfd.datadictionary.ForwardingAssignment;
import org.dataflowanalysis.dfd.datadictionary.Label;
import org.dataflowanalysis.dfd.datadictionary.LabelReference;
import org.dataflowanalysis.dfd.datadictionary.LabelType;
import org.dataflowanalysis.dfd.datadictionary.Pin;
import org.dataflowanalysis.dfd.datadictionary.SetAssignment;
import org.dataflowanalysis.dfd.datadictionary.UnsetAssignment;
import org.dataflowanalysis.dfd.datadictionary.datadictionaryFactory;
import org.dataflowanalysis.dfd.dataflowdiagram.DataFlowDiagram;
import org.dataflowanalysis.dfd.dataflowdiagram.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools.mdsd.modelingfoundations.identifier.Entity;

public class AssignmentsTest {
    private DataFlowDiagram dataFlowDiagram;
    private DataDictionary dataDictionary;

    @BeforeEach
    public void init() {
        dataFlowDiagram = DFDTestUtil.createDataFlowDiagram();
        dataDictionary = DFDTestUtil.createDataDictionary();

        LabelType type = datadictionaryFactory.eINSTANCE.createLabelType();
        type.setEntityName("type");
        Label label = datadictionaryFactory.eINSTANCE.createLabel();
        label.setEntityName("value");
        type.getLabel()
                .add(label);
        dataDictionary.getLabelTypes()
                .add(type);
    }

    @Test
    public void testTFGBuildingWithSetAssignments() {
        // Test whether Set Assignment starts TFG of 2 Nodes
        Node a = DFDTestUtil.createNode("a", dataFlowDiagram, dataDictionary);
        Node b = DFDTestUtil.createNode("b", dataFlowDiagram, dataDictionary);

        DFDTestUtil.createFlow(a, b, null, null, "a2b");
        DFDTestUtil.createAndAddLabelTypeAndLabel(dataDictionary, "type", "value");
        DFDTestUtil.createAndAddAssignment(a, null, null, dataDictionary.getLabelTypes()
                .get(0)
                .getLabel(), null, SetAssignment.class);

        var analysis = new DFDDataFlowAnalysisBuilder().standalone()
                .useCustomResourceProvider(new DFDModelResourceProvider(dataDictionary, dataFlowDiagram))
                .build();
        var tfg = analysis.findFlowGraphs();
        tfg.evaluate();

        assertEquals(tfg.getTransposeFlowGraphs()
                .size(), 1);
        assertEquals(tfg.getTransposeFlowGraphs()
                .get(0)
                .getVertices()
                .size(), 2);

        // Test whether new node with set assignments creates unconnected TFG
        Node c = DFDTestUtil.createNode("c", dataFlowDiagram, dataDictionary);
        DFDTestUtil.createFlow(c, a, null, null, "c2a");

        DFDTestUtil.createAndAddAssignment(c, null, null, dataDictionary.getLabelTypes()
                .get(0)
                .getLabel(), null, SetAssignment.class);

        analysis = new DFDDataFlowAnalysisBuilder().standalone()
                .useCustomResourceProvider(new DFDModelResourceProvider(dataDictionary, dataFlowDiagram))
                .build();
        tfg = analysis.findFlowGraphs();
        tfg.evaluate();

        assertEquals(tfg.getTransposeFlowGraphs()
                .size(), 2);

        // Tests whether assignment with input Pins connects the 2 tfgs
        DFDTestUtil.createAndAddAssignment(a, null, null, null, null, ForwardingAssignment.class);

        analysis = new DFDDataFlowAnalysisBuilder().standalone()
                .useCustomResourceProvider(new DFDModelResourceProvider(dataDictionary, dataFlowDiagram))
                .build();
        tfg = analysis.findFlowGraphs();
        tfg.evaluate();

        assertEquals(tfg.getTransposeFlowGraphs()
                .size(), 1);
    }

    @Test
    public void testSetAndUnsetBehavior() {
        // Test whether Set Assignment sets Label
        Node a = DFDTestUtil.createNode("a", dataFlowDiagram, dataDictionary);
        Node b = DFDTestUtil.createNode("b", dataFlowDiagram, dataDictionary);

        DFDTestUtil.createFlow(a, b, null, null, "a2b");
        DFDTestUtil.createAndAddLabelTypeAndLabel(dataDictionary, "type", "value");
        DFDTestUtil.createAndAddAssignment(a, null, null, dataDictionary.getLabelTypes()
                .get(0)
                .getLabel(), null, SetAssignment.class);

        var analysis = new DFDDataFlowAnalysisBuilder().standalone()
                .useCustomResourceProvider(new DFDModelResourceProvider(dataDictionary, dataFlowDiagram))
                .build();
        var tfg = analysis.findFlowGraphs();
        tfg.evaluate();

        tfg.getTransposeFlowGraphs()
                .forEach(fg -> {
                    fg.getVertices()
                            .forEach(vertex -> {
                                if (((Entity) vertex.getReferencedElement()).getEntityName()
                                        .equals("a")) {
                                    assertEquals(getAllCharacteristicValues((DFDVertex) vertex).size(), 1);
                                }
                            });
                });

        // Test whether Unset Assignment removes Label
        DFDTestUtil.createAndAddAssignment(a, null, null, dataDictionary.getLabelTypes()
                .get(0)
                .getLabel(), null, UnsetAssignment.class);

        analysis = new DFDDataFlowAnalysisBuilder().standalone()
                .useCustomResourceProvider(new DFDModelResourceProvider(dataDictionary, dataFlowDiagram))
                .build();
        tfg = analysis.findFlowGraphs();
        tfg.evaluate();

        tfg.getTransposeFlowGraphs()
                .forEach(fg -> {
                    fg.getVertices()
                            .forEach(vertex -> {
                                if (((Entity) vertex.getReferencedElement()).getEntityName()
                                        .equals("a")) {
                                    assertEquals(getAllCharacteristicValues((DFDVertex) vertex).size(), 0);
                                }
                            });
                });

        // Test Whether the same works for other assignments
        UnsetAssignment unsetAssignment = a.getBehavior()
                .getAssignment()
                .stream()
                .filter(UnsetAssignment.class::isInstance)
                .map(UnsetAssignment.class::cast)
                .findAny()
                .orElseThrow();
        a.getBehavior()
                .getAssignment()
                .remove(unsetAssignment);

        Node c = DFDTestUtil.createNode("c", dataFlowDiagram, dataDictionary);
        DFDTestUtil.createFlow(b, c, null, null, "b2c");

        DFDTestUtil.createAndAddAssignment(b, null, null, null, null, ForwardingAssignment.class);

        DFDTestUtil.createAndAddAssignment(b, null, null, dataDictionary.getLabelTypes()
                .get(0)
                .getLabel(), null, UnsetAssignment.class);

        analysis = new DFDDataFlowAnalysisBuilder().standalone()
                .useCustomResourceProvider(new DFDModelResourceProvider(dataDictionary, dataFlowDiagram))
                .build();
        tfg = analysis.findFlowGraphs();
        tfg.evaluate();

        tfg.getTransposeFlowGraphs()
                .forEach(fg -> {
                    fg.getVertices()
                            .forEach(vertex -> {
                                if (((Entity) vertex.getReferencedElement()).getEntityName()
                                        .equals("b")) {
                                    assertEquals(getAllCharacteristicValues((DFDVertex) vertex).size(), 0);
                                }
                            });
                });
    }

    private List<CharacteristicValue> getAllCharacteristicValues(DFDVertex vertex) {
        return vertex.getAllOutgoingDataCharacteristics()
                .stream()
                .flatMap(it -> it.getAllCharacteristics()
                        .stream())
                .collect(Collectors.toList());
    }
    
    @Test
    public void testTFGBuildingWithConditionalForwardAssignment() {
        Node source = DFDTestUtil.createNode("Source", dataFlowDiagram, dataDictionary);
        Node middle = DFDTestUtil.createNode("Middle", dataFlowDiagram, dataDictionary);
        Node sink = DFDTestUtil.createNode("Sink", dataFlowDiagram, dataDictionary);
        
        LabelType type = datadictionaryFactory.eINSTANCE.createLabelType();
        type.setEntityName("type");
        Label forwardingLabel = datadictionaryFactory.eINSTANCE.createLabel();
        forwardingLabel.setEntityName("forwarding");
        type.getLabel()
                .add(forwardingLabel);
        Label conditionLabel = datadictionaryFactory.eINSTANCE.createLabel();
        conditionLabel.setEntityName("condition");
        type.getLabel()
                .add(conditionLabel);
        dataDictionary.getLabelTypes()
                .add(type);

        
        Pin sourceOut = datadictionaryFactory.eINSTANCE.createPin();
        Pin middleIn = datadictionaryFactory.eINSTANCE.createPin();
        Pin middleOut = datadictionaryFactory.eINSTANCE.createPin();
        Pin sinkIn = datadictionaryFactory.eINSTANCE.createPin();
        
        source.getBehavior().getOutPin().add(sourceOut);
        middle.getBehavior().getInPin().add(middleIn);
        middle.getBehavior().getOutPin().add(middleOut);
        sink.getBehavior().getInPin().add(sinkIn);
        
        
        DFDTestUtil.createFlow(source, middle, sourceOut, middleIn, "source_middle");
        DFDTestUtil.createFlow(middle, sink, middleOut, sinkIn, "middle_sink");
        
        DFDTestUtil.createAndAddAssignment(source, null, null, List.of(forwardingLabel), null, SetAssignment.class);
        
        // The middle has a ConditionalForwardingAssignment that only forwards if the "condition" label was received
        ConditionalForwardingAssignment middleCForward = datadictionaryFactory.eINSTANCE.createConditionalForwardingAssignment();
        middleCForward.setEntityName("middleForward");
        middleCForward.getTermInputPins().add(middleIn);
        middleCForward.getInputPins().add(middleIn);
        middleCForward.setOutputPin(middleOut);
        LabelReference middleRequireConditionLabel = datadictionaryFactory.eINSTANCE.createLabelReference();
        middleRequireConditionLabel.setLabel(conditionLabel);
        middleCForward.setTerm(middleRequireConditionLabel);
        middle.getBehavior().getAssignment().add(middleCForward);
        
        var analysis = new DFDDataFlowAnalysisBuilder().standalone()
                .useCustomResourceProvider(new DFDModelResourceProvider(dataDictionary, dataFlowDiagram))
                .build();
        var tfg = analysis.findFlowGraphs();
        tfg.evaluate();
        
        assertEquals(1, tfg.getTransposeFlowGraphs().size());
        
        // Test that the forwarding label did not reach the sink node (condition label was not sent)
        assertEquals(0, tfg.getTransposeFlowGraphs().get(0).getSink().getAllIncomingDataCharacteristics().stream().filter(i -> i.getAllCharacteristics().stream().anyMatch(c -> c.getValueName().equals("forwarding"))).count());
        

        // Condition label is sent
       ((SetAssignment) source.getBehavior().getAssignment().get(0)).getOutputLabels().add(conditionLabel);

        analysis = new DFDDataFlowAnalysisBuilder().standalone()
                .useCustomResourceProvider(new DFDModelResourceProvider(dataDictionary, dataFlowDiagram))
                .build();
        tfg = analysis.findFlowGraphs();
        tfg.evaluate();
        
        // Test that the forwarding label reached the sink node
        assertEquals(1, tfg.getTransposeFlowGraphs().get(0).getSink().getAllIncomingDataCharacteristics().stream().filter(i -> i.getAllCharacteristics().stream().anyMatch(c -> c.getValueName().equals("forwarding"))).count());
    }
    
    /**
     * Tests that the conditional forwarding assignment behaves correctly when the term input and input pins are different
     */
    @Test
    public void testTFGBuildingWithConditionalForwardAssignmentSeparateTermAndInputPins() {
        Node source = DFDTestUtil.createNode("Source", dataFlowDiagram, dataDictionary);
        Node middle = DFDTestUtil.createNode("Middle", dataFlowDiagram, dataDictionary);
        Node sink = DFDTestUtil.createNode("Sink", dataFlowDiagram, dataDictionary);
        
        LabelType type = datadictionaryFactory.eINSTANCE.createLabelType();
        type.setEntityName("type");
        Label forwardingLabel = datadictionaryFactory.eINSTANCE.createLabel();
        forwardingLabel.setEntityName("forwarding");
        type.getLabel()
                .add(forwardingLabel);
        Label conditionLabel = datadictionaryFactory.eINSTANCE.createLabel();
        conditionLabel.setEntityName("condition");
        type.getLabel()
                .add(conditionLabel);
        dataDictionary.getLabelTypes()
                .add(type);

        
        Pin sourceOutForwarding = datadictionaryFactory.eINSTANCE.createPin();
        Pin sourceOutCondition = datadictionaryFactory.eINSTANCE.createPin();
        Pin middleInForwarding = datadictionaryFactory.eINSTANCE.createPin();
        Pin middleInCondition = datadictionaryFactory.eINSTANCE.createPin();
        Pin middleOut = datadictionaryFactory.eINSTANCE.createPin();
        Pin sinkIn = datadictionaryFactory.eINSTANCE.createPin();
        
        source.getBehavior().getOutPin().add(sourceOutForwarding);
        source.getBehavior().getOutPin().add(sourceOutCondition);
        middle.getBehavior().getInPin().add(middleInForwarding);
        middle.getBehavior().getInPin().add(middleInCondition);
        middle.getBehavior().getOutPin().add(middleOut);
        sink.getBehavior().getInPin().add(sinkIn);
        
        
        DFDTestUtil.createFlow(source, middle, sourceOutForwarding, middleInForwarding, "source_middle_forwarding");
        DFDTestUtil.createFlow(source, middle, sourceOutCondition, middleInCondition, "source_middle_condition");
        DFDTestUtil.createFlow(middle, sink, middleOut, sinkIn, "middle_sink");
        
        DFDTestUtil.createAndAddAssignment(source, null, sourceOutForwarding, List.of(forwardingLabel), null, SetAssignment.class);
        
        // The middle has a ConditionalForwardingAssignment that only forwards if the "condition" label was received
        // Source doesn't set it
        ConditionalForwardingAssignment middleCForward = datadictionaryFactory.eINSTANCE.createConditionalForwardingAssignment();
        middleCForward.setEntityName("middleForward");
        middleCForward.getTermInputPins().add(middleInCondition);
        middleCForward.getInputPins().add(middleInForwarding);
        middleCForward.setOutputPin(middleOut);
        LabelReference middleRequireConditionLabel = datadictionaryFactory.eINSTANCE.createLabelReference();
        middleRequireConditionLabel.setLabel(conditionLabel);
        middleCForward.setTerm(middleRequireConditionLabel);
        middle.getBehavior().getAssignment().add(middleCForward);
        
        var analysis = new DFDDataFlowAnalysisBuilder().standalone()
                .useCustomResourceProvider(new DFDModelResourceProvider(dataDictionary, dataFlowDiagram))
                .build();
        var tfg = analysis.findFlowGraphs();
        tfg.evaluate();
        
        assertEquals(1, tfg.getTransposeFlowGraphs().size());
        
        // Test that the forwarding label did not reach the sink node (condition label was not sent)
        assertEquals(0, tfg.getTransposeFlowGraphs().get(0).getSink().getAllIncomingDataCharacteristics().stream().filter(i -> i.getAllCharacteristics().stream().anyMatch(c -> c.getValueName().equals("forwarding"))).count());
        

        // Condition label is sent
        DFDTestUtil.createAndAddAssignment(source, null, sourceOutCondition, List.of(conditionLabel), null, SetAssignment.class);

        analysis = new DFDDataFlowAnalysisBuilder().standalone()
                .useCustomResourceProvider(new DFDModelResourceProvider(dataDictionary, dataFlowDiagram))
                .build();
        tfg = analysis.findFlowGraphs();
        tfg.evaluate();
        
        // Test that the forwarding label did not reach the sink node
        assertEquals(1, tfg.getTransposeFlowGraphs().get(0).getSink().getAllIncomingDataCharacteristics().stream().filter(i -> i.getAllCharacteristics().stream().anyMatch(c -> c.getValueName().equals("forwarding"))).count());
    }
}
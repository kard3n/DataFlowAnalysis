package org.dataflowanalysis.privacy.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.dataflowanalysis.analysis.core.DataCharacteristic;
import org.dataflowanalysis.analysis.dfd.core.DFDCharacteristicValue;
import org.dataflowanalysis.analysis.dfd.core.DFDFlowGraphCollection;
import org.dataflowanalysis.analysis.dfd.core.DFDVertex;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.examplemodels.Activator;
import org.dataflowanalysis.privacy.PrivacyDFDConfidentialityAnalysis;
import org.dataflowanalysis.privacy.PrivacyDFDDataFlowAnalysisBuilder;
import org.dataflowanalysis.privacy.consentmodel.ConsentLabel;
import org.dataflowanalysis.privacy.consentmodel.ConsentLabelType;
import org.dataflowanalysis.privacy.consentmodel.ConsentOption;
import org.dataflowanalysis.privacy.consentmodel.DataItem;
import org.dataflowanalysis.privacy.consentmodel.DataItemLabel;
import org.dataflowanalysis.privacy.consentmodel.DataItemLabelType;
import org.dataflowanalysis.privacy.consentmodel.DataState;
import org.dataflowanalysis.privacy.consentmodel.StatefulItem;
import org.dataflowanalysis.privacy.consentmodel.UserDataCombination;
import org.dataflowanalysis.privacy.consentmodel.consentmodelFactory;
import org.dataflowanalysis.privacy.constraint.PrivacyConstraintViolation;
import org.dataflowanalysis.privacy.constraint.PrivacyDataFlowConstraint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrivacyDataFlowConstrainTest {
	private static final Logger logger = LoggerManager.getLogger(PrivacyDataFlowConstrainTest.class);

	// Data items
	private DataItem dataItemOne;
	private DataItem dataItemTwo;
	private DataItem dataItemThree;
	private DataItem dataItemFour;
	// Data states
	private DataState dataStateOne;
	private DataState dataStateTwo;
	private DataState dataStateThree;
	private DataState dataStateFour;
	// Consent options
	private ConsentOption consentOptionOne;
	private ConsentOption consentOptionTwo;
	private ConsentOption consentOptionThree;
	// Label types
	private DataItemLabelType dataItemLabelType;
	private ConsentLabelType consentLabelType;
	// Item labels
	private DataItemLabel dataItemLabelOne;
	private DataItemLabel dataItemLabelTwo;
	private DataItemLabel dataItemLabelThree;
	private DataItemLabel dataItemLabelFour;
	// Consent labels
	private ConsentLabel consentLabelOne;
	private ConsentLabel consentLabelTwo;
	private ConsentLabel consentLabelThree;

	@BeforeEach
	public void setup() {
		// Data items
		dataItemOne = consentmodelFactory.eINSTANCE.createDataItem();
		dataItemOne.setEntityName("dOne");
		dataItemTwo = consentmodelFactory.eINSTANCE.createDataItem();
		dataItemTwo.setEntityName("dTwo");
		dataItemThree = consentmodelFactory.eINSTANCE.createDataItem();
		dataItemThree.setEntityName("dThree");
		dataItemFour = consentmodelFactory.eINSTANCE.createDataItem();
		dataItemFour.setEntityName("dFour");

		// Data states
		dataStateOne = consentmodelFactory.eINSTANCE.createDataState();
		dataStateOne.setEntityName("sOne");
		dataStateTwo = consentmodelFactory.eINSTANCE.createDataState();
		dataStateTwo.setEntityName("sTwo");
		dataStateThree = consentmodelFactory.eINSTANCE.createDataState();
		dataStateThree.setEntityName("sThree");
		dataStateFour = consentmodelFactory.eINSTANCE.createDataState();
		dataStateFour.setEntityName("sFour");

		// Consent options
		consentOptionOne = consentmodelFactory.eINSTANCE.createConsentOption();
		consentOptionOne.setEntityName("consentOptionOne");
		consentOptionTwo = consentmodelFactory.eINSTANCE.createConsentOption();
		consentOptionTwo.setEntityName("consentOptionTwo");
		consentOptionThree = consentmodelFactory.eINSTANCE.createConsentOption();
		consentOptionThree.setEntityName("consentOptionThree");

		// Label types
		dataItemLabelType = consentmodelFactory.eINSTANCE.createDataItemLabelType();
		dataItemLabelType.setEntityName("DataItemLabelType");
		consentLabelType = consentmodelFactory.eINSTANCE.createConsentLabelType();
		consentLabelType.setEntityName("ConsentLabelType");

		// Item labels
		dataItemLabelOne = consentmodelFactory.eINSTANCE.createDataItemLabel();
		dataItemLabelOne.setEntityName("dataItemLabelOne");
		dataItemLabelOne.setDataItem(dataItemOne);
		dataItemLabelType.getLabels().add(dataItemLabelOne);
		dataItemLabelTwo = consentmodelFactory.eINSTANCE.createDataItemLabel();
		dataItemLabelTwo.setEntityName("dataItemLabelTwo");
		dataItemLabelTwo.setDataItem(dataItemTwo);
		dataItemLabelType.getLabels().add(dataItemLabelTwo);
		dataItemLabelThree = consentmodelFactory.eINSTANCE.createDataItemLabel();
		dataItemLabelThree.setEntityName("dataItemLabelThree");
		dataItemLabelThree.setDataItem(dataItemThree);
		dataItemLabelType.getLabels().add(dataItemLabelThree);
		dataItemLabelFour = consentmodelFactory.eINSTANCE.createDataItemLabel();
		dataItemLabelFour.setEntityName("dataItemLabelFour");
		dataItemLabelFour.setDataItem(dataItemFour);
		dataItemLabelType.getLabels().add(dataItemLabelFour);

		// Consent labels
		consentLabelOne = consentmodelFactory.eINSTANCE.createConsentLabel();
		consentLabelOne.setEntityName("consentLabelOne");
		consentLabelOne.setConsentOption(consentOptionOne);
		consentLabelTwo = consentmodelFactory.eINSTANCE.createConsentLabel();
		consentLabelTwo.setEntityName("consentLabelTwo");
		consentLabelTwo.setConsentOption(consentOptionTwo);
		consentLabelThree = consentmodelFactory.eINSTANCE.createConsentLabel();
		consentLabelThree.setEntityName("consentLabelThree");
		consentLabelThree.setConsentOption(consentOptionThree);

	}

	@Test
	public void testCalculateItemToDataStateCombinations() {
		HashMap<DataItem, List<Set<DataState>>> input = new HashMap<>();
		input.put(dataItemOne, List.of());
		input.put(dataItemTwo, List.of(Set.of(dataStateOne), Set.of(dataStateTwo)));
		input.put(dataItemThree, List.of(Set.of(dataStateTwo), Set.of(dataStateThree)));
		input.put(dataItemFour, List.of(Set.of(dataStateOne)));

		var result = PrivacyDataFlowConstraint.calculateItemToDataStateCombinations(input);
		assertTrue(result.contains(Map.of(dataItemOne, Set.of(), dataItemTwo, Set.of(dataStateOne), dataItemThree,
				Set.of(dataStateTwo), dataItemFour, Set.of(dataStateOne))));
		assertTrue(result.contains(Map.of(dataItemOne, Set.of(), dataItemTwo, Set.of(dataStateOne), dataItemThree,
				Set.of(dataStateThree), dataItemFour, Set.of(dataStateOne))));

		assertTrue(result.contains(Map.of(dataItemOne, Set.of(), dataItemTwo, Set.of(dataStateTwo), dataItemThree,
				Set.of(dataStateTwo), dataItemFour, Set.of(dataStateOne))));
		assertTrue(result.contains(Map.of(dataItemOne, Set.of(), dataItemTwo, Set.of(dataStateTwo), dataItemThree,
				Set.of(dataStateThree), dataItemFour, Set.of(dataStateOne))));

		/*
		 * for (var combination : result) {
		 * logger.warn(combination.entrySet().stream().map(entry -> { return
		 * entry.getKey().getEntityName() + ": " + entry.getValue().stream().map(state
		 * -> state.getEntityName()).toList(); }).toList()); }
		 */
	}

	@Test
	public void testStateSetsCanBeIntersected() {
		// No exclusion, but overlap
		assertTrue(PrivacyDataFlowConstraint.stateSetsCanBeIntersected(Set.of(dataStateOne, dataStateTwo),
				Set.of(dataStateOne, dataStateThree)));

		// No exclusion, but no overlap
		assertTrue(PrivacyDataFlowConstraint.stateSetsCanBeIntersected(Set.of(dataStateOne, dataStateTwo),
				Set.of(dataStateThree, dataStateFour)));

		// One set empty
		assertTrue(PrivacyDataFlowConstraint.stateSetsCanBeIntersected(Set.of(dataStateOne, dataStateTwo), Set.of()));
		assertTrue(PrivacyDataFlowConstraint.stateSetsCanBeIntersected(Set.of(), Set.of(dataStateThree)));

		// both sets empty
		assertTrue(PrivacyDataFlowConstraint.stateSetsCanBeIntersected(Set.of(), Set.of()));

		// have non-empty intersection, each have a data state that can not be related
		// to one from the other to the other
		dataStateOne.getNotRelatableWith().add(dataStateThree);
		dataStateThree.getNotRelatableWith().add(dataStateTwo);
		assertFalse(PrivacyDataFlowConstraint.stateSetsCanBeIntersected(Set.of(dataStateOne, dataStateTwo),
				Set.of(dataStateOne, dataStateThree)));

		// intersection is not empty. only one side has a data state that cannot be
		// related to one of the other
		dataStateThree.getNotRelatableWith().clear();
		assertTrue(PrivacyDataFlowConstraint.stateSetsCanBeIntersected(Set.of(dataStateOne, dataStateTwo),
				Set.of(dataStateOne, dataStateThree)));
		dataStateOne.getNotRelatableWith().clear();
		dataStateThree.getNotRelatableWith().add(dataStateTwo);
		assertTrue(PrivacyDataFlowConstraint.stateSetsCanBeIntersected(Set.of(dataStateOne, dataStateTwo),
				Set.of(dataStateOne, dataStateThree)));
	}

	@Test
	public void testReduceDataStateSets() {
		// Scenario one: reduction can be done immediately for two sets, third does not
		// have an overlap with either (but the data state is relatable to the others)
		List<Set<DataState>> states = List.of(Set.of(dataStateOne, dataStateTwo), Set.of(dataStateTwo, dataStateThree),
				Set.of(dataStateFour));
		assertEquals(List.of(Set.of()), PrivacyDataFlowConstraint.reduceDataStateSets(states));

		// Scenario two: Two sets have an overlap of more than one element
		states = List.of(Set.of(dataStateOne, dataStateTwo), Set.of(dataStateTwo, dataStateOne, dataStateThree));
		assertEquals(List.of(Set.of(dataStateOne, dataStateTwo)),
				PrivacyDataFlowConstraint.reduceDataStateSets(states));

		// Scenario three: there is overlap, but both sets have a data state exclusive
		// to one from the other
		states = List.of(Set.of(dataStateOne, dataStateTwo), Set.of(dataStateTwo, dataStateOne, dataStateThree));
		dataStateThree.getNotRelatableWith().add(dataStateOne);
		dataStateOne.getNotRelatableWith().add(dataStateThree);
		assertEquals(states, PrivacyDataFlowConstraint.reduceDataStateSets(states));

		// Scenario four: two sets have overlap, and initially a data state exclusive to
		// one from the other.
		// A third set can be used to remove one of the states exclusive to the other
		// from one of the sets, making intersection possible
		states = List.of(Set.of(dataStateOne, dataStateTwo), Set.of(dataStateTwo, dataStateOne, dataStateThree),
				Set.of(dataStateTwo, dataStateFour));

		assertEquals(List.of(Set.of(dataStateTwo)), PrivacyDataFlowConstraint.reduceDataStateSets(states));

	}

	@Test
	public void testExtractDataItems() {
		var otherLabelType = consentmodelFactory.eINSTANCE.createConsentLabelType();
		var otherLabel = consentmodelFactory.eINSTANCE.createDataStateLabel();
		var input = List.of(new DFDCharacteristicValue(dataItemLabelType, dataItemLabelOne),
				new DFDCharacteristicValue(otherLabelType, otherLabel),
				new DFDCharacteristicValue(dataItemLabelType, dataItemLabelTwo));

		assertEquals(List.of(dataItemOne, dataItemTwo), PrivacyDataFlowConstraint
				.extractDataItems(input.stream().map(label -> (CharacteristicValue) label).toList()));
	}

	@Test
	public void testAllFunctionalitiesConsentedTo() {
		// Scenario one: all consent options met
		Set<Set<CharacteristicValue>> pinIncoming = Set.of(
				Set.of(new DFDCharacteristicValue(consentLabelType, consentLabelOne),
						new DFDCharacteristicValue(consentLabelType, consentLabelTwo)),
				Set.of(new DFDCharacteristicValue(consentLabelType, consentLabelTwo)));

		HashSet<HashSet<CharacteristicValue>> pinIncomingHashSet = new HashSet<>();
		pinIncoming.forEach(incoming -> {
			pinIncomingHashSet.add(new HashSet<>(incoming));
		});

		var vertexCharacteristicsOne = List
				.of(((CharacteristicValue) new DFDCharacteristicValue(consentLabelType, consentLabelTwo)));

		assertEquals(Set.of(), PrivacyDataFlowConstraint.allFunctionalitiesConsentedTo(pinIncomingHashSet,
				vertexCharacteristicsOne, "testVertex"));

		// Scenario two: one consent option is not met
		var vertexCharacteristicsTwo = List.of(
				((CharacteristicValue) new DFDCharacteristicValue(consentLabelType, consentLabelTwo)),
				((CharacteristicValue) new DFDCharacteristicValue(consentLabelType, consentLabelThree)));

		// One error for each of the sets
		assertEquals(2, PrivacyDataFlowConstraint
				.allFunctionalitiesConsentedTo(pinIncomingHashSet, vertexCharacteristicsTwo, "testVertex").size());
	}

	@Test
	public void testGroupIncomingCharacteristicsByPin() {
		List<DataCharacteristic> incomingCharacteristics = List.of(
				new DataCharacteristic("pinOne",
						List.of(new DFDCharacteristicValue(consentLabelType, consentLabelOne),
								new DFDCharacteristicValue(consentLabelType, consentLabelTwo))),
				new DataCharacteristic("pinOne",
						List.of(new DFDCharacteristicValue(consentLabelType, consentLabelThree))),
				new DataCharacteristic("pinTwo",
						List.of(new DFDCharacteristicValue(consentLabelType, consentLabelThree))));

		HashMap<String, Set<HashSet<CharacteristicValue>>> expectedResult = new HashMap<>();
		expectedResult.put("pinOne", Set.of(new HashSet<>(incomingCharacteristics.get(0).getAllCharacteristics()),
				new HashSet<>(incomingCharacteristics.get(1).getAllCharacteristics())));
		expectedResult.put("pinTwo", Set.of(new HashSet<>(incomingCharacteristics.get(2).getAllCharacteristics())));

		assertEquals(expectedResult,
				PrivacyDataFlowConstraint.groupIncomingCharacteristicsByPin(incomingCharacteristics));
	}

	// TODO test findViolations

	@Test
	public void testCombinationAllowsItem() {
		UserDataCombination combination = consentmodelFactory.eINSTANCE.createUserDataCombination();
		StatefulItem itemOne = consentmodelFactory.eINSTANCE.createStatefulItem();
		itemOne.setItem(dataItemOne);
		itemOne.getState().add(dataStateOne);
		combination.getMembers().add(itemOne);
		// Scenario one: combination allows for the item
		assertTrue(PrivacyDataFlowConstraint.combinationAllowsItem(combination, dataItemOne,
				Set.of(dataStateOne, dataStateTwo)));
		// Scenario two: the passed item doesn't have the required state
		assertFalse(PrivacyDataFlowConstraint.combinationAllowsItem(combination, dataItemOne, Set.of(dataStateTwo)));
		// Scenario three: the passed item lacks one of the required states
		itemOne.getState().add(dataStateTwo);
		assertFalse(PrivacyDataFlowConstraint.combinationAllowsItem(combination, dataItemOne, Set.of(dataStateOne)));
	}

	@Test
	public void testCombinationAllowedByConsentOptionsNoStateNonAllowedItem() {
		// Passed combination (received data)
		HashMap<DataItem, Set<DataState>> dataCombinationOne = new HashMap<>(
				Map.of(dataItemOne, Set.of(), dataItemTwo, Set.of()));
		// Consent combination
		UserDataCombination consentCombination = consentmodelFactory.eINSTANCE.createUserDataCombination();
		StatefulItem itemOne = consentmodelFactory.eINSTANCE.createStatefulItem();
		itemOne.setItem(dataItemOne);
		consentCombination.getMembers().add(itemOne);
		ConsentOption consentOption = consentmodelFactory.eINSTANCE.createConsentOption();
		consentOption.getAllowsFor().add(consentCombination);

		// Scenario one: neither passed combination nor consent option have state.
		// Consent options not allow for dataItemTwo
		assertFalse(PrivacyDataFlowConstraint.combinationAllowedByConsentOptions(dataCombinationOne,
				List.of(consentOption)));

	}

	@Test
	public void testCombinationAllowedByConsentOptionsTwoNoStateItemsAllowed() {
		// Passed combination (received data)
		HashMap<DataItem, Set<DataState>> dataCombinationOne = new HashMap<>(
				Map.of(dataItemOne, Set.of(), dataItemTwo, Set.of()));
		// Consent combination
		UserDataCombination consentCombination = consentmodelFactory.eINSTANCE.createUserDataCombination();
		StatefulItem itemOne = consentmodelFactory.eINSTANCE.createStatefulItem();
		itemOne.setItem(dataItemOne);
		consentCombination.getMembers().add(itemOne);
		ConsentOption consentOption = consentmodelFactory.eINSTANCE.createConsentOption();
		consentOption.getAllowsFor().add(consentCombination);

		// Scenario two: neither passed combination nor consent option have state. Data
		// combination allows for both items
		StatefulItem itemTwo = consentmodelFactory.eINSTANCE.createStatefulItem();
		itemTwo.setItem(dataItemTwo);
		consentCombination.getMembers().add(itemTwo);
		assertTrue(PrivacyDataFlowConstraint.combinationAllowedByConsentOptions(dataCombinationOne,
				List.of(consentOption)));
	}

	@Test
	public void testCombinationAllowedByConsentOptionsStateIncorrect() {
		// Passed combination (received data)
		HashMap<DataItem, Set<DataState>> dataCombinationOne = new HashMap<>(
				Map.of(dataItemOne, Set.of(), dataItemTwo, Set.of()));
		// Consent combination
		UserDataCombination consentCombination = consentmodelFactory.eINSTANCE.createUserDataCombination();
		StatefulItem itemOne = consentmodelFactory.eINSTANCE.createStatefulItem();
		itemOne.setItem(dataItemOne);
		consentCombination.getMembers().add(itemOne);
		ConsentOption consentOption = consentmodelFactory.eINSTANCE.createConsentOption();
		consentOption.getAllowsFor().add(consentCombination);

		StatefulItem itemTwo = consentmodelFactory.eINSTANCE.createStatefulItem();
		itemTwo.setItem(dataItemTwo);
		consentCombination.getMembers().add(itemTwo);

		// Scenario 3: consent option dictates state, passed item has another one
		itemOne.getState().add(dataStateOne);
		assertFalse(PrivacyDataFlowConstraint.combinationAllowedByConsentOptions(dataCombinationOne,
				List.of(consentOption)));
	}

	@Test
	public void testCombinationAllowedByConsentOptionsStateAdditionalButCorrect() {
		// Passed combination (received data)
		HashMap<DataItem, Set<DataState>> dataCombinationOne = new HashMap<>(
				Map.of(dataItemOne, Set.of(), dataItemTwo, Set.of()));
		// Consent combination
		UserDataCombination consentCombination = consentmodelFactory.eINSTANCE.createUserDataCombination();
		StatefulItem itemOne = consentmodelFactory.eINSTANCE.createStatefulItem();
		itemOne.setItem(dataItemOne);
		consentCombination.getMembers().add(itemOne);
		ConsentOption consentOption = consentmodelFactory.eINSTANCE.createConsentOption();
		consentOption.getAllowsFor().add(consentCombination);

		StatefulItem itemTwo = consentmodelFactory.eINSTANCE.createStatefulItem();
		itemTwo.setItem(dataItemTwo);
		consentCombination.getMembers().add(itemTwo);
		itemOne.getState().add(dataStateOne);

		// Scenario 4: passed item has more states than required by the consent option.
		// Consent option requires two states simultaneously
		itemOne.getState().add(dataStateTwo);
		dataCombinationOne.put(dataItemOne, Set.of(dataStateOne, dataStateTwo, dataStateThree));
		assertTrue(PrivacyDataFlowConstraint.combinationAllowedByConsentOptions(dataCombinationOne,
				List.of(consentOption)));
	}

	@Test
	public void testEmptyCombinationAllowedByConsentOptions() {
		// Passed combination (received data)
		HashMap<DataItem, Set<DataState>> dataCombinationOne = new HashMap<>();
		// Consent combination
		UserDataCombination consentCombination = consentmodelFactory.eINSTANCE.createUserDataCombination();
		StatefulItem itemOne = consentmodelFactory.eINSTANCE.createStatefulItem();
		itemOne.setItem(dataItemOne);
		consentCombination.getMembers().add(itemOne);
		ConsentOption consentOption = consentmodelFactory.eINSTANCE.createConsentOption();
		consentOption.getAllowsFor().add(consentCombination);

		// Scenario The passed item combination is empty
		itemOne.getState().add(dataStateTwo);
		dataCombinationOne.put(dataItemOne, Set.of(dataStateOne, dataStateTwo, dataStateThree));
		assertTrue(PrivacyDataFlowConstraint.combinationAllowedByConsentOptions(dataCombinationOne,
				List.of(consentOption)));
	}

	@Test
	public void testFindViolationBasic() {
		final var dataFlowDiagramPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"SimpleSourceSink.dataflowdiagram");
		final var dataDictionaryPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"SimpleSourceSink.datadictionary");
		final var consentModelPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"SimpleSourceSink.consentmodel");

		PrivacyDFDConfidentialityAnalysis analysis = new PrivacyDFDDataFlowAnalysisBuilder().standalone()
				.modelProjectName("org.dataflowanalysis.examplemodels").usePluginActivator(Activator.class)
				.useDataFlowDiagram(dataFlowDiagramPath.toString())
				.useDataDictionary(dataDictionaryPath.toString()).useConsentModel(consentModelPath.toString())
				.build();
		analysis.initializeAnalysis();
		DFDFlowGraphCollection flowGraphCollection = analysis.findFlowGraphs();
		flowGraphCollection.evaluate();

		var result = PrivacyDataFlowConstraint.findViolations(flowGraphCollection, false);
		assertEquals(3, result.size());
		boolean foundCOne = false;
		boolean foundCTwo = false;
		boolean foundCEmpty = false;
		for (var violation : result) {
			logger.debug(violation.message());
			assertEquals("Sink", violation.vertexID());
			if (violation.message().contains("user: [ConsentOptionOne]")) {
				foundCOne = true;
			}
			if (violation.message().contains("user: [ConsentOptionTwo]")) {
				foundCTwo = true;
			}
			if (violation.message().contains("user: []")) {
				foundCEmpty = true;
			}
		}
		assertTrue(foundCOne && foundCTwo && foundCEmpty);
	}
	
	@Test
	public void testMissingAndCorrectDataState() {
		final var dataFlowDiagramPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"BasicDataState.dataflowdiagram");
		final var dataDictionaryPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"BasicDataState.datadictionary");
		final var consentModelPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"BasicDataState.consentmodel");

		PrivacyDFDConfidentialityAnalysis analysis = new PrivacyDFDDataFlowAnalysisBuilder().standalone()
				.modelProjectName("org.dataflowanalysis.examplemodels").usePluginActivator(Activator.class)
				.useDataFlowDiagram(dataFlowDiagramPath.toString())
				.useDataDictionary(dataDictionaryPath.toString()).useConsentModel(consentModelPath.toString())
				.build();
		analysis.initializeAnalysis();
		DFDFlowGraphCollection flowGraphCollection = analysis.findFlowGraphs();
		flowGraphCollection.evaluate();
		
		var result = PrivacyDataFlowConstraint.findViolations(flowGraphCollection, false);
		assertEquals(1, result.size());
		for(var violation: result) {
			assertTrue(violation.message().contains("The vertex has received a data combination in pin _C-ypEBbvEfGwgKscrQsGUg or could infere one not allowed for any of its consent options/functionalities."));
			logger.debug(violation.message());
		}
	}
}

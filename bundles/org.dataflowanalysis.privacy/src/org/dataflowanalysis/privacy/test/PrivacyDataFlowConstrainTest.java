package org.dataflowanalysis.privacy.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
import org.dataflowanalysis.privacy.constraint.PrivacyConstraintViolation;
import org.dataflowanalysis.privacy.constraint.PrivacyDataFlowConstraint;
import org.dataflowanalysis.privacy.constraint.PrivacyDataFlowConstraint.ItemInformation;
import org.dataflowanalysis.privacy.privacymodel.DataContext;
import org.dataflowanalysis.privacy.privacymodel.DataItem;
import org.dataflowanalysis.privacy.privacymodel.DataItemLabel;
import org.dataflowanalysis.privacy.privacymodel.DataItemLabelType;
import org.dataflowanalysis.privacy.privacymodel.DataState;
import org.dataflowanalysis.privacy.privacymodel.Functionality;
import org.dataflowanalysis.privacy.privacymodel.FunctionalityLabel;
import org.dataflowanalysis.privacy.privacymodel.FunctionalityLabelType;
import org.dataflowanalysis.privacy.privacymodel.StatefulItem;
import org.dataflowanalysis.privacy.privacymodel.UserDataCombination;
import org.dataflowanalysis.privacy.privacymodel.privacymodelFactory;
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
	// Data contexts
	private DataContext dataContextOne;
	private DataContext dataContextTwo;
	// Privacy options
	private Functionality privacyOptionOne;
	private Functionality privacyOptionTwo;
	private Functionality privacyOptionThree;
	// Label types
	private DataItemLabelType dataItemLabelType;
	private FunctionalityLabelType privacyLabelType;
	// Item labels
	private DataItemLabel dataItemLabelOne;
	private DataItemLabel dataItemLabelTwo;
	private DataItemLabel dataItemLabelThree;
	private DataItemLabel dataItemLabelFour;
	// Privacy labels
	private FunctionalityLabel privacyLabelOne;
	private FunctionalityLabel privacyLabelTwo;
	private FunctionalityLabel privacyLabelThree;

	@BeforeEach
	public void setup() {
		// Data items
		dataItemOne = privacymodelFactory.eINSTANCE.createDataItem();
		dataItemOne.setEntityName("dOne");
		dataItemTwo = privacymodelFactory.eINSTANCE.createDataItem();
		dataItemTwo.setEntityName("dTwo");
		dataItemThree = privacymodelFactory.eINSTANCE.createDataItem();
		dataItemThree.setEntityName("dThree");
		dataItemFour = privacymodelFactory.eINSTANCE.createDataItem();
		dataItemFour.setEntityName("dFour");

		// Data states
		dataStateOne = privacymodelFactory.eINSTANCE.createDataState();
		dataStateOne.setEntityName("sOne");
		dataStateTwo = privacymodelFactory.eINSTANCE.createDataState();
		dataStateTwo.setEntityName("sTwo");
		dataStateThree = privacymodelFactory.eINSTANCE.createDataState();
		dataStateThree.setEntityName("sThree");
		dataStateFour = privacymodelFactory.eINSTANCE.createDataState();
		dataStateFour.setEntityName("sFour");

		// Data context
		dataContextOne = privacymodelFactory.eINSTANCE.createDataContext();
		dataContextOne.setEntityName("cOne");
		dataContextTwo = privacymodelFactory.eINSTANCE.createDataContext();
		dataContextTwo.setEntityName("cTwo");

		// Privacy options
		privacyOptionOne = privacymodelFactory.eINSTANCE.createFunctionality();
		privacyOptionOne.setEntityName("privacyOptionOne");
		privacyOptionTwo = privacymodelFactory.eINSTANCE.createFunctionality();
		privacyOptionTwo.setEntityName("privacyOptionTwo");
		privacyOptionThree = privacymodelFactory.eINSTANCE.createFunctionality();
		privacyOptionThree.setEntityName("privacyOptionThree");

		// Label types
		dataItemLabelType = privacymodelFactory.eINSTANCE.createDataItemLabelType();
		dataItemLabelType.setEntityName("DataItemLabelType");
		privacyLabelType = privacymodelFactory.eINSTANCE.createFunctionalityLabelType();
		privacyLabelType.setEntityName("PrivacyLabelType");

		// Item labels
		dataItemLabelOne = privacymodelFactory.eINSTANCE.createDataItemLabel();
		dataItemLabelOne.setEntityName("dataItemLabelOne");
		dataItemLabelOne.setDataItem(dataItemOne);
		dataItemLabelType.getLabels().add(dataItemLabelOne);
		dataItemLabelTwo = privacymodelFactory.eINSTANCE.createDataItemLabel();
		dataItemLabelTwo.setEntityName("dataItemLabelTwo");
		dataItemLabelTwo.setDataItem(dataItemTwo);
		dataItemLabelType.getLabels().add(dataItemLabelTwo);
		dataItemLabelThree = privacymodelFactory.eINSTANCE.createDataItemLabel();
		dataItemLabelThree.setEntityName("dataItemLabelThree");
		dataItemLabelThree.setDataItem(dataItemThree);
		dataItemLabelType.getLabels().add(dataItemLabelThree);
		dataItemLabelFour = privacymodelFactory.eINSTANCE.createDataItemLabel();
		dataItemLabelFour.setEntityName("dataItemLabelFour");
		dataItemLabelFour.setDataItem(dataItemFour);
		dataItemLabelType.getLabels().add(dataItemLabelFour);

		// Privacy labels
		privacyLabelOne = privacymodelFactory.eINSTANCE.createFunctionalityLabel();
		privacyLabelOne.setEntityName("privacyLabelOne");
		privacyLabelOne.setFunctionality(privacyOptionOne);
		privacyLabelTwo = privacymodelFactory.eINSTANCE.createFunctionalityLabel();
		privacyLabelTwo.setEntityName("privacyLabelTwo");
		privacyLabelTwo.setFunctionality(privacyOptionTwo);
		privacyLabelThree = privacymodelFactory.eINSTANCE.createFunctionalityLabel();
		privacyLabelThree.setEntityName("privacyLabelThree");
		privacyLabelThree.setFunctionality(privacyOptionThree);

	}

	@Test
	public void testCalculateItemToDataStateCombinations() {
		HashMap<DataItem, List<ItemInformation>> input = new HashMap<>();
		input.put(dataItemOne, List.of());
		input.put(dataItemTwo, List.of(new ItemInformation(Set.of(dataStateOne), Set.of()),
				new ItemInformation(Set.of(dataStateTwo), Set.of())));
		input.put(dataItemThree, List.of(new ItemInformation(Set.of(dataStateTwo), Set.of()),
				new ItemInformation(Set.of(dataStateThree), Set.of())));
		input.put(dataItemFour, List.of(new ItemInformation(Set.of(dataStateOne), Set.of())));

		var result = PrivacyDataFlowConstraint.calculateItemToDataStateCombinations(input);
		assertTrue(result.contains(Map.of(dataItemOne, new ItemInformation(Set.of(), Set.of()), dataItemTwo,
				new ItemInformation(Set.of(dataStateOne), Set.of()), dataItemThree,
				new ItemInformation(Set.of(dataStateTwo), Set.of()), dataItemFour,
				new ItemInformation(Set.of(dataStateOne), Set.of()))));
		assertTrue(result.contains(Map.of(dataItemOne, new ItemInformation(Set.of(), Set.of()), dataItemTwo,
				new ItemInformation(Set.of(dataStateOne), Set.of()), dataItemThree,
				new ItemInformation(Set.of(dataStateThree), Set.of()), dataItemFour,
				new ItemInformation(Set.of(dataStateOne), Set.of()))));

		assertTrue(result.contains(Map.of(dataItemOne, new ItemInformation(Set.of(), Set.of()), dataItemTwo,
				new ItemInformation(Set.of(dataStateTwo), Set.of()), dataItemThree,
				new ItemInformation(Set.of(dataStateTwo), Set.of()), dataItemFour,
				new ItemInformation(Set.of(dataStateOne), Set.of()))));
		assertTrue(result.contains(Map.of(dataItemOne, new ItemInformation(Set.of(), Set.of()), dataItemTwo,
				new ItemInformation(Set.of(dataStateTwo), Set.of()), dataItemThree,
				new ItemInformation(Set.of(dataStateThree), Set.of()), dataItemFour,
				new ItemInformation(Set.of(dataStateOne), Set.of()))));

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
		List<ItemInformation> states = List.of(new ItemInformation(Set.of(dataStateOne, dataStateTwo), Set.of()),
				new ItemInformation(Set.of(dataStateTwo, dataStateThree), Set.of()),
				new ItemInformation(Set.of(dataStateFour), Set.of()));
		assertEquals(List.of(new ItemInformation(Set.of(), Set.of())),
				PrivacyDataFlowConstraint.reduceDataStateSets(states));

		// Scenario two: Two sets have an overlap of more than one element
		states = List.of(new ItemInformation(Set.of(dataStateOne, dataStateTwo), Set.of()),
				new ItemInformation(Set.of(dataStateTwo, dataStateOne, dataStateThree), Set.of()));
		assertEquals(List.of(new ItemInformation(Set.of(dataStateOne, dataStateTwo), Set.of())),
				PrivacyDataFlowConstraint.reduceDataStateSets(states));

		// Scenario three: there is overlap, but both sets have a data state exclusive
		// to one from the other
		states = List.of(new ItemInformation(Set.of(dataStateOne, dataStateTwo), Set.of()),
				new ItemInformation(Set.of(dataStateTwo, dataStateOne, dataStateThree), Set.of()));
		dataStateThree.getNotRelatableWith().add(dataStateOne);
		dataStateOne.getNotRelatableWith().add(dataStateThree);
		assertEquals(states, PrivacyDataFlowConstraint.reduceDataStateSets(states));

		// Scenario four: two sets have overlap, and initially a data state exclusive to
		// one from the other.
		// A third set can be used to remove one of the states exclusive to the other
		// from one of the sets, making intersection possible
		states = List.of(new ItemInformation(Set.of(dataStateOne, dataStateTwo), Set.of()),
				new ItemInformation(Set.of(dataStateTwo, dataStateOne, dataStateThree), Set.of()),
				new ItemInformation(Set.of(dataStateTwo, dataStateFour), Set.of()));

		assertEquals(List.of(new ItemInformation(Set.of(dataStateTwo), Set.of())),
				PrivacyDataFlowConstraint.reduceDataStateSets(states));

	}

	@Test
	public void testExtractDataItems() {
		var otherLabelType = privacymodelFactory.eINSTANCE.createFunctionalityLabelType();
		var otherLabel = privacymodelFactory.eINSTANCE.createDataStateLabel();
		var input = List.of(new DFDCharacteristicValue(dataItemLabelType, dataItemLabelOne),
				new DFDCharacteristicValue(otherLabelType, otherLabel),
				new DFDCharacteristicValue(dataItemLabelType, dataItemLabelTwo));

		assertEquals(List.of(dataItemOne, dataItemTwo), PrivacyDataFlowConstraint
				.extractDataItems(input.stream().map(label -> (CharacteristicValue) label).toList()));
	}

	@Test
	public void testAllFunctionalitiesPrivacyedTo() {
		// Scenario one: all privacy options met
		Set<Set<CharacteristicValue>> pinIncoming = Set.of(
				Set.of(new DFDCharacteristicValue(privacyLabelType, privacyLabelOne),
						new DFDCharacteristicValue(privacyLabelType, privacyLabelTwo),
						new DFDCharacteristicValue(this.dataItemLabelType, this.dataItemLabelOne)),
				Set.of(new DFDCharacteristicValue(privacyLabelType, privacyLabelTwo),
						new DFDCharacteristicValue(this.dataItemLabelType, this.dataItemLabelOne)));

		var vertexCharacteristicsOne = List.of(privacyLabelTwo);

		pinIncoming.forEach(incoming -> {
			assertEquals(true, PrivacyDataFlowConstraint.allFunctionalitiesConsentedTo(new HashSet<>(incoming),
					vertexCharacteristicsOne, "testVertex"));
		});

		// Scenario two: one privacy option is not met
		var vertexCharacteristicsTwo = List.of(privacyLabelTwo, privacyLabelThree);

		int detectedViolations = 0;
		for (var incoming : pinIncoming) {
			if (!PrivacyDataFlowConstraint.allFunctionalitiesConsentedTo(new HashSet<>(incoming),
					vertexCharacteristicsTwo, "testVertex")) {
				detectedViolations++;
			}
		}
		;
		assertEquals(2, detectedViolations);

	}

	@Test
	public void testGroupIncomingCharacteristicsByPin() {
		List<DataCharacteristic> incomingCharacteristics = List.of(
				new DataCharacteristic("pinOne",
						List.of(new DFDCharacteristicValue(privacyLabelType, privacyLabelOne),
								new DFDCharacteristicValue(privacyLabelType, privacyLabelTwo))),
				new DataCharacteristic("pinTwo",
						List.of(new DFDCharacteristicValue(privacyLabelType, privacyLabelThree))),
				new DataCharacteristic("pinThree",
						List.of(new DFDCharacteristicValue(privacyLabelType, privacyLabelThree))));

		HashMap<String, HashSet<CharacteristicValue>> expectedResult = new HashMap<>();
		expectedResult.put("pinOne", new HashSet<>(incomingCharacteristics.get(0).getAllCharacteristics()));
		expectedResult.put("pinTwo", new HashSet<>(incomingCharacteristics.get(1).getAllCharacteristics()));
		expectedResult.put("pinThree", new HashSet<>(incomingCharacteristics.get(2).getAllCharacteristics()));

		assertEquals(expectedResult,
				PrivacyDataFlowConstraint.groupIncomingCharacteristicsByPin(incomingCharacteristics));
	}

	@Test
	public void testCombinationAllowsItem() {
		UserDataCombination combination = privacymodelFactory.eINSTANCE.createUserDataCombination();
		StatefulItem itemOne = privacymodelFactory.eINSTANCE.createStatefulItem();
		itemOne.setItem(dataItemOne);
		itemOne.getState().add(dataStateOne);
		combination.getMembers().add(itemOne);
		// Scenario one: combination allows for the item
		assertTrue(PrivacyDataFlowConstraint.combinationAllowsItem(combination, dataItemOne,
				new ItemInformation(Set.of(dataStateOne, dataStateTwo), Set.of())));
		// Scenario two: the passed item doesn't have the required state
		assertFalse(PrivacyDataFlowConstraint.combinationAllowsItem(combination, dataItemOne,
				new ItemInformation(Set.of(dataStateTwo), Set.of())));
		// Scenario three: the passed item lacks one of the required states
		itemOne.getState().add(dataStateTwo);
		assertFalse(PrivacyDataFlowConstraint.combinationAllowsItem(combination, dataItemOne,
				new ItemInformation(Set.of(dataStateOne), Set.of())));
	}

	@Test
	public void testCombinationAllowsItemWithContext() {
		UserDataCombination combination = privacymodelFactory.eINSTANCE.createUserDataCombination();
		StatefulItem itemOne = privacymodelFactory.eINSTANCE.createStatefulItem();
		itemOne.setItem(dataItemOne);
		itemOne.getState().add(dataStateOne);
		itemOne.getContext().add(dataContextOne);
		combination.getMembers().add(itemOne);
		// Scenario one: combination allows for the item
		assertTrue(PrivacyDataFlowConstraint.combinationAllowsItem(combination, dataItemOne,
				new ItemInformation(Set.of(dataStateOne), Set.of(Set.of(dataContextOne)))));
		// Scenario two: the passed item doesn't have the required context
		assertFalse(PrivacyDataFlowConstraint.combinationAllowsItem(combination, dataItemOne,
				new ItemInformation(Set.of(dataStateOne), Set.of(Set.of(dataContextTwo)))));
		// Scenario three: the passed item does not have any context
		assertFalse(PrivacyDataFlowConstraint.combinationAllowsItem(combination, dataItemOne,
				new ItemInformation(Set.of(dataStateOne), Set.of())));
		assertFalse(PrivacyDataFlowConstraint.combinationAllowsItem(combination, dataItemOne,
				new ItemInformation(Set.of(dataStateOne), Set.of(Set.of()))));

	}

	@Test
	public void testCombinationAllowsItemWithContextMultiple() {
		UserDataCombination combination = privacymodelFactory.eINSTANCE.createUserDataCombination();
		StatefulItem itemOne = privacymodelFactory.eINSTANCE.createStatefulItem();
		itemOne.setItem(dataItemOne);
		itemOne.getState().add(dataStateOne);
		itemOne.getContext().add(dataContextOne);
		combination.getMembers().add(itemOne);

		StatefulItem itemTwo = privacymodelFactory.eINSTANCE.createStatefulItem();
		itemTwo.setItem(dataItemOne);
		itemTwo.getState().add(dataStateOne);
		itemTwo.getContext().add(dataContextTwo);
		combination.getMembers().add(itemTwo);
		// Scenario one: combination allows for the item
		assertTrue(PrivacyDataFlowConstraint.combinationAllowsItem(combination, dataItemOne,
				new ItemInformation(Set.of(dataStateOne), Set.of(Set.of(dataContextOne), Set.of(dataContextTwo)))));
		// Scenario two: no item has the correct context
		assertFalse(PrivacyDataFlowConstraint.combinationAllowsItem(combination, dataItemOne,
				new ItemInformation(Set.of(dataStateOne), Set.of(Set.of(dataContextOne, dataContextTwo)))));

	}

	@Test
	public void testCombinationAllowedByPrivacyOptionsNoStateNonAllowedItem() {
		// Passed combination (received data)
		HashMap<DataItem, ItemInformation> dataCombinationOne = new HashMap<>(Map.of(dataItemOne,
				new ItemInformation(Set.of(), Set.of()), dataItemTwo, new ItemInformation(Set.of(), Set.of())));
		// Privacy combination
		UserDataCombination privacyCombination = privacymodelFactory.eINSTANCE.createUserDataCombination();
		StatefulItem itemOne = privacymodelFactory.eINSTANCE.createStatefulItem();
		itemOne.setItem(dataItemOne);
		privacyCombination.getMembers().add(itemOne);
		Functionality privacyOption = privacymodelFactory.eINSTANCE.createFunctionality();
		privacyOption.getAllowsFor().add(privacyCombination);

		// Scenario one: neither passed combination nor privacy option have state.
		// Privacy options not allow for dataItemTwo
		assertFalse(PrivacyDataFlowConstraint.combinationAllowedByFunctionalities(dataCombinationOne,
				List.of(privacyOption)));

	}

	@Test
	public void testCombinationAllowedByPrivacyOptionsTwoNoStateItemsAllowed() {
		// Passed combination (received data)
		HashMap<DataItem, ItemInformation> dataCombinationOne = new HashMap<>(Map.of(dataItemOne,
				new ItemInformation(Set.of(), Set.of()), dataItemTwo, new ItemInformation(Set.of(), Set.of())));
		// Privacy combination
		UserDataCombination privacyCombination = privacymodelFactory.eINSTANCE.createUserDataCombination();
		StatefulItem itemOne = privacymodelFactory.eINSTANCE.createStatefulItem();
		itemOne.setItem(dataItemOne);
		privacyCombination.getMembers().add(itemOne);
		Functionality privacyOption = privacymodelFactory.eINSTANCE.createFunctionality();
		privacyOption.getAllowsFor().add(privacyCombination);

		// Scenario two: neither passed combination nor privacy option have state. Data
		// combination allows for both items
		StatefulItem itemTwo = privacymodelFactory.eINSTANCE.createStatefulItem();
		itemTwo.setItem(dataItemTwo);
		privacyCombination.getMembers().add(itemTwo);
		assertTrue(PrivacyDataFlowConstraint.combinationAllowedByFunctionalities(dataCombinationOne,
				List.of(privacyOption)));
	}

	@Test
	public void testCombinationAllowedByPrivacyOptionsStateIncorrect() {
		// Passed combination (received data)
		HashMap<DataItem, ItemInformation> dataCombinationOne = new HashMap<>(Map.of(dataItemOne,
				new ItemInformation(Set.of(), Set.of()), dataItemTwo, new ItemInformation(Set.of(), Set.of())));
		// Privacy combination
		UserDataCombination privacyCombination = privacymodelFactory.eINSTANCE.createUserDataCombination();
		StatefulItem itemOne = privacymodelFactory.eINSTANCE.createStatefulItem();
		itemOne.setItem(dataItemOne);
		privacyCombination.getMembers().add(itemOne);
		Functionality privacyOption = privacymodelFactory.eINSTANCE.createFunctionality();
		privacyOption.getAllowsFor().add(privacyCombination);

		StatefulItem itemTwo = privacymodelFactory.eINSTANCE.createStatefulItem();
		itemTwo.setItem(dataItemTwo);
		privacyCombination.getMembers().add(itemTwo);

		// Scenario 3: privacy option dictates state, passed item has another one
		itemOne.getState().add(dataStateOne);
		assertFalse(PrivacyDataFlowConstraint.combinationAllowedByFunctionalities(dataCombinationOne,
				List.of(privacyOption)));
	}

	@Test
	public void testCombinationAllowedByPrivacyOptionsStateAdditionalButCorrect() {
		// Passed combination (received data)
		HashMap<DataItem, ItemInformation> dataCombinationOne = new HashMap<>(Map.of(dataItemOne,
				new ItemInformation(Set.of(), Set.of()), dataItemTwo, new ItemInformation(Set.of(), Set.of())));
		// Privacy combination
		UserDataCombination privacyCombination = privacymodelFactory.eINSTANCE.createUserDataCombination();
		StatefulItem itemOne = privacymodelFactory.eINSTANCE.createStatefulItem();
		itemOne.setItem(dataItemOne);
		privacyCombination.getMembers().add(itemOne);
		Functionality privacyOption = privacymodelFactory.eINSTANCE.createFunctionality();
		privacyOption.getAllowsFor().add(privacyCombination);

		StatefulItem itemTwo = privacymodelFactory.eINSTANCE.createStatefulItem();
		itemTwo.setItem(dataItemTwo);
		privacyCombination.getMembers().add(itemTwo);
		itemOne.getState().add(dataStateOne);

		// Scenario 4: passed item has more states than required by the privacy option.
		// Privacy option requires two states simultaneously
		itemOne.getState().add(dataStateTwo);
		dataCombinationOne.put(dataItemOne,
				new ItemInformation(Set.of(dataStateOne, dataStateTwo, dataStateThree), Set.of()));
		assertTrue(PrivacyDataFlowConstraint.combinationAllowedByFunctionalities(dataCombinationOne,
				List.of(privacyOption)));
	}

	@Test
	public void testEmptyCombinationAllowedByPrivacyOptions() {
		// Passed combination (received data)
		HashMap<DataItem, ItemInformation> dataCombinationOne = new HashMap<>();
		// Privacy combination
		UserDataCombination privacyCombination = privacymodelFactory.eINSTANCE.createUserDataCombination();
		StatefulItem itemOne = privacymodelFactory.eINSTANCE.createStatefulItem();
		itemOne.setItem(dataItemOne);
		privacyCombination.getMembers().add(itemOne);
		Functionality privacyOption = privacymodelFactory.eINSTANCE.createFunctionality();
		privacyOption.getAllowsFor().add(privacyCombination);

		// Scenario The passed item combination is empty
		itemOne.getState().add(dataStateTwo);
		dataCombinationOne.put(dataItemOne,
				new ItemInformation(Set.of(dataStateOne, dataStateTwo, dataStateThree), Set.of()));
		assertTrue(PrivacyDataFlowConstraint.combinationAllowedByFunctionalities(dataCombinationOne,
				List.of(privacyOption)));
	}

	@Test
	public void testPinLevelFindViolationBasic() {
		final var dataFlowDiagramPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"SimpleSourceSink.dataflowdiagram");
		final var dataDictionaryPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"SimpleSourceSink.datadictionary");
		final var privacyModelPath = Paths.get("models", "dfd", "PrivacyTestModels", "SimpleSourceSink.privacymodel");

		PrivacyDFDConfidentialityAnalysis analysis = new PrivacyDFDDataFlowAnalysisBuilder().standalone()
				.modelProjectName("org.dataflowanalysis.examplemodels").usePluginActivator(Activator.class)
				.useDataFlowDiagram(dataFlowDiagramPath.toString()).useDataDictionary(dataDictionaryPath.toString())
				.usePrivacyModel(privacyModelPath.toString()).build();
		analysis.initializeAnalysis();
		DFDFlowGraphCollection flowGraphCollection = analysis.findFlowGraphs();
		flowGraphCollection.evaluate();

		var result = PrivacyDataFlowConstraint.findViolations(flowGraphCollection, false, false);

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
	public void testPinLevelMissingAndCorrectDataState() {
		final var dataFlowDiagramPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"BasicDataState.dataflowdiagram");
		final var dataDictionaryPath = Paths.get("models", "dfd", "PrivacyTestModels", "BasicDataState.datadictionary");
		final var privacyModelPath = Paths.get("models", "dfd", "PrivacyTestModels", "BasicDataState.privacymodel");

		PrivacyDFDConfidentialityAnalysis analysis = new PrivacyDFDDataFlowAnalysisBuilder().standalone()
				.modelProjectName("org.dataflowanalysis.examplemodels").usePluginActivator(Activator.class)
				.useDataFlowDiagram(dataFlowDiagramPath.toString()).useDataDictionary(dataDictionaryPath.toString())
				.usePrivacyModel(privacyModelPath.toString()).build();
		analysis.initializeAnalysis();
		DFDFlowGraphCollection flowGraphCollection = analysis.findFlowGraphs();
		flowGraphCollection.evaluate();

		var result = PrivacyDataFlowConstraint.findViolations(flowGraphCollection, false, false);
		assertEquals(1, result.size());
		for (var violation : result) {
			assertTrue(violation.message().contains(
					"received a data combination in pin _C-ypEBbvEfGwgKscrQsGUg or could infere one not allowed for any of its functionalities."));
			logger.debug(violation.message());
		}
	}

	@Test
	public void testPinLevelInference() {
		final var dataFlowDiagramPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"PinLevelInference.dataflowdiagram");
		final var dataDictionaryPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"PinLevelInference.datadictionary");
		final var privacyModelPath = Paths.get("models", "dfd", "PrivacyTestModels", "PinLevelInference.privacymodel");

		PrivacyDFDConfidentialityAnalysis analysis = new PrivacyDFDDataFlowAnalysisBuilder().standalone()
				.modelProjectName("org.dataflowanalysis.examplemodels").usePluginActivator(Activator.class)
				.useDataFlowDiagram(dataFlowDiagramPath.toString()).useDataDictionary(dataDictionaryPath.toString())
				.usePrivacyModel(privacyModelPath.toString()).build();
		analysis.initializeAnalysis();
		DFDFlowGraphCollection flowGraphCollection = analysis.findFlowGraphs();
		flowGraphCollection.evaluate();

		var result = PrivacyDataFlowConstraint.findViolations(flowGraphCollection, false, false);
		assertEquals(1, result.size());
		for (var violation : result) {
			logger.debug(violation.message());
			assertTrue(violation.message().contains(
					"has received a data combination in pin _MYqLYBcDEfGz3ruJdcnl1A or could infere one not allowed for any of its functionalities."));
			assertTrue(violation.message().contains("[DataItemOne: {state: {[]}, context: {[[]]}}]")); // State has been
																										// reduced to
																										// the empty set
		}
	}

	@Test
	public void testUniteItemTuples() {
		Map<DataItem, ItemInformation> mapOne = new HashMap<>(
				Map.of(this.dataItemOne, new ItemInformation(new HashSet<>(), new HashSet<>()), this.dataItemTwo,
						new ItemInformation(new HashSet<>(), new HashSet<>())));
		Map<DataItem, ItemInformation> mapTwo = new HashMap<>(
				Map.of(this.dataItemTwo, new ItemInformation(new HashSet<>(), new HashSet<>()), this.dataItemThree,
						new ItemInformation(new HashSet<>(), new HashSet<>())));

		logger.debug("Result: "
				+ PrivacyDataFlowConstraint.uniteItemTuples(List.of(new HashMap<>(mapOne), new HashMap<>(mapTwo)))
						.get(0).keySet().stream().map(item -> item.getEntityName()).toList());
		// Scenario one: no state
		assertEquals(List.of(Map.of(this.dataItemOne, new ItemInformation(Set.of(), Set.of()), this.dataItemTwo,
				new ItemInformation(Set.of(), Set.of()), this.dataItemThree, new ItemInformation(Set.of(), Set.of()))),
				PrivacyDataFlowConstraint.uniteItemTuples(List.of(new HashMap<>(mapOne), new HashMap<>(mapTwo))));

		// Scenario two: state, but no incompatibilities
		mapOne.get(this.dataItemTwo).state().add(this.dataStateOne);
		mapOne.get(this.dataItemTwo).state().add(this.dataStateTwo);
		mapTwo.get(this.dataItemTwo).state().add(this.dataStateOne);
		mapTwo.get(this.dataItemTwo).state().add(this.dataStateThree);

		assertEquals(
				List.of(Map.of(this.dataItemOne, new ItemInformation(Set.of(), Set.of()), this.dataItemTwo,
						new ItemInformation(Set.of(this.dataStateOne), Set.of()), this.dataItemThree,
						new ItemInformation(Set.of(), Set.of()))),
				PrivacyDataFlowConstraint.uniteItemTuples(List.of(new HashMap<>(mapOne), new HashMap<>(mapTwo))));

		// Scenario three: non-relatability resulting in the initial two sets, as the
		// intersection is wholly unrelatable

		this.dataStateTwo.getNotRelatableWith().add(dataStateThree);
		this.dataStateThree.getNotRelatableWith().add(dataStateTwo);

		assertEquals(List.of(new HashMap<>(mapOne), new HashMap<>(mapTwo)),
				PrivacyDataFlowConstraint.uniteItemTuples(List.of(new HashMap<>(mapOne), new HashMap<>(mapTwo))));

		// Scenario four: non-relatability resulting in two sets, intersection has a
		// relatable part
		mapOne.put(dataItemFour, new ItemInformation(new HashSet<>(), new HashSet<>()));
		mapTwo.put(dataItemFour, new ItemInformation(new HashSet<>(), new HashSet<>()));

		assertEquals(List.of(Map.of(this.dataItemOne, new ItemInformation(Set.of(), Set.of()), this.dataItemTwo,
				new ItemInformation(Set.of(this.dataStateOne, this.dataStateTwo), Set.of()), this.dataItemThree,
				new ItemInformation(Set.of(), Set.of()), this.dataItemFour, new ItemInformation(Set.of(), Set.of())),
				Map.of(this.dataItemOne, new ItemInformation(Set.of(), Set.of()), this.dataItemTwo,
						new ItemInformation(Set.of(this.dataStateOne, this.dataStateThree), Set.of()),
						this.dataItemThree, new ItemInformation(Set.of(), Set.of()), this.dataItemFour,
						new ItemInformation(Set.of(), Set.of()))),
				PrivacyDataFlowConstraint.uniteItemTuples(List.of(new HashMap<>(mapOne), new HashMap<>(mapTwo))));

	}

	@Test
	public void testNodeInferenceStateFree() {
		// NodeInferenceStateFree
		final var dataFlowDiagramPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"NodeInferenceStateFree.dataflowdiagram");
		final var dataDictionaryPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"NodeInferenceStateFree.datadictionary");
		final var privacyModelPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"NodeInferenceStateFree.privacymodel");

		PrivacyDFDConfidentialityAnalysis analysis = new PrivacyDFDDataFlowAnalysisBuilder().standalone()
				.modelProjectName("org.dataflowanalysis.examplemodels").usePluginActivator(Activator.class)
				.useDataFlowDiagram(dataFlowDiagramPath.toString()).useDataDictionary(dataDictionaryPath.toString())
				.usePrivacyModel(privacyModelPath.toString()).build();
		analysis.initializeAnalysis();
		DFDFlowGraphCollection flowGraphCollection = analysis.findFlowGraphs();
		flowGraphCollection.evaluate();

		var violations = PrivacyDataFlowConstraint.findViolations(flowGraphCollection, true, false);
		assertEquals(1, violations.size());
		for (var violation : violations) {
			assertTrue(violation.message().contains("information not authorized by its functionalities."));
		}
	}

	@Test
	public void testNodeInferenceStateful() {
		// NodeInferenceStateFree
		final var dataFlowDiagramPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"NodeInferenceStateful.dataflowdiagram");
		final var dataDictionaryPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"NodeInferenceStateful.datadictionary");
		final var privacyModelPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"NodeInferenceStateful.privacymodel");

		PrivacyDFDConfidentialityAnalysis analysis = new PrivacyDFDDataFlowAnalysisBuilder().standalone()
				.modelProjectName("org.dataflowanalysis.examplemodels").usePluginActivator(Activator.class)
				.useDataFlowDiagram(dataFlowDiagramPath.toString()).useDataDictionary(dataDictionaryPath.toString())
				.usePrivacyModel(privacyModelPath.toString()).build();
		analysis.initializeAnalysis();
		DFDFlowGraphCollection flowGraphCollection = analysis.findFlowGraphs();
		flowGraphCollection.evaluate();

		var violations = PrivacyDataFlowConstraint.findViolations(flowGraphCollection, true, false);
		assertEquals(1, violations.size());
		for (var violation : violations) {
			assertTrue(violation.message().contains("information not authorized by its functionalities."));
			assertTrue(violation.message().contains("ItemTwo: {state: {[]}"));
		}
	}

	@Test
	public void testUserNodeLogic() {
		// UserNodeTest
		final var dataFlowDiagramPath = Paths.get("models", "dfd", "PrivacyTestModels", "UserNodeTest.dataflowdiagram");
		final var dataDictionaryPath = Paths.get("models", "dfd", "PrivacyTestModels", "UserNodeTest.datadictionary");
		final var privacyModelPath = Paths.get("models", "dfd", "PrivacyTestModels", "UserNodeTest.privacymodel");

		PrivacyDFDConfidentialityAnalysis analysis = new PrivacyDFDDataFlowAnalysisBuilder().standalone()
				.modelProjectName("org.dataflowanalysis.examplemodels").usePluginActivator(Activator.class)
				.useDataFlowDiagram(dataFlowDiagramPath.toString()).useDataDictionary(dataDictionaryPath.toString())
				.usePrivacyModel(privacyModelPath.toString()).build();
		analysis.initializeAnalysis();
		DFDFlowGraphCollection flowGraphCollection = analysis.findFlowGraphs();
		flowGraphCollection.evaluate();

		var violations = PrivacyDataFlowConstraint.findViolations(flowGraphCollection, true, false);
		assertEquals(1, violations.size());
		for (var violation : violations) {
			assertTrue(violation.message().startsWith("The user-representing vertex"));
		}
	}

	@Test
	public void testPinRelation() {
		// UserNodeTest
		final var dataFlowDiagramPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"PinRelationTest.dataflowdiagram");
		final var dataDictionaryPath = Paths.get("models", "dfd", "PrivacyTestModels",
				"PinRelationTest.datadictionary");
		final var privacyModelPath = Paths.get("models", "dfd", "PrivacyTestModels", "PinRelationTest.privacymodel");

		PrivacyDFDConfidentialityAnalysis analysis = new PrivacyDFDDataFlowAnalysisBuilder().standalone()
				.modelProjectName("org.dataflowanalysis.examplemodels").usePluginActivator(Activator.class)
				.useDataFlowDiagram(dataFlowDiagramPath.toString()).useDataDictionary(dataDictionaryPath.toString())
				.usePrivacyModel(privacyModelPath.toString()).build();
		analysis.initializeAnalysis();
		DFDFlowGraphCollection flowGraphCollection = analysis.findFlowGraphs();
		flowGraphCollection.evaluate();

		var violations = PrivacyDataFlowConstraint.findViolations(flowGraphCollection, true, false);
		assertEquals(1, violations.size());

		for (var violation : violations) {
			assertTrue(violation.message().contains("\"Middle\" received or could derive information not authorized"));
		}
	}
}

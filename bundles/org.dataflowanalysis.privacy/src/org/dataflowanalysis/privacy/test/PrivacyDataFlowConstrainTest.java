package org.dataflowanalysis.privacy.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.core.CharacteristicValue;
import org.dataflowanalysis.analysis.dfd.core.DFDCharacteristicValue;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.privacy.consentmodel.DataItem;
import org.dataflowanalysis.privacy.consentmodel.DataItemLabel;
import org.dataflowanalysis.privacy.consentmodel.DataItemLabelType;
import org.dataflowanalysis.privacy.consentmodel.DataState;
import org.dataflowanalysis.privacy.consentmodel.consentmodelFactory;
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
	// Label types
	private DataItemLabelType dataItemLabelType;
	// Labels
	private DataItemLabel dataItemLabelOne;
	private DataItemLabel dataItemLabelTwo;
	private DataItemLabel dataItemLabelThree;
	private DataItemLabel dataItemLabelFour;

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

		// Label types
		dataItemLabelType = consentmodelFactory.eINSTANCE.createDataItemLabelType();
		dataItemLabelType.setEntityName("DataItemLabelType");

		// Labels
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
		assertFalse(PrivacyDataFlowConstraint.stateSetsCanBeIntersected(Set.of(dataStateOne, dataStateTwo),
				Set.of(dataStateThree, dataStateFour)));

		// One set empty
		assertFalse(PrivacyDataFlowConstraint.stateSetsCanBeIntersected(Set.of(dataStateOne, dataStateTwo), Set.of()));
		assertFalse(PrivacyDataFlowConstraint.stateSetsCanBeIntersected(Set.of(), Set.of(dataStateThree)));

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
		// have an overlap with either
		List<Set<DataState>> states = List.of(Set.of(dataStateOne, dataStateTwo), Set.of(dataStateTwo, dataStateThree),
				Set.of(dataStateFour));
		assertEquals(List.of(Set.of(dataStateTwo), Set.of(dataStateFour)),
				PrivacyDataFlowConstraint.reduceDataStateSets(states));

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
}

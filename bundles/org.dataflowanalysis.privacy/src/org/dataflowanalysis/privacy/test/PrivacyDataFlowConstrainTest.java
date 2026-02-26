package org.dataflowanalysis.privacy.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.dataflowanalysis.analysis.utils.LoggerManager;
import org.dataflowanalysis.privacy.consentmodel.DataItem;
import org.dataflowanalysis.privacy.consentmodel.DataState;
import org.dataflowanalysis.privacy.consentmodel.consentmodelFactory;
import org.dataflowanalysis.privacy.constraint.PrivacyDataFlowConstraint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrivacyDataFlowConstrainTest {
	private static final Logger logger = LoggerManager.getLogger(PrivacyDataFlowConstrainTest.class);

	private DataItem dataItemOne;
	private DataItem dataItemTwo;
	private DataItem dataItemThree;
	private DataItem dataItemFour;
	private DataState dataStateOne;
	private DataState dataStateTwo;
	private DataState dataStateThree;

	@BeforeEach
	public void setup() {
		dataItemOne = consentmodelFactory.eINSTANCE.createDataItem();
		dataItemOne.setEntityName("dOne");
		dataItemTwo = consentmodelFactory.eINSTANCE.createDataItem();
		dataItemTwo.setEntityName("dTwo");
		dataItemThree = consentmodelFactory.eINSTANCE.createDataItem();
		dataItemThree.setEntityName("dThree");
		dataItemFour = consentmodelFactory.eINSTANCE.createDataItem();
		dataItemFour.setEntityName("dFour");
		dataStateOne = consentmodelFactory.eINSTANCE.createDataState();
		dataStateOne.setEntityName("sOne");
		dataStateTwo = consentmodelFactory.eINSTANCE.createDataState();
		dataStateTwo.setEntityName("sTwo");
		dataStateThree = consentmodelFactory.eINSTANCE.createDataState();
		dataStateThree.setEntityName("sThree");

	}

	@Test
	public void calculateItemToDataStateCombinations() {
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
}

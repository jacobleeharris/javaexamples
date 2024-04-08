package me.jacobleeharris.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import me.jacobleeharris.api.MetricConverter;
import me.jacobleeharris.api.MetricUnitType;

public class MetricConverterTest {
	@Test
	private void testDecigramToCentigram() {
		double weight = MetricConverter.convertWeight(MetricUnitType.DECIGRAM, MetricUnitType.CENTIGRAM, 1.0D);
		double expectedWeight = 10.0D;
		Assertions.assertEquals(weight, expectedWeight);
	}

	@Test
	private void testCentigramToMilligram() {
		double weight = MetricConverter.convertWeight(MetricUnitType.CENTIGRAM, MetricUnitType.MILLIGRAM, 1.0D);
		double expectedWeight = 10.0D;
		Assertions.assertEquals(weight, expectedWeight);
	}

	@Test
	private void testMilligramToMicrogram() {
		double weight = MetricConverter.convertWeight(MetricUnitType.MILLIGRAM, MetricUnitType.MICROGRAM, 1.0D);
		double expectedWeight = 1000.0D;
		Assertions.assertEquals(weight, expectedWeight);
	}

	@Test
	private void testMicrogramToNanogram() {
		double weight = MetricConverter.convertWeight(MetricUnitType.MICROGRAM, MetricUnitType.NANOGRAM, 1.0D);
		double expectedWeight = 1000.0D;
		Assertions.assertEquals(weight, expectedWeight);
	}

	@Test
	private void testNanogramToPicogram() {
		double weight = MetricConverter.convertWeight(MetricUnitType.NANOGRAM, MetricUnitType.PICOGRAM, 1.0D);
		double expectedWeight = 1000.0D;
		Assertions.assertEquals(weight, expectedWeight);
	}

	@Test
	private void testPicogramToFemtogram() {
		double weight = MetricConverter.convertWeight(MetricUnitType.PICOGRAM, MetricUnitType.FEMTOGRAM, 1.0D);
		double expectedWeight = 1000.0D;
		Assertions.assertEquals(weight, expectedWeight);
	}

	@Test
	private void testDecigramToGram() {
		double weight = MetricConverter.convertWeight(MetricUnitType.DECIGRAM, MetricUnitType.GRAM, 1.0D);
		double expectedWeight = 0.1D;
		Assertions.assertEquals(weight, expectedWeight);
	}

	@Test
	private void testGramToDeckagram() {
		double weight = MetricConverter.convertWeight(MetricUnitType.GRAM, MetricUnitType.DECKAGRAM, 1.0D);
		double expectedWeight = 0.1D;
		Assertions.assertEquals(weight, expectedWeight);
	}
}

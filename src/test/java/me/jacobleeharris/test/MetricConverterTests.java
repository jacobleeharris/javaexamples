package me.jacobleeharris.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import me.jacobleeharris.api.MetricConverter;
import me.jacobleeharris.api.MetricUnitType;

public class MetricConverterTests {
	private static final double DELTA = Math.pow(10, -12);

	@Test
	public void testDecigramToCentigram() {
		double weight = MetricConverter.convertWeight(MetricUnitType.DECIGRAM, MetricUnitType.CENTIGRAM, 1.0D);
		double expectedWeight = 10.0D;
		Assertions.assertEquals(expectedWeight, weight, DELTA);
	}

	@Test
	public void testCentigramToMilligram() {
		double weight = MetricConverter.convertWeight(MetricUnitType.CENTIGRAM, MetricUnitType.MILLIGRAM, 1.0D);
		double expectedWeight = 10.0D;
		Assertions.assertEquals(expectedWeight, weight, DELTA);
	}

	@Test
	public void testMilligramToMicrogram() {
		double weight = MetricConverter.convertWeight(MetricUnitType.MILLIGRAM, MetricUnitType.MICROGRAM, 1.0D);
		double expectedWeight = 1000.0D;
		Assertions.assertEquals(expectedWeight, weight, DELTA);
	}

	@Test
	public void testMicrogramToNanogram() {
		double weight = MetricConverter.convertWeight(MetricUnitType.MICROGRAM, MetricUnitType.NANOGRAM, 1.0D);
		double expectedWeight = 1000.0D;
		Assertions.assertEquals(expectedWeight, weight, DELTA);
	}

	@Test
	public void testNanogramToPicogram() {
		double weight = MetricConverter.convertWeight(MetricUnitType.NANOGRAM, MetricUnitType.PICOGRAM, 1.0D);
		double expectedWeight = 1000.0D;
		Assertions.assertEquals(expectedWeight, weight, DELTA);
	}

	@Test
	public void testPicogramToFemtogram() {
		double weight = MetricConverter.convertWeight(MetricUnitType.PICOGRAM, MetricUnitType.FEMTOGRAM, 1.0D);
		double expectedWeight = 1000.0D;
		Assertions.assertEquals(expectedWeight, weight, DELTA);
	}

	@Test
	public void testDecigramToGram() {
		double weight = MetricConverter.convertWeight(MetricUnitType.DECIGRAM, MetricUnitType.GRAM, 1.0D);
		double expectedWeight = 0.1D;
		Assertions.assertEquals(expectedWeight, weight, DELTA);
	}

	@Test
	public void testGramToDecagram() {
		double weight = MetricConverter.convertWeight(MetricUnitType.GRAM, MetricUnitType.DECAGRAM, 1.0D);
		double expectedWeight = 0.1D;
		Assertions.assertEquals(expectedWeight, weight, DELTA);
	}
}

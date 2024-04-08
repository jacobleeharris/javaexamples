package me.jacobleeharris.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import me.jacobleeharris.api.ImperialConverter;
import me.jacobleeharris.api.ImperialUnitType;

public class ImperialConverterTest {
	@Test
	private void testOuncesToPounds() {
		double weight = ImperialConverter.convertWeight(ImperialUnitType.OUNCES, ImperialUnitType.POUNDS, 16.0D);
		double expectedWeight = 1.0D;
		Assertions.assertEquals(weight, expectedWeight);
	}

	@Test
	private void testPoundsToStones() {
		double weight = ImperialConverter.convertWeight(ImperialUnitType.POUNDS, ImperialUnitType.STONES, 1.0D);
		double expectedWeight = 1.0D / 14.0D;
		Assertions.assertEquals(weight, expectedWeight);
	}
}

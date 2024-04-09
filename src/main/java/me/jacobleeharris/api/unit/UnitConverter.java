package me.jacobleeharris.api.unit;

// Used for conversion between metric and imperial
public class UnitConverter {
	public static double convertKilogramsToPounds(double kilograms) {
		return kilograms / 0.45359237D;
	}

	public static double convertPoundsToKilograms(double pounds) {
		return pounds / 2.2046226218488D;
	}
}

package me.jacobleeharris.api.unit;

public class ImperialConverter {
	public static int convertWeight(ImperialUnitType from, ImperialUnitType to, int weight) {
		return (int) convertWeight(from, to, weight);
	}

	public static double convertWeight(ImperialUnitType from, ImperialUnitType to, double weight) {
		switch (from) {
			case OUNCES: {
				if (ImperialUnitType.POUNDS.equals(to)) {
					return weight / 16.0D;
				} else if (ImperialUnitType.STONES.equals(to)) {
					return weight / 224.0D;
				} else {
					return weight;
				}
			}
			case POUNDS: {
				if (ImperialUnitType.OUNCES.equals(to)) {
					return weight * 16.0D;
				} else if (ImperialUnitType.STONES.equals(to)) {
					return weight / 14.0D;
				} else {
					return weight;
				}
			}
			case STONES: {
				if (ImperialUnitType.OUNCES.equals(to)) {
					return weight * 224.0D;
				} else if (ImperialUnitType.POUNDS.equals(to)) {
					return weight * 14.0D;
				} else {
					return weight;
				}
			}
			default: {
				throw new UnsupportedOperationException("Imperial unit type: " + from + " is not supported for conversion!");
			}
		}
	}
}

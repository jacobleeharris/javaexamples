package me.jacobleeharris.api;

public class MetricConverter {
	public static int convertWeight(MetricUnitType from, MetricUnitType to, int weight) {
		return (int) convertWeight(from, to, weight);
	}

	public static double convertWeight(MetricUnitType from, MetricUnitType to, double weight) {
		// double fromMultiplier = Math.pow(10, from.getScale());
		double toMultiplier = Math.pow(10, to.getScale());

		// Conversion to a gram, reverse the fromMultiplier
		if (toMultiplier == 0) {
			double gramMultiplier = Math.pow(10, -from.getScale());
			return weight * gramMultiplier;
		}
		return weight * toMultiplier;
	}
}

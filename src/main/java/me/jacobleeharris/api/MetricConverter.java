package me.jacobleeharris.api;

public class MetricConverter {
	public static int convertWeight(MetricUnitType from, MetricUnitType to, int weight) {
		return (int) convertWeight(from, to, weight);
	}

	public static double convertWeight(MetricUnitType from, MetricUnitType to, double weight) {
		double fromScale = from.getScale();
		double toScale = to.getScale();
		return weight * (fromScale / toScale);
	}
}

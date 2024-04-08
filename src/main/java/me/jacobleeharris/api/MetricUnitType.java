package me.jacobleeharris.api;

public enum MetricUnitType {
	// Small unit types
	DECIGRAM(Math.pow(10, -1)),
	CENTIGRAM(Math.pow(10, -2)),
	MILLIGRAM(Math.pow(10, -3)),
	MICROGRAM(Math.pow(10, -6)),
	NANOGRAM(Math.pow(10, -9)),
	PICOGRAM(Math.pow(10, -12)),
	FEMTOGRAM(Math.pow(10, -15)),
	ATTOGRAM(Math.pow(10, -18)),

	// Base unit type
	GRAM(1.0D),

	// Large unit types
	DECAGRAM(Math.pow(10, 1)),
	HECTOGRAM(Math.pow(10, 2)),
	KILOGRAM(Math.pow(10, 3)),
	MEGAGRAM(Math.pow(10, 6)),
	GIGAGRAM(Math.pow(10, 9)),
	TERAGRAM(Math.pow(10, 12)),
	PETAGRAM(Math.pow(10, 15)),
	EXAGRAM(Math.pow(10, 18));

	private final double scale;

	private MetricUnitType(double scale) {
		this.scale = scale;
	}

	public double getScale() {
		return this.scale;
	}
}

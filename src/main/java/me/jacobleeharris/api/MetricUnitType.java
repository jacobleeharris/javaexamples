package me.jacobleeharris.api;

public enum MetricUnitType {
	// Small unit types
	DECIGRAM(-1),
	CENTIGRAM(-2),
	MILLIGRAM(-3),
	MICROGRAM(-6),
	NANOGRAM(-9),
	PICOGRAM(-12),
	FEMTOGRAM(-15),
	ATTOGRAM(-18),

	// Base unit type
	GRAM(0),

	// Large unit types
	DECKAGRAM(1),
	HECTOGRAM(2),
	KILOGRAM(3),
	MEGAGRAM(6),
	GIGAGRAM(9),
	TERAGRAM(12),
	PETAGRAM(15),
	EXAGRAM(18);

	private final int scale;

	private MetricUnitType(int scale) {
		this.scale = scale;
	}

	public int getScale() {
		return this.scale;
	}
}

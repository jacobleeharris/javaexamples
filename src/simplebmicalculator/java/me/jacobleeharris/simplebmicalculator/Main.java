package me.jacobleeharris.simplebmicalculator;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("SimpleBMICalculator v0.1");

		// Continue asking for input if input is malformed.
		boolean isImperial = false;
		while (true) {
			System.out.println("Weight type (lbs/kg): ");
			String weightType = scanner.readLine();
			if ("lbs".equals(weightType) || "kg".equals(weightType)) {
				isImperial = "lbs".equals(weightType);
				break;
			}
		}
	}
}

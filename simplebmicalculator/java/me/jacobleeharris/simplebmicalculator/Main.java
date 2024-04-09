package me.jacobleeharris.simplebmicalculator;

import me.jacobleeharris.api.UnitConverter;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("SimpleBMICalculator v0.1");

		// Ask user for preferred system
		boolean isImperial = parseBooleanInput(scanner, "Imperial system (Y/n): ");

		// Ask user for weight
		double weight = parseDoubleInput(scanner, "Weight: ");

		// Ask user for height (in centimeters)
		double height = parseDoubleInput(scanner, "Height: ");

		// Calculate the user's BMI!
		if (isImperial) {
			weight = UnitConverter.convertPoundsToKilograms(weight);
			height = height / 2.54D;
		}
		double bmi = calculateBMI(weight, height);
		System.out.println("Your BMI is: " + bmi);
	}

	private static boolean parseBooleanInput(Scanner scanner, String prefix) {
		boolean input = false;
		while (true) {
			System.out.println(prefix);
			String parsedString = scanner.readLine().toLowerCase();
			if (parsedString.equals("true") || parsedString.equals("false") || parsedString.charAt(0) == 'y' || parsedString.charAt(0) == 'n') {
				input = Boolean.valueOf(parsedString);
				break;
			}
		}
	}

	private static double parseDoubleInput(Scanner scanner, String prefix) {
		double input = 0.0D;
		while (true) {
			System.out.println(prefix);
			String parsedString = scanner.readLine();
			try {
				input = Double.valueOf(parsedString);
				break;
			} catch (NumberFormatException ignored) {
			}
		}
		return input;
	}

	private static double calculateBMI(double weight, double height) {
		return (weight / (Math.pow(2, height)));
	}
}

package me.jacobleeharris.simplebmicalculator;

import java.util.Scanner;

import me.jacobleeharris.api.cli.InputHelper;
import me.jacobleeharris.api.unit.UnitConverter;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("SimpleBMICalculator v0.1");

		// Ask user for preferred system
		boolean isImperial = InputHelper.parseBooleanInput(scanner, "Imperial system (Y/n): ");

		// Ask user for weight
		double weight = InputHelper.parseDoubleInput(scanner, "Weight: ");

		// Ask user for height (in centimeters)
		double height = InputHelper.parseDoubleInput(scanner, isImperial ? "Height (Inches): " : "Height: ");

		// Calculate the user's BMI!
		if (isImperial) {
			weight = UnitConverter.convertPoundsToKilograms(weight);
			height = height * 2.54D;
		}
		double bmi = calculateBMI(weight, height);
		System.out.println("Your BMI is: " + bmi);
	}

	private static double calculateBMI(double weight, double height) {
		double heightInMeters = height / 100;
		return (weight / (heightInMeters * heightInMeters));
	}
}

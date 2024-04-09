package me.jacobleeharris.api.cli;

import java.util.Scanner;

public class InputHelper {
	public static boolean parseBooleanInput(Scanner scanner, String prefix) {
		boolean input = false;
		while (true) {
			System.out.print(prefix);
			String parsedString = scanner.nextLine().toLowerCase();
			if (Boolean.valueOf(parsedString) || parsedString.startsWith("yes") || parsedString.charAt(0) == 'y') {
				input = true;
				break;
			} else {
				// This could be a bit more clear...
				input = false;
				break;
			}
		}
		return input;
	}

	public static double parseDoubleInput(Scanner scanner, String prefix) {
		double input = 0.0D;
		while (true) {
			System.out.print(prefix);
			String parsedString = scanner.nextLine();
			try {
				input = Double.valueOf(parsedString);
				break;
			} catch (NumberFormatException ignored) {
			}
		}
		return input;
	}
}

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

	public static float parseFloatInput(Scanner scanner, String prefix) {
		float input = 0.0F;
		while (true) {
			System.out.print(prefix);
			String parsedString = scanner.nextLine();
			try {
				input = Float.valueOf(parsedString);
				break;
			} catch (NumberFormatException ignored) {
			}
		}
		return input;
	}

	public static int parseIntegerInput(Scanner scanner, String prefix) {
		System.out.print(prefix);
		return tryParseIntegerInput(scanner.nextLine());
	}

	public static String parseStringInput(Scanner scanner, String prefix) {
		System.out.print(prefix);
		return scanner.nextLine();
	}

	public static char parseCharInput(Scanner scanner, String prefix) {
		System.out.println(prefix);
		String input = scanner.nextLine();
		return input.charAt(0);
	}

	public static int tryParseIntegerInput(String input) {
		int value = 0;
		while (true) {
			try {
				value = Integer.valueOf(input);
				break;
			} catch (NumberFormatException ignored) {
			}
		}
		return value;
	}
}

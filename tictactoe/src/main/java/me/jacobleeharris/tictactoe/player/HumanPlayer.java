package me.jacobleeharris.tictactoe.player;

import java.util.Scanner;

import me.jacobleeharris.api.cli.InputHelper;
import me.jacobleeharris.tictactoe.Board;

public class HumanPlayer extends Player {
	private final Scanner scanner;

	public HumanPlayer(Scanner scanner, Board board, char playSymbol) {
		super(board, playSymbol);
		this.scanner = scanner;
	}

	@Override
	public boolean isComputer() {
		return false;
	}

	@Override
	public int getNextMove() {
		Board board = this.getBoard();

		boolean hasDecidedNextMove = false;
		while (!hasDecidedNextMove) {
			// Ask user for next move in X, Y format
			String input = InputHelper.parseStringInput(this.scanner, "Your move (X, Y): ");

			// Suspend the program if "exit" is input.
			if ("exit".equals(input.toLowerCase())) {
				System.exit(0);
			}

			String[] split = input.split(",");

			// Next move is in proper format
			if (split.length == 2) {
				int x = InputHelper.tryParseIntegerInput(split[0].trim().replaceAll(" ", ""));
				int y = InputHelper.tryParseIntegerInput(split[1].trim().replace(" ", ""));
				if (x > board.getSizeX() || y > board.getSizeY()) {
					System.err.println("Position out of bounds!");
				} else {
					int idx = board.getIndex(x, y);
					if (board.getBit(x, y) == -1) {
						this.setLastMove(x, y);
						return idx;
					} else {
						System.err.println("Position already taken! Try again.");
					}
				}
			}
		}
		return -1;
	}
}

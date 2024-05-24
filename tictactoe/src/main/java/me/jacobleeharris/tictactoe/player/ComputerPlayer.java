package me.jacobleeharris.tictactoe.player;

import java.util.Random;

import me.jacobleeharris.tictactoe.Board;

public class ComputerPlayer extends Player {
	private final Random random = new Random();

	public ComputerPlayer(Board board, char playSymbol) {
		super(board, playSymbol);
	}

	public Random getRandom() {
		return this.random;
	}

	@Override
	public boolean isComputer() {
		return true;
	}

	@Override
	public int getNextMove() {
		Board board = this.getBoard();

		int tries = 0;
		while (!hasWon()) {
			// If too many tries have been attempted, break out of the loop and return -1
			if (tries == board.getSizeX() * board.getSizeY()) {
				break;
			}

			int randomX = this.random.nextInt(board.getSizeX());
			int randomY = this.random.nextInt(board.getSizeY());
			if (board.getBit(randomX, randomY) == -1) {
				System.out.println("Computer's move: " + randomX + ", " + randomY);
				this.setLastMove(randomX, randomY);
				return board.getIndex(randomX, randomY);
			}
			tries++;
		}
		return -1;
	}
}

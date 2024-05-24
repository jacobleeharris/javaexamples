package me.jacobleeharris.tictactoe.player;

import me.jacobleeharris.tictactoe.Board;
import me.jacobleeharris.tictactoe.GameOutcome;

public abstract class Player {
	private final Board board;
	private final char playSymbol;
	private int lastMoveX;
	private int lastMoveY;

	public Player(Board board, char playSymbol) {
		this.board = board;
		this.playSymbol = playSymbol;
	}

	public boolean isComputer() {
		return false;
	}

	public char getPlaySymbol() {
		return this.playSymbol;
	}

	public GameOutcome getGameOutcome() {
		int lastMoveX = this.getLastMoveX();
		int lastMoveY = this.getLastMoveY();
		int expectedBit = this.getBoard().getPlayers()[0].equals(this) ? 0 : 1;

		// Horizontal case
		// Since we have the last move index, we can iterate from
		// the beginning of the row to the end to determine if a win
		// has occurred.
		int lastX = lastMoveX % this.getBoard().getSizeY();
		for (int y = 0; y < this.getBoard().getSizeX(); y++) {
			// If player is second player / computer, the bit
			// should be 1. If player is first player, the bit
			// should be 0. -1 is for unset.
			int currentBit = this.getBoard().getBit(lastX, y);
			if (currentBit == -1) {
				// Position is unset, we don't need to do
				// any more checking for the horizontal case.
				break;
			} else if (currentBit == 0 || currentBit == 1) {
				// A player has set this bit, we need to check
				// if all horizontal cases are fulfilled.
				boolean isHorizontalCaseFulfilled = currentBit == expectedBit ? true : false;

				// Short-circuit out of the horizontal case
				// as the horizontal case was not fulfilled.
				if (!isHorizontalCaseFulfilled) {
					break;
				}
			}
		}

		// Vertical case
		// Same situation as above save for this time
		// we use the column to determine if a win
		// has occurred.
		int y = (int) Math.floor(lastMoveY / this.getBoard().getSizeX());
		for (int x = 0; x < this.getBoard().getSizeY(); x++) {
			int currentBit = this.getBoard().getBit(x, y);
		}

		// Diagonal case

		return GameOutcome.UNDETERMINED;
	}

	public boolean hasWon() {
		return GameOutcome.WIN.equals(this.getGameOutcome());
	}

	public boolean hasTied() {
		return GameOutcome.TIE.equals(this.getGameOutcome());
	}

	public Board getBoard() {
		return this.board;
	}

	public abstract int getNextMove();

	public int getLastMoveX() {
		return this.lastMoveX;
	}

	public int getLastMoveY() {
		return this.lastMoveY;
	}

	public void setLastMove(int lastMoveX, int lastMoveY) {
		this.lastMoveX = lastMoveX;
		this.lastMoveY = lastMoveY;
	}
}

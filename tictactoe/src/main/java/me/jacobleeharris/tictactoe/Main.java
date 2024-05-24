package me.jacobleeharris.tictactoe;

import java.util.Random;
import java.util.Scanner;

import me.jacobleeharris.api.cli.InputHelper;
import me.jacobleeharris.tictactoe.player.ComputerPlayer;
import me.jacobleeharris.tictactoe.player.HumanPlayer;
import me.jacobleeharris.tictactoe.player.Player;

public class Main {
	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		int boardSize = InputHelper.parseIntegerInput(scanner, "Board size: ");
		boolean hasComputer = InputHelper.parseBooleanInput(scanner, "Versus Computer (Y/n): ");

		// Initialize the board
		Board board = new Board(boardSize, boardSize);
		Player humanPlayer = new HumanPlayer(scanner, board, 'X');
		board.addPlayer(0, humanPlayer);

		if (hasComputer) {
			Player computerPlayer = new ComputerPlayer(board, 'O');
			board.addPlayer(1, computerPlayer);
		}
		// TODO: Allow multiple human players
		int startingPlayerIdx = random.nextInt(board.getPlayers().length);
		Player startingPlayer = board.getPlayers()[startingPlayerIdx];

		// Maximum possible moves would be boardSize * boardSize
		for (int idx = 0; idx < boardSize * boardSize; idx++) {
			// Each player makes their move until one wins
			// or the game ends in a tie.
			int currentPlayerIdx = 0;
			Player currentPlayer = null;
			if (idx == 0) {
				currentPlayerIdx = startingPlayerIdx;
				currentPlayer = startingPlayer;
			} else {
				currentPlayerIdx = idx % 2 == 0 ? 1 : 0;
				currentPlayer = board.getPlayers()[currentPlayerIdx];
			}

			// Short-circuit when one player wins or the game ends in a tie.
			if (currentPlayer.hasWon() || currentPlayer.hasTied()) {
				break;
			}

			int nextMove = currentPlayer.getNextMove();
			int[] position = board.unpackIndex(nextMove);

			// No more moves possible!
			if (nextMove == -1) {
				break;
			}

			board.setBit(position[0], position[1], (byte) (currentPlayerIdx));

			// Print the board after each move
			printBoard(board);

			// Move to next line so boards don't bunch up
			System.out.println();
		}
	}

	public static void printBoard(Board board) {
		// Print board out in format of:
		// X | O | X
		// O | X | O
		// X | O | X
		// Player 1 won!

		for (int row = 0; row < board.getSizeX(); row++) {
			for (int col = 0; col < board.getSizeY(); col++) {
				byte value = board.getBit(row, col);

				if (value == -1) {
					// Value is unset.
					System.out.print(" ");
				} else if (value == 0) {
					Player humanPlayer = board.getPlayers()[0];
					System.out.print(humanPlayer.getPlaySymbol());
				} else if (value == 1) {
					Player otherPlayer = board.getPlayers()[1];
					System.out.print(otherPlayer.getPlaySymbol());
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}

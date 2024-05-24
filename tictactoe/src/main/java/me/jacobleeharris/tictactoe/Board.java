package me.jacobleeharris.tictactoe;

import java.util.Arrays;

import me.jacobleeharris.tictactoe.player.Player;

public class Board {
	private final Player[] players = new Player[2];
	private final byte[][] board;
	private final int sizeX;
	private final int sizeY;

	public Board(int sizeX, int sizeY) {
		this.board = new byte[sizeX][sizeY];
		this.sizeX = sizeX;
		this.sizeY = sizeY;

		// Initialize arrays with -1
		for (int row = 0; row < sizeX; row++) {
			Arrays.fill(this.board[row], (byte) -1);
		}
	}

	public byte[][] getBoard() {
		return this.board;
	}

	public void setBit(int x, int y, byte value) {
		this.getBoard()[x][y] = value;
	}

	public byte getBit(int x, int y) {
		return this.getBoard()[x][y];
	}

	public int getSizeX() {
		return this.sizeX;
	}

	public int getSizeY() {
		return this.sizeY;
	}

	public Player[] getPlayers() {
		return this.players;
	}

	public void addPlayer(int index, Player player) {
		this.players[index] = player;
	}

	public int[] unpackIndex(int idx) {
		int x = idx % this.getSizeX();
		int y = (int) Math.floor(idx / this.getSizeX());
		return new int[] {x, y};
	}

	public int getIndex(int x, int y) {
		return (x * this.getSizeX()) + y;
	}
}

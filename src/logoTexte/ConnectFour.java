package logoTexte;

import java.util.ArrayList;
import java.util.Random;

public class ConnectFour {
	// Define the rows of the "Connect Four" board
	private static final int rows = 12;
	// Define the columns of the "Connect Four" board
	private static final int cols = 12;

	/**
	 * Draws the board in the console.
	 * 
	 * @param board
	 */
	private static void paintBoard(char[][] board) {
		int currentRow = 0;
		while (currentRow < board.length) {
			printHorizontalLine();
			System.out.print("|");
			int currentCol = 0;
			while (currentCol < board[currentRow].length) {
				String playerNr = " ";
				if (board[currentRow][currentCol] != 0)
					playerNr = String.valueOf(board[currentRow][currentCol]);
				System.out.print(" " + playerNr + " ");
				System.out.print("|");
				currentCol++;
			}
			System.out.print("\n");
			currentRow++;
		}
		printHorizontalLine();
	}

	/**
	 * Draws a horizontal line.
	 */
	private static void printHorizontalLine() {
		System.out.print("+");
		int i = 0;
		while (i < cols) {
			System.out.print("---+");
			i++;
		}
		System.out.println();
	}

	/**
	 * Creates a random column number col, where 1 <= col <= 7.
	 * 
	 * @return
	 */

	private static int getRandomColumn() {
		int col = new Random().nextInt(7) + 1;
		return col;
	}

	/*
	 * +-----------------------+ | INSERT YOUR CODE HERE |
	 * +-----------------------+
	 */

	public static void main(ArrayList<String> strings) {
		int col = 12;
		int row = 12;
		Random r = new Random();

		char[][] board = new char[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				char x = (char)(r.nextInt(26) + 'a');
				board[i][j] = x;
			}
		}

		// while (areFourConnected(board, row, col) == false) {
		int next = 0;
		
		do {
			next++;
			String eingabe = strings.get(next);
			col = Integer.parseInt(eingabe);
			col = col - 1;
			row = getNextEmptyPositionInCol(board, col);

			board[row][col] = 1;

			paintBoard(board);

			col = getRandomColumn();
			col = col - 1;
			row = getNextEmptyPositionInCol(board, col);
			board[row][col] = 2;

			paintBoard(board);

		} while (areFourConnected(board, row, col) == false);


	}

	/**
	 * Determines, if there are four tokens connected in the environment of the
	 * field with the coordinates (row, col).
	 * 
	 * @param board
	 * @param row
	 * @param col
	 * @return Returns true if there exists such a row with four connected
	 *         tokens, false otherwise.
	 */
	public static boolean areFourConnected(char[][] board, int row, int col) {
		// Insert your code here.
		row = 6;
		col = 7;

		// vertikal

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col - 3; j++) {

				// fuer Spieler 1
				if (board[i][j] == 1 && board[i][j + 1] == 1
						&& board[i][j + 2] == 1 && board[i][j + 3] == 1)

					return true;

				// fuer Spieler 2
				if (board[i][j] == 2 && board[i][j + 1] == 2
						&& board[i][j + 2] == 2 && board[i][j + 3] == 2)

					return true;

			}
		}

		// horizontal
		for (int j = 0; j < col; j++) {
			for (int i = 0; i < row - 3; i++) {

				// fuer Spieler 1
				if (board[i][j] == 1 && board[i + 1][j] == 1
						&& board[i + 2][j] == 1 && board[i + 3][j] == 1)
					return true;

				// fuer Spieler 2
				if (board[i][j] == 2 && board[i + 1][j] == 2
						&& board[i + 2][j] == 2 && board[i + 3][j] == 2)

					return true;
			}
		}

		// diagonal 1
		for (int i = 0; i < row - 3; i++) {
			for (int j = 0; j < col - 3; j++) {

				// fuer Speiler 1
				if (board[i][j] == 1 && board[i + 1][j + 1] == 1
						&& board[i + 2][j + 2] == 1 && board[i + 3][j + 3] == 1)

					return true;

				// fuer Spieler 2
				if (board[i][j] == 2 && board[i + 1][j + 1] == 2
						&& board[i + 2][j + 2] == 2 && board[i + 3][j + 3] == 2)

					return true;

			}
		}
		// diagonal 2
		for (int i = 0; i < row - 3; i++) {
			for (int j = 6; j >= 3; j--) {

				// fuer Spieler 1
				if (board[i][j] == 1 && board[i + 1][j - 1] == 1
						&& board[i + 2][j - 2] == 1 && board[i + 3][j - 3] == 1)
					return true;

				// fuer Spieler 2
				if (board[i][j] == 2 && board[i + 1][j - 1] == 2
						&& board[i + 2][j - 2] == 2 && board[i + 3][j - 3] == 2)
					return true;

			}

		}
		// Return true if there exists such a row with four connected tokens,
		// false otherwise.
		return false;
	}

	/**
	 * Determines all columns, where an empty field is available.
	 * 
	 * @param board
	 * @return Returns a message with all the columns, that have still capacity.
	 */
	private static String checkPossibleCols(int[][] board) {
		// Insert your code here.

		String s;
		// ermittelt Spalten in die noch weitere Steine geworfen werden können
		for (int k = 0; k < 7; k++) {
			if (board[0][k] == 0) {
				s = " ";
				s += k + 1;
				System.out.println(s);
			}
		}

		// Return a message with all the columns, that have still capacity.

		return " ";
	}

	/**
	 * Determines the next free field in the given column.
	 * 
	 * @param board
	 * @param col
	 *            , where 1 <= col <= 7
	 * @return Returns the next empty position in the given col, where 1 <= row
	 *         <= 6, when there is a free field on the board in the given col,
	 *         and 0 when there is no free field.
	 */
	private static int getNextEmptyPositionInCol(char[][] board, int col) {
		// Insert your code here.

		int nr = 0;

		// ermittel die Zeilennummer des naechsten freien Feldes in der Spalte
		// col

		for (int i = 5; i >= 0; i--) {
			if (board[i][col] == 0) {
				nr = i;
				return nr;
			}
		}

		return nr;
	}

	/**
	 * BONUS EXERCISE: Determines the column, that has to be filled by player 2
	 * in order to win. If there is no such field, it determines the column,
	 * that has to be filled by player 1 on the next round in order to win.
	 * 
	 * @param board
	 * @return Returns the column where player 2 has to insert the token to win
	 *         the game or to prevent that the other player wins in the next
	 *         turn. If there is no such column, a random column is returned. It
	 *         is 1 <= col <= 7.
	 */
	public static int detectArisingLine(int[][] board) {
		// Insert your code here.

		// vertikal

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7 - 3; j++) {

				// fuer Spieler 2
				if (board[i][j] == 2 && board[i][j + 1] == 2
						&& board[i][j + 2] == 2)
					return board[i][j + 3];

			}
		}

		// horizontal
		for (int j = 0; j < 7; j++) {
			for (int i = 0; i < 6 - 3; i++) {

				// fuer Spieler 2
				if (board[i][j] == 2 && board[i + 1][j] == 2
						&& board[i + 2][j] == 2)
					return board[i + 3][j];

			}
		}

		// diagonal 1
		for (int i = 0; i < 6 - 3; i++) {
			for (int j = 0; j < 7 - 3; j++) {

				// fuer Spieler 2
				if (board[i][j] == 2 && board[i + 1][j + 1] == 2
						&& board[i + 2][j + 2] == 2)
					return board[i + 3][j + 3];

			}
		}
		// diagonal 2
		for (int i = 0; i < 6 - 3; i++) {
			for (int j = 6; j >= 3; j--) {

				// fuer Spieler 2
				if (board[i][j] == 2 && board[i + 1][j - 1] == 2
						&& board[i + 2][j - 2] == 2)
					return board[i + 3][j - 3];

			}

		}

		return -1;
	}
}

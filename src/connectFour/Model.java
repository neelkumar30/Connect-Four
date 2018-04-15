package connectFour;

import javax.swing.JOptionPane;

public class Model {
	int[][] board = new int[6][7];
	public int movesPlayed = 0;
	public int count = 0;

	public static void main(String[] args) {
	}

	public boolean playMove(int column, int player) {

		if (board[0][column] > 0) {
			return false;
		}
		for (int i = 0; i < board.length; i++) {
			if (board[i][column] == 0) {
				continue;
			} else {
				board[i - 1][column] = player;
				if(checkForWin(i - 1, column, player)) {
					JOptionPane.showMessageDialog(null, "Player" + player + " WON!!!");
				}
				return true;
			}
		}
		board[board.length - 1][column] = player;
		if(checkForWin(board.length - 1, column, player)){
			JOptionPane.showMessageDialog(null, "Player" + player + " WON!!!");
		}
		return true;
	}

	public void printModel() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + "    ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	boolean checkForWin(int row, int column, int player) {
		if (board[row][column + 1] == player) {
			for (int i = 0; i < board[0].length - column; i++) {
				if (board[row][column + i] == player) {
					count = count + 1;
					continue;
				} else {
					break;
				}

			}
			if (count == 4) {
				return true;
			}

		}
		if (board[row][column - 1] == player) {
			for (int i = 0; i < column; i++) {
				if (board[row][column - i] == player) {
					count = count + 1;
					continue;
				} else {
					count = 0;
					break;
				}
			}
			if (count == 4) {
				return true;
			}
		}

		if (board[row - 1][column] == player) {
			for (int i = 0; i < board.length - row; i++) {
				if (board[row + i][column] == player) {
					count = count + 1;
					continue;
				} else {
					count = 0;
					break;
				}
			}
			if (count == 4) {
				return true;
			}

		}

		if (board[row - 1][column + 1] == player) {
			for (int i = 0; i < 8; i++) {
				if (board[row - i][column + i] == player && row < board.length && column < board[0].length) {
					count = count + 1;
					continue;
				} else {
					count = 0;
					break;
				}
			}
			if (count == 4) {
				return true;
			}

		}
		if (board[row + 1][column - 1] == player) {
			for (int i = 0; i < 8; i++) {
				if (board[row + 1][column - 1] == player && row < board.length && column < board[0].length) {
					count = count + 1;
					continue;
				} else {
					count = 0;
					break;
				}

			}
			if (count == 4) {
				return true;
			}

		}
		if (board[row - 1][column - 1] == player) {
			for (int i = 0; i < 8; i++) {
				if (board[row - i][column - i] == player && row < board.length && column < board[0].length) {
					count = count + 1;
					continue;
				} else {
					count = 0;
					break;
				}
			}
			if (count == 4) {
				return true;
			}

		}
		if (board[row + 1][column + 1] == player) {
			for (int i = 0; i < 8; i++) {
				if (board[row + 1][column - 1] == player && row < board.length && column < board[0].length) {
					count = count + 1;
					continue;
				} else {
					count = 0;
					break;
				}

			}
			if (count == 4) {
				return true;
			}

		}

		return false;
	}
}

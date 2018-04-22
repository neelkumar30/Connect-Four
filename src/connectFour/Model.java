package connectFour;

import javax.swing.JOptionPane;

public class Model {
	int[][] board = new int[6][7];
	public int movesPlayed = 0;
	public int count = 0;
	boolean player1Won = false;
	boolean player2Won = false;

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
					if(player == 1) {
						player1Won = true;
					}
					if(player == 2) {
						player2Won = true;
					}
				}
				return true;
			}
		}
		board[board.length - 1][column] = player;
		if(checkForWin(board.length - 1, column, player)){
			if(player == 1) {
				player1Won = true;
			}
			if(player == 2) {
				player2Won = true;
			}
		}
		return true;
	}

	public void printModel() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + "    ");
			}
			System.out.println("");
			if(player1Won == true) {
				JOptionPane.showMessageDialog(null, "Red WON!!!");
			}
			if(player2Won == true) {
				JOptionPane.showMessageDialog(null, "Yellow WON!!!");
			}
		}
		System.out.println("");
	}

	boolean checkForWin(int row, int column, int player) {
		if (row < board.length && column < board[0].length -1 && board[row][column + 1] == player) {
			for (int i = 0; i < board[0].length - column; i++) {
				if (row < board.length && column < board[0].length && board[row][column + i] == player) {
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
		if (row < board.length  && column >0 && board[row][column - 1] == player) {
			for (int i = 0; i < column; i++) {
				if (row < board.length && column > 0 && board[row][column - i] == player) {
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

		if (row >0 && column < board[0].length && board[row - 1][column] == player) {
			for (int i = 0; i < board.length - row; i++) {
				if (row < board.length && column < board[0].length && board[row + i][column] == player) {
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

		if (row >0 && column < board[0].length -1 && board[row - 1][column + 1] == player) {
			for (int i = 0; i < 8; i++) {
				if (row < board.length && column < board[0].length && board[row - i][column + i] == player ) {
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
		if (row < board.length -1 && column >0  && board[row + 1][column - 1] == player) {
			for (int i = 0; i < 8; i++) {
				if (row < board.length && column < board[0].length && board[row + 1][column - 1] == player ) {
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
		if (row >0 && column >0 && board[row - 1][column - 1] == player) {
			for (int i = 0; i < 8; i++) {
				if (row < board.length && column < board[0].length && board[row - i][column - i] == player ) {
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
		if (row < board.length -1 && column < board[0].length -1 && board[row + 1][column + 1] == player) {
			for (int i = 0; i < 8; i++) {
				if (row < board.length && column < board[0].length && board[row + 1][column - 1] == player ) {
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

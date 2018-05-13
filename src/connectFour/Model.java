package connectFour;

import javax.swing.JOptionPane;

public class Model {
	int[][] board = new int[6][7];
	public int movesPlayed = 0;
	boolean player1Won = false;
	boolean player2Won = false;
	
	

	public boolean isPlayer1Won() {
		return player1Won;
	}

	public void setPlayer1Won(boolean player1Won) {
		this.player1Won = player1Won;
	}

	public boolean isPlayer2Won() {
		return player2Won;
	}

	public void setPlayer2Won(boolean player2Won) {
		this.player2Won = player2Won;
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
				if(checkForWin(i-1, column, player)) {
					if(player == 1) {
						player1Won = true;
						System.out.println("RED WINS!!!");
					}
					if(player == 2) {
						player2Won = true;
						System.out.println("YELLOW WINS!!!");
						
					}
				}
			}
			return true;
		}
		board[board.length - 1][column] = player;
		if (checkForWin(board.length - 1, column, player)) {
			if (player == 1) {
				player1Won = true;
				System.out.println("RED WINS!!!");
			}
			if (player == 2) {
				player2Won = true;
				System.out.println("YELLOW WINS!!!");

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
		}
		System.out.println("");
	}

	boolean checkForWin(int row, int column, int player) {
		int count = 0;
		// Checks four in a row to the right horizontally
		if (row < board.length && column < board[0].length - 1 && board[row][column + 1] == player) {
			for (int i = 0; i < board[0].length; i++) {
				if (row < board.length && column + i < board[0].length && board[row][column + i] == player) {
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

		// Checks four in a row to the left horizontally
		if (row < board.length && column > 0 && board[row][column - 1] == player) {
			for (int i = 0; i < board[0].length; i++) {
				if (row < board.length && column - i > 0 && board[row][column - i] == player) {
					count = count + 1;
					if (count == 4) {
						return true;
					}
					continue;
				} else {
					count = 0;
					break;
				}
			}
		}
		count = 0;
		if (row < board.length - 1 && column < board[0].length && board[row + 1][column] == player) {
			for (int i = 0; i < board.length; i++) {
				if (row + i < board.length && column < board[0].length && board[row + i][column] == player) {
					count = count + 1;
					if (count == 4) {
						return true;
					}
					continue;
				} else {
					count = 0;
					break;
				}
			}

		}
//problem
		if (row > 0 && column < board[0].length - 1 && board[row - 1][column + 1] == player) {
			for (int i = 0; i < 8; i++) {
				if (row - i > 0 && column + i < board[0].length && board[row - i][column + i] == player) {
					count = count + 1;
					if (count == 4) {
						return true;
					}
					continue;
				} else {
					break;
				}
			}

		}
		if (row < board.length - 1 && column > 0 && board[row + 1][column - 1] == player) {
			for (int i = 0; i < 8; i++) {
				if (row + i < board.length && column - i > 0 && board[row + i][column - i] == player) {
					count = count + 1;
					if (count == 4) {
						return true;
					}
					continue;
				} else {
					count = 0;
					break;
				}

			}

		}
		count = 0;
		if (row > 0 && column > 0 && board[row - 1][column - 1] == player) {
			for (int i = 0; i < 8; i++) {
				if (row - i > 0 && column - i < board[0].length && board[row - i][column - i] == player) {
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
		if (row < board.length - 1 && column < board[0].length - 1 && board[row + 1][column + 1] == player) {
			for (int i = 0; i < 8; i++) {
				if (row + i < board.length && column + i < board[0].length && board[row + i][column + i] == player) {
					count = count + 1;
					if (count == 4) {
						return true;
					}
					continue;
				} else {
					count = 0;
					break;
				}

			}

		}

		return false;
	}
	
	void Reset() {
		board = new int[6][7];
		player1Won = false;
		player2Won = false;
	}

	public int[][] getBoard() {
		// TODO Auto-generated method stub
		return board;
	}
}

package connectFour;

public class Model {
	int [][] board = new int [6][7];
		
	public static void main(String[] args) {
		Model model = new Model();
		model.printModel();
		model.playMove(2, 2);
		model.printModel();
		model.playMove(2, 2);
		model.printModel();
		model.playMove(2, 2);
		model.printModel();
		model.playMove(2, 2);
		model.printModel();
		model.printModel();
	}
	
	public boolean playMove(int column, int player) {
		if(board[0][column]>0) {
			return false;
		}
		for (int i = 0; i < board.length; i++) {
			if (board[i][column] == 0) {
				continue;
			}
			else {
				board [i-1][column] = player;
				return true;
			}
		}
		board[board.length -1][column] = player;
		return true;
	}
	public void printModel(){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + "    ");
			}
			System.out.println("");
			
		}
	}
}

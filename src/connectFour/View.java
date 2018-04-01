package connectFour;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class View extends JPanel {
	ArrayList<ChipHolder> holders;
	ArrayList<Squares> buttons;
	int[][] board;

	public View(ArrayList<ChipHolder> holders, ArrayList<Squares> buttons) {
		this.holders = holders;
		this.buttons = buttons;
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fill3DRect(50, 100, 700, 600, true);
		g.setColor(Color.black);

		// drawing lines
		int linesx = 150;
		int linesy = 200;
		for (int i = 0; i < 6; i++) {
			g.drawLine(linesx, 100, linesx, 700);
			linesx = linesx + 100;

		}
		for (int i = 0; i < 5; i++) {
			g.drawLine(50, linesy, 750, linesy);
			linesy = linesy + 100;

		}
		g.setColor(Color.WHITE);
		for (ChipHolder h : holders) {
			h.draw(g);
		}

		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				if (board[row][col] == 1) {
					holders.get(row).setFilled(true);
				} else if (board[row][col] == 2) {
					g.setColor(Color.YELLOW);
					// g.fillOval(row * 100 + 62, col * 62 + 100, 75, 75);
				}
			}
		}

	}

	void setBoard(int[][] board) {
		this.board = board;
	}

}

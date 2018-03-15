package connectFour;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

ArrayList<Squares> squares;
	GamePanel(){
		setLayout(null);
		squares = new ArrayList<Squares>();
		for (int i = 0; i < 7; i++) {
			Squares buttons = new Squares(50 + i*100, 100, 100 );
			squares.add(buttons);
			add(buttons);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRect(50, 100, 700, 600);
		g.setColor(Color.black);
		int linesx = 150;
		int linesy = 200;
		for (int i = 0; i < 6; i++) {
			g.drawLine(linesx, 100, linesx, 700);
			linesx = linesx +100;
	
		}
		for (int i = 0; i < 5; i++) {
			g.drawLine(50, linesy, 750, linesy);
			linesy = linesy +100;
	
		}
	}
}

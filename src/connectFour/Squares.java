package connectFour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class Squares extends JButton {
	int x;
	int y;
	int size;
	boolean Chipisin;

	Squares(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.Chipisin = false;
		setBounds(x, y, size, size);

	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
		g.setColor(Color.BLUE);
		g.fillRect(x, y, size, size);

	}

}

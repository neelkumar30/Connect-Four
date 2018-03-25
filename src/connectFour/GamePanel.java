package connectFour;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	ArrayList<Squares> squares;
	ArrayList<ChipHolder> holders;
	ObjectManager manager;

	GamePanel() {
		setLayout(null);
		squares = new ArrayList<Squares>();
		holders = new ArrayList<ChipHolder>();
		for (int i = 0; i < 7; i++) {
			Squares buttons = new Squares(50 + i * 100, 100, 100);
			squares.add(buttons);
			add(buttons);
			buttons.setBackground(Color.BLUE);
			buttons.setOpaque(true);
			buttons.setForeground(Color.BLUE);
			buttons.setContentAreaFilled(false);
			for (int j = 0; j < 6; j++) {
				holders.add(new ChipHolder(i * 100 + 62, j * 100 + 112, false));
			}
		}
		manager = new ObjectManager(holders, squares);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		manager.draw(g);
		// for (int i = 0; i < 7; i++) {
		// for (int j = 0; j < 6; j++) {
		// g.setColor(Color.WHITE);
		// g.fillOval(100*i + 62, 612 - 100*j, 75, 75);
		// }
		// }
	}
}

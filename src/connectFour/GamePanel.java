package connectFour;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {

	ArrayList<Squares> squares;
	ArrayList<ChipHolder> holders;
	View manager;
	Model model = new Model();
	final static int player1 = 1;
	final static int player2 = 2;
	int player = player1;

	GamePanel() {
		setLayout(null);
		squares = new ArrayList<Squares>();
		holders = new ArrayList<ChipHolder>();
		for (int i = 0; i < 7; i++) {
			Squares buttons = new Squares(50 + i * 100, 100, 100);
			squares.add(buttons);
			buttons.addActionListener(this);
			add(buttons);
			buttons.setBackground(Color.BLUE);
			buttons.setOpaque(true);
			buttons.setForeground(Color.BLUE);
			buttons.setContentAreaFilled(false);
			for (int j = 0; j < 6; j++) {
				holders.add(new ChipHolder(i * 100 + 62, j * 100 + 112, false));
			}
		}
		manager = new View(holders, squares);
		manager.setBoard(model.board);
		add(manager);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		manager.draw(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 7; i++) {
			if (e.getSource() == squares.get(i)) {
				boolean successful = model.playMove(i, player);
				if (successful == true) {

					switchPlayers();
					model.printModel();
					repaint();
				}
			}

		}
		if (model.isPlayer1Won()) {
			
			new Thread(()->
			{
			JOptionPane.showMessageDialog(null, "Red WON!!!");
			int restart = JOptionPane.showOptionDialog(null, "Do you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION,
			JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Yes", "No" }, null);
			if(restart == 0) {
				model.Reset();
				manager.setBoard(model.getBoard());
				repaint();
			}
			else {
				System.exit(0);;
			}
			}
			).start();
			
		}

		if (model.isPlayer2Won()) {
			new Thread(()->
			{
			JOptionPane.showMessageDialog(null, "Yellow WON!!!");
			int restart = JOptionPane.showOptionDialog(null, "Do you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION,
			JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Yes", "No" }, null);
			if(restart == 0) {
				model.Reset();
				manager.setBoard(model.getBoard());
				repaint();
			}
			else {
				System.exit(0);;
			}
			
			}
			).start();

		}
	}
	
	public void switchPlayers() {
		if (player == player1) {
			player = player2;
		} else {
			player = player1;
		}

	}
}

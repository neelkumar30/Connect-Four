package connectFour;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ObjectManager extends JPanel implements ActionListener  {
	ArrayList <ChipHolder> holders; 
	ArrayList <Squares> buttons;
	public ObjectManager(ArrayList <ChipHolder> holders, ArrayList <Squares> buttons){
		this.holders = holders;
		this.buttons = buttons;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(50, 100, 700, 600);
		g.setColor(Color.black);
		
		//drawing lines
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
		g.setColor(Color.WHITE);
		for (ChipHolder h: holders) {
			h.draw(g);
		}
	}
	
}

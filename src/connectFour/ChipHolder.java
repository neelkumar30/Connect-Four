package connectFour;

import java.awt.Graphics;

public class ChipHolder {
	int x;
	int y;
	boolean isFilled;
	
	public ChipHolder(int x, int y, boolean isFilled){
		this.x = x;
		this.y = y;
		this.isFilled = isFilled;
	}
	
	public void draw(Graphics g) {
		g.fillOval(x, y, 75, 75);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}
	
}

package connectFour;


	import java.awt.Dimension;

	import javax.swing.JFrame;
import javax.swing.JOptionPane;

	public class ConnectFour {
		JFrame frame = new JFrame();
		static final int width = 800;
		static final int length = 800;
		GamePanel panel = new GamePanel();
		

		ConnectFour() {

		}

		void setup() {
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setPreferredSize(new Dimension(width, length));
			
			frame.add(panel);
			frame.pack();
		}

		public static void main(String[] args) {
			ConnectFour connect = new ConnectFour();
			JOptionPane.showMessageDialog(null, "Click the top row of a column for a chip to place!");
			connect.setup();
		}
	}


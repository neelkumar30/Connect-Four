package connectFour;


	import java.awt.Dimension;

	import javax.swing.JFrame;

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
			frame.pack();
			frame.add(panel);
			
		}

		public static void main(String[] args) {
			ConnectFour connect = new ConnectFour();
			connect.setup();
		}
	}


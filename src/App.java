import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Mainframe mainframe = new Mainframe("Hello World! - Swing07b");
			}
		});
	}
}

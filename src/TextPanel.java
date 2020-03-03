import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 * This method implements a custom "TextPanel" object that is just a JTextArea
 * wrapped in a JScrollPane.
 *
 */

//Note the way that TextPanel extends JPanel....so this means that anything
//that JPanel can do, so can TextPanel (unless TextPanel overrides that somehow.
public class TextPanel extends JPanel {
	private JTextArea textArea;

	public TextPanel() {
		textArea = new JTextArea();

		setLayout(new BorderLayout());
		// Using CENTER will make it consume the entire TextPanel (because
		// there's nothing defined NSE or W of it.
		//
		// Also the entire textArea will be surrounded by a scroll pane which
		// will help if H or V scrollbars are needed.
		// So if this widget appears on the screen and enough text is entered to
		// overflow the H or V size, then H or V scrollbars will appear by
		// magic! And even resizing the window will make them appear/dissappear
		// as needed.
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void append(String str) {
		textArea.append(str);
	}
}

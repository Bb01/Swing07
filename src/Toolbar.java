import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {
	private JButton buttonA;
	private JButton buttonB;
	private LinkedList<Listener> listOfListeners;

	public Toolbar() {
		buttonA = new JButton("ButtonA");
		buttonB = new JButton("ButtonB");

		buttonA.addActionListener(this);
		buttonB.addActionListener(this);

		listOfListeners = new LinkedList<>();

		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(buttonA);
		add(buttonB);
	}

	public void addListener(Listener listener) {
		listOfListeners.add(listener);
	}

	/*
	 * So here we can see that this is where the ActionListener for the Toolbar
	 * is implemented. Within it, the Listener object(s) are invoked.
	 * 
	 * In this example they are just sending a string back, but in theory, this
	 * could be a JSON object, which allows complex data to be sent to the
	 * Listener.
	 * 
	 * Yes this implementation could be reduced/simplified further, but in real
	 * life that may not always be the case; different amounts/types of data
	 * could be sent to Listeners depending upon which component in the Toolbar
	 * is actioned.
	 */
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();

		if (clicked == buttonA) {
			Iterator<Listener> iterate = listOfListeners.iterator();
			while (iterate.hasNext()) {
				iterate.next().hearThis("Button A");
			}
		} else if (clicked == buttonB) {
			Iterator<Listener> iterate = listOfListeners.iterator();
			while (iterate.hasNext()) {
				iterate.next().hearThis("Button B");
			}
		} else {
			System.out.println("Something weird called this method!");
		}
	}
}

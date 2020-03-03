import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * The important thing to get from this example is that there is communication
 * going on between components and that communication is happening DIRECTLY
 * between components (eg the toolbar knows about the textPanel).
 * 
 * For an application of just a few components, this is not a major issue, but
 * GUIs get complicated very quickly and if they continue like this, there will
 * be lots of communication going on directly between components. This makes it
 * hard to maintain and debug.
 * 
 * A better way is to have all components communicate with each other INDIRECTLY
 * via the mainframe. The mainframe acts as a switch/controller of the flow of
 * communication between GUI components. This means that any person walking up
 * to the code, would know to look at the mainframe to see what is communicating
 * with what. This allows GUIs to be scaled up dramatically. In principle, one
 * wants all the components to be as independent of each other as possible.
 * Component A does not need to know about Components B, D, W & Z! This is known
 * as loose coupling between components.
 * 
 * @author brian.breathnach
 *
 */

public class Mainframe extends JFrame {
	private TextPanel textPanel;
	private Toolbar toolbar;

	public Mainframe(String title) {
		super(title);

		textPanel = new TextPanel();
		toolbar = new Toolbar();

		/*
		 * Here we tell the Toolbar object the object that is listening. We can
		 * see that the latter is implemented as an anonymous class, which has
		 * just the one method.
		 * 
		 * In this arrangement, instead of having just the one Listener, the
		 * Toolbar allows multiple Listeners to be registered. So should some
		 * event happen in the Toolbar, then that in turn will cause multiple
		 * Listener objects to be invoked.
		 * 
		 * In this case, the mainframe updates the same TextPanel object with
		 * multiple messages, but it could just as easily be setup so that
		 * multiple other widgets in the GUI are updated.
		 */
		toolbar.addListener(new Listener() {
			public void hearThis(String str) {
				textPanel.append(str + "\n");
			}
		});
		
		toolbar.addListener(new Listener() {
			public void hearThis(String str) {
				textPanel.append(str + "SecondListener\n");
			}
		});

		setLayout(new BorderLayout());

		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);

		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

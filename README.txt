In this example, we look at a better way to communicate between Swing GUI components.
In the previous one (Swing06), the custom widget "Toolbar" knew about the "Textpanel" and invoked a method directly on the Textpanel to append some text to it when a button was clicked.
In general, this is a bad thing.
The coupling between the TextPpanel and the Toolbar is "tight".
The Toolbar knows there is a method on the Textpanel called "append()" which allowed text to be added.
If the Toolbar needed to interact with other widgets, it would need to know what methods to invoke....and this can get very messy very quickly as the GUI grows.

So what we do is define a "thing", an Interface, that has certain methods, that can be invoked (listeners).
We get the mainframe to create an instance of that interface.
We pass a reference to that interface object into the Toolbar.
When the Toolbar has anything to communicate, it invokes a method on that thing/interface/listening object within the Mainframe.
The Mainframe can then process the incoming messages as needed.   

Made a small change on Bb Toshiba
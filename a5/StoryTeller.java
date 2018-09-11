/*
	This file uses the GUI_Demo to show studnets how to create an GUI that can be used in a application.
*/
import java.awt.event.*;

public class StoryTeller{
	GUI_Demo SDGUI = new GUI_Demo();			// creating the SDGUI as the GUI_Demo class
	int CurrentStoryPoint = 0;								// this controles what question you are on
	String UserName = new String();					// keeping track of the users name
	String UserFavColor = new String();				// keeping track of the users favorite color
	
	public static void main(String args[]) {
		new StoryTeller();
	}
	
	// constructor for this class, buids the gui, adds a listener and kicks off the story teller.
	public StoryTeller() {
		SDGUI.ConstructGUI();
		
		// problem here because references object directly
		SDGUI.user_input.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER)  {
					StoryLogic() ;
				}
			}
		});
		StoryLogic() ;
	}
	
	public void StoryLogic() {
  // put your code here...
		
	}
	
}

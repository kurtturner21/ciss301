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
		if (CurrentStoryPoint == 0){
			SDGUI.PrependToTextArea("Hello, my make is Bob.\nWhat is your name?\n");
			CurrentStoryPoint = 1;
		}

		else if (CurrentStoryPoint == 1){
			UserName = SDGUI.getUserText();
			SDGUI.PrependToTextArea("Okay '" + UserName + "', what is your favorite color?\n");
			SDGUI.setUserText("");
			CurrentStoryPoint = 2;
		}

		else if (CurrentStoryPoint == 2){
			UserFavColor = SDGUI.getUserText();
			SDGUI.PrependToTextArea(UserName  + ", I don't like " + UserFavColor 
				+ "', green is much better.\n");
			SDGUI.PrependToTextArea("Type 'good bye' to quit.\n");
			SDGUI.setUserText("");
			CurrentStoryPoint = 3;
		}
		
		else if (CurrentStoryPoint == 3 && new String("good bye").equals(SDGUI.getUserText())){
			System.exit(1);
		}
		
	}
	
}

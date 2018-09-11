/*
	2018 08 09 -  JKT
	This is a demo of how to create a GUI using Java Swing, 
	see page 548 for an example. 
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class GUI_Demo extends JFrame{
	
	JFrame jf = new JFrame("My GUI Demo");
	JTextField user_input = new JTextField();
	JTextArea messages = new JTextArea();
	JScrollPane messagesScroller = new JScrollPane(messages);
	
	public void ConstructGUI() {
		// this is the jframe to place stuff
		jf.setLayout(null);
		jf.setSize(500,400);
		jf.setLocation(2000,300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// create a border for user by swingx objects
		Border bl_border = BorderFactory.createLineBorder(Color.blue);
		Border re_border = BorderFactory.createLineBorder(Color.red);
		
		// text box for imput
		user_input.setBounds(10,10,480,25);
		user_input.setBorder(bl_border);
		jf.add(user_input);
		
		// add a text area for displaying info
		messages.setEditable(false);
		messagesScroller.setBorder(re_border);
		messagesScroller.setBounds(10, 50, 480, 270);
		jf.add(messagesScroller);
		
		// make it known
		jf.setVisible(true);
	}	
	
	// Add to the scolling text area
	public void PrependToTextArea(String newMessage) {
		messages.setText(newMessage + "\n" + messages.getText());
	}
	
	public void setUserText(String userText) {
		user_input.setText(userText);
	}
	
	public String getUserText() {
		return user_input.getText();
	}
}

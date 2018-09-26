/*
	2018 09 25 -  JKT
	This is a demo of how to create a GUI using Java Swing for assignment 5.
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cswing extends JFrame{

	int but_width = 70;
	JLabel lab_user_message = new JLabel();
	JButton btn_blue = new JButton("blue");
	JButton btn_red = new JButton("red");
	
	// override constructor
	public cswing(){
		
		JFrame f = new JFrame("a5 Example");
		f.setSize(400,200);
		f.setLocation(2100,200);
		f.setLayout(null);
		f.setResizable(false);
		// f.setLocationRelativeTo(null); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonListener listener = new ButtonListener();
		
		btn_blue.setBounds(10,10,but_width,50);
		btn_blue.addActionListener(listener);
		f.add(btn_blue);		
		
		btn_red.setBounds(80,10,but_width,50);
		btn_red.addActionListener(listener);
		f.add(btn_red);
		
		lab_user_message.setBounds(10, 70, 100, 20);
		lab_user_message.setForeground(Color.red);
		lab_user_message.setText(" --- ");
		f.add(lab_user_message);
		
		f.setVisible(true); 
	
	}
	
	public static void main(String args[]) {
		new cswing();
	}
	
	
		// let's get the clicks.
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btn_blue) {
				lab_user_message.setText("blue");
				lab_user_message.setForeground(Color.blue);
			} 	else if (e.getSource() == btn_red) {
				lab_user_message.setText("red");
				lab_user_message.setForeground(Color.red);
			} 
		}
	}
	
}

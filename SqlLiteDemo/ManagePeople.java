import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* 
Example on how to run with a jar file in your class path
D:\work\ciss301\SqlLite>javac ManagePeople.java
D:\work\ciss301\SqlLite>java -classpath ".;sqlite-jdbc-3.20.0.jar" ManagePeople
*/


public class ManagePeople extends JFrame{
	String firstNumberString = "";
	UsersDB UDB = new UsersDB();

	
	// override constructor
	public ManagePeople(){
		JFrame f = new JFrame("Button Example");
		f.setSize(400,500);
		f.setLayout(null);
		f.setResizable(false);
		f.setLocationRelativeTo(null); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// UDB.addDataToPeopleTable("Bob", 43, "123 Any St.", "Cleveland", "TN", "37320", 43000.25);
		// UDB.addDataToPeopleTable("Sandy", 25, "400 North Lee Hwy", "Cleveland", "TN", "37317", 16700.12);
		// UDB.addDataToPeopleTable("April", 49, "10 You Know It Drive", "Greensboro", "NC", "27012", 82000.00);
		f.setVisible(true);  
	}
	
	// so simple
	public static void main(String args[]) {
		new ManagePeople();
	}

}
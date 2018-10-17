import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;


public class SalesGUI extends JFrame {

	// States
	String arrStates[] = { "FL", "NC", "SC", "TN", "GA", "AL", "KY", "VA" };
	
	// Form objects
	JLabel customerBanner = new JLabel();
	JLabel salesBanner = new JLabel();
	JLabel customerCount = new JLabel();
	JLabel salesCount = new JLabel();
	JLabel statusBar = new JLabel();
	
	JTextField customerName = new JTextField(50);
	JTextField customerAddress = new JTextField(50);
	JTextField customerCity = new JTextField(50);
	JComboBox<String> customerState = new JComboBox<String>(arrStates);
	JTextField customerZip = new JTextField(15);
	
	// let's make some buttons
	
	JButton prevBut = new JButton("Prev");
	JButton nextBut = new JButton("Next");
	JButton editBut = new JButton("E");
	JButton addBut = new JButton("A");
	JButton deleteBut = new JButton("D");
	JButton saveBut = new JButton("S");
	JButton cancelBut = new JButton("C");
	
	JTextArea eventLog = new JTextArea();
	JScrollPane eventLogScroller = new JScrollPane(eventLog);
	
	// creates form
	JFrame f = new JFrame("Sales Express");
	
	// post the labels to the jframe
	// https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html
	Color ltblue = new Color(191, 215, 252);
	
	public void ConstructGUI(){
		customerBanner.setBounds(10, 5, 335, 40);
		customerBanner.setOpaque(true);
		customerBanner.setForeground(Color.BLACK);
		customerBanner.setBackground(ltblue);
		customerBanner.setHorizontalAlignment(JLabel.CENTER);
		customerBanner.setVerticalAlignment(JLabel.CENTER);
		customerBanner.setFont(new Font("Serif", Font.PLAIN, 16));
		customerBanner.setText("CUSTOMERS");
		f.add(customerBanner);
		
		salesBanner.setBounds(355, 5, 335, 40);
		salesBanner.setOpaque(true);
		salesBanner.setForeground(Color.BLACK);
		salesBanner.setBackground(ltblue);
		salesBanner.setHorizontalAlignment(JLabel.CENTER);
		salesBanner.setVerticalAlignment(JLabel.CENTER);
		salesBanner.setFont(new Font("Serif", Font.PLAIN, 16));
		salesBanner.setText("SALES TO CUSTOMER");
		f.add(salesBanner);
		
		salesCount.setBounds(522, 183, 40, 20);
		salesCount.setForeground(Color.black);
		salesCount.setText("$1000 w/ 5 orders");
		salesCount.setFont(new Font("Serif", Font.PLAIN, 12));
		f.add(salesCount);
		
		statusBar.setBounds(10, 495, 680, 20);
		statusBar.setOpaque(true);
		statusBar.setForeground(Color.black);
		statusBar.setBackground(Color.orange);
		statusBar.setFont(new Font("Serif", Font.PLAIN, 10));
		statusBar.setText("Application Bar");
		f.add(statusBar);	
		
		//eventLog.setBounds(10, 220, 680, 270);
		eventLog.setOpaque(true);
		eventLog.setForeground(Color.black);
		eventLog.setBackground(Color.white);
		eventLog.setFont(new Font("Serif", Font.PLAIN, 12));
		eventLog.setText("EVENTS.");
		//f.add(eventLog);
		
		eventLogScroller.setBounds(10, 220, 680, 270);
		f.add(eventLogScroller);
		
		customerName.setText("Mr. Kurt Turner");
		customerName.setBackground(Color.white);
		customerName.setEditable(false);
		customerName.setBorder(BorderFactory.createCompoundBorder(customerName.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		customerName.setFont(new Font("Serif", Font.PLAIN, 16));
		customerName.setBounds(10, 50, 335, 40);
		f.add(customerName);
		
		customerAddress.setText("1120 Ocoee Street");
		customerAddress.setBackground(Color.white);
		customerAddress.setEditable(false);
		customerAddress.setBorder(BorderFactory.createCompoundBorder(customerAddress.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		customerAddress.setFont(new Font("Serif", Font.PLAIN, 16));
		customerAddress.setBounds(10, 95, 335, 40);
		f.add(customerAddress);
		
		customerCity.setText("Cleveland");
		customerCity.setBackground(Color.white);
		customerCity.setEditable(false);
		customerCity.setBorder(BorderFactory.createCompoundBorder(customerCity.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		customerCity.setFont(new Font("Serif", Font.PLAIN, 16));
		customerCity.setBounds(10, 140, 180, 40);
		f.add(customerCity);
		
		customerState.setFont(new Font("Serif", Font.PLAIN, 16));
		customerState.setBackground(Color.white);
		customerState.setEditable(false);
		customerState.setEnabled(false);
		// customerState.setBorder(BorderFactory.createCompoundBorder(customerState.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		customerState.setBounds(198, 140, 56, 40);
		f.add(customerState);
		
		customerZip.setText("37320");
		customerZip.setBackground(Color.white);
		customerZip.setEditable(false);
		customerZip.setBorder(BorderFactory.createCompoundBorder(customerZip.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		customerZip.setFont(new Font("Serif", Font.PLAIN, 16));
		customerZip.setBounds(260, 140, 85, 40);
		f.add(customerZip);
		
		// We have BUTTONS!!!!!!!!
		int y_but_line = 183;
		int x_but_start = 10;
		int but_font_size = 11;
		int but_height = 30;
		prevBut.setBounds(x_but_start, y_but_line, 80, but_height);
		prevBut.setBackground(Color.lightGray);
		prevBut.setForeground(Color.blue);
		prevBut.setMargin(new Insets(0, 0, 0, 0));
		prevBut.setFont(new Font("Serif", Font.BOLD, but_font_size));
		nextBut.setToolTipText("Previous customer record.");
		f.add(prevBut);	
				
		customerCount.setBounds(x_but_start + 95, y_but_line, 40, but_height);
		customerCount.setForeground(Color.black);
		customerCount.setText("...");
		customerCount.setFont(new Font("Serif", Font.PLAIN, but_font_size + 1));
		customerCount.setToolTipText("This is the position in the range of customer records.");
		f.add(customerCount);
		
		nextBut.setBounds(x_but_start + 135, y_but_line, 80, but_height);
		nextBut.setBackground(Color.lightGray);
		nextBut.setForeground(Color.blue);
		nextBut.setMargin(new Insets(0, 0, 0, 0));
		nextBut.setFont(new Font("Serif", Font.BOLD, but_font_size));
		nextBut.setToolTipText("Next customer record.");
		f.add(nextBut);	
		
		editBut.setBounds(x_but_start + 215, y_but_line, 40, but_height);
		editBut.setBackground(new Color(189, 249, 220));
		editBut.setForeground(Color.black);
		editBut.setMargin(new Insets(0, 0, 0, 0));
		editBut.setFont(new Font("Serif", Font.BOLD, but_font_size));
		editBut.setToolTipText("Edit the selected customer record.");
		f.add(editBut);		
		
		// hidden set
		saveBut.setBounds(x_but_start + 215, y_but_line, 40, but_height);
		saveBut.setBackground(new Color(214, 249, 202));
		saveBut.setForeground(Color.black);
		saveBut.setMargin(new Insets(0, 0, 0, 0));
		saveBut.setFont(new Font("Serif", Font.BOLD, but_font_size));
		saveBut.setVisible(false);
		saveBut.setToolTipText("Save customer record.");
		f.add(saveBut);	

		addBut.setBounds(x_but_start + 255, y_but_line, 40, but_height);
		addBut.setBackground(new Color(189, 218, 249));
		addBut.setForeground(Color.black);
		addBut.setMargin(new Insets(0, 0, 0, 0));
		addBut.setFont(new Font("Serif", Font.BOLD, but_font_size));
		addBut.setToolTipText("Add a new customer record.");
		f.add(addBut);		

		// hidden set
		cancelBut.setBounds(x_but_start + 255, y_but_line, 40, but_height);
		cancelBut.setBackground(new Color(247, 228, 136));
		cancelBut.setForeground(Color.black);
		cancelBut.setMargin(new Insets(0, 0, 0, 0));
		cancelBut.setFont(new Font("Serif", Font.BOLD, but_font_size));
		cancelBut.setVisible(false);
		cancelBut.setToolTipText("Cancel any customer record changes.");
		f.add(cancelBut);		
		
		deleteBut.setBounds(x_but_start + 295, y_but_line, 40, but_height);
		deleteBut.setBackground(Color.pink);
		deleteBut.setForeground(Color.black);
		deleteBut.setMargin(new Insets(0, 0, 0, 0));
		deleteBut.setFont(new Font("Serif", Font.BOLD, but_font_size));
		deleteBut.setToolTipText("Delete the selected  customer record.");
		f.add(deleteBut);	


		f.setSize(700,550);
		f.setLayout(null);
		f.setResizable(false);
		//f.setLocationRelativeTo(null); 
		f.setLocation(300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);  
	}
	
	// This can be called to display text to the user...
	public void AddToEvents(String msg){
		String existingText = eventLog.getText();
		eventLog.setText(msg + "\n" + existingText);
		// eventLogScroller.getVerticalScrollBar().setValue(0);  // this does not work!!!
	}
	
	
	/* /////////////////////////////////
	Customer table functions. 
	 /////////////////////////////////  */

	public void setMyStateComboBox(String StateCode){
		int statepos = 0;
		for(String state: arrStates){
			if (customerState.getItemAt(statepos).toString().equals(StateCode)) {
				// AddToEvents("setMyStateComboBox: " + statepos + " " + state+ " " + StateCode);
				customerState.setSelectedIndex(statepos);		
			}
			statepos++;
		}
	}
	
	public String GetSelectedState(){
		AddToEvents("GetSelectedState: " + customerState.getSelectedItem().toString());
		return customerState.getSelectedItem().toString();
	}
	
	public void toggleCustomerFieldsEditable(Boolean bstate){
		AddToEvents("toggleCustomerFieldsEditable: " + bstate);
		customerName.setEditable(bstate);
		customerAddress.setEditable(bstate);
		customerCity.setEditable(bstate);
		customerState.setEnabled(bstate);
		customerZip.setEditable(bstate);
	}	
	
	public void toggleCustomerButtonsVisible(Boolean bstate){
		AddToEvents("toggleCustomerButtonsVisible: " + bstate);
		addBut.setVisible(bstate);
		editBut.setVisible(bstate);
		deleteBut.setVisible(bstate);
		nextBut.setVisible(bstate);
		prevBut.setVisible(bstate);
		if (bstate == true) {bstate = false;}
		else {bstate = true;}
		saveBut.setVisible(bstate);
		cancelBut.setVisible(bstate);
	}	
	
	public void clearCustomerFieldsBoolean(){
		AddToEvents("clearCustomerFieldsBoolean: ");
		customerName.setText("");
		customerAddress.setText("");
		customerCity.setText("");
		customerZip.setText("");
	}
	
	public int deleteLogic(){
		// https://www.mkyong.com/swing/java-swing-how-to-make-a-confirmation-dialog/
		// 0=yes, 1=no, 2=cancel
		int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Warning", JOptionPane.YES_NO_OPTION);
		return dialogResult;
	}
	
	public Boolean validateCustomerForm(){
		Boolean isValidated = false;
		if (customerName.getText().equals("")){
			AddToEvents("validateCustomerForm: SORRY!!! customerName must have some value");
		} else if (customerAddress.getText().equals("")) {
			AddToEvents("validateCustomerForm: SORRY!!! customerAddress must have some value");
		} else if (customerCity.getText().equals("")) {
			AddToEvents("validateCustomerForm: SORRY!!! customerCity must have some value");
		} else if (customerZip.getText().equals("")) {
			AddToEvents("validateCustomerForm: SORRY!!! customerZip must have some value");
		} else {
			isValidated = true;
		}
		return isValidated;
	}
	
	
}
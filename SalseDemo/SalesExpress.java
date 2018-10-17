import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/* 
Example on how to run with a jar file in your class path
>javac SalesExpress.java
>java -classpath ".;sqlite-jdbc-3.20.0.jar" SalesExpress
*/


public class SalesExpress{
	SalesDB SDB = new SalesDB();						// Creates DB Object
	SalesGUI SGUID = new SalesGUI();					// Make GUI Object
	ButtonListener listener = new ButtonListener();		// Create BUTT Listener Object
	
	// Customer vars
	int CustomerCount;
	int CustomerPosition; 
	int CustomerFormState = 0;  // 0 standard, 1 add, 2 edit
	ArrayList<Integer> CustomerIds = new ArrayList<Integer>();
	
	public static void main(String args[]) {
		new SalesExpress();
	}
	
	
	// This is the method that will be called by main
	public SalesExpress(){
		// connect to db
		SDB.connectDB();
		SDB.createTables();
		
		// make gui
		SGUID.ConstructGUI();
		// SGUID.customerCount.setText(currentCustomer + "");
		
		// Listeners
		SGUID.editBut.addActionListener(listener);
		SGUID.addBut.addActionListener(listener);
		SGUID.deleteBut.addActionListener(listener);
		SGUID.nextBut.addActionListener(listener);
		SGUID.prevBut.addActionListener(listener);
		SGUID.saveBut.addActionListener(listener);
		SGUID.cancelBut.addActionListener(listener);
		
		
		CustomerCount = SDB.getCustomerCount();
		CustomerIds = SDB.getCustomerIds();
		CustomerPosition = 0;
		RefreshCustomerForm();		
	}
	
	// let's get the clicks.
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == SGUID.editBut) {
				CustomerFormState = 2;  // 0 standard, 1 add, 2 edit
				SGUID.toggleCustomerFieldsEditable(true);
				SGUID.toggleCustomerButtonsVisible(false);
				SGUID.statusBar.setText("edit");
			} else if (e.getSource() == SGUID.addBut) {
				CustomerFormState = 1;  // 0 standard, 1 add, 2 edit
				SGUID.toggleCustomerFieldsEditable(true);
				SGUID.toggleCustomerButtonsVisible(false);
				SGUID.clearCustomerFieldsBoolean();
				SGUID.statusBar.setText("add");
			} else if (e.getSource() == SGUID.deleteBut) {
				// 0=yes, 1=no, 2=cancel
				int deleteconfirm = SGUID.deleteLogic();
				if (deleteconfirm == 0){
					SGUID.AddToEvents("deleteconfirm was confirmed with CustomerPosition of: " + CustomerPosition);
					SDB.deleteCustomerRecord(CustomerIds.get(CustomerPosition));
					SGUID.statusBar.setText("delete");
					CustomerCount = SDB.getCustomerCount();
					CustomerIds = SDB.getCustomerIds();
					PrevCustomer();						
				}
			} else if (e.getSource() == SGUID.nextBut) {
				NextCustomer();
			} else if (e.getSource() == SGUID.prevBut) {
				PrevCustomer();
			} else if (e.getSource() == SGUID.saveBut) {
				Boolean isCustomerValidated = SGUID.validateCustomerForm();
				if (isCustomerValidated == true) {
					if (CustomerFormState == 1){
						gatherAndAddCustomer();
						CustomerCount = SDB.getCustomerCount();
						CustomerIds = SDB.getCustomerIds();
						NextCustomer();	
					} else if (CustomerFormState == 2) {
						gatherAndEditCustomer();
					}
					RefreshCustomerForm();
				}
			} else if (e.getSource() == SGUID.cancelBut) {
				RefreshCustomerForm();
			}
		}
	}
	

	/* /////////////////////////////////
	Customer data functions. 
	/////////////////////////////////  */

	private void gatherAndAddCustomer(){
		String custName = SGUID.customerName.getText();
		String custAdd = SGUID.customerAddress.getText();
		String custCity = SGUID.customerCity.getText();
		String custState = SGUID.GetSelectedState();		// custom function
		String custZip = SGUID.customerZip.getText();
		SGUID.AddToEvents("");
		SGUID.AddToEvents("gatherAndAddCustomer customerName: " + custName);
		SGUID.AddToEvents("gatherAndAddCustomer customerAddress: " + custAdd);
		SGUID.AddToEvents("gatherAndAddCustomer customerCity: " + custCity);
		SGUID.AddToEvents("gatherAndAddCustomer customerState: " + custState);
		SGUID.AddToEvents("gatherAndAddCustomer customerZip: " + custZip);
		SGUID.AddToEvents("");
		SDB.addCustomer(custName, custAdd, custCity, custState, custZip);
	}
	
	private void gatherAndEditCustomer(){
		String custName = SGUID.customerName.getText();
		String custAdd = SGUID.customerAddress.getText();
		String custCity = SGUID.customerCity.getText();
		String custState = SGUID.GetSelectedState();		// custom function
		String custZip = SGUID.customerZip.getText();
		SGUID.AddToEvents("");
		SGUID.AddToEvents("gatherAndEditCustomer was called with neededCustomerId of: " + CustomerPosition);
		SGUID.AddToEvents("gatherAndEditCustomer id: " + CustomerIds.get(CustomerPosition));
		SGUID.AddToEvents("gatherAndEditCustomer customerName: " + custName);
		SGUID.AddToEvents("gatherAndEditCustomer customerAddress: " + custAdd);
		SGUID.AddToEvents("gatherAndEditCustomer customerCity: " + custCity);
		SGUID.AddToEvents("gatherAndEditCustomer customerState: " + custState);
		SGUID.AddToEvents("gatherAndEditCustomer customerZip: " + custZip);
		SGUID.AddToEvents("");
		SDB.updateCustomer(custName, custAdd, custCity, custState, custZip, CustomerIds.get(CustomerPosition));
	}
	
	private void popCustomerData(int neededCustomerId){
		SGUID.AddToEvents("popCustomerData was called with neededCustomerId of: " + neededCustomerId);
		String[] CustomerData = SDB.getCustomerRecord(neededCustomerId);
		SGUID.customerName.setText(CustomerData[0]);
		SGUID.customerAddress.setText(CustomerData[1]);
		SGUID.customerCity.setText(CustomerData[2]);
		SGUID.setMyStateComboBox(CustomerData[3]);		// custom function
		SGUID.customerZip.setText(CustomerData[4]);
		//  SGUID.customerPhone.setText(CustomerData[0]);
	}
	
	private void NextCustomer(){
		if (CustomerPosition + 1 < CustomerIds.size()){
			CustomerPosition++;
		}
		RefreshCustomerForm();
	}
	
	private void PrevCustomer(){
		if (CustomerPosition > 0){
			CustomerPosition--;
		}
		RefreshCustomerForm();
	}
	
	private void RefreshCustomerForm(){
		CustomerFormState = 0;  // 0 standard, 1 add, 2 edit
		SGUID.AddToEvents("RefreshCustomerForm: " + CustomerPosition + " " + CustomerIds.size());
		if (CustomerIds.size() > 0){
			popCustomerData(CustomerIds.get(CustomerPosition));
			UpdateCustomerCount();
		} else {
			SGUID.clearCustomerFieldsBoolean();
		}
		if (SGUID.customerName.isEditable() == true){
			SGUID.toggleCustomerFieldsEditable(false);
			SGUID.toggleCustomerButtonsVisible(true);
		}
	}	
	
	private void UpdateCustomerCount(){
		// This is for the little jlabel between the buttons. 
		SGUID.customerCount.setText(CustomerPosition + 1 + " / " + CustomerIds.size());
	}
	
	
}
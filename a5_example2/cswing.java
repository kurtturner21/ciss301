import java.awt.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// https://tips4java.wordpress.com/2009/06/14/moving-windows/
// http://www.otherwise.com/Lessons/ColorsInJava.html

public class cswing extends JFrame{
	
	String firstNumberString = "";
	String secondNumberString = "";
	JLabel currentNum = new JLabel();
	JLabel operation = new JLabel();
	JLabel pos_x = new JLabel();
	JLabel pos_y = new JLabel();
	JLabel pos_cct = new JLabel();
	JButton b0 = new JButton("0");
	JButton b1 = new JButton("1");
	JButton b2 = new JButton("2");
	JButton b3 = new JButton("3");
	JButton b4 = new JButton("4");
	JButton b5 = new JButton("5");
	JButton b6 = new JButton("6");
	JButton b7 = new JButton("7");
	JButton b8 = new JButton("8");
	JButton b9 = new JButton("9");
	JButton orderButtons = new JButton("order");
	JButton chaosButtons = new JButton("chaos");
	JButton bc = new JButton("C");
	JButton bce = new JButton("CE");
	JButton beq = new JButton("CE");
	JButton[] allButtons = {b0, b1, b2, b3, b4, b5, b6, b7, b8, b9};
	int[] buttClicks = {0,0,0,0,0,0,0,0,0,0};
	
	// override constructor
	public cswing(){
		// set my JF
		JFrame f = new JFrame("Button Example");
		f.setSize(400,500);
		f.setLayout(null);
		f.setResizable(false);
		f.setLocationRelativeTo(null); 
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// my colored labels.
		Border border = BorderFactory.createLineBorder(Color.blue);
		currentNum.setBounds(200, 5, 100, 20);
		currentNum.setForeground(Color.black);
		currentNum.setFont(new Font("Serif", Font.BOLD, 14));
		currentNum.setBorder(border);
		currentNum.setText("0");
		f.add(currentNum);
		operation.setBounds(200, 30, 100, 20);
		operation.setForeground(Color.gray);
		operation.setFont(new Font("Serif", Font.PLAIN, 8));
		operation.setText("~");
		f.add(operation);
		pos_x.setBounds(10, 5, 100, 20);
		pos_x.setForeground(Color.red);
		pos_x.setText(" x: ");
		f.add(pos_x);
		pos_y.setBounds(10, 20, 100, 20);
		pos_y.setForeground(Color.blue);
		pos_y.setText(" y: ");
		f.add(pos_y);
		pos_cct.setBounds(10, 35, 300, 20);
		pos_cct.setForeground(new Color(79, 142, 124));
		pos_cct.setText("ct: ");
		f.add(pos_cct);

		// Listeners
		ButtonListener listener = new ButtonListener();
		DragListener drag = new DragListener();

		orderButtons.setBounds(0, 440, 60, 30);
		orderButtons.addActionListener(listener);
		orderButtons.setBackground(Color.lightGray);
		orderButtons.setForeground(Color.blue);
		orderButtons.setFont(new Font("Serif", Font.BOLD, 8));
		f.add(orderButtons);
		
		chaosButtons.setBounds(60, 440, 60, 30);
		chaosButtons.addActionListener(listener);
		chaosButtons.setBackground(Color.lightGray);
		chaosButtons.setForeground(Color.red);
		chaosButtons.setFont(new Font("Serif", Font.BOLD, 8));
		f.add(chaosButtons);	
		
		bc.setBounds(200, 440, 60, 30);
		bc.addActionListener(listener);
		bc.setFont(new Font("Serif", Font.BOLD, 8));
		f.add(bc);
		
		bce.setBounds(260, 440, 60, 30);
		bce.addActionListener(listener);
		bce.setFont(new Font("Serif", Font.BOLD, 8));
		f.add(bce);	
		
		beq.setBounds(320, 440, 60, 30);
		beq.addActionListener(listener);
		beq.setFont(new Font("Serif", Font.BOLD, 8));
		f.add(beq);
		
		// numbered butttons
		for(JButton tb : allButtons){
			tb.setBounds(20, 60, 100, 40);
			tb.addActionListener(listener);
			tb.addMouseListener(drag);
			tb.addMouseMotionListener(drag);
			f.add(tb);
		}
				
		f.setVisible(true);  
	}
	
	// so simple
	public static void main(String args[]) {
		new cswing();
	}
	
	
	// let's get the clicks.
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == b1) {
				numberPusher("1");
				buttClicks[1] += 1;
				pos_x.setText(" x: "+b1.getX());
				pos_y.setText(" y: "+b1.getY());
				pos_cct.setText("ct: "+ java.util.Arrays.toString(buttClicks));
			} else if (e.getSource() == b2) {
				numberPusher("2");
				buttClicks[2] += 1;
				pos_x.setText(" x: "+b2.getX());
				pos_y.setText(" y: "+b2.getY());
				pos_cct.setText("ct: "+ java.util.Arrays.toString(buttClicks));
			} else if (e.getSource() == b3) {
				numberPusher("3");
				buttClicks[3] += 1;
				pos_x.setText(" x: "+b3.getX());
				pos_y.setText(" y: "+b3.getY());
				pos_cct.setText("ct: "+ java.util.Arrays.toString(buttClicks));
			} else if (e.getSource() == b4) {
				numberPusher("4");
				buttClicks[4] += 1;
				pos_x.setText(" x: "+b4.getX());
				pos_y.setText(" y: "+b4.getY());
				pos_cct.setText("ct: "+ java.util.Arrays.toString(buttClicks));
			} else if (e.getSource() == b5) {
				numberPusher("5");
				buttClicks[5] += 1;
				pos_x.setText(" x: "+b5.getX());
				pos_y.setText(" y: "+b5.getY());
				pos_cct.setText("ct: "+ java.util.Arrays.toString(buttClicks));
			} else if (e.getSource() == b6) {
				numberPusher("6");
				buttClicks[6] += 1;
				pos_x.setText(" x: "+b6.getX());
				pos_y.setText(" y: "+b6.getY());
				pos_cct.setText("ct: "+ java.util.Arrays.toString(buttClicks));
			} else if (e.getSource() == b7) {
				numberPusher("7");
				buttClicks[7] += 1;
				pos_x.setText(" x: "+b7.getX());
				pos_y.setText(" y: "+b7.getY());
				pos_cct.setText("ct: "+ java.util.Arrays.toString(buttClicks));
			} else if (e.getSource() == b8) {
				firstNumberString += "8";
				currentNum.setText(firstNumberString);
				buttClicks[8] += 1;
				pos_x.setText(" x: "+b8.getX());
				pos_y.setText(" y: "+b8.getY());
				pos_cct.setText("ct: "+ java.util.Arrays.toString(buttClicks));
			}  else if (e.getSource() == b9) {
				numberPusher("9");
				buttClicks[9] += 1;
				pos_x.setText(" x: "+b9.getX());
				pos_y.setText(" y: "+b9.getY());
				pos_cct.setText("ct: "+ java.util.Arrays.toString(buttClicks));
			}  else if (e.getSource() == b0) {
				numberPusher("0");
				buttClicks[0] += 1;
				pos_x.setText(" x: "+b0.getX());
				pos_y.setText(" y: "+b0.getY());
				pos_cct.setText("ct: "+ java.util.Arrays.toString(buttClicks));
			} else if (e.getSource() == orderButtons) {
				makeSenseOfButtons();
			} else if (e.getSource() == chaosButtons) {
				makeChaosOfButtons();
			} else if (e.getSource() == bc) {
				clearAll();
			} else if (e.getSource() == bce) {
				clearEntry();
			} else if (e.getSource() == beq) {
				findTotal();
			}
		}
	}
	
	
	private void numberPusher(String buttonValue){
		if(buttonValue.equals("0")){
		firstNumberString += buttonValue;
		currentNum.setText(firstNumberString);
		}
	}

	private void clearEntry(){
		firstNumberString = "";
		currentNum.setText(firstNumberString);
	}
	
	private void clearAll(){
		firstNumberString = "";
		secondNumberString = "";
		currentNum.setText(firstNumberString);
		operation.setText("");
	}	
	
	private void findTotal(){
		firstNumberString = "x";
		secondNumberString = "x";
		currentNum.setText(firstNumberString);
		operation.setText("x");
	}
	
	
	// let's get the drags
	// does not have to change for each object
	class DragListener extends MouseInputAdapter
	{
		Point location;
		MouseEvent pressed;
	 
		public void mousePressed(MouseEvent me)
		{
			pressed = me;
		}
	 
		public void mouseDragged(MouseEvent me)
		{
			Component component = me.getComponent();
			location = component.getLocation(location);
			int x = location.x - pressed.getX() + me.getX();
			int y = location.y - pressed.getY() + me.getY();
			component.setLocation(x, y);
		 }
	}
	
	
	// Let's pop the numbered buttons to attention
	public void makeSenseOfButtons() {
		int count = 0;
		int row = 0;
		for(JButton tb : allButtons){
			count += 1;
			tb.setLocation(20 + (105 * (count - 1)), 80 + (45 * row));
			tb.setBackground(Color.gray);
			tb.setForeground(Color.black);
			if(count % 3 == 0) {
				count = 0;
				row += 1;
			}
		}
	}	
	
	// Let's dive the numbered buttons to chaos 
	public void makeChaosOfButtons() {
		for(JButton tb : allButtons){
			int x = randomWithRange(20, 290);
			int y = randomWithRange(60, 400);
			int fr = randomWithRange(0, 255);
			int fg = randomWithRange(0, 255);
			int fb = randomWithRange(0, 255);
			int br = randomWithRange(0, 255);
			int bg = randomWithRange(0, 255);
			int bb = randomWithRange(0, 255);
			tb.setBackground(new Color(br, bg, bb));
			tb.setForeground(new Color(fr, fg, fb));
			tb.setLocation(x, y);
		}
	}
	
	// found this on the internet
	// https://stackoverflow.com/questions/7961788/math-random-explained
	int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
}

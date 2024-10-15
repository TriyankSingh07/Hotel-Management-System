package Hotel;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class HotelManagementSystem_1 extends JFrame implements ActionListener{
	
	HotelManagementSystem_1(){
	
		 
		setBounds(100,100,1366,565);
		 setLayout(null);
		 
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("first.jpg"));
		 JLabel image = new JLabel(i1);
		 image.setBounds(0,0,1366,565);
		 add(image);
		 
		 JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		 text.setBounds(20,430,1000,90);
		 text.setForeground(Color.white);
		 text.setFont(new Font("serif",Font.PLAIN,50));
		 image.add(text);
		 
		 JButton next = new JButton("Next");
		 next.setBounds(1150,460,120,40);
		 next.setForeground(Color.black);
		 next.setBackground(Color.white);
		 next.addActionListener(this);
		 next.setFont(new Font("serif",Font.PLAIN,30));
		 image.add(next);
		
		 setVisible(true);
		 
		 while(true) {
			 text.setVisible(false);
			 try {
				 Thread.sleep(500);
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			 text.setVisible(true);
			 try {
				 Thread.sleep(500);
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		 }
		 
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Hotel_Login_2();
	}
	
	public static void main(String[] args) {
			new HotelManagementSystem_1();
	}

}

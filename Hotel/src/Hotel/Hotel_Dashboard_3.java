package Hotel;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class Hotel_Dashboard_3 extends JFrame implements ActionListener{
	
	Hotel_Dashboard_3(){
		
		setBounds(0,0,1550,1000);
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("third.jpg"));
		JLabel image = new JLabel(i1);
		add(image);
		
		JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
		text.setBounds(430,70,900,50);
		text.setFont(new Font("Raleway",Font.PLAIN,45));
		text.setForeground(Color.white);
		image.add(text);
		
		JMenuBar mb = new JMenuBar();
		mb.setBounds(0,0,1550,30);
		image.add(mb);
		
		JMenu hotel = new JMenu("HOTEL MANAGEMENT");
		hotel.setForeground(Color.red);
		mb.add(hotel);
		
		JMenuItem reception = new JMenuItem("RECEPTION");
		reception.addActionListener(this);
		hotel.add(reception);
		
		JMenu admin = new JMenu("ADMIN");
		admin.setForeground(Color.blue);
		mb.add(admin);
		
		JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
		addemployee.addActionListener(this);
		admin.add(addemployee);
		
		JMenuItem addrooms = new JMenuItem("ADD ROOMS");
		addrooms.addActionListener(this);
		admin.add(addrooms);
		
		JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
		adddrivers.addActionListener(this);
		admin.add(adddrivers);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("ADD EMPLOYEE")){
	new Hotel_AddEmployee();
		}
	
		else if (ae.getActionCommand().equals("ADD ROOMS")) {
			new AddRooms();
		}
		else if (ae.getActionCommand().equals("ADD DRIVERS")) {
			new AddDriver();
		}
		else if (ae.getActionCommand().equals("RECEPTION")) {
			new Reception();
		}
		
		
	}
	
	public static void main(String[] args) {
		 new Hotel_Dashboard_3();

	}

}

package Hotel;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
public class Reception  extends JFrame implements ActionListener{
	
	JButton newCustomer,logout,rooms,department,checkout,pickup,roomStatus,allEmployee,managerInfo,customer,update,searchRoom;
	
	Reception(){
		
		 newCustomer = new JButton("New Customer Form");
		newCustomer.setBounds(10,30,180,30);
		newCustomer.setBackground(Color.black);
		newCustomer.setForeground(Color.white);
		newCustomer.addActionListener(this);
		add(newCustomer);
		
		 rooms = new JButton("Rooms");
		rooms.setBounds(10,70,180,30);
		rooms.setBackground(Color.black);
		rooms.setForeground(Color.white);
		rooms.addActionListener(this);
		add(rooms);
		
		 department = new JButton("Department");
		department .setBounds(10,110,180,30);
		department .setBackground(Color.black);
		department .setForeground(Color.white);
		department.addActionListener(this);
		add(department );
		
		 allEmployee = new JButton("All Employees");
		allEmployee.setBounds(10,150,180,30);
		allEmployee.setBackground(Color.black);
		allEmployee.setForeground(Color.white);
		allEmployee.addActionListener(this);
		add(allEmployee);
		
		 customer = new JButton("Customer Info");
		customer.setBounds(10,190,180,30);
		customer.setBackground(Color.black);
		customer.setForeground(Color.white);
		customer.addActionListener(this);
		add(customer);
		
		 managerInfo = new JButton("Manager Info");
		managerInfo.setBounds(10,230,180,30);
		managerInfo.setBackground(Color.black);
		managerInfo.setForeground(Color.white);
		managerInfo.addActionListener(this);
		add(managerInfo);
		
		 checkout = new JButton("Checkout");
		checkout.setBounds(10,270,180,30);
		checkout.setBackground(Color.black);
		checkout.setForeground(Color.white);
		checkout.addActionListener(this);
		add(checkout);
		
		  update = new JButton("Pending Status");
		update.setBounds(10,310,180,30);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.addActionListener(this);
		add(update);
		
		 roomStatus = new JButton("Update Room Status");
		roomStatus.setBounds(10,350,180,30);
	    roomStatus.setBackground(Color.black);
		roomStatus.setForeground(Color.white);
		roomStatus.addActionListener(this);
		add(roomStatus);
		
		 pickup = new JButton("Pickup Service");
		pickup.setBounds(10,390,180,30);
		pickup.setBackground(Color.black);
		pickup.setForeground(Color.white);
		pickup.addActionListener(this);
		add(pickup);
		
		 searchRoom = new JButton("Search Room");
		searchRoom.setBounds(10,430,180,30);
		searchRoom.setBackground(Color.black);
		searchRoom.setForeground(Color.white);
		searchRoom.addActionListener(this);
		add(searchRoom);
		
		 logout = new JButton("Logout");
		logout.setBounds(10,470,180,30);
		logout.setBackground(Color.black);
		logout.setForeground(Color.white);
		logout.addActionListener(this);
		add(logout);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(200, 30, 700, 470);
        add(image);
		
		
		setBounds(350,200,900,570);
		setLayout(null);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == newCustomer) {
			setVisible(false);
			new AddCustomer();
		}
		else if(ae.getSource() == rooms) {
			setVisible(false);
			new Room();
		}
		else if(ae.getSource() == department) {
			setVisible(false);
			new Department();
		}
		else if(ae.getSource() == allEmployee) {
			setVisible(false);
			new EmployeeInfo();
		}
		else if(ae.getSource() == managerInfo) {
			setVisible(false);
			new ManagerInfo();
		}
		else if(ae.getSource() == customer) {
			setVisible(false);
			new CustomerInfo();
		}
		else if(ae.getSource() == searchRoom) {
			setVisible(false);
			new SearchRoom();
		}
		else if(ae.getSource() == update) {
			setVisible(false);
			new UpdateCheck();
		}
		else if(ae.getSource() == roomStatus) {
			setVisible(false);
			new UpdateRoom();
		}
		else if(ae.getSource() == pickup) {
			setVisible(false);
			new Pickup();
		}
		else if(ae.getSource() == checkout) {
			setVisible(false);
			new Checkout();
		}
		else if(ae.getSource() == logout) {
			setVisible(false);
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		
		new Reception();

	}
}


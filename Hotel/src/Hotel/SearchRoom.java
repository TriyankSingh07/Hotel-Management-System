package Hotel;

import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {
	
	JTable table;
	JButton back,submit;
	JComboBox bedType;
	JCheckBox available;
	
	SearchRoom(){
		
		setLayout(null);
		
		JLabel text = new JLabel("Search for Room");
		text.setFont(new Font("Tahome",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
        bedType = new JComboBox(new String[] {"Single Bed","Double Bed"});
        bedType.setBounds(150,100,150,25);
        bedType.setBackground(Color.white);
        add(bedType);
        
        available = new JCheckBox("Only Display Available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.white);
        add(available);
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(50,160,100,40);
        add(l1);
        
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(270,160,100,40);
        add(l2);
        
        JLabel l3 = new JLabel(" Cleaning Status");
        l3.setBounds(450,160,100,40);
        add(l3);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(670,160,100,40);
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(870,160,100,40);
        add(l5);
		
		table = new JTable();
		table.setBounds(0,200,1000,300);
		add(table);
		
		try {
			
			Jdbc_con c = new Jdbc_con();
			ResultSet rs = c.smt.executeQuery("select * from room");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		submit = new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		submit.setBounds(300,520,120,30);
		add(submit);
		
		back = new JButton("Back");
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		back.setBounds(500,520,120,30);
		add(back);
		
        getContentPane().setBackground(Color.white);
		
		setBounds(300,200,1000,600);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== submit) {
			try {
				
				String query1="Select * from room where bed_type = '"+bedType.getSelectedItem()+"'";
				String query2= "Select * from room where availability = 'Available' AND bed_type = '"+bedType.getSelectedItem()+"'";		
				Jdbc_con c = new Jdbc_con();
				ResultSet rs;
				
				if(available.isSelected()) {
				rs = c.smt.executeQuery(query2);	
				}
				else {
					rs = c.smt.executeQuery(query1);
				}
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
		
		setVisible(false);
		new Reception();
		}	
	}

	public static void main(String[] args) {
		new SearchRoom();

	}

}

package Hotel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class  Hotel_Login_2 extends JFrame implements ActionListener {
	
	
	JTextField username;
	JPasswordField password;
	JButton login,cancel;
	
	Hotel_Login_2(){
		
		getContentPane().setBackground(Color.white);
		
		JLabel user = new JLabel("Username");
		user.setBounds(40,20,100,30);
		user.setFont(new Font("serif",Font.PLAIN,18));
		add(user);
		
		 username = new JTextField();
		username.setBounds(150,20,150,30);
		add(username);
		
		JLabel pass = new JLabel("Password");
		pass.setBounds(40,70,100,25);
		pass.setFont(new Font("serif",Font.PLAIN,18));
		add(pass);
		
		 password = new JPasswordField();
		password.setBounds(150,70,150,25);
		add(password);
		
		 login = new JButton("Login");
		login.setBounds(40,150,120,30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		 cancel = new JButton("Cancel");
		cancel.setBounds(180,150,120,30);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);		
		image.setBounds(350,10,200,200);
		add(image);
		
		setLayout(null);
		setBounds(500,300,600,300);
		 setVisible(true);
	}
	
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()== login) {
//				String user = username.getText();
//				String pass = password.getText();
				
				try {
					Jdbc_con c = new Jdbc_con();
					String user = username.getText();
					String pass = password.getText();
					String query = "select * from hotellogin where username = '" + user + "' and password = '" + pass + "' ";
					ResultSet rs =c.smt.executeQuery(query);
					
					if(rs.next()) {
						
						new Hotel_Dashboard_3().setVisible(true);
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null,"Invalid username or password");
						setVisible(false);
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
						
			}else if(ae.getSource()== cancel) {
				setVisible(false);
			}
		}

	public static void main(String[] args) {
		new Hotel_Login_2();
	}

}

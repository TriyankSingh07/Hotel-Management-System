package Hotel;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class Hotel_AddEmployee extends JFrame implements ActionListener {
    JTextField tfname, tfage, tfsalary, tfemail, tfphone, tfaadhar;
    JRadioButton rbmale, rbfemale;
    JButton submit;
    JComboBox<String> cbjob;

    Hotel_AddEmployee() {

        setLayout(null);

        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 30, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 30, 150, 30);
        add(tfname);

        JLabel lblage = new JLabel("AGE");
        lblage.setBounds(60, 80, 120, 30);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 80, 150, 30);
        add(tfage);

        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(60, 130, 120, 30);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200, 130, 70, 30);
        rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbmale.setBackground(Color.white);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280, 130, 70, 30);
        rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rbfemale.setBackground(Color.white);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbfemale);
        bg.add(rbmale);

        JLabel lbjob = new JLabel("JOB");
        lbjob.setBounds(60, 180, 120, 30);
        lbjob.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbjob);

        String str[] = { "Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Shefs",
                "Waiter/Waitress", "Manager", "Accountant" };
        cbjob = new JComboBox<String>(str);
        cbjob.setBounds(200, 180, 150, 30);
        cbjob.setBackground(Color.white);
        add(cbjob);

        JLabel lblsalary = new JLabel("SALARY");
        lblsalary.setBounds(60, 230, 120, 30);
        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(200, 230, 150, 30);
        add(tfsalary);

        JLabel lbLphone = new JLabel("PHONE");
        lbLphone.setBounds(60, 280, 120, 30);
        lbLphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lbLphone);

        tfphone = new JTextField();
        tfphone.setBounds(200, 280, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("EMAIL");
        lblemail.setBounds(60, 330, 120, 30);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 330, 150, 30);
        add(tfemail);

        JLabel lblaadhar = new JLabel("AADHAR");
        lblaadhar.setBounds(60, 380, 120, 30);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 380, 150, 30);
        add(tfaadhar);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200, 430, 150, 30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setBounds(350, 200, 850, 540);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();

        String gender = rbmale.isSelected() ? "Male" : "Female";
        String job = (String) cbjob.getSelectedItem();
        
        if (name.isEmpty()) { 
            JOptionPane.showMessageDialog(null, "Name should not be empty");
            return; // Exit the method
        }

        try {
            Jdbc_con c = new Jdbc_con();

            String query = "insert into hotelemployee values('" + name + "','" + age + "','" + gender + "','" + job
                    + "','" + salary + "','" + phone + "','" + email + "','" + aadhar + "')";

            c.smt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee added Successfully");
            setVisible(false);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new Hotel_AddEmployee();
    }

}

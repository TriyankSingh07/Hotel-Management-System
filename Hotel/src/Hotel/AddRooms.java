package Hotel;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener {

    JButton cancel, add;
    JTextField tfroom, tfprice;
    JComboBox<String> typecombo, availablecombo, cleancombo;

    AddRooms() {

        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(200, 20, 200, 20);
        add(heading);

        JLabel lblrooms = new JLabel("Room Number");
        lblrooms.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblrooms.setBounds(60, 80, 120, 30);
        add(lblrooms);

        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);

        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60, 130, 120, 30);
        add(lblavailable);

        String[] availableOptions = {"Available", "Occupied"};
        availablecombo = new JComboBox<>(availableOptions);
        availablecombo.setBounds(200, 130, 150, 30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblclean.setBounds(60, 180, 120, 30);
        add(lblclean);

        String[] cleanOptions = {"Cleaned", "Dirty"};
        cleancombo = new JComboBox<>(cleanOptions);
        cleancombo.setBounds(200, 180, 150, 30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);

        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblprice.setBounds(60, 230, 120, 30);
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);

        JLabel lbltype = new JLabel("Bed Type");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltype.setBounds(60, 280, 120, 30);
        add(lbltype);

        String[] typeOptions = {"Single Bed", "Double Bed"};
        typecombo = new JComboBox<>(typeOptions);
        typecombo.setBounds(200, 280, 150, 30);
        typecombo.setBackground(Color.WHITE);
        add(typecombo);

        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 350, 130, 30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel ");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 350, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 30, 500, 400);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(350, 200, 940, 540);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {

            String roomnumber = tfroom.getText();
            String availability = (String) availablecombo.getSelectedItem();
            String status = (String) cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String) typecombo.getSelectedItem();

            try {
                Jdbc_con c = new Jdbc_con();
                String str = "insert into room values ('" + roomnumber + "','" + availability + "','" + status + "','" + price + "','" + type + "')";
                c.smt.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Room Added Successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRooms();

    }

}

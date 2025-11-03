package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
     JTextField tfname, tfnationality, tfaadhar, tfaddress, tfphone; 
     JRadioButton rbmale, rbfemale;
        public AddCustomer()
        {
            
            getContentPane().setBackground(Color.lightGray);
            setLayout(null);
            
            JLabel Heading = new JLabel("ADD CUSTOMER DETAILS");
            Heading.setBounds(250,20,500,35);
            Heading.setFont(new Font("Tahoma", Font.BOLD,38));
            Heading.setForeground(Color.RED);
            add(Heading);
            
            JLabel lblname = new JLabel("NAME: ");
            lblname.setBounds(60,80,150,25);
            lblname.setFont(new Font("Tahoma", Font.PLAIN,17));
            add(lblname);
            
            tfname = new JTextField();
            tfname.setBounds(220,80,150,25);
            tfname.setBackground(Color.LIGHT_GRAY);
            add(tfname);
            
            JLabel lblnationality = new JLabel("NATIONALITY: ");
            lblnationality.setBounds(60,130,150,25);
            lblnationality.setFont(new Font("Tahoma", Font.PLAIN,17));
            add(lblnationality);
            
            tfnationality = new JTextField();
            tfnationality.setBounds(220,130,150,25);
            tfnationality.setBackground(Color.LIGHT_GRAY);
            add(tfnationality);
            
            JLabel lblaadhar = new JLabel("AADHAR NO. : ");
            lblaadhar.setBounds(60,180,150,25);
            lblaadhar.setFont(new Font("Tahoma", Font.PLAIN,17));
            add(lblaadhar);
            
            tfaadhar = new JTextField();
            tfaadhar.setBounds(220,180,150,25);
            tfaadhar.setBackground(Color.LIGHT_GRAY);
            add(tfaadhar);
            
            JLabel lbladdress = new JLabel("ADDRESS: ");
            lbladdress.setBounds(60,230,150,25);
            lbladdress.setFont(new Font("Tahoma", Font.PLAIN,17));
            add(lbladdress);
            
            tfaddress = new JTextField();
            tfaddress.setBounds(220,230,150,25);
            tfaddress.setBackground(Color.LIGHT_GRAY);
            add(tfaddress);
            
            JLabel lblgender = new JLabel("GENDER: ");
            lblgender.setBounds(60,280,150,25);
            lblgender.setFont(new Font("Tahoma", Font.PLAIN,17));
            add(lblgender);
            
            ButtonGroup gendergroup = new ButtonGroup();
            
            rbmale= new JRadioButton("Male");
            rbmale.setBounds(220,280,70,25);
            rbmale.setBackground(Color.LIGHT_GRAY);
            add(rbmale);
            gendergroup.add(rbmale);
            
            rbfemale= new JRadioButton("Female");
            rbfemale.setBounds(300,280,70,25);
            rbfemale.setBackground(Color.LIGHT_GRAY);
            add(rbfemale);
            gendergroup.add(rbfemale);
         
            JLabel lblphone= new JLabel("PHONE NO. : ");
            lblphone.setBounds(60,330,150,25);
            lblphone.setFont(new Font("Tahoma", Font.PLAIN,17));
            add(lblphone);
            
            tfphone = new JTextField();
            tfphone.setBounds(220,330,150,25);
            tfphone.setBackground(Color.LIGHT_GRAY);
            add(tfphone);
         
            JButton save = new JButton("SAVE");
            save.setBackground(Color.BLACK);
            save.setForeground(Color.WHITE);
            save.setBounds(120,380,150,30);
            save.addActionListener(this);
            add(save);
            
            ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
            JLabel lblimage = new JLabel(image);
            lblimage.setBounds(450,80,280,400);
            add(lblimage);
            
            setSize(900,600);
            setLocation(300,150);
            setVisible(true);
            
        }
        public void actionPerformed(ActionEvent ae)
        {   String name = tfname.getText();
            String nationality = tfnationality.getText();
            String phone = tfphone.getText();
            String address = tfaddress.getText();
            String aadhar= tfaadhar.getText();
            String gender = null;
            if(rbmale.isSelected()){
                gender="Male";
            }else {
                gender= "Female";
            }
            try{
                Conn conn= new Conn();
                String query = "Insert into Passenger values('"+name+"','"+nationality+"','"+phone+"','"+address+"','"+aadhar+"','"+gender+"')";
                conn.s.executeUpdate(query); 
                JOptionPane.showMessageDialog(null,"Customer Details Added Succcessfully");
                setVisible(false);



            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
public static void main(String[]args)
{
    new AddCustomer();
}
}

package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public  class Login extends JFrame implements ActionListener
        
{
    JButton Submit, reset, Close;
    JTextField tfusername;
    JPasswordField tfpassword;
    public Login()
    {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel lblusername = new JLabel("Username: ");
        lblusername.setBounds(20,20,100,20);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(130,20,200,20);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password: ");
        lblpassword.setBounds(20,40,100,20);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(130,40,200,20);
        add(tfpassword);
        
        reset = new JButton("Reset");
        reset.setBounds(40,90,120,20);
        reset.addActionListener(this);
        add(reset);
        
        Submit = new JButton("Submit");
        Submit.setBounds(190,90,120,20);
        Submit.addActionListener(this);
        add(Submit);
        
        Close = new JButton("Close");
        Close.setBounds(120,120,120,20);
        Close.addActionListener(this);
        add(Close);
        
        setSize(400,250);
        setLocation(400,220);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
     if(ae.getSource() == Submit ){
     String username = tfusername.getText();
     String password = tfpassword.getText();
     try{
       Conn c= new Conn();
       String query= "Select * from login where username='"+username+"' and password ='"+password+"'";
       ResultSet rs =c.s.executeQuery(query);
       if (rs.next())
       {
           new Home();
           setVisible(false);
       }
       else
       {
           JOptionPane.showMessageDialog(null,"Invalid username or password");
           setVisible(false);
       }
     }catch(Exception e)
     {
         e.printStackTrace();
     }
     
     }
     else if (ae.getSource()==Close){
     setVisible(false);
     }
     else if (ae.getSource()==reset){
         tfusername.setText("");
         tfpassword.setText("");
         
     }
         
    }
    public static void main(String[]args)
    {
       new Login();
    }
}

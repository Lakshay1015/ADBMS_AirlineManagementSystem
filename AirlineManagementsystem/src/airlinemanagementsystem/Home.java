package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public  class Home extends JFrame implements ActionListener
{
   
    public Home()
    {
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1400,750);
        add(image);
        
        JLabel heading = new JLabel ("LUFTHANSA WELCOMES YOU");
        heading.setBounds(350,40,1200,40);
        heading.setForeground(Color.RED);
        heading.setFont(new Font("Tahoma",Font.BOLD,42));
        image.add(heading);
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        JMenu details = new JMenu("Details");
        menubar.add(details);
        JMenuItem flightdetails = new JMenuItem("Flight Details");
        flightdetails.addActionListener(this);
        details.add(flightdetails);
        JMenuItem CustomerDetails = new JMenuItem("Add Customer Details");
        CustomerDetails.addActionListener(this);
        details.add(CustomerDetails);
        JMenuItem bookflight = new JMenuItem("Book Flight");
        bookflight.addActionListener(this);
        details.add(bookflight);
        JMenuItem journeydetails = new JMenuItem("Journey Details");
        journeydetails.addActionListener(this);
        details.add(journeydetails);
        JMenuItem ticketcancellation = new JMenuItem("Ticket Cancellation");
        ticketcancellation.addActionListener(this);
        details.add(ticketcancellation);
        
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);
        JMenuItem boardingpass = new JMenuItem("Generate Boarding Pass");
        boardingpass.addActionListener(this);
        ticket.add(boardingpass);
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
         String text = ae.getActionCommand();
         if(text.equals("Add Customer Details"))
         {
             new AddCustomer();
         }else if(text.equals("Flight Details"))
         {
             new FlightInfo();
         }else if(text.equals("Journey Details"))
         {
             new JourneyDetails();
         }else if (text.equals("Book Flight"))
         {
             new BookFlight();
         }else if (text.equals("Ticket Cancellation"))
         {
             new Cancel();
         } else if(text.equals("Generate Boarding Pass"))
         {
             new BoardingPass();
         }
    }
    public static void main(String[]args)
    {
        new Home();
    }
}

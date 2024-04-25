import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton addPersonDetails, updatePersonDetails, viewPersonDetails, deletePersonDetails, checkPackage,bookPackage,
            viewPackage, viewHotels, bookHotel, payment, viewBookedHotel, calculator, notepad, about, viewDestination;
    public Dashboard(String username){
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        System.out.println(screenWidth);
        int screenHeight = (int) screenSize.getHeight();
        System.out.println(screenHeight);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,screenWidth,65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);

        JLabel heading = new JLabel("DASHBOARD");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahome",Font.BOLD,30));
        p1.add(heading);


        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0,102));
        p2.setBounds(0,65,300,screenHeight);
        add(p2);

        addPersonDetails = new JButton("Add Personal Details");
        addPersonDetails.setBackground(new Color(0,0,102));
        addPersonDetails.setForeground(Color.white);
        addPersonDetails.setFont(new Font("Tahome",Font.BOLD,20));
        addPersonDetails.setMargin(new Insets(0,0,0,60));
        addPersonDetails.setBounds(0 , 0, 300,40);
        addPersonDetails.addActionListener(this);
        p2.add(addPersonDetails);


        updatePersonDetails = new JButton("Update Personal Details");
        updatePersonDetails.setBackground(new Color(0,0,102));
        updatePersonDetails.setForeground(Color.white);
        updatePersonDetails.setFont(new Font("Tahome",Font.BOLD,20));
        updatePersonDetails.setMargin(new Insets(0,0,0,30));
        updatePersonDetails.setBounds(0 , 40, 300,40);
        updatePersonDetails.addActionListener(this);
        p2.add(updatePersonDetails);

        viewPersonDetails = new JButton("View Details");
        viewPersonDetails.setBackground(new Color(0,0,102));
        viewPersonDetails.setForeground(Color.white);
        viewPersonDetails.setFont(new Font("Tahome",Font.BOLD,20));
        viewPersonDetails.setMargin(new Insets(0,0,0,140));
        viewPersonDetails.setBounds(0 , 80, 300,40);
        viewPersonDetails.addActionListener(this);
        p2.add(viewPersonDetails);

        deletePersonDetails = new JButton("Delete Personal Details");
        deletePersonDetails.setBackground(new Color(0,0,102));
        deletePersonDetails.setForeground(Color.white);
        deletePersonDetails.setFont(new Font("Tahome",Font.BOLD,20));
        deletePersonDetails.setMargin(new Insets(0,0,0,35));
        deletePersonDetails.setBounds(0 , 120, 300,40);
        deletePersonDetails.addActionListener(this);
        p2.add(deletePersonDetails);

        checkPackage = new JButton("Check Package");
        checkPackage.setBackground(new Color(0,0,102));
        checkPackage.setForeground(Color.white);
        checkPackage.setFont(new Font("Tahome",Font.BOLD,20));
        checkPackage.setMargin(new Insets(0,0,0,110));
        checkPackage.setBounds(0 , 160, 300,40);
        checkPackage.addActionListener(this);
        p2.add(checkPackage);

        bookPackage = new JButton("Book Package");
        bookPackage.setBackground(new Color(0,0,102));
        bookPackage.setForeground(Color.white);
        bookPackage.setFont(new Font("Tahome",Font.BOLD,20));
        bookPackage.setMargin(new Insets(0,0,0,120));
        bookPackage.setBounds(0 , 200, 300,40);
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewPackage = new JButton("View Package");
        viewPackage.setBackground(new Color(0,0,102));
        viewPackage.setForeground(Color.white);
        viewPackage.setFont(new Font("Tahome",Font.BOLD,20));
        viewPackage.setMargin(new Insets(0,0,0,120));
        viewPackage.setBounds(0 , 240, 300,40);
        viewPackage.addActionListener(this);
        p2.add(viewPackage);

        viewHotels = new JButton("View Hotels");
        viewHotels.setBackground(new Color(0,0,102));
        viewHotels.setForeground(Color.white);
        viewHotels.setFont(new Font("Tahome",Font.BOLD,20));
        viewHotels.setMargin(new Insets(0,0,0,140));
        viewHotels.setBounds(0 , 280, 300,40);
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotel = new JButton("Book Hotel");
        bookHotel.setBackground(new Color(0,0,102));
        bookHotel.setForeground(Color.white);
        bookHotel.setFont(new Font("Tahome",Font.BOLD,20));
        bookHotel.setMargin(new Insets(0,0,0,150));
        bookHotel.setBounds(0 , 320, 300,40);
        bookHotel.addActionListener(this);
        p2.add(bookHotel);

        viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setBackground(new Color(0,0,102));
        viewBookedHotel.setForeground(Color.white);
        viewBookedHotel.setFont(new Font("Tahome",Font.BOLD,20));
        viewBookedHotel.setMargin(new Insets(0,0,0,80));
        viewBookedHotel.setBounds(0 , 360, 300,40);
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);

        viewDestination = new JButton("Destination");
        viewDestination.setBackground(new Color(0,0,102));
        viewDestination.setForeground(Color.white);
        viewDestination.setFont(new Font("Tahome",Font.BOLD,20));
        viewDestination.setMargin(new Insets(0,0,0,150));
        viewDestination.setBounds(0 , 400, 300,40);
        viewDestination.addActionListener(this);
        p2.add(viewDestination);

        payment = new JButton("Payment");
        payment.setBackground(new Color(0,0,102));
        payment.setForeground(Color.white);
        payment.setFont(new Font("Tahome",Font.BOLD,20));
        payment.setMargin(new Insets(0,0,0,175));
        payment.setBounds(0 , 440, 300,40);
        payment.addActionListener(this);
        p2.add(payment);

        calculator = new JButton("Calculator");
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.white);
        calculator.setFont(new Font("Tahome",Font.BOLD,20));
        calculator.setMargin(new Insets(0,0,0,165));
        calculator.setBounds(0 , 480, 300,40);
        calculator.addActionListener(this);
        p2.add(calculator);

        notepad = new JButton("Notepad");
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("Tahome",Font.BOLD,20));
        notepad.setMargin(new Insets(0,0,0,180));
        notepad.setBounds(0 , 520, 300,40);
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.white);
        about.setFont(new Font("Tahome",Font.BOLD,20));
        about.setMargin(new Insets(0,0,0,200));
        about.setBounds(0 , 560, 300,40);
        about.addActionListener(this);
        p2.add(about);

        JPanel p3 = new JPanel();
        p3.setLayout(null);
        p3.setBounds(300,65, screenWidth,screenHeight);
        add(p3);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(screenWidth,screenHeight,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,screenWidth,screenHeight);
        p3.add(image);

        JLabel text = new JLabel("Travel & Tourism Management System");
        text.setBounds(100,10,1000,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.PLAIN,50));
        image.add(text);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Dashboard("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addPersonDetails){
            new AddCustomer(username);
        }else if(e.getSource() == updatePersonDetails){
            new UpdateCustomer(username);
        } else if (e.getSource() == viewPersonDetails) {
            new ViewCustomer(username);
        } else if(e.getSource() == checkPackage){
            new CheckPackage();
        } else if (e.getSource() == bookPackage) {
            new BookPackage(username);
        } else if (e.getSource() == viewPackage){
            new ViewPackage(username);
        } else if (e.getSource() == viewHotels) {
            new CheckHotels();
        } else if (e.getSource() == viewDestination) {
            new Destination();
        } else if (e.getSource() == bookHotel) {
            new BookHotel(username);
        } else if (e.getSource() == viewBookedHotel) {
            new ViewBookedHotel(username);
        } else if (e.getSource() == payment) {
            new Payment();
        } else if (e.getSource() == calculator) {
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception exception){
                exception.printStackTrace();
            }
        } else if (e.getSource() == notepad) {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }else if(e.getSource()== about){
            new About();
        } else if (e.getSource() == deletePersonDetails) {
            new DeleteDetails(username);
        }


    }
}

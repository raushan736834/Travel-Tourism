import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewBookedHotel extends JFrame implements ActionListener {
    JLabel labelUsername, labelPerson, labelNumber, labelID, labelPrice, labelPhone,labelFood, labelAC, labelHotel, labelDays;
    JButton back;
    String username;

    ViewBookedHotel(String username){
        this.username = username;
        setBounds(250,50,1000,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading  = new JLabel("View Booked Hotel Details");
        heading.setBounds(60,0,250,30);
        heading.setFont(new Font("Tahome",Font.BOLD,20));
        add(heading);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(20,40,100,30);
        lblUsername.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblUsername);

        labelUsername = new JLabel();
        labelUsername.setBounds(140,40,100,30);
        labelUsername.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelUsername);

        JLabel lblHotel = new JLabel("Hotel Name:");
        lblHotel.setBounds(20,90,100,30);
        lblHotel.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblHotel);

        labelHotel = new JLabel();
        labelHotel.setBounds(140,90,150,30);
        labelHotel.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelHotel);

        JLabel lblPerson = new JLabel("Total Persons:");
        lblPerson.setBounds(20,140,100,30);
        lblPerson.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblPerson);

        labelPerson = new JLabel();
        labelPerson.setBounds(140,140,100,30);
        labelPerson.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelPerson);

        JLabel lblDays = new JLabel("Total Days");
        lblDays.setBounds(20,190,100,30);
        lblDays.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblDays);

        labelDays = new JLabel();
        labelDays.setBounds(140,190,100,30);
        labelDays.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelDays);

        JLabel lblAC = new JLabel("AC Included?");
        lblAC.setBounds(20,240,100,30);
        lblAC.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblAC);

        labelAC = new JLabel();
        labelAC.setBounds(140,240,100,30);
        labelAC.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelAC);

        JLabel lblFood = new JLabel("Food Included?");
        lblFood.setBounds(20,290,130,35);
        lblFood.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblFood);

        labelFood = new JLabel();
        labelFood.setBounds(140,290,130,35);
        labelFood.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelFood);

        JLabel lblID = new JLabel("ID Type:");
        lblID.setBounds(20,340,100,30);
        lblID.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblID);

        labelID = new JLabel();
        labelID.setBounds(140,340,100,30);
        labelID.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelID);

        JLabel lblNumber = new JLabel("Id Number:");
        lblNumber.setBounds(20,390,100,30);
        lblNumber.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblNumber);

        labelNumber = new JLabel();
        labelNumber.setBounds(140,390,100,30);
        labelNumber.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelNumber);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(20,440,100,30);
        lblPhone.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblPhone);

        labelPhone = new JLabel();
        labelPhone.setBounds(140,440,100,30);
        labelPhone.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelPhone);

        JLabel lblPrice = new JLabel("Total Cost:");
        lblPrice.setBounds(20,490,100,30);
        lblPrice.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblPrice);

        labelPrice = new JLabel();
        labelPrice.setBounds(140,490,100,30);
        labelPrice.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelPrice);



        back = new JButton("Back");
        back.setBounds(150,550,100,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.GRAY);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,40,500,500);
        add(image);


        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bookHotel where username = '"+username+"'");
            while(rs.next()){
                labelUsername.setText(rs.getString("username"));
                labelID.setText(rs.getString("id"));
                labelHotel.setText(rs.getString("name"));
                labelAC.setText(rs.getString("ac"));
                labelDays.setText(rs.getString("days"));
                labelFood.setText(rs.getString("food"));
                labelNumber.setText(rs.getString("number"));
                labelPrice.setText(rs.getString("price"));
                labelPerson.setText(rs.getString("persons"));
                labelPhone.setText(rs.getString("phone"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }
    public static void main(String[] args) {
        new ViewBookedHotel("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}

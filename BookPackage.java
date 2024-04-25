import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class BookPackage extends JFrame implements ActionListener {

    JComboBox<String> pack;
    JTextField totalPerson;
    JLabel labelID,labelNumber,labelPhone,labelPrice,labelUsername;
    String username;

    JButton checkPrice, bookPackage,back;

    public BookPackage(String username){
        this.username= username;
        setBounds(200,120,1000,450);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel book = new JLabel("BOOK PACKAGE");
        book.setBounds(50,5,200,30);
        book.setFont(new Font("Tahome",Font.BOLD,20));
        add(book);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(20,50,200,30);
        lblUsername.setFont(new Font("Tahome",Font.BOLD,16));
        add(lblUsername);

        labelUsername = new JLabel();
        labelUsername.setBounds(200,50,200,30);
        labelUsername.setFont(new Font("Tahome",Font.PLAIN,20));
        add(labelUsername);

        JLabel lblPackage = new JLabel("Select Package");
        lblPackage.setFont(new Font("Tahome",Font.BOLD,16));
        lblPackage.setBounds(20,90,200,30);
        add(lblPackage);

        pack = new JComboBox<>(new String[]{"Gold Package","Silver Package","Bronze Package"});
        pack.setBounds(200,90,200,30);
        pack.setBackground(Color.WHITE);
        add(pack);

        JLabel lblPerson = new JLabel("Total Person");
        lblPerson.setFont(new Font("Tahome",Font.BOLD,16));
        lblPerson.setBounds(20,130,200,30);
        add(lblPerson);

        totalPerson = new JTextField("1");
        totalPerson.setBounds(200,130,200,30);
        totalPerson.setFont(new Font("Tahome",Font.BOLD,16));
        add(totalPerson);

        JLabel lblID = new JLabel("ID Card");
        lblID.setBounds(20,170,200,30);
        lblID.setFont(new Font("Tahome",Font.BOLD,16));
        add(lblID);

        labelID = new JLabel();
        labelID.setBounds(200,170,200,30);
        labelID.setFont(new Font("Tahome",Font.BOLD,16));
        add(labelID);

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(20,210,200,30);
        lblNumber.setFont(new Font("Tahome",Font.BOLD,16));
        add(lblNumber);

        labelNumber = new JLabel();
        labelNumber.setBounds(200,210,200,30);
        labelNumber.setFont(new Font("Tahome",Font.BOLD,16));
        add(labelNumber);

        JLabel lblPhone = new JLabel("Phone No.");
        lblPhone.setBounds(20,250,200,30);
        lblPhone.setFont(new Font("Tahome",Font.BOLD,16));
        add(lblPhone);

        labelPhone = new JLabel();
        labelPhone.setBounds(200,250,200,30);
        labelPhone.setFont(new Font("Tahome",Font.BOLD,16));
        add(labelPhone);

        JLabel lblPrice = new JLabel("Total Price");
        lblPrice.setBounds(20,290,200,30);
        lblPrice.setFont(new Font("Tahome",Font.BOLD,16));
        add(lblPrice);

        labelPrice = new JLabel();
        labelPrice.setBounds(200,290,200,30);
        labelPrice.setFont(new Font("Tahome",Font.BOLD,16));
        add(labelPrice);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()){
                labelUsername.setText(rs.getString("username"));
                labelID.setText(rs.getString("id"));
                labelNumber.setText(rs.getString("number"));
                labelPhone.setText(rs.getString("phone"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }


        checkPrice = new JButton("Check Price");
        checkPrice.setBackground(Color.GRAY);
        checkPrice.setForeground(Color.WHITE);
        checkPrice.setFont(new Font("Raleway",Font.BOLD,13));
        checkPrice.setBounds(30,350,130,30);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookPackage = new JButton("Book Package");
        bookPackage.setBackground(Color.GRAY);
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setFont(new Font("Raleway",Font.BOLD,13));
        bookPackage.setBounds(180,350,130,30);
        bookPackage.addActionListener(this);
        add(bookPackage);

        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway",Font.BOLD,13));
        back.setBounds(320,350,130,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(430,30,500,300);
        add(image);


        setVisible(true);

    }

    public static void main(String[] args) {
        new BookPackage("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== checkPrice){
            String package1 = (String) pack.getSelectedItem();
            int personNo =Integer.parseInt(totalPerson.getText());
            int cost = 0;
            assert package1 != null;
            if (package1.equals("Gold Package")){
                cost += 24000;
            } else if (package1.equals("Silver Package")) {
                cost += 18000;
            }else {
                cost += 12000;
            }
            cost = +cost * personNo;
            labelPrice.setText("Rs. "+cost);
        }else if (e.getSource() == bookPackage){
            String username = labelUsername.getText();
            String packa = pack.getSelectedItem().toString();
            String person =totalPerson.getText();
            String id = labelID.getText();
            String number = labelNumber.getText();
            String phone = labelPhone.getText();
            String price = labelPrice.getText();
            try{
                Conn c = new Conn();
                String query = "insert into bookPackage values ('"+username+"','"+packa+"','"+person+"','"+id+"','"+number+"','"+phone+"','"+price+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);
            }catch (Exception exception ){
                exception.printStackTrace();
            }
        }else
            setVisible(false);
    }
}

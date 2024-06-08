import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class BookHotel extends JFrame implements ActionListener {
    String username;
    JLabel labelUsername, labelID, labelNumber, labelPhone, labelPrice;
    JComboBox<String> comboHotel, comboAC, comboFood;
    JTextField tfPerson, tfDays;
    JButton book, back, checkPrice;

    BookHotel(String username){
        this.username = username;
        setBounds(150,50,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("BOOK HOTEL");
        heading.setBounds(60,0,200,70);
        heading.setFont(new Font("Tahome",Font.BOLD,20));
        add(heading);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(30,50,150,30);
        lblUsername.setFont(new Font("Tahome",Font.BOLD,16));
        add(lblUsername);

        labelUsername = new JLabel();
        labelUsername.setBounds(220,50,250,30);
        labelUsername.setFont(new Font("Tahome",Font.BOLD,16));
        add(labelUsername);

        JLabel lblHotel = new JLabel("Select Hotel:");
        lblHotel.setBounds(30,90,150,30);
        lblHotel.setFont(new Font("Tahome",Font.BOLD,16));
        add(lblHotel);

        comboHotel = new JComboBox<>(new String[]{"Maurya Hotel","Chanakya Hotel","Lemon Tree Premier ","Patliputra Continental",
        "The Hotel Bliss"," The Panache Hotel","Gargee Grand","Hotel CP Palace ","Patliputra Exotica","The Grand Empire"});
        comboHotel.setBounds(220,90,200,30);
        comboHotel.setFont(new Font("Tahome",Font.BOLD,14));
        comboHotel.setBackground(Color.WHITE);
        add(comboHotel);

        JLabel lblPerson = new JLabel("Total Persons:");
        lblPerson.setBounds(30,130,150,30);
        lblPerson.setFont(new Font("Tahome",Font.BOLD,16));
        add(lblPerson);

        tfPerson = new JTextField("1");
        tfPerson.setBounds(220,130,200,30);
        tfPerson.setFont(new Font("Tahome",Font.BOLD,16));
        add(tfPerson);

        JLabel lblDays = new JLabel("No. of Days:");
        lblDays.setBounds(30,170,150,30);
        lblDays.setFont(new Font("Tahome",Font.BOLD,16));
        add(lblDays);

        tfDays = new JTextField("1");
        tfDays.setBounds(220,170,200,30);
        tfDays.setFont(new Font("Tahome",Font.BOLD,16));
        add(tfDays);

        JLabel lblAC = new JLabel("AC/Non-AC:");
        lblAC.setBounds(30,210,150,30);
        lblAC.setFont(new Font("Tahome",Font.BOLD,16));
        add(lblAC);

        comboAC = new JComboBox<>(new String[] {"AC","Non-AC"});
        comboAC.setBounds(220,210,200,30);
        comboAC.setFont(new Font("Tahome",Font.BOLD,14));
        comboAC.setBackground(Color.WHITE);
        add(comboAC);

        JLabel lblFood = new JLabel("Food Included:");
        lblFood.setBounds(30,250,150,30);
        lblFood.setFont(new Font("Tahome",Font.BOLD,16));
        add(lblFood);

        comboFood = new JComboBox<>(new String[] {"Yes","No"});
        comboFood.setBounds(220,250,200,30);
        comboFood.setFont(new Font("Tahome",Font.BOLD,14));
        comboFood.setBackground(Color.WHITE);
        add(comboFood);

        JLabel lblId = new JLabel("ID Type");
        lblId.setBounds(30,290,150,30);
        lblId.setFont(new Font("Tahome",Font.BOLD,16));
        add(lblId);

        labelID = new JLabel();
        labelID.setBounds(220,290,200,30);
        labelID.setFont(new Font("Tahome",Font.BOLD,16));
        add(labelID);

        JLabel lblNumber = new JLabel("Number:");
        lblNumber.setBounds(30, 330, 150, 30);
        lblNumber.setFont(new Font("Tahome",Font.BOLD,16));
        add(lblNumber);

        labelNumber = new JLabel();
        labelNumber.setBounds(220,330,200,30);
        labelNumber.setFont(new Font("Tahome",Font.BOLD,16));
        add(labelNumber);

        JLabel phone  = new JLabel("Phone No.:");
        phone.setFont(new Font("Tahome",Font.BOLD,16));
        phone.setBounds(30,370,150,30);
        add(phone);

        labelPhone = new JLabel();
        labelPhone.setFont(new Font("Tahome",Font.BOLD,16));
        labelPhone.setBounds(220,370,200,30);
        add(labelPhone);

        JLabel lblPrice  = new JLabel("Total Price:");
        lblPrice.setFont(new Font("Tahome",Font.BOLD,16));
        lblPrice.setBounds(30,410,150,30);
        add(lblPrice);

        labelPrice = new JLabel();
        labelPrice.setFont(new Font("Tahome",Font.BOLD,16));
        labelPrice.setBounds(220,410,200,30);
        add(labelPrice);

        checkPrice = new JButton("Check Price");
        checkPrice.setFont(new Font("Tahome",Font.BOLD,16));
        checkPrice.setBounds(40,470,110,30);
        checkPrice.setBackground(Color.GRAY);
        checkPrice.setBorder(BorderFactory.createEmptyBorder());
        checkPrice.setForeground(new Color(255, 255, 255));
        checkPrice.addActionListener(this);
        add(checkPrice);

        book = new JButton("Add");
        book.setFont(new Font("Tahome",Font.BOLD,16));
        book.setBounds(170,470,110,30);
        book.setBackground(Color.GRAY);
        book.setBorder(BorderFactory.createEmptyBorder());
        book.setForeground(new Color(255, 255, 255));
        book.addActionListener(this);
        add(book);

        back = new JButton("Back");
        back.setFont(new Font("Tahome",Font.BOLD,16));
        back.setBounds(300,470,110,30);
        back.setBackground(Color.GRAY);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setForeground(new Color(255, 255, 255));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icon/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(460,50,600,400);
        add(image);

        try{
            Conn c = new Conn();
            String query = "select * from customer where username ='"+username+"'";
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                labelUsername.setText(rs.getString("username"));
                labelID.setText(rs.getString("id"));
                labelPhone.setText(rs.getString("phone"));
                labelNumber.setText(rs.getString("number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }


        setVisible(true);
    }
    public static void main(String[] args) {
        new BookHotel("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == checkPrice) {
            String hotel = Objects.requireNonNull(comboHotel.getSelectedItem()).toString();
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '"+hotel+"'");
                while(rs.next()){
                    int cost = Integer.parseInt(rs.getString("cost"));
                    int food = Integer.parseInt(rs.getString("foodIncluded"));
                    int ac = Integer.parseInt(rs.getString("roomType"));

                    int person = Integer.parseInt(tfPerson.getText());
                    int days = Integer.parseInt(tfDays.getText());

                    String acSelected = comboAC.getSelectedItem().toString();
                    String foodSelected = comboFood.getSelectedItem().toString();

                    if (person * days > 0 ){
                        int total = 0;
                        total += acSelected.equals("AC") ? ac :0;
                        total += foodSelected.equals("Yes") ? food : 0;

                        total += cost;
                        total = total * person * days;
                        labelPrice.setText("Rs. "+total);
                    }else {
                        JOptionPane.showMessageDialog(null,"Invalid Total Person or No. of Days");
                    }
                }
                
            }catch (Exception ex){
                ex.printStackTrace();
            }
        } else if (e.getSource() == book) {
            String username = labelUsername.getText();
            String hotelName = comboHotel.getSelectedItem().toString();
            String person = tfPerson.getText();
            String days = tfDays.getText();
            String  ac = comboAC.getSelectedItem().toString();
            String food = comboFood.getSelectedItem().toString();
            String id = labelID.getText();
            String number = labelNumber.getText();
            String phone = labelPhone.getText();
            String price = labelPrice.getText();

            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookHotel values('"+username+"','"+hotelName+"','"+person+"'," +
                        "'"+days+"','"+ac+"','"+food+"'," +
                        "'"+id+"','"+number+"','"+phone+"','"+price+"')");

                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
}

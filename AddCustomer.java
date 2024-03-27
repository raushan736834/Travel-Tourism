import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel Username, labelName;
    JComboBox<String> comboID;
    JTextField tfNumber, tfCountry, tfAddress, tfPhone, tfEmail;
    JRadioButton male,female;
    JButton add, back;

    public AddCustomer(String username){
        setBounds(300,100,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30,20,150,30);
        lblUsername.setFont(new Font("Tahome",Font.BOLD,16));
        add(lblUsername);

        Username = new JLabel();
        Username.setBounds(220,20,250,30);
        Username.setFont(new Font("Tahome",Font.BOLD,16));
        add(Username);

        JLabel lblId = new JLabel("ID Proof");
        lblId.setBounds(30,60,150,30);
        lblId.setFont(new Font("Tahome",Font.BOLD,16));
        add(lblId);

        comboID = new JComboBox<>(new String[] {"Passport", "Aadhaar Card","Pan Card", "Ration Card"});
        comboID.setBounds(220,60,200,30);
        comboID.setFont(new Font("Tahome",Font.BOLD,14));
        comboID.setBackground(Color.WHITE);
        add(comboID);

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30,100,150,30);
        lblNumber.setFont(new Font("Tahome",Font.BOLD,16));
        add(lblNumber);

        tfNumber = new JTextField();
        tfNumber.setBounds(220,100,200,30);
        tfNumber.setFont(new Font("Tahome",Font.BOLD,16));
        add(tfNumber);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30,140,150,30);
        lblName.setFont(new Font("Tahome",Font.BOLD,16));
        add(lblName);

        labelName = new JLabel();
        labelName.setBounds(220,140,200,30);
        labelName.setFont(new Font("Tahome",Font.BOLD,16));
        add(labelName);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(30,180,150,30);
        gender.setFont(new Font("Tahome",Font.BOLD,16));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(215,180,90,30);
        male.setFont(new Font("Tahome",Font.BOLD,14));
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(325,180,100,30);
        female.setFont(new Font("Tahome",Font.BOLD,14));
        female.setBackground(Color.white);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel country = new JLabel("Country");
        country.setBounds(30,220,150,30);
        country.setFont(new Font("Tahome",Font.BOLD,16));
        add(country);

        tfCountry = new JTextField();
        tfCountry.setBounds(220,220,200,30);
        tfCountry.setFont(new Font("Tahome",Font.BOLD,16));
        add(tfCountry);

        JLabel address = new JLabel("Address");
        address.setBounds(30,260,150,30);
        address.setFont(new Font("Tahome",Font.BOLD,16));
        add(address);

        tfAddress = new JTextField();
        tfAddress.setBounds(220,260,200,30);
        tfAddress.setFont(new Font("Tahome",Font.BOLD,16));
        add(tfAddress);

        JLabel email = new JLabel("E-Mail");
        email.setBounds(30, 300, 150, 30);
        email.setFont(new Font("Tahome",Font.BOLD,16));
        add(email);

        tfEmail = new JTextField();
        tfEmail.setBounds(220,300,200,30);
        tfEmail.setFont(new Font("Tahome",Font.BOLD,16));
        add(tfEmail);


        JLabel phone  = new JLabel("Phone No.");
        phone.setFont(new Font("Tahome",Font.BOLD,16));
        phone.setBounds(30,340,150,30);
        add(phone);


        tfPhone = new JTextField();
        tfPhone.setFont(new Font("Tahome",Font.BOLD,16));
        tfPhone.setBounds(220,340,200,30);
        add(tfPhone);


        add = new JButton("Add");
        add.setFont(new Font("Tahome",Font.BOLD,16));
        add.setBounds(80,400,95,30);
        add.setBackground(Color.GRAY);
        add.setBorder(BorderFactory.createEmptyBorder());
        add.setForeground(new Color(255, 255, 255));
        add.addActionListener(this);
        add(add);


        back = new JButton("Back");
        back.setFont(new Font("Tahome",Font.BOLD,16));
        back.setBounds(250,400,100,30);
        back.setBackground(Color.GRAY);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setForeground(new Color(255, 255, 255));
        back.addActionListener(this);
        add(back);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450,50,400,500);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username = '"+username+"'");
            while (rs.next()){
                labelName.setText(rs.getString("name"));
                Username.setText(rs.getString("username"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }
    public static void main(String[] args) {
        new AddCustomer("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add){
            String username = Username.getText();
            String name = labelName.getText();
            String id =(String) comboID.getSelectedItem();
            String number = tfNumber.getText();
            String country = tfCountry.getText();
            String address = tfAddress.getText();
            String email = tfEmail.getText();
            String phone = tfPhone.getText();
            String gender = null;
            if (male.isSelected()){
                gender = "Male";
            }else{
                gender = "Female";
            }

            try{
                Conn c = new Conn();
                String query = "insert into customer values ('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"'," +
                        "'"+country+"','"+address+"','"+phone+"','"+email+"')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                setVisible(false);

            }catch (Exception exception){
                exception.printStackTrace();
            }
        }else{
            setVisible(false);

        }
    }
}

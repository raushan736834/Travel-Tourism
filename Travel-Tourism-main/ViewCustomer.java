import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.ImageGraphicAttribute;
import java.sql.ResultSet;


public class ViewCustomer extends JFrame implements ActionListener {
    JLabel labelUsername, labelName, labelId, labelNumber, labelCountry, labelGender, labelAddress, labelPhone, labelEmail;
    JButton back;
    ViewCustomer(String username){
        setBounds(280,80,870,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(20,20,100,30);
        lblUsername.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblUsername);

        labelUsername = new JLabel();
        labelUsername.setBounds(140,20,100,30);
        labelUsername.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelUsername);

        JLabel lblId = new JLabel("ID Type");
        lblId.setBounds(20,80,100,30);
        lblId.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblId);

        labelId = new JLabel();
        labelId.setBounds(140,80,100,30);
        labelId.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelId);

        JLabel lblNumber = new JLabel("ID Number");
        lblNumber.setBounds(20,140,100,30);
        lblNumber.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblNumber);

        labelNumber = new JLabel();
        labelNumber.setBounds(140,140,100,30);
        labelNumber.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelNumber);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(20,200,100,30);
        lblName.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblName);

        labelName = new JLabel();
        labelName.setBounds(140,200,150,30);
        labelName.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelName);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(20,260,100,30);
        lblGender.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblGender);

        labelGender = new JLabel();
        labelGender.setBounds(140,260,100,30);
        labelGender.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelGender);

        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(350,20,100,35);
        lblCountry.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblCountry);

        labelCountry = new JLabel();
        labelCountry.setBounds(470,20,100,35);
        labelCountry.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelCountry);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(350,80,100,30);
        lblAddress.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblAddress);

        labelAddress = new JLabel();
        labelAddress.setBounds(470,80,100,30);
        labelAddress.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelAddress);

        JLabel lblPhone = new JLabel("Phone No.");
        lblPhone.setBounds(350,140,100,30);
        lblPhone.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblPhone);

        labelPhone = new JLabel();
        labelPhone.setBounds(470,140,100,30);
        labelPhone.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelPhone);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(350,200,100,30);
        lblEmail.setFont(new Font("Tahome",Font.BOLD,14));
        add(lblEmail);

        labelEmail = new JLabel();
        labelEmail.setBounds(470,200,300,30);
        labelEmail.setFont(new Font("Tahome",Font.BOLD,14));
        add(labelEmail);

        back = new JButton("Back");
        back.setBounds(350,340,100,30);
        back.addActionListener(this);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.GRAY);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,400,600,200);
        add(image);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icon/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(600,400,600,200);
        add(image1);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()){
                labelUsername.setText(rs.getString("username"));
                labelId.setText(rs.getString("id"));
                labelNumber.setText(rs.getString("number"));
                labelName.setText(rs.getString("name"));
                labelGender.setText(rs.getString("gender"));
                labelCountry.setText(rs.getString("country"));
                labelAddress.setText(rs.getString("address"));
                labelPhone.setText(rs.getString("phone"));
                labelEmail.setText(rs.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }
    public static void main(String[] args) {
        new ViewCustomer("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}

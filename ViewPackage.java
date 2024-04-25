import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewPackage extends JFrame implements ActionListener {
        JLabel labelUsername, labelPerson, labelPackage, labelNumber, labelID, labelPrice, labelPhone;
        JButton back;
        String username;
        ViewPackage(String username){
            this.username = username;
            setBounds(250,120,1000,550);
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            JLabel heading  = new JLabel("View Booked Package");
            heading.setBounds(60,0,250,30);
            heading.setFont(new Font("Tahome",Font.BOLD,20));
            add(heading);

            JLabel lblUsername = new JLabel("Username");
            lblUsername.setBounds(20,40,100,30);
            lblUsername.setFont(new Font("Tahome",Font.BOLD,14));
            add(lblUsername);

            labelUsername = new JLabel();
            labelUsername.setBounds(140,40,100,30);
            labelUsername.setFont(new Font("Tahome",Font.BOLD,14));
            add(labelUsername);

            JLabel lblPackage = new JLabel("Package");
            lblPackage.setBounds(20,90,100,30);
            lblPackage.setFont(new Font("Tahome",Font.BOLD,14));
            add(lblPackage);

            labelPackage = new JLabel();
            labelPackage.setBounds(140,90,150,30);
            labelPackage.setFont(new Font("Tahome",Font.BOLD,14));
            add(labelPackage);

            JLabel lblPerson = new JLabel("ID Number");
            lblPerson.setBounds(20,140,100,30);
            lblPerson.setFont(new Font("Tahome",Font.BOLD,14));
            add(lblPerson);

            labelPerson = new JLabel();
            labelPerson.setBounds(140,140,100,30);
            labelPerson.setFont(new Font("Tahome",Font.BOLD,14));
            add(labelPerson);

            JLabel lblID = new JLabel("ID Type");
            lblID.setBounds(20,190,100,30);
            lblID.setFont(new Font("Tahome",Font.BOLD,14));
            add(lblID);

            labelID = new JLabel();
            labelID.setBounds(140,190,100,30);
            labelID.setFont(new Font("Tahome",Font.BOLD,14));
            add(labelID);

            JLabel lblNumber = new JLabel("Number");
            lblNumber.setBounds(20,240,100,30);
            lblNumber.setFont(new Font("Tahome",Font.BOLD,14));
            add(lblNumber);

            labelNumber = new JLabel();
            labelNumber.setBounds(140,240,120,30);
            labelNumber.setFont(new Font("Tahome",Font.BOLD,14));
            add(labelNumber);

            JLabel lblPhone = new JLabel("Phone");
            lblPhone.setBounds(20,290,100,35);
            lblPhone.setFont(new Font("Tahome",Font.BOLD,14));
            add(lblPhone);

            labelPhone = new JLabel();
            labelPhone.setBounds(140,290,100,35);
            labelPhone.setFont(new Font("Tahome",Font.BOLD,14));
            add(labelPhone);

            JLabel lblPrice = new JLabel("Price");
            lblPrice.setBounds(20,340,100,30);
            lblPrice.setFont(new Font("Tahome",Font.BOLD,14));
            add(lblPrice);

            labelPrice = new JLabel();
            labelPrice.setBounds(140,340,100,30);
            labelPrice.setFont(new Font("Tahome",Font.BOLD,14));
            add(labelPrice);


            back = new JButton("Back");
            back.setBounds(150,390,100,30);
            back.addActionListener(this);
            back.setForeground(Color.WHITE);
            back.setBackground(Color.GRAY);
            back.addActionListener(this);
            add(back);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bookedDetails.jpg"));
            Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(400,20,500,400);
            add(image);


            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from bookPackage where username = '"+username+"'");
                while(rs.next()){
                    labelUsername.setText(rs.getString("username"));
                    labelID.setText(rs.getString("id"));
                    labelPackage.setText(rs.getString("packa"));
                    labelNumber.setText(rs.getString("number"));
                    labelPrice.setText(rs.getString("price"));
                    labelPerson.setText(rs.getString("person"));
                    labelPhone.setText(rs.getString("phone"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }

            setVisible(true);
        }
        public static void main(String[] args) {
            new ViewPackage("");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }


}

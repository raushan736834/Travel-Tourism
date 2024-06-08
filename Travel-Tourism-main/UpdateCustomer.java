import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener {

        JLabel Username, labelName;
        JTextField tfNumber, tfCountry, tfAddress, tfPhone, tfEmail, tfId, tfGender;
        JButton update, back;

        public UpdateCustomer(String username){
            setBounds(300,100,850,550);
            setLayout(null);
            getContentPane().setBackground(Color.WHITE);

            JLabel heading = new JLabel("Update Customer Details");
            heading.setBounds(300,0,300,30);
            heading.setFont(new Font("Tahome",Font.PLAIN,20));
            add(heading);


            JLabel lblUsername = new JLabel("Username");
            lblUsername.setBounds(30,40,150,30);
            lblUsername.setFont(new Font("Tahome",Font.BOLD,16));
            add(lblUsername);

            Username = new JLabel();
            Username.setBounds(220,40,250,30);
            Username.setFont(new Font("Tahome",Font.BOLD,16));
            add(Username);

            JLabel lblId = new JLabel("ID Proof");
            lblId.setBounds(30,80,150,30);
            lblId.setFont(new Font("Tahome",Font.BOLD,16));
            add(lblId);

            tfId = new JTextField();
            tfId.setBounds(220,80,200,30);
            tfId.setFont(new Font("Tahome",Font.BOLD,14));
            tfId.setBackground(Color.WHITE);
            add(tfId);

            JLabel lblNumber = new JLabel("Number");
            lblNumber.setBounds(30,120,150,30);
            lblNumber.setFont(new Font("Tahome",Font.BOLD,16));
            add(lblNumber);

            tfNumber = new JTextField();
            tfNumber.setBounds(220,120,200,30);
            tfNumber.setFont(new Font("Tahome",Font.BOLD,16));
            add(tfNumber);

            JLabel lblName = new JLabel("Name");
            lblName.setBounds(30,160,150,30);
            lblName.setFont(new Font("Tahome",Font.BOLD,16));
            add(lblName);

            labelName = new JLabel();
            labelName.setBounds(220,160,200,30);
            labelName.setFont(new Font("Tahome",Font.BOLD,16));
            add(labelName);

            JLabel gender = new JLabel("Gender");
            gender.setBounds(30,200,150,30);
            gender.setFont(new Font("Tahome",Font.BOLD,16));
            add(gender);

            tfGender = new JTextField();
            tfGender.setBounds(220,200,200,30);
            tfGender.setFont(new Font("Tahome",Font.BOLD,14));
            tfGender.setBackground(Color.WHITE);
            add(tfGender);

            JLabel country = new JLabel("Country");
            country.setBounds(30,240,150,30);
            country.setFont(new Font("Tahome",Font.BOLD,16));
            add(country);

            tfCountry = new JTextField();
            tfCountry.setBounds(220,240,200,30);
            tfCountry.setFont(new Font("Tahome",Font.BOLD,16));
            add(tfCountry);

            JLabel address = new JLabel("Address");
            address.setBounds(30,280,150,30);
            address.setFont(new Font("Tahome",Font.BOLD,16));
            add(address);

            tfAddress = new JTextField();
            tfAddress.setBounds(220,280,200,30);
            tfAddress.setFont(new Font("Tahome",Font.BOLD,16));
            add(tfAddress);

            JLabel email = new JLabel("E-Mail");
            email.setBounds(30, 320, 150, 30);
            email.setFont(new Font("Tahome",Font.BOLD,16));
            add(email);

            tfEmail = new JTextField();
            tfEmail.setBounds(220,320,200,30);
            tfEmail.setFont(new Font("Tahome",Font.BOLD,16));
            add(tfEmail);


            JLabel phone  = new JLabel("Phone No.");
            phone.setFont(new Font("Tahome",Font.BOLD,16));
            phone.setBounds(30,360,150,30);
            add(phone);


            tfPhone = new JTextField();
            tfPhone.setFont(new Font("Tahome",Font.BOLD,16));
            tfPhone.setBounds(220,360,200,30);
            add(tfPhone);


            update = new JButton("Update");
            update.setFont(new Font("Tahome",Font.BOLD,16));
            update.setBounds(80,420,95,30);
            update.setBackground(Color.GRAY);
            update.setBorder(BorderFactory.createEmptyBorder());
            update.setForeground(new Color(255, 255, 255));
            update.addActionListener(this);
            add(update);


            back = new JButton("Back");
            back.setFont(new Font("Tahome",Font.BOLD,16));
            back.setBounds(250,420,100,30);
            back.setBackground(Color.GRAY);
            back.setBorder(BorderFactory.createEmptyBorder());
            back.setForeground(new Color(255, 255, 255));
            back.addActionListener(this);
            add(back);


            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
            Image i2 = i1.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(400,50,400,400);
            add(image);

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
                while (rs.next()){
                    labelName.setText(rs.getString("name"));
                    Username.setText(rs.getString("username"));
                    tfId.setText(rs.getString("id"));
                    tfNumber.setText(rs.getString("number"));
                    tfGender.setText(rs.getString("gender"));
                    tfPhone.setText(rs.getString("phone"));
                    tfEmail.setText(rs.getString("email"));
                    tfCountry.setText(rs.getString("country"));
                    tfAddress.setText(rs.getString("address"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            setVisible(true);
        }
        public static void main(String[] args) {
            new UpdateCustomer("rudra");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == update){
                String username = Username.getText();
                String name = labelName.getText();
                String id =tfId.getText();
                String number = tfNumber.getText();
                String country = tfCountry.getText();
                String address = tfAddress.getText();
                String email = tfEmail.getText();
                String phone = tfPhone.getText();
                String gender = tfGender.getText();


                try{
                    Conn c = new Conn();
                    String query = "update customer set username = '"+username+"',id = '"+id+"',number = '"+number+"',name = '"+name+"',gender = '"+gender+"',country = '"+country+"',address = '"+address+"',phone = '"+phone+"',email = '"+email+"'";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Customer Details Updated Successfully");
                    setVisible(false);

                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }else{
                setVisible(false);
            }
        }
}

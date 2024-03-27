import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame implements ActionListener {
    JButton create , back;
    JTextField tfUsername,tfName,tfPassword, tfAnswer;
    Choice tfSecurity;
    public SignUp(){
        setBounds(280,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,450,400);
        p1.setLayout(null);
        add(p1);

        JLabel lbUsername = new JLabel("Username");
        lbUsername.setFont(new Font("Tahome",Font.BOLD,16));
        lbUsername.setBounds(30,30,125,25);
        p1.add(lbUsername);
        
        tfUsername = new JTextField();
        tfUsername.setBounds(195, 30, 220,25);
        tfUsername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfUsername);

        JLabel lbName = new JLabel("Name");
        lbName.setFont(new Font("Tahome",Font.BOLD,16));
        lbName.setBounds(30,70,125,25);
        p1.add(lbName);

        tfName = new JTextField();
        tfName.setBounds(195, 70, 220,25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);

        JLabel lbPassword = new JLabel("Password");
        lbPassword.setFont(new Font("Tahome",Font.BOLD,16));
        lbPassword.setBounds(30,110,125,25);
        p1.add(lbPassword);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(195, 110, 220,25);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfPassword);

        JLabel lbSecurity = new JLabel("Security Question");
        lbSecurity.setFont(new Font("Tahome",Font.BOLD,16));
        lbSecurity.setBounds(30,150,150,25);
        p1.add(lbSecurity);

        tfSecurity = new Choice();
        tfSecurity.add("Fav Character from The Boys");
        tfSecurity.add("Fav Character from Marvels");
        tfSecurity.add("Your Lucky Number");
        tfSecurity.add("Childhood Superhero");
        tfSecurity.setBounds(195, 150, 220,25);
        p1.add(tfSecurity);

        JLabel lbAnswer = new JLabel("Answer");
        lbAnswer.setFont(new Font("Tahome",Font.BOLD,16));
        lbAnswer.setBounds(30,190,125,25);
        p1.add(lbAnswer);

        tfAnswer = new JTextField();
        tfAnswer.setBounds(195, 190, 220,25);
        tfAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfAnswer);

        create = new JButton("Create");
        create.setBackground(Color.white);
        create.setForeground(new Color(133,193,233));
        create.setFont(new Font("Tahome", Font.BOLD, 16));
        create.setBorder(BorderFactory.createEmptyBorder());
        create.setBounds(80,250,100,25);
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(new Color(133,193,233));
        back.setFont(new Font("Tahome", Font.BOLD, 16));
        back.setBounds(225,250,100,25);
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        p1.add(back);

        JPanel p2 = new JPanel();
        p2.setBackground(Color.white);
        p2.setBounds(450,30, 400,320);
        p2.setLayout(null);
        add(p2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(95,20,200,200);
        p2.add(image);



        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == create){
            String username = tfUsername.getText();
            String name = tfName.getText();
            String answer = tfAnswer.getText();
            String password = tfPassword.getText();
            String question = tfSecurity.getSelectedItem();

            String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Account Created Successfully");
                setVisible(false);
                new Login();
            }catch (Exception exception){
                System.out.println(exception);
            }
        }else if(e.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
}

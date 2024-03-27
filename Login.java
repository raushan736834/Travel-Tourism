import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Arrays;

public class Login extends JFrame implements ActionListener {
    JButton signup, login, forgetPass;
    JTextField tfUserName;
    JPasswordField tfPassword;
    public Login(){
        setSize(800,420);
        setLocation(300,200);
        setLayout(null);

//      give full access to the panel
        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0, 350,420);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(75,80,200,200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(350,30,400,320);
        add(p2);

        JLabel username = new JLabel("Username");
        username.setBounds(60,20,100,25);
        username.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(username);

        tfUserName = new JTextField();
        tfUserName.setBounds(60,60,300,30);
        tfUserName.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfUserName);

        JLabel password = new JLabel("Password");
        password.setBounds(60,110,100,25);
        password.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        p2.add(password);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(60,150,300,30);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfPassword);

        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(131,193,233));
        login.setForeground(Color.white);
        login.setBorder(new LineBorder(new Color(131,193,233)));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Sign Up");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(131,193,233));
        signup.setForeground(Color.white);
        signup.setBorder(new LineBorder(new Color(131,193,233)));
        signup.addActionListener(this);
        p2.add(signup);

        forgetPass = new JButton("Forget Password");
        forgetPass.setBounds(60,250,300,30);
        forgetPass.setBackground(new Color(131,193,233));
        forgetPass.setForeground(Color.white);
        forgetPass.setBorder(new LineBorder(new Color(131,193,233)));
        forgetPass.addActionListener(this);
        p2.add(forgetPass);

        JLabel text = new JLabel("Trouble in Login...");
        text.setBounds(150,290,150,20);
        text.setForeground(Color.RED);
        p2.add(text);

        setVisible(true);

    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){
            try{
                String username = tfUserName.getText();
                String password = tfPassword.getText();

                String query = "select * from account where username = '"+username+"' AND password ='"+password+"'";
                Conn c = new Conn();
                ResultSet set = c.s.executeQuery(query);
                if(set.next()){
                    setVisible(false);
                    new Loading(username);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
                }
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }else if(e.getSource() == signup){
            setVisible(false);
            new SignUp();
        }else{
            setVisible(false);
            new ForgetPassword();
        }
    }
}

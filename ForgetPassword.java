import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener {
    JTextField tfUsername ,tfName, tfQuestion, tfAnswer, tfPassword;
    JButton search, retrieve, back;
    public ForgetPassword(){
        setBounds(300,200,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30,20,100,25);
        lblUsername.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(200,20,180,25);
        tfUsername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfUsername);

        search = new JButton("Search");
        search.setBounds(390,20,100,25);
        search.setForeground(Color.white);
        search.setBackground(Color.gray);
        search.addActionListener(this);
        p1.add(search);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30,55,100,25);
        lblName.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(200,55,180,25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);

        JLabel lblQuestion = new JLabel("Your Security Question");
        lblQuestion.setBounds(30,90,200,25);
        lblQuestion.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblQuestion);

        tfQuestion = new JTextField();
        tfQuestion.setBounds(200,90,180,25);
        tfQuestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfQuestion);

        JLabel lblAnswer = new JLabel("Your Answer");
        lblAnswer.setBounds(30,125,200,25);
        lblAnswer.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblAnswer);

        tfAnswer = new JTextField();
        tfAnswer.setBounds(200,125,180,25);
        tfAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfAnswer);

        retrieve = new JButton("Retrieve");
        retrieve.setBounds(390,125,100,25);
        retrieve.setForeground(Color.white);
        retrieve.setBackground(Color.gray);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel lblPassword = new JLabel("Your Password is");
        lblPassword.setBounds(30,160,200,25);
        lblPassword.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblPassword);

        tfPassword = new JTextField();
        tfPassword.setBounds(200,160,180,25);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfPassword);

        back = new JButton("Back");
        back.setBounds(180,215,100,25);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBackground(Color.gray);
        p1.add(back);

        setVisible(true);
    }
    public static void main(String[] args) {
        new ForgetPassword();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search){

            String username = tfUsername.getText();

            try{
                String query = "select * from account where username = '"+username+"'";
                Conn c = new Conn();
                ResultSet set = c.s.executeQuery(query);

                while(set.next()) {
                    tfName.setText(set.getString("name"));
                    tfQuestion.setText(set.getString("security"));
                }

            }catch (Exception exception){
                System.out.println(exception);
            }
        } else if(e.getSource() == retrieve){
            try{
                String query = "select * from account where answer = '"+tfAnswer.getText()+"' AND username = '"+tfUsername.getText()+"'";
                Conn c = new Conn();
                ResultSet set = c.s.executeQuery(query);

                while(set.next()) {
                    tfPassword.setText(set.getString("password"));
                }

            }catch (Exception exception){
                System.out.println(exception);
            }
        } else{
            setVisible(false);
            new Login();
        }
    }
}

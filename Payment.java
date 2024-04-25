import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment extends JFrame implements ActionListener {
//    JButton pay,back;
    Payment(){
        setBounds(350,20,800,700);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/phonepe.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
        ImageIcon i3  = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);


//        pay = new JButton("Pay");
//        pay.setBounds(320,0,80,40);
//        pay.setBackground(Color.WHITE);
//        pay.addActionListener(this);
////        image.add(pay);
//
//        back = new JButton("Back");
//        back.setBounds(420,0,80,40);
//        back.setBackground(Color.white);
//        back.addActionListener(this);
////        image.add(back);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Payment();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == pay){
//            setVisible(false);
//            new Paytm();
//        }else{
//            setVisible(false);
//        }
    }
}

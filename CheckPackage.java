import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {
    public CheckPackage(){
        setBounds(200,100,900,530);

        String[] package1 = {"GOLD PACKAGE","6 Days & 7 Nights","Airport Assistance","Half Day City Tour","Daily Buffet","Soft Drink Free","Full Day 3 Island Cruise","English Speaking Guide","BOOK PACKAGE","Summer Special","Rs 24000/-","icon/package1.jpg"};
        String[] package2 = {"SILVER PACKAGE","4 Days & 5 Nights","Toll Free & Entrance Free Tickets","Meet and Greet at Airport","Welcome Drinks on Arrival","Night Party","Night Safari","Cruise with Dinner","BOOK PACKAGE","Winter Special","Rs 18000/-","icon/package2.jpg"};
        String[] package3 = {"BRONZE PACKAGE","2 Days & 3 Nights","Return Airfare","Free Clubbing","Horse Ridding & Other Games","Hard Drinks Free","Daily Buffet","BBQ Dinner","BOOK PACKAGE","Spring Special","12000/-","icon/package3.jpg"};

        JTabbedPane tab = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1",null,p1);

        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2",null,p2);


        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3",null,p3);

        add(tab);

        setVisible(true);
    }
    public JPanel createPackage(String[] pack){
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);

        JLabel l1 = new JLabel(pack[0]);
        l1.setForeground(new Color(231, 157, 28));
        l1.setBounds(40,5,300,30);
        l1.setFont(new Font("Tahome",Font.BOLD,30));
        p1.add(l1);

        JLabel l2 = new JLabel(pack[1]);
        l2.setForeground(new Color(28, 194, 231));
        l2.setBounds(20,60,300,30);
        l2.setFont(new Font("Tahome",Font.BOLD,20));
        p1.add(l2);

        JLabel l3 = new JLabel(pack[2]);
        l3.setForeground(new Color(28, 31, 231));
        l3.setBounds(20,100,350,30);
        l3.setFont(new Font("Tahome",Font.BOLD,20));
        p1.add(l3);

        JLabel l4 = new JLabel(pack[3]);
        l4.setForeground(new Color(28, 194, 231));
        l4.setBounds(20,140,300,30);
        l4.setFont(new Font("Tahome",Font.BOLD,20));
        p1.add(l4);

        JLabel l5 = new JLabel(pack[4]);
        l5.setForeground(new Color(28, 31, 231));
        l5.setBounds(20,180,300,30);
        l5.setFont(new Font("Tahome",Font.BOLD,20));
        p1.add(l5);

        JLabel l6 = new JLabel(pack[5]);
        l6.setForeground(new Color(28, 194, 231));
        l6.setBounds(20,220,300,30);
        l6.setFont(new Font("Tahome",Font.BOLD,20));
        p1.add(l6);

        JLabel l7 = new JLabel(pack[6]);
        l7.setForeground(new Color(28, 31, 231));
        l7.setBounds(20,260,300,30);
        l7.setFont(new Font("Tahome",Font.BOLD,20));
        p1.add(l7);

        JLabel l8 = new JLabel(pack[7]);
        l8.setForeground(new Color(28, 194, 231));
        l8.setBounds(20,300,300,30);
        l8.setFont(new Font("Tahome",Font.BOLD,20));
        p1.add(l8);

        JLabel l9 = new JLabel(pack[8]);
        l9.setForeground(Color.BLACK);
        l9.setBounds(60,370,300,30);
        l9.setFont(new Font("Tahome",Font.BOLD,25));
        p1.add(l9);

        JLabel l10 = new JLabel(pack[9]);
        l10.setForeground(Color.MAGENTA);
        l10.setBounds(80,410,300,30);
        l10.setFont(new Font("Tahome",Font.BOLD,25));
        p1.add(l10);

        JLabel l11 = new JLabel(pack[10]);
        l11.setForeground(Color.CYAN);
        l11.setBounds(450,410,300,30);
        l11.setFont(new Font("Tahome",Font.BOLD,25));
        p1.add(l11);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(pack[11]));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(350,30,500,300);
        p1.add(image);

        return p1;
    }
    public static void main(String[] args) {
        new CheckPackage();
    }
}

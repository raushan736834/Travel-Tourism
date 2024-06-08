import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener {
    JButton back;
    About(){
        setBounds(400,150,500,500);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(180,10,100,40);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahome",Font.PLAIN,20));
        add(l1);

        String s = "About Projects......             \n"+
                "     \n"+
                "The objective of the Travel and Tourism Management System Project is to develop a system that automates the processes and activities of a travel and the purpose is to design a system using which one can perform all operations  related to travelling. \n" +
                "\n"+
                "This application will hel in accessing the information related to the travel to the particular destination with great ease. The users can track the information related to their tours with great ease thought this application. The travel agency information can also be obtained through this application.  \n"+
                "\n"+
                "Advantages to Projects:\n"+
                "`Gives accurate information\n"+
                "`Simplifies the manual work\n"+
                "`It minimizes the documentation related work\n"+
                "`Provides up to date information\n"+
                "`Friendly Environment by providing warning messages\n"+
                "`Travelers details can be provided\n"+
                "`booking confirmation notification";

        TextArea area = new TextArea(s,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,50,450,300);
        add(area);


        back = new JButton("Back");
        back.setBounds(180,380,100,25);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new About();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}

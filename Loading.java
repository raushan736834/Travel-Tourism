import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loading extends JFrame implements Runnable {
    Thread t;
    JProgressBar bar;
    String username;
    public Loading(String username){
        this.username = username;

        t = new Thread(this);
        setBounds(450,170,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(60,20,520,40);
        text.setFont(new Font("Tahome", Font.BOLD,35));
        text.setForeground(Color.BLUE);
        add(text);

        bar = new JProgressBar();
        bar.setBounds(150, 90,300,35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading, Please wait...");
        loading.setBounds(210,120,180,30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway",Font.BOLD,16));
        add(loading);

        JLabel lblUsername = new JLabel("Welcome, "+username);
        lblUsername.setBounds(20,310,400,40);
        lblUsername.setForeground(Color.RED);
        lblUsername.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblUsername);

        t.start();
        setVisible(true);
    }
    public static void main(String[] args) {
        new Loading("");
    }

    @Override
    public void run() {
        try{
            for (int i = 1; i <= 101; i++) {
                int max = bar.getMaximum(); // 100
                int value = bar.getValue();

                if(value < max){
                    bar.setValue(bar.getValue()+1);
                }else{
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

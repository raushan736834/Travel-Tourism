import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener {
    Paytm(){
        setBounds(300,100,800,600);
        setLayout(null);

        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);

        try{
            pane.setPage("https://paytm.com/");
        }catch (Exception e){
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, Error 404</html>");
        }


        JScrollPane scrollPane = new JScrollPane(pane);
        scrollPane.setBounds(10, 10, 760, 500); // Set bounds for the scroll pane
        add(scrollPane);


        JButton back = new JButton("Back");
        back.setBounds(300,20,100,30);
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        pane.add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Paytm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Payment();
    }
}

package JFrameExample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author P51
 */
public class JFrameExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JFrame Example");
        
        JButton btn = new JButton("Username");
        btn.setBounds(50, 20, 100, 30);
        
        JButton btn2 = new JButton("Password");
        btn2.setBounds(50, 60, 100, 30);
        
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ong da an vao username");
            }
           
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ong da an vao password");
            }
        });
        
        JLabel lb1 = new JLabel("Username: ");
        JLabel lb2 = new JLabel("Password: ");
        lb1.setBounds(50, 50, 100, 30);
        lb2.setBounds(50, 90, 100, 30);


        JTextField username = new JTextField("Enter username");
        JTextField password = new JTextField("Enter password");
        username.setBounds(150, 50, 120, 30);
        password.setBounds(150, 90, 120, 30);


        JButton login = new JButton("Login");
        login.setBounds(100, 130, 100, 30);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Username: " + username.getText());
                System.out.println("Password: " + password.getText());
                username.setText("Ban da dang nhap thanh cong");
            }
        });
        

        frame.add(lb1);
        frame.add(lb2);
        frame.add(username);
        frame.add(password);
        frame.add(login);
        // frame.add(btn);
        
        // frame.add(btn2);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // cho man hinh ra giua
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

package JFrameExample2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;  

public class JFrameExample2 {
    public static void main(String[] args) {
        // Write your code here

        JFrame frame = new JFrame("JFrame Example");
        JTextArea textArea = new JTextArea();
        textArea.setBounds(20, 20, 300, 300);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JPasswordField password = new JPasswordField();
        password.setBounds(150, 90, 120, 30);
        JButton btn2 = new JButton("Password");
        btn2.setBounds(50, 60, 100, 30);
        frame.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (password.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(frame, "Password is empty");
                    return;
                } else {
                    JOptionPane.showMessageDialog(frame, "Password is not empty");
                }
                System.out.println(password.getPassword());
                String s = String.valueOf(password.getPassword());
                System.out.println(s);
            }
        });
        
        frame.add(password);
        frame.add(btn2);
        frame.add(textArea);

        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
}

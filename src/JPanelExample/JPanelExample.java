package JPanelExample;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;

public class JPanelExample {
    public static void main(String[] args) {
        // Write your code here
        JFrame frame = new JFrame("Panel");
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JButton button = new JButton("Panel1");
        JButton button1 = new JButton("Panel2");
        button.setBounds(50, 100, 100, 30);
        button1.setBounds(50, 100, 100, 30);
        panel.add(button);
        panel1.add(button1);
        panel.setBounds(0, 0, 300, 150);
        panel1.setBounds(150, 0, 300, 150);
        frame.add(panel);
        frame.add(panel1);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

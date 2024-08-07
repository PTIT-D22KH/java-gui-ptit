package BorderLayoutExample;

import javax.swing.*;
import java.awt.*;
public class BorderLayoutExample {
    public static void main(String[] args) {
        // Write your code here
        JFrame frame = new JFrame("Border Layout");
        JButton button1 = new JButton("North");
        JButton button2 = new JButton("South");
        JButton button3 = new JButton("East");
        JButton button4 = new JButton("West");
        JButton button5 = new JButton("Center");

        frame.setLayout(new BorderLayout(5, 10));
        frame.add(button1, BorderLayout.NORTH);
        frame.add(button2, BorderLayout.SOUTH);
        frame.add(button3, BorderLayout.EAST);
        frame.add(button4, BorderLayout.WEST);
        frame.add(button5, BorderLayout.CENTER);
        
        frame.setSize(500, 500);
        
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        

    }
}

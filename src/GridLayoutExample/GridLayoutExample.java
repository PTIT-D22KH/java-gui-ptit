package GridLayoutExample;

import javax.swing.*;
import java.awt.*;

public class GridLayoutExample {
    public static void main(String[] args) {
        // Write your code here
        JFrame frame = new JFrame("Grid Layout");
        JButton[] buttons = new JButton[9];
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("Button " + (i + 1));
        }
        frame.setLayout(new GridLayout(3, 3, 10, 10));
        for (int i = 0; i < 9; i++) {
            frame.add(buttons[i]);
        }
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

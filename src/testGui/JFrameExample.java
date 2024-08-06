/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testGui;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author P51
 */
public class JFrameExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JFrame Example");
        
        JButton btn = new JButton("Username");
        btn.setBounds(50, 60, 100, 30);
        
        JButton btn2 = new JButton("Password");
        btn2.setBounds(50, 60, 100, 30);
        
        frame.add(btn);
        frame.add(btn2);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

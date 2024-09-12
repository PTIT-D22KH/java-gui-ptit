/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package own;

/**
 *
 * @author P51
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TestFrame extends Frame{
   
    public static void main(String[] args) {
        JFrame frame = new JFrame("JFrame Example");
        
        /*
        Add label into the frame
        */
        JLabel label = new JLabel("Label: ");
        label.setBounds(50, 25, 150, 30);
        frame.add(label);
        
        
        /*
        Add text field into the frame
        */
        JTextField field = new JTextField("Enter: ");
        field.setBounds(100, 25, 150, 30);
        frame.add(field);
        
        
        
        /*
        
        Create a button
        */
        JButton button = new JButton("Click");
        button.setBounds(100, 50, 80, 30);
        frame.setSize(300, 200);
        frame.add(button);
        button.addActionListener(new ActionListener() {
            private int count = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ban da nhan vao Button Click !");
                count++;
                button.setText(String.format("Click %d!", count));
                System.out.println(field.getText());
            }
        });
        
        /*
        
        Add properties for the frame
        */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

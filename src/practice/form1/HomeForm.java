/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.form1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
/**
 *
 * @author P51
 */
public class HomeForm extends JFrame{
    private JTextField field;
    private JButton signOutButton;

    /**
     * Constructor to set up the frame
     */
    public HomeForm() {
        // Set up the frame
        this.setTitle("Home Form");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // Add label
        field = new JTextField();
        field.setBounds(50, 50, 300, 30);
        field.setText("Welcome to the Home Page!");
        field.setEditable(false);

        // Add button
        signOutButton = new JButton("Sign Out");
        signOutButton.setBounds(50, 100, 100, 30);
        signOutButton.addActionListener(new SignOutButtonClickListener());

        // Add components
        this.add(field);
        this.add(signOutButton);

        // Set Visible
        this.setVisible(true);
    }

    /**
     * Inner class to handle the sign out button click event
     */
    private class SignOutButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AuthenticationForm();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.form1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author P51
 */
public class ResetPassword extends JFrame{
    private JLabel usernameLabel, passwordLabel, confirmPasswordLabel;
    private JPasswordField  passwordField, confirmPasswordField;
    private JTextField usernameField;
    private JButton resetButton;
    /**
     * Constructor to set up the frame
     */
    public ResetPassword(){
        // Set up the frame
        setTitle("Reset Password");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Add label
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(50, 50, 100, 30);
        passwordLabel = new JLabel("New Password");
        passwordLabel.setBounds(50, 100, 100, 30);
        confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setBounds(50, 150, 150, 30);

        // Add text field
        usernameField = new JTextField();
        usernameField.setBounds(200, 50, 150, 30);
        passwordField = new JPasswordField();
        passwordField.setBounds(200, 100, 150, 30);
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(200, 150, 150, 30);

        // Add button
        resetButton = new JButton("Reset");
        resetButton.setBounds(50, 200, 100, 30);
        resetButton.addActionListener(new ResetButtonClickListener());

        // Add components
        add(usernameLabel);
        add(passwordLabel);
        add(confirmPasswordLabel);
        add(usernameField);        
        add(passwordField);
        add(confirmPasswordField);
        add(resetButton);

        // Set Visible
        setVisible(true);
    }

    /**
     * Inner  class to handle the reset button click event
     */
    private class ResetButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            if (!AuthenticationForm.getDatabase().containsKey(username)) {
                JOptionPane.showMessageDialog(null, "Username does not exist! Try again");
                return;
            }
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());
            if (password.equals(confirmPassword)) {
                // Update the password in the database
                AuthenticationForm.getDatabase().put(username, password);
                JOptionPane.showMessageDialog(null, "Password reset successfully");
                AuthenticationForm.saveDataToFile();
                LoginForm loginForm = new LoginForm();
                ResetPassword.this.dispose();

                
            } else {
                JOptionPane.showMessageDialog(null, "Passwords do not match! Try again");
            }
        }   
    }
}

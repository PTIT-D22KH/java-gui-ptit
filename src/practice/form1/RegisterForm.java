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
public class RegisterForm extends JFrame{
    private JLabel usernameLabel, passwordLabel, confirmPasswordLabel;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton signUpButton;
    private JTextField usernameField;
    private JOptionPane confirmPasswordPane;

    /**
     * Constructor to set up the frame
     */
    public RegisterForm() {
        this.setTitle("Register Form");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // Add label
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(50, 50, 100, 30);
        passwordLabel = new JLabel("Password");
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
        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(50, 200, 100, 30);
        signUpButton.addActionListener(new SignUpButtonClickListener());
        
        // Add components
        this.add(usernameLabel);
        this.add(passwordLabel);
        this.add(confirmPasswordLabel);
        this.add(usernameField);
        this.add(passwordField);
        this.add(confirmPasswordField);
        this.add(signUpButton);

        // Set Visible
        this.setVisible(true);
    }

    /**
     * Inner class to handle the sign up button click event
     */
    private class SignUpButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());
            password = password.trim();
            String confirmPassword = new String(confirmPasswordField.getPassword());
            confirmPassword = confirmPassword.trim();
            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                confirmPasswordPane.showMessageDialog(null, "Please fill in all fields");
                return;
            }
            if (AuthenticationForm.getDatabase().containsKey(username)) {
                confirmPasswordPane.showMessageDialog(null, "Username already exists");
                return;
            }
            if (password.equals(confirmPassword)) {
                AuthenticationForm.getDatabase().put(username, password);
                AuthenticationForm.saveDataToFile();
                confirmPasswordPane.showMessageDialog(null, "Account created successfully");
                
                dispose();
                LoginForm loginForm = new LoginForm();
            } else {
                confirmPasswordPane.showMessageDialog(null, "Password does not match");
            }
        }
    }
}

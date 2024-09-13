/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.form1;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author P51
 */
public class LoginForm extends JFrame{
    private JLabel usernameLabel, passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton, signUpButton, forgotPasswordButton;
    private JTextField usernameField;
    private JOptionPane loginPane;
    
    /**
     * Constructor to set up the frame
     */
    public LoginForm() {
        // Set up the frame
        this.setTitle("Login Form");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        
        // Add label
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(50, 50, 100, 30);
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 100, 100, 30);
        forgotPasswordButton = new JButton("Forgot Password");
        forgotPasswordButton.setBounds(50, 200, 150, 30);
        forgotPasswordButton.addActionListener(new ForgotPasswordButtonClickListener());

        // Add text field
        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 150, 30);
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 150, 30);

        // Add button
        loginButton = new JButton("Login");
        loginButton.setBounds(50, 150, 100, 30);
        loginButton.addActionListener(new LoginButtonClickListener());
        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(200, 150, 100, 30);
        signUpButton.addActionListener(new DirectToSignUpButtonClickListener());
        
        // Add components to the frame
        this.add(usernameLabel);
        this.add(passwordLabel);
        this.add(forgotPasswordButton);
        this.add(usernameField);
        this.add(passwordField);
        this.add(loginButton);
        this.add(signUpButton);


        // Set visible to the login form
        setVisible(true);
    }

    /**
     * Inner class to handle the login button click events
     */
    private class LoginButtonClickListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the username and password
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            String correctPassword = AuthenticationForm.getDatabase().get(username);
            if (password.equals(correctPassword)) {
                loginPane.showMessageDialog(null, "Login successful");
                AuthenticationForm.saveDataToFile();
                HomeForm homeForm = new HomeForm();
                LoginForm.this.dispose();
            } else {
                loginPane.showMessageDialog(null, "Login failed");
            }
            
        }
    }

    /**
     * Inner class to handle the sign up button click events
     */
    private class DirectToSignUpButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            RegisterForm registerForm = new RegisterForm();
            LoginForm.this.dispose();
        }
    }

    /**
     * Inner class to handle the forgot password button click events
     */
    private class ForgotPasswordButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ResetPassword resetPassword = new ResetPassword();
            LoginForm.this.dispose();
        }
    }
}

package practice.form2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * AuthenticationForm class demonstrates a simple Swing application with a JFrame.
 * 
 * The frame displays a login form and handles user authentication.
 * 
 * @param args Command line arguments
 * 
 * @return AuthenticationForm object
 * 
 */
public class AuthenticationForm extends JFrame {
    private LoginForm loginForm;
    private RegisterForm registerForm;
    private HomeForm homeForm;
    private JLabel loginLabel, registerLabel;
    private JButton loginButton, registerButton;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/self_learn1";
    private static final String USER_NAME = "test_user";
    private static final String PASSWORD = "superSecretPassword!123";
    private Connection conn;

    /**
     * Constructor to set up the form and its components
     */
    public AuthenticationForm() {
        conn = getConnection(DB_URL, USER_NAME, PASSWORD);
        
        // Set up the frame
        this.setTitle("Authentication Form");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // Add labels
        loginLabel = new JLabel("Login");
        loginLabel.setBounds(50, 50, 100, 30);
        registerLabel = new JLabel("Sign up");
        registerLabel.setBounds(50, 100, 100, 30);

        // Add buttons
        loginButton = new JButton("Login");
        loginButton.setBounds(200, 50, 100, 30);
        loginButton.addActionListener(new DirectToLoginButtonClickListener());
        registerButton = new JButton("Sign up");
        registerButton.setBounds(200, 100, 100, 30);
        registerButton.addActionListener(new DirectToSignUpButtonClickListener());

        // Add components to the frame
        this.add(loginLabel);
        this.add(registerLabel);
        this.add(loginButton);
        this.add(registerButton);

        // Make the frame visible
        this.setVisible(true);
    }

    /**
     * Inner class to handle the action of the login button
     */
    private class DirectToLoginButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginForm = new LoginForm(conn);
            loginForm.setVisible(true);
            AuthenticationForm.this.dispose();
        }
    }

    /**
     * Inner class to handle the action of the register button
     */
    private class DirectToSignUpButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            registerForm = new RegisterForm(conn);
            registerForm.setVisible(true);
            AuthenticationForm.this.dispose();
        }
    }

    /**
     * Method to connect to MySQL database
     */
    public static Connection getConnection(String dbURL, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("Connect successfully!");
        } catch (Exception ex) {
            System.out.println("Connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    /**
     * Main method to run the program
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AuthenticationForm());
    }
}
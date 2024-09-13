package practice.form2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LoginForm extends JFrame {
    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, signUpButton, forgotPasswordButton;
    private Connection conn;

    public LoginForm(Connection conn) {
        this.conn = conn;

        // Set up the frame
        this.setTitle("Login Form");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // Add labels
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(50, 50, 100, 30);
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 100, 100, 30);

        // Add text fields
        usernameField = new JTextField();
        usernameField.setBounds(200, 50, 150, 30);
        passwordField = new JPasswordField();
        passwordField.setBounds(200, 100, 150, 30);

        // Add buttons
        loginButton = new JButton("Login");
        loginButton.setBounds(50, 150, 100, 30);
        loginButton.addActionListener(new LoginButtonClickListener());

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(200, 150, 100, 30);
        signUpButton.addActionListener(new DirectToSignUpButtonClickListener());

        forgotPasswordButton = new JButton("Forgot Password");
        forgotPasswordButton.setBounds(50, 200, 150, 30);
        forgotPasswordButton.addActionListener(new ForgotPasswordButtonClickListener());

        // Add components to the frame
        this.add(usernameLabel);
        this.add(passwordLabel);
        this.add(usernameField);
        this.add(passwordField);
        this.add(loginButton);
        this.add(signUpButton);
        this.add(forgotPasswordButton);

        // Make the frame visible
        this.setVisible(true);
    }

    private class LoginButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (authenticateUser(username, password)) {
                JOptionPane.showMessageDialog(null, "Login successful");
                new HomeForm(conn).setVisible(true);
                LoginForm.this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }
        }

        private boolean authenticateUser(String username, String password) {
            String query = "SELECT * FROM User WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                return rs.next();
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
    }

    private class DirectToSignUpButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new RegisterForm(conn).setVisible(true);
            LoginForm.this.dispose();
        }
    }

    private class ForgotPasswordButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ResetPasswordForm(conn).setVisible(true);
            LoginForm.this.dispose();
        }
    }

//    public static void main(String[] args) {
//        // Example usage
//        Connection conn = getConnection("jdbc:mysql://localhost:3306/test", "test_user", "superSecretPassword!123");
//        new LoginForm(conn);
//    }
//
//    private static Connection getConnection(String dbURL, String userName, String password) {
//        Connection conn = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(dbURL, userName, password);
//            System.out.println("Connect successfully!");
//        } catch (Exception ex) {
//            System.out.println("Connect failure!");
//            ex.printStackTrace();
//        }
//        return conn;
//    }
}
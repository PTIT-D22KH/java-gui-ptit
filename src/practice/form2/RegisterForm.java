package practice.form2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class RegisterForm extends JFrame {
    private JLabel usernameLabel, passwordLabel, confirmPasswordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton registerButton;
    private Connection conn;

    public RegisterForm(Connection conn) {
        this.conn = conn;

        // Set up the frame
        this.setTitle("Register Form");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // Add labels
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(50, 50, 100, 30);
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 100, 100, 30);
        confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setBounds(50, 150, 150, 30);

        // Add text fields
        usernameField = new JTextField();
        usernameField.setBounds(200, 50, 150, 30);
        passwordField = new JPasswordField();
        passwordField.setBounds(200, 100, 150, 30);
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(200, 150, 150, 30);

        // Add button
        registerButton = new JButton("Register");
        registerButton.setBounds(50, 200, 100, 30);
        registerButton.addActionListener(new RegisterButtonClickListener());

        // Add components to the frame
        this.add(usernameLabel);
        this.add(passwordLabel);
        this.add(confirmPasswordLabel);
        this.add(usernameField);
        this.add(passwordField);
        this.add(confirmPasswordField);
        this.add(registerButton);

        // Make the frame visible
        this.setVisible(true);
    }

    private class RegisterButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match");
                return;
            }

            if (registerUser(username, password)) {
                JOptionPane.showMessageDialog(null, "Registration successful");
                new LoginForm(conn).setVisible(true);
                RegisterForm.this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to register user");
            }
        }

        private boolean registerUser(String username, String password) {
            String query = "INSERT INTO User (username, password) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                int rowsInserted = stmt.executeUpdate();
                return rowsInserted > 0;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
    }
}
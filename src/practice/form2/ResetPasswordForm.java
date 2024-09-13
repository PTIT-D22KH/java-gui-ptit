package practice.form2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ResetPasswordForm extends JFrame {
    private JLabel usernameLabel, newPasswordLabel, confirmPasswordLabel;
    private JTextField usernameField;
    private JPasswordField newPasswordField, confirmPasswordField;
    private JButton resetButton;
    private Connection conn;

    public ResetPasswordForm(Connection conn) {
        this.conn = conn;

        // Set up the frame
        this.setTitle("Reset Password");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // Add labels
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(50, 50, 100, 30);
        newPasswordLabel = new JLabel("New Password");
        newPasswordLabel.setBounds(50, 100, 100, 30);
        confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setBounds(50, 150, 150, 30);

        // Add text fields
        usernameField = new JTextField();
        usernameField.setBounds(200, 50, 150, 30);
        newPasswordField = new JPasswordField();
        newPasswordField.setBounds(200, 100, 150, 30);
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(200, 150, 150, 30);

        // Add button
        resetButton = new JButton("Reset Password");
        resetButton.setBounds(50, 200, 150, 30);
        resetButton.addActionListener(new ResetButtonClickListener());

        // Add components to the frame
        this.add(usernameLabel);
        this.add(newPasswordLabel);
        this.add(confirmPasswordLabel);
        this.add(usernameField);
        this.add(newPasswordField);
        this.add(confirmPasswordField);
        this.add(resetButton);

        // Make the frame visible
        this.setVisible(true);
    }

    private class ResetButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String newPassword = new String(newPasswordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (!newPassword.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match");
                return;
            }

            if (resetPassword(username, newPassword)) {
                JOptionPane.showMessageDialog(null, "Password reset successful");
                new LoginForm(conn).setVisible(true);
                ResetPasswordForm.this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to reset password");
            }
        }

        private boolean resetPassword(String username, String newPassword) {
            String query = "UPDATE User SET password = ? WHERE username = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, newPassword);
                stmt.setString(2, username);
                int rowsUpdated = stmt.executeUpdate();
                return rowsUpdated > 0;
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
        }
    }
}
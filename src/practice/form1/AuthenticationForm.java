package practice.form1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

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
    private static Map<String, String> database = new HashMap<>();
    private static final String FILE_PATH = "src/practice/form1/data.txt";

    /**
     * Constructor to set up the form and its components
     */
    public AuthenticationForm() {
        // Load data from file
        loadUsersFromFile();

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

    public static Map<String, String> getDatabase() {
        return database;
    }

    /**
     * Inner class to handle the action of the login button
     */
    private class DirectToLoginButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginForm = new LoginForm();
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
            registerForm = new RegisterForm();
            registerForm.setVisible(true);
            AuthenticationForm.this.dispose();
        }
    }

    /**
     * Method to load data from file into a map
     */
    private void loadUsersFromFile() {
        try (Scanner input = new Scanner(new File(FILE_PATH))) {
            while (input.hasNextLine()) {
                String s = input.nextLine().trim();
                String[] a = s.split(",");
                if (a.length == 2) {
                    database.put(a[0], a[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to save data from map to file
     */
    public static void saveDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Map.Entry<String, String> entry : database.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Main method to run the program
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AuthenticationForm());
    }
}
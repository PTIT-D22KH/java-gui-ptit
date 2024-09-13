package practice.codeptitGUIVersion.J05007;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * UserInterface class demonstrates a simple Swing application with a JFrame and JPanel.
 * 
 * The panel displays input fields and a table of employees.
 * 
 * @param employees List of employees to display in the table
 * 
 * @return UserInterface object
 * 
 */
public class UserInterface extends JFrame {
    private JLabel nameLabel, genderLabel, dobLabel, addressLabel, taxIdLabel, contractDateLabel;
    private JTextField nameField, genderField, dobField, addressField, taxIdField, contractDateField;
    private JButton button;
    private JPanel inputPanel;
    private EmployeeView employeeView;
    private ArrayList<Employee> employees;

    public UserInterface() {
        // Init the list of employees
        employees = new ArrayList<>();

        // Set up the frame
        this.setTitle("J05007: SAP XEP DANH SACH DOI TUONG NHAN VIEN");
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Create input panel
        inputPanel = new JPanel();
        inputPanel.setLayout(null);
        inputPanel.setPreferredSize(new Dimension(800, 400));

        // Add labels
        nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 50, 100, 30);
        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(50, 100, 100, 30);
        dobLabel = new JLabel("Date of Birth");
        dobLabel.setBounds(50, 150, 100, 30);
        addressLabel = new JLabel("Address");
        addressLabel.setBounds(50, 200, 100, 30);
        taxIdLabel = new JLabel("Tax ID");
        taxIdLabel.setBounds(50, 250, 100, 30);
        contractDateLabel = new JLabel("Contract Date");
        contractDateLabel.setBounds(50, 300, 100, 30);

        // Add text fields
        nameField = new JTextField();
        nameField.setBounds(200, 50, 300, 30);
        genderField = new JTextField();
        genderField.setBounds(200, 100, 300, 30);
        dobField = new JTextField();
        dobField.setBounds(200, 150, 300, 30);
        addressField = new JTextField();
        addressField.setBounds(200, 200, 300, 30);
        taxIdField = new JTextField();
        taxIdField.setBounds(200, 250, 300, 30);
        contractDateField = new JTextField();
        contractDateField.setBounds(200, 300, 300, 30);

        // Add button
        button = new JButton("Add employee");
        button.setBounds(250, 350, 200, 50);
        button.addActionListener(new ButtonClickListener());

        // Add components to input panel
        inputPanel.add(nameLabel);
        inputPanel.add(genderLabel);
        inputPanel.add(dobLabel);
        inputPanel.add(addressLabel);
        inputPanel.add(taxIdLabel);
        inputPanel.add(contractDateLabel);
        inputPanel.add(nameField);
        inputPanel.add(genderField);
        inputPanel.add(dobField);
        inputPanel.add(addressField);
        inputPanel.add(taxIdField);
        inputPanel.add(contractDateField);
        inputPanel.add(button);

        // Create employee view panel
        employeeView = new EmployeeView(employees);

        // Add panels to frame
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(employeeView, BorderLayout.CENTER);

        // Make the frame visible
        this.setVisible(true);
    }

    /**
     * Inner class to handle button click events
     * Add a record when clicked
     */
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the data
            String name = nameField.getText().trim();
            String gender = genderField.getText().trim();
            String dob = dobField.getText().trim();
            String address = addressField.getText().trim();
            String taxId = taxIdField.getText().trim();
            String contractDate = contractDateField.getText().trim();

            // Create the employee instance
            Employee employee = new Employee(name, gender, dob, address, taxId, contractDate);

            // Add the employee to the arraylist
            employees.add(employee);

            // Sort the list
            Collections.sort(employees, new CompareByTime());

            // Update the table
            employeeView.updateTable(employees);
        }
    }

    /**
     * Main method to create and display the frame
     * @param args 
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserInterface());
    }
}
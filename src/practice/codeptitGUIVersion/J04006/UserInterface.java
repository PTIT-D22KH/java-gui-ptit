package practice.codeptitGUIVersion.J04006;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * UserInterface class demonstrates a simple Swing application with a JFrame,
 * JLabel, JTextField, and JButton.
 * 
 * The button click adds a student with the provided details and shows a new frame with a table of students.
 * 
 * @param students List of students to display in the table
 * 
 * @return UserInterface object
 * 
 * @author P51
 */
public class UserInterface extends JFrame {
    private JLabel nameLabel, classNameLabel, dobLabel, gpaLabel;
    private JTextField nameField, classNameField, dobField, gpaField;
    private JButton button;
    private List<Student> students;
    private StudentView studentView;

    /**
     * Constructor to set up the frame and its components.
     */
    public UserInterface() {
        // Initialize the list of students
        students = new ArrayList<>();

        // Set up the frame
        setTitle("J04006: KHAI BAO LOP SINH VIEN");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Add labels
        nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 50, 100, 30);
        classNameLabel = new JLabel("Class Name");
        classNameLabel.setBounds(50, 100, 100, 30);
        dobLabel = new JLabel("Date of birth");
        dobLabel.setBounds(50, 150, 100, 30);
        gpaLabel = new JLabel("GPA");
        gpaLabel.setBounds(50, 200, 100, 30);

        // Add text fields
        nameField = new JTextField();
        nameField.setBounds(200, 50, 300, 30);
        classNameField = new JTextField();
        classNameField.setBounds(200, 100, 300, 30);
        dobField = new JTextField();
        dobField.setBounds(200, 150, 300, 30);
        gpaField = new JTextField();
        gpaField.setBounds(200, 200, 300, 30);

        // Add button
        button = new JButton("Add student");
        button.setBounds(300, 600, 200, 100);
        button.addActionListener(new ButtonClickListener());

        // Add components
        add(nameLabel);
        add(classNameLabel);
        add(dobLabel);
        add(gpaLabel);
        add(nameField);
        add(classNameField);
        add(dobField);
        add(gpaField);
        add(button);

        // Make the frame visible
        setVisible(true);
    }

    /**
     * Inner class to handle button click events
     */
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText().trim();
            String className = classNameField.getText().trim();
            String dob = dobField.getText().trim();
            double gpa = Double.parseDouble(gpaField.getText().trim());
            Student student = new Student(name, className, dob, gpa);
            students.add(student);
            Collections.sort(students, new StudentNameComparator());
            if (studentView == null) {
                studentView = new StudentView(students);
            } else {
                studentView.updateTable(students);
            }
        }
    }

    /**
     * Main method to create and display the frame
     * @param args 
     */
    public static void main(String[] args) {
        // Create and display the frame
        SwingUtilities.invokeLater(() -> new UserInterface());
    }
}
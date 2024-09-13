package practice.form2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.List;

/**
 * HomeForm class demonstrates a simple Swing application with a JFrame.
 * 
 * The frame displays a form to add students and handles user sign out.
 * 
 */
public class HomeForm extends JFrame {
    private JButton addStudentButton, signOutButton, viewStudentsButton;
    private JLabel nameLabel, classNameLabel, dobLabel, gpaLabel;
    private JTextField nameField, classNameField, dobField, gpaField;
    private Connection conn;
    private List<Student> students;

    /**
     * Constructor to set up the frame
     */
    public HomeForm(Connection conn) {
        this.conn = conn;
        this.students = new ArrayList<>();

        // Set up the frame
        this.setTitle("Home Form");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

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

        // Add buttons
        addStudentButton = new JButton("Add student");
        addStudentButton.setBounds(300, 600, 200, 100);
        addStudentButton.addActionListener(new AddStudentButtonClickListener());
        
        signOutButton = new JButton("Sign Out");
        signOutButton.setBounds(50, 300, 100, 30);
        signOutButton.addActionListener(new SignOutButtonClickListener());

        viewStudentsButton = new JButton("View Students");
        viewStudentsButton.setBounds(50, 400, 150, 30);
        viewStudentsButton.addActionListener(new ViewStudentsButtonClickListener());

        // Add components
        add(nameLabel);
        add(classNameLabel);
        add(dobLabel);
        add(gpaLabel);
        add(nameField);
        add(classNameField);
        add(dobField);
        add(gpaField);
        add(addStudentButton);
        add(signOutButton);
        add(viewStudentsButton);

        // Set Visible
        this.setVisible(true);
    }

    /**
     * Inner class to handle the add student button click event
     */
    private class AddStudentButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String className = classNameField.getText();
            String dob = dobField.getText();
            double gpa;

            try {
                gpa = Double.parseDouble(gpaField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid GPA format");
                return;
            }

            if (name.trim().isEmpty() || className.trim().isEmpty() || dob.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
                return;
            }

            try {
                String studentId = generateStudentId();
                Student student = new Student(studentId, name, className, dob, gpa);
                addStudentToDatabase(student);
                students.add(student);
                JOptionPane.showMessageDialog(null, "Student added successfully");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred while adding the student");
            }
        }

        private void addStudentToDatabase(Student student) throws SQLException {
            String query = "INSERT INTO Student (id, name, className, dob, gpa) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, student.getId());
                stmt.setString(2, student.getName());
                stmt.setString(3, student.getClassName());
                stmt.setDate(4, Date.valueOf(formatDob(student.getDob())));
                stmt.setDouble(5, student.getGpa());
                stmt.executeUpdate();
            }
        }

        private String generateStudentId() throws SQLException {
            String query = "SELECT COUNT(*) AS count FROM Student";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                if (rs.next()) {
                    int count = rs.getInt("count") + 1;
                    return String.format("B20DCCN%03d", count);
                } else {
                    throw new SQLException("Failed to generate student ID");
                }
            }
        }

        private String formatDob(String dob) {
            String[] parts = dob.trim().split("/");
            return String.format("%s-%s-%s", parts[2], parts[1], parts[0]);
        }
    }

    /**
     * Inner class to handle the sign out button click event
     */
    private class SignOutButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AuthenticationForm();
        }
    }

    /**
     * Inner class to handle the view students button click event
     */
    private class ViewStudentsButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new StudentView(students);
        }
    }

//    public static void main(String[] args) {
//        // Example usage
//        Connection conn = getConnection("jdbc:mysql://localhost:3306/test", "test_user", "superSecretPassword!123");
//        new HomeForm(conn);
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
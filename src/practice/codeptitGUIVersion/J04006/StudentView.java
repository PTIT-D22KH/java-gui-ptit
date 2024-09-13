package practice.codeptitGUIVersion.J04006;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.table.TableRowSorter;

/**
 * StudentView class demonstrates a simple Swing application with a JFrame and JTable.
 * 
 * The table displays a list of students.
 * 
 * @param students List of students to display in the table
 * 
 * @return StudentView object
 * 
 * @author P51
 */
public class StudentView extends JFrame {
    private DefaultTableModel model;
    private JTable table;
    private TableRowSorter<DefaultTableModel> sorter;

    /**
     * Constructor to set up the frame and its components.
     */
    public StudentView(List<Student> students) {
        // Set up the frame
        setTitle("Student Table");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create table model and set columns
        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Class Name");
        model.addColumn("Date of Birth");
        model.addColumn("GPA");

        // Create table with the model
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Populate the table with initial data
        updateTable(students);
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        // Make the frame visible
        setVisible(true);
    }

    /**
     * Method to update the table with new student data
     */
    public void updateTable(List<Student> students) {
        // Clear existing rows
        model.setRowCount(0);

        // Add rows to the table model
        for (Student student : students) {
            model.addRow(new Object[]{student.getName(), student.getClassName(), student.getDob(), student.getGpa()});
        }
        
    }
}
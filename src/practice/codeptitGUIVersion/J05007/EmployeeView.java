package practice.codeptitGUIVersion.J05007;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.*;

/**
 * EmployeeView class demonstrates a simple Swing application with a JFrame and JTable.
 * 
 * The table displays a list of employees.
 * 
 * @param employees List of employees to display in the table
 * 
 * @return EmployeeView object
 * 
 */
public class EmployeeView extends JPanel {
    private JTable table;
    private DefaultTableModel model;
    private TableRowSorter<DefaultTableModel> sorter;
    private JScrollPane scrollPane;
    
    /**
     * Constructor to set up the panel and its components
     */
    public EmployeeView(ArrayList<Employee> employees) {
        this.setLayout(new BorderLayout());
        
        // Create the table model
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("Date of Birth");
        model.addColumn("Address");
        model.addColumn("Tax ID");
        model.addColumn("Contract Date");
        
        // Create table with model
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        
        // Update the table
        updateTable(employees);
        
        // Add sorter
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        
    }
    
    /**
     * Method to update the table with new employee data
     */
    public void updateTable(ArrayList<Employee> employees) {
        // Clear existing rows
        model.setRowCount(0);
        
        // Add rows to the table model
        for (Employee employee : employees) {
            model.addRow(new Object[]{
                employee.getId(),
                employee.getName(),
                employee.getGender(),
                employee.getDob(),
                employee.getAddress(),
                employee.getTaxId(),
                employee.getContractDate()
            });
        }
    }
    
      
}
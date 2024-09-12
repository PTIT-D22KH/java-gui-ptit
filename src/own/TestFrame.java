package own;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Vector;

/**
 * TestFrame class demonstrates a simple Swing application with a JFrame,
 * JLabel, JTextField, JTextArea, JPasswordField, JButton, and JTable.
 * 
 * The button click updates the button text with the number of clicks and
 * prints the text from the JTextField, JTextArea, and JPasswordField to the console.
 * 
 * A JTable is also added to demonstrate table usage.
 * 
 * Rows can be added to the JTable using a Scanner for dynamic input.
 * 
 * @author P51
 */
public class TestFrame extends JFrame {
    private JLabel label;
    private JTextField field;
    private JButton button;
    private JTextArea jta;
    private JPasswordField password;
    private JTable table;
    private DefaultTableModel model;
    private int count = 0;

    /**
     * Constructor to set up the frame and its components.
     */
    public TestFrame() {
        // Set up the frame
        setTitle("JFrame Example");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create the first JPanel
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3, 1));

        // Initialize components for the first panel
        label = new JLabel("Label: ");
        panel1.add(label);

        field = new JTextField("Enter: ");
        panel1.add(field);

        // Add text area to the first panel
        jta = new JTextArea("Enter text area: ");
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);
        panel1.add(new JScrollPane(jta));

        // Add the first panel to the north region
        add(panel1, BorderLayout.NORTH);

        // Create the second JPanel
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 1));

        // Add password field to the second panel
        password = new JPasswordField();
        panel2.add(password);

        // Add button to the second panel
        button = new JButton("Click");
        panel2.add(button);

        // Add action listeners to the button
        button.addActionListener(new ButtonClickListener());
        button.addActionListener(new ButtonClickGetPasswordListener());

        // Add the second panel to the center region
        add(panel2, BorderLayout.CENTER);

        // Create the third JPanel for JTable
        JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());

        // Create JTable with DefaultTableModel
        table = new JTable();
        model = (DefaultTableModel) table.getModel();
        model.addColumn("ID");
        model.addColumn("Ho Ten");
        model.addColumn("Lop");
        model.addColumn("GPA");
        model.addRow(new Object[]{"SV01", "Nguyen Van Nam", "CNTT1", 3.2});
        model.addRow(new Object[]{"SV02", "Tran Thi Hien", "CNTT2", 3.6});
        model.addRow(new Object[]{"SV03", "Le Van An", "CNTT3", 3.8});
        model.addRow(new Object[]{"SV04", "Pham Thi Thu", "CNTT4", 3.0});
        model.addRow(new Object[]{"SV05", "Nguyen Van Binh", "CNTT5", 3.4});
        model.addRow(new Object[]{"SV06", "Tran Van Cuong", "CNTT6", 3.6});
        model.addRow(new Object[]{"SV07", "Le Thi Thanh", "CNTT7", 3.2});
        model.addRow(new Object[]{"SV08", "Pham Van Tuan", "CNTT8", 3.8});
        model.addRow(new Object[]{"SV09", "Nguyen Thi Thuy", "CNTT9", 3.6});
        model.addRow(new Object[]{"SV10", "Tran Van Thanh", "CNTT10", 3.4});

        JScrollPane tableScrollPane = new JScrollPane(table);
        panel3.add(tableScrollPane, BorderLayout.CENTER);

        // Add the third panel to the south region
        add(panel3, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);

        // Start a new thread to read input from stdin
        new Thread(this::readInputFromStdin).start();
    }

    /**
     * Method to read input from stdin and add rows to the JTable.
     */
    private void readInputFromStdin() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter ID, Ho Ten, Lop, GPA (separated by commas):");
            String input = scanner.nextLine();
            String[] data = input.split(",");
            if (data.length == 4) {
                Vector<Object> newRow = new Vector<>();
                newRow.add(data[0].trim());
                newRow.add(data[1].trim());
                newRow.add(data[2].trim());
                newRow.add(Double.parseDouble(data[3].trim()));
                model.addRow(newRow);
            } else {
                System.out.println("Invalid input. Please enter exactly 4 values separated by commas.");
            }
        }
    }

    /**
     * Inner class to handle button click events to get the password.
     */
    private class ButtonClickGetPasswordListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String s = String.valueOf(password.getPassword());
            System.out.println(s);
            if (s.equals("vucongtuanduong")) {
                JOptionPane.showMessageDialog(TestFrame.this, "Successful!");
            } else {
                JOptionPane.showMessageDialog(TestFrame.this, "Wrong Password!");
            }
        }
    }

    /**
     * Inner class to handle button click events.
     */
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Ban da nhan vao Button Click !");
            count++;
            button.setText(String.format("Click %d!", count));
            // Show a message dialog using JOptionPane
            JOptionPane.showMessageDialog(TestFrame.this, "Button clicked " + count + " times!");
        }
    }

    /**
     * Main method to create and display the frame.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // Create and display the frame
        SwingUtilities.invokeLater(() -> new TestFrame());
    }
}
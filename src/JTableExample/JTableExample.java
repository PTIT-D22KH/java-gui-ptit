package JTableExample;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class JTableExample {
    public static void main(String[] args) {
        // Write your code here
        JFrame frame = new JFrame("Table");
        // Object[][] row = {
        //     {"SV01", "Nguyen Van Nam", "CNTT1", 3.2},
        //     {"SV02", "Tran Thi Hien", "CNTT2", 3.6},
        //     {"SV03", "Le Van An", "CNTT3", 3.8},
        //     {"SV04", "Pham Thi Thu", "CNTT4", 3.0},
        //     {"SV05", "Nguyen Van Binh", "CNTT5", 3.4},
        //     {"SV06", "Tran Van Cuong", "CNTT6", 3.6},
        //     {"SV07", "Le Thi Thanh", "CNTT7", 3.2},
        //     {"SV08", "Pham Van Tuan", "CNTT8", 3.8},
        //     {"SV09", "Nguyen Thi Thuy", "CNTT9", 3.6},
        //     {"SV10", "Tran Van Thanh", "CNTT10", 3.4}
        // };
        // Object[] column = {"ID", "Ho Ten", "Lop", "GPA"};
        // JTable table = new JTable(row, column);
        // table.setAutoCreateRowSorter(true);
        // JScrollPane pane = new JScrollPane(table);  
        // frame.add(pane);
        
        JTable table = new JTable();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
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
        Vector<Object> newRow = new Vector<>();
        JScrollPane pane = new JScrollPane(table);
        frame.add(pane);
        newRow.add("SV11");
        newRow.add("Nguyen Van A");
        newRow.add("CNTT11");
        newRow.add(3.6);
        model.addRow(newRow);
        model.removeRow(2);
        frame.add(new JScrollPane(table));
        
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        System.out.println(table.getValueAt(0, 0));

        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                System.out.print(table.getValueAt(i, j) + " ");
            }
            System.out.println();
        }

    }
}

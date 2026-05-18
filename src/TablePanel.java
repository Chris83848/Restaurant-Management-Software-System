import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class TablePanel extends JPanel {
    public TablePanel(String tableNumber, boolean tableAssigned, Color[] tableColors, Map<JButton, Integer> tableColor) {
        setLayout(new BorderLayout(5, 5));
        setPreferredSize(new Dimension(120, 100));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        JButton table = new JButton(tableNumber);

        // Create table button if table is assigned ot the waiter
        if (tableAssigned) {
            table.setBackground(tableColors[0]);
            tableColor.put(table, 0);

            // Tables change colors when clicked
            table.addActionListener(e -> {
                int current = tableColor.get(table);
                int next = (current + 1) % tableColors.length;
                table.setBackground(tableColors[next]);
                tableColor.put(table, next);
            });

            // Create tab button and functionality
            JButton tabButton = new JButton("Tab");
            tabButton.setPreferredSize(new Dimension(120, 25));
            tabButton.addActionListener(e -> {
                NewMenu menu = new NewMenu();
            });
            add(tabButton, BorderLayout.SOUTH);
        } else {
            // Grey out table if it is unassigned
            table.setBackground(Color.LIGHT_GRAY);
            table.setEnabled(false);
        }
        add(table, BorderLayout.CENTER);
    }
}
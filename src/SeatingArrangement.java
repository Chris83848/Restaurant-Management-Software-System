import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class SeatingArrangement extends JFrame {

    // Store possible table colors
    private final Color[] tableColors = {Color.YELLOW, Color.GREEN, Color.RED};
    private final Map<JButton, Integer> tableColor = new HashMap<>();

    public SeatingArrangement(String waiter, List<String> tableAssignments) {
        setTitle("Restaurant Table Layout for " + waiter);
        setSize(1000, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Add title, legend, and log out button
        add(new TopPanel(usued -> {
            dispose();
            new LoginScreen();
        }), BorderLayout.NORTH);


        // Set table dimensions and spacing
        int width = 120, height = 100, spacingX = 120, spacingY = 50, columns = 6;
        JPanel tablesHolder = new JPanel(null);

        // Create tables using loop
        for (int i = 0; i < 30; i++) {
            int row = i / columns;
            int column = i % columns;

            int x = 50 + column * (width + spacingX);
            int y = 50 + row * (height + spacingY);

            final String tableNumber = "T" + (i + 1);
            boolean tableAssigned = tableAssignments.contains(tableNumber);

            TablePanel tablePanel = new TablePanel(tableNumber, tableAssigned, tableColors, tableColor);
            tablePanel.setBounds(x, y, width, height);
            tablesHolder.add(tablePanel);

        }

        int rows = (int) Math.ceil(30 / (double) columns);
        int totalWidth = columns * width + (columns - 1) * spacingX + 100;
        int totalHeight = rows * height + (rows - 1) * spacingY + 100;
        tablesHolder.setPreferredSize(new Dimension(totalWidth, totalHeight));
        JPanel center = new JPanel(new GridBagLayout());
        center.add(tablesHolder);
        add(center, BorderLayout.SOUTH);
        setVisible(true);
    }
}
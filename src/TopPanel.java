import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;


public class TopPanel extends JPanel {
    public TopPanel(Consumer<Void> onLogout) {

        setLayout(new BorderLayout());

        // Create log out button
        JPanel top = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        top.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 250));
        JButton logout = new JButton("Log out");
        logout.setPreferredSize(new Dimension(130, 50));
        logout.setFont(new Font("Arial", Font.BOLD, 16));
        logout.addActionListener(e -> onLogout.accept(null));
        top.add(logout);

        // Create legend for different colors of the tables
        JPanel legend = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        legend.add(createLegendItem(Color.YELLOW, "Occupied"));
        legend.add(createLegendItem(Color.GREEN, "Available"));
        legend.add(createLegendItem(Color.RED, "Dirty"));
        legend.add(createLegendItem(Color.LIGHT_GRAY, "Unassigned"));
        legend.setBorder(BorderFactory.createEmptyBorder(40, 220, 20, 0));

        // Create screen title
        JLabel title = new JLabel("Seating Floor");
        title.setFont(new Font("Arial", Font.BOLD, 45));
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBorder(BorderFactory.createEmptyBorder(30, 100, 20, 0));
        titlePanel.add(title);

        // Add all elements to panel
        add(legend, BorderLayout.CENTER);
        add(top, BorderLayout.EAST);
        add(titlePanel, BorderLayout.WEST);
    }

    // Add new items and colors to the legend
    private JPanel createLegendItem(Color color, String label) {
        JPanel item = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel colorBox = new JLabel();
        colorBox.setOpaque(true);
        colorBox.setBackground(color);
        colorBox.setPreferredSize(new Dimension(15, 15));
        colorBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel text = new JLabel(label);
        text.setFont(new Font("Arial", Font.PLAIN, 12));

        item.add(colorBox);
        item.add(text);
        return item;
    }
}



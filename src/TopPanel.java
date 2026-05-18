import javax.swing.*;
import java.awt.*;

public class Legend extends JPanel {
    public Legend() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createTitledBorder("Legend"));
        setPreferredSize(new Dimension(150, 0));
        setBackground(Color.BLACK);

        add(createItem(Color.GREEN, "Available"));
        add(Box.createVerticalStrut(10));
        add(createItem(Color.YELLOW, "Occupied"));
        add(Box.createVerticalStrut(10));
        add(createItem(Color.RED, "Dirty"));
        add(Box.createVerticalStrut(10));
        add(createItem(Color.LIGHT_GRAY, "Unassigned Tables"));
    }

    private JPanel createItem(Color color, String label) {
        JPanel item = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel colorBox = new JLabel();
        colorBox.setOpaque(true);
        colorBox.setBackground(color);
        colorBox.setPreferredSize(new Dimension(20, 20));
        colorBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel text = new JLabel(" " + label);

        item.add(colorBox);
        item.add(text);
        return item;
    }
}



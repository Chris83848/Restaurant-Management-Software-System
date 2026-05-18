import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TableTab extends JPanel {

    private JTextArea order;
    private JLabel total;
    private double totalDue = 0.0;
    private java.util.List<String> items = new ArrayList<>();

    public TableTab() {
        setLayout(new BorderLayout());

        order = new JTextArea(10, 30);
        order.setEditable(false);
        JScrollPane scroll = new JScrollPane(order);

        total = new JLabel("Total: $0.00");

        JPanel bottom = new JPanel(new FlowLayout((FlowLayout.RIGHT)));
        bottom.add(total);

        add(scroll, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }

    public void addItem(String item, double price) {
        items.add(item + " - $" + String.format("%.2f", price));
        totalDue += price;
        updateDisplay();
    }

    public void clear() {
        items.clear();
        totalDue = 0.0;
        updateDisplay();
    }

    private void updateDisplay() {
        order.setText("");
        for (String item : items) {
            order.append(item + "\n");
        }
        total.setText(String.format("Total: $%.2f", totalDue));
    }
}

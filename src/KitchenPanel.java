import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class KitchenPanel extends JFrame {
    private JTabbedPane orderTabs = new JTabbedPane();;
    private JButton backButton = new JButton("Back");
    public KitchenPanel() {
        setTitle("Kitchen View");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(orderTabs);


        int orderNumber = 1;
        for (Orders order : OrdersQueue.getOrders()) {
            addOrderTab("Order " + orderNumber++, order.getItems());
        }

        add(backButton, BorderLayout.SOUTH);

        backButton.addActionListener(e -> dispose());
        setVisible(true);
    }

    private void addOrderTab(String title, List<String> items) {
        String[] columnNames = {"Order Items"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (String item : items) {
            model.addRow(new Object[]{item});
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        orderTabs.addTab(title, panel);
    }

    public static void main(String[] args) {
        new KitchenPanel();
    }
}

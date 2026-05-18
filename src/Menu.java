import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;

public class Menu extends JPanel {

    public Menu(TableTab tab) {
        setLayout(new GridLayout(5, 1));

        add(createCategory("Beverages", new String[][] {
                {"Coffee", "2.00"},
                {"Coke", "2.00"},
                {"Sprite", "2.00"},
                {"Lemonade", "2.00"}
        }, tab));

        add(createCategory("Sandwiches", new String[][] {
                {"Grilled Cheese", "5.50"},
                {"100% Beef Hot Dog", "5.50"},
                {"Chicken BLT&A", "10.00"},
                {"Cordon Bleu", "11.00"}
        }, tab));

        add(createCategory("Sides", new String[][] {
                {"Curly Fries", "2.50"},
                {"Mashed Potatoes", "2.50"},
                {"Mac & Cheese", "2.50"},
                {"Broccoli", "2.50"}
        }, tab));

        add(createCategory("Salads", new String[][] {
                {"House Salad", "7.50"},
                {"Wedge Salad", "7.50"},
                {"Caesar Salad", "7.50"},
                {"Sweet Potato Chicken Salad", "11.50"}
        }, tab));

        add(createCategory("Entrees", new String[][] {
                {"Shrimp & Grits", "13.50"},
                {"Sweet Tea Fried Chicken", "11.50"},
                {"Grilled Pork Chops", "11.00"},
                {"120z New York Strip Steak", "17.00"}
        }, tab));
    }

    private JPanel createCategory(String category, String[][] menuItems, TableTab tab) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(BorderFactory.createTitledBorder(category));

        for (String[] item : menuItems) {
            String name = item[0];
            double price = Double.parseDouble(item[1]);

            JButton button = new JButton(name + " ($" + price + ")");
            button.addActionListener((ActionEvent e) -> tab.addItem(name, price));
            panel.add(button);
        }

        return panel;
    }
}

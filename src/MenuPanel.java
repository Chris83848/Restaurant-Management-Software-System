import javax.swing.*;

public class MenuPanel extends JPanel {
    JButton goToAppetizers = new JButton("Appetizers");
    JButton goToEntrees = new JButton("Entrees");
    JButton goToWraps = new JButton("Wraps");
    JButton goToBurgers = new JButton("Burgers");
    JButton goToBeverages = new JButton("Beverages");
    JButton goToSides = new JButton("Sides");

    MenuPanel(){
        add(goToAppetizers);
        add(goToEntrees);
        add(goToWraps);
        add(goToBurgers);
        add(goToBeverages);
        add(goToSides);


    }
}

import javax.swing.*;

public class BurgersPanel extends JPanel {
    JButton carolinaBurgerButton = new JButton("Carolina Burger");
    JButton jSBurgerButton = new JButton("J's Burger");
    JButton mushroomSwissBurgerButton = new JButton("Mushroom Swiss Burger");
    JButton portobelloBurgerVButton = new JButton("Portobello Burger (V)");

    public BurgersPanel(){
        add(carolinaBurgerButton);
        add(jSBurgerButton);
        add(mushroomSwissBurgerButton);
        add(portobelloBurgerVButton);
    }
}

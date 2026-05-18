import javax.swing.*;

public class BeveragesPanel extends JPanel {
    JButton cokeButton = new JButton("Coke");
    JButton dietCokeButton = new JButton("Diet Coke");
    JButton lemonadeButton = new JButton("Lemonade");
    JButton sweetTeaButton = new JButton("Sweet Tea");
    JButton spriteButton = new JButton("Sprite");
    JButton mrPibbButton = new JButton("Mr.Pibb");

    BeveragesPanel(){
        add(cokeButton);
        add(dietCokeButton);
        add(lemonadeButton);
        add(sweetTeaButton);
        add(spriteButton);
        add(mrPibbButton);
    }
}

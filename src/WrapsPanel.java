import javax.swing.*;

public class WrapsPanel extends JPanel {
    JButton clubWrapButton = new JButton("Club Wrap");
    JButton chickenBLTAWrap = new JButton("Chicken Wrap");
    JButton veggieWrap = new JButton("Veggie Wrap");
    JButton chickenCaesarWrap = new JButton("Chicken Caesar Wrap");

    public WrapsPanel(){
        add(clubWrapButton);
        add(chickenBLTAWrap);
        add(veggieWrap);
        add(chickenCaesarWrap);
    }
}

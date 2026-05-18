import javax.swing.*;

public class EntreePanel extends JPanel{
    JButton shrimpAndGritsButton = new JButton("Shrimp and Grits");
    JButton caribbeanChickenButton = new JButton("Caribbean Chicken");
    JButton newYorkSteakButton = new JButton("120 oz New York Strip Steak");
    JButton searedTunaButton = new JButton("Seared Tuna");

    EntreePanel(){
        add(shrimpAndGritsButton);
        add(caribbeanChickenButton);
        add(newYorkSteakButton);
        add(searedTunaButton);
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppetizersPanel extends JPanel {
    JButton chipsAndDipButton = new JButton("Chips and Dip");
    JButton catfishBitesButton = new JButton("Catfish Bites");
    JButton chickenQuesadillasButton = new JButton("Chicken Quesadilla");
    JButton buffaloBlueChipsButton = new JButton("Buffalo Blue Chips");

    public AppetizersPanel() {
        add(chipsAndDipButton);
        add(catfishBitesButton);
        add(chickenQuesadillasButton);
        add(buffaloBlueChipsButton);


    }

}

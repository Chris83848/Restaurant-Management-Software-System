import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LoginSystem extends JFrame {
    // Maps username to password
    private final Map<String, String> loginInfo = new HashMap<>();

    // Maps username to waiter name
    private final Map<String, String> waiter = new HashMap<>();

    // Maps waiter to their assigned tables
    private final Map<String, List<String>> tableAssignments = new HashMap<>();

    public LoginSystem() {
        setTitle("Waiter Login Screen");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        JPanel button = new JPanel();

        // Different accounts set up
        loginInfo.put("SarahT99", "password1");
        loginInfo.put("nicholasRoberts87", "password2");
        loginInfo.put("emmaJ23!", "password3");

        waiter.put("SarahT99", "Sarah Thomas");
        waiter.put("nicholasRoberts87", "Nicholas Roberts");
        waiter.put("emmaJ23!", "Emma Johnson");

        tableAssignments.put("Sarah Thomas", Arrays.asList("T1", "T7", "T8", "T14", "T19"));
        tableAssignments.put("Nicholas Roberts", Arrays.asList("T3", "T9", "T11", "T15", "T22"));
        tableAssignments.put("Emma Johnson", Arrays.asList("T13", "T16", "T18", "T24", "T28"));

        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
        JButton loginButton = new JButton("Login");

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        panel.add(new JLabel("Username:"));
        panel.add(username);
        panel.add(new JLabel("Password:"));
        panel.add(password);

        button.add(loginButton);

        add(panel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        loginButton.addActionListener(e -> {
            String user = username.getText().trim();
            String pass = new String(password.getPassword()).trim();

            if (loginInfo.containsKey(user) && loginInfo.get(user).equals(pass)) {
                String waiterName = waiter.get(user);
                List<String> assignedTables = tableAssignments.get(waiterName);
                new SeatingArrangement(waiterName, assignedTables);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid login information", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}

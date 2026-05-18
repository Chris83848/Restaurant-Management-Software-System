import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginScreen {

    // Maps username to password
    private final Map<String, String> loginInfo = new HashMap<>();

    // Maps username to waiter name
    private final Map<String, String> waiter = new HashMap<>();

    // Maps waiter to their assigned tables
    private final Map<String, List<String>> tableAssignments = new HashMap<>();

    public LoginScreen() {

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

        JFrame frame = new JFrame("J's Restaurant Login");
        frame.setSize(300, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel titleLabel = new JLabel("Welcome To J's! Please Enter Login Info");
        titleLabel.setBounds(20, 0, 300, 25);
        frame.add(titleLabel);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 80, 25);
        frame.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(100, 20, 160, 25);
        frame.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 50, 80, 25);
        frame.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 160, 25);
        frame.add(passwordText);

        JButton loginButton = new JButton("Submit");
        loginButton.setBounds(100, 90, 80, 25);
        frame.add(loginButton);

        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(20, 120, 250, 25);
        frame.add(messageLabel);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText().trim();
                String password = new String(passwordText.getPassword());

                if (loginInfo.containsKey(username) && loginInfo.get(username).equals(password)) {
                    messageLabel.setText("Login successful!");
                    String waiterName = waiter.get(username);
                    List<String> assignedTables = tableAssignments.get(waiterName);
                    new SeatingArrangement(waiterName, assignedTables);
                } else {
                    messageLabel.setText("Invalid username or password.");
                }
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


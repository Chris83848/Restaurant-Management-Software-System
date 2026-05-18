import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class NewMenu extends JFrame {
    /*
     *This portion creates the main tabbed pane for the menu and all the tab panels for each category of the menu
     */
    private final JTabbedPane menuItems = new JTabbedPane();
    private final MenuPanel menuPanel = new MenuPanel();
    private final AppetizersPanel appetizerPanel = new AppetizersPanel();
    private final EntreePanel entreePanel = new EntreePanel();
    private final WrapsPanel wrapsPanel = new WrapsPanel();
    private final BurgersPanel burgersPanel = new BurgersPanel();
    private final BeveragesPanel beveragesPanel = new BeveragesPanel();
    private final SidesPanel sidesPanel = new SidesPanel();
    private final JButton backButton = new JButton("Back");
    private final JButton saveButton = new JButton("Save");
    private final JButton sendToKitchenButton = new JButton("Send To Kitchen");
    private final JButton viewKitchenOrdersButton = new JButton("View Kitchen Queue");
    private final JFrame frame = new JFrame();
    /*
     * This portion initializes items needed for the JTable that acts as a tab
     */
    private final DefaultTableModel tableModel = new DefaultTableModel(new String[] {"Item", "Price"}, 0);
    private final JTable tabTable = new JTable(tableModel);
    private final JLabel subtotalLabel = new JLabel("Subtotal: $0.00");
    private final JLabel taxLabel = new JLabel("Tax: $0.00");
    private final JLabel totalLabel = new JLabel("Total: $0.00");

    /*
     *This portion stores all our menu items and their prices into 2D arrays based on category
     */
    private final String[][] appetizerMenu = {
            {"Chips & Dip", "8.00"},
            {"Catfish Bites", "6.50"},
            {"Buffalo Blue Chips", "6.00"},
            {"Chicken Quesadillas", "7.50"}
    };

    private final String[][] entreeMenu = {
            {"Shrimp & Grits", "13.50"},
            {"Caribbean Chicken", "11.50"},
            {"120 oz New York Strip Steak", "17.00"},
            {"Seared Tuna", "15.00"}
    };

    private final String[][] burgersMenu = {
            {"Carolina Burger", "11.00"},
            {"J's Burger", "10.00"},
            {"Mushroom Swiss Burger", "11.00"},
            {"Portobello Burger", "8.50"}
    };

    private final String[][] wrapsMenu = {
            {"Club", "10.00"},
            {"Chicken BLT&A", "10.00"},
            {"Veggie", "10.00"},
            {"Chicken", "10.00"}
    };

    private final String[][] beveragesMenu = {
            {"Coke", "2.00"},
            {"Diet Coke", "2.00"},
            {"Lemonade", "2.00"},
            {"Sweet Tea", "2.00"},
            {"Sprite", "2.00"},
            {"Mr. Pibb", "2.00"}
    };

    private final String[][] sidesMenu = {
            {"Curly Fries", "2.50"},
            {"Wing Chips", "2.50"},
            {"Sweet Potato Fries", "4.00"},
            {"Creamy Cabbage Slaw", "2.50"},
            {"Adluh Cheese Grits", "2.50"},
            {"Mashed Potatoes", "2.50"},
            {"Mac & Cheese", "2.50"},
            {"Spicy Mac & Cheese", "2.50"},
            {"Bacon Mac & Cheese", "2.50"},
            {"Broccoli", "2.50"},
            {"Seasonal Vegetables", "2.50"},
            {"Baked Beans", "2.50"},
            {"Fried Okra", "4.00"},
            {"Soup", "5.00"},
            {"House Salad", "5.00"},
            {"Caesar Salad", "5.00"}
    };

    /*
     *
     */

    public NewMenu() {
        /*
         * Setting up the UI to have specific properties
         */
        setTitle("J's Restaurant");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 500);
        setLayout(null);
        getContentPane().setBackground(new Color(242, 251, 255));
        setLocationRelativeTo(null);

        /*
         * Making menu (JTabbed Panel) take up only half the screen and adding tabs for each
         * menu category
         */

        menuItems.setBounds(5, 5, 440, 450);
        menuItems.addTab("Menu", menuPanel);
        menuItems.addTab("Appetizers", appetizerPanel);
        menuItems.addTab("Entrees", entreePanel);
        menuItems.addTab("Wraps", wrapsPanel);
        menuItems.addTab("Burgers", burgersPanel);
        menuItems.addTab("Beverages", beveragesPanel);
        menuItems.addTab("Sides", sidesPanel);
        add(menuItems);

        /*
         *Creating space for tab, only takes up half of screen. Adding title for each table's tab
         *The table is set to be non-interactive and grid lines be removed
         * Including a scroll pane for when tab is long
         */


        JPanel tabPanel = new JPanel(new BorderLayout());
        tabPanel.setBounds(450, 5, 430, 450);
        tabPanel.setBorder(BorderFactory.createTitledBorder("Table " + " Tab"));
        tabTable.setEnabled(false);
        tabTable.setShowVerticalLines(false);
        tabTable.setShowGrid(false);
        JScrollPane tabScrollPane = new JScrollPane(tabTable);
        tabPanel.add(tabScrollPane, BorderLayout.CENTER);


        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(backButton);
        buttonsPanel.add(sendToKitchenButton);
        buttonsPanel.add(viewKitchenOrdersButton);


        /*
         * Focusing on the subtotal, tax, and total labels for the tab
         */
        JPanel totalPanel = new JPanel();
        subtotalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        taxLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalPanel.add(subtotalLabel);
        totalPanel.add(taxLabel);
        totalPanel.add(totalLabel);


        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setBounds(450,5,430,100);
        southPanel.add(buttonsPanel, BorderLayout.SOUTH);
        southPanel.add(totalPanel, BorderLayout.NORTH);

        tabPanel.add(southPanel, BorderLayout.SOUTH);

        add(tabPanel);

        /*
         *Customizing the first tab containing all categories of the menu
         * Each menu category shows as a button and when clicked, each button should
         * take user to that category's tab in the JTabbed Pane
         */
        menuPanel.setLayout(new GridLayout(0,1,10,10));
        menuPanel.setPreferredSize(new Dimension(400, 0));
        menuPanel.goToAppetizers.addActionListener(e -> menuItems.setSelectedComponent(appetizerPanel));
        menuPanel.goToEntrees.addActionListener(e -> menuItems.setSelectedComponent(entreePanel));
        menuPanel.goToWraps.addActionListener(e -> menuItems.setSelectedComponent(wrapsPanel));
        menuPanel.goToBurgers.addActionListener(e -> menuItems.setSelectedComponent(burgersPanel));
        menuPanel.goToBeverages.addActionListener(e -> menuItems.setSelectedComponent(beveragesPanel));
        menuPanel.goToSides.addActionListener(e -> menuItems.setSelectedComponent(sidesPanel));

        /*
         *Making all contents in the "Price" column right justified and the "Items" header
         * left justified
         */
        DefaultTableCellRenderer leftJustified = new DefaultTableCellRenderer();
        DefaultTableCellRenderer rightJustified = new DefaultTableCellRenderer();
        leftJustified.setHorizontalAlignment(SwingConstants.LEFT);
        rightJustified.setHorizontalAlignment(SwingConstants.RIGHT);

        tabTable.getColumnModel().getColumn(1).setCellRenderer(rightJustified);
        tabTable.getColumnModel().getColumn(1).setHeaderRenderer(rightJustified);
        tabTable.getColumnModel().getColumn(0).setHeaderRenderer(leftJustified);
        setVisible(true);


        appetizerPanel.chipsAndDipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(appetizerMenu[0][0], Double.parseDouble(appetizerMenu[0][1]));
            }
        });
        appetizerPanel.catfishBitesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(appetizerMenu[1][0], Double.parseDouble(appetizerMenu[1][1]));
            }
        });
        appetizerPanel.buffaloBlueChipsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(appetizerMenu[2][0], Double.parseDouble(appetizerMenu[2][1]));
            }
        });
        appetizerPanel.chickenQuesadillasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(appetizerMenu[3][0], Double.parseDouble(appetizerMenu[3][1]));
            }
        });

        //entree Buttons
        entreePanel.shrimpAndGritsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(entreeMenu[0][0], Double.parseDouble(entreeMenu[0][1]));
            }
        });
        entreePanel.caribbeanChickenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(entreeMenu[1][0], Double.parseDouble(entreeMenu[1][1]));
            }
        });
        entreePanel.newYorkSteakButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(entreeMenu[2][0], Double.parseDouble(entreeMenu[2][1]));
            }
        });
        entreePanel.searedTunaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(entreeMenu[3][0], Double.parseDouble(entreeMenu[3][1]));
            }
        });

        //burgers buttons
        burgersPanel.carolinaBurgerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(burgersMenu[0][0], Double.parseDouble(burgersMenu[0][1]));
            }
        });
        burgersPanel.jSBurgerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(burgersMenu[1][0], Double.parseDouble(burgersMenu[1][1]));
            }
        });
        burgersPanel.mushroomSwissBurgerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(burgersMenu[2][0], Double.parseDouble(burgersMenu[2][1]));
            }
        });
        burgersPanel.portobelloBurgerVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(burgersMenu[3][0],Double.parseDouble(burgersMenu[3][1]));
            }
        });

        //wraps buttons
        wrapsPanel.clubWrapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(wrapsMenu[0][0], Double.parseDouble(wrapsMenu[0][1]));
            }
        });
        wrapsPanel.chickenBLTAWrap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(wrapsMenu[1][0], Double.parseDouble(wrapsMenu[1][1]));
            }
        });
        wrapsPanel.veggieWrap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(wrapsMenu[2][0], Double.parseDouble(wrapsMenu[2][1]));
            }
        });
        wrapsPanel.chickenCaesarWrap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(wrapsMenu[3][0], Double.parseDouble(wrapsMenu[3][1]));
            }
        });
        //beverage buttons
        beveragesPanel.cokeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(beveragesMenu[0][0], Double.parseDouble(beveragesMenu[0][1]));
            }
        });
        beveragesPanel.dietCokeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(beveragesMenu[1][0], Double.parseDouble(beveragesMenu[1][1]));
            }
        });
        beveragesPanel.lemonadeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(beveragesMenu[2][0], Double.parseDouble(beveragesMenu[2][1]));
            }
        });
        beveragesPanel.sweetTeaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(beveragesMenu[3][0], Double.parseDouble(beveragesMenu[3][1]));
            }
        });
        beveragesPanel.spriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(beveragesMenu[4][0], Double.parseDouble(beveragesMenu[4][1]));
            }
        });
        beveragesPanel.mrPibbButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(beveragesMenu[5][0], Double.parseDouble(beveragesMenu[5][1]));
            }
        });
        //sides buttons
        sidesPanel.curlyFriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(sidesMenu[0][0], Double.parseDouble(sidesMenu[0][1]), true);
            }
        });
        sidesPanel.wingChipsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(sidesMenu[1][0], Double.parseDouble(sidesMenu[1][1]), true);
            }
        });
        sidesPanel.sweetPotatoFriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(sidesMenu[2][0], Double.parseDouble(sidesMenu[2][1]), true);
            }
        });
        sidesPanel.slawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(sidesMenu[3][0], Double.parseDouble(sidesMenu[3][1]), true);
            }
        });
        sidesPanel.cheeseGritsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(sidesMenu[4][0], Double.parseDouble(sidesMenu[4][1]), true);
            }
        });
        sidesPanel.mashedPotatoesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(sidesMenu[5][0], Double.parseDouble(sidesMenu[5][1]), true);
            }
        });
        sidesPanel.macAndCheeseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(sidesMenu[6][0], Double.parseDouble(sidesMenu[6][1]), true);
            }
        });
        sidesPanel.spicyMacButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(sidesMenu[7][0], Double.parseDouble(sidesMenu[7][1]), true);
            }
        });
        sidesPanel.baconMacButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(sidesMenu[8][0], Double.parseDouble(sidesMenu[8][1]), true);
            }
        });
        sidesPanel.broccoliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(sidesMenu[9][0], Double.parseDouble(sidesMenu[9][1]), true);
            }
        });
        sidesPanel.seasonalVegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(sidesMenu[10][0], Double.parseDouble(sidesMenu[10][1]), true);
            }
        });
        sidesPanel.bakedBeansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(sidesMenu[11][0], Double.parseDouble(sidesMenu[11][1]), true);
            }
        });
        sidesPanel.friedOkraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(sidesMenu[12][0], Double.parseDouble(sidesMenu[12][1]), true);
            }
        });
        sidesPanel.soupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(sidesMenu[13][0], Double.parseDouble(sidesMenu[13][1]), true);
            }
        });
        sidesPanel.houseSaladButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(sidesMenu[14][0], Double.parseDouble(sidesMenu[14][1]), true);
            }
        });
        sidesPanel.caesarSaladButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToOrder(sidesMenu[15][0], Double.parseDouble(sidesMenu[15][1]), true);
            }
        });

        sendToKitchenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableModel.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(frame, "Add items to tab first.");

                } else {
                    List<String> itemsInOrder = getOrderFromTable(tabTable);
                    Orders order = new Orders("Order" + "", itemsInOrder);
                    OrdersQueue.addOrder(order);
                    JOptionPane.showMessageDialog(frame, "Order sent to kitchen!");

                    int rows = tableModel.getRowCount();
                    int i = 0;
                    while (rows > 0) {
                        tableModel.removeRow(i);
                        rows--;
                    }
                    updateSubtotal();
                }
            }
        });

        viewKitchenOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KitchenPanel();
            }
        });

        backButton.addActionListener(e -> dispose());


        /*
         * Allowing user to delete item from tab by clicking on item
         */
        tabTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowClicked = tabTable.rowAtPoint(e.getPoint());

                if(rowClicked >= 0){
                    tableModel.removeRow(rowClicked);
                    updateSubtotal();
                }
            }
        });
    }
    public List getOrderFromTable(JTable table){
        List<String> items = new ArrayList<String>();
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        int rows = defaultTableModel.getRowCount();

        for(int i = 0; i < rows; i++){
            Object rowItem = defaultTableModel.getValueAt(i,0);
            if(rowItem != null){
                items.add(rowItem.toString());
            }
        }

        return items;
    }
    /*
     * Function to add an item to the tab. Passing the item name and price from its corresponding array,
     * the function will add information to a row in the table
     */
    public void addItemToOrder(String item, double price){
        tableModel.addRow(new Object[]{item, String.format("$%.2f", price)});
        updateSubtotal();
    }

    /*
     *Overloaded function for sides. Allows sides to be indented in tab
     */
    public void addItemToOrder(String item, double price, boolean isSide){
        String itemName = "";
        if(isSide){
            itemName = "      " + item;
        }
        tableModel.addRow(new Object[] {itemName, String.format("$%.2f", price)});
        updateSubtotal();
    }

    /*
     * Function updates subtotal, tax, and total labels based on current contents of tab
     */
    public void updateSubtotal(){
        double subtotal = 0.0;
        for(int i = 0; i < tableModel.getRowCount(); i++){
            String stringPrice = (String) tableModel.getValueAt(i, 1);
            stringPrice = stringPrice.replace("$", "");
            subtotal += Double.parseDouble(stringPrice);
        }

        double tax = subtotal * 0.04;
        double total = subtotal + tax;
        subtotalLabel.setText(String.format("Subtotal: $%.2f", subtotal));
        taxLabel.setText(String.format("Tax: $%.2f", tax));
        totalLabel.setText(String.format("Total: $%.2f", total));

    }

    public JTabbedPane getMenuItems(){
        return menuItems;
    }
    public static void main(String[] args) {
        new NewMenu();
    }
}

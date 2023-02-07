package org.sherwoodhs.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class InventoryPanel extends JPanel {
    public static final InventoryPanel inventoryPanel = new InventoryPanel();
    private DefaultListModel<String> inventoryListModel = new DefaultListModel<>();
    private JList<String> inventoryList;
    private InventoryPanel() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(250, 470));
        setBorder(new TitledBorder("Inventory"));

        inventoryList = new JList<>(inventoryListModel);
        add(inventoryList);

        initInventory(new String[]{"Item One", "Item Deux", "Item Three", "Item 4"});
    }
    /**
     * Clears all contents inside inventoryList, then adds every element in String[] inventory
     * @param inventory all contents inside the player's inventory as a {@link String} array
     */
    public void initInventory(String[] inventory) {
        clearInventory();
        for (String element : inventory) {
            inventoryListModel.addElement(element);
        }
    }
    /**
     * Adds one element to inventoryList without clearing its contents
     * @param s one element to be added to inventoryList
     */
    public void addToInventory(String s) {
        inventoryListModel.addElement(s);
    }
    /**
     * Removes one element to inventoryList without clearing its contents
     * @param s one element to be removed from inventoryList; method will not work if the element cannot be found
     */
    public void removeFromInventory(String s) {
        inventoryListModel.removeElement(s);
    }
    /**
     * Clears all content inside inventoryList
     */
    public void clearInventory() {
        inventoryListModel.clear();
    }
}
package org.sherwoodhs.ui;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.ui.util.DisabledItemSelectionModel;
import org.sherwoodhs.ui.util.InvPanelCellRenderer;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;

public class InventoryPanel extends JPanel {
    public static final InventoryPanel inventoryPanel = new InventoryPanel();
    private DefaultListModel<String> inventoryListModel = new DefaultListModel<>();
    private JList<String> inventoryList;
    private Timer timer = new Timer(); // see TextPanel for explanation
    private static int index = 0;
    private static int i = 0;
    private static String itemName;

    private InventoryPanel() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(250, 295));
        setBorder(new TitledBorder("Inventory"));

        inventoryList = new JList<>(inventoryListModel);
        inventoryList.setSelectionModel(new DisabledItemSelectionModel());
        inventoryList.setCellRenderer(new InvPanelCellRenderer());
        add(inventoryList);

        initInventory(new String[]{});
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
     * @param item one element to be added to inventoryList
     */
    public void addToInventory(String item) { // identical method to TextPanel's "addText", but runs in its own thread

        i = 0;

        itemName = item;

        inventoryListModel.add(index, "");

        AdvGame.isTyping = true;

        timer.schedule(new TimerTask() { // maybe make this one typingTask in the class attributes? find way to repeatedly schedule.
            @Override
            public void run() {

                while(AdvGame.isTyping) {
                    Thread.yield();
                }

                if (i < itemName.length()) {
                    i++;
                    inventoryListModel.set(index, (itemName.substring(0,i)+"|") );
                } else {
                    inventoryListModel.set(index, itemName);
                    AdvGame.isTyping = false;
                    System.out.println("InventoryPanel : addToInventory() : timer : " + AdvGame.isTyping);
                    index++;
                    cancel();
                }
            }
        }, 200, 30);
    }
    /**
     * Removes one element from inventoryList without clearing its contents
     * @param item one element to be removed from inventoryList; method will not work if the element cannot be found
     */
    public void removeFromInventory(String item) {
        inventoryListModel.removeElement(item);
    }
    /**
     * Clears all content inside inventoryList
     */
    public void clearInventory() {
        inventoryListModel.clear();
    }
    /**
     * Returns a boolean that determines whether an item is contained in the inventory
     * @param item represents the item to be searched for in inventoryList
     */
    public boolean containsItem (String item){
        if (inventoryListModel.contains(item)) {
            return true;
        } else {
            return false;
        }
    }
}

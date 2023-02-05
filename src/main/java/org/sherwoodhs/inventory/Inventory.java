package org.sherwoodhs.inventory;

import java.util.Collection;
import java.util.HashMap;

public class Inventory {
    private static Inventory inventory = new Inventory();

    private Inventory(){

    }
    private HashMap<String, Item> inv = new HashMap<String, Item>();

    public int size() {
        return inv.size();
    }

    public Collection<Item> getInventory () {
        return inv.values();
    }
    public void addItem(Item item) {
        inv.put(item.getName().toLowerCase(), item);
    }
    public Item getItem(String itemName) {
        return inv.get(itemName);
    }
    public Item removeItem(String itemName){
        return inv.remove(itemName);
    }

    public void clearInventory() {
        inv.clear();
    }

    public boolean checkInventory(String item) {
        return inv.containsKey(item);
    }

    public static Inventory getInstance(){
        return inventory;
    }

}


package org.sherwoodhs.situation.Separatist.Kitchen;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.quest.Separatist.FoodMakingQuest;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import static org.sherwoodhs.situation.Separatist.Kitchen.CashRegister.playerOrder;
import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;

public class SodaMachine implements Situation {

    // REVERT EVERYTHING TO EXPLORATION TYPE, MAKE INDIVIDUAL CLASSES FOR EVERY OPTION (maybe with adding previous text in backwards).
    private static Situation situation = new SodaMachine();
    @Override
    public String getTitle() {
        return "Burger Station";
    }

    public static String drink = "";

    @Override
    public String getDescription() {
        return "You are standing in front of the soda machine. Fill up cups with soda.\n" +
                "_______________\n" +
                "|S||C||W||F||M|\n" +
                "|V  V  V  V  V|\n" +
                "|_____________|";
    }

    @Override
    public SitType getSitType() {return SitType.Interaction;}

    @Override
    public String[] getOptions() {
        String[] options = {"Sprite", "Coke", "Water", "Fanta", "Mountain Dew", "Back to Kitchen"}; // limit 6
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){

            // MAIN BRANCH
            case "Sprite":
                if (FoodMakingQuest.inProgress()) {
                    addItem("Sprite");
                } else {
                    AdvGame.updateFrame("You have not taken an order yet. Please take an order first " +
                            "at the cash register.");
                }
                break;

            case "Coke":
                if (FoodMakingQuest.inProgress()) {
                    addItem("Coke");
                } else {
                    AdvGame.updateFrame("You have not taken an order yet. Please take an order first " +
                            "at the cash register.");
                }
                break;

            case "Water":
                if (FoodMakingQuest.inProgress()) {
                    addItem("Water");
                } else {
                    AdvGame.updateFrame("You have not taken an order yet. Please take an order first " +
                            "at the cash register.");
                }
                break;

            case "Fanta":
                if (FoodMakingQuest.inProgress()) {
                    addItem("Fanta");
                } else {
                    AdvGame.updateFrame("You have not taken an order yet. Please take an order first " +
                            "at the cash register.");
                }
                break;

            case "Mountain Dew":
                if (FoodMakingQuest.inProgress()) {
                    addItem("Mountain Dew");
                } else {
                    AdvGame.updateFrame("You have not taken an order yet. Please take an order first " +
                            "at the cash register.");
                }
                break;

            // EXIT POINT
            case "Back to Kitchen":
                AdvGame.setSituation(Kitchen.getInstance());
                break;
        }
    }

    public static void addItem(String d) {
        if (playerOrder[1][0].equals("")) {
            inventoryPanel.addToInventory(d);
        }
        playerOrder[1][0] = d;
        drink = d;
    }

    public static String getDrink() {
        return drink;
    }

    public static Situation getInstance(){
        return situation;
    }

}

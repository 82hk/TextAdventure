package org.sherwoodhs.situation.Separatist.Kitchen;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.quest.Separatist.FoodMakingQuest;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;

import static org.sherwoodhs.situation.Separatist.Kitchen.CashRegister.playerOrder;
import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;

public class Fryer implements Situation {

    // REVERT EVERYTHING TO EXPLORATION TYPE, MAKE INDIVIDUAL CLASSES FOR EVERY OPTION (maybe with adding previous text in backwards).
    private static Situation situation = new Fryer();

    @Override
    public String getTitle() {
        return "Potato Fryer";
    }

    @Override
    public String getDescription() {
        return "You are standing by the fries fryer. Fry some fries.";
    }

    @Override
    public SitType getSitType() {return SitType.Interaction;}

    @Override
    public String[] getOptions() {
        String[] options = {"Get Fries", "Back to Kitchen"}; // limit 6
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){

            // MAIN BRANCH
            case "Get Fries":
                if (FoodMakingQuest.inProgress()) {
                    if (!playerOrder[2][0].equals("Fries")) {
                        inventoryPanel.addToInventory("Fries");
                    }
                    playerOrder[2][0] = "Fries";
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

    @Override
    public ImageIcon getImg() {
        return null;
    }

    public static Situation getInstance(){
        return situation;
    }

}

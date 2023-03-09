package org.sherwoodhs.situation.Separatist.Kitchen;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Separatist.WorkPlace;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;
import static org.sherwoodhs.situation.Separatist.Kitchen.CashRegister.playerOrder;

public class Kitchen implements Situation {
    
    // REVERT EVERYTHING TO EXPLORATION TYPE, MAKE INDIVIDUAL CLASSES FOR EVERY OPTION (maybe with adding previous text in backwards).
    private static boolean firstTime = true;
    private static Situation situation = new Kitchen();

    public static String burger = "Burger with: ";

    @Override
    public String getTitle() {
        return "You are in the Food Court Kitchen";
    }

    @Override
    public String getDescription() {
        if (firstTime) {
            return "You walk into the kitchen and you see a lady.";
        } else {
            return "Go take orders/make food.";
        }
    }

    @Override
    public SitType getSitType() {return SitType.Interaction;}

    @Override
    public String[] getOptions() {
        String[] options = new String[]{"Talk to lady", "Leave"}; // limit 6;
        if (!firstTime) {
            options = new String[]{"Go to cash register", "Go to fryer", "Go to soda machine","Go to burger station","Back to Food Court"};
        }
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){

            // MAIN BRANCH

            case "Talk to lady":
                if (firstTime) {
                    AdvGame.updateFrame("The person introduces herself as the Kitchen Lady. She tells you that they are in rush" +
                            "hour. She says \" we need someone to work part time and get payed 2 money per order.\"",
                            new String[]{"Go to Kitchen", "Leave"});
                }
                break;

            case "Go to Kitchen":
                    AdvGame.updateFrame("You are in the kitchen as customers begin rolling into the food court. You hurriedly " +
                                    "put on your apron and get to work.",
                            new String[]{"Go to cash register", "Go to fryer", "Go to soda machine","Go to burger station","Back to Food Court"});
                break;

            case "Go to cash register":
                firstTime = false;
                AdvGame.setSituation(CashRegister.getInstance());
                break;

            case "Go to fryer":
                firstTime = false;
                AdvGame.setSituation(Fryer.getInstance());
                break;

            case "Go to soda machine":
                firstTime = false;
                AdvGame.setSituation(SodaMachine.getInstance());
                break;

            case "Go to burger station":
                firstTime = false;
                AdvGame.setSituation(BurgerStation.getInstance());
                break;


            // EXIT POINT
            case "Back to Food Court":
                AdvGame.setSituation(WorkPlace.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

    public static void addItem(String b) {
        if (playerOrder[0][2].equals("")) {
            inventoryPanel.addToInventory(b);
            dealWithOrder(b);
        }
    }

    public static void dealWithOrder(String b) {
        inventoryPanel.removeFromInventory(burger);
        burger = b;
    }
}

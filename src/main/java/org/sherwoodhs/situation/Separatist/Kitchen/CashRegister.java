package org.sherwoodhs.situation.Separatist.Kitchen;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.quest.Separatist.FoodMakingQuest;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import static org.sherwoodhs.situation.Separatist.Kitchen.Kitchen.burger;
import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;

import java.util.Random;

public class CashRegister implements Situation {

    // REVERT EVERYTHING TO EXPLORATION TYPE, MAKE INDIVIDUAL CLASSES FOR EVERY OPTION (maybe with adding previous text in backwards).
    private static boolean firstTime = true;
    private static Situation situation = new CashRegister();

    private static final String[][] options = {
            {"cheese", "lettuce", "tomatoes", "mayo", "ketchup"},
            {"sprite", "coke", "water", "fanta", "mountain dew"},
            {"fries", "no fries"},
    };

    private static final String[][] custOrder = {
            {"", "", ""},
            {""},
            {""},
    };

    static final String[][] playerOrder = {
            {"", "", ""},
            {""},
            {"no fries"},
    };

    @Override
    public String getTitle() {
        return "Cash Register";
    }

    @Override
    public String getDescription() {
        if (firstTime == true) {
            return "You are at the cash register. You will take customer orders here.";
        } else {
            return "You are at the cash register. Customers are waiting.";
        }
    }

    @Override
    public SitType getSitType() {return SitType.Interaction;}

    @Override
    public String[] getOptions() {
        String[] options = {"Get Customer Order", "Back to Kitchen"}; // limit 6
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){

            // MAIN BRANCH

            case "Get Customer Order":
                if (firstTime) {
                    randomizeOrder();
                    AdvGame.updateFrame(getOrder(), new String[]{"Back to Kitchen"});
                    AdvGame.addQuest(FoodMakingQuest.getInstance());
                } else {
                    if (FoodMakingQuest.getInstance().isCompleted()) {
                        randomizeOrder();
                        AdvGame.updateFrame(getOrder(), new String[]{"Back to Kitchen"});
                        AdvGame.addQuest(FoodMakingQuest.getInstance());
                    } else {
                        AdvGame.updateFrame("You may only take one order at a time. " +
                                "Please complete the current order.", new String[]{"Check Order", "Trash Can (Restart Order)", "Back to Kitchen"});
                    }
                }
                break;

            case "Check Order":
                AdvGame.clearFrame(getOrder());
                break;

            case "Trash Can (Restart Order)":
                inventoryPanel.removeFromInventory(burger);
                inventoryPanel.removeFromInventory("fries");
                break;

            // EXIT POINT
            case "Back to Kitchen":
                firstTime = false;
                AdvGame.setSituation(Kitchen.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

    public static void randomizeOrder() {
        Random r = new Random();
        for (int j = 0; j < options.length; j++) {
            for (int i = 0; i < options[j].length; i++) {
                int randomIndexToSwap = r.nextInt(options[j].length);
                String temp = options[j][randomIndexToSwap];
                options[j][randomIndexToSwap] = options[j][i];
                options[j][i] = temp;
            }
        }

        for(int i = 0; i < 3; i++) {
            custOrder[0][i] = options[0][i];
        }
        custOrder[1][0] = options[1][1];
        custOrder[2][0] = options[2][1];
    }

    public static String getOrder() {
            return "I would like a burger with: \n" +
                    custOrder[0][0] + "\n" +
                    custOrder[0][1] + "\n" +
                    custOrder[0][2] + "\n" +
                    "With a " + custOrder[1][0] + " and " +
                    custOrder[2][0];
    }
}
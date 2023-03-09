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
            {"Sprite", "Coke", "Water", "Fanta", "Mountain Dew"},
            {"Fries", "no fries"},
    };

    public static final String[][] resetOrder = {
            {"", "", ""},
            {""},
            {"no fries"},
    };

    private static final String[][] custOrder = {
            {"", "", ""},
            {""},
            {""},
    };

    public static int money = 0;

    public static String[][] playerOrder = {
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
        String[] options = new String[0];
        if (!FoodMakingQuest.inProgress()) {
            options = new String[]{"Get Customer Order", "Back to Kitchen"}; // limit 6
        } else {
            options = new String[]{"Check Current Order", "Trash Can (Restart Order)",
                    "Back to Kitchen", "Give Order to Customer"};
        }
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){

            // MAIN BRANCH

            case "Get Customer Order":
                if (!FoodMakingQuest.inProgress()) {
                    randomizeOrder();
                    AdvGame.updateFrame(getOrder(), new String[]{"Back to Kitchen"});
                    AdvGame.addQuest(FoodMakingQuest.getInstance());
                    FoodMakingQuest.setProgress(true);
                    FoodMakingQuest.getInstance().reset();
                }
                break;

            case "Check Current Order":
                AdvGame.clearFrameWithoutSpacing(getOrder());
                break;

            case "Trash Can (Restart Order)":
                restartOrder();
                break;

            case "Give Order to Customer":
                if (checkOrder()) {
                    restartOrder();
                    FoodMakingQuest.setProgress(false);
                    FoodMakingQuest.getInstance().complete();
                    AdvGame.removeQuest(FoodMakingQuest.getInstance());
                    AdvGame.clearFrameWithoutSpacing("You have successfully completed this order! As a result, " +
                            "you have been awarded 2 money. You can take as many orders as you wish.",
                            new String[]{"Get Customer Order", "Back to Kitchen"});
                    addMoney(money+=2);
                } else {
                    AdvGame.clearFrameWithoutSpacing("Sorry, this is not what the customer wanted. Please try again.",
                            new String[]{"Check Current Order", "Trash Can (Restart Order)", "Back to Kitchen"});
                }
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
                    "With a " + custOrder[1][0].toLowerCase() + " and " +
                    custOrder[2][0].toLowerCase();
    }

    public static boolean checkOrder() {
        int match = 0;
        for (int i = 0; i < playerOrder.length; i++) {
            for (int j = 0; j < playerOrder[i].length; j++) {
                for (int g = 0; g < playerOrder[i].length; g++) {
                    if (custOrder[i][g].equals(playerOrder[i][j])) {
                        match++;
                    }
                }
            }
        }
        if (match == 5) {
            return true;
        }
        return false;
    }

    public static void restartOrder() {
        inventoryPanel.removeFromInventory(burger);
        inventoryPanel.removeFromInventory("Fries");
        inventoryPanel.removeFromInventory(SodaMachine.getDrink());
        playerOrder = resetOrder;
        burger = "Burger with: ";
    }

    public static void addMoney(int b) {
            inventoryPanel.addToInventory("Money: " + b);
            int a = b-2;
            inventoryPanel.removeFromInventory("Money: " + a);
    }

}
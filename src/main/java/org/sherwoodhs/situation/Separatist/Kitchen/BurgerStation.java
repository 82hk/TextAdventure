package org.sherwoodhs.situation.Separatist.Kitchen;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.quest.Separatist.FoodMakingQuest;
import org.sherwoodhs.situation.Separatist.WorkPlace;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import static org.sherwoodhs.situation.Separatist.Kitchen.Kitchen.burger;
import static org.sherwoodhs.situation.Separatist.Kitchen.CashRegister.playerOrder;
import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;

public class BurgerStation implements Situation {
    
    // REVERT EVERYTHING TO EXPLORATION TYPE, MAKE INDIVIDUAL CLASSES FOR EVERY OPTION (maybe with adding previous text in backwards).
    private static boolean firstTime = true;
    private static Situation situation = new BurgerStation();

    @Override
    public String getTitle() {
        return "Burger Station";
    }

    @Override
    public String getDescription() {
        return "You walk into the burger station. You will make burgers here.";
    }

    @Override
    public SitType getSitType() {return SitType.Interaction;}

    @Override
    public String[] getOptions() {
        String[] options = {"Add lettuce", "Add tomatoes", "Add cheese", "Add ketchup",
                "Add mayo", "Back to Kitchen"}; // limit 6
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){

            // MAIN BRANCH

            case "Add lettuce":
                Kitchen.addItem(burger + "L ");
                addToOrder("lettuce");
                break;
            case "Add tomatoes":
                Kitchen.addItem(burger + "T ");
                addToOrder("tomatoes");
                break;
            case "Add cheese":
                Kitchen.addItem(burger + "C ");
                addToOrder("cheese");
                break;
            case "Add ketchup":
                Kitchen.addItem(burger + "K ");
                addToOrder("ketchup");
                break;
            case "Add mayo":
                Kitchen.addItem(burger + "M ");
                addToOrder("mayo");
                break;

            // EXIT POINT
            case "Back to Kitchen":
                firstTime = false;
                AdvGame.setSituation(Kitchen.getInstance());
                break;
        }
    }

    public static void addToOrder(String food) {
        for (int i = 0; i < playerOrder[0].length; i++) {
            if(playerOrder[0][i].equals("")) {
                playerOrder[0][i] = food;
                return;
            }
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

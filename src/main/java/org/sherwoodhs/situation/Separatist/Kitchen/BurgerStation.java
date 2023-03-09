package org.sherwoodhs.situation.Separatist.Kitchen;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.quest.Separatist.FoodMakingQuest;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import static org.sherwoodhs.situation.Separatist.Kitchen.Kitchen.burger;
import static org.sherwoodhs.situation.Separatist.Kitchen.CashRegister.playerOrder;

public class BurgerStation implements Situation {

    private static Situation situation = new BurgerStation();

    @Override
    public String getTitle() {
        return "Burger Station";
    }

    @Override
    public String getDescription() {
        return "You walk into the burger station. You will make burgers here. " +
                "Empty buns sit patiently on the table.";
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
                checkQuest("L ", "lettuce");
                break;
            case "Add tomatoes":
                checkQuest("T ", "tomatoes");
                break;
            case "Add cheese":
                checkQuest("C ", "cheese");
                break;
            case "Add ketchup":
                checkQuest("K ", "ketchup");
                break;
            case "Add mayo":
                checkQuest("M ", "mayo");
                break;

            // EXIT POINT
            case "Back to Kitchen":
                // REVERT EVERYTHING TO EXPLORATION TYPE, MAKE INDIVIDUAL CLASSES FOR EVERY OPTION (maybe with adding previous text in backwards).
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

    public void checkQuest(String s, String g) {
        if (FoodMakingQuest.inProgress()) {
            Kitchen.addItem(burger + s);
            addToOrder(g);
        } else {
            AdvGame.updateFrame("You have not taken an order yet. Please take an order first " +
                    "at the cash register.");
        }
    }

}

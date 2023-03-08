package org.sherwoodhs.situation.Separatist.Kitchen;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import java.util.Random;

public class CashRegister implements Situation {

    // REVERT EVERYTHING TO EXPLORATION TYPE, MAKE INDIVIDUAL CLASSES FOR EVERY OPTION (maybe with adding previous text in backwards).
    private static boolean firstTime = true;
    private static Situation situation = new CashRegister();

    private static final String[][] options = {
            {"cheese", "lettuce", "tomatoes", "mayo", "ketchup"},
            {"sprite", "coke", "water", "fanta", "mountain Dew"},
            {"fries", "no fries"},
    };

    private static final String[] order = new String[5];

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
                getOrder();
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

        for (int i = 0; i < 3; i++) {
            order[i] = options[i][i];
        }
        order[3] = options[1][0];
        order[4] = options[2][1];
    }

    public static String getOrder() {
        randomizeOrder();
            String temp = "I would like a burger with: ";
            return "";
    }
}
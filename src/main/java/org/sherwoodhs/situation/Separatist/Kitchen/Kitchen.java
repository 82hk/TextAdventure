package org.sherwoodhs.situation.Separatist.Kitchen;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Separatist.WorkPlace;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class Kitchen implements Situation {
    
    // REVERT EVERYTHING TO EXPLORATION TYPE, MAKE INDIVIDUAL CLASSES FOR EVERY OPTION (maybe with adding previous text in backwards).
    private static boolean firstTime = true;
    private static Situation situation = new Kitchen();

    @Override
    public String getTitle() {
        return "You are in the Food Court Kitchen";
    }

    @Override
    public String getDescription() {
        if (firstTime == true) {
            return "You walk into the kitchen and you see a lady.";
        } else {
            return "You should probably work part time for some money.";
        }
    }

    @Override
    public SitType getSitType() {return SitType.Interaction;}

    @Override
    public String[] getOptions() {
        String[] options = {"Talk to lady","Leave"}; // limit 6
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
                if (firstTime) {
                    AdvGame.updateFrame("You are in the kitchen as customers begin rolling into the food court. You hurriedly " +
                                    "put on your apron and get to work.",
                            new String[]{"Go to fryer", "Go to soda machine","Go to burger station","Back to Food Court"});
                } break;

            case "Go to fryer":
                AdvGame.setSituation(Fryer.getInstance());
                break;

            case "Go to soda machine":
                AdvGame.setSituation(SodaMachine.getInstance());
                break;

            case "Go to burger station":
                AdvGame.setSituation(BurgerStation.getInstance());
                break;


            // EXIT POINT
            case "Leave":
                firstTime = false;
                AdvGame.setSituation(WorkPlace.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

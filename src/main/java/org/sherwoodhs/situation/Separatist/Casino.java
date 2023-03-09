package org.sherwoodhs.situation.Separatist;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class Casino implements Situation {
    
    // REVERT EVERYTHING TO EXPLORATION TYPE, MAKE INDIVIDUAL CLASSES FOR EVERY OPTION (maybe with adding previous text in backwards).
    private static boolean firstTime = true;
    private static Situation situation = new Casino();

    @Override
    public String getTitle() {
        return "Separatist Casino";
    }

    @Override
    public String getDescription() {
        if (firstTime) {
            return "You have reached the Separatist Casino. This is where the supposed Sparkling Water" +
                    "is retrieved. Go play the Casino";
        } else {
            // if sparkling water quest isn't complete
            return "You still need to win the Casino.";
        }
    }

    @Override
    public SitType getSitType() {return SitType.Interaction;}

    @Override
    public String[] getOptions() {
        String[] options = {"Go to Slots Machine", "Have a drink", "Leave"}; // limit 6
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){

            // MAIN BRANCH
            case "Go to Slots Machine":
               AdvGame.setSituation(SlotsMachine.getInstance());
                break;

            case "Have a drink":
                //Have a beer
                break;
                
            // EXIT POINT
            case "Leave":
                firstTime = false;
                AdvGame.setSituation(SeparatistHub.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }
}

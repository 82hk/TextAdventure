package org.sherwoodhs.situation.Separatist;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class Kitchen implements Situation {
    
    // REVERT EVERYTHING TO EXPLORATION TYPE, MAKE INDIVIDUAL CLASSES FOR EVERY OPTION (maybe with adding previous text in backwards).
    private static boolean firstTime = true;
    private static Situation situation = new Kitchen();

    @Override
    public String getTitle() {
        return "You are in the Ikea Kitchen";
    }

    @Override
    public String getDescription() {
        if (firstTime == true) {
            return "You walk into the kitchen and you see a lady.";
        } else {
            return "You need money. Go find a job";
        }
    }

    @Override
    public SitType getSitType() {return SitType.Interaction;}

    @Override
    public String[] getOptions() {
        String[] options = {"Go to Kitchen", "Talk to lady","Leave"}; // limit 6
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){

            // MAIN BRANCH
            case "Go to Kitchen":
                if (firstTime) {
                    //base entrance situation
                    AdvGame.updateFrame("Work for money",
                            new String[]{"temp","temp"});
                } else {
                    // doesn't matter
                    AdvGame.updateFrame("temp",
                            new String[]{"temp","temp"});
                }
                break;

            case "Talk to Lady":
                if (firstTime) {
                    
                }

                
            // EXIT POINT
            case "Leave":
                firstTime = false;
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

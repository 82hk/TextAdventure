package org.sherwoodhs.situation.Separatist;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class WorkPlace implements Situation {
    
    // REVERT EVERYTHING TO EXPLORATION TYPE, MAKE INDIVIDUAL CLASSES FOR EVERY OPTION (maybe with adding previous text in backwards).
    private static boolean firstTime = true;
    private static Situation situation = new WorkPlace();

    @Override
    public String getTitle() {
        return "Food Court";
    }

    @Override
    public String getDescription() {
        if (firstTime == true) {
            return "You are in the Food Court. You wonder if you can get a job for some money...";
        } else {
            return "You need money find a job";
        }
    }

    @Override
    public SitType getSitType() {return SitType.Interaction;}

    @Override
    public String[] getOptions() {
        String[] options = {"Go to Kitchen", "Leave"}; // limit 6
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

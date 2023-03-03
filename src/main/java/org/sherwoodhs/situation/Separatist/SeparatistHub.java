package org.sherwoodhs.situation.Separatist;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class SeparatistHub implements Situation {
    
    // REVERT EVERYTHING TO EXPLORATION TYPE, MAKE INDIVIDUAL CLASSES FOR EVERY OPTION (maybe with adding previous text in backwards).
    private static boolean firstTime = true;
    private static Situation situation = new SeparatistHub();

    @Override
    public String getTitle() {
        return "The central hub to the Separatist Location";
    }

    @Override
    public String getDescription() {
        if (firstTime == true) {
            return "You are in the central hub...";
        } else {
            return "temp";
        }
    }

    @Override
    public SitType getSitType() {return SitType.Hub;}

    @Override
    public String[] getOptions() {
        String[] options = {"Go to the base entrance", "Go to the Workplace", "Casino" , "Leave"}; // limit 6
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){

            // MAIN BRANCH
            case "Go to the base entrance":
                if (firstTime) {
                    //base entrance situation
                    AdvGame.setSituation(SeparatistBaseEntrance.getInstance());
                } else {
                    // doesn't matter
                    AdvGame.updateFrame("temp",
                            new String[]{"temp","temp"});
                }
                break;

            case "Casino":
                if (firstTime) {
                    //go to casino situation
                    AdvGame.setSituation(Casino.getInstance());
                } else {
                    // doesn't matter
                    AdvGame.updateFrame("temp",
                            new String[]{"temp","temp"});
                }
                break;

            case "Go to the Workplace":
                //Situation to WorkPlace
                AdvGame.setSituation(WorkPlace.getInstance());
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

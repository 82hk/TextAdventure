package org.sherwoodhs.situation.Separatist;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class SeparatistBaseEntrance implements Situation {
    
    // REVERT EVERYTHING TO EXPLORATION TYPE, MAKE INDIVIDUAL CLASSES FOR EVERY OPTION (maybe with adding previous text in backwards).
    private static boolean firstTime = true;
    private static Situation situation = new SeparatistBaseEntrance();

    @Override
    public String getTitle() {
        return "Central Meeting Location";
    }

    @Override
    public String getDescription() {
        if (firstTime == true) {
            return "";
        } else {
            return "temp";
        }
    }

    @Override
    public SitType getSitType() {return SitType.Interaction;}

    @Override
    public String[] getOptions() {
        String[] options = {"Talk to the Chief","Leave"}; // limit 6
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){

            // MAIN BRANCH
            case "Talk to the Chief":
                if (firstTime) {
                    AdvGame.updateFrame("Chief talk dialogue",
                            new String[]{"temp","temp"});
                } else {
                    // if reputation is not enough
                    AdvGame.updateFrame("You are still not wanted",
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

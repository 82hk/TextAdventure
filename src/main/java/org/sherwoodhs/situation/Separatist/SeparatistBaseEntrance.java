package org.sherwoodhs.situation.Separatist;

import org.sherwoodhs.AdvGame;
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
            return "You approach the separatist base where the separatists live. You want to explore, but a person " +
                    "comes up to you and initiates a conversation.";
        } else {
            // if not enough reputation, chief tells you to still go away
            return "temp";
        }
    }

    @Override
    public SitType getSitType() {return SitType.Interaction;}

    @Override
    public String[] getOptions() {
        String[] options = {"Talk to the person","Leave"}; // limit 6
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){

            // MAIN BRANCH
            case "Talk to the person":
                if (firstTime) {
                    AdvGame.updateFrame("The person introduces himself as the chief of the separatist village. Using his local power, he " +
                                    "tells you that you are not wanted, unless you can do him a favor.",
                            new String[]{"Talk to the Chief","Leave"});
                } else {
                    // if reputation is not enough
                    AdvGame.updateFrame("You are still not wanted",
                            new String[]{"Talk to the Chief","Leave"});
                }
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

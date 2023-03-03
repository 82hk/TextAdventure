package org.sherwoodhs.situation.Separatist;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.npc.Separatist.SeparatistChief;
import org.sherwoodhs.npc.NPC;

public class SeparatistBaseEntrance implements Situation {
    
    // REVERT EVERYTHING TO EXPLORATION TYPE, MAKE INDIVIDUAL CLASSES FOR EVERY OPTION (maybe with adding previous text in backwards).
    private static boolean firstTime = true;
    private static Situation situation = new SeparatistBaseEntrance();

    NPC chief = SeparatistChief.getInstance();

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
            if (chief.getHappiness() == 100) {
                //new situation unlock
                return "";
            } else {
                AdvGame.updateFrame(new String[]{"Leave"});
                return "You are still not wanted. You haven't completed the quest yet.";
            }
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
                }
                break;

            case "Talk to the Chief":
                    AdvGame.updateFrame("The Chief tells you that his daughter is very sick. To cure her, she needs the holy liquid: Sparking Water. " +
                                    "To cure her, you need to find three cans of sparkling water.",
                            new String[]{"Ask Chief for information", "Leave"});
                    break;

            case "Ask Chief for information":
                AdvGame.updateFrame("The Separatist have a casino that has never been won before. " +
                                "To get three bottles of water, you need to win the slots machine.",
                        new String[]{"Leave"});
                firstTime = false;
                break;

            // EXIT POINT
            case "Leave":
                AdvGame.setSituation(SeparatistHub.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

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
                            new String[]{"Leave"});
                } break;


                
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

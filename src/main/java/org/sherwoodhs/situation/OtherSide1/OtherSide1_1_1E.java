package org.sherwoodhs.situation.OtherSide1;

import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

/*
 When you select this situation, you leave the Hidden Alcove and are unable to come back.
 You permanently block this questline.

 */
public class OtherSide1_1_1E implements Situation {
    private static Situation situation = new OtherSide1_1_1E();
    private OtherSide1_1_1E(){

    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "A Bad Choice";
    }

    @Override
    public String getDescription() {
        return ("You left the Hidden Alcove. Never did you look back, but there was a nagging feeling that you " +
        "made a bad decision. Your body told you to turn back. Yet, you squashed that feeling. That unnatural attraction " +
        "was unhealthy. Finally, forever pushing away the thoughts of what you just experienced, you returned to _________.\n\n" +
        "You never looked back.");
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        return new String[]{"Continue"};
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Continue" :
                //AdvGame.setSituation(LocationOption.Path.getInstance());
                break;
        }
    }
}

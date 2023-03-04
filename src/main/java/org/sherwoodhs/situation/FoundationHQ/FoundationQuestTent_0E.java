package org.sherwoodhs.situation.FoundationHQ;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class FoundationQuestTent_0E implements Situation {
    private static Situation situation = new FoundationQuestTent_0E();

    @Override
    public String getTitle() {
        return "The Foundation quest tent";
    }

    @Override
    public String getDescription() {
        return "The assignment center buzzes around you. Foundation gaurds ";
    }

    @Override
    public SitType getSitType() {
        return SitType.Interaction;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Talk to assignment manager", "Leave"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch(option){
            case "Leave":
                AdvGame.setSituation(FoundationHub_0E.getInstance());
                break;
            case "Talk to assignment manager":
                AdvGame.updateFrame();
        }
    }

    public static Situation getInstance(){
        return situation;
    }
}

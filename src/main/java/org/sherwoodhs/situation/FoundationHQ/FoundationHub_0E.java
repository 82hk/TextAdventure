package org.sherwoodhs.situation.FoundationHQ;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class FoundationHub_0E implements Situation {
    private static Situation situation = new FoundationHub_0E();

    @Override
    public String getTitle() {
        return "The Foundation HQ";
    }

    @Override
    public String getDescription() {
        return "do";
    }

    @Override
    public SitType getSitType() {
        return SitType.Hub;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Go to armory tent", "Go to command tent", "Go to mess tent", "Go back to The Haven"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch(option) {
            case "Go to armory tent":

                break;
            case "Go back to The Haven":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
            case "Go to command tent":
                break;
            case "Go to mess tent":
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }
}

package org.sherwoodhs.situation.FoundationHQ;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class FoundationMessTent_0E implements Situation {
    private static Situation situation = new FoundationMessTent_0E();

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
        return SitType.Exploration;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Leave"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch(option) {
            case "Leave":
                AdvGame.setSituation(FoundationHub_0E.getInstance());
        }
    }

    public static Situation getInstance(){
        return situation;
    }
}

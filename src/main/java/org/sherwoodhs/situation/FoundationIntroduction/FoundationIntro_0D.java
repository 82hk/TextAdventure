package org.sherwoodhs.situation.FoundationIntroduction;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Dialogue;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class FoundationIntro_0D implements Situation {
    private static Situation situation = new FoundationIntro_0D();

    public static Situation getInstance(){
        return situation;
    }

    @Override
    public String getTitle() {
        return "The Foundation Booth";
    }

    @Override
    public String getDescription() {
        return "Do";
    }

    @Override
    public SitType getSitType() {
        return SitType.Dialogue;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Talk to guard", "Go back to The Haven"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch(option) {
            case "Talk to guard":

                break;
            case "Go back to The Haven":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
        }
    }
}

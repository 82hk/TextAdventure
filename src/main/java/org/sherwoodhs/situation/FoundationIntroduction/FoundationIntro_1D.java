package org.sherwoodhs.situation.FoundationIntroduction;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.npc.foundation.FoundationGuard;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class FoundationIntro_1D implements Situation {
    private static Situation situation = new FoundationIntro_1D();
    NPC Guard = FoundationGuard.getInstance();

    @Override
    public String getTitle() {
        return "The Foundation booth";
    }

    @Override
    public String getDescription() {
        return "The guard ";
    }

    @Override
    public SitType getSitType() {
        return SitType.Dialogue;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Talk to The Guard", "Go back to The Haven"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch(option) {
            case "Talk to The Guard":

                break;
            case "Go back to The Haven":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
        }

    }

    public static Situation getInstance(){
        return situation;
    }
}

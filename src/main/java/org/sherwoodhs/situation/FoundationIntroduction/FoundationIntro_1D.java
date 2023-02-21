package org.sherwoodhs.situation.FoundationIntroduction;

import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.npc.foundation.FoundationGuard;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class FoundationIntro_1D implements Situation {
    NPC Guard = FoundationGuard.getInstance();

    @Override
    public String getTitle() {
        return "The Foundation";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public SitType getSitType() {
        return SitType.Dialogue;
    }

    @Override
    public String[] getOptions() {
        return new String[0];
    }

    @Override
    public void perform(String option) {

    }
}

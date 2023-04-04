package org.sherwoodhs.situation.Foundation.quests;

import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;


public class CourierQuest implements Situation {
    @Override
    public String getTitle() {
        return "Transport The Message";
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public SitType getSitType() {
        return SitType.Interaction;
    }

    @Override
    public String[] getOptions() {
        return new String[0];
    }

    @Override
    public void perform(String option) {

    }

    @Override
    public ImageIcon getImg() {
        return null;
    }
}

package org.sherwoodhs.situation.Foundation.FoundationHQ;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;

public class FoundationMessTent_0E implements Situation {
    private static Situation situation = new FoundationMessTent_0E();

    @Override
    public String getTitle() {
        return "The Foundation mess hall";
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

    @Override
    public ImageIcon getImg() {
        return null;
    }

    public static Situation getInstance(){
        return situation;
    }
}

package org.sherwoodhs.situation.FoundationHQ;

import javafx.application.Application;
import javafx.stage.Stage;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class FoundationBlacksmith_0E implements Situation {
    private static Situation situation = new FoundationBlacksmith_0E();
    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public SitType getSitType() {
        return null;
    }

    @Override
    public String[] getOptions() {
        return new String[0];
    }

    @Override
    public void perform(String option) {

    }
    public static Situation getInstance(){
        return situation;
    }
}


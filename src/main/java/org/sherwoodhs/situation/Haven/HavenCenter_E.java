package org.sherwoodhs.situation.Haven;

import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class HavenCenter_E implements Situation {

    private static Situation situation = new HavenCenter_E();

    @Override
    public String getTitle() {
        return "Haven Center";
    }

    @Override
    public String getDescription() {
        return "You are in the city center of The Haven.";
    }

    @Override
    public SitType getSitType() {
        return SitType.Hub;
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

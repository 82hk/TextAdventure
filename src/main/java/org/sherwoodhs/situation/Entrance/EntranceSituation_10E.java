package org.sherwoodhs.situation.Entrance;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class EntranceSituation_10E implements Situation {
    private static Situation situation = new EntranceSituation_10E();

    @Override
    public String getTitle() {
        return "???";
    }

    @Override
    public String getDescription() {
        return "";

    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Explore","Go back"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Explore":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
            case "Go back":
                AdvGame.setSituation(EntranceSituation_11E.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

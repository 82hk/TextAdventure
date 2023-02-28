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
        return "Everything in sight bears the familiar look and feel of an Ikea department store but there are no employees to be seen, only this vast crowd interspersed by scattered groups of mall security guards roaming about."+
              "\n\nStepping forward, you see this vast chamber is actually created by the joining of four enormous halls in the shape of an 'X', each as tall as the room itself and with just as many floors, stretching far into the distance and out of sight."+
              "\n\nYou are on the ground floor."+
              "\n\nYou feel rather small.";

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

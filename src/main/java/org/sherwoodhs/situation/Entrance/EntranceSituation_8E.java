package org.sherwoodhs.situation.Entrance;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class EntranceSituation_8E implements Situation {
    private static Situation situation = new EntranceSituation_8E();

    @Override
    public String getTitle() {
        return "The Ikea - ???";
    }

    @Override
    public String getDescription() {
        return "You step forward and cautiously try the doorknob.\n\nWith a shrill squeak, it turns.";
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Enter"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Enter":
                AdvGame.setSituation(EntranceSituation_9E.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

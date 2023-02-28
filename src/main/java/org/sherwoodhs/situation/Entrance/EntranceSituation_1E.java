package org.sherwoodhs.situation.Entrance;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class EntranceSituation_1E implements Situation {
    private static Situation situation = new EntranceSituation_1E();

    @Override
    public String getTitle() {
        return "The Ikea - Entrance";
    }

    @Override
    public String getDescription() {
        return "The massive ‘Ikea’ sign looms high above as the fluorescent glow of the interior lights flood through display "+
            "windows near the entrance. Against the pitch black of the night sky, the light is nearly blinding.";
";
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Enter","Go to Home Depot"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Enter":
                AdvGame.setSituation(EntranceSituation_2E.getInstance());
                break;
            case "Go to Home Depot":
                AdvGame.setSituation(EntranceSituation_3E.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

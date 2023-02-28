package org.sherwoodhs.situation.Entrance;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class EntranceSituation_7E implements Situation {
    private static Situation situation = new EntranceSituation_7E();

    @Override
    public String getTitle() {
        return "Ending - Lost";
    }

    @Override
    public String getDescription() {
        return "You ignore the obvious hint and carry on wandering through the Ikea.\n\nYou never find the exit, "+
          "though you do eventually find the food court and live out the rest of your days on stale meatballs and bottled water.";
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Exit","Restart"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Exit":
                // Exit game
                break;
            case "Restart":
                // Restart game
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

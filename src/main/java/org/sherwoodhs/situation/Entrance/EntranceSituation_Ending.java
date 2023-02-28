package org.sherwoodhs.situation.Entrance;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class EntranceSituation_Ending implements Situation {
    private static Situation situation = new EntranceSituation_1E();

    @Override
    public String getTitle() {
        return "Ending - Home Depot";
    }

    @Override
    public String getDescription() {
        return "Unnerved by the absence of any sign of life, you decide to try your luck at the nearby Home Depot instead.\n\n"+
          "Getting back in your car, you pull out of the parking lot and drive away, leaving the Ikea—and the entire point of the game—behind you."+
          "\n\nThe End.";
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
                // End the game
                break;
            case "Restart":
                // Restart game.
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

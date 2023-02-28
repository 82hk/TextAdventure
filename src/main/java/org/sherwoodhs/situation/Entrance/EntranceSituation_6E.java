package org.sherwoodhs.situation.Entrance;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class EntranceSituation_6E implements Situation {
    private static Situation situation = new EntranceSituation_6E();

    @Override
    public String getTitle() {
        return "The Ikea - ???";
    }

    @Override
    public String getDescription() {
        return "You wander aimlessly down more aisles lined with display rooms, through the labyrinthian twists and turns of the Ikea.\n\n"+
          "Eventually, you turn the corner to see a door on the far wall. It's a small gray utility door, "+
          "quietly placed between two ornately decorated showroom displays.";
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Keep going","Open the door"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Keep going":
                AdvGame.setSituation(EntranceSituation_Ending2.getInstance());
                break;
            case "Open the door":
                AdvGame.setSituation(EntranceSituation_8E.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

package org.sherwoodhs.situation.Entrance;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class EntranceSituation_4E implements Situation {
    private static Situation situation = new EntranceSituation_4E();

    @Override
    public String getTitle() {
        return "The Ikea - Food Court...?";
    }

    @Override
    public String getDescription() {
        return "You go further into the Ikea.\n\nPast showrooms and home decorations; past kitchenware and tiled counters and cabinets galore. "+
            "Past bedroom displays overflowing with pillows; past dining table chairs of every shape, color, and size. "+
            "Past bathroom tiles and shower curtains; through the winding maze of the store’s floor plan you navigate until you reach the—\n\n"+
            "Food court.\n\nOr at least, this is where the food court had always been. Instead there’s only more furniture: "+
            "a few mattress displays and bins of assorted blankets.\n\nHave they remodeled?";
;
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Keep going"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Keep going":
                AdvGame.setSituation(EntranceSituation_5E.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

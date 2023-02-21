package org.sherwoodhs.situation.EntranceSituation;

/*
The very first situation, introduces the character and motivation. Starts the get furniture quest.
 */

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Clearwater.ClearwaterKiosk1_0E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class EntranceSituation_0E implements Situation {
    private static Situation situation = new EntranceSituation_0E();


    @Override
    public String getTitle() {
        return "The Entrance";
    }

    @Override
    public String getDescription() {
        AdvGame.addQuest("Retrieve furniture");
        return "Ugh. It's been a long day. \n\n" +
                "The police finally figured out what happened in your apartment, apparently there's been a series of furniture-related crimes recently. You'll need to replace your bed at least before tonight. " +
                "You made your way to the local IKEA, you don't wanna waste too much money after all that stuff was stolen, and besides, you could use the practice assembling anyway. " +
                "The parking lot is mostly empty. It's strange they keep the place open this late.\n\n" +
                "It would be nice if I could find a couch too, but it's pretty late already, I might just grab one if I see it.";
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Enter the IKEA","Skip to Clearwater"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Enter the IKEA":
                AdvGame.setSituation(EntranceSituation_1E.getInstance());
                break;
            case "Skip to Clearwater":
                AdvGame.setSituation(ClearwaterKiosk1_0E.getInstance());
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

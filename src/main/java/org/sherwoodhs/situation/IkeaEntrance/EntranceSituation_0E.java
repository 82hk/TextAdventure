package org.sherwoodhs.situation.IkeaEntrance;

/*
The very first situation, introduces the character and motivation. Starts the get furniture quest.
 */

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.quest.StolenFurnQuest;
import org.sherwoodhs.situation.Clearwater.ClearwaterKiosk1_0E;
import org.sherwoodhs.situation.FoundationIntroduction.FoundationIntro_1D;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.LocationOptions.HiddenAlcove.HiddenAlcove1_0E;
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
        AdvGame.addQuest(StolenFurnQuest.getInstance());
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
        String[] options = {"Enter the IKEA","Skip to Clearwater", "Skip to Hidden Alcove", "Skip to Haven"};
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
                break;
            case "Skip to Hidden Alcove":
                AdvGame.setSituation(HiddenAlcove1_0E.getInstance());
                break;
            case "Skip to Haven":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

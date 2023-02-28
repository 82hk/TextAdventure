package org.sherwoodhs.situation.Entrance;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.quest.StolenFurnQuest;
import org.sherwoodhs.situation.Clearwater.KioskIntro.ClearwaterKiosk1_0E;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.HiddenAlcove.HiddenAlcove1_0E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class EntranceSituation_0E implements Situation {
    private static Situation situation = new EntranceSituation_0E();

    @Override
    public String getTitle() {
        return "The Ikea - Parking Lot";
    }

    @Override
    public String getDescription() {
        return "There it is—the Ikea furniture and home improvement store.\n\nThe blue and yellow of the concrete building stretches from end to end across "+
            "the huge lot. Despite the size of the retail store, there’s not a single person in sight. The parking lot is similarly deserted, with nothing "+
            "but rows of empty spaces illuminated by the occasional streetlamp.";
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Approach", "Test: Hidden Alcove", "Test: Haven"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Approach":
                AdvGame.setSituation(EntranceSituation_1E.getInstance());
                break;
            case "Test: Hidden Alcove":
                AdvGame.setSituation(HiddenAlcove1_0E.getInstance());
                break;
            case "Test: Haven":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

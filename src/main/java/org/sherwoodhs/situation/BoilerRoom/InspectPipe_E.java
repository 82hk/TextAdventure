package org.sherwoodhs.situation.BoilerRoom;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class InspectPipe_E implements Situation {
    private static Situation situation = new InspectPipe_E();
    @Override
    public String getTitle() {
        return "The Boiler Room";
    }
    @Override
    public String getDescription() {
        return "You take a closer look at one of the large rusty pipes near you... one that's not leaking steam.\n\n" +
                "You try and rub off some of the rust to see if there's anything you can find. Some of the rust flakes off, " +
                "revealing dull gold metal underneath. It doesn't look like any metal you've seen before. However, it doesn't look like there's anything else of note here.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        return new String[]{"Return"};
    }
    @Override
    public void perform(String option) {
        switch(option) {
            case "Return":
                AdvGame.setSituation(BoilerRoom_0E.getInstance());
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}

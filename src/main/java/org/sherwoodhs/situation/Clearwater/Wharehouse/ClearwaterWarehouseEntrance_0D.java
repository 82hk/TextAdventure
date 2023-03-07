package org.sherwoodhs.situation.Clearwater.Wharehouse;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class ClearwaterWarehouseEntrance_0D implements Situation {
    private static final Situation situation = new ClearwaterWarehouseEntrance_0D();

    @Override
    public String getTitle() {
        return "Warehouse Entrance";
    }

    @Override
    public String getDescription() {
        return "You walk across the plaza to a large bay door, currently shuttered by a metal grating. On the other " +
                "side of the grating, a wide hallway curves around out of sight. You hear distant sounds of shouting " +
                "echoing from the hall.\n\nA Foundation guard leans against the metal grating, eyeing you.";
    }

    @Override
    public SitType getSitType() {
        return SitType.Dialogue;
    }

    @Override
    public String[] getOptions() {
        return new String[]{"Talk", "Enter", "Leave"};
    }

    @Override
    public void perform(String option) {
        switch (option) {
            case "Talk":
                AdvGame.updateFrame("",
                        new String[]{"The Distributor sent me", "Bribe [100x scrap]"});
                break;
            case "Enter":
                AdvGame.updateFrame("Guard: Sorry pal, that’s a restricted area. No entry without " +
                                "proper clearance.\n\nHe stares at you",
                        new String[]{"Talk", "Leave"});
                break;
            case "The Distributor sent me":
                AdvGame.updateFrame("You: The Distributor told me to come here. He offered me a job working for " +
                                "Clearwater...this is the place, right?\n\nThe guard looks at you a moment longer, turns and spits, " +
                                "then presses a button on the wall.\n\nYou hear the sound of a creaky motor coming to life, and the metal grate rises.\n",
                        new String[]{"Enter ", "Leave"});
                break;
            case "Bribe [100x scrap]":
                AdvGame.updateFrame("The guard glances around, then nods silently and takes your offering. He presses " +
                                "a button on the wall and the metal grate slowly rises.",
                        new String[]{"Enter ", "Leave"});
                break;
            case "Enter ":
                AdvGame.updateFrame("You step across the threshold and into the passageway. It’s poorly lit and has a greasy, mechanical look.",
                        new String[]{"Continue", "[Hangil's room]"});
                break;
            case "Continue":
                AdvGame.setSituation(ClearwaterWarehouse_0D.getInstance());
                break;
            case "Leave":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
        }
    }
    public static Situation getInstance(){
        return situation;
    }
}

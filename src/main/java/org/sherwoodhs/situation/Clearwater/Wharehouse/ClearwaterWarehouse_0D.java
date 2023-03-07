package org.sherwoodhs.situation.Clearwater.Wharehouse;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Clearwater.KioskIntro.ClearwaterKiosk1_2D;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class ClearwaterWarehouse_0D implements Situation {
    private static final Situation situation = new ClearwaterWarehouse_0D();

    @Override
    public String getTitle() {
        return "Clearwater Warehouse";
    }

    @Override
    public String getDescription() {
        return "You turn the corner and are nearly blinded by a glaring light.\n\nIn front of you is " +
                "the interior of a warehouse, stretching far into the distance and lit by massive industrial lights. Towering " +
                "shelves reach far up to the ceiling while down on the floor men in gray uniforms carry pallets loaded with " +
                "bottled water.\n\nJust ahead of you, a short man with an ambitious waistline dressed in a black suit shouts " +
                "through a megaphone at the warehouse workers.";
    }

    @Override
    public SitType getSitType() {
        return SitType.Dialogue;
    }

    @Override
    public String[] getOptions() {
        return new String[]{"Approach", "Leave"};
    }

    @Override
    public void perform(String option) {
        switch (option) {
            case "Approach":
                AdvGame.updateFrame("You approach the man, who whirls around and glares at you.\n\n" +
                        "The Man: What do you want?\n\nHe barks through the megaphone.",
                        new String[]{"Job [ Distributor ]", "Inspecting [ Lie ]"});
                break;
            case "Inspecting [ Lie ]":
                AdvGame.updateFrame("You: I-I’m here to inspect the warehouse, on orders from...",
                        new String[]{"The Distributor", "The Foundation"});
                break;
            case "The Distributor":
                AdvGame.updateFrame("The man narrows his eyes.\n\nThe Man: Fine, but it’ll cost you. 50 scrap.",
                        new String[]{"Pay [50x scrap]", "Leave"});
                break;
            case "Pay [50x scrap]":
                AdvGame.updateFrame("The man eyes the scrap and snatches it from your hand, shoving it into his suit coat.\n\n" +
                        "The Man: Make it quick.",
                        new String[]{"Explore"});
                break;
            case "Explore":
                AdvGame.updateFrame("[Content]",
                        new String[]{"Leave"});
                break;
            case "Job [ Distributor ]":
                AdvGame.updateFrame("You: I was told I could get a job here. The Distributor sent me.\n\nThe man narrows his eyes, " +
                        "then gestures to the warehouse shelves behind him.\n\nThe Man: Get to work.",
                        new String[]{"Work", "Leave"});
                break;
            case "Work":
                AdvGame.updateFrame("[ You work. Replace later with Dean’s minigame ]",
                        new String[]{"Explore", "Leave"});
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

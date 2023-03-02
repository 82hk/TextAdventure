package org.sherwoodhs.situation.BoilerRoom;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.location.BoilerRoom;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.situation.BoilerRoom.Generator.Generator_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;

public class BoilerRoom_1E implements Situation {
    private boolean firstTime = true;
    private boolean collectedPipe = false;
    private boolean clickedContinue = false;
    private static Situation situation = new BoilerRoom_1E();
    Location location = BoilerRoom.getInstance();
    private BoilerRoom_1E() {
    }
    @Override
    public String getTitle() {
        return "The Boiler Room";
    }
    @Override
    public String getDescription() {
        if (firstTime) {
            return "You walk forward into the humid darkness. The never-ending darkness envelops you. " +
                    "As you climb over the shards of a shattered pipe, you notice a small flickering light in the distance...\n\n" +
                    "You can't really make out where the light is coming from, but it seems to be colored red.";
        }
        if (collectedPipe) {
            if (clickedContinue) {
                clickedContinue = false;
                return "You stand in the darkness, staring at the red light off in the distance.";
            }
            return "You travel forward through the humid darkness. A hulking silhouette of the generator looms in the distance, and a bright red light.";
        }
        return "You travel forward through the humid darkness. " +
                "You climb over the shards of a shattered pipe on the ground... carefully, so you don't cut yourself on accident. " +
                "There's a small red light off in the distance. It seems to be unstable, however... it's flickering.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        if (!collectedPipe) {
            return new String[]{"Travel towards the light", "Grab one of the pipe shards", "Turn back"};
        }
        return new String[]{"Travel towards the light", "Turn back"};
    }
    @Override
    public void perform(String option) {
        switch (option) {
            case "Travel towards the light":
                firstTime = false;
                AdvGame.setSituation(Generator_E.getInstance());
                break;
            case "Continue":
                clickedContinue = true;
                AdvGame.setSituation(getInstance());
                break;
            case "Grab one of the pipe shards":
                firstTime = false;
                inventoryPanel.addToInventory("A shard of a rusty pipe");
                collectedPipe = true;
                AdvGame.updateFrame(
                        "You carefully grab one of the shards off the ground, so you don't cut yourself.",
                        new String[]{"Continue"});
                break;
            case "Turn back":
                AdvGame.setSituation(BoilerRoom_0E.getInstance());
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}

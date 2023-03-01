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
    private static Situation situation = new BoilerRoom_1E();
    Location location = BoilerRoom.getInstance();
    private BoilerRoom_1E() {
        World.setStateS("Location", location.getName());
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
            return "You travel forward through the humid darkness. A hulking silhouette of something looms in the distance, and a flashing red light.";
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
        if (collectedPipe) {
            return new String[]{"Travel towards the light", "Grab one of the pipe shards", "Turn back"};
        }
        return new String[]{"Travel towards the light", "Turn back"};
    }
    @Override
    public void perform(String option) {
        firstTime = false;
        switch (option) {
            case "Travel towards the light":
                AdvGame.setSituation(Generator_E.getInstance());
                break;
            case "Grab one of the pipe shards":
                inventoryPanel.addToInventory("A shard of a rusty pipe");
                collectedPipe = true;
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

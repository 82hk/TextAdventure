package org.sherwoodhs.situation.BoilerRoom.Abyss.Canyon;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;

public class Crevasse_0E implements Situation {
    private boolean clickedReturn = false;
    private boolean firstTime = true;
    private static Situation situation = new Crevasse_0E();
    @Override
    public String getTitle() {
        if (World.discoveredAbyssInfo) {
            return "Canyon of Ashes";
        }
        return "???";
    }
    @Override
    public String getDescription() {
        if (clickedReturn) {
            clickedReturn = false;
            return "You look out towards the massive crevasse. The rope bridge swings slightly as you pace around. Should you cross?";
        }
        if (World.discoveredAbyssInfo) {
            return "You walk towards the massive crevasse. In the distance, you see an old rotting rope bridge you could probably cross.";
        }
        if (firstTime) {
            return "You move towards the crevasse. It stretches widely into some unfathomable darkness. " +
                    "In the distance, you see an old rotting rope bridge… you think to yourself. " +
                    "You should probably cross it once you have more information. " +
                    "Behind you, there is a mound of fabric you haven’t inspected yet.";
        }
        return "You move towards the crevasse. It stretches widely into some unfathomable darkness. " +
                "In the distance, you see an old rotting rope bridge… you think to yourself. " +
                "You should probably cross it once you have more information.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        if (World.discoveredAbyssInfo) {
            return new String[]{"Inspect the tent behind you", "Cross the rope bridge", "Return to the lake"};
        }
        return new String[]{"Inspect the mound of fabric", "Return to the lake"};
    }
    @Override
    public void perform(String option) {
        firstTime = false;
        switch (option) {
            case "Inspect the tent behind you":
            case "Inspect the mound of fabric":
                AdvGame.setSituation(Tent_E.getInstance());
                break;
            case "Cross the rope bridge":
                AdvGame.clearFrameWithoutSpacing(
                        "You stand in front of the rope bridge. The rope is fraying at the ends, and it doesn't look that structurally stable.",
                        new String[]{"Cross", "Return"}
                );
                break;
            case "Cross":
                AdvGame.setSituation(Crevasse_1E.getInstance());
                break;
            case "Return":
                clickedReturn = true;
                AdvGame.setSituation(getInstance());
                break;
            case "Return to the lake":
                AdvGame.setSituation(Aquifer_E.getInstance());
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}

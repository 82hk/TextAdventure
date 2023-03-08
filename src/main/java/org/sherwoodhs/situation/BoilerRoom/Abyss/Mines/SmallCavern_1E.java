package org.sherwoodhs.situation.BoilerRoom.Abyss.Mines;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.situation.BoilerRoom.Abyss.Surface.Outcropping_E;
import org.sherwoodhs.situation.BoilerRoom.Generator.Passage_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class SmallCavern_1E implements Situation {
    private static Situation situation = new SmallCavern_1E();
    private boolean cameReverse = false;
    @Override
    public String getTitle() {
        if (World.discoveredAbyssInfo) {
            return "Abyss Mines";
        }
        return "???";
    }
    @Override
    public String getDescription() {
        if (cameReverse) {
            cameReverse = false;
            return "You walk forward, and it begins angling upwards. A small, flickering blue lantern like the one illuminating the rope above is hanging from the ceiling.";
        }
        return "You walk forward into the passage you uncovered, and it begins angling downwards. A small, flickering blue lantern like the one illuminating the rope above is hanging from the ceiling. " +
                "Your shoes make a crunching noise as you step on small pebbles scattered across the floor.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        return new String[]{"Move forward", "Return"};
    }
    @Override
    public void perform(String option) {
        switch (option) {
            case "Move forward":
                cameReverse = true;
                AdvGame.setSituation(SmallCavern_2E.getInstance());
                break;
            case "Return":
                AdvGame.setSituation(SmallCavern_1E.getInstance());
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}


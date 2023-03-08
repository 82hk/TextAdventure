package org.sherwoodhs.situation.BoilerRoom.Abyss.Canyon;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class SpiralRock_0E implements Situation {
    private static Situation situation = new SpiralRock_0E();
    @Override
    public String getTitle() {
        if (World.discoveredAbyssInfo) {
            return "Canyon of Ashes";
        }
        return "???";
    }
    @Override
    public String getDescription() {
        return "You climb down from the boulder, and slosh your way over to the spiral-shaped rocks. " +
                "You touch one of the rocks, and it feels rough and almost porous, like volcanic rock. " +
                "The spirals seem to be almost reaching for the soft blue glow of the pit’s opening above you.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        return new String[]{"Study the rocks further", "Return to the lake"};
    }
    @Override
    public void perform(String option) {
        switch (option) {
            case "Study the rocks further":
                AdvGame.setSituation(SpiralRock_1E.getInstance());
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

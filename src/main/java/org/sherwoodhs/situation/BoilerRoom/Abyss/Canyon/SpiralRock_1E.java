package org.sherwoodhs.situation.BoilerRoom.Abyss.Canyon;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class SpiralRock_1E implements Situation {
    private static Situation situation = new SpiralRock_1E();
    @Override
    public String getTitle() {
        return "???";
    }
    @Override
    public String getDescription() {
        return "You decide to look at the rocks more carefully. " +
                "Upon closer inspection, it seems that there are small flecks of clear crystal embedded in the rock. " +
                "Perhaps it is the same material that the massive clear boulders are made of?";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        return new String[]{"Inspect the flecks of crystal", "Return to the lake"};
    }
    @Override
    public void perform(String option) {
        switch (option) {
            case "Inspect the flecks of crystal":
                AdvGame.updateFrame(
                        "While the crystal flecks do look pretty, there doesn’t seem to be much you can do with them.",
                        new String[]{"Return to the lake"}
                );
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

package org.sherwoodhs.situation.BoilerRoom.Abyss.Canyon.PraffitSettlement;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class PraffitEntrance_E implements Situation {
    private static Situation situation = new PraffitEntrance_E();
    private boolean firstTime = true;
    @Override
    public String getTitle() {
        if (World.discoveredAbyssInfo) {
            return "Praffit";
        }
        return "???";
    }
    @Override
    public String getDescription() {
        if (firstTime) {
            return "Settlement.";
        }
        return "Settlement.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        return new String[]{"A"};
    }
    @Override
    public void perform(String option) {
        switch (option) {
            case "Walk on the pathway":
                AdvGame.updateFrame(
                        "???.",
                        new String[]{"Return to the lake"}
                );
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}

package org.sherwoodhs.situation.BoilerRoom.Abyss.Canyon;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.situation.BoilerRoom.Abyss.Canyon.PraffitSettlement.PraffitEntrance_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class Crevasse_1E implements Situation {
    private static Situation situation = new Crevasse_1E();
    private boolean firstTime = true;
    @Override
    public String getTitle() {
        if (World.discoveredAbyssInfo) {
            return "Canyon of Ashes";
        }
        return "???";
    }
    @Override
    public String getDescription() {
        if (firstTime) {
            return "You stumble across the rope bridge. You definitely... absolutely, do not want to look down.\n\n" +
                    "Suddenly, a slight breeze blows through the canyon and you catch your breath. A sense of vertigo overcomes you as you're forced to look down into the dark depths.\n" +
                    "You will not die here. As you reach the other side with renewed confidence, the rope bridge suddenly gives way under you.\n" +
                    "You let out a gasp but you grab the ledge with your two hands. You prop yourself up, and sit dizzily on the ledge. You survived... but there is no way back now.\n\n" +
                    "You look around, and you see a pathway carved into the porous gray rock, leading to a large spire-like structure in the distance.";
        }
        return "You look out towards the other side of the crevasse you crossed. The massive crevasse gapes, leading into an unfathomable darkness. You wish you would have been more careful crossing the rope bridge.\n\n" +
                "You look around, and you see a pathway carved into the porous gray rock, leading to a large spire-like structure in the distance.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        return new String[]{"Walk on the pathway"};
    }
    @Override
    public void perform(String option) {
        switch (option) {
            case "Walk on the pathway":
                AdvGame.setSituation(PraffitEntrance_E.getInstance());
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}

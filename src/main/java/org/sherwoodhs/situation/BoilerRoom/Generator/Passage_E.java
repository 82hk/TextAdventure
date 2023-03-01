package org.sherwoodhs.situation.BoilerRoom.Generator;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class Passage_E implements Situation {
    @Override
    public String getTitle() {
        return "A Dark Passage";
    }
    @Override
    public String getDescription() {
        return "You are inside a dark passage. You can't really tell what the walls are made out of. " +
                "There seems to be water dripping somewhere off in the distance. Its sound is amplified by the narrow tunnel.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        return new String[]{"Move into the darkness", "Return to the generator"};
    }
    @Override
    public void perform(String option) {
        switch (option) {
            case "Move into the darkness":
                break;
            case "Return to the generator":
                AdvGame.setSituation(Generator_E.getInstance());
                break;
        }
    }
}

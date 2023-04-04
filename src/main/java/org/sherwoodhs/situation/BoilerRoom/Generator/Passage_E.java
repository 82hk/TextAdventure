package org.sherwoodhs.situation.BoilerRoom.Generator;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.BoilerRoom.Abyss.Surface.Outcropping_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;

public class Passage_E implements Situation {
    private boolean firstTime = true;
    private static Situation situation = new Passage_E();
    @Override
    public String getTitle() {
        return "A Dark Passage";
    }
    @Override
    public String getDescription() {
        if (firstTime) {
            return "Before you enter the narrow entrance, you strain your eyes to see if there is anything to warn you of any dangers lying ahead. " +
                    "However, the passage is so dark that you can't see anything.\n\n" +
                    "You carefully step into the passage. It's cool... it offers a bit of a reprieve from the humid steam of the boiler room.\n\n" +
                    "Feeling more confident, you inspect the wall closest to you, even though it's quite dark. " +
                    "However, you can't really tell what the walls are made out of. There seems to be water dripping somewhere off in the distance. " +
                    "Its sound is amplified by the narrow tunnel.";
        }
        return "You are inside a dark passage, now warm due to the exposure to the boiler room. Again, you can't really tell what the walls are made out of. " +
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
        firstTime = false;
        switch (option) {
            case "Move into the darkness":
                AdvGame.setSituation(Outcropping_E.getInstance());
                break;
            case "Return to the generator":
                AdvGame.setSituation(Generator_E.getInstance());
                break;
        }
    }

    @Override
    public ImageIcon getImg() {
        return null;
    }

    public static Situation getInstance() {
        return situation;
    }
}

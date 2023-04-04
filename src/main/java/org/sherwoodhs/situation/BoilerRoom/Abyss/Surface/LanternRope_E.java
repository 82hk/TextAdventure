package org.sherwoodhs.situation.BoilerRoom.Abyss.Surface;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.situation.BoilerRoom.Abyss.Forest.Clearing_E;
import org.sherwoodhs.situation.BoilerRoom.Abyss.Mines.SmallCavern_0E;
import org.sherwoodhs.situation.BoilerRoom.Generator.Passage_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;

public class LanternRope_E implements Situation {
    private boolean firstTime = true;
    private boolean inspectedLantern = false;
    private static Situation situation = new LanternRope_E();
    @Override
    public String getTitle() {
        if (World.discoveredAbyssInfo) {
            return "The Surface";
        }
        return "???";
    }
    @Override
    public String getDescription() {
        if (firstTime) {
            return "You take a deep breath and jump on the ledge to your right. Thankfully, it doesn’t shake under your weight.\n\n" +
                    "You make your way forwards, and you come upon a thin rope softly illuminated by a small blue lantern that leads downwards. " +
                    "You’ve never seen any light source that was so bright blue… you look at it with wonder. " +
                    "It is made of what looks like black cast iron, with intricate details that you can’t quite make out what it’s supposed to be. " +
                    "Anyways, you notice that there is also a rope ladder that ascends up towards a tall ridge.";
        }
        return "In front of you is a thin rope softly illuminated by a beautiful but small lantern going down.\n\n" +
                "The lantern emits a ghostly blue light. There’s also a rope ladder that seemingly climbs up towards a tall ridge.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        if (inspectedLantern) {
            return new String[]{"Slide down the rope", "Climb the rope ladder", "Return to the outcropping"};
        }
        return new String[]{"Slide down the rope", "Inspect the lantern", "Climb the rope ladder", "Return to the outcropping"};
    }
    @Override
    public void perform(String option) {
        firstTime = false;
        switch (option) {
            case "Return to the outcropping":
                AdvGame.setSituation(Outcropping_E.getInstance());
                break;
            case "Slide down the rope":
                AdvGame.setSituation(SmallCavern_0E.getInstance());
                break;
            case "Climb the rope ladder":
                AdvGame.setSituation(Clearing_E.getInstance());
                break;
            case "Inspect the lantern":
                inspectedLantern = true;
                AdvGame.updateFrame(
                        "You take a closer look at the lantern. You notice that the lantern is hanging off a hook on a rotting wooden pole. " +
                                "You try to slide the lantern off the hook, but a strong ache shoots through your head. " +
                                "As you straddle your head in your hands, " +
                                "you think to yourself that it might be a good idea not to touch it anymore.",
                        new String[]{"Continue"});
                break;
            case "Continue":
                AdvGame.setSituation(getInstance());
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


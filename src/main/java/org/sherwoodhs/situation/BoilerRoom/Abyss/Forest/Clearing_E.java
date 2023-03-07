package org.sherwoodhs.situation.BoilerRoom.Abyss.Forest;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.BoilerRoom.Abyss.Surface.LanternRope_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class Clearing_E implements Situation {
    boolean firstTime = true;
    private static Situation situation = new Clearing_E();
    @Override
    public String getTitle() {
        return "???";
    }
    @Override
    public String getDescription() {
        if (firstTime) {
            return "You slowly climb up the ladder. It shakes as you begin to climb… but you still have a long way to go. You try not to look down as you inch closer and closer to your destination. After a heart-wrenching climbing session, you catch your breath at the top of the ridge. " +
                    "You look around, and you’re met with a breathtaking view. In front of you is a massive forest… it must have been hidden by the ridges towering over the cavern you were just in.\n" +
                    "The issue is, the forest is upside down. The tops of the trees are all that is visible from the rock you stand on; the forest is quite thick, so you can’t see what’s below the trees. Above the trees? " +
                    "The forest on the ground is just as thick, but currently you’re in an expansive clearing. \n" +
                    "You can see vines wrapping around many of the tree trunks, and what seems to be butterflies and birds flying around. " +
                    "Seeing these animals makes you wonder if you'll ever be able to leave this IKEA…\n" +
                    "Around you are stacks of what looks to be basic wooden furniture: chairs, tables, desks, nightstands… they seem to be returned products. " +
                    "They must have been up here for who knows long; many are quite moldy and are in various states of disrepair.";
        }
        return "You carefully climb the rope ladder. " +
                "As you catch your breath at the top of the ridge, you look up at the breathtaking upside-down forest above you, and the normal forest around you. " +
                "You wonder if you could get up to the upside-down part of the forest safely. " +
                "If only it was the right way up…\n\n" +
                "However the only things that can comfort you here are a smattering of returned moldy chairs and tables… " +
                "and the mysterious forest in front of you.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        return new String[]{"Move forward", "Climb down the ladder"};
    }
    @Override
    public void perform(String option) {
        switch (option) {
            case "Move forward":
                break;
            case "Climb down the ladder":
                AdvGame.setSituation(LanternRope_E.getInstance());
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}

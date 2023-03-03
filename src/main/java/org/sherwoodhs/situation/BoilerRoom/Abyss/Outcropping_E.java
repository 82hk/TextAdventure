package org.sherwoodhs.situation.BoilerRoom.Abyss;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.BoilerRoom.Generator.Passage_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class Outcropping_E implements Situation {
    private boolean firstTime = true;
    private static Situation situation = new Outcropping_E();
    @Override
    public String getTitle() {
        return "???";
    }
    @Override
    public String getDescription() {
        if (firstTime) {
            return "As you walk further down the passage, you see a soft blue glow in the distance. Tired of the narrow tunnel, " +
                    "you dash towards the glow... and almost fall to your death.\n\n" +
                    "Thankfully, you stopped right before you fell off a small ledge. You take a quick look around you, and notice that you are in a massive cavern made up of slightly blue-tinged rock. " +
                    "Massive ridges of sharp rock make up the walls, and you can see what looks to be small sparkling bodies of water placed arbitrarily around them. " +
                    "The soft blue glow seems to be coming from a smattering of glowing blue crystals near the base of the sharp ridges.\n\n" +
                    "You then look down, and see that you almost fell into a massive hole leading into an infinite darkness. If you fell, you might have fell for infinity... who knows?\n\n" +
                    "Being more careful this time, you see that there are two small ledges you might be able to jump across to your left and right.";
        }
        return "You find yourself in a massive blue-tinged cavern, surrounded by massive sharp ridges and softly luminescent crystals. It's quite a beautiful sight.\n\n" +
                "Below you is a massive abyss... who knows where it leads? To your left and right are two small ledges you should be able to jump across.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        return new String[]{"Move towards the ledge on the left", "Move towards the ledge on the right", "Return to the passage"};
    }
    @Override
    public void perform(String option) {
        firstTime = false;
        switch (option) {
            case "Move towards the ledge on the left":
                AdvGame.setSituation(Door_E.getInstance());
                break;
            case "Move towards the ledge on the right":
                break;
            case "Return to the generator":
                AdvGame.setSituation(Passage_E.getInstance());
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}


package org.sherwoodhs.situation.BoilerRoom.Abyss;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.BoilerRoom.Generator.Passage_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class Door_E implements Situation {
    private boolean doorIsOpen = false;
    private static Situation situation = new Door_E();
    @Override
    public String getTitle() {
        return "???";
    }
    @Override
    public String getDescription() {
        return "You carefully climb across a small ridge, and you find in front of you an extremely ornate door. " +
                "The door's border is encrusted with softly glowing yellow and blue crystals. " +
                "The door itself is made out of a mysterious swirled gold metal. There are also carvings of... something. You can't quite make out what they are. " +
                "The shapes in the carvings are very abstract, and staring at them gives you a headache.\n\n" +
                "However in all honesty, it's a very beautiful door.\n\n" +
                "You take another look around the door, but there doesn't seem to be any other places you can travel towards.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        if (doorIsOpen) {
            return new String[]{"Close the door", "Return to the passage"};
        } else {
            return new String[]{"Open the door", "Return to the passage"};
        }
    }
    @Override
    public void perform(String option) {
        switch (option) {
            case "Close the door":
                doorIsOpen = false;
                break;
            case "Open the door":
                doorIsOpen = true;
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


package org.sherwoodhs.situation.BoilerRoom.Abyss.Surface;

import org.sherwoodhs.AdvGame;
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
        if (doorIsOpen) {
            return "You carefully climb across a small ridge, and you find in front of you an extremely ornate door embedded into the blue-tinged rock. Where does it lead? Why is it here?\n\n" +
                    "The door's border is encrusted with softly glowing yellow and blue crystals... the facets of the gems are cut at extremely unconventional angles. " +
                    "The door itself is made out of a mysterious swirled gold metal. There are also carvings of... something. You can't quite make out what they are. " +
                    "The shapes in the carvings are very abstract, and staring at them gives you a headache. On the other hand, there is a polished wooden handle that you could use to open the door.\n\n" +
                    "In all honesty, it's a very beautiful door.\n\n" +
                    "You take another look around the door, but there doesn't seem to be any other places you can travel towards. The door is ajar.";
        } else {
            return "You carefully climb across a small ridge, and you find in front of you an extremely ornate door embedded into the blue-tinged rock. Where does it lead? Why is it here?\n\n" +
                    "The door's border is encrusted with softly glowing yellow and blue crystals... the facets of the gems are cut at extremely unconventional angles. " +
                    "The door itself is made out of a mysterious swirled gold metal. There are also carvings of... something. You can't quite make out what they are. " +
                    "The shapes in the carvings are very abstract, and staring at them gives you a headache. On the other hand, there is a polished wooden handle that you could use to open the door.\n\n" +
                    "In all honesty, it's a very beautiful door.\n\n" +
                    "You take another look around the door, but there doesn't seem to be any other places you can travel towards. The door is closed.";
        }
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        if (doorIsOpen) {
            return new String[]{"Close the door", "Return to the outcropping"};
        } else {
            return new String[]{"Open the door", "Return to the outcropping"};
        }
    }
    @Override
    public void perform(String option) {
        switch (option) {
            case "Close the door":
                doorIsOpen = false;
                AdvGame.clearFrame(
                        "You close the door, and it closes with a resounding thud.",
                        new String[]{"Open the door", "Return to the outcropping"}
                );
                break;
            case "Open the door":
                doorIsOpen = true;
                AdvGame.clearFrame(
                        "You open the door, and you can see only darkness inside.",
                        new String[]{"Close the door", "Enter", "Return to the outcropping"}
                );
                break;
            case "Enter":
                AdvGame.clearFrame("You try go inside, but a sudden migraine shoots through your head. It might be a good idea not to enter.");
                break;
            case "Return to the outcropping":
                AdvGame.setSituation(Outcropping_E.getInstance());
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}


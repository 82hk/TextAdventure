package org.sherwoodhs.situation.BoilerRoom.Abyss.Surface;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;

public class Door_E implements Situation {
    private boolean doorIsOpen = false;
    private boolean dented = false;
    private static Situation situation = new Door_E();
    @Override
    public String getTitle() {
        if (World.discoveredAbyssInfo) {
            return "The Surface";
        }
        return "???";
    }
    @Override
    public String getDescription() {
        if (doorIsOpen) {
            if (dented) {
                return "You carefully climb across a small ridge, and you find in front of you an extremely ornate door embedded into the blue-tinged rock.\n\n" +
                        "The door's border is encrusted with softly glowing yellow and blue crystals... the facets of the gems are cut at extremely unconventional angles. " +
                        "The door itself is made out of a mysterious swirled gold metal. There are also carvings of... something. You can't quite make out what they are. It doesn't help that you've dented it.\n\n" +
                        "The shapes in the carvings are very abstract, and staring at them gives you a headache. On the other hand, there is a polished wooden handle that you could use to open the door.\n\n" +
                        "In all honesty, it's a very beautiful door.\n\n" +
                        "You take another look around the door, but there doesn't seem to be any other places you can travel towards. The door is ajar, and leads into darkness.";
            }
            return "You carefully climb across a small ridge, and you find in front of you an extremely ornate door embedded into the blue-tinged rock. Where does it lead? Why is it here?\n\n" +
                    "The door's border is encrusted with softly glowing yellow and blue crystals... the facets of the gems are cut at extremely unconventional angles. " +
                    "The door itself is made out of a mysterious swirled gold metal. There are also carvings of... something. You can't quite make out what they are. " +
                    "The shapes in the carvings are very abstract, and staring at them gives you a headache. On the other hand, there is a polished wooden handle that you could use to open the door.\n\n" +
                    "In all honesty, it's a very beautiful door.\n\n" +
                    "You take another look around the door, but there doesn't seem to be any other places you can travel towards. The door is ajar, and leads into darkness.";
        } else {
            if (dented) {
                return "You carefully climb across a small ridge, and you find in front of you an extremely ornate door embedded into the blue-tinged rock.\n\n" +
                        "The door's border is encrusted with softly glowing yellow and blue crystals... the facets of the gems are cut at extremely unconventional angles. " +
                        "The door itself is made out of a mysterious swirled gold metal. There are also carvings of... something. You can't quite make out what they are. It doesn't help that you've dented it.\n\n" +
                        "The shapes in the carvings are very abstract, and staring at them gives you a headache. On the other hand, there is a polished wooden handle that you could use to open the door.\n\n" +
                        "In all honesty, it's a very beautiful door.\n\n" +
                        "You take another look around the door, but there doesn't seem to be any other places you can travel towards. The door is closed.";
            }
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
            if (inventoryPanel.containsItem("A moderately polished pickaxe") && !dented) {
                return new String[]{"Close the door", "Slice the door with the pickaxe", "Enter", "Return to the outcropping"};
            }
            return new String[]{"Close the door", "Enter", "Return to the outcropping"};
        } else {
            if (inventoryPanel.containsItem("A moderately polished pickaxe") && !dented) {
                return new String[]{"Open the door", "Slice the door with the pickaxe", "Return to the outcropping"};
            }
            return new String[]{"Open the door", "Return to the outcropping"};
        }
    }
    @Override
    public void perform(String option) {
        switch (option) {
            case "Close the door":
                doorIsOpen = false;
                AdvGame.clearFrameWithoutSpacing(
                        "You close the door, and it closes with a resounding thud.",
                        new String[]{"Open the door", "Return to the outcropping"}
                );
                break;
            case "Open the door":
                World.changeStateI("Renown", -1);
                World.changeStateI("Time", 2);
                doorIsOpen = true;
                AdvGame.clearFrameWithoutSpacing(
                        "You open the door, and it creaks. You can see only darkness inside. You can sense that you're losing something by wasting your time here...",
                        new String[]{"Close the door", "Enter", "Return to the outcropping"}
                );
                break;
            case "Slice the door with the pickaxe":
                dented = true;
                if (doorIsOpen) {
                    AdvGame.updateFrame(
                            "You swing your trusty pickaxe towards the door. The metal isn't that hard, so you make a sizeable dent in the beautiful gold carvings.\n\n" +
                            "...Nothing happens.",
                            new String[]{"Close the door", "Enter", "Return to the outcropping"}
                    );
                } else {
                    AdvGame.updateFrame(
                            "You swing your trusty pickaxe towards the door. The metal isn't that hard, so you make a sizeable dent in the beautiful gold carvings.\n\n" +
                            "...Nothing happens.",
                            new String[]{"Open the door", "Return to the outcropping"}
                    );
                }
                break;
            case "Enter":
                if (World.getState("Renown") == -100) {
                    AdvGame.setSituation(GildedRoom_E.getInstance());
                } else {
                    AdvGame.clearFrameWithoutSpacing("You try to go inside, but a sudden migraine shoots through your head. It might be a good idea not to enter.");
                }
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


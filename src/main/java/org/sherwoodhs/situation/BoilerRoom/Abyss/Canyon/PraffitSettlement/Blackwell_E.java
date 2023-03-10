package org.sherwoodhs.situation.BoilerRoom.Abyss.Canyon.PraffitSettlement;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.situation.BoilerRoom.Abyss.Surface.LanternRope_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;

public class Blackwell_E implements Situation {
    boolean firstTime = true;
    boolean inspectedBars = false;
    boolean clickedContinue = false;
    boolean activatedRock = false;
    private static Situation situation = new Blackwell_E();
    @Override
    public String getTitle() {
        return "Blackwell Prison";
    }
    @Override
    public String getDescription() {
        if (firstTime) {
            return "You enter the ruins of Blackwell Prison through the main entrance. The ash covering the ground is picked up by a weak breeze, causing dust to fly into your face. " +
                    "YOu wipe your now burning eyes, and look around the room you just entered. It's a two-storied building; the walls are made up of a sequence of jail cells, and there are tables on the ground, presumably a cafeteria. However, the stairs leading up are long gone.\n\n" +
                    "You walk up to one of the cell doors, and notice that the bars are made of a hard and cold black metal.";
        }
        return "You enter the ruins of Blackwell Prison through the main entrance. The only light source is a flickering light bulb on the ceiling. " +
                "You are in a two-storied building; the walls are made up of a sequence of jail cells, and there are tables on the ground, presumably a cafeteria. However, the stairs leading up are long gone.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        return new String[]{"Inspect the bars further", "Leave"};
    }
    @Override
    public void perform(String option) {
        firstTime = false;
        switch (option) {
            case "Inspect the bars further":
                inspectedBars = true;
                AdvGame.clearFrameWithoutSpacing(
                        "You take a closer look at the bars. As you do so, your hand brushes on some kind of indentation. Suddenly, the prison begins to glow with an eerie red light. You seem to have activated some kind of mechanism.\n\n" +
                        "Then, the lights completely shut off.\n\nYou are in pitch black darkness. As the darkness envelops you, your heart rate begins rising. You can hear some kind of clawing noise in the distance... and it's growing louder.\n\n" +
                                "You quickly feel around the ground to see if there's anything you can hold. You feel a small but heavy rock, a small mound of ash, and a hard piece of metal that seems to be rectangular.",
                        new String[]{"Pick up the rock", "Pick up the ash", "Pick up the piece of metal"}
                );
                break;
            case "Pick up the rock":
                inventoryPanel.addToInventory("A small but heavy rock");
                AdvGame.clearFrameWithoutSpacing(
                       "You grab the small rock. It's way heavier than you thought. The rock tapers to a relatively sharp point, making it an adequate weapon. The rock also feels a little chalky, like you're able to use it as flint.\n\n" +
                               "The clawing noise grows louder and louder. A bead of sweat rolls down your back as you wait, drowned in your fear.",
                       new String[]{"Strike the rock on the ground", "Wait in the darkness"}
                );
                break;
            case "Strike the rock on the ground":
                activatedRock = true;
                inventoryPanel.removeFromInventory("A small but heavy rock");
                AdvGame.clearFrameWithoutSpacing(
                       "You strike the rock on the ground with a swift swing. The clawing noise grows even louder, like whatever it is just in front of you...\n\n" + 
                    "The rock produces a stream of vibrant blue sparks. You try again, and the rock catches on fire... a vibrant blue fire. In shock, you nearly drop the rock, but the fire doesn't burn you. It feels a little ticklish instead.\n" + 
                    "You are able to see around you just a bit better. The outlines of the cells and tables are visible with your rock. Even though the volume of the clawing noise hasn't stopped, there's nothing in front of you...",
                       new String[]{"Wait in the darkness"}
                );
                break;
            case "Pick up the ash":
                AdvGame.clearFrameWithoutSpacing(
                        "You try and grab the mound of ash, but the dust slips through your fingers. Useless.\n\n" +
                                "You are left defenseless as the clawing noise grows louder and louder. There's no more time to try and grab anything else. " +
                                "A bead of sweat rolls down your back as you wait, drowned in your fear.",
                        new String[]{"Wait in the darkness"}
                );
                break;
            case "Pick up the piece of metal":
                inventoryPanel.addToInventory("A rectangular metal piece");
                AdvGame.clearFrameWithoutSpacing(
                        "You grab the piece of metal. It feels rough, like it's rusty. It might deal more damage to whatever is searching for you in the darkness...\n\n" + 
                    "The clawing noise grows louder and louder. A bead of sweat rolls down your back as you wait, drowned in your fear.",
                        new String[]{"Wait in the darkness"}
                );
                break;
            case "Wait in the darkness":
                if (inventoryPanel.containsItem("A small but heavy rock") {
                    AdvGame.clearFrameWithoutSpacing(
                        "The clawing noise grows louder and louder. You cover your ears...\n\n" + 
                        "The eerie red light returns. The clawing noise has disappeared. You look around, and you notice a stone pillar that has appeared in the center of the room. Was that the source of the clawing noise?",
                        new String[]{"Inspect the pillar"});
                } else if (inventoryPanel.containsItem("A rectangular metal piece") {
                    inventoryPanel.removeFromInventory("A rectangular metal piece");
                    AdvGame.clearFrameWithoutSpacing(
                        "The clawing noise grows louder and louder. You cover your ears and drop the piece of metal...\n\n" + 
                        "The eerie red light returns. The clawing noise has disappeared. You look around, and you notice a stone pillar that has appeared in the center of the room. Was that the source of the clawing noise?",
                        new String[]{"Inspect the pillar"});
                } else if (activatedRock) {
                    inventoryPanel.addToInventory("A small but heavy rock");
                    AdvGame.clearFrameWithoutSpacing(
                        "The clawing noise grows louder and louder. You cover your ears...\n\n" + 
                        "The eerie red light returns. The clawing noise has disappeared. You look around, and you notice a stone pillar that has appeared in the center of the room. Was that the source of the clawing noise?\n\n" + 
                        "You notice that the rock has turned off... you wonder if the fire produced is light-sensitive. You place the rock in your pocket.",
                        new String[]{"Inspect the pillar"});
                } else {
                    AdvGame.clearFrameWithoutSpacing(
                        "The clawing noise grows louder and louder. You cover your ears...\n\n" + 
                        "The eerie red light returns. The clawing noise has disappeared. You look around, and you notice a stone pillar that has appeared in the center of the room. Was that the source of the clawing noise?",
                        new String[]{"Inspect the pillar"});
                }
                break;
            case "Inspect the pillar":
                AdvGame.clearFrameWithoutSpacing(
                        "You take a closer look at the pillar. You notice that there is a surprisingly modern interface present on the screen. You can't really comprehend what the meaning of it is... the interface reads:\n\n" +
                        "",
                        new String[]{"Inspect the pillar"});
                break;
            case "Leave":
                AdvGame.setSituation(BlackwellEntrance_E.getInstance());
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}

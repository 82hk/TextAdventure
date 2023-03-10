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
                       "You grab the small rock. It's way heavier than you thought. The rock tapers to a relatively sharp point, making it an adequate weapon.\n\n" +
                               "The clawing noise grows louder and louder. A bead of sweat rolls down your back as you wait, drowned in your fear.",
                       new String[]{}
                );
                break;
            case "Pick up the ash":
                AdvGame.clearFrameWithoutSpacing(
                        "You try and grab the mound of ash, but the dust slips through your fingers. Useless.\n\n" +
                                "You are left defenseless as the clawing noise grows louder and louder. There's no more time to try and grab anything else. " +
                                "A bead of sweat rolls down your back as you wait, drowned in your fear.",
                        new String[]{}
                );
                break;
            case "Pick up the piece of metal":
                inventoryPanel.addToInventory("A rectangular metal piece");
                AdvGame.clearFrameWithoutSpacing(
                        "You grab the small rock. It's way heavier than you thought. The rock tapers to a relatively sharp point, making it an adequate weapon.\n\n" +
                                "The clawing noise grows louder and louder. A bead of sweat rolls down your back as you wait, drowned in your fear.",
                        new String[]{}
                );
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

package org.sherwoodhs.situation.BoilerRoom.Generator;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.location.BoilerRoom;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.situation.BoilerRoom.BoilerRoom_1E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import java.util.ArrayList;

import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;

public class Generator_E implements Situation {
    private boolean firstTime = true;
    private boolean clickedContinue = false;
    private boolean inspectedGenerator = false;
    private boolean inspectedRedLight = false;
    private boolean inspectedPanel = false;
    private boolean openedGenerator = false;
    private static Situation situation = new Generator_E();
    Location location = BoilerRoom.getInstance();
    private Generator_E() {
        World.setStateS("Location", location.getName());
    }
    @Override
    public String getTitle() {
        return "The Boiler Room";
    }
    @Override
    public String getDescription() {
        if (firstTime) {
            return "After climbing across some pipes, you find that you are in front of a massive vibrating green container. It's extremely loud.\n\n" +
                    "You strain your eyes and see that in faded paint, it is the IKEA's \"generator\". " +
                    "You then turn, seeing that the red light you saw before was actually a flashing light on the generator's side. It's as large as your head.\n\n" +
                    "You listen for any other people that could be near, but your attempts are drowned out by the generator's sound.";
        }
        if (openedGenerator) {
            if (clickedContinue) {
                clickedContinue = false;
                return "As you wipe condensation off your face, you stare into the passage you uncovered. It leads into an unfathomable darkness.";
            }
            return "You adeptly scale a stack of pipes, and the green generator comes into your view. The vibrations almost feel comforting... you've gotten used to the eerie red light, now that it has stopped flashing.\n\n" +
                    "As you wipe steam condensation off your face, you stare into the passage you uncovered. It leads into an unfathomable darkness.";
        }
        if (inspectedGenerator) {
            if (clickedContinue) {
                clickedContinue = false;
                return "The red light eerily illuminates the steam around you. " +
                        "You stand in front of the generator next to the metal sheet you pried off the generator, " +
                        "and stare curiously at the small panel you uncovered under it.";
            }
            return "After climbing around some pipes, the massive generator comes into view. The red light eerily illuminates the steam around you.\n\n" +
                    "As you stand in front of the generator next to the metal sheet you pried off the generator, you look at the small panel you uncovered under it.";
        }
        return "You climb for a bit across some pipes, and take in the view in front of you. " +
                "The gigantic generator almost seems ethereal. The red light illuminates the white steam around it, which makes you feel a bit uneasy. " +
                "Not to mention, the generator is so loud, you won't be able to detect if any people are near you...";

    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        ArrayList<String> options = new ArrayList<>();
        if (openedGenerator) {
            options.add("Enter the passage");
        } else {
            if (inspectedGenerator) {
                if (inspectedPanel) {
                    if (inventoryPanel.containsItem("A shard of a rusty pipe")) {
                        options.add("Prick your finger");
                    }
                    // people can re-inspect the panel if needed
                    options.add("Inspect the panel again");
                } else {
                    options.add("Inspect the panel");
                }
            } else {
                options.add("Inspect the generator");
            }
            // the option to inspect the red light will disappear once the generator has opened
            if (!inspectedRedLight) {
                options.add("Inspect the red light");
            }
        }
        options.add("Leave");
        return options.toArray(new String[0]);
    }
    @Override
    public void perform(String option) {
        firstTime = false;
        switch (option) {
            case "Continue":
                clickedContinue = true;
                AdvGame.setSituation(getInstance());
                break;
            case "Inspect the generator":
                inspectedGenerator = true;
                AdvGame.updateFrame(
                        "You take a closer look at the generator, and you notice a loose metal panel to the right of the flashing red light.\n\n" +
                                "It looks distinct from the dark green metal surrounding it. You slowly pry it off, and you discover a small panel with a blank screen under it.",
                        new String[]{"Continue"});
                break;
            case "Inspect the red light":
                inspectedRedLight = true;
                AdvGame.setSituation(InspectRedLight_E.getInstance());
                break;
            case "Inspect the panel":
                inspectedPanel = true;
                AdvGame.updateFrame(
                            "You place your hand on the panel, to see if it activates anything. As you feel the panel, you notice that panel is slightly textured, as if it's meant to absorb something...\n\n" +
                                    "Suddenly to your surprise, the blank screen flashes on, illuminating your face with a dull green glow. " +
                                    "The screen displays one ominous sentence: \"To descend into the depths, one must sacrifice a sliver of precious life.\"\n\n" +
                                    "It doesn't quite make sense to you. Is this device really a generator? Or is it something more sinister?",
                        new String[]{"Continue"});
                break;
            case "Inspect the panel again":
                AdvGame.updateFrame(
                        "You place your hand on the panel again, and the blank screen flashes on, illuminating your face with a dull green glow. " +
                                "The screen displays one ominous sentence: \"To descend into the depths, one must sacrifice a sliver of precious life.\"",
                        new String[]{"Continue"});
                break;
            case "Prick your finger":
                openedGenerator = true;
                inventoryPanel.removeFromInventory("A shard of a rusty pipe");
                AdvGame.updateFrame(
                        "You come to the conclusion that the panel might be able to detect liquid. You pull out the pipe shard you collected earlier, and lightly jab at your finger. " +
                                "A small bead of dark blood oozes out from the small cut you made, and you place your finger on the panel. As you pull it away, you see the blood quickly disappear into the panel.\n\n" +
                                "The screen flashes a bright green and a quiet grinding sound begins to emanate from the generator. As the grinding sound grows louder and louder, you notice a small passage opening up on the side of the generator. " +
                                "Looking at the red light that was flashing before, you notice that it has stopped flashing. Perhaps the passage is a vent, and the generator was telling you to open it?\n\n" +
                                "During your observations, you drop the shard of pipe on the ground... thanks to the darkness, you likely won't be able to find it again...\n\n" +
                                "You then look back at the passage, and you get an odd feeling... like a dull headache. You think again. Maybe it wasn't a generator after all.",
                        new String[]{"Continue"});
                break;
            case "Enter the passage":
                AdvGame.setSituation(Passage_E.getInstance());
                break;
            case "Leave":
                AdvGame.setSituation(BoilerRoom_1E.getInstance());
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}

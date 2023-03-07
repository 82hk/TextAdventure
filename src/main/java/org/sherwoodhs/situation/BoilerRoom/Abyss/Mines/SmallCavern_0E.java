package org.sherwoodhs.situation.BoilerRoom.Abyss.Mines;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.BoilerRoom.Abyss.Surface.LanternRope_E;
import org.sherwoodhs.situation.BoilerRoom.Generator.Passage_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import java.util.ArrayList;

import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;

public class SmallCavern_0E implements Situation {
    private boolean firstTime = true;
    private boolean clickedContinue = false;
    private boolean collectedPickaxe = false;
    private boolean inspectedCart = false, inspectedRails = false, inspectedWalls = false;
    private boolean openedCrack = false;
    private boolean cameFromPassage = false;
    private static Situation situation = new SmallCavern_0E();
    @Override
    public String getTitle() {
        return "???";
    }
    @Override
    public String getDescription() {
        if (firstTime) {
            return "Carefully, you make your way down the rope. It’s much longer than you initially thought… you never actually checked where the rope led. " +
                    "It’s much too late now; gravity is pulling you down farther and farther. " +
                    "After what seems like a millennia, you finally land in a small cavern. It seems different here; the stone is darker. " +
                    "It’s more of a navy tint rather than a soft blue. " +
                    "You inspect the cavern more and you find some broken rusty rails on the ground, and an upturned and battered metal cart. " +
                    "There’s also a small pickaxe propped up next to the metal cart.\n\n" +
                    "It’s the first sign of civilization you’ve seen in a while. You think to yourself, perhaps there are people down here?\n\n" +
                    "There is a small passage that leads towards the front, probably towards another cavern like this one.";
        }
        if (cameFromPassage) {
            cameFromPassage = false;
            return "You emerge from the passageway you uncovered. The rope leading up to the surface is in front of you.";
        }
        if (openedCrack) {
            if (clickedContinue) {
                clickedContinue = false;
                return "As you observe the small navy-tinted cavern, you marvel at your skill in discovering the passage behind the cracks in the rock.";
            }
            return "You carefully make your way down the rope. Landing in the small navy-tinted cavern, you marvel at your skill in discovering the passage behind the cracks in the rock.";
        }
        if (collectedPickaxe && inspectedWalls) {
            return "You observe the small navy-tinted cavern. The cracks you saw in the wall looks back at you.";
        }
        if (collectedPickaxe) {
            if (clickedContinue) {
                clickedContinue = false;
                return "You observe the small navy-tinted cavern. Maybe there's something else you can do here.";
            }
            return "You slowly make your way down the rope. As you land in the small navy-tinted cavern, you wonder if there's anything else you can do here.";
        }
        return "You carefully make your way down the rope. Landing in the small navy-tinted cavern, you can see a small passage that leads towards the front.\n\n" +
                "There is a small pickaxe propped up next to the upturned metal cart you saw before.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        ArrayList<String> options = new ArrayList<>();
        if (openedCrack) {
            options.add("Move forward");
        } else {
            if (!inspectedCart) {
                options.add("Inspect the cart");
            }
            if (!inspectedRails) {
                options.add("Grab one of the rails");
            }
            if (!collectedPickaxe) {
                options.add("Grab the pickaxe");
            }
            if (!inspectedWalls) {
                options.add("Inspect the walls");
            }
            if (collectedPickaxe && inspectedWalls) {
                options.add("Break open the crack with the pickaxe");
            }
        }
        options.add("Go back up the rope");
        return options.toArray(new String[0]);
    }
    @Override
    public void perform(String option) {
        firstTime = false;
        switch (option) {
            case "Go back up the rope":
                AdvGame.updateFrame("You climb back onto the thin rope, and make your way up. It’s a lot more tiring going up than down, in your opinion.",
                        new String[]{"Keep going"});
                break;
            case "Keep going":
                AdvGame.setSituation(LanternRope_E.getInstance());
                break;
            case "Continue":
                clickedContinue = true;
                AdvGame.setSituation(getInstance());
                break;
            case "Grab one of the rails":
                inspectedRails = true;
                AdvGame.updateFrame(
                        "You hold one of the rails under your foot, and pull upwards with all of your strength.\n\n" +
                                "However, the metal doesn’t budge. The rails must be bolted to the ground.",
                        new String[]{"Continue"});
                break;
            case "Climb the rope ladder":
                AdvGame.setSituation(Passage_E.getInstance());
                break;
            case "Inspect the walls":
                inspectedWalls = true;
                String text =
                        "You sweep the perimeter of the cavern. Through your findings, you find a small crack in one of the walls. " +
                        "You try to peek through to see what’s behind it, but you don’t see anything other than a soft blue glow, akin to the lantern you saw at the top of the rope. " +
                                "You try and push your fingers through, but the rock doesn’t budge.";
                if (!collectedPickaxe) {
                    text += "\n\nYou might need some kind of strong tool to even have a chance at seeing what’s behind.";
                }
                AdvGame.updateFrame(
                        text,
                        new String[]{"Continue"});
                break;
            case "Grab the pickaxe":
                collectedPickaxe = true;
                inventoryPanel.addToInventory("A moderately polished pickaxe");
                AdvGame.updateFrame(
                        "You grab the pickaxe, and inspect it. The metal is quite rusty, but polishing it with your sleeve returns some glint back to the metal. " +
                                "The metal itself doesn’t seem that special though. " +
                                "However, the wooden handle is quite well crafted, it’s polished and there only seems to be a couple of dents.\n\n" +
                                "How long was this pickaxe laying here for? Nevertheless, you decide to keep it.",
                        new String[]{"Continue"});
                break;
            case "Break open the crack with the pickaxe":
                inventoryPanel.removeFromInventory("A moderately polished pickaxe");
                openedCrack = true;
                AdvGame.updateFrame(
                        "With an adept swing of your pickaxe, you shatter the rock near the crack. " +
                                "A passage is visible to your front, dimly illuminated by a flickering blue lantern hanging on the ceiling. " +
                                "You marvel at your strength, and you look down at your pickaxe.\n\nTragedy has struck.\n\n" +
                                "The metal blade of the pickaxe has completely snapped off from the wooden handle, rendering it useless. " +
                                "You throw away the stick you’re currently holding, and stare at the passage you just discovered.",
                        new String[]{"Continue"});
                break;
            case "Inspect the cart":
                inspectedCart = true;
                AdvGame.updateFrame(
                        "You flip the cart, and it flips over with a resounding clang. " +
                                "Whatever was inside in the past is now gone, and all that is there is a powdery layer of navy dust.",
                        new String[]{"Continue"});
                break;
            case "Move forward":
                cameFromPassage = true;
                AdvGame.setSituation(SmallCavern_1E.getInstance());
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}


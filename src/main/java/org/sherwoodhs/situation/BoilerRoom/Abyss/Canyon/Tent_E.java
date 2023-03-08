package org.sherwoodhs.situation.BoilerRoom.Abyss.Canyon;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;

public class Tent_E implements Situation {
    private static Situation situation = new Tent_E();
    boolean clickedContinue = false;
    private boolean inspectedWrappers = false;
    @Override
    public String getTitle() {
        if (World.discoveredAbyssInfo) {
            return "Canyon of Ashes";
        }
        return "???";
    }
    @Override
    public String getDescription() {
        if (clickedContinue) {
            clickedContinue = false;
            return "You look around the dusty old tent. Who lived here? Where are they now?";
        }
        if (inventoryPanel.containsItem("A small journal")) {
            return "You walk towards the mound of rotten fabric. " +
                    "There isn't anything notable in the tent, other than some ash-dusted wrappers on the ground. ";
        }
        return "As you walk towards the mound of rotten fabric, " +
                "you realize that it’s not as decrepit as you initially thought. " +
                "It seems to be some kind of tent… a thin sheet of old fabric is " +
                "held up by a rotting wooden pole, and locked into place by a " +
                "couple of metal bolts hammered into the rock. " +
                "It must be more porous than it looks. " +
                "It doesn’t look like anyone has lived in the tent for a while…\n\n" +
                "You duck inside, and you find one leather-bound journal inside. " +
                "There doesn’t seem to be anything else notable in the tent, " +
                "save for some ash-dusted wrappers on the ground.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        if (inventoryPanel.containsItem("A small journal")) {
            if (inspectedWrappers) {
                return new String[]{"Inspect the wrappers", "Return to the lake"};
            }
            return new String[]{"Return to the lake"};
        }
        if (inspectedWrappers) {
            return new String[]{"Read the journal", "Return to the lake"};
        }
        return new String[]{"Read the journal", "Inspect the wrappers", "Return to the lake"};
    }
    @Override
    public void perform(String option) {
        switch (option) {
            case "Inspect the wrappers":
                inspectedWrappers = true;
                AdvGame.updateFrame(
                    "You try to pick up one of the wrappers, but they crumble into fine dust as you do so.",
                    new String[]{"Continue"}
                );
                break;
            case "Read the journal":
                AdvGame.clearFrameWithoutSpacing(
                        "You crack open the journal, and you notice that the paper is stiff. " +
                                "It must have been a while since anyone has written anything in it. " +
                                "There are only a couple of pages in the journal that have writing on it, " +
                                "which are the first four pages.",
                        new String[]{"Read the first page", "Read the second page", "Read the third page", "Read the fourth page"}
                );
                break;
            case "Read the first page":
                AdvGame.clearFrameWithoutSpacing(
                        "I’ve found it. I’ve found what I’ve been searching for ten years. " +
                                "There is indeed a secret settlement down in these caves... previously named Praffit.\n\n" +
                                "After finding those hidden documents… reports of a sealed mine filled with mysterious ore… " +
                                "discovering that there was some project that they were working on… I’ve done it.\n\n" +
                                "Sadly, the remains of Praffit are now crumbling, making it difficult to truly explore what lies within it. " +
                                "I would assume that the ruins are approximately five hundred years old, but they may be older. " +
                                "The settlement was built with a hodge-podge of bricks the inhabitants must have built with the weak stone " +
                                "found in this area… well, used to be built. " +
                                "Most of the structures have now crumbled into dust at this point. ",
                        new String[]{"Read the second page", "Read the third page", "Read the fourth page", "Stop reading"}
                );
                break;
            case "Read the second page":
                World.discoveredAbyssInfo = true;
                AdvGame.clearFrameWithoutSpacing(
                        "I’ve learned many things from my mini excursions into the ruins of Praffit. They’ve developed their own terminology for what this place is. I’ll just write this down for future reference:\n" +
                                "This massive cave system is the “abyss”. It is essentially one massive pit that is surrounded by smaller cave systems… and as far as I know, stretches down to the bottom of the earth.\n" +
                                "They have designated distinct areas of the abyss as “layers”. Seemingly, the inhabitants of the settlement have discovered four distinct layers. \n" +
                                "“They” is referring to the inhabitants of Praffit.",
                        new String[]{"Continue reading the second page"}
                );
                break;
            case "Continue reading the second page":
                AdvGame.clearFrameWithoutSpacing(
                        "The topmost layer is a forest, a forest that is both upside down and the right way up. It is covered with abandoned returns, likely from this IKEA. It seems that the inhabitants of Praffit went up often to get lumber, fruits, and vegetables, until they descended farther into the abyss.\n\n" +
                                "The next layer was known as “the surface”. I entered this layer by swimming through an underground river, and surfacing in a small lake… however there may be more entrances. I didn’t check. The surface is made up of light blue rock, and surrounded by massive sharp ridges and small lakes. " +
                                "The entrance to the abyss (at least, the massive pit), is located on this layer.\n\n" +
                                "As deemed the “Abyss Mines” in the past, this next layer is mostly the product of human intervention. However, the stone in this area does become much darker than the stone found on the surface. There is an abundance of a mysterious copper-like ore in this area, " +
                                "which seemed to have been used for the secret project the inhabitants of the settlement were creating.\n\n" +
                                "The layer where Praffit is located (and currently where I am) was known as the “Canyon of Ashes”, due to its abundance of volcanic rock formations, and ash. I believe that the settlement they built down here was meant to be temporary, and they moved onto what they stated was the “bottommost layer”.\n\n" +
                                "The bottommost layer is still a mystery to me… only accessible through a massive hole with completely vertical walls. It seems that they hosted excursions into the unknown but never created actual reports, like they were in a rush. " +
                                "There seemed to be some kind of reaction from ascending from this layer as well, according to my analysis of the reports found in the abandoned settlement. Due to this, it seemed that the inhabitants of Praffit moved down to this layer and stayed there, including their project. " +
                                "There must be more information down there.\n\n" +
                                "On that note, I don’t know if there are still people alive in the depths… how could they get food or water if they were unable to ascend? " +
                                "I assume whatever rations they had brought from the IKEA would have run out by then…",
                        new String[]{"Read the first page", "Read the third page", "Read the fourth page", "Stop reading"}
                );
                break;
            case "Read the third page":
                AdvGame.updateFrame(
                        "There are some scribbles on the third page, but you can’t make out any letters. It doesn’t help that the ink on the page has bled over time.",
                        new String[]{"Read the first page", "Read the second page", "Read the fourth page", "Stop reading"}
                );
                break;
            case "Read the fourth page":
                World.discoveredAbyssInfo = true;
                AdvGame.updateFrame(
                        "On the fourth page, you find a magnificent hand-drawn map of the abyss. The map looks shakily drawn, like it's been copied from something else... It's basically vertical, and massive.\n\n" + 
                        "The highest layer of the abyss is a massive forest, which you see that is actually a gargantuan cavern, hence the upside down trees.\n" +
                        "The layer you entered the abyss in with the soft blue rocks and the ridges seems to be the surface. The massive pit you saw at the outcropping starts at the surface.\n" +
                        "The mines you explored before, you see was simply called the 'abyss mines'. The copper-like ore, according to the map, can be discovered anywhere on that layer.\n" +
                        "The current ashy layer you stand in was known as the 'Canyon of Ashes'. The owner of the journal circled a small spire to the right, which seems to be an old settlement.\n" +
                        "There is a large pit with completely vertical walls stretching down into the bottom layer, which is not completely mapped out. The bottom layer fades into an unknown black.",
                        new String[]{"Read the first page", "Read the second page", "Read the third page", "Stop reading"}
                );
                break;
            case "Stop reading":
                AdvGame.clearFrameWithoutSpacing(
                        "You look up from your reading session. You make a note to yourself. When you leave the tent, you'll take the journal with you.",
                        new String[]{"Continue"}
                );
                break;
            case "Continue":
                clickedContinue = true;
                AdvGame.setSituation(getInstance());
                break;
            case "Return to the lake":
                inventoryPanel.addToInventory("A small journal");
                AdvGame.setSituation(Aquifer_E.getInstance());
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}

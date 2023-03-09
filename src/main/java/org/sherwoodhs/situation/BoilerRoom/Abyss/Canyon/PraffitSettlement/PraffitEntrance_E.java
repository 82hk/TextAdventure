package org.sherwoodhs.situation.BoilerRoom.Abyss.Canyon.PraffitSettlement;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.situation.BoilerRoom.Abyss.Canyon.Crevasse_1E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class PraffitEntrance_E implements Situation {
    private static Situation situation = new PraffitEntrance_E();
    private boolean firstTime = true;
    private boolean clickedContinue = false;
    @Override
    public String getTitle() {
        if (World.discoveredAbyssInfo) {
            return "Praffit";
        }
        return "???";
    }
    @Override
    public String getDescription() {
        if (firstTime) {
            return "In front of you is a massive settlement built around a large spire of rock in the center. The houses are all in various states of disrepair. " + 
                "Many of the houses look to be built with some kind of gray brick, but many have since crumbled into dust. Some of the streets are illuminated with flickering yellow lanterns. " +
                "How have they have managed to stay lit? The houses are so old, they are just ghosts of their previous selves...\n\n" +
                "There are five streets you can travel into, the rest are all blocked by debris.";
        }
        if (clickedContinue) {
            return "You return from the street. The now ruined settlement of Praffit looms in front of you. There are five streets you can travel into.";
        }
        return "In front of you is a massive settlement built around a large spire of rock in the center. The houses are all in various states of disrepair." + 
            "There are five streets you can travel into... the rest are all blocked by debris.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        return new String[]{"Take the first street", "Take the second street", "Take the third street", "Take the fourth street", "Take the fifth street", "Return"};
    }
    boolean cameFromApothecary = false;
    @Override
    public void perform(String option) {
        firstTime = false;
        switch (option) {
            // first street
            case "Take the first street":
                AdvGame.updateFrame(
                        "You walk down the first street. As you observe the ruined houses, you reach a dead end. " + 
                        "All of the houses on this street don't have any walls anymore... and it doesn't look like there's anything interesting here.",
                        new String[]{"Return to the intersection"}
                );
                break;
                // second street - apothecary
            case "Exit the building":
            case "Take the second street":
                if (cameFromApothecary) {
                    cameFromApothecary = false;
                    AdvGame.updateFrame(
                            "You exit the building. You wonder if there is anything else of note here...",
                            new String[]{"Enter the building again", "Return to the intersection"}
                    );
                } else {
                    AdvGame.updateFrame(
                            "You walk down the second street. In the corner of your eye to the left, you see a relatively intact building, with openings that were likely windows in the past.\n\n" +
                                    "Upon closer inspection, it seems to have been some kind of window display. You drag your hand across the small platform, and your hand becomes covered in vaguely green dust. Herbs, perhaps?",
                            new String[]{"Enter the building", "Return to the intersection"}
                    );
                }
                break;
            case "Enter the building again":
            case "Enter the building":
                cameFromApothecary = true;
                AdvGame.clearFrameWithoutSpacing(
                        "You enter the building, being careful not to disturb the walls. Who knows how stable the structure is?\n\n" +
                                "Inside, you find the remains of a couple of chairs. It smells vaguely like rosemary and fennel... " +
                        "The interior of the building is not that expansive. You come upon a small rotting desk with a document carefully placed on top.",
                        new String[]{"Inspect the document", "Look under the desk", "Exit the building"}
                );
                break;
            case "Stop reading":
                AdvGame.clearFrameWithoutSpacing(
                        "The faint smell of rosemary and fennel seems to grow slightly stronger. Maybe it's just you. In front of you is a small rotting desk with a document carefully placed on top.",
                        new String[]{"Inspect the document", "Look under the desk", "Exit the building"}
                );
                break;
            case "Look under the desk":
                AdvGame.clearFrameWithoutSpacing(
                        "Other than a fine layering of dust and mold, there's nothing under there.",
                        new String[]{"Inspect the document", "Exit the building"}
                );
                break;
            case "Inspect the document":
                AdvGame.clearFrameWithoutSpacing(
                        "Apothecary Report III\n" +
                                "Three men entered the bottommost layer of the abyss approximately five days ago, and recently ascended. Unlike the previous higher layers, there seems to be some kind of condition that afflicts humans when returning from the bottom of the abyss.Two of the men exhibited relatively minor symptoms. However, the other individual remained in the bottommost layer for the longest period of time, and exhibited more major symptoms. Seemingly, there is a correlation between time of exposure and the severity of symptoms exhibited.\n" + "\n" +
                                "Minor symptoms:\n" +
                                "Insomnia\n" +
                                "Hypothermic symptoms\n" +
                                "Minor hallucinations\n" + "\n" +
                                "Major symptoms:\n" +
                                "Major cognitive distortions\n" +
                                "Extreme sensitivity to light and cold temperatures\n" +
                                "Temporary paralysis in legs and arms\n" +
                                "Intense chest and head pain\n\n" +
                                "It is currently unclear whether these symptoms are exhibited by all individuals resulting from ascension. However, considering the state of these individuals, there may be no clear cure other than waiting for the symptoms of ascension to dissipate.",
                        new String[]{"Stop reading", "Exit the building"}
                );
                break;
                // third street
            case "Take the third street":
                System.out.println("You've reached the end of the current explorable part of the abyss!");
                break;
            case "Take the fourth street":
                System.out.println("You've reached the end of the current explorable part of the abyss!");
                break;
            case "Take the fifth street":
                System.out.println("You've reached the end of the current explorable part of the abyss!");
                break;
            case "Return to the intersection":
                clickedContinue = true;
                AdvGame.setSituation(getInstance());
                break;
            case "Return":
                AdvGame.setSituation(Crevasse_1E.getInstance());
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}

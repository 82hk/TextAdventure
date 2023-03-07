package org.sherwoodhs.situation.BoilerRoom.Abyss.Mines;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class CopperCave_E implements Situation {
    private boolean firstTime = true;
    private boolean solvedPuzzle = false;
    private boolean clickedContinue = false;
    private boolean fromPuzzle = false;
    private boolean inspectedWalls = false;
    private int amountOfNoteInspections = 0;
    // index
    private int copper1 = 0, copper2 = 0, copper3 = 0, copper4 = 0;
    private int[] copper1arr = new int[]{1, 4, 2, 5, 8, 3, 15};
    private int[] copper2arr = new int[]{2, 19, 1, 4, 15, 7, 3};
    private int[] copper3arr = new int[]{5, 1, 9, 12, 7, 0, 8};
    private int[] copper4arr = new int[]{7, 12, 5, 1, 3, 9, 13};
    private static Situation situation = new CopperCave_E();
    @Override
    public String getTitle() {
        return "A Cave of Copper-like Ore";
    }
    @Override
    public String getDescription() {
        if (firstTime) {
            return "You enter a beautiful cavern. " +
                    "A blue lantern’s light softly shines onto the orange glints, which upon closer inspection turns out to be some kind of ore embedded in the navy stone. " +
                    "Some of the ore reflects the lantern’s light onto the ground, creating some kind of abstract image.\n\n" +
                    "You decide to call this area the “copper cave” just because it seems quite distinct from the boring navy-tinted stone of the previous cavern.\n\n" +
                    "You look around, and you realize that you are at a dead end. Perhaps there is nowhere to go from here.";
        }
        if (solvedPuzzle) {
            return "You enter the beautiful copper cave. The copper-like ore twinkles at you like stars.\n\n" +
                    "The hole that appeared once you moved around the orientations of the copper ore stares back at you ominously.\n\n" +
                    "The hole leads into an infinite darkness…";
        }
        if (fromPuzzle && clickedContinue) {
            clickedContinue = false;
            fromPuzzle = false;
            return "The orange ore glints at you cheerfully as you pace around the cave. There must be something else you can do.\nYou look again at the ores. Respectively, the ores have [" + copper1arr[copper1] + "] - [" + copper2arr[copper2] + "] - [" + copper3arr[copper3] + "] - [" + copper4arr[copper4] + "] slashes on them.";
        }
        if (amountOfNoteInspections != 0 && clickedContinue) {
            clickedContinue = false;
            return "You think about the note you just read. It seems to just be an instructional poster, but maybe there's something else hidden within it.\n\nYour attention is drawn to the messily drawn brackets around some of the words... it doesn't really match the clean printed text. " + 
                    "You come to the conclusion that the brackets may have been from someone who was not from the time period of the note's printing...";
        }
        if (clickedContinue) {
            clickedContinue = false;
            return "The orange ore glints at you cheerfully as you look around. There must be something you can do.";
        }
        return "You enter the beautiful copper cave. The orange “copper” ore glints at you cheerfully as you pace around the cavern, which is a dead end. " +
                "However, there must be something you can do here… your journey hasn’t ended quite yet.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        if (solvedPuzzle) {
            // special type of note inspection after you've solved everything
            amountOfNoteInspections = 5;
            return new String[]{"Drop down into the hole", "Read the note", "Return to the cavern"};
        }
        if (inspectedWalls) {
            return new String[]{"Read the note", "Inspect the slashed ores", "Return to the cavern"};
        }
        return new String[]{"Inspect the walls", "Return to the cavern"};
    }
    @Override
    public void perform(String option) {
        firstTime = false;
        switch (option) {
            case "Inspect the walls":
                inspectedWalls = true;
                AdvGame.updateFrame(
                        "You walk around the perimeter of the copper cave, and you make a couple of new discoveries.\n\n" +
                                "There is a yellowing note pinned to the wall with a thin metal spike, " +
                                "and on the opposite wall, there are four curiously shaped “copper” ores with slashes in them. You don't see any similar looking slashes in the other pieces of ore around the cave. " +
                                "In order, the copper ores have [1] - [2] - [5] - [7] slashes on them respectively.",
                        new String[]{"Continue"});
                break;
            case "Read the note":
                amountOfNoteInspections++;
                // 5 is a "key", look in getOptions()
                if (amountOfNoteInspections != 5 && amountOfNoteInspections > 3) {
                    amountOfNoteInspections = 3;
                }
                String text = "";
                switch (amountOfNoteInspections) {
                    case 1:
                        text += "You prop the note up with your hand so that it’s facing the light of the lantern. " +
                                "It makes a crackling sound, like it’s been a while since it has been written... printed. The text looks like it's been printed; you'd be very surprised if someone was able to write so geometrically and precise. " +
                                "The corners crumble into dust. It reads:";
                        break;
                    case 2:
                        text += "The way the instructions are written seems a little odd. " +
                                "Perhaps the brackets contain a clue? You take a closer look, being careful not to disturb the note too much, lest it disintegrates. " +
                                "You notice that the brackets don't match the font that the note is printed in... it looks like someone wrote them down in a rush. The note reads:";
                        break;
                    case 3:
                        text += "You think to yourself, maybe you should look at the first letter of each bracketed word. " +
                                "There seems to be some significance… perhaps they correlate with the amount of slashes on the four pieces of ore? " +
                                "The note reads:";
                        break;
                    case 5:
                        text += "The note reads:";
                        break;
                    default:
                        text += "";
                        break;
                }
                AdvGame.updateFrame(
                        text,
                        new String[]{"Continue reading"});
                break;
            case "Continue reading":
                AdvGame.clearFrameWithoutSpacing(
                        "Welcome!\nYou are currently in: Mine 1600-4C\n\n" +
                        "Thank you for your participation in this world-changing, innovative, and impactful project. " +
                        "To aid with [our] efforts, please mine the orange ore that you can find commonly on this layer of the abyss daily, " +
                        "ensuring that you meet the daily quota that was assigned to you at the beginning of the day. " +
                        "[Similar] examples of the ore you must mine can be found in this cave. " +
                        "This ore will begin to regenerate over time, considering its unique properties, " +
                        "so please take [note] of each location on the map that we have given you.\n\n" +
                        "In addition, make sure to stay in areas of the mine you have been assigned to. " +
                        "The naming convention for the mine is as follows:\nDepth, in meters - Branch, Cave\n" +
                        "As of now,\nThe topmost cave is: 780-1A\nThe bottommost cave is: 7900-5L\n\n" +
                                "The areas of the mine that you have been assigned to is stated on the ticket you should have received at the beginning of the day, " +
                                "which is the same ticket that contains your daily ore quota. " +
                                "After completing your mining excursion for the day, " +
                                "please place all of the ore you mined in one of the carts found in these mines, " +
                                "and they will be sent to the settlement below at the end of the day. " +
                                "Please take your ticket down to the settlement [once] the carts have departed, " +
                                "so that we can ensure you have been productive the entire day.\n\n" +
                                "Again, we would like to thank you for your aid and participation! " +
                                "We are excited that you are aiding in the completion of a project that will change the lives of all that live in this IKEA.",
                        new String[]{"Continue"});
                break;
            case "Continue":
                clickedContinue = true;
                AdvGame.setSituation(getInstance());
                break;
            case "Inspect the slashed ores":
                AdvGame.clearFrameWithoutSpacing(
                        "You inspect the ores with the slashes on them. As you saw before, there are just four pieces of ore in the cave with the special slashes. " +
                                "The ore forms some reflections on the ground, making some odd abstract shape. You touch one, and feel it rotate a bit.\n\n" +
                                "After some more inspection, you discover that you can freely spin each piece of ore around. Maybe it's a puzzle of sorts?\n" +
                                "Respectively, the ore pieces each have [" + copper1arr[copper1] + "] - [" + copper2arr[copper2] + "] - [" + copper3arr[copper3] + "] - [" + copper4arr[copper4] + "] slashes.",
                        new String[]{"Spin the first ore", "Spin the second ore", "Spin the third ore", "Spin the fourth ore", "Stop"});
                break;
            case "Keep going":
                AdvGame.clearFrameWithoutSpacing(
                        "Respectively, the ore pieces each have [" + copper1arr[copper1] + "] - [" + copper2arr[copper2] + "] - [" + copper3arr[copper3] + "] - [" + copper4arr[copper4] + "] slashes.",
                        new String[]{"Spin the first ore", "Spin the second ore", "Spin the third ore", "Spin the fourth ore", "Stop"}
                );
                break;
            case "Spin the first ore":
                if (copper1arr[copper1] == 1) {
                    AdvGame.clearFrameWithoutSpacing(
                            "The first ore currently has [" + copper1arr[copper1] + "] slash on it.",
                            new String[]{"Spin the first ore clockwise", "Spin the first ore counterclockwise", "Stop"}
                    );
                } else {
                    AdvGame.clearFrameWithoutSpacing(
                            "The first ore currently has [" + copper1arr[copper1] + "] slashes on it.",
                            new String[]{"Spin the first ore clockwise", "Spin the first ore counterclockwise", "Stop"}
                    );
                }
                break;
            case "Spin the first ore clockwise":
                // is maximum?
                if (copper1 == copper1arr.length - 1) {
                    copper1 = 0;
                } else {
                    copper1++;
                }
                if (isSolved()) {
                    AdvGame.clearFrameWithoutSpacing(
                        "After you spin the first ore, something quietly clicks into place. Perhaps a mechanism of sorts?",
                        new String[]{"Wait in suspense"});
                    break;
                }
                if (copper1arr[copper1] == 1) {
                    AdvGame.updateFrame("You spin the ore around clockwise, and the first ore now has [" + copper1arr[copper1] + "] slash on it.",
                            new String[]{"Keep going", "Stop"});
                } else {
                    AdvGame.updateFrame("You spin the ore around clockwise, and the first ore now has [" + copper1arr[copper1] + "] slashes on it.",
                            new String[]{"Keep going", "Stop"});
                }
                break;
            case "Spin the first ore counterclockwise":
                // is minimum?
                if (copper1 == 0) {
                    copper1 = copper1arr.length - 1;
                } else {
                    copper1--;
                }
                if (isSolved()) {
                    AdvGame.clearFrameWithoutSpacing(
                        "After you spin the first ore, something quietly clicks into place. Perhaps a mechanism of sorts?",
                        new String[]{"Wait in suspense"});
                    break;
                }
                if (copper1arr[copper1] == 1) {
                    AdvGame.updateFrame("You spin the ore around counterclockwise, and the first ore now has [" + copper1arr[copper1] + "] slash on it.",
                            new String[]{"Keep going", "Stop"});
                } else {
                    AdvGame.updateFrame("You spin the ore around counterclockwise, and the first ore now has [" + copper1arr[copper1] + "] slashes on it.",
                            new String[]{"Keep going", "Stop"});
                }
                break;
            case "Spin the second ore":
                if (copper2arr[copper2] == 1) {
                    AdvGame.clearFrameWithoutSpacing(
                            "The second ore currently has [" + copper2arr[copper2] + "] slash on it.",
                            new String[]{"Spin the second ore clockwise", "Spin the second ore counterclockwise", "Stop"}
                    );
                } else {
                    AdvGame.clearFrameWithoutSpacing(
                            "The second ore currently has [" + copper2arr[copper2] + "] slashes on it.",
                            new String[]{"Spin the second ore clockwise", "Spin the second ore counterclockwise", "Stop"}
                    );
                }
                break;
            case "Spin the second ore clockwise":
                // is maximum?
                if (copper2 == copper2arr.length - 1) {
                    copper2 = 0;
                } else {
                    copper2++;
                }
                if (isSolved()) {
                    AdvGame.clearFrameWithoutSpacing(
                        "After you spin the second ore, something quietly clicks into place. Perhaps a mechanism of sorts?",
                        new String[]{"Wait in suspense"});
                    break;
                }
                if (copper2arr[copper2] == 1) {
                    AdvGame.updateFrame("You spin the ore around clockwise, and the second ore now has [" + copper2arr[copper2] + "] slash on it.",
                            new String[]{"Keep going", "Stop"});
                } else {
                    AdvGame.updateFrame("You spin the ore around clockwise, and the second ore now has [" + copper2arr[copper2] + "] slashes on it.",
                            new String[]{"Keep going", "Stop"});
                }
                break;
            case "Spin the second ore counterclockwise":
                // is minimum?
                if (copper2 == 0) {
                    copper2 = copper2arr.length - 1;
                } else {
                    copper2--;
                }
                if (isSolved()) {
                    AdvGame.clearFrameWithoutSpacing(
                        "After you spin the second ore, something quietly clicks into place. Perhaps a mechanism of sorts?",
                        new String[]{"Wait in suspense"});
                    break;
                }
                if (copper2arr[copper2] == 1) {
                    AdvGame.updateFrame("You spin the ore around counterclockwise, and the second ore now has [" + copper2arr[copper2] + "] slash on it.",
                            new String[]{"Keep going", "Stop"});
                } else {
                    AdvGame.updateFrame("You spin the ore around counterclockwise, and the second ore now has [" + copper2arr[copper2] + "] slashes on it.",
                            new String[]{"Keep going", "Stop"});
                }
                break;
            case "Spin the third ore":
                if (copper3arr[copper3] == 1) {
                    AdvGame.clearFrameWithoutSpacing(
                            "The third ore currently has [" + copper3arr[copper3] + "] slash on it.",
                            new String[]{"Spin the third ore clockwise", "Spin the third ore counterclockwise", "Stop"}
                    );
                } else {
                    AdvGame.clearFrameWithoutSpacing(
                            "The third ore currently has [" + copper3arr[copper3] + "] slashes on it.",
                            new String[]{"Spin the third ore clockwise", "Spin the third ore counterclockwise", "Stop"}
                    );
                }
                break;
            case "Spin the third ore clockwise":
                // is maximum?
                if (copper3 == copper3arr.length - 1) {
                    copper3 = 0;
                } else {
                    copper3++;
                }
                if (isSolved()) {
                    AdvGame.clearFrameWithoutSpacing(
                        "After you spin the third ore, something quietly clicks into place. Perhaps a mechanism of sorts?",
                        new String[]{"Wait in suspense"});
                    break;
                }
                if (copper3arr[copper3] == 1) {
                    AdvGame.updateFrame("You spin the ore around clockwise, and the third ore now has [" + copper3arr[copper3] + "] slash on it.",
                            new String[]{"Keep going", "Stop"});
                } else {
                    AdvGame.updateFrame("You spin the ore around clockwise, and the third ore now has [" + copper3arr[copper3] + "] slashes on it.",
                            new String[]{"Keep going", "Stop"});
                }
                break;
            case "Spin the third ore counterclockwise":
                // is minimum?
                if (copper3 == 0) {
                    copper3 = copper3arr.length - 1;
                } else {
                    copper3--;
                }
                if (isSolved()) {
                    AdvGame.clearFrameWithoutSpacing(
                        "After you spin the third ore, something quietly clicks into place. Perhaps a mechanism of sorts?",
                        new String[]{"Wait in suspense"});
                    break;
                }
                if (copper3arr[copper3] == 1) {
                    AdvGame.updateFrame("You spin the ore around counterclockwise, and the third ore now has [" + copper3arr[copper3] + "] slash on it.",
                            new String[]{"Keep going", "Stop"});
                } else {
                    AdvGame.updateFrame("You spin the ore around counterclockwise, and the third ore now has [" + copper3arr[copper3] + "] slashes on it.",
                            new String[]{"Keep going", "Stop"});
                }
                break;
            case "Spin the fourth ore":
                if (copper4arr[copper4] == 1) {
                    AdvGame.clearFrameWithoutSpacing(
                            "The fourth ore currently has [" + copper4arr[copper4] + "] slash on it.",
                            new String[]{"Spin the fourth ore clockwise", "Spin the fourth ore counterclockwise", "Stop"}
                    );
                } else {
                    AdvGame.clearFrameWithoutSpacing(
                            "The fourth ore currently has [" + copper4arr[copper4] + "] slashes on it.",
                            new String[]{"Spin the fourth ore clockwise", "Spin the fourth ore counterclockwise", "Stop"}
                    );
                }
                break;
            case "Spin the fourth ore clockwise":
                // is maximum?
                if (copper4 == copper4arr.length - 1) {
                    copper4 = 0;
                } else {
                    copper4++;
                }
                if (isSolved()) {
                    AdvGame.clearFrameWithoutSpacing(
                        "After you spin the fourth ore, something quietly clicks into place. Perhaps a mechanism of sorts?",
                        new String[]{"Wait in suspense"});
                    break;
                }
                if (copper4arr[copper4] == 1) {
                    AdvGame.updateFrame("You spin the ore around clockwise, and the fourth ore now has [" + copper4arr[copper4] + "] slash on it.",
                            new String[]{"Keep going", "Stop"});
                } else {
                    AdvGame.updateFrame("You spin the ore around clockwise, and the fourth ore now has [" + copper4arr[copper4] + "] slashes on it.",
                            new String[]{"Keep going", "Stop"});
                }
                break;
            case "Spin the fourth ore counterclockwise":
                // is minimum?
                if (copper4 == 0) {
                    copper4 = copper4arr.length - 1;
                } else {
                    copper4--;
                }
                if (isSolved()) {
                    AdvGame.clearFrameWithoutSpacing(
                        "After you spin the fourth ore, something quietly clicks into place. Perhaps a mechanism of sorts?",
                        new String[]{"Wait in suspense"});
                        break;
                }
                if (copper4arr[copper4] == 1) {
                    AdvGame.updateFrame("You spin the ore around counterclockwise, and the fourth ore now has [" + copper4arr[copper4] + "] slash on it.",
                            new String[]{"Keep going", "Stop"});
                } else {
                    AdvGame.updateFrame("You spin the ore around counterclockwise, and the fourth ore now has [" + copper4arr[copper4] + "] slashes on it.",
                            new String[]{"Keep going", "Stop"});
                }
                break;
            case "Wait in suspense":
                AdvGame.updateFrame("You wait for a bit. Suddenly, the reflections of the light made by the ore begin to glow brighter and brighter. " +  
                                    "You shield yourself from the light… and once your eyes readjust, you see that a massive hole has mysteriously opened up in the cave floor.\n\n" + 
                                    "The hole seems to be radiating a kind of eerie chilliness you have never experienced before in these caves… it looks extremely dark in there. " +
                                    "You might be missing the blue lanterns’ light for a while if you go in. " + 
                                    "You’ve come to rely on its dim but reassuring light.",
                                    new String[]{"Drop down into the hole"});
                break;
            case "Drop down into the hole":
                break;
            case "Stop":
                fromPuzzle = true;
                clickedContinue = true;
                AdvGame.setSituation(getInstance());
                break;
            case "Return to the cavern":
                AdvGame.setSituation(SmallCavern_0E.getInstance());
                break;
        }
    }
    private boolean isSolved() {
        if (copper1 == 0 && copper2 == 5 && copper3 == 2 && copper4 == 3) {
            return true;
        }
        return false;
    }
    public static Situation getInstance() {
        return situation;
    }
}

package org.sherwoodhs.situation.BoilerRoom.Abyss.Canyon.PraffitSettlement;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.situation.BoilerRoom.Abyss.Canyon.Crevasse_1E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;

public class Praffit_E implements Situation {
    private static Situation situation = new Praffit_E();
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
                        new String[]{"Return to the junction"}
                );
                break;
                // second street - apothecary
            case "Exit the building":
            case "Take the second street":
                if (cameFromApothecary) {
                    cameFromApothecary = false;
                    AdvGame.updateFrame(
                            "You exit the building. You wonder if there is anything else of note here...",
                            new String[]{"Enter the building again", "Return to the junction"}
                    );
                } else {
                    AdvGame.updateFrame(
                            "You walk down the second street. In the corner of your eye to the left, you see a relatively intact building, with openings that were likely windows in the past.\n\n" +
                                    "Upon closer inspection, it seems to have been some kind of window display. You drag your hand across the small platform, and your hand becomes covered in vaguely green dust. Herbs, perhaps?",
                            new String[]{"Enter the building", "Return to the junction"}
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
                        "The document reads:\n\n\nApothecary Report III\n\n" +
                                "Three men entered the bottommost layer of the abyss approximately five days ago, and recently ascended. Unlike the previous higher layers, there seems to be some kind of condition that afflicts humans when returning from the bottom of the abyss.Two of the men exhibited relatively minor symptoms. However, the other individual remained in the bottommost layer for the longest period of time, and exhibited more major symptoms. Seemingly, there is a correlation between time of exposure and the severity of symptoms exhibited.\n" + "\n" +
                                "Minor symptoms:\n" +
                                "Insomnia\n" + "Hypothermia\n" + "Minor hallucinations\n\n" +
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
                AdvGame.clearFrameWithoutSpacing(
                        "You travel down the third street. Most of the houses are broken and crumbling. As you keep walking forwards, you feel your foot catch on something. You looking down, and you find a small green journal on the ground under your shoe.\n\n" +
                    "You crack open the journal, and you see that the pages are warped, like they’ve been submerged in water a long time ago. You carefully flip through the pages of the journal, and you notice one page that captures your attention:\n\n\n" +
                    "The construction workers I work with have been down there for so long, it’s no longer safe for them to come back up. People have already died from ascension; there was that one man who stayed down there for a month, came back up, then promptly died. So, why don’t we just stay down there? " + 
                    "The air quality is better down there than here in Praffit. There’s no ash or dust or whatever… really, the only danger down there is moving between layers, right? And, right now we call it the bottommost layer, but what if there are other layers beneath it? There’s no way to know unless we stay down there…\n" + 
                    "I don’t think there’s any point in staying in Praffit at this point. This place is desolate and decrepit, and we’re all alone. It’s time for something new.\n\n\n" +
                    "You look up from your reading, and notice that the street continues to head forwards, converging with another street.",
                        new String[]{"Keep moving down the street", "Return to the junction"}
                );
                break;
                // fourth street - residential area
            case "Take the fourth street":
                AdvGame.clearFrameWithoutSpacing(
                        "As you travel down the fourth street, you happen upon what looks like a residential area. The buildings are smaller and tightly packed, and in some, you can find the remnants of couches, chairs, lamps, and bookshelves.\n\n" + 
                        "It's quite eerie... seeing all of these crumbling houses makes you realize that any sense of normalcy is behind you now. You decide to inspect one of the houses to your left, and you find a lamp, a bookshelf, and a broken table.",
                        new String[]{"Inspect the lamp", "Inspect the bookshelf", "Inspect the table", "Return to the junction"}
                );
                break;
            case "Inspect the lamp":
                AdvGame.clearFrameWithoutSpacing(
                    "The lamp's base is made out of an orange metal. The lampshade likely rotted away a long time ago... only a couple flakes of gray fabric remain on the dusty lightbulb. You try pulling the thin cord attached to the lamp to see if it will turn on, but it doesn't.\n\n" + 
                    "You rub some of the tarnish off of the metal, and it reveals some small letters imprinted on the metal: ÅRSTID. It must be the lamp's model name.",
                        new String[]{"Inspect the bookshelf", "Inspect the table", "Return to the junction"}
                );
                break;
             case "Inspect the bookshelf":
                AdvGame.clearFrameWithoutSpacing(
                    "You find a small document sandwiched between two moldy books. It doesn’t look like it’s been disturbed for a long time. The ink on the document has since bled out significantly, but you can still make out what it says:\n\n\n" +
                    "Depths of each respective layer of the abyss:\nForest of Abandoned Returns - 0m to 350m\nThe Surface - 350m to 750m\nThe Abyss Mines - 750m to 7940m\nThe Canyon of Ashes - 7940m to 11690m\n[Praffit - approx. 9730m]\nThe Blank - 11000m to 12400m\nCity of the Abyss - 12400m to approx. 14900m\n???? - 14900m to ?\n\n\n" +
                    "You realize that the inhabitants of this settlement did indeed make it down the vertical pit mentioned in the journal by the time this document was written (which you now know was affectionately called ‘the blank’) leading to the layer underneath, and constructed a (you assume) small city there. The question marks below however… do pique your interest.",
                        new String[]{"Inspect the lamp", "Inspect the table", "Return to the junction"}
                );
                break;
            case "Inspect the table":
                AdvGame.clearFrameWithoutSpacing(
                    "You take a closer look at the table. One of the legs are gone, leaving the table tilted to one side. There's nothing that remarkable about the table, and you fear that if you touch it, it'll completely break apart.\n\n" + 
                    "You look around again, and you notice a set of stairs that was hidden in the darkness leading up.",
                        new String[]{"Inspect the lamp", "Inspect the bookshelf", "Go upstairs", "Return to the junction"}
                );
                break;
            case "Go upstairs":
                AdvGame.clearFrameWithoutSpacing(
                    "You ascend the stairs. The second floor of this house is much more destroyed; yellow light streams through the cracks in the crumbling walls.\n\n" + 
                    "There is a desk made of dark wood placed off to the side, surrounded by bookshelves. The desk has a leather journal and a blueprint placed next to it. Perhaps this was a home office of some kind?",
                        new String[]{"Inspect the desk", "Inspect the journal", "Inspect the blueprint", "Go downstairs"}
                );
                break;
            case "Inspect the desk":
                AdvGame.clearFrameWithoutSpacing(
                    "The dark wood desk is masterfully crafted. There are beautiful carvings still visible on the legs, even after all this time. Other than that, there is nothing too special about the desk itself.",
                        new String[]{"Inspect the journal", "Inspect the blueprint", "Go downstairs"}
                );
                break;
            case "Inspect the journal":
                AdvGame.clearFrameWithoutSpacing(
                    "Inspecting the small book, the journal actually looks to be in relatively good condition... which might mean it’s the most recent thing you’ve found in this settlement… You flip to the first page, and it reads in a beautiful cursive text:\n\n\n" +
                    "It has been fifty years since Praffit has been established in the depths… it is simply a symbol of human determination and achievement. We cannot be restrained; we will always expand. Thus, it is now time to depart.\n\n" + 
                    "After this point… we will not be able to return. But in the end, that doesn’t matter. As humans, we are trailblazers. We will light the way to success, by dooming the rest of our lives to the depths… never to see the surface again.\n\n" + 
                    "Who could possibly run away from this fate? You cannot escape fate. Even so, those cowards ran away into those infernal mines… their names will be lost to history. No one will remember their stories. Thus, the curse of ascension I see as a blessing. " + 
                    "It provides a motive to keep moving forward, rather than to meddle in the past. Those cowards will never learn their lesson. " +
                    "Through exploration of the layer beneath the blank, I personally will be the one to establish our glorious device of the light. We will be forever hailed as heroes. I look forward to it.",
                        new String[]{"Inspect the desk", "Look under the journal", "Inspect the blueprint", "Go downstairs"}
                );
                break;
            case "Look under the journal":
                AdvGame.clearFrameWithoutSpacing(
                    "You look underneath the journal, and you find a grainy photograph of a beautiful subterranean city. It looks like the photograph has been taken from some kind of high vantage point… the city is so massive, it stretches out into the darkness. The stone looks close to pure black (much darker than the gray of the stone here), " + 
                    "and you then notice that the city is quite literally carved into the massive pillar-like stone formations making up the city. Unlike the mines above and the ashy canyons here, however, " + 
                    "you see that there is some type of massive vegetation growing on the stones; vines, large pink flowers, and what looks like glowing orbs growing from large yellow tendrils. It’s a beautiful sight, but you notice that the emptiness of the city makes it feel hollow… " + 
                    "and almost like an echo of the dream the inhabitants of this settlement cherished.",
                        new String[]{"Inspect the desk", "Inspect the blueprint", "Go downstairs"}
                );
                break;
            case "Inspect the blueprint":
                AdvGame.clearFrameWithoutSpacing(
                    "The thin piece of blue paper is covered with scribbled calculations and measurements, but underneath all that it seems like it’s a schematic for a large spherical object.\n\nOn the bottom left corner, an image of a skull draws your attention… was this secret project a weapon? " + 
                    "Or was there something more sinister lurking in the depths of the abyss?",
                        new String[]{"Inspect the desk", "Inspect the journal", "Go downstairs"}
                );
                break;
            case "Go downstairs":
                AdvGame.clearFrameWithoutSpacing(
                    "You look around the decrepit room after descending down the stairs. Who lived here? Why did they leave?",
                        new String[]{"Inspect the lamp", "Inspect the bookshelf", "Inspect the table", "Go upstairs", "Return to the junction"}
                );
                break;
                // fifth street
            case "Leave":
                AdvGame.clearFrameWithoutSpacing(
                        "You exit the building. There is a small crumbling house to your left, and a building with no walls to your right, containing science equipment.",
                        new String[]{"Inspect the house to the left", "Inspect the building to the right", "Return to the junction"}
                );
                break;
            case "Take the fifth street":
                AdvGame.clearFrameWithoutSpacing(
                        "You walk down the fifth street. There is a small crumbling house to your left, and a building with no walls to your right. The building on the right has a couple of large tables set in a row, with what looks to be the remnants of science equipment on them.\n\n" + 
                    "The street also begins to turn towards the left, as if it is converging with another street you saw at the junction.",
                        new String[]{"Inspect the house to the left", "Inspect the building to the right", "Keep moving down the street", "Return to the junction"}
                );
                break;
            case "Inspect the house to the left":
                AdvGame.clearFrameWithoutSpacing(
                        "You enter the house. A piece of scrap metal creaks under your shoe as you walk inside. There is not much left of the house, other than a small white envelope covered in dust, propped up next to the remnants of a bookshelf.",
                        new String[]{"Open the envelope", "Leave"}
                );
                break;
            case "Open the envelope":
                AdvGame.clearFrameWithoutSpacing(
                    "Inside the envelope, you find a small letter containing tiny but neat handwriting. It seems like it’s been forgotten by whoever was meant to read it.\n\n\n" +
                    "Dear Mom,\n\n" +
                    "Everyone is moving out of Praffit now. They’re all chanting about how they will become heroes and idols… but I don’t want to go. I’ve been enlisted to be one of the first groups to go under the blank and begin life in the city below, but I can’t. I’ve seen the city through photographs, and it truly is beautiful… but there’s something sinister I can sense about it. " +
                    "It definitely feels like there’s something wrong with everyone who’s going… my friends are saying that I should come with them without thinking of the curse… The ascension curse is what I’m scared of. Once we live down there, we’ll die if we try to ascend up the blank again. " + 
                    "And… I don’t want that to happen if something goes wrong down there.\n" + 
                    "So please, come and run away with me. I know you want to explore the unknown… but nothing about this feels right to me. People being bribed to work in the mines at the beginning of this entire situation forty-nine years ago… some kind of daily quota for a project no one knows about… a prison that’s always full but no one knows the prisoners… " + 
                    "Please. I know the way through the mines. We can survive in the forest or go to the IKEA. Who cares if the situation in the IKEA you mentioned got worse. All I’ve known in this world is the abyss… but you’ve been out there. And I say, anything but this.\n\n\n" +
                    "You squint your eyes at the name written underneath the letter, but it’s illegible. It seems that the hopes of the writer were forgotten forever… those hopes left to rot in a settlement that never again saw the light of day.",
                    new String[]{"Leave"});
                break;
            case "Inspect the building to the right":
                AdvGame.clearFrameWithoutSpacing(
                        "You carefully step inside. Shattered test tubes crunch under your shoes as you reach one of the tables you saw. You find a textbook placed on top of one of the tables.",
                        new String[]{"Open the textbook", "Leave"}
                );
                break;
            case "Open the textbook":
                AdvGame.clearFrameWithoutSpacing(
                        "You flip through the book, but it’s just a science textbook. Then to your surprise, you find a small slip of paper that has writing on it, sandwiched between two pages covered with pictures of plants and flowers. It says:\n\n\n" +
                        "I’ve been doing some exploration on my own. I know everyone is excited about building and living in a city below the blank, but I’ve discovered something else even farther below… something that completely changes how we’ll live life in the IKEA. " + 
                    "Who cares about that little project we’ve been working on with all of the ore quotas and things… in the end, that’s just a stopgap. " + 
                    "It’s just meant to cover up something that went wrong. But this… this must be hidden at all costs. No one can know about this, or else it’ll be scooped up by some other organization… and disappear forever. " + 
                    "Thankfully, it’s quite a journey to get there, not to mention the ascension curse (which hit me quite hard coming from the layer beneath the city), so hopefully no one discovers it and decides to taint it.\n\n\n" +
                    "The writing is extremely messy, like it’s been written in a rush. There’s some more writing afterwards, but it’s completely illegible. You wish you could read a bit more.",
                        new String[]{"Leave"}
                );
                break;
            case "Keep moving down the street":
                clickedContinue = true;
                    AdvGame.setSituation(BlackwellEntrance_E.getInstance());
                    break;
            case "Return to the junction":
                clickedContinue = true;
                AdvGame.setSituation(getInstance());
                break;
            case "Return":
                AdvGame.setSituation(Crevasse_1E.getInstance());
                break;
        }
    }

    @Override
    public ImageIcon getImg() {
        return null;
    }

    public static Situation getInstance() {
        return situation;
    }
}

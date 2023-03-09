package org.sherwoodhs.situation.Foundation.quests;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import java.util.Random;

public class MaterialsQuest implements Situation {
    private static Situation situation = new MaterialsQuest();
    Player player = Player.getInstance();
    Random random = new Random();
    private int num = random.nextInt(15);
    static int screws = 0;
    static int wood = 0;
    @Override
    public String getTitle() {
        return "Collect Furnature";
    }

    @Override
    public String getDescription() {
        return "As you enter an mostly abandoned section of the Haven things begin to change." +
                "You notice that the lighting is dim and flickering," +
                "casting eerie shadows on the shelves and walls." +
                "The sound of footsteps echoes throughout the space but you cant see anyone. " +
                "you can hear faint whispers and murmurs in the distance." +
                "This is creepy I better find a couple of pieces of furniture and get out before anything happens";
    }

    @Override
    public SitType getSitType() {
        return SitType.Interaction;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Move on", "Nap", "Look Around"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option) {
            case "Look Around":
                if (num == 1) {
                   AdvGame.updateFrame("you notice a piece of furniture that could be useful" +
                           "You cautiously approach it, ready to grab it and go if anything goes wrong." +
                           "As you reach out nothing seems to be unusual and it seems to be the scraps of what used to be a chair." +
                           "Now nothing more than wood and screws", new String[]{"Move on", "Nap", "Look Around", " Grab the Scraps"});
                } else if (num == 3) {
                    AdvGame.updateFrame("you notice a piece of furniture that could be useful" +
                            "You cautiously approach it, ready to grab it and go if anything goes wrong." +
                            "But as your reach out you cant even make out what furniture it used to be most of it seems to be too damaged to use" +
                            "Now nothing more than the screws can be used", new String[]{"Move on", "Nap", "Look Around", " Grab the Screws"});
                } else if (num == 6) {
                    AdvGame.updateFrame("you notice a piece of furniture that could be useful" +
                            "You cautiously approach it, ready to grab it and go if anything goes wrong." +
                            "As you reach out nothing seems to be unusual " +
                            "but it seems to be what looks like the pieces of an old couch with the wood to old and rotten to use" +
                            "Now nothing more than the screws can be used", new String[]{"Move on", "Nap", "Look Around", " Grab the Screws"});
                } else if (num == 12) {
                    AdvGame.updateFrame("you notice wardrobe that looks to be in good condition that could be useful" +
                            "You cautiously approach it, ready to grab it and go if anything goes wrong." +
                            "As you reach out the whole thing seems to be intact a rarity in the haven " +
                            "as you pick apart the pieces you need you get lots of wood and screws", new String[]{"Move on", "Nap", "Look Around", "Take Apart the Wardrobe"});
                } else if (num == 9) {
                    AdvGame.updateFrame("you notice a wooden desk that could be useful" +
                            "You cautiously approach it, ready to grab it and go if anything goes wrong." +
                            "As you reach out the whole thing seems to be intact a rarity in the haven " +
                            "As you pick apart the pieces you need you get lots of wood and screws", new String[]{"Move on", "Nap", "Look Around", " Take Apart the Desk"});
                } else if (num == 15) {
                    AdvGame.updateFrame("you notice a piece of furniture that could be useful" +
                            "You cautiously approach it, ready to grab it and go if anything goes wrong." +
                            "As you reach out nothing seems to be unusual " +
                            "but it seems to be what looks like a desk with the screws all stripped and bent but the wood looks salvageable" +
                            "Now nothing more than the wood can be used", new String[]{"Move on", "Nap", "Look Around", "Salvage the Wood"});
                }else {
                    AdvGame.updateFrame("The shelves that once held beds, chairs, and tables are now empty, leaving behind only bare walls and dusty floors." +
                            "You don't see and furniture or usable materials to grab", new String[]{"Move on", "Nap", "Look Around"});

                }

                World.changeStateI("Time", 1);
                break;
            case "Nap":
                World.changeStateI("Time", 1);
                break;
            case "Move On":
                AdvGame.updateFrame("You move on to other places to search for furniture");
                World.changeStateI("Time", 1);
                break;
            case "Grab Scraps":
                AdvGame.updateFrame("As you grab the scraps of the old furniture you collect the wood and screws that are usable and move on",
                        new String[]{"Move on", "Nap", "Look Around"});
                screws++;
                wood++;
                World.changeStateI("Time", 1);
                break;
            case "Grab Screws":
                AdvGame.updateFrame("As you grab the scraps of the old furniture you collect the screws that are usable and move on",
                        new String[]{"Move on", "Nap", "Look Around"});
                screws++;
                World.changeStateI("Time", 1);
                break;
            case "Take Apart the Desk":
                AdvGame.updateFrame("As you pick apart the pieces from the desk you need you get lots of wood and screws",
                        new String[]{"Move on", "Nap", "Look Around"});
                screws += 2;
                wood += 2;
                World.changeStateI("Time", 1);
                break;
            case "Take Apart the Wardrobe":
                AdvGame.updateFrame("As you pick apart the pieces from the wardrobe you need you get lots of wood and screws",
                        new String[]{"Move on", "Nap", "Look Around"});
                screws += 2;
                wood += 2;
                World.changeStateI("Time", 1);
                break;
            case "Salvage the Wood":
                AdvGame.updateFrame("As you salvage the wood of the old furniture you collect the wood that is usable and move on",
                        new String[]{"Move on", "Nap", "Look Around"});
                wood++;
                World.changeStateI("Time", 1);
                break;


        }
    }
}

package org.sherwoodhs.situation.BoilerRoom.Abyss.Surface;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Entrance.EntranceSituation_0E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class GildedRoom_E implements Situation {
    boolean firstTime = true;
    private static Situation situation = new GildedRoom_E();
    @Override
    public String getTitle() {
        return "???";
    }
    @Override
    public String getDescription() {
        return "To your surprise, you enter the door unharmed. At the same time, you realize you've spent too much time here...\n\n" +
                "Lost in your thoughts, you don't notice the door slowly shutting behind you. All too late, you notice and run towards the door, so it doesn't close. " +
                "However for some reason, the door that you were able to easily open and close is now heavier than a ton of bricks... and it slams shut.\n\n" +
                "You look around the room. The walls are covered in a vibrant gold metal, and the room is illuminated with a collection of blue lanterns. " +
                "There are a couple of plush chairs and a large bed in one corner, and a small hole probably meant for waste... In another, there is a massive stack of food and water, to your surprise. You might be able to survive here.\n\n" +
                "But still you try the door again... until you notice there is no handle on the inside. You are trapped.\n\n" +
                "At least you can still live out the rest of your days here in relative comfort... but does it matter? You've wasted too much time. Everyone has forgotten about you.\n\n\n\n\n\n\n\n\n...Your story is over.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        return new String[]{"Restart", "Exit"};
    }
    @Override
    public void perform(String option) {
        firstTime = false;
        switch (option) {
            case "Restart":
                AdvGame.setSituation(EntranceSituation_0E.getInstance());
                break;
            case "Exit":
                System.exit(0);
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}

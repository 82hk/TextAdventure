package org.sherwoodhs.situation.BoilerRoom.Generator;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.location.BoilerRoom;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.situation.BoilerRoom.BoilerRoom_1E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class Generator_E implements Situation {
    private boolean firstTime = true;
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
            return "After a bit of climbing across pipes, you find that you are in front of a massive vibrating green container. It's extremely loud.\n\n" +
                    "You strain your eyes and see that in faded paint, it is the IKEA's \"generator\". " +
                    "You then turn, seeing that the red light you saw before was actually a flashing light on the generator's side.\n\n" +
                    "You listen for any other people that could be near, but your attempts are drowned out by the generator's sound.";
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
        return new String[]{"Enter the darkness", "Inspect one of the pipes", "Leave"};
    }
    @Override
    public void perform(String option) {
        firstTime = false;
        switch (option) {
            case "Enter the darkness":
                AdvGame.setSituation(BoilerRoom_1E.getInstance());
                break;
            case "Inspect one of the pipes":

                break;
            case "Leave":
                // leave
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}

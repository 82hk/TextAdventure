package org.sherwoodhs.situation.Entrance;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class EntranceSituation_2E implements Situation {
    private static Situation situation = new EntranceSituation_2E();

    @Override
    public String getTitle() {
        return "???";
    }

    @Override
    public String getDescription() {
        return "You step through the door and into the massive open expanse of a mall."+
          "\n\nOr at least, something resembling a mall. Many floors high and hundreds of feet across, this colossal room is lined with even more Ikea furniture and display rooms on every level."+
          "\n\nFar up above, countless industrial ceiling lights glare down illuminating the room almost like daylight, while along the perimeter dozens of escalators vertically connect the floors. Down in the center of it all, kiosks and booths litter the ground floor.";

    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Continue"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){

            // MAIN BRANCH
            case "Continue": // first
                AdvGame.updateFrame("---\n\nMost strikingly of all—people. Thousands of them, everywhere.\n\nPeople walking around or talking at small storefronts and children chasing each other across the plaza floor, filling the whole area with an indistinct chatter. Yet . . . no one seems to be shopping.\n\nRather than browsing the showrooms, these people appear to be living in them. People are sitting in the sofas and chairs, sleeping on the display mattresses, sweeping the porches of fake house fronts, and eating at the showroom dining tables.",
                        new String[]{" Continue "});
                break;
            case " Continue ": // second
                AdvGame.updateFrame("---\n\nEverything in sight bears the familiar look and feel of an Ikea department store but there are no employees to be seen, only this vast crowd interspersed by patrols of roaming mall security guards.\n\nStepping forward, you see this vast plaza is actually created by the joining of four enormous halls in the shape of an 'X', each many floors high and stretching far into the distance out of sight.\n\nYou are on the ground floor.\n\nYou feel rather small.",
                        new String[]{"Explore","Go back"});
                break;
            case "Go back":
                AdvGame.updateFrame("You turn around, but see that the door you entered through has vanished. In its place is a small note taped to the wall. It reads:\n\n\"No\n\n     - The Dev Team\"",
                        new String[]{"Explore"});
                break;
            case "Explore":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

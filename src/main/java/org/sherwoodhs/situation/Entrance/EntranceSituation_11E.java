

package org.sherwoodhs.situation.Entrance;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Haven.HavenCenter;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class EntranceSituation_11E implements Situation {
    private static Situation situation = new EntranceSituation_11E();

    @Override
    public String getTitle() {
        return "???";
    }

    @Override
    public String getDescription() {
        return "You turn around, but see that the door you entered through has vanished. In its place is a small note taped to the wall. It reads:\n\n"+
            "\"'No'\n     - The Dev Team\"";

    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Explore"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Explore":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

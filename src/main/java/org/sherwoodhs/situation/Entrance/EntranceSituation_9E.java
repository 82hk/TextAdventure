package org.sherwoodhs.situation.Entrance;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class EntranceSituation_9E implements Situation {
    private static Situation situation = new EntranceSituation_9E();

    @Override
    public String getTitle() {
        return "???";
    }

    @Override
    public String getDescription() {
        return "You step through the door and into the massive open expanse of a mall."+
          "\n\nOr at least, something resembling a mall. Many floors high and hundreds of feet across, the colossal room is lined with more Ikea furniture and showroom displays on every level."+
          "\n\nHigh up above, countless industrial ceiling-mounted lights cast a uniform yellow glow across the scene, while along the perimeter dozens of escalators connect the floors together. Down in the center of it all, kiosks and booths litter the ground floor."+
          "\n\nMost strikingly of all: people.\n\nThousands of them, everywhere. Milling about, talking at booths, going between floors, filling the whole of the plaza with indistinct chatter. Yet no one seems to be shopping. Rather than browsing the showrooms, these people appear to be living in them, using the mock home displays of living rooms and kitchens and dining areas that line the walls of the plaza for their actual purpose."; 

    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"..."};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "...":
                AdvGame.setSituation(EntranceSituation_10E.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

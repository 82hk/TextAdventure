package org.sherwoodhs.situation.BoilerRoom.Generator;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class InspectRedLight_E implements Situation {
    private static Situation situation = new InspectRedLight_E();
    @Override
    public String getTitle() {
        return "The Boiler Room";
    }
    @Override
    public String getDescription() {
        return "You take a closer look at the red light. At this distance, it's almost blinding. " +
                "You touch the glass, and it's scorching hot. " +
                "You quickly pull your hand away from the glass... it doesn't look like there's anything special with the light.\n\n" +
                "You do wonder why it's flashing, however. It's almost like if it's... warning you about something.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        return new String[]{"Return"};
    }
    @Override
    public void perform(String option) {
        switch(option) {
            case "Return":
                AdvGame.setSituation(Generator_E.getInstance());
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}

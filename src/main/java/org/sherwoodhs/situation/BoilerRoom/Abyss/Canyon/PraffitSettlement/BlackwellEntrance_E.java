package org.sherwoodhs.situation.BoilerRoom.Abyss.Canyon.PraffitSettlement;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class BlackwellEntrance_E implements Situation {
    private static Situation situation = new BlackwellEntrance_E();
    @Override
    public String getTitle() {
        if (World.discoveredAbyssInfo) {
            return "Praffit";
        }
        return "???";
    }
    @Override
    public String getDescription() {
            return "You walk out of the main settlement, leaving the decrepit buildings behind. In front of you looms a small complex of stone towers and buildings." +
                    "As you approach, you notice a small wooden sign with red letters painted on: \"Blackwell Prison\". You step over a sheet of rusty metal, and observe the area.\n\n" +
                    "There are also two streets leading back into the ruined settlement of Praffit, one curving towards the right and the other going straight.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        return new String[]{"Enter the Blackwell Prison", "Take the street curving towards the right", "Take the street going straight"};
    }
    @Override
    public void perform(String option) {
        switch (option) {
            case "Enter the Blackwell Prison":
                System.out.println("This place isn't available yet!");
                break;
            case "Take the street curving towards the right":
            case "Take the street going straight":
                AdvGame.updateFrame("You go travel down the streets of Praffit, and make a point of returning all the way back to the junction.",
                        new String[]{"Continue"});
                break;
            case "Continue":
                AdvGame.setSituation(Praffit_E.getInstance());
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}

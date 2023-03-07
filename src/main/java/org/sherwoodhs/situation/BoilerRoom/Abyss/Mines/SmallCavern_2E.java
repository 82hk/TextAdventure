package org.sherwoodhs.situation.BoilerRoom.Abyss.Mines;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class SmallCavern_2E implements Situation {
    boolean firstTime = true;
    private boolean cameReverse = false;
    private static Situation situation = new SmallCavern_2E();
    @Override
    public String getTitle() {
        return "???";
    }
    @Override
    public String getDescription() {
        if (firstTime) {
            return "You continue to walk forward, being careful not to slip. " +
                    "The tunnel goes downwards at a sharper and sharper angle.\n\n" +
                    "There’s really nothing of note, until you reach a point where you can see a medium-sized cavern in front of you. " +
                    "There are glints of something orange embedded in the walls. Maybe you should go investigate.";
        }
        if (cameReverse) {
            cameReverse = false;
            return ("You walk forward through the passage. It angles slightly upwards.");
        }
        return "You continue to walk forward through the passage leading downwards. " +
                "You reach a point where you can see a medium-sized cavern in front of you. " +
                "Sparkling glints of orange embedded in the walls twinkle back at you from the cavern.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        return new String[]{"Move towards the orange glints", "Return", "Go all the way back"};
    }
    @Override
    public void perform(String option) {
        switch (option) {
            case "Move towards the orange glints":
                cameReverse = true;
                AdvGame.setSituation(CopperCave_E.getInstance());
                break;
            case "Return":
                AdvGame.setSituation(SmallCavern_1E.getInstance());
                break;
            case "Go all the way back":
                AdvGame.setSituation(SmallCavern_0E.getInstance());
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}


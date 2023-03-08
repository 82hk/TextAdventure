package org.sherwoodhs.situation.BoilerRoom.Abyss.Canyon.PraffitSettlement;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class PraffitEntrance_E implements Situation {
    private static Situation situation = new PraffitEntrance_E();
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
                "How have they have managed to stay lit? The houses are so old they are just the ghosts of their previous selves...\n\n" + 
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
    @Override
    public void perform(String option) {
        firstTime = false;
        switch (option) {
            case "Take the first street":
                AdvGame.updateFrame(
                        "You walk down the first street. As you observe the ruined houses, you reach a dead end. " + 
                        "All of the houses on this street don't have any walls anymore... and it doesn't look like there's anything interesting here.",
                        new String[]{"Continue"}
                );
                break;
            case "Take the second street":
                break;
            case "Take the third street":
                break;
            case "Take the fourth street":
                break;
            case "Take the fifth street":
                break;
            case "Continue":
                clickedContinue = true;
                break;
            case "Return":
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}

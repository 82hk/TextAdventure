package org.sherwoodhs.situation.ClearwaterEntrance;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.EntranceSituation.EntranceSituation_0E;
import org.sherwoodhs.situation.EntranceSituation.EntranceSituation_2E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class ClearwaterLobby_E implements Situation {

    private static Situation situation = new ClearwaterLobby_E();

    @Override
    public String getTitle() {
        return "Clearwater Lobby";
    }

    @Override
    public String getDescription() {
        return "Lobby of the Clearwater Collective";
    }

    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"1", "2", "3"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "1":
                AdvGame.updateFrame("The meatballs are good, but I don't have the time.");
                break;
            case "2":
                AdvGame.setSituation(EntranceSituation_2E.getInstance());
                break;
            case "3":
                AdvGame.updateFrame("Thankfully all my appliances are hard to remove. I don't need to replace any of them.");
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }
}

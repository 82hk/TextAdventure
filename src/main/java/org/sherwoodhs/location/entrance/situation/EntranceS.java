package org.sherwoodhs.location.entrance.situation;

import org.sherwoodhs.IkeaGame;
import org.sherwoodhs.inventory.Player;
import org.sherwoodhs.situation.Situation;

public class EntranceS implements Situation {

    private Player player = IkeaGame.player;

    @Override
    public String getSituation() {
        return "You stand in front of the abandoned IKEA.";
    }

    @Override
    public String[] getActions() {
        return new String[]{"Back away slowly.", "Enter the building"};
    }

    @Override
    public Situation performAction(int index) {
        switch (index) {
            case 0:
                player.makeCookies();
                //Make an instance to IkeaGame in the superClass?
                IkeaGame.getInstance().setSituation(new ExitS());
                break;
            case 1:
                IkeaGame.getInstance().setSituation(new IKEAEntranceS());
                break;
        }
        throw new IllegalArgumentException();
    }
}

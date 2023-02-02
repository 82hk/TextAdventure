package org.sherwoodhs.location.entrance.situation;

import org.sherwoodhs.IkeaGame;
import org.sherwoodhs.inventory.Player;
import org.sherwoodhs.situation.Situation;

public class EntranceS implements Situation {

    private Player player = Player.getInstance();

    @Override
    public String getSituation() {
        return "You stand in front of the abandoned IKEA.";
    }

    @Override
    public String[] getActions() {
        return new String[]{"Back away slowly.", "Enter the building"};
    }

    @Override
    public void performAction(int index) {
        switch (index) {
            case 0:
                player.makeCookies();
                //Make an instance to IkeaGame in the superClass?
                break;
            case 1:
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}

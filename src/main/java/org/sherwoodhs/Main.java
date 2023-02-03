package org.sherwoodhs;

import org.sherwoodhs.inventory.Player;
import org.sherwoodhs.location.entrance.Entrance;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.situation.Situation;

public class Main {
    public static void main(String[] args) {
        AdvGame game = AdvGame.getInstance();
        Location currentLocation = new Entrance();
        Situation currentSituation = currentLocation.getStartSituation();
        currentSituation.performAction(0);
        System.out.println(Player.getInstance().getCookies());
    }
}
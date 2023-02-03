package org.sherwoodhs;

import org.sherwoodhs.inventory.Player;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.situation.Situation;

public class AdvGame {
    private Location currentLocation;
    private Situation currentSituation;

    private static AdvGame ikeaGame = new AdvGame();
    public static Player player = Player.getInstance();

    private AdvGame() {
        //do
    }

    public static AdvGame getInstance() {
        return ikeaGame;
    }

    public void setSituation(Situation situation) {
        this.currentSituation = situation;
    }
}

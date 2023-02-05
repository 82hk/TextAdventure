package org.sherwoodhs;

import org.sherwoodhs.Locations.Location;
import org.sherwoodhs.inventory.Player;
import org.sherwoodhs.Situations.Situation;

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

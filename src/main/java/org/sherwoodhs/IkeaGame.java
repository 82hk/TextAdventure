package org.sherwoodhs;

import org.sherwoodhs.inventory.Player;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.situation.Situation;

public class IkeaGame {
    private Location currentLocation;
    private Situation currentSituation;

    private static IkeaGame ikeaGame = new IkeaGame();
    public static Player player = Player.getInstance();

    private IkeaGame()
    {
        //do
    }

    public static IkeaGame getInstance()
    {
        return ikeaGame;
    }

    public void setSituation(Situation situation)
    {
        this.currentSituation = situation;
    }




}

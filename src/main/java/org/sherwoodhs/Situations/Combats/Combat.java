package org.sherwoodhs.Situations.Combats;


import org.sherwoodhs.Locations.Location;
import org.sherwoodhs.NPCS.NPC;
import org.sherwoodhs.Situations.Situation;
import org.sherwoodhs.inventory.Player;

public abstract class Combat extends Situation {
    //Calls in player singleton
    protected Player player = Player.getInstance();

    //Enemy involved in combat
    protected NPC enemy;

    protected Combat (String name, String text, String[] absButtonText, Location location, NPC enemy){
        super(name, text, absButtonText,location);
        this.enemy = enemy;
    }

}

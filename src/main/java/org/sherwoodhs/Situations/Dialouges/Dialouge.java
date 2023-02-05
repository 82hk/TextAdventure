package org.sherwoodhs.Situations.Dialouges;


import org.sherwoodhs.Locations.Location;
import org.sherwoodhs.NPCS.NPC;
import org.sherwoodhs.Situations.Situation;

public abstract class Dialouge extends Situation {
    //All NPCs involved in dialouge
    protected NPC[] npcs;

    //Make sure the String array has 6 entries

    protected Dialouge (String name, String text, String[] absButtonText, Location location, NPC... npcs) {
        super(name, text, absButtonText,location);
        this.npcs = npcs;
    }
}

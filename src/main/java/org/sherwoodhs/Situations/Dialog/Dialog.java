package org.sherwoodhs.Situations.Dialog;


import org.sherwoodhs.Locations.Location;
import org.sherwoodhs.NPCS.NPC;
import org.sherwoodhs.Situations.Situation;

public abstract class Dialog extends Situation {
    //All NPCs involved in dialog
    protected NPC[] npcs;

    //Make sure the String array has 6 entries

    protected Dialog(String name, String text, String[] absButtonText, Location location, NPC... npcs) {
        super(name, text, absButtonText,location);
        this.npcs = npcs;
    }
}

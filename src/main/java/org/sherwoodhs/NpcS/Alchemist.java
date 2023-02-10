package org.sherwoodhs.NpcS;

import org.sherwoodhs.Locations.HiddenAlcove;

public class Alchemist extends NPC{
    private static NPC npc = new Alchemist();
    private Alchemist(){
        super("?????", 0, HiddenAlcove.getInstance(), false);
    }
    public static NPC getInstance(){
        return npc;
    }
}

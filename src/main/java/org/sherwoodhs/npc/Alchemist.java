package org.sherwoodhs.npc;

import org.sherwoodhs.location.HiddenAlcove;

public class Alchemist extends NPC{
    private static NPC npc = new Alchemist();
    private Alchemist(){
        super("?????", 0, HiddenAlcove.getInstance(), false);
    }
    public static NPC getInstance(){
        return npc;
    }
}

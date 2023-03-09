package org.sherwoodhs.npc.OtherSide;

import org.sherwoodhs.location.OtherSide.HiddenAlcove;
import org.sherwoodhs.npc.NPC;

public class Janus extends NPC {
    private static NPC npc = new Janus();
    private Janus(){
        super("Janus", 15, HiddenAlcove.getInstance(), false);
    }
    public static NPC getInstance(){
        return npc;
    }
}

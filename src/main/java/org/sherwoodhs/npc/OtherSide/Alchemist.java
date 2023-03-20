package org.sherwoodhs.npc.OtherSide;

import org.sherwoodhs.location.OtherSide.HiddenAlcove;
import org.sherwoodhs.npc.NPC;

public class Alchemist extends NPC {
    private static NPC npc = new Alchemist();
    private Alchemist(){
        super("?????", -25, HiddenAlcove.getInstance(), false);
    }
    public static NPC getInstance(){
        return npc;
    }
    protected void updateObRel(){
    }
}

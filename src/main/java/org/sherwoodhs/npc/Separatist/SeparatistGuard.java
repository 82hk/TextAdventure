package org.sherwoodhs.npc.Separatist;

import org.sherwoodhs.location.Foundation.FoundationBase;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.npc.NPC;

public class SeparatistGuard extends NPC {
    private static SeparatistGuard npc = new SeparatistGuard();
    protected SeparatistGuard() {
        super("A Separatist Guard stands fast by the door", 0, FoundationBase.getInstance(), false);
    }
    public static NPC getInstance(){
        return npc;
    }
}

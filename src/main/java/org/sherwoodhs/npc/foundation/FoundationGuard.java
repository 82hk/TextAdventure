package org.sherwoodhs.npc.foundation;

import org.sherwoodhs.location.Foundation.FoundationBase;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.npc.NPC;

public class FoundationGuard extends NPC {
    private static FoundationGuard npc = new FoundationGuard();
    protected FoundationGuard() {
        super("The Guard", 0, FoundationBase.getInstance(), false);
    }
    public static NPC getInstance(){
        return npc;
    }
}

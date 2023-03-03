package org.sherwoodhs.npc.Separatist;

import org.sherwoodhs.location.Foundation.FoundationBase;
import org.sherwoodhs.npc.NPC;

public class SeparatistChief extends NPC {
    private static SeparatistChief npc = new SeparatistChief();
    protected SeparatistChief() {
        super("Chief", 0, FoundationBase.getInstance(), false);
    }
    public static NPC getInstance(){
        return npc;
    }

    @Override
    public void changeHappiness(int amount) {
        super.changeHappiness(amount);
    }

    @Override
    public int getHappiness() {
        return super.getHappiness();
    }
}

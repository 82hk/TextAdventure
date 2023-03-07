package org.sherwoodhs.npc;

import org.sherwoodhs.location.Clearwater.ClearwaterHeadquarters;
import org.sherwoodhs.location.HiddenAlcove;

public class OldMan extends NPC{
    private static NPC npc = new OldMan();
    private OldMan(){
        super("Old Man", 0, ClearwaterHeadquarters.getInstance() /*Some city*/, false);
    }
    public static NPC getInstance(){
        return npc;
    }
    protected void updateObRel(){
        obRelation = 100;
    }
}

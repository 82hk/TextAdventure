package org.sherwoodhs.npc;

import org.sherwoodhs.location.Clearwater.ClearwaterKiosk;
import org.sherwoodhs.location.Location;

public class TheDistributor extends NPC {

    private static NPC npc = new TheDistributor();
    private TheDistributor() {super ("The Distributor",0,ClearwaterKiosk.getInstance(),false);}

    public static NPC getInstance() {return npc;}
}

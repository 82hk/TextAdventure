package org.sherwoodhs.NpcS;

import org.sherwoodhs.Locations.TestingLocation;

public class TestingDummy extends NPC{
    private static NPC npc = new TestingDummy();
    private TestingDummy(){
        super("Testing Dummy",0, TestingLocation.getInstance(),false);
    }
    public static NPC getInstance(){
        return npc;
    }
}

package org.sherwoodhs.npc;

import org.sherwoodhs.location.TestingLocation;

public class TestEnemy extends NPC{


    public TestEnemy() {
        super("Test Enemy", 0, TestingLocation.getInstance(), true);
    }
}

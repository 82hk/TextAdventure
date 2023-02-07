package org.sherwoodhs.NPCS;

import org.sherwoodhs.Locations.Location;
import org.sherwoodhs.Locations.TestingLocation;

public class TestEnemy extends NPC{


    public TestEnemy() {
        super("Test Enemy", 0, TestingLocation.getInstance(), true);
    }
}

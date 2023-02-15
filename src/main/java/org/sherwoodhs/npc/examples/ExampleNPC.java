package org.sherwoodhs.npc.examples;

/*
Example NPC
 */

import org.sherwoodhs.location.TestingLocation;
import org.sherwoodhs.location.examples.ExampleLocation;
import org.sherwoodhs.npc.NPC;

public class ExampleNPC extends NPC{
    //First, make sure your NPC class is named and packaged correctly
    //Then create the singleton instance:
    private static NPC npc = new ExampleNPC();

    //Then create the constructor:
    //The constructor contains the NPC's name, location, relationship and if it is hostile or not
    private ExampleNPC(){
        super("Example NPC",0, ExampleLocation.getInstance(),false);
    }

    //lastly create the "getter" method
    public static NPC getInstance(){
        return npc;
    }

    //Most NPC attributes can be changed from the NPC superclass
}

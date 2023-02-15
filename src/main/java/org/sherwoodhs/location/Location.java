package org.sherwoodhs.location;

import org.sherwoodhs.World;

//Do all singleton Stuff in separate objects of Location.
public abstract class Location {
    //Singleton Calls
    protected World world = World.getInstance();

    //Inner information
    protected String name;
    protected int obsReputation;
    protected int repModifier;

    protected Location(String name, int repModifier){
        this.name = name;
        this.repModifier = repModifier;
    }

    public String getName(){
        return name;
    }

    public int getReputation(){
        updateReputation();
        return obsReputation;
    }

    //Updates Reputation if modifier has changed or world renown has changed
    private void updateReputation(){
        int x = world.getState("Renown");
        x += repModifier;
        if (x > 100){
            obsReputation = 100;
        } else if (x < -100){
            obsReputation = -100;
        } else {
            obsReputation = x;
        }
    }

    public void changeRepModifier(int change){
        repModifier += change;
    }
}

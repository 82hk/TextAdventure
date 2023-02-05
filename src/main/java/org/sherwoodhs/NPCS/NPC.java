package org.sherwoodhs.NPCS;


import org.sherwoodhs.Locations.Location;

// Do singleton stuff in each separate NPC
public abstract class NPC {
    //Relationship stats
    protected int obRelation;
    protected int relModifier;

    //Location where NPC originates
    protected Location citizenship;
    protected boolean hostile;
    protected String name;

    protected NPC (String name, int relModifier, Location citizenship, boolean hostile){
        this.name = name;
        this.relModifier = relModifier;
        this.citizenship = citizenship;
        this.hostile = hostile;
    }

    public int getObRel() {
        updateObRel();
        return obRelation;
    }

    //Updates the observed reputation by checking to see if there is an updated
    //location base reputation/individual modifier
    protected void updateObRel(){
        int x = citizenship.getReputation();
        x += relModifier;
        obRelation = x;
    }

    //Changes the RelModifier by a certain value
    public void changeRelModifier(int change) {
        relModifier += change;
    }


    //Basic Accessors and Mutators
    public void setHostility(boolean hostile){
        this.hostile = hostile;
    }
    public boolean getHostility(){
        return hostile;
    }
    public String getName(){
        return name;
    }
}

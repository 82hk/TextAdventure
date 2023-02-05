package org.sherwoodhs.Situations.Explorations;


import org.sherwoodhs.Locations.Location;
import org.sherwoodhs.Situations.Situation;

public abstract class Exploration extends Situation {
    protected Exploration(String name, String text, String[] absButtonText, Location location){
        super(name,text,absButtonText, location);
    }

}

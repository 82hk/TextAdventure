package org.sherwoodhs.Situations.Interactions;

import org.sherwoodhs.Locations.Location;
import org.sherwoodhs.Situations.Situation;

import org.sherwoodhs.inventory.Item;

public abstract class Interaction extends Situation {
    //Items present in a situation
    protected Item[] items;
    protected Interaction (String name, String text, String[] absButtonText, Location location, Item... items) {
        super(name,text,absButtonText, location);
        this.items = items;
    }

}

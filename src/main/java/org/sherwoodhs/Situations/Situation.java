package org.sherwoodhs.Situations;

import org.sherwoodhs.Locations.Location;
import org.sherwoodhs.World;
import org.sherwoodhs.inventory.Inventory;

import java.util.Arrays;
import java.util.Objects;

//Singleton stuff will be done in each separate singleton

public interface Situation {
    //Returns options for input

    public abstract String getTitle();
    public abstract String getDescription();

    public abstract String[] getOptions();

    public abstract void perform(String option);

/*

    switch(i)
    case 0:
        inventory.remove(boot)
        AdvGame.setSituation(threwBoot.getInstance())

*/
}

package org.sherwoodhs.location.Separatists;
import org.sherwoodhs.location.Location;

/*
Example location
 */

public class SeparatistBase extends Location {

    private static SeparatistBase location = new SeparatistBase();

    private SeparatistBase(){super("This is the separatist central area", 0);}

    public static Location getInstance(){return(location);}

    //To update reputation call the changeReputation method from another class
    @Override
    public void changeRepModifier(int change){
        repModifier += change;
    }
}

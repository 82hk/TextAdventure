package org.sherwoodhs.location.Separatists;
import org.sherwoodhs.location.Location;

/*
Example location
 */

public class SeparatistHome extends Location {

    private static SeparatistHome location = new SeparatistHome();

    private SeparatistHome(){super("This is the separatist meeting location", 0);}

    public static Location getInstance(){return(location);}

    //To update reputation call the changeReputation method from another class
    @Override
    public void changeRepModifier(int change){
        repModifier += change;
    }
}

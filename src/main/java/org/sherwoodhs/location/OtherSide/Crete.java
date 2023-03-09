package org.sherwoodhs.location.OtherSide;

import org.sherwoodhs.location.Location;

public class Crete extends Location {
    private static Crete location = new Crete();
    private Crete(){
        super("Crete",20);
    }
    public static Location getInstance(){
        return(location);
    }
}

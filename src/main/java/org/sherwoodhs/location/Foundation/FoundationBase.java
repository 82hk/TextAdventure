package org.sherwoodhs.location.Foundation;


import org.sherwoodhs.location.Location;

public class FoundationBase extends Location {
    private static FoundationBase location = new FoundationBase();
    protected FoundationBase() {
        super("Foundation Base", 0);
    }
    public static Location getInstance(){
        return location;
    }
}

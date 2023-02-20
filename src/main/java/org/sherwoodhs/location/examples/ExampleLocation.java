package org.sherwoodhs.location.examples;

import org.sherwoodhs.location.Location;

/*
Example location
 */

public class ExampleLocation extends Location {

    //To create a custom location first you must properly name the file and package it correctly for organizational purposes
    //The second thing you should do is create a SINGLE instance of the location:
    private static ExampleLocation location = new ExampleLocation(); //ONE INSTANCE, make sure it is both PRIVATE and STATIC

    //next we need to specify the name and reputation, most of the time it will be 0, since the reputation will be updated later
    private ExampleLocation(){super("Example Location", 0);}

    //lastly we need to create the "getter" for the single instance of this location:
    //it needs to be both PUBLIC and STATIC
    public static Location getInstance(){return(location);}

    //To update reputation call the changeReputation method from another class
    @Override
    public void changeRepModifier(int change){
        repModifier += change;
    }
}

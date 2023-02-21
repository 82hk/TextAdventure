package org.sherwoodhs.location;

import org.sherwoodhs.location.Location;

public class HavenCenter extends Location {
    private static HavenCenter location = new HavenCenter();
    private HavenCenter() {super("Haven City Center", 0);}

    public static Location getInstance() {return(location);}

}

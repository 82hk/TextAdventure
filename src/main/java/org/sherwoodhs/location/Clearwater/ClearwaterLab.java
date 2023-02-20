package org.sherwoodhs.location.Clearwater;

import org.sherwoodhs.location.Location;

public class ClearwaterLab extends Location {

    private static ClearwaterLab location = new ClearwaterLab();
    private ClearwaterLab() {super("Clearwater Collective Lab",0);}

    public static Location getInstance() {return(location);}
}
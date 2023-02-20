package org.sherwoodhs.location.Clearwater;

import org.sherwoodhs.location.Location;

public class ClearwaterKiosk extends Location {

    private static ClearwaterKiosk location = new ClearwaterKiosk();
    private ClearwaterKiosk() {super("Clearwater Collective Kiosk",0);}

    public static Location getInstance() {return(location);}

}

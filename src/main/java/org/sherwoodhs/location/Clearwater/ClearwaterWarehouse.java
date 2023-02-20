package org.sherwoodhs.location.Clearwater;

import org.sherwoodhs.location.Location;

public class ClearwaterWarehouse extends Location {

    private static ClearwaterWarehouse location = new ClearwaterWarehouse();
    private ClearwaterWarehouse() {super("Clearwater Collective Warehouse",0);}

    public static Location getInstance() {return(location);}
}

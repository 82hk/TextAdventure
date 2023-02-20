package org.sherwoodhs.location.Clearwater;

import org.sherwoodhs.location.Location;

public class ClearwaterHeadquarters extends Location {
    private static ClearwaterHeadquarters location = new ClearwaterHeadquarters();
    private ClearwaterHeadquarters() {super("Clearwater Collective Headquarters", 0);}

    public static Location getInstance() {return(location);}

}

package org.sherwoodhs.location.Clearwater;

import org.sherwoodhs.location.Location;

public class ClearwaterKiosk extends Location {
    private static ClearwaterKiosk location = new ClearwaterKiosk();
    private ClearwaterKiosk() {super("In the center of the plaza stands one especially large kiosk. It's round, with polished white pillars " +
            "supporting a sky-blue dome. A massive model water bottle sits on top of the dome rotating slowly, while beneath a long line of people stretches out from the kiosk.",0);}

    public static Location getInstance() {return(location);}

}

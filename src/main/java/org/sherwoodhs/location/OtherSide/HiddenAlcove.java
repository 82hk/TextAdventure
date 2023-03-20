package org.sherwoodhs.location.OtherSide;

import org.sherwoodhs.location.Location;

public class HiddenAlcove extends Location {
    private static HiddenAlcove location = new HiddenAlcove();
    private HiddenAlcove(){
        super("Hidden Alcove",0);
    }
    public static Location getInstance(){
        return(location);
    }
}

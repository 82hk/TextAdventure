package org.sherwoodhs.Locations;

public class HiddenAlcove extends Location{
    private static HiddenAlcove location = new TestingLocation();
    private HiddenAlcove(){
        super("Hidden Alcove",0);
    }
    public static Location getInstance(){
        return(location);
    }
}

package org.sherwoodhs.location;

public class HiddenAlcove extends Location{
    private static HiddenAlcove location = new HiddenAlcove();
    private HiddenAlcove(){
        super("Hidden Alcove",0);
    }
    public static Location getInstance(){
        return(location);
    }
}

package org.sherwoodhs.location;

public class BoilerRoom extends Location{
    private static BoilerRoom location = new BoilerRoom();
    private BoilerRoom(){
        super("The Boiler Room",0);
    }
    public static Location getInstance(){
        return(location);
    }
}

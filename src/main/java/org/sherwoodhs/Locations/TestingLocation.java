package org.sherwoodhs.Locations;



public class TestingLocation extends Location{
    private static TestingLocation location= new TestingLocation();
    private TestingLocation(){
        super("Testing Location",0);
    }
    public static Location getInstance(){
        return(location);
    }
}

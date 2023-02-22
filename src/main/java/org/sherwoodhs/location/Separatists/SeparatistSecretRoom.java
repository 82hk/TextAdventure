package org.sherwoodhs.location.Separatists;
import org.sherwoodhs.location.Location;

/*
Example location
 */

public class SeparatistSecretRoom extends Location {

    private static SeparatistSecretRoom location = new SeparatistSecretRoom();

    private SeparatistSecretRoom() {super("This is the separatist secret room where we gather evidence of Foundation fraud", 0);}

    public static Location getInstance(){return(location);}

    //To update reputation call the changeReputation method from another class
    @Override
    public void changeRepModifier(int change){
        repModifier += change;
    }
}
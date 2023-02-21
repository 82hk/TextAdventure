package org.sherwoodhs.situation.Clearwater;

import org.sherwoodhs.location.Clearwater.ClearwaterKiosk;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.npc.TheDistributor;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class ClearwaterKiosk1_1E implements Situation {

    // The player decides whether to approach the Clearwater kiosk.

    Player player = Player.getInstance();
    NPC distributor = TheDistributor.getInstance();
    Location location = ClearwaterKiosk.getInstance();

    private static Situation situation = new ClearwaterKiosk1_1E();

    @Override
    public String getTitle() {
        return "Kiosk Line";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Approach the booth","Leave"}; // limit 6
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Approach the booth":
                break;
            case "Leave":
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

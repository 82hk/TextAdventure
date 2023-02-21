package org.sherwoodhs.situation.Clearwater;

import org.sherwoodhs.location.Clearwater.ClearwaterKiosk;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.npc.TheDistributor;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class ClearwaterKiosk1_D implements Situation {

    Player player = Player.getInstance();
    NPC distributor = TheDistributor.getInstance();
    Location location = ClearwaterKiosk.getInstance();

    private static Situation exploration = new ClearwaterKiosk1_D();

    @Override
    public String getTitle() {
        return "title";
    }

    @Override
    public String getDescription() {
        return "description";
    }

    @Override
    public SitType getSitType() {return SitType.Dialogue;}

    @Override
    public String[] getOptions() {
        String[] options = {"Example Option", "Example Option 2", "Make NPC hostile"}; // limit 6
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "":
                break;
            case " ":
                break;
            case "  ":
        }
    }

    public static Situation getInstance(){
        return dialogue;
    }

}

package org.sherwoodhs.situation.Clearwater;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.location.Clearwater.ClearwaterKiosk;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.npc.TheDistributor;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class ClearwaterKiosk1_0E implements Situation {

    // The player waits in line at the Clearwater booth.

    Player player = Player.getInstance();
    NPC distributor = TheDistributor.getInstance();
    Location location = ClearwaterKiosk.getInstance();

    private static Situation situation = new ClearwaterKiosk1_0E();

    @Override
    public String getTitle() {
        return "Kiosk Line";
    }

    @Override
    public String getDescription() {
        return "You step into the line.\n\nIn front of you, a man wrings his hands nervously. \"I hope there's enough this time,\" he mumbles to himself. " +
                "Ahead, a woman and her daughter walk away from the kiosk, each carrying a small plastic jug of water.\n\nThe line shuffles forward.\n\n";
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Keep waiting","Leave"}; // limit 6
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Keep waiting":
                AdvGame.setSituation(ClearwaterKiosk1_1E.getInstance());
                break;
            case "Leave":
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

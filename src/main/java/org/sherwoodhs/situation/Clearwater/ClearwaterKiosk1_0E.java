package org.sherwoodhs.situation.Clearwater;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.location.Clearwater.ClearwaterKiosk;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.npc.TheDistributor;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class ClearwaterKiosk1_0E implements Situation {

    Player player = Player.getInstance();
    NPC distributor = TheDistributor.getInstance();
    Location location = ClearwaterKiosk.getInstance();
    private boolean firstTime = true;

    private static Situation situation = new ClearwaterKiosk1_0E();

    @Override
    public String getTitle() {
        return "Kiosk Line";
    }

    @Override
    public String getDescription() {
        if (firstTime == true) {
            return "You step into the line.\n\nIn front of you, a man wrings his hands nervously. \"I hope there's enough this time,\" he mumbles to himself. " +
                    "Ahead, a woman and her daughter walk away from the kiosk, each carrying a small plastic jug of water.\n\nThe line shuffles forward.\n\n";
        } else {
            return "You step into the line.";
        }
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
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

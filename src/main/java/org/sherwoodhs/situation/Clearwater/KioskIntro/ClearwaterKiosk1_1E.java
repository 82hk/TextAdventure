package org.sherwoodhs.situation.Clearwater.KioskIntro;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.location.Clearwater.ClearwaterKiosk;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.npc.TheDistributor;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class ClearwaterKiosk1_1E implements Situation {

    private static boolean firstTime = true;

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
        if (firstTime) {
            firstTime = false;
            return "You step into the back of the line.\n\nIn front of you, a woman clutches her daughter's hand, muttering to herself and glancing ahead nervously,"+
                    " while the little girl waves at you with an empty bottle.\n\nThe line shuffles forward.";
        } else {
            return "You get in line.";
        }
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Wait","Leave"}; // limit 6
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Wait":
                AdvGame.setSituation(ClearwaterKiosk1_2E.getInstance());
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

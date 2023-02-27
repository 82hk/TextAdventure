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

public class ClearwaterKiosk1_2E implements Situation {

    Player player = Player.getInstance();
    NPC distributor = TheDistributor.getInstance();
    Location location = ClearwaterKiosk.getInstance();

    private static Situation situation = new ClearwaterKiosk1_2E();

    @Override
    public String getTitle() {
        return "Kiosk Line";
    }

    @Override
    public String getDescription() {
        return "You wait as the line of people slowly moves closer to the kiosk.\n\nOnly ten people to go.\n\nThen seven.\n\nThen five.\n\nThen two.\n\n"+
                "The woman steps up to the booth, pulling along her daughter. The old man greets them warmly and takes a small card from the woman. "+
                "He marks something on a desk behind the booth and turns to one of the guards, who in turn hands a package of water bottles to the woman."+
                " She looks at the stack of bottled water behind the booth then turns to look at the old man, seeming to grow agitated. "+
                "The old man shakes his head solemnly, while the guard steps in between to escort her away from the kiosk."+
                "\n\nThe old man sighs and sits back down, then gestures to you.";
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Approach","Leave"}; // limit 6
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Approach":
                AdvGame.setSituation(ClearwaterKiosk1_3D.getInstance());
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

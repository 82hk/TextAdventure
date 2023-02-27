package org.sherwoodhs.situation.Clearwater.KioskIntro;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.location.Clearwater.ClearwaterKiosk;
import org.sherwoodhs.location.HavenCenter;
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
    Location location = HavenCenter.getInstance();
    private static boolean firstTime = true;

    private static Situation situation = new ClearwaterKiosk1_0E();

    @Override
    public String getTitle() {
        return "Kiosk";
    }

    @Override
    public String getDescription() {
        if (firstTime == true) {
            return "Inside the circle of pillars, an old man sits at a booth. Behind him are dozens of packages of plastic water bottles, stacked high up to the domed ceiling."+
                    "\n\nMore security guards patrol the kiosk, guarding the bottled water pile and distributing individual bottles to the line of people at the old man's orders.";
        } else {
            return "Placeholder";
        }
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Get in line","Go elsewhere"}; // limit 6
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Get in line":
                AdvGame.setSituation(ClearwaterKiosk1_1E.getInstance());
                break;
            case "Go elsewhere":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

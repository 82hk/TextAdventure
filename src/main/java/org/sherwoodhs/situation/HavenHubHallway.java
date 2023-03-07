package org.sherwoodhs.situation;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.npc.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.quest.OtherSideQuest;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.HiddenAlcove.HiddenAlcove1_0E;
import org.sherwoodhs.situation.HiddenAlcove.HiddenAlcove1_1_1E;
import org.sherwoodhs.situation.Separatist.SeparatistHub;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

/*
   This is a hallway between the Hall and the Haven Center.
 */
public class HavenHubHallway implements Situation {
    private Player player = Player.getInstance();
    private NPC alchemist = Alchemist.getInstance();
    private static Situation situation = new HavenHubHallway();
    private HavenHubHallway(){

    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "Hallway Undefined";
    }

    @Override
    public String getDescription() {
        return ("You are currently in the hallway between Haven and the Hub.");
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] string = new String[]{"Go to the Haven Center", "Go to the Hall", ""};
        if (World.alcoveAccessible){
            string[2] = "Go to the Hidden Alcove";
        }
        return string;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Go to the Haven Center" :
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
            case "Go to the Hall":
                AdvGame.setSituation(SeparatistHub.getInstance());
                break;
            case "Go to the Hidden Alcove":
                AdvGame.setSituation(HiddenAlcove1_0E.getInstance());
            break;
        }
    }
}

package org.sherwoodhs.situation.OtherSide.OtherSide3;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.npc.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.HavenHubHallway;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

/*
   You talk to the Alchemist before you obtain the item required.
    It's just a little dialogue interaction
 */
public class OtherSide3_1_2D implements Situation {
    private Player player = Player.getInstance();
    private NPC alchemist = Alchemist.getInstance();
    private static Situation situation = new OtherSide3_1_2D();
    private OtherSide3_1_2D(){

    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "Don't Regret Your Decision";
    }

    @Override
    public String getDescription() {
        return (player.getName() + ": I can't hand this over to you right now. ");
    }

    @Override
    public SitType getSitType() {return SitType.Dialogue;}

    @Override
    public String[] getOptions() {
        return new String[]{"Continue"};
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Continue" :
                World.alcoveAccessible = false;
                AdvGame.setSituation(HavenHubHallway.getInstance());
                break;
        }
    }
}

package org.sherwoodhs.situation.OtherSide.OtherSide3;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.npc.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.quest.OtherSideQuest;
import org.sherwoodhs.situation.HiddenAlcove.HiddenAlcove1_0E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

/*
   You talk to the Alchemist before you obtain the item required.
    It's just a little dialogue interaction
 */
public class OtherSide3_1_0D implements Situation {
    private Player player = Player.getInstance();
    private NPC alchemist = Alchemist.getInstance();
    private static Situation situation = new OtherSide3_1_0D();
    private OtherSide3_1_0D(){

    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "Wish Granted";
    }

    @Override
    public String getDescription() {
        return ("You hand over the USB to " + alchemist.getName());
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
                World.changeStateI("Deaths", 1);
                break;
        }
    }
}

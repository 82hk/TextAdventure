package org.sherwoodhs.situation.OtherSide.OtherSide2;

import org.sherwoodhs.npc.OtherSide.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;

/*
   You found the door to Crete.
 */
public class OtherSide2_0E implements Situation {
    private Player player = Player.getInstance();
    private NPC alchemist = Alchemist.getInstance();
    private static Situation situation = new OtherSide2_0E();
    private OtherSide2_0E(){

    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "Crete Entrance";
    }

    @Override
    public String getDescription() {
        return ("You followed the map to an out-of-way door. It appears that you have found the entrance to Crete.");
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        return new String[]{"Enter the Door"};
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Enter the Door" :

                break;
        }
    }

    @Override
    public ImageIcon getImg() {
        return null;
    }
}

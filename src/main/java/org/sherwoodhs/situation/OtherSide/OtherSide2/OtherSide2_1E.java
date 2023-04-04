package org.sherwoodhs.situation.OtherSide.OtherSide2;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.npc.OtherSide.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;

/*
   You enter Crete
 */
public class OtherSide2_1E implements Situation {
    private Player player = Player.getInstance();
    private NPC alchemist = Alchemist.getInstance();
    private static Situation situation = new OtherSide2_1E();
    private OtherSide2_1E(){

    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "Crete";
    }

    @Override
    public String getDescription() {
        return ("You enter the room. It's very dark and you can't see much. However, you can see the vague outline of a ");
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        return new String[]{"Talk to the Man"};
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Talk to the Man" :
                AdvGame.setSituation(OtherSide2_UndeclaredE.getInstance());
                break;
        }
    }

    @Override
    public ImageIcon getImg() {
        return null;
    }
}

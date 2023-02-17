package org.sherwoodhs.situation.OtherSide1;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.npc.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

/*
 You essentially ask a question to the Alchemist, get a vague answer and return back to Otherside1_0_0D
 Nothing much happens except for removing this option from OtherSide1_0_0D

 */
public class OtherSide1_2D implements Situation {
    private Player player = Player.getInstance();
    private NPC alchemist = Alchemist.getInstance();
    private static Situation situation = new OtherSide1_2D();
    private OtherSide1_2D(){

    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "A Request";
    }

    @Override
    public String getDescription() {
        return (alchemist.getName() + ": If you really want to help,");
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
                // Continues on.
                break;
        }
    }
}

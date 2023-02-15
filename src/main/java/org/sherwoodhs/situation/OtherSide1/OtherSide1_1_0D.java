package org.sherwoodhs.situation.OtherSide1;

import org.sherwoodhs.npc.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.Situation;

/*
 This event occurs when you select the "nothing to return to" option in OtherSide1_0_0D.
 This only is selectable when the world basically hates you.
 Adds 5 rel to the Alchemist.
 Returns to the normal questline options.
 */
public class OtherSide1_1_0D implements Situation {
    private NPC alchemist = Alchemist.getInstance();
    private Player player = Player.getInstance();
    private static Situation situation = new OtherSide1_1_0D();
    private OtherSide1_1_0D(){

    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "Two Of The Same Kind";
    }

    @Override
    public String getDescription() {
        return ("(+5 relationship with " + alchemist.getName() + ")\n\n" +
                player.getName() + ": ");
    }

    @Override
    public String getSitType() {
        return "Dialogue";
    }

    @Override
    public String[] getOptions() {
        return new String[]{"Continue"};
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Continue" :
                break;
        }
    }
}

package org.sherwoodhs.situation.OtherSide1;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.npc.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.LocationOptions.HiddenAlcove.HiddenAlcove1_0E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

/*
 You, in some fashion, agree to help out with the alchemist.
 Displays information about a new quest when you first enter.

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
        return (alchemist.getName() + ": If you really want to help, there is something you can do...\n\n" +
                "Can you grab me ___________ from _____________. There is \n\n" +
                "(Quest Log Updated!)");
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
                World.changeStateI("Time",1);
                AdvGame.setSituation(HiddenAlcove1_0E.getInstance());
                break;
        }
    }
}

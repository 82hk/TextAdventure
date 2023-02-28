package org.sherwoodhs.situation.OtherSide.OtherSide1;

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
public class OtherSide1_1_3D implements Situation {
    private Player player = Player.getInstance();
    private NPC alchemist = Alchemist.getInstance();
    private static Situation situation = new OtherSide1_1_3D();
    private OtherSide1_1_3D(){

    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "Awkward";
    }

    @Override
    public String getDescription() {
        return ("(-1 relationship with " + alchemist.getName() + ")\n\n" +
                player.getName() + ": Nice to meet you too?\n\n" +
                "You were met with a blank stare. It was the look of extreme judgement. Internally, you knew you have been marked as an idiot.\n\n" +
                player.getName() + ": Umm. Okay...");
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
                AdvGame.setSituation(OtherSide1_0D.getInstance());
                break;
        }
    }
}

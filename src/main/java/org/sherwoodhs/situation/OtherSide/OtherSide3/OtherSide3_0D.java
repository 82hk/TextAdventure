package org.sherwoodhs.situation.OtherSide.OtherSide3;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.npc.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

/*
 This event only occurs have fulfilled part II of the questline and return to the hidden alcove.
 You get to decide whether or not you give the ______ to the alchemist.
 */
public class OtherSide3_0D implements Situation {
    private NPC alchemist = Alchemist.getInstance();
    private Player player = Player.getInstance();
    private static Situation situation = new OtherSide3_0D();
    private OtherSide3_0D(){
    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "Item Fetched";
    }

    @Override
    public String getDescription() {
        String string = "You returned back to the Hidden Alcove with the ______ in hand. When you entered, " + alchemist.getName() +
                " looked very surprised." +
                alchemist.getName() + ": You- you actually got it!\n\n";
        if (alchemist.getName().equals("Hecate")){
            string += "";
        } else {
            string += "";
        }
        return (string);
    }

    @Override
    public SitType getSitType() {return SitType.Dialogue;}

    @Override
    public String[] getOptions() {
        return new String[]{"Hand the item over", "Refuse to hand the item over"};
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Hand the item over" :
                //AdvGame.setSituation(.getInstance());
                break;
            case "Refuse to hand the item over":
                //AdvGame.setSituation(.getInstance());
                break;
        }

    }
}

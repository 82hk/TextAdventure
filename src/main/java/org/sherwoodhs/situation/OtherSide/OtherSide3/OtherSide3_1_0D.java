package org.sherwoodhs.situation.OtherSide.OtherSide3;

import org.sherwoodhs.npc.OtherSide.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;

import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;

/*
   You decide to hand over the USB to the alchemist, regardless of the rumors surrounding her.
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
        inventoryPanel.removeFromInventory("USB");
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
                
                break;
        }
    }

    @Override
    public ImageIcon getImg() {
        return null;
    }
}

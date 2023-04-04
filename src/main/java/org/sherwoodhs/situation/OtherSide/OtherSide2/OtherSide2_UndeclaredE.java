package org.sherwoodhs.situation.OtherSide.OtherSide2;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.npc.OtherSide.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.quest.Misc.OtherSideQuest;
import org.sherwoodhs.situation.Clearwater.Warehouse.ClearwaterWarehouseEntrance_0D;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;

import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;

/*
   You enter Crete
 */
public class OtherSide2_UndeclaredE implements Situation {
    private Player player = Player.getInstance();
    private NPC alchemist = Alchemist.getInstance();
    private static Situation situation = new OtherSide2_UndeclaredE();
    private OtherSide2_UndeclaredE(){

    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "Obtained USB";
    }

    @Override
    public String getDescription() {
        return ("This is a gap missing scenes. You obtained the USB");
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        return new String[]{"Continue"};
    }

    @Override
    public void perform(String option) {
        OtherSideQuest.advanceQuest();
        inventoryPanel.addToInventory("USB");
        switch (option){
            case "Continue" :
                AdvGame.setSituation(ClearwaterWarehouseEntrance_0D.getInstance());
                break;
        }
    }

    @Override
    public ImageIcon getImg() {
        return null;
    }
}

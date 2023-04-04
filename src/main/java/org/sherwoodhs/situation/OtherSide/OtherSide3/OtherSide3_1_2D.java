package org.sherwoodhs.situation.OtherSide.OtherSide3;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.npc.OtherSide.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;

import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;

/*
   You refuse to hand over the USB, but you have enough Relationship with the Alchemist that you don't die.
   The Destruct End Counter starts ticking.
 */
public class OtherSide3_1_2D implements Situation {
    private Player player = Player.getInstance();
    private NPC alchemist = Alchemist.getInstance();
    private static Situation situation = new OtherSide3_1_2D();
    private OtherSide3_1_2D(){

    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "Don't Regret Your Decision";
    }

    @Override
    public String getDescription() {
        return ("(-10 relationship with " + alchemist.getName() + ")\n\n" +
                player.getName() + ": I can't hand this over to you right now. With what I understand is contained in this USB, " +
                "I don't really know if anyone should have this. This... this can destroy everything.\n\n" +
                alchemist.getName() + ": You know, I thought you would understand. You always had. But I guess that only was meant to be for so long.\n\n" +
                "She stared at you with a disappointed look - both in you and the situation. But after a few seconds, you started to feel woozy. " +
                "You looked around and saw a container leaking gas. You look back at " + alchemist.getName() + " to see that she now wore a gas mask. " +
                alchemist.getName() + ": You know. I never wanted it to be this way. I thought... it could finally work out. But, no. I'm cursed, aren't I? " +
                "Every single, bloody time. Well, I guess this is goodbye. You won't see me again. Let your heroic fallacies to glory or death. " +
                "I won't be part of that. When you wake up, I'll be long gone. This place will be dissolved, to be left only in the history books." +
                "Farewell, " + player.getName() + ". It was nice while it lasted...\n\n" + 
                "You fell unconscious.");
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
                World.destructEnd = true;
                World.changeStateI("Time", 3);
                World.alcoveAccessible = false;
                inventoryPanel.removeFromInventory("USB");
                AdvGame.setSituation(OtherSide3_2_0E.getInstance());
                break;
        }
    }

    @Override
    public ImageIcon getImg() {
        return null;
    }
}

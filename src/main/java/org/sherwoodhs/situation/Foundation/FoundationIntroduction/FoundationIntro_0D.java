package org.sherwoodhs.situation.Foundation.FoundationIntroduction;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.npc.foundation.FoundationGuard;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.quest.Foundation.ScrapMetalCollection;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.ui.QuestPanel;

import javax.swing.*;

import static org.sherwoodhs.ui.BarPanel.barPanel;

public class FoundationIntro_0D implements Situation {
    private static Situation situation = new FoundationIntro_0D();
    NPC guard = FoundationGuard.getInstance();
    Player player = Player.getInstance();
    private static boolean firstTime = true;
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "The Foundation Booth";
    }

    @Override
    public String getDescription() {
        if (firstTime) {
            firstTime = false;
            return "As you approach the booth, you can see a makeshift tent set up behind it with a few guards dressed in worn-down uniforms " +
                    "milling around. A guard stands next to the booth, scanning the crowd for any signs of trouble. " +
                    "The ambient noise from the haven seems to dissipate as you walk closer to the foundation tents and the guard greets you with a nod." +
                    "\n\nGuard: You there. You look new around here you looking to join the foundation?";
        } else if(ScrapMetalCollection.getInstance().isCompleted()){
            AdvGame.setSituation(FoundationIntro_3D.getInstance());
            return null;
        } else if(QuestPanel.questPanel.containsQuest(ScrapMetalCollection.getInstance())) {
            return "You should probably go get the metal and complete the quest before returning to the guard.";
        } else {
            return "As you approach the booth, you can see a makeshift tent set up behind it with a few guards dressed in worn-down uniforms " +
                    "milling around. A guard stands next to the booth, scanning the crowd for any signs of trouble. " +
                    "The ambient noise from the haven seems to dissipate as you walk closer to the foundation tents and the guard greets you with a nod." +
                    "\n\nGuard: You again. You looking to join the foundation?";
        }
    }


    @Override
    public SitType getSitType() {
        return SitType.Dialogue;
    }

    @Override
    public String[] getOptions() {
        if(QuestPanel.questPanel.containsQuest(ScrapMetalCollection.getInstance())) {
            String[] options = {"Go back to The Haven"};
            return options;
        } else{
            String[] options = {"Talk to guard", "Go back to The Haven", "Test - Skip 2 HQ"};
            return options;
        }
    }

    @Override
    public void perform(String option) {
        switch(option) {
            case "Talk to guard":
                AdvGame.updateFrame("...", new String[]{"Yes", "No"});
                break;
            case "Go back to The Haven":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
            case "Yes":
                barPanel.setVisible(barPanel.getFoundationBar(), true);
                AdvGame.updateFrame(player.getName() + ": Yes. \n\n" + guard.getName() + ": Great! There's just some things you need to do for us first.", new String[]{"Continue"});
                break;
            case "No":
                AdvGame.updateFrame(player.getName() + ": No thanks." +
                            "\n\n" + guard.getName() + ": Well, okay... Come back if you change your mind, we're always hiring.", new String[]{"Go back to The Haven"});
                break;
            case "Continue":
                AdvGame.setSituation(FoundationIntro_1D.getInstance());
                break;
            case "Test - Skip 2 HQ":
                ScrapMetalCollection.getInstance().complete();
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
        }
    }

    @Override
    public ImageIcon getImg() {
        return null;
    }
}

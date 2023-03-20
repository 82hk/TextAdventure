package org.sherwoodhs.situation.Foundation.FoundationHQ;

import org.sherwoodhs.AdvGame;

import org.sherwoodhs.quest.Foundation.GuardQuest;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.situation.Foundation.FoundationHQ.QuestTent.FoundationQuestTent_0E;
import org.sherwoodhs.ui.InventoryPanel;

public class FoundationCommandTent_0E implements Situation {
    private static Situation situation = new FoundationCommandTent_0E();
    @Override
    public String getTitle() {
        return "The Foundation command tent";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public SitType getSitType() {
        return SitType.Interaction;
    }

    @Override
    public String[] getOptions() {
        if(GuardQuest.getInstance().isCompleted()) {
            String[] options = {"Complete quest", "Leave"};
            return options;
        } else{
            String[] options = {"Leave"};
            return options;
        }
    }

    @Override
    public void perform(String option) {
        switch(option){
            case "Leave":
                AdvGame.setSituation(FoundationHub_0E.getInstance());
                break;
            case "Complete quest":
                AdvGame.clearFrame("You tell The Captain that you finished your shift. He nods and tells you to turn in your gear. You make your way back to the armory" +
                        " and return the gear and the radio.", new String[]{"Leave"});
                InventoryPanel.inventoryPanel.removeFromInventory("Riot gear");
                InventoryPanel.inventoryPanel.removeFromInventory("Radio");
                AdvGame.removeQuest(GuardQuest.getInstance());
                GuardQuest.getInstance().reset();
                GuardQuest.getInstance().complete();
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }
}

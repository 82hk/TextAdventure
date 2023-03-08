package org.sherwoodhs.situation.Foundation.FoundationHQ;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.quest.Foundation.ScrapMetalRepeatable;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.situation.Foundation.quests.ScrapCollection;
import org.sherwoodhs.ui.QuestPanel;


public class FoundationArmory_0E implements Situation {

    private static Situation situation = new FoundationArmory_0E();


    @Override
    public String getTitle() {
        return "The Armory";
    }

    @Override
    public String getDescription() {
        return "You see scrap metal and makeshift kilns that seem to have been overused.";
    }

    @Override
    public SitType getSitType() {
        return SitType.Interaction;
    }

    @Override
    public String[] getOptions() {
        if (QuestPanel.questPanel.containsQuest(ScrapMetalRepeatable.getInstance())) {
            String[] options = {"Talk to Blacksmith", "Go back to HQ", "Complete quest"};
            return options;
        } else {
            String[] options = {"Talk to Blacksmith", "Go back to HQ"};
            return options;
        }
    }


    @Override
    public void perform(String option) {

        switch(option){
            case "Go back to HQ":
                AdvGame.setSituation(FoundationHub_0E.getInstance());
                break;
            case "Talk to Blacksmith":
                AdvGame.setSituation(FoundationBlacksmith_0E.getInstance());
                break;
            case "Complete quest":
                AdvGame.removeQuest(ScrapMetalRepeatable.getInstance());
                if(ScrapCollection.getUseless() == 10) {
                    AdvGame.updateFrame("You turn in the metal you collected from the scrap collection quest, but because you wasted more than "
                            + ScrapCollection.getUseless() + "  hours you lose " + ScrapCollection.getUseless() + " Foundation reputation.", new String[]{"Talk to Blacksmith", "Go back to HQ"});
                    World.changeStateI("Foundation Rep", -ScrapCollection.getUseless());
                } else if(ScrapCollection.getUseless() < 10 && ScrapCollection.getUseless() > 1){
                    AdvGame.updateFrame("You turn in the metal you collected from the scrap collection quest, but because you wasted "
                            + ScrapCollection.getUseless() + " hour(s) you lose " + ScrapCollection.getUseless() + " Foundation reputation.", new String[]{"Talk to Blacksmith", "Go back to HQ"});
                    World.changeStateI("Foundation Rep", -ScrapCollection.getUseless());
                } else if(ScrapCollection.getUseless()==0) {
                    AdvGame.updateFrame("You turn in the metal you collected from the scrap collection quest and since you wasted no time" +
                            " you gain 10 Foundation reputation.", new String[]{"Talk to Blacksmith", "Go back to HQ"});
                    World.changeStateI("Foundation Rep", 10);
                }
        }
    }
    public static Situation getInstance(){
        return situation;
    }
}



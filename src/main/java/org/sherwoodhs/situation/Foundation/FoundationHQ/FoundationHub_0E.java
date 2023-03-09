package org.sherwoodhs.situation.Foundation.FoundationHQ;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.player.Player;

import org.sherwoodhs.situation.Foundation.FoundationHQ.QuestTent.FoundationQuestTent_0E;
import org.sherwoodhs.situation.Foundation.FoundationHQ.armory.FoundationArmory_0E;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.situation.Foundation.quests.GuardDuty;
import org.sherwoodhs.situation.Foundation.quests.ScrapCollection;


public class FoundationHub_0E implements Situation {
    private static Situation situation = new FoundationHub_0E();
    private static boolean firstTime = true;
    Player player = Player.getInstance();
    @Override
    public String getTitle() {
        return "The Foundation HQ";
    }

    @Override
    public String getDescription() {
        if (firstTime) {

            return "Foundation Employee: Seems you're the new guy. " +
                    "This place is a hellhole but, don't worry though, we have established some safe zones for our staff. " +
                    "I'll show you around.";
        } else{
            return "Foundation employees wander around. The hub is bustling with activity and Foundation personnel. You see 3 distinct large tents with plenty of small tents " +
                    "around them.";
        }
    }

    @Override
    public SitType getSitType() {
        return SitType.Hub;
    }

    @Override
    public String[] getOptions() {
        String[] options;
        if (firstTime) {
            firstTime = false;
            options = new String[]{"Sounds Good."};
        } else {
            options = new String[]{"Go to armory tent", "Go to command tent", "Go to mess tent", "Go to quest tent", "Go back to The Haven", ""};
            if(FoundationQuestTent_0E.isScrapQuest()){
                options[5] = "Go on scrap quest";
            }
            if(FoundationQuestTent_0E.isGuardQuest()){
                options[5] = "Go on guard duty";
            }
            if(FoundationQuestTent_0E.isMessageQuest()){
                options[5] = "Deliver message";
            }
        }
        return options;
    }


    @Override
    public void perform(String option) {
        switch(option) {
            case "Go to armory tent":
                AdvGame.setSituation(FoundationArmory_0E.getInstance());
                break;
            case "Go back to The Haven":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
            case "Go to command tent":
                AdvGame.setSituation(FoundationCommandTent_0E.getInstance());
                break;
            case "Go to mess tent":
                AdvGame.setSituation(FoundationMessTent_0E.getInstance());
                break;
            case "Go to quest tent":
                AdvGame.setSituation(FoundationQuestTent_0E.getInstance());
                break;
            //TOUR
            case "Sounds Good.":
                AdvGame.updateFrame( player.getName() + ": Sounds Good. \n\n" +
                        "Foundation Employee: This way please. Our first stop is the Quest tent." +
                        " Here, you will be given tasks to help us maintain order in the store." +
                        " Some of these tasks will involve exploration, retrieval of objects, and maintenance." +
                        " It's important that you follow the instructions given to you by your supervisor and be on the lookout for any anomalous activity." +
                        " If you do good they might even move you up the ranks. Some of our finest members have started in your exact position.", new String[]{"Sure."});
                break;
            case "Sure.":
                AdvGame.updateFrame( player.getName() + ": Sure.\n\n" +
                        "Foundation Employee: Next up is our Command tent." +
                        " This is where you can find information on SCP objects, reports, and other important documents." +
                        " You can also communicate with your supervisors and fellow staff members here." +
                        " Just remember to keep the information confidential, and there will be consequences for leaking it." +
                        " Our final stop is the Mess Hall." +
                        " This is where we take our breaks and have our meals." +
                        " It's important to take breaks and rest, as working in SCP-3008 can be mentally exhausting." +
                        " We also have some entertainment options here, like books and board games, to help you pass the time.", new String[]{"Thanks for the tour."});
                break;
            case "Thanks for the tour.":
                AdvGame.setSituation(FoundationHub_0E.getInstance());
                break;

        //QUESTS
            case "Go on scrap quest":
                AdvGame.setSituation(ScrapCollection.getInstance());
                FoundationQuestTent_0E.setScrapQuest(false);
                break;
            case "Go on guard duty":
                AdvGame.setSituation(GuardDuty.getInstance());
                FoundationQuestTent_0E.setGuardQuest(false);
                break;
            case "Deliver message":
                //AdvGame.setSituation();
                break;
        }
    }


    public static Situation getInstance(){
        return situation;
    }
}

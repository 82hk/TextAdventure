package org.sherwoodhs.situation.FoundationHQ;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

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

            return "Foundation Employee: Seems your the new guy. " +
                    "This place is a hell hole but dont worry though we have established some safe zones for our staff. " +
                    "I'll show you around.";
        } else{
            return "Foundation employees wander around";
        }
    }

    @Override
    public SitType getSitType() {
        return SitType.Hub;
    }

    @Override
    public String[] getOptions() {
        if (firstTime) {
            firstTime = false;
            String[] options = {"Sounds Good"};
            return options;
        } else {
            String[] options = {"Go to armory tent", "Go to command tent", "Go to mess tent", "Go back to The Haven"};
            return options;
        }
    }

    @Override
    public void perform(String option) {
        switch(option) {
            case "Go to armory tent":

                break;
            case "Go back to The Haven":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
            case "Go to command tent":
                break;
            case "Go to mess tent":
                break;
            case "Sounds Good":
                AdvGame.updateFrame( player.getName() + ": Sounds Good \n\n" +
                        "Foundation Employee: This way please. Our first stop is the Assignment tent." +
                        " Here, you will be given tasks to help us maintain order in the store." +
                        " Some of these tasks will involve exploration, retrieval of SCP objects, and maintenance." +
                        " It's important that you follow the instructions given to you by your supervisor and be on the lookout for any anomalous activity." +
                        " If you do good they might even move you up the ranks. Some of our finest members have started in your exact position\n", new String[]{"Sure"});
                break;
            case "Sure":
                AdvGame.updateFrame( player.getName() + ": Sure \n\n" +
                        "Foundation Employee: Next up is our Headquarters." +
                        "This is where you can find information on SCP objects, reports, and other important documents." +
                        "You can also communicate with your supervisors and fellow staff members here." +
                        "Just remember to keep the information confidential." +
                        "Our final stop is the Mess Hall." +
                        "This is where we take our breaks and have our meals." +
                        "It's important to take breaks and rest, as working in SCP-3008 can be mentally exhausting." +
                        "We also have some entertainment options here, like books and board games, to help you pass the time.\n", new String[]{"Thanks for the tour"});
                break;
            case "Thanks for the tour":
                AdvGame.setSituation(FoundationHub_0E.getInstance());
                break;
        }
    }


    public static Situation getInstance(){
        return situation;
    }
}

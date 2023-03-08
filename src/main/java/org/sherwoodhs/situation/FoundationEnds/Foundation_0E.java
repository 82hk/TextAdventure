package org.sherwoodhs.situation.FoundationEnds;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.situation.BoilerRoom.BoilerRoom_0E;
import org.sherwoodhs.situation.Entrance.EntranceSituation_0E;
import org.sherwoodhs.situation.Entrance.EntranceSituation_1E;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.HiddenAlcove.HiddenAlcove1_0E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class Foundation_0E implements Situation {
    private static Situation situation = new Foundation_0E();

    @Override
    public String getTitle() {
        return "Guard duty";
    }

    @Override
    public String getDescription() {
        return "The officer ask you to Guard the door for him, telling you to make sure no one listens in on him and his colleague. Would you like to listen in?";
    }

    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Listen in.", "Don't listen."};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option) {

            // MAIN BRANCH
            case "Listen in.":
                AdvGame.updateFrame("You listen to conversation on the other side of the door, they seem to be arguing about something, and they seem very secretive, repeatedly growing loud before returning to a whisper. After about 30 min the conversation ends, and they leave, dismissing you. you notice the door is open you see a yellow folder on the desk marked \"CLASIFIED\". What do you do?",
                        new String[]{"Investigate the documents", "Confront them", "Leave in ignorance"});
                break;
            case "Don't listen.":
                AdvGame.updateFrame("You don't listen to conversation on the other side of the door, but you still hear a bit of what they say. They seem to be arguing about something, and they seem very secretive, repeatedly growing loud before returning to a whisper. After about 30 min the conversation ends, and they leave, dismissing you. you notice the door is open you see a yellow folder on the desk marked \"CLASIFIED\". What do you do?",
                        new String[]{"Investigate the documents", "Confront them", "Leave in ignorance"});
                break;
            case "I'm sure":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
            case "I'm not sure":
                AdvGame.updateFrame("What would you like to do?",
                        new String[]{"Investigate the documents", "Ask them"});
                break;
            case "Leave in ignorance":
                AdvGame.updateFrame("Are you sure? You won't get this opportunity again.",
                        new String[]{"I'm not sure", "I'm sure"});
                break;
            case "Investigate the documents":
                AdvGame.setSituation(Foundation_1E.getInstance());
                break;
            case "Confront them":
                AdvGame.updateFrame("You ask them about their conversation, they look to each-other with a worried expression. The officer glances towards your rifle and begins to speak: \"The foundation, it... It isn't the foundation.\"",
                        new String[]{"I have to tell someone!", "What does that mean?"});
                break;
            case "I have to tell someone!":
                AdvGame.updateFrame("Who would you like to tell?",
                        new String[]{"Everyone", "Clearwater", "I should reconsider", "You", "Your mom"});
                break;
            case "You":
                AdvGame.updateFrame("Thank you, but I already know that. Who else would you like to tell?",
                        new String[]{"Everyone", "Clearwater", "I should reconsider"});
                break;
            case "Your mom":
                AdvGame.updateFrame("",
                        new String[]{"Everyone", "Clearwater", "I should reconsider"});
                break;
            case "Everyone":
                AdvGame.updateFrame("You rush into the city center bringing the two officers so they can tell everyone. But before you can react the Officer shouts out, \"Guards help! He's gone mad and threatened me.\" After a brief standoff you are arrested and thrown in jail.",
                        new String[]{"The end."});
                break;
            case "Clearwater":
                AdvGame.updateFrame("You take the officers to clearwater, the boss can't decide whether or not to believe you. He eventually decides to detain you himself until clearwater can investigate the foundation. But you know that sooner or later they'll confirm what you told them.",
                        new String[]{"The end."});
                break;
            case "I should reconsider":
            case "What does that mean?":
                AdvGame.setSituation(Foundation_2E.getInstance());
                break;
            case "The end.":
                System.exit(0);
        }
    }

    public static Situation getInstance() {
        return situation;
    }
}

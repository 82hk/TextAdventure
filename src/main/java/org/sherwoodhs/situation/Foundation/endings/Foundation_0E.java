package org.sherwoodhs.situation.Foundation.endings;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class Foundation_0E implements Situation {
    private static Situation situation = new Foundation_0E();

    private Foundation_0E () {
        
    }
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
        String[] options = {"Listen in.", "Don't listen"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option) {

            // MAIN BRANCH
            case "Listen in.":
                AdvGame.updateFrame("Listen to conversation on the other side of the door, they seem to be arguing about something, and they seem very secretive, repeatedly growing loud before returning to a whisper. After about 30 min the conversation ends, and they leave, dismissing you. you notice the door is open you see a yellow folder on the desk marked \"CLASIFIED\". What do you do?",
                        new String[]{"Investigate the documents", "Ask them", "Leave in ignorance"});
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
            case "Ask them":
                AdvGame.updateFrame("You ask them about their conversation, they look to each-other with a worried expression.",
                        new String[]{"I'm not sure", "I'm sure"});
                break;
        }
    }

    public static Situation getInstance() {
        return situation;
    }
}

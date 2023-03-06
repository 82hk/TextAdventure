package org.sherwoodhs.situation.FoundationEnds;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class Foundation_1E implements Situation {
    private static Situation situation = new Foundation_1E();
    private int eats = 0;

    @Override
    public String getTitle() {
        return "Cluttered office";
    }

    @Override
    public String getDescription() {
        return "The small office is cluttered, but the classified documents aren't subtle, which strikes you as somewhat odd. With a sense of anticipation you pull a sheet of paper out of the folder. What do you do?";
    }

    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Read it", "Eat it"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option) {

            // MAIN BRANCH
            case "Read it":
                AdvGame.updateFrame("",
                        new String[]{"Investigate the documents", "Ask them", "Leave in ignorance"});
                break;
            case "Read the paper":
                AdvGame.updateFrame("Oh, Finally, ",
                        new String[]{"Investigate the documents", "Ask them", "Leave in ignorance"});
                break;
            case "Eat it":
                switch (this.eats) {
                    case 0:
                        this.eats ++;
                        AdvGame.updateFrame("Why would you do that? you’re supposed to read it not eat it.",
                                new String[]{"Read it", "Eat it"});
                    case 1:
                        this.eats ++;
                        AdvGame.updateFrame("No, it’s inedible, and important!",
                                new String[]{"Read it", "Eat it"});
                    case 2:
                        this.eats ++;
                        AdvGame.updateFrame("No, you cannot eat the paper.",
                                new String[]{"Read it", "Eat it"});
                    case 3:
                        this.eats ++;
                        AdvGame.updateFrame("No.",
                                new String[]{"Read it", "Eat it"});
                    case 4:
                        this.eats ++;
                        AdvGame.updateFrame("NO.",
                                new String[]{"Read it", "Eat it"});
                    case 5:
                        this.eats ++;
                        AdvGame.updateFrame("You’ll get a papercut.",
                                new String[]{"Read it", "Eat it"});
                    case 6:
                        this.eats ++;
                        AdvGame.updateFrame("Why? Why are you like this?",
                                new String[]{"Read the paper", "I'm just hungry!", "I'm lonely", "Why is ~YOUR MOM~ like this?", "Eat it"});
                    case 7:
                        World.changeStateI("Time", 1);
                        AdvGame.setSituation(Foundation_EAT_0E.getInstance());
                }
        }
    }

    public static Situation getInstance() {
        return situation;
    }
}



package org.sherwoodhs.situation.Entrance;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class EntranceSituation_1E implements Situation {
    private static Situation situation = new EntranceSituation_1E();

    @Override
    public String getTitle() {
        return "The Ikea - Interior";
    }

    @Override
    public String getDescription() {
        return "On cue, the automatic doors slide open. A warm breeze wafts out, mixing with the cool evening air."+
            "\n\nYou step into the store and survey your surroundings."+
            "\n\nSofas, recliners, ottomans, and every kind of furniture piece imaginable cover the floor in a carefully structured manner, "+
            "flanked by an innumerable variety of mini-display rooms. Decorative light fixtures cast soft shadows from the low exposed ceiling above, "+
            "while in the distance air conditioning fans hum quietly.\n\nThe only thing missing is people.";
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Keep going","Go to Home Depot"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Keep going":
                AdvGame.setSituation(EntranceSituation_4D.getInstance());
                break;
            case "Go to Home Depot":
                AdvGame.setSituation(EntranceSituation_3E.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

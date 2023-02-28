package org.sherwoodhs.situation.Entrance;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class EntranceSituation_5E implements Situation {
    private static Situation situation = new EntranceSituation_5E();

    @Override
    public String getTitle() {
        return "The Ikea - ???";
    }

    @Override
    public String getDescription() {
        return "The store has stopped looking recognizable now. The bathroom and kitchen tile department had always led "+
                "right to the food court, but now it joins up to—\n\nMore display rooms.\n\nAll filled with furniture. All empty of people.\n\n"+
                "This can’t be right. But with so many twists and turns to get here, is it even possible to find the way back to where you entered?";
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Keep going","Turn back"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Keep going":
                AdvGame.setSituation(EntranceSituation_6E.getInstance());
                break;
            case "Turn back":
                AdvGame.setSituation(EntranceSituation_6E.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

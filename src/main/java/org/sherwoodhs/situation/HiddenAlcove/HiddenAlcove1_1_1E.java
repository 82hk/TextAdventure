package org.sherwoodhs.situation.HiddenAlcove;


import org.sherwoodhs.AdvGame;
import org.sherwoodhs.location.OtherSide.HiddenAlcove;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.npc.OtherSide.Alchemist;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

/*
 * Basically a mini text snippet.
 */
public class HiddenAlcove1_1_1E implements Situation {
    Location location = HiddenAlcove.getInstance();

    // desc
    private static Situation situation = new HiddenAlcove1_1_1E();
    private HiddenAlcove1_1_1E() {
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String getTitle() {return "The Hidden Alcove";}

    @Override
    public String getDescription() {
        return ("The room is too dark for you to see anything. In any case, you didn't think " +
                Alchemist.getInstance().getName() + " would let you explore the area.");
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Continue"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Continue":
                AdvGame.setSituation(HiddenAlcove1_0E.getInstance());
                break;

        }
    }


    public static Situation getInstance(){
        return situation;
    }
}

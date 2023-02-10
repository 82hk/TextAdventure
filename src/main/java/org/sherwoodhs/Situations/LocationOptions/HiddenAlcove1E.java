package org.sherwoodhs.Situations.LocationOptions;


import org.sherwoodhs.AdvGame;
import org.sherwoodhs.Locations.HiddenAlcove;
import org.sherwoodhs.Locations.Location;
import org.sherwoodhs.Situations.Situation;
import org.sherwoodhs.Situations.OtherSide1.OtherSide1_0_0E;
import org.sherwoodhs.World;


public class HiddenAlcove1E implements Situation {
    Location location = HiddenAlcove.getInstance();

    // desc
    private static Situation dialogue = new HiddenAlcove1E();
    private boolean firstTime = true;
    private HiddenAlcove1E() {
        World.setStateS("Location",location.getName());
    }

    @Override
    public String getSitType() {return "Exploration";}

    @Override
    public String getTitle() {return "The Hidden Alcove";}

    @Override
    public String getDescription() {
        return ("There's a large opening hidden behind the curtain. Up until this point, you never knew that this space existed. If it weren't for the _______ telling you about the rumors, you would've passed this space everyday while ignorant.");
    }

    @Override
    public String[] getOptions() {
        String[] options;
        if (firstTime){
            firstTime = false;
            options = new String[]{"Something"};
        } else {
            options = new String[]{"Explore", "*Look*"};
        }
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Something" :
                AdvGame.setSituation(OtherSide1_0_0E.getInstance());
                break;
        }
    }


    public static Situation getInstance(){
        return dialogue;
    }
}

package org.sherwoodhs.situation.LocationOptions;


import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.location.HiddenAlcove;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.situation.OtherSide1.OtherSide1_0_0E;
import org.sherwoodhs.situation.Situation;


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
        return ("There's a large opening hidden behind the curtain.Up until this point, you never knew that this space existed." +
                "If it weren't for that Old Man telling you about the rumors, you would've passed this space everyday while remaining ignorant.\n" +
                "Hopefully, here you will find what you've been needing. Hopefully, you can the meaning of your life.");
    }

    @Override
    public String[] getOptions() {
        String[] options;
        if (firstTime){
            firstTime = false;
            options = new String[]{"Enter The Room"};
        } else {
            options = new String[]{"Explore", "*Look*"};
        }
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Enter The Room" :
                AdvGame.setSituation(OtherSide1_0_0E.getInstance());
                break;
        }
    }


    public static Situation getInstance(){
        return dialogue;
    }
}

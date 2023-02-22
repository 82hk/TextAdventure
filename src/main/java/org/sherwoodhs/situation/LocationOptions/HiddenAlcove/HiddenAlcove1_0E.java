package org.sherwoodhs.situation.LocationOptions.HiddenAlcove;


import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.location.HiddenAlcove;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.npc.Alchemist;
import org.sherwoodhs.quest.OtherSideQuest;
import org.sherwoodhs.situation.OtherSide1.OtherSide1_0D;
import org.sherwoodhs.situation.OtherSide3.OtherSide3_0D;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;


public class HiddenAlcove1_0E implements Situation {
    Location location = HiddenAlcove.getInstance();

    // desc
    private static Situation situation = new HiddenAlcove1_0E();
    private boolean firstTime = true;
    private HiddenAlcove1_0E() {
        World.setStateS("Location",location.getName()); // temp for now
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String getTitle() {return "The Hidden Alcove";}

    @Override
    public String getDescription() {
        if (firstTime){
            return ("There's a large opening hidden behind the curtain. Up until this point, you never knew that this space existed. " +
                    "If it weren't for that Old Man telling you about the rumors, you would've passed this space everyday while remaining ignorant.\n\n" +
                    "Hopefully, here you will find what you've been needing. Hopefully, you can the meaning of your life.");
        }
        return("You arrive back at the hidden alcove. Ever since you first found this place, it has been calling out for you." + 
        "You can't shake the feeling of interest you have for the room and its mysteries.");
    }

    @Override
    public String[] getOptions() {
        String[] options;
        if (firstTime){

            options = new String[]{"Enter The Room", "Leave"};
        } else {
            options = new String[]{"Explore", "Leave", "Talk to " + Alchemist.getInstance().getName()};
        }
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Enter The Room" :
                firstTime = false;
                AdvGame.setSituation(OtherSide1_0D.getInstance());
                break;
            case "Leave" :
                //AdvGame.setSituation(Location.getInstance());
                break;
            case "Explore" :
                AdvGame.setSituation(HiddenAlcove1_1_1E.getInstance());
                break;

        }
        if (option.equals("Talk to " + Alchemist.getInstance().getName())){
            //AdvGame.setSituation(AdvGame.setSituation(OtherSide3_0D.getInstance()));
        } else {
            //Some random interaction
        }
    }


    public static Situation getInstance(){
        return situation;
    }
}

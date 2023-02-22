package org.sherwoodhs.situation.IkeaEntrance;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.Dialogue;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;


/*
    This is where the player starts to notice something is up. They meet a strange character who yells at them for being so close to the edge.
*/
public class EntranceSituation_2E extends Dialogue {
    private static Situation situation = new EntranceSituation_2E();
    String name = Player.getInstance().getName();


    private String selectedOption;

    private EntranceSituation_2E()
    {
        currentOptions = new String[]{"Apologetic", "Confused", "Hostile", "Vulnerable"};
        tracker = 0;
    }

    @Override
    public String getTitle() {
        return "Bedrooms Section";
    }

    @Override
    public String getDescription() {
        return "Most of the beds seem to be missing from the display models. Dressers, curtains, nightstands, lamps, everything else you could want in a bedroom is here, except beds. Great. \n" +
                "You notice a door labeled 'Extra furniture' it doesn't say customers aren't allowed, so you head inside. \n\n" +
                "A woman on the other side of the door cries out when she sees you: \n\n'What are you doing?! How did you get to the other side of the door! You know it's not safe out there!'";
    }

    @Override
    public SitType getSitType() {return SitType.Dialogue;}


    @Override
    protected String playerStatements(String option) {
        switch (option) {
            case "Apologetic":
                return name +  ": I'm so sorry, I thought you might have more beds in here. I can just leave.";
            case "Confused":
                if(tracker==0) {
                    return name + ": What? Out there? Not safe? Where is all the furniture?";
                }
                if(tracker==1){
                    return name + ": Separatists? What on Earth are you talking about? And where is all the furniture?";
                }
            case "Follow":
                //AdvGame.setSituation();

            case "Leave":
                //AdvGame.setSituation();
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    protected void Confirm(String option) {
        //"Apologetic", "Confused", "Hostile", "Vulnerable"
        switch (option) {
            case "Apologetic":
                if (tracker == 0) {
                    currentOptions = new String[]{"Confused", "Hostile"};
                    tracker = 1;
                    AdvGame.updateFrame("'Beds? What are you talking about? Are you some sort of wandering Separatist?'", currentOptions);
                }
                break;
            case "Confused":
                if(tracker==0){
                    currentOptions = new String[]{"Follow", "Leave"};
                    tracker = 1;
                    AdvGame.updateFrame("'Close the door!' She beckons you closer. 'It's not safe out there in the beyond.'", currentOptions);
                }
            case "Hostile":
                if(tracker==0){
                    //Do
                }
            case "Vulnerable":
                if(tracker==0){
                    //Do
                }
        }
    }


    public static Situation getInstance(){
        return situation;
    }
}

package org.sherwoodhs.situation.Entrance;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.Dialogue;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;


/*
    This is where the player confirms something is up, meeting someone who guards the edge of the haven in the neutral zone
    needs to be rewritten to match new entrance plot, will do later.
*/
public class EntranceSituation_4D extends Dialogue {
    private static Situation situation = new EntranceSituation_4D();
    String name = Player.getInstance().getName();


    private String selectedOption;

    private EntranceSituation_4D()
    {
        setDescription("Most of the beds seem to be missing from the display models. Dressers, curtains, nightstands, lamps, everything else you could want in a bedroom is here, except beds. Great. \n" +
                "You notice a door labeled 'Extra furniture' it doesn't say customers aren't allowed, so you head inside. \n\n" +
                "A woman on the other side of the door cries out when she sees you: \n\n'What are you doing?! How did you get to the other side of the door! You know it's not safe out there!'",
                new String[]{"Apologetic", "Confused"}) ;
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
    protected boolean playerStatements(String option) {
        switch (option) {
            case "Apologetic":
                AdvGame.updateFrame(name +  ": I'm sorry, I thought you might have more beds in here. I'll leave.");
                return true;
            case "Confused":
                if(tracker==0) {
                    AdvGame.updateFrame(name + ": What? Out there? Not safe? Where is all the furniture?");
                    return true;
                }
                if(tracker==1){
                    AdvGame.updateFrame(name + ": Separatists? What on Earth are you talking about? And where is all the furniture?");
                    return true;
                }
                break;
            case "Hostile":
                AdvGame.updateFrame(name + ": I said I was leaving, you clearly don't have what I want anyway.");
                return true;
            case "Follow":
                //AdvGame.setSituation();
                return false;
        }
        return false;
    }

    @Override
    protected void Confirm(String option) {
        //0: "Apologetic"[1], "Confused"[2]
        //1: "Confused"[2], "Hostile"[2], follow
        //2: follow

        switch (option) {
            case "Apologetic": {
                String[] options = new String[]{"Confused", "Hostile"};
                tracker = 1;
                setDescription("'Beds? What are you talking about? Are you some sort of wandering Separatist?'", options);
                break;
            }
            case "Confused":
            case "Hostile":
            {
                String[] options = new String[]{"Follow"};
                tracker = 2;
                setDescription("'Just close the door!' She beckons you closer. 'It's not safe out there in the beyond.'", options);
                break;
            }
        }
    }


    public static Situation getInstance(){
        return situation;
    }
}

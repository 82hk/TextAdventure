package org.sherwoodhs.situation.OtherSide.OtherSide3;


import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.npc.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.player.Player;

import org.sherwoodhs.situation.Entrance.EntranceSituation_0E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

/*
   You refuse to hand over the USB and your relationship with her isn't high enough. You sentence yourself to death.
   You supposedly chose this option after hearing about the Alchemist's past from others.
   Ending
 */
public class OtherSide3_1_1End implements Situation {
    private Player player = Player.getInstance();
    private NPC alchemist = Alchemist.getInstance();
    private static Situation situation = new OtherSide3_1_1End();
    private OtherSide3_1_1End(){

    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "Refusal Hidden Alcove Ending";
    }

    @Override
    public String getDescription() {
        alchemist.changeRelModifier(-95);
        alchemist.setHostility(true);
        World.changeStateI("Deaths", 1);
        return ("You just stood there. You didn't hand over the USB to " + alchemist.getName() + ". The room immediately became tense." +
                player.getName()) + ": I'm not handing this over. There's definitely something suspicious stored in here." +
                "I can't, in good conscious, give this to you without knowing what this might do. I might not like the people here," +
                "I will not let myself be the cause of the self-destruction of the place. I've heard of you've done " + alchemist.getName() + "\n\n" +
                alchemist.getName() + " was visibly angry. She pulled out a pistol from the inner pocket of her coat and pointed it straight at you.\n\n" +
                alchemist.getName() + ": I was beginning to think you were different from others, but apparently I was wrong. You're just like the others." +
                "You idiots always disappoint others. Never do you think for yourself. If it sounds correct, you'll unite to beat up someone who can't fight back." +
                "Why can you guys never think about the truth before accepting everything that comes your way.\n\n" +
                "Her voice was choking up. At this point, her hood had fallen off. You could see tears streaming down her face.\n\n" +
                "It... never goes right for me. Goodbye " + player.getName() +
                "She pulled the trigger. A bullet went through your heart. You went down hard, bleeding out." +
                "In the last minutes before you claimed by the Grim Reaper, you could barely make out some words.\n\n" +
                alchemist.getName()+ ": I'm sorry. Perhaps we could've had a better ending, if things turned out differently.\n\n" + 
                "And with that, your world finally faded to black.";
    }

    @Override
    public SitType getSitType() {return SitType.Dialogue;}

    @Override
    public String[] getOptions() {
        return new String[]{"Try Again?", "Exit"};
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Try Again?":
                AdvGame.setSituation(EntranceSituation_0E.getInstance());
                break;
            case "Exit":
                System.exit(0);
        }
    }
}

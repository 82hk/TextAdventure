package org.sherwoodhs.situation.OtherSide.OtherSide1;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.npc.OtherSide.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;

/*
 This event occurs when you select the "nothing to return to" option in OtherSide1_0_0D.
 This only is selectable when the world basically hates you.
 Adds 5 rel to the Alchemist.
 This is one way to progress to the main storyline.
 */
public class OtherSide1_1_0D implements Situation {
    private NPC alchemist = Alchemist.getInstance();
    private Player player = Player.getInstance();
    private static Situation situation = new OtherSide1_1_0D();
    private OtherSide1_1_0D(){
    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "Two Of The Same Kind";
    }

    @Override
    public String getDescription() {
        return ("(+15 relationship with " + alchemist.getName() + ")\n\n" +
                player.getName() + ": There's nothing for me to return to.\n\n" +
                "There was no hesitation in your voice because there was no doubt that what you said was right. " +
                "The statement took " + alchemist.getName() + " by surprise. They did not expect to hear that from you. " +
                "Their demeanor relaxed, showing a moment of weakness.\n\n" +
                alchemist.getName() + ": Huh, I guess... I guess we're the same in that aspect.\n\n" +
                alchemist.getName() + " took off their hood, revealing a green-eyed woman with shoulder-length brown hair.\n\n" +
                alchemist.getName() + ": The name's Hecate. Nice to meet a fellow loner...?\n\n" +
                player.getName() + ": " + player.getName() + ". The feeling is mutual. How did you end up here?\n\n" +
                "She became immediately serious.\n\n" +
                "Hecate: It's a long story, full of some pain. Maybe time will let it heal, but that story isn't one for now." +
                "At least, not until I complete my goal...\n\n" +
                "A look of inspiration flashed across her face before being quickly replaced by doubt.\n\n" +
                "Hecate: I can't force you to do anything, but...\n\n" +
                "She put back on her hood.\n\n" +
                "Hecate: ...would you be willing to help me out with something?\n\n" +
                "You couldn't help but feel empathy. So much that you agreed, without thinking too much."
                );
    }

    @Override
    public SitType getSitType() {return SitType.Dialogue;}

    @Override
    public String[] getOptions() {
        return new String[]{"Continue"};
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Continue" :
                Alchemist.getInstance().setName("Hecate");
                AdvGame.setSituation(OtherSide1_2D.getInstance());
                break;
        }
    }

    @Override
    public ImageIcon getImg() {
        return null;
    }
}

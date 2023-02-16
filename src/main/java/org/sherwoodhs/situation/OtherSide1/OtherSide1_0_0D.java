package org.sherwoodhs.situation.OtherSide1;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.npc.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.situation.Situation;
/*
    This is where you first meet the mysterious Alchemist(At this point, known as ?????).
    This only happens on your first entrance of the Hidden Alcove.
    Really more like an introduction to questline before it is initiated.
    Leads to some options like the questline never starting or some early relationship boost.
*/
public class OtherSide1_0_0D implements Situation {
    private Player player = Player.getInstance();
    private NPC alchemist = Alchemist.getInstance();

    // desc
    private static Situation exploration = new OtherSide1_0_0D();
    private OtherSide1_0_0D() {}

    private boolean questionOption = true; //Decides if option 1 get shown as an option
    @Override
    public String getSitType() {return "Dialogue";}

    @Override
    public String getTitle() {return "An Unexpected Meeting";}

    @Override
    public String getDescription() {
        return ("As soon as you enter the room, someone jumped in front of you.\n\n" +
                alchemist.getName() + ": Not one step closer! How did you find this place?\n\n" +
                "They spoke with a strange voice. It was feminine, but you couldn't figure out more than that. " +
                "They were cloaked in a dark garment, but in the dim light, you couldn't determine what specific color it is.\n\n" +
                "You paused for a second before answering slowly.\n\n" +
                player.getName() + ": Calm down. I come in peace. An Old Man told me about this place. Said I could find ___________.\n\n" +
                alchemist.getName() + " noticeably relaxed and sighed.\n\n" +
                alchemist.getName() + ": I don't what my grandpa said to you, but he's wrong. You'll find nothing here but forsaken dreams " +
                "and lost happiness. Let me give you a piece of advice. Leave this place. Get involved with one of those factions out there. " +
                "Make friends and enemies... Win the loot of victors... Maybe find true love... I don't know what you want. " +
                "Just don't waste your time here. Lose yourself in all the stimuli of this cursed place. " +
                "The anarchy giving us the perceived freedom of choice is the only thing it's good for anyway. " +
                "Too bad seeing behind the curtain ruins everything...\n\n" +
                "Silence befell you two. It permeated the room, until you said...");
    }

    @Override
    public String[] getOptions() {
        String[] options = { "", "\"I'll take your advice and leave\"", "", ""};
        if ( true /*Some kind of really-bad reputation with everyone*/){
            options[2] = "\"There's nothing for me to return to.\"";

        }
        if (questionOption){
            options[0] = "\"What curtain?\"";
        }
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "\"There's nothing for me to return to.\"":
                alchemist.changeRelModifier(5); // Possibly here works?
                AdvGame.setSituation(OtherSide1_1_0D.getInstance());
            break;
            case "\"What curtain?\"":
                questionOption = false; // Disables this option for the future
                AdvGame.setSituation(OtherSide1_1_2D.getInstance());
            break;
            case "\"I'll take your advice and leave\"":
            //Returns back to the road(temp) LocationOption and permanently removes the option to enter the Hidden Alcove.
            break;

        }
    }


    public static Situation getInstance(){
        return exploration;
    }
}

package org.sherwoodhs.situation.OtherSide1;

import org.sherwoodhs.player.Player;
import org.sherwoodhs.npc.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.situation.Situation;
/*
    This is where you first meet the mysterious Alchemist(At this point, known as ?????).
    This only happens on your first entrance of the Hidden Alcove.
    Really more like an introduction to questline before it is initiated. 
*/
public class OtherSide1_0_0E implements Situation {
    private Player player = Player.getInstance();
    private NPC alchemist = Alchemist.getInstance();

    // desc
    private static Situation exploration = new OtherSide1_0_0E();
    private OtherSide1_0_0E() {}

    @Override
    public String getSitType() {return "Exploration";}

    @Override
    public String getTitle() {return "An Unexpected Meeting";}

    @Override
    public String getDescription() {
        return ("As soon as you enter the room, a figure jumps in front of you.\n\n" +
                alchemist.getName() + ": Not one step closer! How did you find this place?\n\n" +
                "The figure spoke with a strange voice. It was feminine, but you couldn't figure out more than that. " +
                "They are cloaked in a dark garment. In the dim light, you can't distinguish what specific color it is.\n\n" +
                "You paused for a second before answering slowly.\n\n" +
                player.getName() + ": Calm down. I come in peace. An Old Man told me about this place. Said I could find ___________.\n\n" +
                "The figure noticably relaxes and sighs." +
                alchemist.getName() + ": I don't what my grandpa said to you, but he's wrong. You'll find nothing here but forsaken dreams " +
                "and lost happiness. Let me give you a piece of advice. Leave this place. Get involved with one of those factions out there. " +
                "Make friends and enemies... Win the loot of victors... Maybe find true love... I don't know what you want. " +
                "Just don't waste your time here. Lose yourself in the stimulations of this cursed place. " +
                "The anarchy giving us the percieved freedom of choice is the only thing it's good for anyway. " +
                "Too bad seeing behind the curtain ruins everything...\n\n" +
                "Silence befalls you two. It permeates the room, until you say...");
    }

    @Override
    public String[] getOptions() {
        String[] options = { "\"\""};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){

        }
    }


    public static Situation getInstance(){
        return exploration;
    }
}

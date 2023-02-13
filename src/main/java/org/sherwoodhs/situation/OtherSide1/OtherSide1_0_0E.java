package org.sherwoodhs.situation.OtherSide1;

import org.sherwoodhs.inventory.Player;
import org.sherwoodhs.npc.Alchemist;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.situation.Situation;
/*
    This is where you first meet the mysterious Alchemist(At this point, known as ?????).
    This only happens on your first entrance of the Hidden Alcove
*/
public class OtherSide1_0_0E implements Situation {
    Player player = Player.getInstance();
    NPC alchemist = Alchemist.getInstance();

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
                "The figure spoke with a strange voice. It was feminine, but you couldn't figure out more than that." +
                "They are cloaked in a dark garment. In the dim light, you can't distinguish what specific color it is." +
                "" +
                player.getName() + ": Calm down. An Old Man told me about this place.\n\n");
    }

    @Override
    public String[] getOptions() {
        String[] options = { "*Yell*"};
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

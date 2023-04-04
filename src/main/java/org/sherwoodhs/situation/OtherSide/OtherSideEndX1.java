package org.sherwoodhs.situation.OtherSide;


import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.location.OtherSide.HiddenAlcove;
import org.sherwoodhs.npc.OtherSide.Alchemist;
import org.sherwoodhs.player.Player;

import org.sherwoodhs.situation.Entrance.EntranceSituation_0E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;

/*
   One day has passed since the USB from the alchemist was forcefully taken from you after you refused to hand it over.
   The world collapses and you don't make it.
   Ending
 */
public class OtherSideEndX1 implements Situation {
    private Player player = Player.getInstance();
    private static Situation situation = new OtherSideEndX1();
    private OtherSideEndX1(){

    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "World Destruction Ending";
    }

    @Override
    public String getDescription() {
        World.changeStateI("Deaths", 1);
        return ("Before you could do whatever you were planning to do next, the world begins to shake. " +
                "All the furniture, walls, ceiling panels, floor tiles, and doors were shaking. The lights began flickering." +
                "\n\n4" +
                "After a minute of shaking - that was when the real chaos started. It was Armageddon.\n\n" +
                "Reality began to fold upon itself. Words couldn't fully capture the warping of reality. " +
                "Gone was the euclidean geometry of your 3D world. Gone was the normal color palate you were used to. " +
                "A discordant, sharp, loud noise pierced your ears.\n\n" +
                "You took a step forward to escape this madness, but when you did, your foot appeared 10 feet in front of you, disconnected from your body. " +
                "It hurt. It made you hurt so badly that you fell over. That caused your body to fall apart, hurting so badly. " +
                "But although it really hurt, you didn't die from that. However, you couldn't move anymore. " +
                "You were forced to watch as everything around you broke down.\n\n" +
                "As you watched, you were left thinking: \"What could've caused this chaos?\" " +
                "You then realized that it was <b>you</b>, " + player.getName() + ", that brought this upon the IKEA.\n\n" +
                "If only you hadn't turned the world against you. If only you hadn't entered the " + HiddenAlcove.getInstance().getName() + ". " +
                "If only you hadn't given in to " + Alchemist.getInstance().getName() + "'s requests. If only... you had been a better person, a better friend.\n\n" +
                "There were so many what ifs, but that didn't matter now. It was all going to end. Maybe in your next life, you could do something else...\n\n" +
                "As the world finally began to corrupt to the point of complete incoherency, you let out one last sigh before it overtook you."
        );
    }

    @Override
    public SitType getSitType() {return SitType.Dialogue;}

    @Override
    public String[] getOptions() {
        return new String[]{"Try Again?", "Exit"};
    }

    @Override
    public void perform(String option) {
        World.changeStateI("Deaths", 1);
        switch (option){
            case "Try Again?":
                AdvGame.setSituation(EntranceSituation_0E.getInstance());
                break;
            case "Exit":
                System.exit(0);
        }
    }

    @Override
    public ImageIcon getImg() {
        return null;
    }
}

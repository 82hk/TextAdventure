package org.sherwoodhs.situation.Haven;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.npc.OldMan;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;
import java.util.Random;

public class OldMan_D implements Situation {
    private NPC oldMan = OldMan.getInstance();
    private Player player = Player.getInstance();
    private static Situation situation = new OldMan_D();
    private boolean firstTime = true;
    private boolean revealed = false;

    private OldMan_D(){

    }
    @Override
    public String getTitle() {
        return("Talk with the Old Man");
    }

    @Override
    public String getDescription() {
        if (firstTime) {
            firstTime = false;
            return (oldMan.getName() + ": Hello there. You seem like a new face around here. Did you happen to get stuck here too?\n\n" +
                    "You nod.\n\n" +
                    oldMan.getName() + ": Well, that's unfortunate. I hope you enjoy your stay here. It's a nice place once you get used to it."
            );
        } else if (World.getState("Renown") <= -10 && !revealed) {
            revealed = true;
            return (oldMan.getName() + ": Oh, hello there " + player.getName() + ". It's nice to see you again.\n\n" +
                    "The world might dislike you, but the old man has never changed. He's always been on your side the entire way through, no matter what you did.\n\n" +
                    player.getName() + ": ");
        } else {
            Random r = new Random();

            return "";
        }
    }

    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }

    @Override
    public String[] getOptions() {
        return(new String[]{"Continue"});
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Continue":
            AdvGame.setSituation(HavenCenter_E.getInstance());
            break;
        }
    }
    public static Situation getInstance(){
        return situation;
    }
}

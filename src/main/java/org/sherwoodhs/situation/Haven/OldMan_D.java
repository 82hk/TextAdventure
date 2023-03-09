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
        } else if (World.getState("Renown") <= -5 && !revealed) {
            revealed = true;
            HavenCenter_E.oldManGone = true;
            return (oldMan.getName() + ": Oh, hello there " + player.getName() + ". It's nice to see you again.\n\n" +
                    "The world might dislike you, but the old man has never changed. He's always been on your side the entire way through, no matter what you did.\n\n" +
                    player.getName() + ": Thank you. Thank you for all the positivity you've given me.\n\n" +
                    oldMan.getName() + ": Oh, what's wrong? You seem sad today.\n\n" +
                    player.getName() + ": I've been thinking lately. I've made enemies of almost everyone. But what am I really trying to get here?\n\n" +
                    oldMan.getName() + ": I see, so you're stuck in that hole. Here,\n\n" +
                    "He hands over a piece of paper. On it in is a little map.\n\n" +
                    player.getName() + ": If you go through the hallway over there, you can find this little place. Maybe your answers can be found there. " +
                    "Now if you'll excuse me, I need to grab some food. Have a nice day!\n\n" +
                    "The old man starts walks away. But before he could leave, you yell out to him.\n\n" +
                    player.getName() + ": Wait a minute Mister! I never got your name.\n\n" +
                    oldMan.getName() + ": Me? The people close to me call me Ouranos.\n\n" +
                    player.getName() + ": Well, thank you again Ouranos.\n\n" +
                    "The old man smiled before turning around and leaving you alone with your thoughts.");
        } else {
            Random r = new Random();
            int rand = r.nextInt(4);
            switch (rand){
                case 0:
                    return (oldMan.getName() + ": Hello again. How are you doing today?\n\n" +
                            player.getName() + ": I'm doing as fine as I can be here, I guess. How are you today?\n\n" +
                            oldMan.getName() + ": I'm doing splendid today. Thanks for asking.");
                case 1:
                    return (oldMan.getName() + ": The weather's amazing today, isn't it?\n\n" +
                            player.getName() + ": Umm, sir. We're inside an IKEA. There's no sky here. Only a roof and lights\n\n" +
                            oldMan.getName() + ": I know that. But we have to think about the positive things in life. " +
                            "We can't get rain here, so every day is a nice day. No outside force can bring unhappiness to us. " +
                            "It's acknowledging that simple fact that makes our day so much better. It's just that people don't want to step " +
                            "back and think about these things. They're always looking for more.\n\n" +
                            player.getName()+ ": O-kay?");
                case 2:
                    return ("You found the old man humming a song that sounded familiar. You listened closely, and you identified the song to be... \"I Need a Hero\"? " + 
                            "The old man had reached the end of the song when he noticed your presence.\n\n" +
                            oldMan.getName() + ": Hello there, " + player.getName() +"! What are you up to today?\n\n" +
                            player.getName() + ": Me? Nothing much planned today. Just thought I would drop by today.\n\n" +
                            oldMan.getName() + ": I'll be honest, if you had nothing else better to do, you could've simply read a book, " +
                            "explored the many secrets of this place, or maybe tried to escape here. That last one is possible, you know. " +
                            "Anything is better off than uselessly walking around. Nothing changes if you do nothing. Make every choice deliberate. " +
                            "So go out there - go enojy your youth.\n\n" +
                            "With unexpected strength for an old man, he pushed you toward the middle of the square.");
                case 3:
                    return (oldMan.getName() + ": You seem free today, talking to an inconsequential old man like me.\n\n" +
                            player.getName() + ": I wouldn't call you inconsequential. It's nice to talk to someone in this chaotic place.\n\n" +
                            "The old man just shook his head.\n\n" +
                            oldMan.getName() + ": You might think that, but I'm just here - just an observer. You on the other hand, you have " +
                            "the potential to change everything. My words can only do so much. Your actions are the determining factor to the future. " +
                            "Choosing to talk to me might be the thing that changes everything.\n\n" +
                            player.getName() + ": Come on, I'm not that arrogant.\n\n" +
                            "The old man just gave a knowing smile.\n\n" +
                            oldMan.getName() + ": You'll find out in good time...");
            }

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
        if (revealed) {
            oldMan.setName("Ouranos");
        }
        switch (option){
            case "Continue":
                World.changeStateI("Time", 1);
            AdvGame.setSituation(HavenCenter_E.getInstance());
            break;
        }
    }
    public static Situation getInstance(){
        return situation;
    }
}

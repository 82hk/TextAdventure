package org.sherwoodhs.situation.Clearwater.KioskIntro;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.location.Clearwater.ClearwaterKiosk;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.npc.TheDistributor;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class ClearwaterKiosk1_1D implements Situation {

    Player player = Player.getInstance();
    NPC distributor = TheDistributor.getInstance();
    Location location = ClearwaterKiosk.getInstance();
    private static final Situation situation = new ClearwaterKiosk1_1D();

    @Override
    public String getDescription() {
        return "You step up to the booth.\n\nUp close, you can see the old man is wearing a gray suit with a gray bowler hat. He has a thin face with a long beard"+
                " and a mustache, curled at the tips.\n\n" + distributor.getName() + ": Water card please.\n\nHe looks at you expectantly.";
    }

    @Override
    public String getTitle() {
        return "Kiosk Line";
    }

    @Override
    public SitType getSitType() {return SitType.Dialogue;}

    @Override
    public String[] getOptions() {
        return new String[]{"What?", "Lie"};
    }

    @Override
    public void perform(String option) {
        switch (option) {
            case "What?":
                AdvGame.updateFrame(distributor.getName() + ": Your water card. Per Foundation orders, Clearwater can't distribute water rations to Haven citizens unless they're regulated "+
                        "with a card. Surely you've heard about this by now. Clearwater announced it to every nook, cranny, and corner "+
                        "of the Haven weeks ago, and it's been posted here in the Center ever since.\n\nHe points to a poster on one of the nearby pillars.\n\n"+
                        distributor.getName() + ": So come now, what're you playing at? Trying to tell me you don't have it?\n\nThe old man raises a gray eyebrow.",
                        new String[]{"What??", "Lie"});
                break;
            case "Lie":
                AdvGame.updateFrame("You: I-I must have lost it. Can I get a replacement?\n\nHe shakes his head.\n\n"+
                        distributor.getName() + ": Sorry son, but you ought to know to be more careful with those things. Can't be handing out water off the books now, "+
                        "or the Boss would have a fit. All cards have to be registered with the Foundation at their office over yonder—"+
                        "\n\nHe points to a [ get description ].\n\n" + distributor.getName() + ": —and only then am I allowed to give you water.",
                        new String[]{"The Boss?", "The Foundation?", "Leave"});
                break;
            case "What??":
                AdvGame.clearFrame();
                AdvGame.updateFrame("You: What?? What are you talking about?? I just wanted to buy a [ ] but no one was in the Ikea "+
                        "and when I started looking around the store just stretched on and on like some kind of maze and none of this "+
                        "should be physically possible so WHERE ARE WE??\n\nYou pause to take a breath. The man's eyes are now wide open.\n\n"+
                        distributor.getName() + ": You-you're not...\n\nIn an instant the man is up and on the other side of the booth, pulling you along "+
                        "as he steps out from the kiosk.\n\n" + "Guard: Hey! Where are you--\n\n" + "One of the the guards takes a step. \n\n"+
                        distributor.getName() + ": Relax, Alex, We just need to sort out some business with this fellow's card.",
                        new String[]{"Placeholder"});
                break;
            case "The Boss?":
                AdvGame.updateFrame(distributor.getName() + ": Clearwater Collective's one and only warehouse manager. Not a "+
                        "particularly nice man. Now go on, get. Plenty of other Haven citizens needing water here today.",
                        new String[]{"Clearwater?", "Haven?", "Leave"});
                break;
            case "The Foundation?":
                AdvGame.updateFrame(distributor.getName() + ": Yknow, the Haven's government and security force."+
                        "\n\nHe nods to the guards standing around the water pile and kiosk pillars.\n\n"+
                        distributor.getName() + ": Those guys. Now go on, get. Plenty of other citizens need Clearwater service today.",
                        new String[]{"Clearwater?", "Haven?", "Leave"});
                break;
            case "Clearwater?":
            case "Haven?":
                AdvGame.clearFrame();
                AdvGame.updateFrame("The old man chuckles to himself.\n\n" + distributor.getName() +
                        ": C'mon kid, you're acting like you just got here or something. Now—\n\nHe gestures to a family "+
                        "standing behind you.\n\n" + distributor.getName() + ": —next!\n\nYou step away from the booth and "+
                        "walk back out into the plaza.",
                        new String[]{"Leave"});
                break;
            case "Leave":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }
}

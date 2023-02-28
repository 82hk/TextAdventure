package org.sherwoodhs.situation.Clearwater.KioskIntro;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.location.Clearwater.ClearwaterKiosk;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.npc.TheDistributor;
import org.sherwoodhs.player.Player;
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
                " and a mustache, curled at the tips.\n\n\"Water card please.\"\n\nHe looks at you expectantly.";
    }

    @Override
    public String getTitle() {
        return "Kiosk Line";
    }

    @Override
    public SitType getSitType() {return SitType.Dialogue;}

    @Override
    public String[] getOptions() {
        return new String[]{"What??", "Lie"};
    }

    @Override
    public void perform(String option) {
        switch (option) {
            case "What??":
                AdvGame.updateFrame("\"Your water card. Per Foundation orders, Clearwater can't distribute water rations to Haven citizens unless they're regulated "+
                        "with a card. Surely you've heard about this by now. Clearwater announced it to every nook, cranny, and corner "+
                        "of the Haven weeks ago, and it's been posted here in the Center ever since.\"\n\nHe points to a poster on one of the nearby pillars.\n\n"+
                        "\"So come now, what're you playing it? Trying to tell me you don't have it?\"\n\nThe old man raises a gray eyebrow.",
                        new String[]{"\"Clearwater??\"", "\"The Foundation??\"", "\"The Haven??\""});
                break;
            case "Lie":
                AdvGame.updateFrame("\"I-I must have lost it. Can I get a replacement?\" You stammer.\n\nHe shakes his head.\n\n"+
                        "\"Sorry son, but you ought to know to be more careful with those things. Can't be handing out water off the books now, "+
                        "or the Boss would have a fit. All cards have to be registered with the Foundation at their office over yonder—\""+
                        "\n\nHe points to a [ get description ].\n\n\"—and only then am I allowed to give you water.\"",
                        new String[]{"Placeholder"});
                break;
            case "\"Clearwater??\"":
                break;
            case "\"The Foundation??\"":
                break;
            case "\"The Haven??\"":
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }
}

package org.sherwoodhs.situation.Clearwater.KioskIntro;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.location.Clearwater.ClearwaterKiosk;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.npc.TheDistributor;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.Dialogue;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class ClearwaterKiosk1_3D extends Dialogue implements Situation {

    Player player = Player.getInstance();
    NPC distributor = TheDistributor.getInstance();
    Location location = ClearwaterKiosk.getInstance();
    private static Situation situation = new ClearwaterKiosk1_3D();
    public String[] getOptions() {
        switch (tracker){
            case 0: String [] options = new String[]{"\"What?\"", "Lie"}; // limit 6
            case 1:
            case 2:
            case 3:
        return options;
        }
        return null;
    }

    private ClearwaterKiosk1_3D() {
        setDescription("You step up to the booth.\n\nUp close, you can see the old man is wearing a gray suit with a gray bowler hat. He has a thin face with a long beard"+
        " and a mustache, curled at the tips.\n\n\"Water card please.\"\n\nHe looks at you expectantly.");
        String[] options = {"\"What?\"", "Lie"};
        tracker = 0;

    }
    @Override
    protected boolean playerStatements(String option) {
        tracker = 0;
        switch (option){

            case "\"What?\"": {
                tracker = 1;
                String[] options = {"\"What??\"", "Lie"};
                AdvGame.updateFrame("\"Your water card. Per Foundation orders, Clearwater can't distribute water rations to Haven citizens unless they're regulated "+
                        "with a card. Surely you've heard about this by now. Clearwater announced it to every nook, cranny, and corner "+
                        "of the Haven weeks ago, and it's been posted here in the Center ever since.\"\n\nHe points to a poster on one of the nearby pillars.\n\n"+
                        "\"So come now, what're you playing it? Trying to tell me you don't have it?\"\n\nThe old man raises a gray eyebrow.");

            }

            case "\"What??\"": {
                String[] options = {};
                AdvGame.updateFrame("");

            }

            case "Lie": {
                String[] options = {"\"The Boss?\"", "\"The Foundation?\"", "Leave"};
                AdvGame.clearFrame();
                AdvGame.updateFrame("\"I-I must have lost it. Can I get a replacement?\" You stammer.\n\nHe shakes his head.\n\n"+
                        "\"Sorry son, but you ought to know to be more careful with those things. Can't be handing out water off the books now, "+
                        "or the Boss would have a fit. All cards have to be registered with the Foundation at their office over yonder—\""+
                        "\n\nHe points to a [ get description ].\n\n\"—and only then am I allowed to give you water.\"");

            }
            case "\"The Boss?\"": {
                String[] options = {"\"Clearwater??\"","\"The Foundation??\"","\"The Haven??\""};
                AdvGame.updateFrame("");
                tracker = 1;

            }
            case "\"The Foundation??\"": {
                String[] options = {"\"Clearwater??\"","\"The Boss??\"","\"The Haven??\""};
                AdvGame.updateFrame("");
                tracker = 1;

            }
            case "\"Clearwater??\"":
            case "\"The Foundation?\"":
            case "\"The Boss??\"":
            case "\"The Haven??\"":
                if (tracker == 1) {
                    //AdvGame.setSituation(HavenCenter_E.getInstance());
                }


        }
        return false;
    }

    @Override
    protected void Confirm(String option) {

    }

    @Override
    public String getDescription() {
        return "You step up to the booth.\n\nUp close, you can see the old man is wearing a gray suit with a gray bowler hat. He has a thin face with a long beard"+
                " and a mustache, curled at the tips.\n\n\"Water card please.\"\n\nHe looks at you expectantly.";
    }

    @Override
    public String getTitle() {
        return "Kiosk Line";
    }

    public SitType getSitType() {return SitType.Dialogue;}

    public static Situation getInstance(){
        return situation;
    }
}

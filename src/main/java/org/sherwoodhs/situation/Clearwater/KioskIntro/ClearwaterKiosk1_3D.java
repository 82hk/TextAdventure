package org.sherwoodhs.situation.Clearwater.KioskIntro;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.location.Clearwater.ClearwaterKiosk;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.npc.TheDistributor;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.Dialogue;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class ClearwaterKiosk1_3D extends Dialogue {

    Player player = Player.getInstance();
    NPC distributor = TheDistributor.getInstance();
    Location location = ClearwaterKiosk.getInstance();
    private static Situation situation = new ClearwaterKiosk1_3D();

    private ClearwaterKiosk1_3D() {
        setDescription("You step up to the booth.\n\nUp close, you can see the old man is wearing a gray suit with a gray bowler hat. He has a thin face with a long beard"+
        " and a mustache, curled at the tips.\n\n\"Water card please.\"\n\nHe looks at you expectantly.");
        String[] options = new String[]{"\"What?\"", "Lie"};
        tracker = 0;

    }
    @Override
    protected boolean playerStatements(String option) {
        switch (option){
            case "\"What?\"": {
                String[] options = new String[]{"\"What??\"", "Lie"};
                AdvGame.updateFrame("");
                tracker = 1;
                return true;
            }

            case "Lie": {
                String[] options = new String[]{"\"The Boss?\"", "\"The Foundation?\"", "Leave"};
                AdvGame.updateFrame("\"I-I must have lost it. Can I get a replacement?\" You stammer.");
                tracker = 2;
                return true;
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

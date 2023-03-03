package org.sherwoodhs.situation.Clearwater.KioskIntro;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.npc.TheDistributor;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class ClearwaterKiosk1_2D implements Situation {
    NPC distributor = TheDistributor.getInstance();
    private static final Situation situation = new ClearwaterKiosk1_2D();

    @Override
    public String getTitle() {
        return "Distributor's Dialogue.";
    }

    @Override
    public String getDescription() {
        return distributor.getName() + ": I'll be back shortly.\n\nThe guard hesitates a moment, then "+
                "returns to the water pile. The old man leads you further out into the open, until you're out of earshot of any nearby people.";
    }

    @Override
    public SitType getSitType() {
        return SitType.Dialogue;
    }

    @Override
    public String[] getOptions() {
        return new String[]{"Continue"};
    }

    @Override
    public void perform(String option) {
        switch (option) {
            case "Continue":
                AdvGame.updateFrame(distributor.getName() + ": I don't know how. I thought they had blockaded all "+
                        "the passages years ago. But this place... it tends to have a mind of its own.\n\n"+ distributor.getName() +
                        ": At any rate, here you are. Our most recent Outsider. Probably the very last one.",
                        new String[]{"What?"});
                break;
            case "What?":
                AdvGame.updateFrame(distributor.getName() + ": Outsider—you come from The Outside. Earth, if you like. "+
                        "Actually, \n\n" + "He chuckles to himself.\n\n" + distributor.getName() +
                        ": not all of us are from there, either.",
                        new String[]{"..."});
                break;
            case "...":
                AdvGame.updateFrame(distributor.getName() + ": Anyways, here you are. Yes, this is an Ikea. "+
                        "The Ikea, in fact. It's constantly shifting around — you're lucking to have found an "+
                        "access point to The Haven, or you would've been toast.",
                        new String[]{"... "});
                break;
            case "... ":
                AdvGame.clearFrame();
                AdvGame.updateFrame(distributor.getName() + ": Right sorry. This is The Haven, our small island "+
                        "of safety in the middle of all that.\n\n" + distributor.getName() + ": Each of those halls "+
                        "you see stretches for about a mile adn a half. Floors 2-7 are for residential living, "+
                        "while the ground floor is for shops and general purpose. It's quite handy being stuck "+
                        "in an Ikea, you see. We have all the chairs, beds, sofas, kitchens, and bathrooms you could "+
                        "ever need, conveniently already fashionable arrangements.\n\n" + distributor.getName() +
                        ": Families tend to live together in nearby rooms, but that all is arranged and managed by "+
                        "the Foundation and boy you'll do well to stay far away from them. To be honest with you, "+
                        "nobody knows where the power for all these lights and escalators comes from. Occasionally "+
                        "there are blackouts, but things usually work out okay."+
                        "\n\nThe old man looks at a patrol of guards on the floor above scanning the plaza.",
                        new String[]{"Go on"});
                break;
            case "Go on":
                AdvGame.updateFrame(distributor.getName() + ": Especially as an Outsider. See, people talk and "+
                        "rumors spread, but officially? There is no Outside. There is only the Haven, ruled by our "+
                        "\"benevolent protectors\",\n\n" + "He rolls his eyes.\n\n" + distributor.getName() + ": the Foundation. "+
                        "Police, government, and security, with a healthy dose of paranoid secrecy. They cut off all the "+
                        "entrance points to the Beyond—the rest of the Ikea—years ago, so if they find out about you...",
                        new String[]{"[]"});
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }
}

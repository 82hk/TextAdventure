package org.sherwoodhs.situation.Clearwater.KioskIntro;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.npc.TheDistributor;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.ui.BarPanel;

import javax.swing.*;

import static org.sherwoodhs.ui.BarPanel.barPanel;

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
                barPanel.setVisible(barPanel.getHavenBar(), true);
                AdvGame.updateFrame(distributor.getName() + ": Right sorry. This is The Haven, our small island "+
                        "of safety in the middle of all that.\n\n" + distributor.getName() + ": Each of those halls "+
                        "you see stretches for about a mile and a half. Floors 2-7 are for residential living, "+
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
                        "entrance points to the Beyond—the rest of the Ikea—years ago, so if they find out about you...\n\n"+
                        distributor.getName() + ": Just stay away from them. And keep your mouth shut. As far as anyone here’s ,"+
                        "concerned, you live in a cozy closet in some forgotten corner of the Haven, "+
                        "and you don’t mean to cause any trouble.\n\nHe gives you a look.\n\n" + distributor.getName() +
                        ": Now, any other questions?",
                        new String[]{"Water?", "Exit?"});
                break;
            case "Water?":
                AdvGame.clearFrame();
                AdvGame.updateFrame(distributor.getName() + ": Oh, of course! We’ll need to get you a water card, won’t we. " +
                        "Now, the Foundation is technically supposed to have sole dominion over these cards, but us Clearwater " +
                        "employees each get our own company-issued ones too, straight from the Collective.\n\n" +
                        distributor.getName() + ": You can take your chance with the Foundation, or you can come work for us.",
                        new String[]{"Foundation", "Clearwater", "Exit?"});
                break;
            case "Exit?":
                AdvGame.clearFrame();
                AdvGame.updateFrame("You: Can’t I just slip out the way I came? I’ve got to find my way out, if I don’t " +
                        "get back home I [ motive. note: rewrite lore later ]... and the door is just right over there in the corner—" +
                        "\n\nYou glance over at the door, only to see it’s now wide open and leads to a...bathroom?" +
                        "\n\nThe old man shakes his head solemnly.\n\n" + distributor.getName() + ": No, my friend. I’m afraid there’s " +
                        "no way back now—neither to the Outside or the Beyond. Whatever path brought you here was cut, soon as you " +
                        "stepped through to the Haven. This here building’s not in the business of losing its catch. But don’t fret, " +
                        "you won’t mind it here. It’s rather a nice arrangement, once you get used to it.",
                        new String[]{"Foundation", "Clearwater", "Water?"});
                break;
            case "Foundation":
                AdvGame.updateFrame("You: I’ll try my luck with the Foundation.\n\nThe old man looks hard at you with a stern, " +
                        "almost sad, expression and then nods slowly.\n\n" + distributor.getName() + ": Well good luck.\n\n" +
                        "He turns abruptly, and begins to walk back to the kiosk with the giant water bottle.\n\n" +
                        distributor.getName() + ": Cya' round kid.",
                        new String[]{"Leave"});
                break;
            case "Clearwater":
                barPanel.setVisible(barPanel.getClearwaterBar(), true);
                AdvGame.updateFrame(distributor.getName() + ": Wonderful!\n\nThe old man's eyes light up.\n\n" +
                        distributor.getName() + ": Head on over to the Warehouse—\n\nHe points to a large bay door on the " +
                        "far side of the plaza, partially hidden under the shadow of an overhanging floor balcony.\n\n" +
                        distributor.getName() + ": —and ask to see The Boss. Tell ‘em the Distributor sent you, they’ll " +
                        "let you right in. And don’t be afraid to ask questions about the job once you’re there. Not too many " +
                        "people know what us Clearwater Collective folk actually do, so you won’t seem too suspicious.\n\n" +
                        "He shakes your hand warmly and grins, before beginning to walk back to the kiosk.\n\n" + distributor.getName() +
                        ": Cya' round kid.",
                        new String[]{"Leave"});
                break;
            case "Leave":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
        }
    }

    @Override
    public ImageIcon getImg() {
        return null;
    }

    public static Situation getInstance(){
        return situation;
    }
}

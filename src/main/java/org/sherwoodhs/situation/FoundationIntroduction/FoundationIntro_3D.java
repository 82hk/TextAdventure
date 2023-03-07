package org.sherwoodhs.situation.FoundationIntroduction;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.quest.foundation.ScrapMetalCollection;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.ui.BarPanel;
import org.sherwoodhs.ui.InventoryPanel;

public class FoundationIntro_3D implements Situation {
    private static Situation situation = new FoundationIntro_3D();
    public static Situation getInstance(){
        return situation;
    }
    private static boolean foundationIsMet = false;


    @Override
    public String getTitle() {
        return "Joining the Foundation";
    }

    @Override
    public String getDescription() {
        return "You make your way back to the guard at the booth.";
    }

    @Override
    public SitType getSitType() {
        return SitType.Dialogue;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Complete quest", "Leave"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Leave":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
            case "Complete quest":
                World.changeStateI("Foundation Rep", 5);
                InventoryPanel.inventoryPanel.addToInventory("Foundation ID Card");
                AdvGame.removeQuest(ScrapMetalCollection.getInstance());
                AdvGame.updateFrame("You show him the metal you collected from the abandon section. He takes a piece and inspects it," +
                        " before setting it down and nods approvingly.\n\n(+5 Relationship with Foundation)\n\n" +
                        "Guard: Good work, this is the type of stuff we like to see from our employees. \n\n He hands you an ID card.\n\n" +
                        "Guard: Here's an ID card. You can use it to get foundation equipment as well as get more tasks from the Foundation. " +
                        "For now you’ll just occupy entry-level jobs for the foundation but continue like this and eventually you'll be promoted.", new String[]{"What now?"});
                break;
            case "What now?":
                AdvGame.updateFrame(Player.getInstance().getName() + ": What now?\n\n" +
                        "Guard: You can head to the Foundation HQ accessible from the Haven. I'll tell them that you're coming so one of our members can give you" +
                        " a quick rundown of the place." , new String[]{"Thanks."});
                break;
            case "Thanks.":
                foundationIsMet = true;
                AdvGame.updateFrame(Player.getInstance().getName() + ": Thanks.\n\n" +
                        " Guard: Trust me, you'll fit right in, again, welcome to the Foundation!", new String[]{"Leave"});
                break;
        }
    }

    public static boolean lock() {
        return foundationIsMet;
    }
}

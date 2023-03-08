package org.sherwoodhs.situation.Foundation.FoundationIntroduction;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.quest.Foundation.ScrapMetalCollection;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class FoundationIntro_1D implements Situation {
    private static Situation situation = new FoundationIntro_1D();
    Player player = Player.getInstance();
    private static boolean unlocked = false;
    @Override
    public String getTitle() {
        return "Joining the Foundation";
    }

    @Override
    public String getDescription() {
        AdvGame.addQuest(ScrapMetalCollection.getInstance());
        return "Guard: The foundation always needs some new hands. We're looking for some scrap metal to recycle into new supplies. Just bring us 10 scrap metal pieces.";
    }

    @Override
    public SitType getSitType() {
        return SitType.Dialogue;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Where do I look?"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Where do I look?":
                AdvGame.updateFrame(player.getName() + ": Where do I look? \n\n" +
                        "Guard: There's this part of The Haven that was abandoned some time ago. They left some metal furniture there that can be dismantled and repurposed for scrap." +
                        " Barely anyone goes there, you shouldn't have a hard time gathering it. \n\n (You are now aware of the abandoned area)", new String[]{"Go back to The Haven"});
                unlocked = true;
                break;
            case "Go back to The Haven":
                AdvGame.setSituation(HavenCenter_E.getInstance());
        }
    }

    public static boolean isUnlocked() {
        return unlocked;
    }
    public static void setLocked(){
        unlocked = !unlocked;
    }

    public static Situation getInstance(){
        return situation;
    }
}

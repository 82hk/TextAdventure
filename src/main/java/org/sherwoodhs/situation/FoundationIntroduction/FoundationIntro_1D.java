package org.sherwoodhs.situation.FoundationIntroduction;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class FoundationIntro_1D implements Situation {
    private static Situation situation = new FoundationIntro_1D();
    Player player = Player.getInstance();
    @Override
    public String getTitle() {
        return "Joining the Foundation";
    }

    @Override
    public String getDescription() {
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
                        "Guard: There's this ");
                break;
        }
    }
    public static Situation getInstance(){
        return situation;
    }
}

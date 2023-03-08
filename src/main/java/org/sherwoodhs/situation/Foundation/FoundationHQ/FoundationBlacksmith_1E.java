package org.sherwoodhs.situation.Foundation.FoundationHQ;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class FoundationBlacksmith_1E implements Situation {
    private static Situation situation = new FoundationBlacksmith_0E();
    Player player = Player.getInstance();
    @Override
    public String getTitle() {
        return "The Forges";
    }

    @Override
    public String getDescription() {
        return "As you work on the makeshift kiln you add scrap pieces to the furnace." +
                "Carefully watching as they melt down into liquid metal." +
                "With a pair of tongs, you remove the molten metal from the furnace and pour it into poorly made bullet molds." +
                "Why is the foundation working with such poor equipment you think to yourself but suddenly you hear footsteps approaching behind you";
    }

    @Override
    public SitType getSitType() {
        return SitType.Interaction;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Turn Around", "Keep Working"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch(option){
            case "Turn Around":
                AdvGame.updateFrame( player.getName() + ": Whats going. \n\n " +
                                "Foundation Employee: We're running out of gunpowder. " +
                                "start making metal batons instead"
                        , new String[]{"Work on Batons"});
                break;
            case "Keep Working":
                AdvGame.updateFrame("As the footsteps draw close your hear a foundation employee tap your shoulder"
                        , new String[]{"Turn Around", "Ignore Him"});
                break;
            case "Ignore Him":
                AdvGame.updateFrame("You hear a disgruntled voice \n\n" +
                        "Foundation Employee: If you dont turn around right now I will notify senior officers about this act of insubordination"
                        , new String[]{});
                break;
            case "Walk over to the kiln":
                AdvGame.setSituation(FoundationBlacksmith_1E.getInstance());
                break;
            case "Go Back to Hub":
                AdvGame.setSituation(FoundationHub_0E.getInstance());
                break;

        }

    }
    public static Situation getInstance(){
        return situation;
    }
}

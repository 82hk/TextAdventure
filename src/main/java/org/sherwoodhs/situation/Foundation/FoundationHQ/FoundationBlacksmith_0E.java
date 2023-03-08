package org.sherwoodhs.situation.Foundation.FoundationHQ;


import org.sherwoodhs.AdvGame;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class FoundationBlacksmith_0E implements Situation {
    private static Situation situation = new FoundationBlacksmith_0E();
    Player player = Player.getInstance();
    @Override
    public String getTitle() {
        return "The Armory";
    }

    @Override
    public String getDescription() {
        return "As you approach the blacksmith you see a burly man with bulging muscles and a thick beard." +
                "the sound of hammer striking metal echoing through the tent" +
                "He's wearing a leather apron and gloves working over a hot forge." +
                "The heat from the forge causes sweat to glisten on his forehead and arms, and his face is smudged with soot." +
                "As you make your way closer he turns to you and says" +
                "Blacksmith: Are you the guy sent over to help?";
    }

    @Override
    public SitType getSitType() {
        return SitType.Interaction;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Yes I want to forge weapons", "No I came here by accident"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch(option){
            case "No I came here by accident":
                AdvGame.updateFrame( player.getName() + ": No I came here by accident. \n\n " +
                        "Blacksmith: A shame we really need more trust worthy people like you working the kilns"
                        , new String[]{"Go Back to Hub"});
                break;
            case "Yes I want to forge weapons":
                AdvGame.updateFrame( player.getName() + ": Yes I want to forge weapons. \n\n " +
                        "Blacksmith: Well perfect we needed more trust worthy people like you working the kilns. We can get you started right away"
                        , new String[]{"Walk over to the kiln"});
                break;
            case "Walk over to the kiln":
                AdvGame.setSituation(FoundationBlacksmith_1E.getInstance());
            case "Go Back to Hub":
                AdvGame.setSituation(FoundationHub_0E.getInstance());

        }
    }

    public static Situation getInstance(){
        return situation;
    }
}


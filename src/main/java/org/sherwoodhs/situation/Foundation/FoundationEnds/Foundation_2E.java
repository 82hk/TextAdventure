package org.sherwoodhs.situation.Foundation.FoundationEnds;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;

public class Foundation_2E implements Situation {
    private static Situation situation = new Foundation_2E();

    @Override
    public String getTitle() {
        return "Guard duty";
    }

    @Override
    public String getDescription() {
        return "The foundation, left, one day they just up and vanished, leaving everything behind. We, replaced them, pretended they had never left, gave people the hope that they still had contact with the outside. That's why we do what we do, because without us, the haven would devolve into anarchy. You have to trust me.";
    }

    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Trust him", "Go to clearwater"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option) {

            // MAIN BRANCH
            case "Trust him":
                AdvGame.updateFrame("You decide to continue to work for the foundation, over the next few months you are rapidly promoted, becoming one of the most powerful people in the haven, and you convince them to stop labeling their files as CLASSIFIED.",
                        new String[]{"The end."});
                break;
            case "Go to clearwater":
                AdvGame.updateFrame("You take the blueprints to clearwater, proving that the foundation has been lying to everyone. The balance of power in the haven has changed forever. Some leave the haven entirely lost in the infinite maze. Many call for the deaths of the foundations leadership. Clearwater is left as the sole political force, leaving a massive power vacuum. Crime rises sharply as foundation guards are hastily replaced with the newly founded Haven police force. ",
                        new String[]{"The end."});
                break;
            case "The end.":
                System.exit(0);
                break;

        }
    }

    @Override
    public ImageIcon getImg() {
        return null;
    }

    public static Situation getInstance() {
        return situation;
    }
}

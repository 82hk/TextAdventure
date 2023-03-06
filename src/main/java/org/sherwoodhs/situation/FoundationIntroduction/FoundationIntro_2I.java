package org.sherwoodhs.situation.FoundationIntroduction;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.quest.foundation.ScrapMetalCollection;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FoundationIntro_2I implements Situation {
    private static Situation situation = new FoundationIntro_2I();

    @Override
    public String getTitle() {
        return "Gathering scrap";
    }

    @Override
    public String getDescription() {
        return "This abandoned part of The Haven is creepy, not a single soul in sight. You decide you want to get the scrap and get out quick. Various metal furniture frames " +
                "lie in display in the mock room. You only need 10 decently sized peaces of metal.";
    }

    @Override
    public SitType getSitType() {
        return SitType.Interaction;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Nap", "Procrastinate", "Get scrap metal", "Burn some time", "Fiddle about", "Goof off"};
        return options;
    }

    private String[] shuffledOptions(){
        String[] oldOptions = getOptions();
        List<String> list = Arrays.asList(oldOptions);
        Collections.shuffle(list);
        oldOptions = list.toArray(new String[list.size()]);
        return oldOptions;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Nap":
                AdvGame.clearFrame("You feel tired and lay on one of the display beds, you doze off and awake not long after.", shuffledOptions());
                World.changeStateI("Time", 1);
                break;
            case "Procrastinate":
                AdvGame.clearFrame("You decide to sit down and not do some work, it can wait.", shuffledOptions());
                World.changeStateI("Time", 1);
                break;
            case "Get scrap metal":
                AdvGame.clearFrame("You sit down and break up some of the furniture, you grab a decently sized metal part.", shuffledOptions());
                World.changeStateI("Time", 1);

                ScrapMetalCollection.advanceQuest();
                if(ScrapMetalCollection.getTracker() == 10){
                    AdvGame.updateFrame("You have enough metal, you should leave and return to the booth. Hopefully you can be accepted into their ranks.", new String[]{"Head back to Haven"});
                }
                break;
            case "Burn some time":
                AdvGame.clearFrame("You pace back and fourth across the display room wondering about the secrets of the Ikea.", shuffledOptions());
                World.changeStateI("Time", 1);

                break;
            case "Fiddle about":
                AdvGame.clearFrame("You sit down in a chair and twiddle your thumbs.", shuffledOptions());
                World.changeStateI("Time", 1);

                break;
            case "Goof off":
                AdvGame.clearFrame("You jump on one of the display beds, and realize they arent that bouncy.", shuffledOptions());
                World.changeStateI("Time", 1);

                break;
            case "Head back to Haven":
                FoundationIntro_1D.setLocked();
                AdvGame.setSituation(HavenCenter_E.getInstance());
                World.changeStateI("Time", 1);

                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }
}

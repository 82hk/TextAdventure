package org.sherwoodhs.situation.Foundation.quests;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.quest.Foundation.ScrapMetalRepeatable;
import org.sherwoodhs.situation.Foundation.FoundationHQ.FoundationHub_0E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.situation.Foundation.FoundationHQ.FoundationHub_0E;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ScrapCollection implements Situation {
    private static Situation situation = new ScrapCollection();
    static int useless = 0;

    public static int getUseless() {
        return useless;
    }

    @Override
    public String getTitle() {
        return "Gathering scrap";
    }

    @Override
    public String getDescription() {
        useless = 0;
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
                AdvGame.clearFrameWithoutSpacing("You feel tired and lay on one of the display beds, you doze off and awake not long after.", shuffledOptions());
                World.changeStateI("Time", 1);
                useless++;
                break;
            case "Procrastinate":
                AdvGame.clearFrameWithoutSpacing("You decide to sit down and not do some work, it can wait.", shuffledOptions());
                World.changeStateI("Time", 1);
                useless++;
                break;
            case "Get scrap metal":
                AdvGame.clearFrameWithoutSpacing("You sit down and break up some of the furniture, you grab a decently sized metal part.", shuffledOptions());
                World.changeStateI("Time", 1);

               ScrapMetalRepeatable.advanceQuest();
                if(ScrapMetalRepeatable.getTracker() == 10){
                    AdvGame.updateFrame("You have enough metal, you should leave and return to the armory.", new String[]{"Head back to HQ"});
                }
                if(useless >= 10){
                    useless = 10;
                }
                break;
            case "Burn some time":
                AdvGame.clearFrameWithoutSpacing("You pace back and fourth across the display room wondering about the secrets of the Ikea.", shuffledOptions());
                World.changeStateI("Time", 1);
                useless++;
                break;
            case "Fiddle about":
                AdvGame.clearFrameWithoutSpacing("You sit down in a chair and twiddle your thumbs.", shuffledOptions());
                World.changeStateI("Time", 1);
                useless++;
                break;
            case "Goof off":
                AdvGame.clearFrameWithoutSpacing("You jump on one of the display beds, and realize they arent that bouncy.", shuffledOptions());
                World.changeStateI("Time", 1);
                useless++;
                break;
            case "Head back to HQ":
                AdvGame.setSituation(FoundationHub_0E.getInstance());
                World.changeStateI("Time", 1);
                break;
        }
    }


    public static Situation getInstance(){
        return situation;
    }
}

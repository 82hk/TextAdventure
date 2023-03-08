package org.sherwoodhs.situation.Foundation.FoundationEnds;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class Foundation_EAT_0E implements Situation {
    private static Situation situation = new Foundation_EAT_0E();

    @Override
    public String getTitle() {
        return "Hunger's Folly";
    }

    @Override
    public String getDescription() {
        return "As you finish eating the papers the officer re-enters the room.";
    }

    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"I can explain!", "Have you tried this stuff!", "[Run]"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option) {

            // MAIN BRANCH
            case "I can explain!":
                AdvGame.updateFrame("The officer stares at you expectantly. well, confused, but you should probably say something quickly",
                        new String[]{"Nutrients?", "To remove the evidence?", "I'm not sure."});
                break;
            case "Have you tried this stuff!":
                AdvGame.updateFrame("..., ..., wha?",
                        new String[]{"It’s delicious!"});
                break;
            case "[Run]":
                AdvGame.updateFrame("Where would you like to go?",
                        new String[]{"Clearwater", "City center", "The Beyond"});
                break;
            case "It’s delicious!":
            case "The end.":
                System.exit(0);
                //sitcom laugh track ending
                break;
            case "Nutrients?":
                AdvGame.updateFrame("The officer arrests you for destroying important documents, after conferming you never actually read the documents the officer has you court marshaled and dishonorably discharged, you spend the rest of your life in insignificance.",
                        new String[]{"The end."});
                break;
            case "to remove the evidence?":
                AdvGame.updateFrame("The officer scolds you for improper and frankly inexplicably odd behavior. He and his college discuss what to do with you, they eventually decide you know too much.",
                        new String[]{"The end."});
                break;
            case "I'm not sure.":
                AdvGame.updateFrame("You're not sure? You're not sure?!? Did you even read them?",
                        new String[]{"No"});
                break;
            case "No":
                AdvGame.updateFrame("Oh, well then... How about we both forget this ever happened.",
                    new String[]{"Ok"});
                break;
            case "Ok":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
            case "City center":
                AdvGame.updateFrame("Lost in the crowd you manage to escape the officer, but you'll have to change your name and disappear.",
                        new String[]{"The end."});
                break;
            case "Clearwater":
                AdvGame.updateFrame("Without any evidence of the foundations misdeeds, they turn you over to the foundation and you are arrested.",
                        new String[]{"The end."});
                break;
            case "The Beyond":
                AdvGame.updateFrame("You escape through the door you came in, back in and endless expanse of IKEA, you try to find the door that brought you to the IKEA, but the search is fruitless, and you never find your way back home.",
                        new String[]{"The end."});
                break;
        }
    }

    public static Situation getInstance() {
        return situation;
    }
}


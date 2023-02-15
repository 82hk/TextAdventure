package org.sherwoodhs.situation.entrance;

/*
The very first situation, will contain nothing but a description and 2 options
 */

import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.situation.examples.ExampleSituation;

public class EntranceSituation_0E implements Situation {
    private static Situation exploration = new EntranceSituation_0E();


    @Override
    public String getTitle() {
        return "The Entrance";
    }

    @Override
    public String getDescription() {
        return "Placeholder entrance text";
    }

    @Override
    public String getSitType() {
        return "Exploration";
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Enter the IKEA", "Leave"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Enter the IKEA":
                //setSituation(TODO);
                break;
            case "Leave":
                System.exit(0);
                break;
        }
    }

    public static Situation getInstance(){
        return exploration;
    }

}

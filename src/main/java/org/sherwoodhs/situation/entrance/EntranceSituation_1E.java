package org.sherwoodhs.situation.entrance;

import org.sherwoodhs.situation.Situation;
/*
The first situation inside the ikea
 */

public class EntranceSituation_1E implements Situation {
    private static Situation exploration = new EntranceSituation_1E();

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
        String[] options = {"placeholder"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            //TODO: implement
        }
    }

    public static Situation getInstance(){
        return exploration;
    }

}

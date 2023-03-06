package org.sherwoodhs.situation.FoundationHQ;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class FoundationQuestTent_1E implements Situation {
    private static Situation situation = new FoundationQuestTent_1E();



    @Override
    public String getTitle() {
        return "The Assignment Manager";
    }

    @Override
    public String getDescription() {
    return "\"I see you're looking for a job at the foundation, '' he says.\n" +
            "\"I’ve if you wanna stay in the foundation you’ve gotta carry your weight”\n" +
            "He goes on to explain that the foundation needs your help collecting scrap metal, food, and materials to make makeshift tents.\n" +
            "\"The first task is collecting scrap metal,\" he says, \n" +
            "\"I need someone to head out into the labyrinth of shelves and bring back as much metal as they can carry.\n" +
            "“But beware, there are dangerous creatures lurking around every corner.\"\n" +
            "\"The second task is collecting food,\" he continues, \n" +
            "\"I need someone to venture into the food court and gather as much sustenance as possible. \n" +
            "But be careful not to get lost in the endless sea of tables and chairs.\"\n" +
            "\"The third and final task is making makeshift tents,\" he says,\n" +
            "\"I need someone to gather up all the materials necessary to make some basic shelters. \n" +
            "Search the storage rooms and loading docks, but watch out for any employees who might be lurking about.\"\n" +
            "He finishes by offering a reward for each completed quest, promising a cut of the supplies and perhaps even some valuable information or even a promotion in the foundation.\n" +
            "\"So, what do you say? You lookin to make a living in this hell hole?\" he asks\n";
    }

    @Override
    public SitType getSitType() {
        return null;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Collect Scrap","Find Food","Get Materials"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch(option){
            case "Collect Scrap":
                AdvGame.setSituation(FoundationHub_0E.getInstance());
                break;
            case "Find Food":
                break;
            case "Get Materials":

                break;
        }
    }
    public static Situation getInstance(){
        return situation;
    }
}


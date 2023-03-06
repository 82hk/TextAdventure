package org.sherwoodhs.situation.FoundationHQ.QuestTent;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.FoundationHQ.FoundationHub_0E;
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
    return "Assignment Manager: I see you're looking for a job at the foundation." +
            " If you wanna stay in the foundation you’ve gotta carry your weight”\n\n" +
            "He goes on to explain that the foundation needs your help collecting scrap metal, food, and materials to make makeshift tents.\n\n" +
            "Assignment Manager: The first task is collecting scrap metal," +
            " I need someone to head out into The Haven's labyrinth of shelves and bring back as much metal as they can carry." +
            " The second task is collecting food," +
            " I need someone to venture into the food courts and gather as much sustenance as possible." +
            " The third and final task is making makeshift tents," +
            " I need someone to gather up all the materials necessary to make some basic shelters.\n\n" +
            "He finishes by offering a reward for each completed quest, promising a cut of the supplies and perhaps even some valuable information or even a promotion in the foundation.\n\n" +
            "Assignment Manager: So, what do you say? You lookin' to make a living in this hellhole?";
    }

    @Override
    public SitType getSitType() {
        return SitType.Interaction;
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


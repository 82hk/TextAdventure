package org.sherwoodhs.quest;

import org.sherwoodhs.quest.Quest;

public class StolenFurnQuest implements Quest {

    private String description;
    private boolean status;

    public StolenFurnQuest() {
        description = "The furniture bandit stole your bed. You have to get a new one for tonight.";
        status = false;
    }

    public void create()
    {
        //QuestPanel.
    }

    @Override
    public String getName() {
        return "Replacement Bed";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String newDescription) {
        description = newDescription;
    }

    @Override
    public boolean isCompleted() {
        return status;
    }

    @Override
    public void complete() {
        status = true;
    }
}

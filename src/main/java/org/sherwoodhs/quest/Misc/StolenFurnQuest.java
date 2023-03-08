package org.sherwoodhs.quest.Misc;

import org.sherwoodhs.quest.Quest;

public class StolenFurnQuest implements Quest {

    private static Quest quest = new StolenFurnQuest();
    private String description;
    private boolean completed;

    public StolenFurnQuest() {
        completed = false;
    }

    public void create()
    {
        //QuestPanel.
    }

    @Override
    public String getName() {
        return "Furniture retrieval";
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
        return completed;
    }

    @Override
    public void complete() {
        completed = true;
    }

    @Override
    public void reset() {
        completed = false;
        description = "Get the furniture back";
    }

    public static Quest getInstance(){
        return quest;
    }
}

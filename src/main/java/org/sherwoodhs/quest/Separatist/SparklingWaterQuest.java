package org.sherwoodhs.quest.Separatist;

import org.sherwoodhs.quest.Quest;

public class SparklingWaterQuest implements Quest {
    private static Quest quest = new SparklingWaterQuest();

    private String description;
    private boolean status;

    public SparklingWaterQuest() {
        description = "The Chief's daughter is very sick and requires 3 cans of sparkling water to cure her sickness.";
        status = false;
    }

    public void create()
    {
        //
    }

    @Override
    public String getName() {
        return "Sparkling Water";
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

    @Override
    public void reset() {
        status = false;
        description = "The Chief's daughter is very sick and requires 3 cans of sparkling water to cure her sickness.";
    }

    public static Quest getInstance(){
        return quest;
    }
}

package org.sherwoodhs.quest.Separatist;

import org.sherwoodhs.quest.Quest;

public class FoodMakingQuest implements Quest {
    private static Quest quest = new FoodMakingQuest();

    private String description;
    private boolean status;
    public FoodMakingQuest() {
        description = "You need to complete a customer's order.";
        status = false;
    }

    public void create()
    {
        //
    }

    @Override
    public String getName() {
        return "Make some food";
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
    }

    public static Quest getInstance(){
        return quest;
    }
}

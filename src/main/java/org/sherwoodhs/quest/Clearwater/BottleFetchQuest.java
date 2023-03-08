package org.sherwoodhs.quest.Clearwater;

import org.sherwoodhs.quest.Quest;

public class BottleFetchQuest implements Quest {
    private static Quest quest = new BottleFetchQuest();

    private String description;
    private boolean completed;

    public BottleFetchQuest() {
        description = "The man at the Clearwater kiosk told you to return with 10 plastic bottles in exchange for a water card.";
        completed = false;
    }

    public void create()
    {
        //
    }

    @Override
    public String getName() {
        return "Plastic Bottles";
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
        description = "The man at the Clearwater kiosk told you to return with 10 plastic bottles in exchange for a water card.";
    }

    public static Quest getInstance(){
        return quest;
    }
}

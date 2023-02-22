package org.sherwoodhs.quest;

public class BottleFetchQuest implements Quest {
    private static Quest quest = new BottleFetchQuest();

    private String description;
    private boolean status;

    public BottleFetchQuest() {
        description = "The man at the Clearwater kiosk told you to return with 10 plastic bottles in exchange for a water card.";
        status = false;
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
        return status;
    }

    @Override
    public void complete() {
        status = true;
    }

    public static Quest getInstance(){
        return quest;
    }
}

package org.sherwoodhs.quest.foundation;

import org.sherwoodhs.quest.Quest;

public class ScrapMetalCollection implements Quest {
    private static Quest quest = new ScrapMetalCollection();

    private static int tracker = 0;
    String description;
    private static boolean status = false;
    String name = "Foundation Initiation\nCollected scrap: " + tracker;


    @Override
    public String getName() {
        return name;
    }

    public static int getTracker() {
        return tracker;
    }

    public static void advanceQuest(){
        tracker++;
        if(tracker == 5){
            status = true;
        }
    }

    @Override
    public String getDescription() {
        description = "Collect scrap metal for the Foundation";
        return description;
    }

    @Override
    public void setDescription(String newDescription) {
        description = newDescription;
    }

    @Override
    public boolean isCompleted() {
        if(tracker == 5){
            status = true;
            return true;
        } else {
            status = false;
            return false;
        }
    }

    @Override
    public void complete() {
        status = true;
    }



    public static Quest getInstance(){
        return quest;
    }

}

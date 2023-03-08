package org.sherwoodhs.quest.Foundation;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.quest.Quest;

public class BulletBuildingQuest implements Quest {
    private static Quest quest = new BulletBuildingQuest();

    private static int tracker = 0;
    String description;
    private static boolean completed = false;


    @Override
    public String getName() {
        return "Bullet building\n    Number made: " + tracker;
    }

    public static int getTracker() {
        return tracker;
    }

    public static void advanceQuest(){
        AdvGame.removeQuest(BulletBuildingQuest.getInstance());
        tracker++;
        AdvGame.addQuest(BulletBuildingQuest.getInstance());
        if(tracker == 13){ // should this be '>='?
            completed = true;
        }
    }

    @Override
    public String getDescription() {
        description = "Make bullets for the Foundation.";
        return description;
    }

    @Override
    public void setDescription(String newDescription) {
        description = newDescription;
    }

    @Override
    public boolean isCompleted() {
        if(completed){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public void complete() {
        completed = true;
    }

    @Override
    public void reset() {
        completed = false;
        tracker = 0;
        description = "Make bullets for the Foundation.";
    }


    public static Quest getInstance(){
        return quest;
    }

}

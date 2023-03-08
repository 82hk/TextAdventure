package org.sherwoodhs.quest.Misc;

import org.sherwoodhs.npc.Alchemist;
import org.sherwoodhs.quest.Quest;

public class OtherSideQuest implements Quest {
    private static Quest quest = new OtherSideQuest();
    private String description;
    private static boolean completed;
    private static int progress = 0;

    private OtherSideQuest() {
        description = Alchemist.getInstance().getName() + " has asked you to grab her a _______ from ________.";
        completed = false;
    }

    public void create()
    {
        //Quest Panel
    }

    @Override
    public String getName() {
        return "The Other Side (" + progress + "/5)";
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
        progress = 0;
        description = Alchemist.getInstance().getName() + " has asked you to grab her a _______ from ________.";
    }

    public static void advanceQuest() {
        progress++;
        if (progress == 5) { //Progress caps at 5
            completed = true;
        }
    }
    public static int getProgress (){
        return progress;
    }
    public static Quest getInstance() {
        return quest;
    }

}

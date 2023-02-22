package org.sherwoodhs.quest;

import org.sherwoodhs.npc.Alchemist;
import org.sherwoodhs.quest.Quest;

public class OtherSideQuest implements Quest {
    private static Quest quest = new OtherSideQuest();
    private String description;
    private static boolean status;
    private static int progress = 0;

    private OtherSideQuest() {
        description = Alchemist.getInstance().getName() + " has asked you to grab her a _______ from ________.";
        status = false;
    }

    public void create()
    {
        //Quest Panel
    }

    @Override
    public String getName() {
        return "The Other Side pt." + progress;
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
    public static void advanceQuest() {
        progress++;
        if (progress == 5) { //Progress caps at 5
            status = true;
        }
    }
    public static int getProgress (){
        return progress;
    }
    public static Quest getInstance() {
        return quest;
    }

}

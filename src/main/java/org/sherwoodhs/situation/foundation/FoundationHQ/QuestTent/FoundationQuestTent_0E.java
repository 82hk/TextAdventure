package org.sherwoodhs.situation.foundation.FoundationHQ.QuestTent;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.foundation.FoundationHQ.FoundationHub_0E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class FoundationQuestTent_0E implements Situation {
    private static Situation situation = new FoundationQuestTent_0E();
    private static boolean firstTime = true;


    @Override
    public String getTitle() {
        return "The Foundation quest tent";
    }

    @Override
    public String getDescription() {
        if (firstTime) {
            return "The quest tent buzzes around you. Couriers and guards march hastily around delivering papers and receiving orders. One guy almost " +
                    "pushes you over as he stumbles by carrying a huge stack of papers. A smart-looking man with a clipboard and pencil on his ear comes up to you and introduces himself as the " +
                    "Assignment Manager.";
        } else{
            return "Assignment Manager: Hey, " + Player.getInstance().getName() + " you looking for a job to do?";
        }
    }

    @Override
    public SitType getSitType() {
        return SitType.Interaction;
    }

    @Override
    public String[] getOptions() {
        if(firstTime) {
            String[] options = {"Hi."};
            return options;
        } else {
            String[] options = {"Scrap Collection", "Guard Duty", "Courier", "Leave"};
            return options;
        }
    }

    @Override
    public void perform(String option) {
        switch(option){
            case "Leave":
                firstTime = false;
                AdvGame.setSituation(FoundationHub_0E.getInstance());
                break;
            case "Talk to assignment manager":
                break;

            //FIRSTTIME
            case "Hi.":
                AdvGame.updateFrame(Player.getInstance().getName() + ": Hi. \n\nAssignment Manager: I see you're looking for a job at the foundation. You must be the new recruit, they told me your name was " +
                        Player.getInstance().getName() + ". If you wanna stay in the foundation you’ve got to carry your weight.”\n\n" +
                        "He goes on to explain that the foundation needs your help collecting scrap metal, guarding posts, and delivering messages.\n\n" +
                        "Assignment Manager: The first task is collecting scrap metal, you've already done this but more scrap never hurt anyone.", new String[]{"..."} );
                break;
            case "...":
                AdvGame.updateFrame(
                        "Assignment Manager: Now guarding posts is a bit more taxing than just collecting plain scrap, you will sent out into The Haven to maintain order, peace" +
                                ", and security... \n\nHe almost looks valiant saying that..\n\nAssignment Manager: ...and also to guard key Foundation interests." +
                                " The third task you'll be able to do at this level is deliver messages, now that may sound mediocre but.. \n\nHis voices lowers " +
                                " and you can barely hear him above the chatter of the rest of the tent.\n\n" +
                                "Assignment Manager: Some of messages contain... sensitive.. information if you will. Now you're not permitted to read the messages, just deliver them" +
                                " but we can't monitor every courier at once so we have to trust you to not read it.", new String[]{" ..."});
                break;
            case " ...":
                AdvGame.clearFrameWithoutSpacing("He finishes by offering a reward for each completed quest, promising a warm bed, shelter, and even a promotion in the foundation.\n\n" +
                        "Assignment Manager: The Foundation looks after it's members and in return you'll need to have the back of you fellow recruits and remember," +
                        " even if you don't like or prefer what we do, it's your duty to follow orders to the letter.. " +
                        "So, what do you say? You looking' to make a living in this hellhole?", new String[]{"Scrap Collection", "Guard Duty", "Courier", "Leave"});
                break;

            //QUESTS (lvl 1 <30 rep)
            case "Scrap Collection":
                break;
            case "Guard Duty":
                break;
            case "Courier":
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }
}

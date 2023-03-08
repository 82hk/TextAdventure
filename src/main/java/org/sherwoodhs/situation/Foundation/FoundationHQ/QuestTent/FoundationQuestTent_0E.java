package org.sherwoodhs.situation.Foundation.FoundationHQ.QuestTent;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.quest.Foundation.GuardQuest;
import org.sherwoodhs.quest.Foundation.ScrapMetalRepeatable;
import org.sherwoodhs.situation.Foundation.FoundationHQ.FoundationBlacksmith_0E;
import org.sherwoodhs.situation.Foundation.FoundationHQ.FoundationHub_0E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class FoundationQuestTent_0E implements Situation {
    private static Situation situation = new FoundationQuestTent_0E();
    private static boolean firstTime = true;
    private static boolean scrapQuest = false;
    private static boolean guardQuest = false;
    private static boolean messageQuest = false;
    private static boolean armedGuardQuest = false;
    private static boolean bulletBuilding = false;
    private static boolean sraOperation = false;

    public static boolean isArmedGuardQuest() {return armedGuardQuest;}
    public static boolean isBulletBuilding() {return bulletBuilding;}
    public static boolean isGuardQuest() {return guardQuest;}
    public static boolean isMessageQuest() {return messageQuest;}
    public static boolean isScrapQuest() {return scrapQuest;}
    public static boolean isSraOperation() {return sraOperation;}

    public static void setScrapQuest(boolean scrapQuest) {FoundationQuestTent_0E.scrapQuest = scrapQuest;}
    public static void setGuardQuest(boolean guardQuest) {FoundationQuestTent_0E.guardQuest = guardQuest;}
    public static void setBulletBuilding(boolean bulletBuilding) {FoundationQuestTent_0E.bulletBuilding = bulletBuilding;}

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
            if(scrapQuest || guardQuest || sraOperation || messageQuest || armedGuardQuest || bulletBuilding) {
                return "You should probably do the the quest you have first.";
            } else {
                return "Assignment Manager: Hey, " + Player.getInstance().getName() + " you looking for a job to do?";
            }
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
            if(scrapQuest || guardQuest || sraOperation || messageQuest || armedGuardQuest || bulletBuilding){
                String[] options = {"Leave"};
                return options;
            }else {
                String[] options = {"Talk to assignment manager", "Leave"};
                return options;
            }
        }
    }

    @Override
    public void perform(String option) {
        switch(option){
            case "Back":
                scrapQuest = false;
                guardQuest = false;
                messageQuest = false;
                armedGuardQuest = false;
                bulletBuilding = false;
                sraOperation = false;
                AdvGame.setSituation(FoundationQuestTent_0E.getInstance());
                break;
            case "Leave":
                AdvGame.setSituation(FoundationHub_0E.getInstance());
                break;
            case "Talk to assignment manager":
                if(World.getState("Foundation Rep") <= 30) {
                    AdvGame.clearFrameWithoutSpacing("Assignment Manager: Hey, " + Player.getInstance().getName() + " you looking for a job to do?", new String[]{"Level 1 Quests", "Back"});
                } else if(World.getState("Foundation Rep") > 30 && World.getState("Foundation Rep") < 90){
                    AdvGame.clearFrameWithoutSpacing("Assignment Manager: Hey, " + Player.getInstance().getName() + " you looking for a job to do?", new String[]{"Level 1 Quests", "Level 2 Quests", "Back"});
                } else if(World.getState("Foundation Rep") >= 90){
                    AdvGame.clearFrameWithoutSpacing("Assignment Manager: Hey, " + Player.getInstance().getName() + " you looking for a job to do?", new String[]{"Level 1 Quests", "Level 2 Quests", "Level 3 Quests", "Back"});
                }
                break;

            //FIRSTTIME
            case "Hi.":
                AdvGame.updateFrame(Player.getInstance().getName() + ": Hi. \n\nAssignment Manager: I see you're looking for a job at the foundation. You must be the new recruit, they told me your name was " +
                        Player.getInstance().getName() + ". If you wanna stay in the foundation you’ve got to carry your weight.\n\n" +
                        "He goes on to explain that the foundation needs your help collecting scrap metal, guarding posts, and delivering messages.\n\n" +
                        "Assignment Manager: The first task is collecting scrap metal, you've already done this but more scrap never hurt anyone.", new String[]{"..."} );
                break;
            case "...":
                AdvGame.updateFrame(
                        "Assignment Manager: Now guarding posts is a bit more taxing than just collecting plain scrap, you will sent out into The Haven to maintain order, peace" +
                                ", and security... \n\nHe almost looks valiant saying that..\n\nAssignment Manager: ...and also to guard key Foundation interests." +
                                " The third task you'll be able to do at this level is deliver messages, now that may sound mediocre but.. \n\nHis voices lowers " +
                                "and you can barely hear him above the chatter of the rest of the tent.\n\n" +
                                "Assignment Manager: Some of messages contain... sensitive.. information if you will. Now you're not permitted to read the messages, just deliver them" +
                                ", but we can't monitor every courier at once so we have to trust you to not read it.", new String[]{" ..."});
                break;
            case " ...":
                firstTime = false;
                AdvGame.clearFrameWithoutSpacing("He finishes by offering a reward for each completed quest, promising a warm bed, shelter, and even a promotion in the foundation.\n\n" +
                        "Assignment Manager: The Foundation looks after it's members and in return you'll need to have the back of you fellow recruits and remember," +
                        " even if you don't like or prefer what we do, it's your duty to follow orders to the letter.. " +
                        "So, what do you say? You looking' to make a living in this hellhole?", new String[]{"Level 1 Quests", "Leave"});
                break;

            //QUESTS (lvl 1 <30 rep)
            case "Level 1 Quests":
                AdvGame.clearFrameWithoutSpacing("Assignment Manager: Hey, " + Player.getInstance().getName() + " you looking for a job to do?",new String[]{"Scrap Collection", "Guard Duty", "Courier", "Back"});
                break;
            case "Scrap Collection":
                scrapQuest = true;
                AdvGame.updateFrame(Player.getInstance().getName() + ": Tell me about the scrap collecting job. \n\n" +
                        "Assignment Manager: You've already done that but more scrap never hurt anyone." +
                        " I need someone to head out into the labyrinth of shelves and bring back as much metal as they can carry. " +
                        "Bring the metal to the armory when you are done." , new String[]{"Confirm", "Back"});
                break;
            case "Guard Duty":
                guardQuest = true;
                AdvGame.updateFrame(Player.getInstance().getName() + ": Tell me about guard duty. \n\n" +
                                "Assignment Manager: Guarding posts is a bit more taxing than just collecting plain scrap, you will sent out into The Haven to maintain order, peace" +
                                ", and security... \n\nHe almost looks valiant saying that..\n\nAssignment Manager: ...and also to guard key Foundation interests.", new String[]{"Confirm", "Back"});
                break;
            case "Courier":
                messageQuest = true;
                AdvGame.updateFrame(Player.getInstance().getName() + ": Tell me about the courier job. \n\n" +
                        "Assignment Manager: You'll deliver messages, now that may sound mediocre but.. \n\nHis voices lowers" +
                        " and you can barely hear him above the chatter of the rest of the tent.\n\n" +
                        "Assignment Manager: Some of messages contain... sensitive.. information if you will. Now you're not permitted to read the messages, just deliver them" +
                        ", but we can't monitor every courier at once so we have to trust you to not read it."  , new String[]{"Confirm", "Back"});
                break;

            //LEVEL 2 >30 <90
            case "Level 2 Quests":
                AdvGame.clearFrameWithoutSpacing("Assignment Manager: Hey, " + Player.getInstance().getName() + " you looking for a job to do?", new String[]{"Armed guard", "Bullet assembly", "Back"});
                break;
            case "Armed guard":
                break;
            case "Bullet assembly":
                AdvGame.updateFrame(Player.getInstance().getName() + ": Tell me about the bullet assembly job. \n\n" +
                        "Assignment Manager: You will be sent to the blacksmith to help assemble bullets and other gear for Foundation members to use."  , new String[]{"Confirm", "Back"});
                break;
            //LEVEL 3 90+
            case "Level 3 Quests":
                AdvGame.clearFrameWithoutSpacing("Assignment Manager: Hey, " + Player.getInstance().getName() + " you looking for a job to do?", new String[]{"SRA Operation", "Back"});
                break;
            case "SRA Operation":
                break;

            case "Confirm":
                if(scrapQuest){
                    AdvGame.addQuest(ScrapMetalRepeatable.getInstance());
                    AdvGame.setSituation(FoundationHub_0E.getInstance());
                }
                if(guardQuest){
                    AdvGame.addQuest(GuardQuest.getInstance());
                    AdvGame.setSituation(FoundationHub_0E.getInstance());
                }
                if(messageQuest){
                    AdvGame.setSituation(FoundationHub_0E.getInstance());
                }
                if(bulletBuilding){
                    //AdvGame.addQuest();
                }
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }
}

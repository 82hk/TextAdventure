package org.sherwoodhs.situation.foundation.quests;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.ui.InventoryPanel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GuardDuty implements Situation {
    private static Situation situation = new GuardDuty();
    ArrayList<String> names = new ArrayList<>();

    private int radioChannel(){
        Random random = new Random();
        return random.nextInt(9);
    }

    private void initArray(){
        names.add("Chris");
        names.add("Ken");
        names.add("Hangil");
        names.add("Derek");
        names.add("Cyrus");
        names.add("Tyler");
        names.add("Andi");
        names.add("Connor");
        names.add("Landon");
        names.add("Trenton");
        names.add("Dean");
        Collections.shuffle(names);
    }

    private String unitName1(){
        Random random = new Random();
        int i = random.nextInt(4);
        if(i==0){
            return "Alpha";
        }
        if(i==1){
            return "Beta";
        }
        if(i==2){
            return "Charlie";
        }else{
            return "Delta";
        }
    }
    private String unitName2(){
        Random random = new Random();
        int i = random.nextInt(4);
        if(i==0){
            return "Echo";
        }
        if(i==1){
            return "Foxtrot";
        }
        if(i==2){
            return "Golf";
        }else{
            return "Hotel";
        }
    }

    private String unitName(){
        Random r = new Random();
        int t = r.nextInt(30);
        return unitName1() + "-" + unitName2() + " " +t;
    }

    private void resetArray(){
        names.clear();
        initArray();
    }

    private String generateRandomNames() {

        Random rand = new Random();
        int i = rand.nextInt(names.size());
        String s = names.get(i);
        names.remove(i);
        return s;
    }

    @Override
    public String getTitle() {
        return "Guard Duty";
    }

    @Override
    public String getDescription() {
        InventoryPanel.inventoryPanel.addToInventory("Riot gear");
        return "You visit the armory to get your own locker. Inside you find a uniform, riot helmet, and a baton. You gear up and join the rest of teh guards getting" +
                " ready for their shift. A gruff-looking man in a black and red uniform marches up to the front of the armory. From the other guards you learn that" +
                " they call him The Captain.";
    }

    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Listen"};
        return options;
    }

    @Override
    public void perform(String option) {
        initArray();
        String unitName = unitName();
        String npc1 = generateRandomNames();
        String npc2 = generateRandomNames();
        String npc3 = generateRandomNames();
        String npc4 = generateRandomNames();
        switch (option){
            //START
            case "Listen":
                AdvGame.updateFrame("The Captain: Listen up men. Recently I've learned that Clearwater has been undermining Foundation control and is " +
                        " starting to oppose us in the region. I'm sure you've seen the protests. \n\nMurmurs arise from the crowd of guards.\n\n" +
                        "The Captain: Today, that comes to a stop. We are increasing Foundation presence in the area to control the water supply and..\n\n" +
                        "His face darkens and becomes even more serious.. if that's even possible.\n\nThe Captain: ..if anybody stands in your way" +
                        " force them into submission. I don't care how.", new String[]{"Continue"});
                break;
            case "Continue":
                InventoryPanel.inventoryPanel.addToInventory("Radio");
                AdvGame.clearFrameWithoutSpacing("The Captain: Shifts are 6 hours long. Move out!\n\nYou and the other guards make your way to the armory exit" +
                        " where a man with a clipboard hands out radios to each guard leaving.\n\nGuard: ID please.\n\nYou show him. He marks something off on his clipboard.\n\n" +
                        "Guard: You are in unit " + unitName + " with " + npc1 + ", " + npc2 + ", " + npc3 + ", and " +
                        npc4 + ". Your radio is on channel " + radioChannel()+".", new String[]{"Guard"});
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }
}

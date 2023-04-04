package org.sherwoodhs.situation.examples;

import org.sherwoodhs.location.Location;
import org.sherwoodhs.location.examples.ExampleLocation;
import org.sherwoodhs.npc.NPC;
import org.sherwoodhs.npc.examples.ExampleNPC;
import org.sherwoodhs.player.Player;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

import javax.swing.*;

import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;
import static org.sherwoodhs.ui.TextPanel.textPanel;

//Should IMPLEMENT Situation
public class ExampleSituation implements Situation {
    /*
    !!!!!!!NOTE!!!!!!!!
    This file's name does not follow the standard naming conventions,
    to properly name your files refer to convention.txt This is merely
    a guide for others to follow to create your own situation
     */


    /*The first thing you must do is call all the other singleton stuff you need for this example we will call the player,
    the npc ExampleNPC, and the ExampleLocation
    Not all situations will have to call other singleton classes, we are just doing this for this example
     */

    Player player = Player.getInstance();
    NPC examplenpc = ExampleNPC.getInstance();
    Location examplelocation = ExampleLocation.getInstance();


    //Now we need to override the methods from the situation superclass, fill these out with the necessary information
    private static Situation exploration = new ExampleSituation();

    @Override
    public String getTitle() {
        return "Example Situation";
    }

    @Override
    public String getDescription() {
        return "This is an example situation, wait you put here gets displayed in the textpanel, so the majority of the writing will happen here.";
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}


    //These are the options you have in the certain situation, you can only have up to six, and there is a character limit, so make each option short and concise
    @Override
    public String[] getOptions() {
        String[] options = {"Example Option", "Example Option 2", "Make NPC hostile"}; //fill with option, remember the limit of 6 options
        return options;
    }

    //Another important method, this handles the actions when the buttons are pressed
    //Should be a switch case
    @Override
    public void perform(String option) {
        switch (option){
            case "Example Option":
                textPanel.addText("Some text that gets displayed to the screen. \n Wow! A new line!");
                break;
            case "Example Option 2":
                textPanel.addText("Hi, my name is: " + examplenpc.getName() + " and my happiness is: " + examplenpc.getHappiness() + ". Here's a ruler." +
                        "\n Your name is: " + player.getName());
                inventoryPanel.addToInventory("Ruler");
                break;
            case "Make NPC hostile":
                examplenpc.setHostility(true);
                if(examplenpc.getHostility()){
                    textPanel.addText("I am hostile");
                } else {
                    textPanel.addText("I am not hostile");
                    break;
            }
        }
    }

    @Override
    public ImageIcon getImg() {
        return null;
    }

    //and remember to add the getInstance method!
    public static Situation getInstance(){
        return exploration;
    }

}

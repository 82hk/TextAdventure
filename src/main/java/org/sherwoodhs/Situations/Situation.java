package org.sherwoodhs.Situations;

import org.sherwoodhs.Locations.Location;
import org.sherwoodhs.World;
import org.sherwoodhs.inventory.Inventory;

//Singleton stuff will be done in each separate singleton

public abstract class Situation {
    //Accesses Singletons
    //protected JFrame frame = Frame.getInstance();
    protected Inventory inv = Inventory.getInstance();
    protected World world = World.getInstance();

    //Information specific to Situation
    protected Location location;
    protected String name;
    protected String text;
    protected String[] obsButtonText = {"","","","","",""};
    protected String[] absButtonText = {"","","","","",""};

    protected Situation(String name, String text, String[] absButtonText, Location location){
        this.name = name;
        this.text = text;
        this.absButtonText = absButtonText;
        this.location = location;
    }

    // When this situation is called, updates frame
    protected static void changeFrame(){
        //To Implement Here
    }

    //Checks Certain Conditions to remove options from absButtonText to get the observed Buttons
    protected void checkPossibles(){
        //Natural State of Nothing to Check
    }

    //Accesses Methods to do something based on Button Pressed. Uses values and corresponding button of Absolute Button texts
    public void doEffect(String bText){
        if (bText != ""){
            if (absButtonText[0] == bText){
                buttonEffect1();
            }
            if (absButtonText[1] == bText){
                buttonEffect2();
            }
            if (absButtonText[2] == bText){
                buttonEffect3();
            }
            if (absButtonText[3] == bText){
                buttonEffect4();
            }
            if (absButtonText[4] == bText){
                buttonEffect5();
            }
            if (absButtonText[5] == bText){
                buttonEffect6();
            }

        }
    }

    //Overide with needed effects for all absolute Buttons
    protected void buttonEffect1() {}
    protected void buttonEffect2() {}
    protected void buttonEffect3() {}
    protected void buttonEffect4() {}
    protected void buttonEffect5() {}
    protected void buttonEffect6() {}

}

package org.sherwoodhs.Situations.Dialouges;


import org.sherwoodhs.Locations.TestingLocation;
import org.sherwoodhs.NPCS.TestingDummy;
import org.sherwoodhs.Situations.Situation;

public class TestingDialouge extends Dialouge{
    private static Situation dialouge = new TestingDialouge();
    private TestingDialouge(){
        super("Testing Dialouge","This is some example text", new String[]{"Option 1", "Option 2", "Option 3","","",""}, TestingLocation.getInstance(),TestingDummy.getInstance());
    }

    @Override
    protected void checkPossibles() {
        //Do something else, but override
    }

    @Override
    protected void buttonEffect1() {
        super.buttonEffect1();
    }

    @Override
    protected void buttonEffect2() {
        super.buttonEffect2();
    }

    @Override
    protected void buttonEffect3() {
        super.buttonEffect3();
    }
    public static Situation getInstance(){
        changeFrame();
        return dialouge;
    }
}

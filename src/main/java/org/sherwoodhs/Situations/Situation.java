package Situations;

import javax.swing.*;

public abstract class Situation {
    protected JFrame frame = Frame.getInstance();
    protected Inventory inv = Inventory.getInstance();
    protected World world = World.getInstance();

    protected Location location;

    protected String name;
    protected String text;
    protected String[] obsButtonText = {"","","","","",""};
    protected String[] absButtonText = {"","","","","",""};
    protected Situation situation;

    public abstract void changeFrame();

    protected void checkPossibles(){}

    public void doEffect(String bText){
        if (bText != ""){
            if (obsButtonText[0] == bText){
                buttonEffect1();
            }
            if (obsButtonText[1] == bText){
                buttonEffect2();
            }
            if (obsButtonText[2] == bText){
                buttonEffect3();
            }
            if (obsButtonText[3] == bText){
                buttonEffect4();
            }
            if (obsButtonText[4] == bText){
                buttonEffect5();
            }
            if (obsButtonText[5] == bText){
                buttonEffect6();
            }

        }
    }
    protected void buttonEffect1() {}
    protected void buttonEffect2() {}
    protected void buttonEffect3() {}
    protected void buttonEffect4() {}
    protected void buttonEffect5() {}
    protected void buttonEffect6() {}
    
    protected Situation getInstance(){
        return(situation);
    }
}

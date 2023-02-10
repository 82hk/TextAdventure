package org.sherwoodhs.situation.OtherSide1;


import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.situation.Testing.TestCombat1.TestCombat1_0C;

import static org.sherwoodhs.ui.TextPanel.textPanel;

/*
    This is where you first meet the mysterious Alchemist(At this point, known as ?????).
    This only happens on your first entrance of the Hidden Alcove
*/
public class OtherSide1_0_0E implements Situation {

    // desc
    private static Situation exploration = new OtherSide1_0_0E();
    private OtherSide1_0_0E() {}

    @Override
    public String getSitType() {return "Exploration";}

    @Override
    public String getTitle() {return "A Starting Conversation";}

    @Override
    public String getDescription() {
        return "You are in front of the building.";
    }

    @Override
    public String[] getOptions() {
        String[] options = {"Hello, traveler", "*Yell*"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "*Yell*" :
                textPanel.addText("LOLOL\nOLOLOL");
                break;
            case "Hello, traveler" :
                AdvGame.setSituation(TestCombat1_0C.getInstance());
                break;
        }
    }


    public static Situation getInstance(){
        return exploration;
    }
}

package org.sherwoodhs.Situations.Testing.TestConversation1;


import org.sherwoodhs.AdvGame;
import org.sherwoodhs.Situations.Situation;
import org.sherwoodhs.Situations.Testing.TestCombat1.TestCombat1_0C;

import static org.sherwoodhs.ui.TextPanel.textPanel;

public class TestConversation1_0D implements Situation {

    // desc
    private static Situation dialogue = new TestConversation1_0D();
    private TestConversation1_0D() {}

    @Override
    public String getSitType() {return "Dialogue";}

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
        return dialogue;
    }
}

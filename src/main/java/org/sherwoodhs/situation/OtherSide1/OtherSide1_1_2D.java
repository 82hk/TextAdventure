package org.sherwoodhs.situation.OtherSide1;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Situation;

/*
 You essentially ask a question to the Alchemist, get a vague answer and return back to Otherside1_0_0D
 Nothing much happens except for removing this option from OtherSide1_0_0D

 */
public class OtherSide1_1_2D implements Situation {
    private static Situation situation = new OtherSide1_1_2D();
    private OtherSide1_1_2D(){

    }
    public static Situation getInstance() {
        return situation;
    }

    @Override
    public String getTitle() {
        return "Inquiry";
    }

    @Override
    public String getDescription() {
        return ("");
    }

    @Override
    public String getSitType() {
        return "Dialogue";
    }

    @Override
    public String[] getOptions() {
        return new String[]{"Continue"};
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Continue" :
                AdvGame.setSituation(OtherSide1_0_0D.getInstance());
                break;
        }
    }
}

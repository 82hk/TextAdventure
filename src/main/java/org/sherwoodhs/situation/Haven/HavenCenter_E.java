package org.sherwoodhs.situation.Haven;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Clearwater.KioskIntro.ClearwaterKiosk1_0E;
import org.sherwoodhs.situation.FoundationIntroduction.FoundationIntro_1D;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class HavenCenter_E implements Situation {

    private static Situation situation = new HavenCenter_E();
    private static boolean firstTime = true;

    @Override
    public String getTitle() {
        return "Haven Center";
    }

    @Override
    public String getDescription() {
        return "You are in the city center of The Haven.\n\nIn the center of the plaza stands one especially large kiosk. It's round, with polished white pillars "+
                "supporting a sky-blue dome. A massive model water bottle sits on top of the dome rotating slowly, while beneath a long line of people stretches out from the kiosk.";
    }

    @Override
    public SitType getSitType() {
        return SitType.Hub;
    }

    @Override
    public String[] getOptions() {
        if (firstTime) {
            String[] options = {"Booth", "Kiosk"};
            firstTime = false;
            return options;
        } else {
            String[] options = {"Foundation Booth", "Clearwater Kiosk"};
            return options;
        }
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Foundation Booth":
            case "Booth":
                AdvGame.setSituation(FoundationIntro_1D.getInstance());
                break;
            case "Clearwater Kiosk":
            case "Kiosk":
                AdvGame.setSituation(ClearwaterKiosk1_0E.getInstance());
                break;
        }

    }
    public static Situation getInstance(){
        return situation;
    }
}

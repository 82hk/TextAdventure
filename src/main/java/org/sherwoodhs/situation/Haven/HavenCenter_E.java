package org.sherwoodhs.situation.Haven;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Clearwater.KioskIntro.ClearwaterKiosk1_0E;
import org.sherwoodhs.situation.foundation.FoundationHQ.FoundationHub_0E;
import org.sherwoodhs.situation.foundation.FoundationIntroduction.FoundationIntro_0D;
import org.sherwoodhs.situation.foundation.FoundationIntroduction.FoundationIntro_1D;
import org.sherwoodhs.situation.foundation.FoundationIntroduction.FoundationIntro_2I;
import org.sherwoodhs.situation.foundation.FoundationIntroduction.FoundationIntro_3D;
import org.sherwoodhs.situation.HavenHubHallway;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class HavenCenter_E implements Situation {

    private static Situation situation = new HavenCenter_E();
    private static boolean firstTime = true;

    public static boolean oldManGone = false;
    @Override
    public String getTitle() {
        if (firstTime) {
            return "???";
        } else {
            return "The Center";
        }
    }

    @Override
    public String getDescription() {
        if (firstTime) {
            return "You are in the plaza.\n\nIn the center of the plaza stands one especially large kiosk. It's round, with polished white pillars supporting a blue tiled dome. A massive model water bottle sits on top of the dome, rotating slowly\n\nA long line of people stretches out from the kiosk across the plaza floor."+
                    "\n\n[ Foundation description ]"+
                    "\n\n[ Misc. ]";
        } else {
            return "You return to the Center of the Haven."+
                    "\n\n[ Foundation ]"+
                    "\n\n[ Clearwater ]"+
                    "\n\n[ Misc. ]";
        }
    }

    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }

    @Override
    public String[] getOptions() {
        if(firstTime) {
            String[] options = {"Approach the booth","Approach the kiosk"};
            firstTime = false;
            return options;
        } else {
            String[] options = new String[]{"Foundation Booth","Clearwater Kiosk", "Separatist Hub", "", "Talk to an Old Man"};
            if(FoundationIntro_1D.isUnlocked()) {
                options[3] = "Abandoned displays";
                return options;
            } if(FoundationIntro_3D.lock()) {
                options[0] = "Foundation HQ";
                return options;
            }
            if (oldManGone){
                options[4] = "";
            }
            return options;
        }
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Foundation Booth":
            case "Approach the booth":
                AdvGame.setSituation(FoundationIntro_0D.getInstance());
                break;
            case "Clearwater Kiosk":
            case "Approach the kiosk":
                AdvGame.setSituation(ClearwaterKiosk1_0E.getInstance());
                break;
            case "Separatist Hub":
                AdvGame.setSituation(HavenHubHallway.getInstance());
                break;
            case "Abandoned displays":
                AdvGame.setSituation(FoundationIntro_2I.getInstance());
                break;
            case "Foundation HQ":
                AdvGame.setSituation(FoundationHub_0E.getInstance());
                break;
            case "Talk to an Old Man":
                AdvGame.setSituation(OldMan_D.getInstance());
                break;
        }
    }
    public static Situation getInstance(){
        return situation;
    }
}

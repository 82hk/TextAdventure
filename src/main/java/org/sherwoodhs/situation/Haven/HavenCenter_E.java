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
            return "You return to the Center of the Haven. There is an Old Man sitting on a chair in the corner of the haven."+
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
            if(FoundationIntro_1D.isUnlocked()) {
                String[] options = {"Foundation Booth", "Clearwater Kiosk", "Separatist Hub", "Abandoned displays", "Talk to the Old Man"};
                return options;
            } if(FoundationIntro_3D.lock()) {
                String[] options = {"Foundation HQ", "Clearwater Kiosk", "Separatist Hub", "Talk to the Old Man"};
                return options;
            } else {
                String[] options = {"Foundation Booth", "Clearwater Kiosk", "Separatist Hub", "Talk to the Old Man"};
                return options;
            }
        }
    }

    @Override
    public void perform(String option) {
        switch (option){
            case "Foundation Booth":
                AdvGame.setSituation(FoundationIntro_0D.getInstance());
                break;
            case "Approach the booth":
                AdvGame.setSituation(FoundationIntro_0D.getInstance());
                break;
            case "Clearwater Kiosk":
                AdvGame.setSituation(ClearwaterKiosk1_0E.getInstance());
                break;
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
            case "Talk to Old Man":
                AdvGame.setSituation(OldMan_D.getInstance());
                break;
        }
    }
    public static Situation getInstance(){
        return situation;
    }
}

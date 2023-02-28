package org.sherwoodhs.situation.Haven;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Clearwater.KioskIntro.ClearwaterKiosk1_0E;
import org.sherwoodhs.situation.FoundationIntroduction.FoundationIntro_0D;
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
        if (firstTime) {
            return "You step through the door and into the massive open expanse of a mall.\n" +
                    "\n" +
                    "Or at least, something resembling a mall. Many floors high and hundreds of feet across, the colossal room is lined with more Ikea furniture and showroom displays on every level.\n" +
                    "\n" +
                    "High up above, countless industrial ceiling-mounted lights cast a uniform yellow glow across the scene, while along the perimeter dozens of escalators connect the floors together. Down in the center of it all, kiosks and booths litter the ground floor.\n" +
                    "\n" +
                    "Most strikingly of all—people. Thousands of them, everywhere. Milling about, talking at booths, going between floors, filling the whole of the plaza with indistinct chatter. Yet no one seems to be shopping. Rather than browsing the showrooms, these people appear to be living in them, using the mock home displays of living rooms and kitchens and dining areas that line the walls of the plaza for their actual purpose. \n" +
                    "\n" +
                    "Everything in sight bears the familiar look and feel of an Ikea department store but there are no employees to be seen, only this vast crowd interspersed by scattered groups of mall security guards roaming about." +
                    "\n\nStepping forward, you see this vast chamber is actually created by the joining of four enormous halls in the shape of an ‘X’, each as tall as the room itself and with just as many floors, stretching far into the distance and out of sight.\n" +
                    "\n" +
                    "You are on the ground floor.\n" +
                    "\n" +
                    "You feel rather small.";
        } else {
            return "You are in the Center of the Haven";
        }
    }

    @Override
    public SitType getSitType() {
        return SitType.Hub;
    }

    @Override
    public String[] getOptions() {
        if(firstTime) {
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
                AdvGame.setSituation(FoundationIntro_0D.getInstance());
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

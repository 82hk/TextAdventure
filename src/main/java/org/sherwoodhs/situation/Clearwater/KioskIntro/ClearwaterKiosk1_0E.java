package org.sherwoodhs.situation.Clearwater.KioskIntro;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class ClearwaterKiosk1_0E implements Situation {
    
    // REVERT EVERYTHING TO EXPLORATION TYPE, MAKE INDIVIDUAL CLASSES FOR EVERY OPTION (maybe with adding previous text in backwards).
    private static boolean firstTime = true;
    private static Situation situation = new ClearwaterKiosk1_0E();

    @Override
    public String getTitle() {
        return "Kiosk";
    }

    @Override
    public String getDescription() {
        if (firstTime == true) {
            return "Inside the circle of pillars, an old man sits at a booth. Behind him are dozens of packages of plastic water bottles, stacked high up to the domed ceiling."+
                    "\n\nMore security guards patrol the kiosk, guarding the bottled water pile and distributing individual bottles to the line of people at the old man's orders.";
        } else {
            return "[ Placeholder ]";
        }
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Get in line","Leave"}; // limit 6
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){

            // MAIN BRANCH
            case "Get in line":
                if (firstTime) {
                    AdvGame.updateFrame("You step into the back of the line.\n\nIn front of you a woman clutches her daughter's hand, muttering to herself and glancing ahead nervously, while the little girl waves at you with an empty bottle.\n\nThe line shuffles forward.",
                            new String[]{"Wait","Leave"});
                } else {
                    AdvGame.updateFrame("You step into the line of people.",
                            new String[]{"Wait","Leave"});
                }
                break;
            case "Wait":
                if (firstTime) {
                    AdvGame.updateFrame("You wait as the line of people slowly moves closer to the kiosk.\n\nOnly ten people to go.\n\nThen seven.\n\nThen five.\n\nThen two.\n\nThe woman steps up to the booth, pulling along her daughter. The old man greets them warmly and takes a small card from the woman. He marks something on a desk behind the booth and turns to one of the guards, who in turn hands a package of water bottles to the woman. She looks at the stack of bottled water behind the booth then turns to look at the old man, seeming to grow agitated. The old man shakes his head solemnly, while the guard steps in between to escort her away from the kiosk.\n\nThe old man sighs and sits back down, then gestures to you.",
                            new String[]{"Approach","Leave"});
                } else {
                    AdvGame.updateFrame("The line shuffles forward, until finally it's your turn.\n\nThe old man gestures to you.",
                            new String[]{"Approach","Leave"});
                }
                break;

            case "Approach":
                AdvGame.setSituation(ClearwaterKiosk1_1D.getInstance());

            // EXIT POINT
            case "Leave":
                firstTime = false;
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

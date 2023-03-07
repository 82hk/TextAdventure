package org.sherwoodhs.situation.BoilerRoom.Abyss.Canyon;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.BoilerRoom.Abyss.Mines.CopperCave_E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class Aquifer_E implements Situation {
    boolean firstTime = true;
    boolean wentBack = false;
    boolean cameBack = false;
    boolean firstTimeClimbingBoulder = true;
    private static Situation situation = new Aquifer_E();
    @Override
    public String getTitle() {
        return "???";
    }
    @Override
    public String getDescription() {
        if (cameBack) {
            cameBack = false;
            return "You come back to the ash-contaminated lake. You dip your fingers in experimentally, and when you take them out, they're covered in wet gray dust.";
        }
        if (wentBack) {
            wentBack = false;
            return "You drop down from the clear boulder. A rope ladder hangs in front of you, and leads up to the cave with the copper-like ore.";
        }
        if (firstTime) {
            return "You can’t quite see how far the hole goes… but might as well try. " +
                    "You dangle your legs into the hole, and drop yourself downwards. Quickly, as you gain speed in the darkness, you realize that you might have made an idiotic mistake. " +
                    "However, before you can really imagine your fate, you fall into some kind of body of water with a splash… only that the splash only sounds like a muffled roar. " +
                    "As you stand up, you try to regain your bearings. It feels like there’s some kind of pressure applied to your ears… it might be because you are deep in the ground. \n" +
                    "You take a deep breath and look around. " +
                    "The opening to the massive pit you saw on the outcropping you almost ran off of before stretches out above you, " +
                    "its soft blue glow an echo of the lanterns you’ve come to rely on until now. You must be extremely deep in the earth… " +
                    "what was a massive opening that was approximately the size of a school is now the size of a small lawn. " +
                    "You can also faintly see the hole that you fell through, realizing now that there was a rope ladder that you could have used. " +
                    "You’ll keep that in mind for the future… at least you can get back up now.\n" +
                    "On the ground, you see that you’ve landed in a massive but extremely shallow lake, " +
                    "softly illuminated by massive clear boulders of crystal. " +
                    "Looking further into the darkness, " +
                    "there seems to be more lakes like the one you fell in, " +
                    "leading down like a staircase.";
        }
        return "You carefully climb down the rope ladder into the hole surrounded by infinite darkness. " +
                "You jump off the ladder as you reach the base, " +
                "and land in a massive but shallow lake with a muffled splash. " +
                "The depth might be affecting your hearing somehow. " +
                "The lake is softly illuminated by massive clear boulders of crystal. " +
                "Looking further into the darkness, there seems to be more lakes leading down like a staircase.";
    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        return new String[]{"Climb on top of one of the clear boulders", "Climb up the ladder"};
    }
    @Override
    public void perform(String option) {
        firstTime = false;
        switch (option) {
            case "Climb on top of one of the clear boulders":
                if (firstTimeClimbingBoulder) {
                    firstTimeClimbingBoulder = false;
                    AdvGame.clearFrameWithoutSpacing(
                            "You spot a clear boulder in the distance that you might be able to climb. " +
                                    "You slosh through the water, which you see now it is not completely clear. " +
                                    "The water is contaminated with some kind of ash or dust.\n" +
                                    "You hoist yourself up the boulder, and you look around you.\n\n" +
                                    "To the left, you see some interesting rock formations, like spirals emanating from the ground. " +
                                    "Directly forwards, you see some kind of dark shape that looks like a mound of rotten fabric. " +
                                    "To your right, you see what seems to be a massive crevasse hulking ominously in the shadows.",
                            new String[]{"Inspect the spiral rock formations", "Inspect the mound of fabric", "Inspect the crevasse", "Go back"}

                    );
                } else {
                    AdvGame.clearFrameWithoutSpacing(
                            "You spot a clear boulder in the distance that you can climb. " +
                                    "You slosh through the water and hoist yourself up.\n\n" +
                                    "From your vantage point, you can see odd spiraling rock formations over to the left, " +
                                    "the remains of some rotten fabric directly forwards, " +
                                    "and a massive crevasse to your right, partly obscured by the atmosphere.",
                            new String[]{"Inspect the spiral rock formations", "Inspect the mound of fabric", "Inspect the crevasse", "Go back"}

                    );
                }
                break;
            case "Inspect the spiral rock formations":
                cameBack = true;
                AdvGame.setSituation(SpiralRock_0E.getInstance());
                break;
            case "Inspect the mound of fabric":
                cameBack = true;
                AdvGame.setSituation(Tent_E.getInstance());
                break;
            case "Inspect the crevasse":
                cameBack = true;
                AdvGame.setSituation(Crevasse_E.getInstance());
                break;
            case "Go back":
                wentBack = true;
                AdvGame.setSituation(getInstance());
            case "Climb up the ladder":
                AdvGame.setSituation(CopperCave_E.getInstance());
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}

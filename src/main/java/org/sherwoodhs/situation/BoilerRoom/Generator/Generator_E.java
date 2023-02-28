package org.sherwoodhs.situation.BoilerRoom.Generator;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.location.BoilerRoom;
import org.sherwoodhs.location.Location;
import org.sherwoodhs.situation.BoilerRoom.BoilerRoom_1E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class Generator_E implements Situation {
    private boolean firstTime = true;
    private boolean inspectedGenerator = false;
    private boolean openedGenerator = false;
    private static Situation situation = new Generator_E();
    Location location = BoilerRoom.getInstance();
    private Generator_E() {
        World.setStateS("Location", location.getName());
    }
    @Override
    public String getTitle() {
        return "The Boiler Room";
    }
    @Override
    public String getDescription() {
        if (firstTime) {
            return "After a bit of climbing across pipes, you find that you are in front of a massive vibrating green container. It's extremely loud.\n\n" +
                    "You strain your eyes and see that in faded paint, it is the IKEA's \"generator\". " +
                    "You then turn, seeing that the red light you saw before was actually a flashing light on the generator's side.\n\n" +
                    "You listen for any other people that could be near, but your attempts are drowned out by the generator's sound.";
        }
        if (openedGenerator) {
            return "You adeptly scale a stack of pipes, and the green generator comes into your view. The vibrations almost feel comforting, now that the red light has turned off... perhaps permanently. " +
                    "As you wipe condensated steam off your face, you stare into the passage you uncovered. It leads into an unfathomable darkness.";
        }
        if (inspectedGenerator) {
            return "After climbing around some pipes, the massive generator comes into view. The red light eerily illuminates the steam around you. " +
                    "As you stand in front of the generator next to the metal sheet you pried off the generator, you look at the small panel you uncovered under it.";
        }
        return "You climb for a bit across some pipes, and take in the view in front of you. " +
                "The gigantic generator almost seems ethereal. The red light illuminates the white steam around it, which makes you feel a bit uneasy. " +
                "Not to mention, the generator is so loud, you won't be able to detect if any people are near you...";

    }
    @Override
    public SitType getSitType() {
        return SitType.Exploration;
    }
    @Override
    public String[] getOptions() {
        return new String[]{"Inspect the generator", "Inspect the red light", "Leave"};
        // Inspect the panel
        // Nick your finger with the pipe shard
        // Enter the passage
    }
    @Override
    public void perform(String option) {
        firstTime = false;
        switch (option) {
            case "Inspect the generator":
                // You take a closer look at the generator, and you notice a loose metal panel to the right of the flashing red light. 
                // It looks distinct from the dark green metal surrounding it. You slowly pry it off, and you discover a small panel with a blank screen under it.
                break;
            case "Inspect the red light":
                // You take a closer look at the red light. At this distance, it's almost blinding. You touch the glass, and it's scorching hot.
                // You quickly pull your hand away from the glass... it doesn't look like there's anything special with the light. You do wonder why it's flashing, however.
                // It's almost like if it's... warning you about something.
                break;
            case "Inspect the panel":
                // You place your hand on the panel, to see if it activates anything. As you feel the panel, you notice that panel is slightly textured, as if it's meant to absorb something...
                // Suddenly to your surprise, the blank screen flashes on, illuminating your face with a dull green glow.
                // The screen displays one ominous sentence: "To truly descend into the depths, one must sacrifice a sliver of their life."
                // It doesn't quite make sense to you. Is this device really a generator? Or is it something more sinister?
                break;
            case "Nick your finger with the pipe shard":
                // You come to the conclusion that the panel might be able to detect liquid. You pull out the pipe shard you collected earlier, and lightly jab at your finger.
                // A small bead of dark blood oozes out from the small cut you made, and you place your finger on the panel. As you pull it away, you see the blood quickly disappear into the panel.
                // The screen flashes a bright green and a quiet grinding sound begins to emanate from the generator. As the grinding sound grows louder and louder, you notice a small passage opening up on the side of the generator.
                // You think, maybe it wasn't a generator after all.
                break;
            case "Enter the passage":
                // first time:
                // Before you enter the narrow entrance, you strain your eyes to see if there is anything to warn you of any dangers lying ahead. 
                // However, the passage is so dark that you can't see anything. You carefully step into the passage. It's cool... it offers a bit of a reprieve from the humid steam of the boiler room.
                // Feeling more confident, you carefully make your way through.
                
                // afterwards:
                // You step into the narrow passage. The passage, now having been exposed to the humidity of the boiler room, has lost its initial chilliness.
                // You carefully make your way forward.
                break;
            case "Leave":
                // leave
                break;
        }
    }
    public static Situation getInstance() {
        return situation;
    }
}

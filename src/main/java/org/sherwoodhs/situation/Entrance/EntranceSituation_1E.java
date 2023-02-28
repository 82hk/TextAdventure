package org.sherwoodhs.situation.Entrance;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;

public class EntranceSituation_1E implements Situation {
    private static Situation situation = new EntranceSituation_1E();

    @Override
    public String getTitle() {
        return "The Ikea...?";
    }

    @Override
    public String getDescription() {
        return "Or at least, this is where the food court had always been. Instead there’s only more furniture, a few mattress displays, and bins of assorted blankets.\n\nHave they remodeled?";
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Keep going "};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){

            // MAIN BRANCH
            case "Keep going ":
                AdvGame.updateFrame("---\n\nThe store has stopped looking recognizable now. The bathroom and kitchen tile department had always led right to the food court, but now it joins up to—\n\nMore display rooms.\n\nAll filled with furniture. All empty of people.\n\nThis can’t be right. But with so many twists and turns to get here, is it even possible to find the way back to where you entered?",
                        new String[] {"Keep going","Turn back"});
                break;
            case "Turn back":
                AdvGame.updateFrame("---\n\nYou search for an exit, wandering aimlessly down more aisles lined with home decor through the labyrinthian twists and turns of the Ikea.\n\nEventually, you turn the corner to see a door on the far wall. It's a small gray utility door, quietly placed between two ornately decorated showroom displays.",
                        new String[] {" Keep going ","Open the door"});
                break;
            case "Keep going":
                AdvGame.updateFrame("---\n\nYou press on, wandering aimlessly down more aisles lined with display rooms, through the labyrinthian twists and turns of the Ikea.\n\nEventually, you turn the corner to see a door on the far wall. It's a small gray utility door, quietly placed between two ornately decorated showroom displays.",
                        new String[] {" Keep going ","Open the door"});
                break;
            case "Open the door":
                AdvGame.updateFrame("---\n\nYou step forward and cautiously try the doorknob.\n\nWith a shrill squeak, it turns.",
                        new String[] {"Enter"});
                break;
            case "Enter":
                AdvGame.setSituation(EntranceSituation_2E.getInstance());
                break;

            // EXIT POINT
            case " Keep going ":
                AdvGame.updateFrame("---\n\nYou ignore the obvious hint and carry on wandering through the Ikea. You never find the exit, though you do eventually find the food court and live out the rest of your days on stale meatballs and bottled water.\n\nThe End.",
                        new String[] {"Restart","Exit"});
                break;
            case "Restart":
                AdvGame.setSituation(EntranceSituation_0E.getInstance());
                break;
            case "Exit":
                System.exit(0);
        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

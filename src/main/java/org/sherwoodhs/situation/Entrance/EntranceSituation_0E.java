package org.sherwoodhs.situation.Entrance;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.World;
import org.sherwoodhs.quest.Clearwater.BottleFetchQuest;
import org.sherwoodhs.situation.BoilerRoom.Abyss.Canyon.Aquifer_E;
import org.sherwoodhs.situation.BoilerRoom.BoilerRoom_0E;
import org.sherwoodhs.situation.Foundation.FoundationEnds.Foundation_0E;
import org.sherwoodhs.situation.Haven.HavenCenter_E;
import org.sherwoodhs.situation.HiddenAlcove.HiddenAlcove1_0E;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.ui.InventoryPanel;

public class EntranceSituation_0E implements Situation {
    private static Situation situation = new EntranceSituation_0E();

    @Override
    public String getTitle() {
        return "The Ikea";
    }

    @Override
    public String getDescription() {
        return "There it is—the Ikea furniture and home improvement store.\n\nThe blue and yellow of the concrete building stretches from end to end across "+
            "the huge lot. Despite the size of the retail store, there’s not a single person in sight. The parking lot is similarly deserted, with nothing "+
            "but rows of empty spaces illuminated by the occasional streetlamp.";
    }

    @Override
    public SitType getSitType() {return SitType.Exploration;}

    @Override
    public String[] getOptions() {
        String[] options = {"Approach", "Test - Hidden Alcove", "Test - Haven", "Test - Boiler Room", "Test - Abyss"};
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){

            // MAIN BRANCH
            case "Approach":
                InventoryPanel.inventoryPanel.addToInventory("> Sample item");
                AdvGame.addQuest(BottleFetchQuest.getInstance());
                AdvGame.updateFrame("The massive ‘Ikea’ sign looms high above as the fluorescent glow of the interior lights floods through display windows near the entrance. Against the pitch black of the night sky, the light is nearly blinding.",
                        new String[] {"Enter","Go to Lowe's", "Test - Foundation endings"});
                break;
            case "Enter":
                AdvGame.updateFrame("---\n\nOn cue, the automatic doors slide open. A warm breeze wafts out, mixing with the cool evening air.\n\nYou step into the store and survey your surroundings.\n\nSofas, recliners, ottomans, and every kind of furniture piece imaginable cover the floor in a carefully structured manner, flanked by an innumerable variety of mini-display rooms. Decorative light fixtures cast soft shadows from the low exposed ceiling above, while in the distance air conditioning fans hum quietly.\n\nThe only thing missing is people.",
                        new String[] {"Keep going","Go to Lowe's"});
                break;
            case "Keep going":
                AdvGame.updateFrame("---\n\nYou go further into the Ikea.\n\nPast showrooms and home decorations; past kitchenware and tiled counters and cabinets galore. Past bedroom displays overflowing with pillows; past dining table chairs of every shape, color, and size. Past bathroom tiles and shower curtains; through the winding maze of the store’s floor plan you navigate until you reach the—\n\nFood court.\n",
                        new String[] {"Continue"});
                break;
            case "Continue":
                World.changeStateI("Time",1);
                AdvGame.setSituation(EntranceSituation_1E.getInstance());
                break;

            // EXIT POINT
            case "Go to Lowe's":
                AdvGame.updateFrame("---\n\nUnnerved by the absence of any sign of life, you decide to try your luck at the nearby Lowe's instead.\n\nGetting back in your car, you pull out of the parking lot and drive away, leaving the Ikea—and the entire point of the game—behind you.\n\nThe End.",
                        new String[] {"Restart","Exit"});
                break;
            case "Restart":
                AdvGame.getInstance().restartGame();
                break;
            case "Exit":
                System.exit(0);

            // DEBUGGING (to remove)
            case "Test - Hidden Alcove":
                AdvGame.setSituation(HiddenAlcove1_0E.getInstance());
                break;
            case "Test - Haven":
                AdvGame.setSituation(HavenCenter_E.getInstance());
                break;
            case "Test - Boiler Room":
                AdvGame.setSituation(BoilerRoom_0E.getInstance());
                break;
            case "Test - Foundation endings":
                AdvGame.setSituation(Foundation_0E.getInstance());
                break;
            case "Test - Abyss":
                AdvGame.setSituation(Aquifer_E.getInstance());
                break;

        }
    }

    public static Situation getInstance(){
        return situation;
    }

}

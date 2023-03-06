package org.sherwoodhs;

import java.util.HashMap;

import static org.sherwoodhs.ui.SituationPanel.situationPanel;

public class World {
    //Contains all State values
    private static HashMap<String, Integer> states = new HashMap(); //For int values
    //Singleton Stuff
    private static World world = new World();

    //Check if countdown is active
    private static boolean destructEnd = false;
    private World(){
        states.put("Time", 0); // Time of Day
        states.put("Day", 0); // # of Days spent in game
        states.put("Renown", 0); // Total renown in world
        states.put("Foundation Rep", 0);
        states.put("Haven Rep", 0);
        states.put("Clearwater Rep", 0);
        states.put("Deaths", 0);
        states.put("Destruction End Counter", 24); // 1 day counter
    }
    public static World getInstance(){
        return world;
    }

    //Gets a specific value based on state String key
    public int getState(String key){
        return(states.get(key));
    }

    //Changes a specific state in a specific way (using an int) depending on the state.
    public static void changeStateI(String key, int value){
        int changed = states.get(key) + value; // Default just adds upon a value;
        switch (key){
            case "Time" : //Adds value to current Time then undergoes modulus before updating
                if (changed / 24 > 0)/* Integer Division to check if day is over */{
                    changed %= 24; // Current Day cycle of 24 hours
                    states.replace("Day",states.get("Day") + 1); // Adds to the day counter
                    situationPanel.setTimeLabel("Day " + states.get("Day")); //Updates Day Label
                    // Could add something to happen during Midnight
                }
                if (destructEnd) {
                    int val = states.get("Destruction End Counter") - 1;
                    states.replace("Destruction End Counter", val);
                }
                break;
            case "Foundation Rep":
            case "Haven Rep":
            case "Clearwater Rep":
            case "Renown" : // Simply Updates Renown by adding then checking if exceeding max or going under min
                //Checks for out of limits values
                if (changed > 100) /* Current Max of 100 */ {
                    changed = 100;
                } else if (changed < -100) /* Current Min of -100 */{
                    changed = -100;
                }
                break;

        }
        states.replace(key, changed);
        if (key.equals("Time")){
            situationPanel.setTimeLabel(states.get("Time") + ":00"); //Updates Time Label
        }
    }

    public static void resetStates(){
        states.replace("Time", 0); // Time of Day
        states.replace("Day", 0); // # of Days spent in game
        states.replace("Renown", 0); // Total renown in world
        states.replace("Foundation Rep", 0);
        states.replace("Haven Rep", 0);
        states.replace("Clearwater Rep", 0);
        states.replace("Destruction End Counter", 24); // 1 day counter
    }
}

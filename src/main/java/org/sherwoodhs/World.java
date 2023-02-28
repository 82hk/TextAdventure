package org.sherwoodhs;

import java.util.HashMap;

import static org.sherwoodhs.ui.SituationPanel.situationPanel;

public class World {
    //Contains all State values
    private static HashMap<String, Integer> states = new HashMap(); //For int values
    private static HashMap<String, String> states2 = new HashMap(); //For String values
    //Singleton Stuff
    private static World world = new World();
    private World(){
        states.put("Time", 0); // Time of Day
        states.put("Day", 0); // # of Days spent in game
        states.put("Renown", 0); // Total renown in world
        states2.put("Location","Entry Room"); // The current location of the player
        states.put("Foundation Rep", 0);
        states.put("Haven Rep", 0);
        states.put("Clearwater Rep", 0);
        states.put("Separatists Rep", 0);
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
        int changed;
        switch (key){
            case "Time" : //Adds value to current Time then undergoes modulus before updating
                changed = states.get("Time") + value;
                if (changed / 24 > 0)/* Integer Division to check if day is over */{
                    changed %= 24; // Current Day cycle of 24 hours
                    states.replace("Day",states.get("Day") + 1); // Adds to the day counter
                    situationPanel.setTimeLabel("Day " + states.get("Day")); //Updates Day Label
                    // Could add something to happen during Midnight
                }
                states.replace("Time", changed);
                situationPanel.setTimeLabel(states.get("Time") + ":00"); //Updates Time Label
                break;
            case "Renown" : // Simply Updates Renown by adding then checking if exceeding max or going under min
                changed = states.get("Renown" + value);
                //Checks for out of limits values
                if (changed > 100) /* Current Max of 100 */ {
                    changed = 100;
                } else if (changed < -100) /* Current Min of -100 */{
                    changed = -100;
                }
                states.replace("Renown",changed);
                break;
        }
    }

    //Changes a specific state to a String.
    public static void setStateS (String key, String value){
        switch (key){
            case "Location" : //Changes the current location of the player. This method would typically be used in a Situation Constructor if needed.
                states2.replace("Location",value);
                break;
        }
    }
}

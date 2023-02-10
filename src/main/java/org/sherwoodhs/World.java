package org.sherwoodhs;

import java.util.HashMap;

public class World {
    //Contains all State values
    private HashMap<String, Integer> states = new HashMap(); //For int values
    private HashMap<Strint, String> states2 = new HashMap(); //For String values
    //Singleton Stuff
    private static World world = new World();
    private World(){
        states.put("Time", 0); // Time of Day
        states.put("Day", 0); // # of Days spent in game
        states.put("Renown", 0); // Total renown in world
        states2.put("Location","Entry Room"); // The current location of the player
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
                    // Could add something to happen during Midnight
                }
                states.replace("Time", changed);
                break;
            case "Renown" : // Simply Updates Renown by adding then checking if exceeding max or going under min
                changed = states.get("Renown" + value);
                //Checks for out of limits values
                if (changed > 100) /* Current Max of 100 */ {
                    changed = 100;
                } else if (changed < 0) /* Current Min of 0 */{
                    changed = 0;
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

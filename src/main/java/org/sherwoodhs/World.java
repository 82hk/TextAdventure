package org.sherwoodhs;

import java.util.HashMap;

public class World {
    //Contains all State values
    private HashMap<String, Integer> states = new HashMap();
    //Singleton Stuff
    private static World world = new World();
    private World(){
        states.put("Time", 0); // Time of Day
        states.put("Day", 0); // # of Days spent in game
        states.put("Renown", 0); // Total renown in world
    }
    public static World getInstance(){
        return world;
    }

    //Gets a specific value based on state String key
    public int getState(String key){
        return(states.get(key));
    }

    //Changes a specific state in a specific way depending on the state.
    public void changeState(String key, int value){
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
}

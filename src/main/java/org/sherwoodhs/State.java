package org.sherwoodhs;

import java.util.HashMap;
import java.util.Objects;

public abstract class State {
    HashMap<String, Object> state;

    Object get(String key) {
        return state.get(key);
    }

    void set(String key, Object value) {
        if(state.containsKey(key)) {
            state.remove(key);
        }
        state.put(key, value);
    }
}


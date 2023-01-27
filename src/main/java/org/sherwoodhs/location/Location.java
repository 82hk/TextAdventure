package org.sherwoodhs.location;

import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.State;

public abstract interface Location {
    Situation getStartSituation();

    State getLocationState();



}

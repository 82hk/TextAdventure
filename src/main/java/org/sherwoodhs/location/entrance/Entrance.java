package org.sherwoodhs.location.entrance;

import org.sherwoodhs.location.Location;
import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.State;
import org.sherwoodhs.location.entrance.situation.EntranceS;

public class Entrance implements Location {

    @Override
    public Situation getStartSituation() {
        return new EntranceS();
    }

    @Override
    public State getLocationState() {
        return null;
    }
}

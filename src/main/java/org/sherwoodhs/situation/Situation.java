package org.sherwoodhs.situation;

public abstract interface Situation {

    public String getSituation();

    public String[] getActions();

    public Situation performAction(int index);

}


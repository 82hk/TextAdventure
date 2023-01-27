package org.sherwoodhs.situation;

public abstract interface Situation {

    public String getSituation();

    public String[] getActions();

    public void performAction(int index);

}


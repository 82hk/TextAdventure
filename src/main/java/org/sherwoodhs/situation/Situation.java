package org.sherwoodhs.situation;

//Singleton stuff will be done in each separate singleton

public interface Situation {
    //Returns options for input

    public abstract String getTitle();
    public abstract String getDescription();
    public abstract String getSitType();

    public abstract String[] getOptions();

    public abstract void perform(String option);

/*

    switch(i)
    case 0:
        inventory.remove(boot)
        AdvGame.setSituation(threwBoot.getInstance())

*/
}

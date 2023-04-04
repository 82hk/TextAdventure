package org.sherwoodhs.situation;

//Singleton stuff will be done in each separate singleton

import javax.swing.*;

public interface Situation {
    //Returns options for input

    public abstract String getTitle();
    public abstract String getDescription();
    public abstract SitType getSitType();

    public abstract String[] getOptions();

    public abstract void perform(String option);

    public abstract ImageIcon getImg();

/*

    switch(i)
    case 0:
        inventory.remove(boot)
        AdvGame.setSituation(threwBoot.getInstance())

*/
}

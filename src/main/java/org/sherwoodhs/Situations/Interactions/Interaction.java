package Situations.Interactions;

import Situations.Situation;

public class Interaction extends Situation {
    Item[] items;
    protected Interaction (Item... items) {
        this.items = items;
    }
    public void changeFrame(){}
}

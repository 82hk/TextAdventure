package Situations.Combats;

import Situations.Situation;

public class Combat extends Situation {
    protected Player player = Player.getInstance();
    protected NPC enemy;

    protected Combat (NPC enemy){
        this.enemy = enemy;
    }
    public void changeFrame(){}
}

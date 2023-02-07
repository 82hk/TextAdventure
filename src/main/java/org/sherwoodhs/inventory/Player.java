package org.sherwoodhs.inventory;

public class Player {
    int health;
    int stamina;
    String name;

    private static Player player = new Player();

    private Player() {
        //do
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStamina() {
        return stamina;
    }

    public static Player getInstance() {
        return player;
    }

}


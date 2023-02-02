package org.sherwoodhs.inventory;

import org.sherwoodhs.IkeaGame;

public class Player {
    //dummy class for now
    int cookies = 0;

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

    public void makeCookies() {
        cookies += 12;
        //do nothing
    }

    public int getCookies() {
        return cookies;
    }
}


package org.sherwoodhs.inventory;

import org.sherwoodhs.IkeaGame;

public class Player {
    //dummy class for now
    int cookies = 0;
    private static Player player = new Player();

    private Player() {
        //do
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


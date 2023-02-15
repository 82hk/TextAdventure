package org.sherwoodhs;

import org.sherwoodhs.player.Player;

public class Main {
    public static void main(String[] args) {
        AdvGame e = AdvGame.getInstance();
        Player p = Player.getInstance();

        p.setPlayerName();
        e.startGame();
    }
}
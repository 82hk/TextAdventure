package org.sherwoodhs;

import org.sherwoodhs.player.Player;
import java.lang.Thread;

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread() { public void run() { while(true) { System.out.println(Thread.activeCount()); } } };
        AdvGame a = AdvGame.getInstance();
        Player p = Player.getInstance();

        t.start();
        p.setPlayerName();
        a.startGame();
    }
}
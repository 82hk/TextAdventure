package org.sherwoodhs;

import org.sherwoodhs.player.Player;
import java.lang.Thread;

public class Main {
    public static void main(String[] args) {
        //Thread tCounter = new Thread() { public void run() { while(true) { System.out.println(Thread.activeCount()); } } };
        //Thread bTyping = new Thread() { public void run() { while(true) { System.out.println(AdvGame.isTyping); } } };
        AdvGame a = AdvGame.getInstance();
        Player p = Player.getInstance();

        //tCounter.start();
        //bTyping.start();
        p.setPlayerName();
        a.startGame();
    }
}
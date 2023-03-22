package org.sherwoodhs;

import org.sherwoodhs.player.Player;
import org.sherwoodhs.ui.MenuPanel;

public class Main {
    public static void main(String[] args) {
        MenuPanel m = MenuPanel.getInstance();
        Player p = Player.getInstance();

        p.setPlayerName();
        m.startMenu();
    }
}
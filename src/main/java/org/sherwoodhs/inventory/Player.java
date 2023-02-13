package org.sherwoodhs.inventory;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {
    int health;
    int stamina;
    String name;
    String s;

    private static Player player = new Player();

    private Player() {
        //do
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;} // Should only be used once (Unless you need to change the player's name???)

    public int getHealth() {
        return health;
    }

    public int getStamina() {
        return stamina;
    }

    public static Player getInstance() {
        return player;
    }


    //gets the sets the player name but only if it does NOT contain numbers and special characters
    public void setPlayerName() {
        Boolean b = true;
        do {
            s = JOptionPane.showInputDialog(null, "Enter your name: ", "Name", JOptionPane.QUESTION_MESSAGE);
            if (s == null || s.isEmpty() || nameHasNums() || nameHasSpCh()) {
                JOptionPane.showMessageDialog(null, "Name cannot contain numbers, special characters, or be blank!", "Name", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Player.getInstance().setName(s);
                b = false;
            }
        } while(b);
    }

    //Check name string for numbers
    private boolean nameHasNums() {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    //check name string for special characters
    private boolean nameHasSpCh() {
        Pattern p = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(s);
        boolean b = m.find();

        if (b) {
            return true;
        } else {
            return false;
        }
    }
}


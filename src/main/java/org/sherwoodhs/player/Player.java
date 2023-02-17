package org.sherwoodhs.player;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    //gets the sets the player name but only if it does NOT contain numbers and special characters
    public void setPlayerName() {
        Boolean b = true;
        try {
            do {
                name = JOptionPane.showInputDialog(null, "Enter your name: ", "Name", 3);
                if (name.isEmpty() || nameHasNums() || nameHasSpCh() || charCap()) {
                    JOptionPane.showMessageDialog(null, "Name cannot contain numbers,  special characters, spaces, be blank, or be longer than 16 characters!", "Name", 0);
                } else {
                    b = false;
                }
            } while (b);
        }catch (NullPointerException e){
            System.exit(0);
        }
    }

    //Check name string for numbers
    private boolean nameHasNums() {
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    //check name string for special characters
    private boolean nameHasSpCh() {
        Pattern p = Pattern.compile("[^a-z]", 2);
        Matcher m = p.matcher(name);
        boolean b = m.find();

        if (b) {
            return true;
        } else {
            return false;
        }
    }

    private boolean charCap(){
        char[] nameList = name.toCharArray();
        if(nameList.length > 16) {
            return true;
        } else{
            return false;
        }
    }
}


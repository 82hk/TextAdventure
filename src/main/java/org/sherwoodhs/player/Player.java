package org.sherwoodhs.player;

import com.sun.corba.se.impl.encoding.BufferManagerWriteCollect;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Player {
    int health;
    int stamina;
    String name;
    File savedName = new File("src/main/java/org/sherwoodhs/player/name.txt");

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
                if(savedName.exists()){
                    name = readSavedName();
                     b = false;
                } else {
                    name = JOptionPane.showInputDialog(null, "Enter your name: ", "Name", 3);
                    if (name.isEmpty() || nameHasNums() || nameHasSpCh() || charCap()) {
                        JOptionPane.showMessageDialog(null, "Name cannot contain numbers,  special characters, spaces, be blank, or be longer than 16 characters!", "Name", 0);
                    } else {
                        setSavedName();
                        b = false;
                    }
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

    //Writes input name in text file
    private void setSavedName() {
        try {
            FileWriter fileWriter = new FileWriter(savedName);
            fileWriter.write(name);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Something broke while saving.");
            e.printStackTrace();
        }
    }

    /* private void resetSavedName() {
        try {
            savedName.delete();
            setPlayerName();
        } catch (Exception e) {
            System.out.println("Something broke while resetting.");
        }
    } */

    //returns name inside text file
    public String readSavedName() {
        String data;
        try {
            Scanner scanner = new Scanner(savedName);
            data = scanner.nextLine();
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Something broke");
            e.printStackTrace();
            return null;
        }
        return data;
    }
}


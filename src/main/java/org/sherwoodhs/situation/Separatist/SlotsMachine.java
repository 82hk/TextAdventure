package org.sherwoodhs.situation.Separatist;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.situation.Separatist.Kitchen.CashRegister;
import org.sherwoodhs.situation.SitType;
import org.sherwoodhs.situation.Situation;
import java.util.Random;

import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;
import static org.sherwoodhs.situation.Separatist.Kitchen.CashRegister.money;

public class SlotsMachine implements Situation {
    
    // REVERT EVERYTHING TO EXPLORATION TYPE, MAKE INDIVIDUAL CLASSES FOR EVERY OPTION (maybe with adding previous text in backwards).
    private static boolean firstTime = true;
    private static boolean casinoWin = false;
    private static Situation situation = new SlotsMachine();

    @Override
    public String getTitle() {
        return "The Separatist Slot Machine";
    }

    @Override
    public String getDescription() {
        if (firstTime) {
            return "Welcome to the Slot Machine! To win, you must get 3 sparkling waters in a row." +
                    "This is what the winning situation looks like. \n\n" +
                    "[S] [S] [S] \n\n" +
                    "To play, you must spend 3 money.";
        } else {
            if (casinoWin) {
                return "You've already won the casino. You don't need to play anymore, " +
                        "but you may do so if you wish.";
            } else {
                return "Welcome to the Slot Machine! To win, you must get 3 sparkling waters in a row." +
                        "This is what the winning situation looks like. \n\n" +
                        "[S] [S] [S] \n\n" +
                        "To play, you must spend 3 money.";
            }
        }
    }

    @Override
    public SitType getSitType() {return SitType.Interaction;}

    @Override
    public String[] getOptions() {
        String[] options = {"Play", "Leave"}; // limit 6
        return options;
    }

    @Override
    public void perform(String option) {
        switch (option){

            // MAIN BRANCH
            case "Play":
                if (!(money-3<0)) {
                    addMoney(money-=3);
                    casinoGame();
                } else {
                    AdvGame.clearFrameWithoutSpacing("Sorry, you do not have enough " +
                            "money to play this game. Please come back when you are richer.");
                }
                break;

            case "Have a drink":
                //Have a beer
                break;
                
            // EXIT POINT
            case "Leave":
                firstTime = false;
                AdvGame.setSituation(Casino.getInstance());
                break;
        }
    }

    public static Situation getInstance(){
        return situation;
    }

    private static void casinoGame() {
        String[] options = new String[]{"S", "D", "F"};
        Random r = new Random();
        String s1 = options[r.nextInt(options.length)];
        String s2 = options[r.nextInt(options.length)];
        String s3 = options[r.nextInt(options.length)];

        String game1 = "     [" + options[r.nextInt(options.length)] + "] " +
                "[" + options[r.nextInt(options.length)] + "] " +
                "[" + options[r.nextInt(options.length)] + "]";
        String game2 = "-> [" + s1 + "] " +
                "[" + s2 + "] " +
                "[" + s3 + "] <-";
        String game3 = "     [" + options[r.nextInt(options.length)] + "] " +
                "[" + options[r.nextInt(options.length)] + "] " +
                "[" + options[r.nextInt(options.length)] + "]";

        if (s1.equals("S") && s1.equals(s2) && s2.equals(s3)) {
            AdvGame.clearFrame("     You won!");
            AdvGame.updateFrame(game1 + "\n" + game2 + "\n" + game3);
            if (!casinoWin) {
                AdvGame.updateFrame("You won the fabled casino! You have been awarded 3 sparkling waters as a result. " +
                        "You may use it how you wish.", new String[]{"Leave"});
                inventoryPanel.addToInventory("Sparkling Water (x3)");
            }
            casinoWin = true;
        } else {
            AdvGame.clearFrame("     You lost!");
            AdvGame.updateFrame(game1 + "\n" + game2 + "\n" + game3);
        }

    }

    public static void addMoney(int b) {
        inventoryPanel.addToInventory("Money: " + b);
        int a = b+3;
        inventoryPanel.removeFromInventory("Money: " + a);
    }
}
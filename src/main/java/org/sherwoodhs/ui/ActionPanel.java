package org.sherwoodhs.ui;

import org.sherwoodhs.AdvGame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.sherwoodhs.ui.Frame.FRAME;

public class ActionPanel extends JPanel {
    public static final ActionPanel actionPanel = new ActionPanel();
    private AdvGame adv;

    private ActionPanel() {
        super(new GridLayout(2, 3));
        setPreferredSize(new Dimension(750, 170));
        setBorder(new TitledBorder("Actions"));
        adv = AdvGame.getInstance();
    }
    /**
     * Adds a 'skip' button while typing text which skips over the typing effect
     */
    public void addSkipButton() {

        removeAllActions();
        JButton skip = new JButton(getWrappedText("Skip"));
        skip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();

            }
        });
        add(skip);

        for (int i = 0; i < 5; i++) {
            JButton blank = new JButton();
            blank.setEnabled(false);
            add(blank);
        }
    }

    /**
     * Adds # number of JButtons that represents the actions the player can take
     * @param texts represents the prompts the player will be given in each JButton, texts.length represents the amount of buttons added to the panel
     */
    public void initActions(String[] texts) {
        System.out.println("initActions :" + texts.length);
        if (texts.length == 0)
            return;
        if (texts.length > 6)
            return;
        removeAllActions();
        int blanks = 0;
        for (String element : texts) {
            // if the element  cycling through is not blank
            if (!element.equals("")) {
                JButton action = new JButton(getWrappedText(element));
                action.setFont(new Font ("Lato",0,15)); // FONTS
                action.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton b = (JButton) e.getSource();
                        String s = b.getText()
                                .replace("<html><center>", "")
                                .replace("</center></html>", "");
                        adv.getCurrentSituation().perform(s);
                    }
                });
                add(action);
            } else {
                blanks++;
            }
        }
        // adds empty space to non-existent cells
        for (int i = 0; i < 6 - (texts.length - blanks); i++) {
            JButton blank = new JButton();
            blank.setEnabled(false);
            add(blank);
        }
    }
    /**
     * Changes the content and action of one button that is present in the panel
     * @param s represents the action that will be searched for to remove
     * @param text represents the text that will replace String s
     */
    public void changeAction(String s, String text) {
        Component[] comp = getComponents();
        for (Component element : comp) {
            if (element instanceof JButton) {
                // if the text of JButton element is equivalent to String s
                if (((JButton) element).getText().equals(s)) {
                    // sets text of the button to be changed
                    ((JButton) element).setText(text);
                    // sets actions of the button to be changed
                    ((JButton) element).addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // situation
                        }
                    });
                    return;
                }
            }
        }
        // will not achieve anything if a JButton with the content String s cannot be found on the panel
    }
    /**
     * Removes one button present in the panel
     * @param s represents the action that will be searched for to remove
     */
    public void removeAction(String s) {
        Component[] comp = getComponents();
        for (Component element : comp) {
            if (element instanceof JButton) {
                if (((JButton) element).getText().equals(s)) {
                    remove(element);
                }
            }
        }
        // will not achieve anything if a JButton with the content String s cannot be found on the panel
    }
    /**
     * Removes all action buttons in the panel
     */
    public void removeAllActions() {
        Component[] comp = getComponents();
        for (Component element : comp) {
            remove(element);
        }
    }

    /**
     * Disable all actions
     */
    public void disableAllActions() {
        Component[] comp = getComponents();
        for (Component element : comp) {
            element.setEnabled(false);
        }
    }

    public void enableValidOptions() {
        Component[] comp = getComponents();
        for (Component element : comp) {
            if (element instanceof JButton) {
                if (((JButton) element).getText() != "") {
                    element.setEnabled(true);
                }
            }
        }
    }


    /**
     * Enable actions
     */
    private String getWrappedText(String s) {
        s = "<html><center>" + s + "</center></html>";
        return s;
    }
}
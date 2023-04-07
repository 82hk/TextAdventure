package org.sherwoodhs.ui;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.ui.util.TextPanelCellRenderer;
import org.sherwoodhs.ui.util.DisabledItemSelectionModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TextPanel extends JPanel {
    public static final TextPanel textPanel = new TextPanel();
    private DefaultListModel<String> textListModel = new DefaultListModel<>();
    private JList<String> textList;
    private Timer timer = new Timer();
    private int index = 0; // tracks the index of the JList element being edited
    private int i = 0; // character index for 'typingTask'
    private String text; // holds elements passed into addText
    public TextPanel() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(600, 550));
        setBorder(new TitledBorder("Dialogue"));
        setFont(new Font("Lato",2,13));

        textList = new JList<>(textListModel);
        textList.setSelectionModel(new DisabledItemSelectionModel());
        textList.setCellRenderer(new TextPanelCellRenderer());
        add(textList);
    }

    /**
     * Adds one element to textList without clearing its contents, can contain escape sequences.
     * @param s one element to be added to TextList
     */

    public void addText(String... s) {

        i = 0;

        text = "";
        for (String element : s) {
            text += element;
        }

        textListModel.add(index,"|");

        AdvGame.isTyping = true;
        timer.schedule(new TimerTask() { // maybe make this one typingTask in the class attributes? find way to repeatedly schedule.
            @Override
            public void run() {

                if (i < text.length()) {
                    i++;
                    textListModel.set(index, (text.substring(0,i)+"|") );
                } else {
                    textListModel.set(index, text);
                    AdvGame.isTyping = false;
                    System.out.println("TextPanel : addText() : timer : " + AdvGame.isTyping);
                    index++;
                    cancel();
                }
            }
        }, 0, 10);

    }
    /**
     * Adds a blank line to textList, akin to two <br> tags in HTML
     */
    public void addBlank() {
        textListModel.addElement("");
    }

    /**
     * Clears all content inside textList
     */
    public void clearAllText() {
        textListModel.clear();
        index = 0;
    }

}
package org.sherwoodhs.ui;

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
    private TimerTask typingTask = new TimerTask() {
        @Override
        public void run() {
            // make timerTask automate through a variable that holds the preloaded messages, then types them out

            // textListModel.set(element, i)
            // i++
        }
    };
    private int index = 0; // tracks the index of the JList element being edited
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

        /*
        textListModel.add(index, "|");
        timer.schedule(typing Task, delay 10);

         */


        textListModel.add(index,"|");

        for (String element : s) {
            for (int i = 0; i < element.length(); i++) {

                textListModel.set(index, (element.substring(0,i)+"|") );

                try {
                    Thread.sleep(12);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            } textListModel.set(index, element);
        } index++;

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
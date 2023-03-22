package org.sherwoodhs.ui;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.ui.util.CellRenderer;
import org.sherwoodhs.ui.util.DisabledItemSelectionModel;

import static org.sherwoodhs.ui.ActionPanel.actionPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TextPanel extends JPanel {
    public static final TextPanel textPanel = new TextPanel();
    private DefaultListModel<String> textListModel = new DefaultListModel<>();
    private JList<String> textList;
    private int index = 0; // tracks the index of the JList element being edited
    public TextPanel() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(600, 550));
        setBorder(new TitledBorder("Dialogue"));

        textList = new JList<>(textListModel);
        textList.setSelectionModel(new DisabledItemSelectionModel());
        textList.setCellRenderer(new CellRenderer());
        add(textList);
    }

    /**
     * Adds one element to textList without clearing its contents, can contain escape sequences.
     * @param s one element to be added to TextList
     */
    public void addText(String... s) {

        textListModel.add(index,"|"); // adds a "|" for typing effect

        for (String element : s) {
            for (int i = 0; i < element.length(); i++) {

                textListModel.set(index, (element.substring(0,i)+"|") ); // keeps the "|" in front

                try { // pause for typing effect
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            textListModel.set(index, element); // removes the "|"
        }
        index++; // new element after finish typing
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
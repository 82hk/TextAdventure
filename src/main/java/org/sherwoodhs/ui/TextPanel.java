package org.sherwoodhs.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TextPanel extends JPanel {
    public static final TextPanel textPanel = new TextPanel();
    private DefaultListModel<String> textListModel = new DefaultListModel<>();
    private JList<String> textList;
    private TextPanel() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(600,550));
        setBorder(new TitledBorder("Dialogue"));

        textList = new JList<>(textListModel);
        textList.setSelectionModel(new DisabledItemSelectionModel());
        textList.setCellRenderer(new CellRenderer());
        add(textList);
    }
    /**
     * Adds one element to textList without clearing its contents, can contain escape sequences
     * @param s one element to be added to TextList
     */
    public void addText (String... s) {
        for (String element : s) {
            textListModel.addElement(element);
        }
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
    }
}
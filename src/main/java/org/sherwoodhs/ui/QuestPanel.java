package org.sherwoodhs.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class QuestPanel extends JPanel {
    public static final QuestPanel questPanel = new QuestPanel();
    private DefaultListModel<String> questListModel = new DefaultListModel<>();
    private JList<String> questList;
    private QuestPanel() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(150,550));
        setBorder(new TitledBorder("Current Quests"));

        questList = new JList<>(questListModel);
        questList.setSelectionModel(new DisabledItemSelectionModel());
        questList.setCellRenderer(new CellRenderer());
        add(questList);

        addQuest("A quest.");
    }
    /**
     * Adds one element to questList without clearing its contents after adding "> " to the beginning of the string
     * @param s one element to be added to questList
     */
    public void addQuest(String s) {
        questListModel.addElement(setQuestConvention(s));
    }
    private String setQuestConvention(String s) {
        return "> " + s;
    }
    /**
     * Removes one element to questList without clearing its contents
     * @param s one element to be removed from questList; method will not work if the element cannot be found
     */
    public void removeQuest(String s) {
        questListModel.removeElement(s);
    }
}
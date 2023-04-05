package org.sherwoodhs.ui;

import org.sherwoodhs.quest.Quest;
import org.sherwoodhs.ui.util.QuestPanelCellRenderer;
import org.sherwoodhs.ui.util.DisabledItemSelectionModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class QuestPanel extends JPanel {
    public static final QuestPanel questPanel = new QuestPanel();
    private DefaultListModel<String> questListModel = new DefaultListModel<>();
    private JList<String> questList;
    private int index = 0;

    private QuestPanel() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(150,550));
        setBorder(new TitledBorder("Current Quests"));

        questList = new JList<>(questListModel);
        questList.setSelectionModel(new DisabledItemSelectionModel());
        questList.setCellRenderer(new QuestPanelCellRenderer());
        add(questList);
    }
    /**
     * Adds one element to questList without clearing its contents after adding "> " to the beginning of the string
     * @param quest one element to be added to questList
     */
    public void addQuest(Quest quest) { // identical method to TextPanel's "addText"

        String questName = setQuestConvention(quest.getName());
        questListModel.addElement(questName);

        /** Thread t = new Thread() {
            public void run() {

                String questName = setQuestConvention(quest.getName());
                questListModel.add(index, "|");

                for (int i = 0; i < questName.length(); i++) {
                    questListModel.set(index, (questName.substring(0, i) + "|"));
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                questListModel.set(index, questName);
                index++;
            }
        };
        t.start(); */
    }
    private String setQuestConvention(String s) {return "> " + s;}
    /**
     * Removes one element from questList without clearing its contents
     * @param quest one element to be removed from questList; method will not work if the element cannot be found
     */
    public void removeQuest(Quest quest) {
        String s = setQuestConvention(quest.getName());
        questListModel.removeElement(s);
        index--;
    }
    /**
     * Checks questList for quest
     * @param quest quest to be checked
     */
    public boolean containsQuest(Quest quest){
        String s = setQuestConvention(quest.getName());
        if(questListModel.contains(s)){
            return true;
        }else{
            return false;
        }
    }

    public void clearQuestList(){
        questListModel.clear();
        index = 0;
    }

}
package org.sherwoodhs.ui;

import org.sherwoodhs.AdvGame;
import org.sherwoodhs.quest.Quest;
import org.sherwoodhs.ui.util.QuestPanelCellRenderer;
import org.sherwoodhs.ui.util.DisabledItemSelectionModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;

import static org.sherwoodhs.ui.ActionPanel.actionPanel;

public class QuestPanel extends JPanel {
    public static final QuestPanel questPanel = new QuestPanel();
    private DefaultListModel<String> questListModel = new DefaultListModel<>();
    private JList<String> questList;
    private Timer timer = new Timer(); // see TextPanel for explanation
    private int index = 0;
    private int i = 0;
    private String questName;

    private QuestPanel() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(150,550));
        setBorder(new TitledBorder("Quests"));



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

        i = 0;

        questName = setQuestConvention(quest.getName());

        questListModel.add(index, "");

        AdvGame.isTyping = true;
        timer.schedule(new TimerTask() { // maybe make this one typingTask in the class attributes? find way to repeatedly schedule.
            @Override
            public void run() {

                while(AdvGame.isTyping) {
                    Thread.yield();
                }

                if (i < questName.length()) {
                    i++;
                    questListModel.set(index, (questName.substring(0,i)+"|") );
                } else {
                    questListModel.set(index, questName);
                    index++;
                    AdvGame.isTyping = false;
                    cancel();
                }
            }
        }, 0, 30);

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
package org.sherwoodhs;

import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import org.sherwoodhs.quest.Quest;
import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.situation.IkeaEntrance.EntranceSituation_0E;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import static org.sherwoodhs.ui.ActionPanel.actionPanel;
import static org.sherwoodhs.ui.Frame.FRAME;
import static org.sherwoodhs.ui.SituationPanel.situationPanel;
import static org.sherwoodhs.ui.TextPanel.textPanel;
import static org.sherwoodhs.ui.QuestPanel.questPanel;

public class AdvGame {
    private static Situation currentSituation;
    private static AdvGame advGame = new AdvGame();
    private AdvGame() {
        try {
            UIManager.setLookAndFeel(new FlatDarkPurpleIJTheme());
            UIManager.put("ScrollBar.thumbArc", 999);
            UIManager.put("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));
            UIManager.put("Component.arrowType", "triangle");
            UIManager.put("ProgressBar.foreground", new Color(69, 64, 92));
            UIManager.put("ProgressBar.selectionForeground", new Color(180, 180, 200));
            UIManager.put("ProgressBar.selectionBackground", new Color(180, 180, 200));
            UIManager.put("TextArea.background", new Color(44, 44, 59));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Starts game at TestConversation1_0D then makes frame visible
    public void startGame() {
        setSituation(EntranceSituation_0E.getInstance());
        EventQueue.invokeLater(() -> {
            FRAME.setVisible(true);
        });
    }

    public static AdvGame getInstance() {
        return advGame;
    }

    //Changes situation and updates frame
    public static void setSituation(Situation situation) {
        currentSituation = situation;
        updateFrame();
    }
    public Situation getCurrentSituation (){
        return currentSituation;
    }

    /* Updates the frame */
    public static void updateFrame() {
        situationPanel.setSituationLabel(currentSituation.getTitle()); // Changes Situation Title
        textPanel.clearAllText(); // Empties the textfield
        textPanel.addText(currentSituation.getDescription()); // Changes textfield description
        textPanel.setBorder(new TitledBorder(currentSituation.getSitType().toString())); //setTitled border title
        actionPanel.initActions(currentSituation.getOptions()); //Changes buttons
    }

    public static void updateFrame(String newDesc, String[] options) {
        updateFrame(newDesc);
        updateFrame(options);
    }

    public static void updateFrame(String[] options) {
        actionPanel.initActions(options);
    }

    public static void updateFrame(String newDesc) {
        textPanel.addText("\n" + newDesc);
    }

    public static void clearFrame() {textPanel.clearAllText();}

    public static void addQuest(Quest quest) {questPanel.addQuest(quest);}

    public static void clearFrame(String newDesc) {clearFrame(); updateFrame(newDesc);}

    public static void clearFrame(String newDesc, String[] options) {clearFrame(); updateFrame(newDesc, options);}
    public static void removeQuest(Quest quest){questPanel.removeQuest(quest);}

}

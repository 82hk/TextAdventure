package org.sherwoodhs;

import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;

import org.sherwoodhs.quest.Quest;
import org.sherwoodhs.quest.Clearwater.*;
import org.sherwoodhs.quest.Foundation.*;
import org.sherwoodhs.quest.Misc.*;
import org.sherwoodhs.quest.Separatist.*;
import org.sherwoodhs.situation.OtherSide.OtherSideEndX1;
import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.situation.Entrance.EntranceSituation_0E;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.EventQueue.*;

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
            //UIManager.put("TextArea.background", new Color(44, 44, 59));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Starts game at TestConversation1_0D then makes frame visible
    public void startGame() {
        setSituation(EntranceSituation_0E.getInstance());
        FRAME.setVisible(true);
    }

    public void restartGame() {
        setSituation(EntranceSituation_0E.getInstance());
        World.resetStates();
        resetQuestProgression();

    }

    public void resetQuestProgression() { // add all quests here, both to reset and remove from panel. quests are organized by package


        // reset quest progression
        BottleFetchQuest.getInstance().reset(); // Clearwater

        GuardQuest.getInstance().reset(); // Foundation
        ScrapMetalCollection.getInstance().reset();
        ScrapMetalRepeatable.getInstance().reset();
        BulletBuildingQuest.getInstance().reset();

        OtherSideQuest.getInstance().reset(); // Misc
        StolenFurnQuest.getInstance().reset();

        SparklingWaterQuest.getInstance().reset(); // Separatist
        FoodMakingQuest.getInstance().reset();

        questPanel.clearQuestList();
    }

    public static AdvGame getInstance() {
        return advGame;
    }

    //Changes situation and updates frame
    public static void setSituation(Situation situation) {
        if (World.destructEnd){
            currentSituation = OtherSideEndX1.getInstance();
        } else {
            currentSituation = situation;
        }
        updateFrame();
    }
    public Situation getCurrentSituation (){
        return currentSituation;
    }

    /* Updates the frame */
    public static void updateFrame() {
        situationPanel.setSituationLabel(currentSituation.getTitle()); // Changes Situation Title
        textPanel.clearAllText(); // Empties the textfield

        Thread a = new Thread() {
            public void run() {
                textPanel.addText(currentSituation.getDescription()); // Changes textfield description
            }
        };
        a.start();

        textPanel.setBorder(new TitledBorder(currentSituation.getSitType().toString())); //setTitled border title
        actionPanel.initActions(currentSituation.getOptions());
    }

    public static void updateFrame(String newDesc, String[] options) {
        updateFrame(options);
        updateFrame(newDesc);
    }

    public static void updateFrame(String[] options) {
        actionPanel.initActions(options);
    }

    public static void updateFrame(String newDesc) {
        Thread c = new Thread() {
            public void run() {
                textPanel.addText("\n" + newDesc);
            }
        };
        c.start();

    }
    
    public static void updateFrameWithoutSpacing(String newDesc) {
        textPanel.addText(newDesc);
    }
    public static void updateFrameWithoutSpacing(String newDesc, String[] options) {
        updateFrameWithoutSpacing(newDesc);
        updateFrame(options);
    }

    public static void clearFrame() {textPanel.clearAllText();}

    public static void clearFrame(String newDesc) {clearFrame(); updateFrame(newDesc);}

    public static void clearFrame(String newDesc, String[] options) {clearFrame(); updateFrame(newDesc, options);}
    
    public static void clearFrameWithoutSpacing(String newDesc) {clearFrame(); updateFrameWithoutSpacing(newDesc);}
    
    public static void clearFrameWithoutSpacing(String newDesc, String[] options) {clearFrame(); updateFrameWithoutSpacing(newDesc, options);}
    
    public static void addQuest(Quest quest) {
        Thread q = new Thread() {
            public void run() {
                questPanel.addQuest(quest);
            }
        };
        q.start();

    }
    
    public static void removeQuest(Quest quest){questPanel.removeQuest(quest);}

}

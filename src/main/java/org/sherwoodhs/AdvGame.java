package org.sherwoodhs;

import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;

import org.sherwoodhs.player.Player;
import org.sherwoodhs.quest.Quest;
import org.sherwoodhs.quest.Clearwater.*;
import org.sherwoodhs.quest.Foundation.*;
import org.sherwoodhs.quest.Misc.*;
import org.sherwoodhs.quest.Separatist.*;
import org.sherwoodhs.situation.OtherSide.OtherSideEndX1;
import org.sherwoodhs.situation.Situation;
import org.sherwoodhs.situation.Entrance.EntranceSituation_0E;
import org.sherwoodhs.ui.InventoryPanel;
import org.sherwoodhs.ui.MapPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.EventQueue.*;

import static org.sherwoodhs.ui.ActionPanel.actionPanel;
import static org.sherwoodhs.ui.Frame.FRAME;
import static org.sherwoodhs.ui.SituationPanel.situationPanel;
import static org.sherwoodhs.ui.TextPanel.textPanel;
import static org.sherwoodhs.ui.QuestPanel.questPanel;
import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;
public class AdvGame {
    public static boolean isTyping = false;
    private static Situation currentSituation;
    private static AdvGame advGame = new AdvGame();
    private Player player;
    private AdvGame() {
        try {
            UIManager.setLookAndFeel(new FlatDarkPurpleIJTheme());
            UIManager.put("ScrollBar.thumbArc", 999);
            UIManager.put("ScrollBar.thumbInsets", new Insets(2, 2, 2, 2));
            UIManager.put("Component.arrowType", "triangle");
            UIManager.put("ProgressBar.foreground", new Color(69, 64, 92));
            UIManager.put("ProgressBar.selectionForeground", new Color(180, 180, 200));
            UIManager.put("ProgressBar.selectionBackground", new Color(180, 180, 200));
            UIManager.put("TextArea.background", new Color(44, 44, 59)); // Comment out to add highlighting
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Starts game at TestConversation1_0D then makes frame visible
    public void startGame() {
        FRAME.setVisible(true);
        setSituation(EntranceSituation_0E.getInstance());
    }

    public void restartGame() {
        setSituation(EntranceSituation_0E.getInstance());
        World.resetStates();
        resetQuestProgression();
        inventoryPanel.clearInventory();
    }

    public void resetQuestProgression() { // add all quests here, both to reset and remove from panel. quests are organized by package

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
        if (World.getState("Destruction End Counter") <= 0){
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

        MapPanel.mapPanel.updateImg();
        situationPanel.setSituationLabel(currentSituation.getTitle());

        textPanel.clearAllText();
        textPanel.setBorder(new TitledBorder(currentSituation.getSitType().toString()));

        System.out.println("AdvGame : updateFrame() : " + isTyping);
        textPanel.addText(currentSituation.getDescription());
        System.out.println("AdvGame : updateFrame() : " + isTyping);

        actionPanel.initActions(currentSituation.getOptions());

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
        System.out.println("AdvGame : addQuest() : " + isTyping);
        questPanel.addQuest(quest);
        System.out.println("AdvGame : addQuest() : " + isTyping);
    }
    
    public static void removeQuest(Quest quest){questPanel.removeQuest(quest);}

}

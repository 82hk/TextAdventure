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
        isTyping = false;
        inventoryPanel.clearInventory();
        questPanel.clearQuestList();

        World.resetStates();
        resetQuestProgression();

        setSituation(EntranceSituation_0E.getInstance());
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

        textPanel.addText(currentSituation.getDescription());

        actionPanel.initActions(currentSituation.getOptions());
        actionPanel.disableAllActions();
    }

    public static void updateFrame(String newDesc, String[] options) {
        MapPanel.mapPanel.updateImg();
        updateFrame(newDesc);
        updateFrame(options);
    }

    public static void updateFrame(String[] options) {
        MapPanel.mapPanel.updateImg();
        actionPanel.initActions(options);
        actionPanel.disableAllActions();
    }

    public static void updateFrame(String newDesc) {
        MapPanel.mapPanel.updateImg();

        textPanel.addText("\n" + newDesc);
    }

    public static void updateFrameWithoutSpacing(String newDesc) {
        MapPanel.mapPanel.updateImg();

        textPanel.addText(newDesc);
    }

    public static void updateFrameWithoutSpacing(String newDesc, String[] options) {
        MapPanel.mapPanel.updateImg();

        updateFrameWithoutSpacing(newDesc);
        updateFrame(options);
    }

    public static void clearFrame() {
        MapPanel.mapPanel.updateImg();

        textPanel.clearAllText();
    }

    public static void clearFrame(String newDesc) {
        MapPanel.mapPanel.updateImg();

        clearFrame();
        updateFrame(newDesc);
    }

    public static void clearFrame(String newDesc, String[] options) {
        MapPanel.mapPanel.updateImg();

        clearFrame();
        updateFrame(newDesc, options);
    }
    
    public static void clearFrameWithoutSpacing(String newDesc) {
        MapPanel.mapPanel.updateImg();

        clearFrame();
        updateFrameWithoutSpacing(newDesc);
    }

    public static void clearFrameWithoutSpacing(String newDesc, String[] options) {
        MapPanel.mapPanel.updateImg();

        clearFrame();
        updateFrameWithoutSpacing(newDesc, options);
    }
    
    public static void addQuest(Quest quest) {
        questPanel.addQuest(quest);
    }
    
    public static void removeQuest(Quest quest){
        questPanel.removeQuest(quest);
    }

}

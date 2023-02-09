package org.sherwoodhs;

import org.sherwoodhs.Situations.Testing.TestCombat1.TestCombat1_0C;
import org.sherwoodhs.Situations.Situation;
import org.sherwoodhs.Situations.Testing.TestConversation1.TestConversation1_0D;
import org.sherwoodhs.ui.ActionPanel;
import org.sherwoodhs.ui.SituationPanel;
import org.sherwoodhs.ui.TextPanel;

import javax.swing.*;
import java.awt.*;

import static org.sherwoodhs.ui.ActionPanel.actionPanel;
import static org.sherwoodhs.ui.Frame.FRAME;
import static org.sherwoodhs.ui.SituationPanel.situationPanel;
import static org.sherwoodhs.ui.TextPanel.textPanel;


public class AdvGame {
    private static Situation currentSituation;
    private static AdvGame advGame = new AdvGame();
    private AdvGame() {
    }

    //Starts game at TestConversation1_0D then makes frame visible
    public void startGame(){
        setSituation(TestConversation1_0D.getInstance());
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
        actionPanel.initActions(currentSituation.getOptions()); //Changes buttons
    }
}

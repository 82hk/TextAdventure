package org.sherwoodhs;

import org.sherwoodhs.Situations.Testing.TestCombat1.TestCombat1_0C;
import org.sherwoodhs.Situations.Situation;
import org.sherwoodhs.Situations.Testing.TestConversation1.TestConversation1_0D;
import org.sherwoodhs.ui.ActionPanel;
import org.sherwoodhs.ui.SituationPanel;
import org.sherwoodhs.ui.TextPanel;

import java.awt.*;

import static org.sherwoodhs.ui.ActionPanel.actionPanel;
import static org.sherwoodhs.ui.Frame.FRAME;


public class AdvGame {
    private Situation currentSituation;

    private static AdvGame ikeaGame = new AdvGame();
    private SituationPanel situationPanel = SituationPanel.situationPanel;
    private TextPanel txt = TextPanel.textPanel;
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
        return ikeaGame;
    }

    //Changes situation and updates frame
    public void setSituation(Situation situation) {
        this.currentSituation = situation;
        updateFrame();
    }
    public Situation getCurrentSituation (){
        return currentSituation;
    }

    /* Updates the frame */
    public void updateFrame() {
        situationPanel.setSituationLabel(currentSituation.getTitle()); // Changes Situation Title
        txt.addText(currentSituation.getDescription()); // Changes textfield description
        actionPanel.initActions(currentSituation.getOptions()); //Changes buttons
    }
}

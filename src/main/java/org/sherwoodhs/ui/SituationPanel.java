package org.sherwoodhs.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Displays the current situation as a JLabel, nothing else
 */
public class SituationPanel extends JPanel {
    public static SituationPanel situationPanel = new SituationPanel();
    private JLabel situationLabel;
    private SituationPanel() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(900, 18));

        situationLabel = new JLabel("Situation Situation Situation");
        situationLabel.setText(getBoldText(situationLabel));
        add(situationLabel);
    }

    /**
     * Changes the text present in situationLabel to a String of choosing
     * @param text represents the text that the situationLabel will be set to
     */
    public void setSituationLabel(String text) {
        situationLabel.setText(text);
    }
    private String getBoldText(JLabel label) {
        String s = label.getText();
        return "<html><b>" + s + "</b></html>";
    }
    private String getBoldText(String s) {
        return "<html><b>" + s + "</b></html>";
    }
}

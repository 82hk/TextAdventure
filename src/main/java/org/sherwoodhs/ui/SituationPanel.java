package org.sherwoodhs.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SituationPanel extends JPanel {
    public static SituationPanel situationPanel = new SituationPanel();
    private JLabel situationLabel, timeLabel, dayLabel;
    private SituationPanel() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(900, 18));

        situationLabel = new JLabel("Sadness");
        situationLabel.setText(getBoldText(situationLabel));
        situationLabel.setBorder(new EmptyBorder(5, 5, 0, 0));
        add(situationLabel, BorderLayout.WEST);

        timeLabel = new JLabel("1:00");
        timeLabel.setBorder(new EmptyBorder(5, 0, 0, 5));
        add(timeLabel, BorderLayout.EAST);

        dayLabel = new JLabel("Day 1");
        dayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        dayLabel.setBorder(new EmptyBorder(5, 0, 0, 15));
        add(dayLabel, BorderLayout.CENTER);
    }

    /**
     * Changes the text present in situationLabel to a String of choosing
     * @param text represents the text that the situationLabel will be set to
     */
    public void setSituationLabel(String text) {
        situationLabel.setText(getBoldText(text));
    }
    /**
     * Changes the text present in timeLabel to a String of choosing
     * @param text represents the time that the timeLabel will be set to
     */
    public void setTimeLabel(String text) {
        timeLabel.setText(text);
    }
    /**
     * Changes the text present in dayLabel to a day number of choosing
     * @param day represents the day that the dayLabel will be set to + "Day"
     */
    public void setDayLabel(int day) {
        dayLabel.setText("Day " + day);
    }
    private String getBoldText(JLabel label) {
        String s = label.getText();
        return "<html><b>" + s + "</b></html>";
    }
    private String getBoldText(String s) {
        return "<html><b>" + s + "</b></html>";
    }
}

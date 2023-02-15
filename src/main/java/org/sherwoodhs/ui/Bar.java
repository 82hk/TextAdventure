package org.sherwoodhs.ui;

import javax.swing.*;
import java.awt.*;

public class Bar extends JPanel {
    private JProgressBar bar;
    private JLabel label;

    /**
     * Creates a Bar JPanel that contains a JLabel as an indicator for the bar, and a JProgressBar that indicates the value of the indicator
     * All bars are minimum 0, maximum 100
     * @param name represents the text of the JLabel that acts as a title for the bar
     * @param value represents the value of the bar when it is initialized
     */
    public Bar(String name, int value) {
        super(new GridLayout(0, 2));
        setPreferredSize(new Dimension(190, 28));

        label = new JLabel(name);

        bar = new JProgressBar(SwingConstants.HORIZONTAL, -100, 100);
        bar.setString(Integer.toString(value));
        bar.setStringPainted(true);
        bar.setPreferredSize(new Dimension(130, 28));
        bar.setValue(value);

        add(label);
        add(bar);
    }
    public void setvalue(int value) {
        bar.setString(Integer.toString(value));
    }
}

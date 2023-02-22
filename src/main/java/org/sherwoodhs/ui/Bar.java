package org.sherwoodhs.ui;

import javax.swing.*;
import java.awt.*;

public class Bar extends JPanel {
    private JProgressBar bar;
    private JLabel label;
    private final int r = 69, g = 64, b = 92;
    private int curR = r, curG = g, curB = b;

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

        setColor(value);

        bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
        bar.setValue(Math.abs(value));
        string(value);
        bar.setStringPainted(true);
        bar.setPreferredSize(new Dimension(130, 28));

        add(label);
        add(bar);
    }
    /**
     * Sets the value of the bar
     * @param value represents the current value of the bar
     */
    public void setValue(int value) {
        remove();

        setColor(value);

        bar = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
        bar.setValue(Math.abs(value));
        string(value);
        bar.setStringPainted(true);
        bar.setPreferredSize(new Dimension(130, 28));

        add(label);
        add(bar);
    }
    private void string(int value) {
        if (value == -100) {
            bar.setString("-MAX");
        } else if (value == 100) {
            bar.setString("MAX");
        } else {
            bar.setString(Integer.toString(value));
        }
    }
    private void remove() {
        Component[] comp = getComponents();
        for (Component element : comp) {
            remove(element);
        }
    }
    /**
     * Sets the color of the bar based upon an algorithm of how far away the value is away from 0
     * @param value represents the current value of the bar
     */
    private void setColor(int value) {
        try {
            if (value == 0) {
                UIManager.put("ProgressBar.foreground", new Color(r, g, b));
            } else {
                boolean isNegative = (value < 0);
                double constR, constG, constB;
                curR = r;
                curG = g;
                curB = b;
                if (isNegative) {
                    // 255, 95, 185
                    /*
                     * const represents 1 step the color values should take, out of 100 steps
                     */
                    constR = (255 - r) / 100.0;
                    constG = (95 - g) / 100.0;
                    constB = (185 - b) / 100.0;
                    for (int i = 0; i > value; i--) {
                        curR += constR;
                        curG += constG;
                        curB += constB;
                    }
                    UIManager.put("ProgressBar.foreground", new Color(curR, curG, curB));
                } else {
                    // if value is pos
                    // 90, 255, 155
                    /*
                     * const represents 1 step the color values should take, out of 100 steps
                     */
                    constR = (90 - r) / 100.0;
                    constG = (255 - g) / 100.0;
                    constB = (155 - b) / 100.0;
                    for (int i = 0; i < value; i++) {
                        curR += constR;
                        curG += constG;
                        curB += constB;
                    }
                    UIManager.put("ProgressBar.foreground", new Color(curR, curG, curB));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
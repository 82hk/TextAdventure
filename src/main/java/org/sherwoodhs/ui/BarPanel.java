package org.sherwoodhs.ui;

import org.sherwoodhs.World;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BarPanel extends JPanel {
    public static final BarPanel barPanel = new BarPanel();
    private Bar foundationBar = new Bar("Foundation", World.getInstance().getState("Foundation Rep"));
    private Bar havenBar = new Bar("Haven", World.getInstance().getState("Haven Rep"));
    private Bar clearWaterBar = new Bar("Clearwater", World.getInstance().getState("Clearwater Rep"));

    private BarPanel() {
        super(new FlowLayout(FlowLayout.CENTER));
        setPreferredSize(new Dimension(250, 170));
        setBorder(new TitledBorder("Reputation"));
        add(havenBar);
        add(clearWaterBar);
        add(foundationBar);
    }
    public Bar getFoundationBar() {
        return foundationBar;
    }
    public Bar getClearWaterBar() {
        return clearWaterBar;
    }
    public Bar getHavenBar() {
        return havenBar;
    }
}
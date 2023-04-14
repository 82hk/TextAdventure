package org.sherwoodhs.ui;

import org.sherwoodhs.World;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BarPanel extends JPanel {
    public static final BarPanel barPanel = new BarPanel();
    private Bar foundationBar = new Bar("Foundation", World.getInstance().getState("Foundation Rep"));
    private Bar havenBar = new Bar("Haven", World.getInstance().getState("Haven Rep"));
    private Bar clearwaterBar = new Bar("Clearwater", World.getInstance().getState("Clearwater Rep"));

    private BarPanel() {
        super(new FlowLayout(FlowLayout.CENTER));
        setPreferredSize(new Dimension(250, 170));
        setBorder(new TitledBorder("Reputation"));

        add(foundationBar);
        add(clearwaterBar);
        add(havenBar);

        setVisible(foundationBar, false);
        setVisible(clearwaterBar, false);
        setVisible(havenBar, false);

    }
    public void setVisible(Bar b, Boolean isVisible) {
        b.setVisible(isVisible);
    }
    public Bar getFoundationBar() {
        return foundationBar;
    }
    public Bar getClearwaterBar() {
        return clearwaterBar;
    }
    public Bar getHavenBar() {
        return havenBar;
    }
}
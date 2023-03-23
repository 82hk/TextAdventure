package org.sherwoodhs.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MapPanel extends JPanel {
    public static final MapPanel mapPanel = new MapPanel();

    private MapPanel() {
        super();
        setPreferredSize(new Dimension(150, 550));
        setBorder(new TitledBorder("Map"));
    }
}

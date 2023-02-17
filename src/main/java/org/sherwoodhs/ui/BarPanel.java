package org.sherwoodhs.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BarPanel extends JPanel {
    public static final BarPanel barPanel = new BarPanel();
    private BarPanel() {
        super(new FlowLayout(FlowLayout.CENTER));
        setPreferredSize(new Dimension(250, 170));
        setBorder(new TitledBorder("Reputation"));
        add(new Bar("Haven", 100));
        add(new Bar("Foundation", 75));
        add(new Bar("Clearwater", 50));
        add(new Bar("Separatists", 25));
    }
}
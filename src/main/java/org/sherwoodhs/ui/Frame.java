package org.sherwoodhs.ui;

import javax.swing.*;
import java.awt.*;

import static org.sherwoodhs.ui.ActionPanel.actionPanel;
import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;
import static org.sherwoodhs.ui.MapPanel.mapPanel;
import static org.sherwoodhs.ui.SituationPanel.situationPanel;
import static org.sherwoodhs.ui.TextPanel.textPanel;

public class Frame extends JFrame {
    public static final Frame FRAME = new Frame("Text Adventure");
    private final int WIDTH = 900, HEIGHT = 720;
    private Frame(String s) {
        super(s);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        add(situationPanel, BorderLayout.NORTH);

        // contains TextPanel, ActionPanel
        JPanel left = new JPanel();
        // contains MapPanel, InventoryPanel
        JPanel right = new JPanel();
        left.setPreferredSize(new Dimension(650, 720));
        right.setPreferredSize(new Dimension(250, 720));
        add(left, BorderLayout.WEST);
        add(right, BorderLayout.EAST);

        // adds all __Panel classes to each JPanel
        left.add(textPanel, BorderLayout.NORTH);
        left.add(actionPanel, BorderLayout.SOUTH);
        right.add(mapPanel, BorderLayout.NORTH);
        right.add(inventoryPanel, BorderLayout.SOUTH);

        pack();
    }
}


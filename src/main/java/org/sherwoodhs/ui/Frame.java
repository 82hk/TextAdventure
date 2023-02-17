package org.sherwoodhs.ui;

import javax.swing.*;
import java.awt.*;

import static org.sherwoodhs.ui.ActionPanel.actionPanel;
import static org.sherwoodhs.ui.BarPanel.barPanel;
import static org.sherwoodhs.ui.InventoryPanel.inventoryPanel;
import static org.sherwoodhs.ui.MapPanel.mapPanel;
import static org.sherwoodhs.ui.QuestPanel.questPanel;
import static org.sherwoodhs.ui.SituationPanel.situationPanel;
import static org.sherwoodhs.ui.TextPanel.textPanel;

public class Frame extends JFrame {
    public static final Frame FRAME = new Frame("Text Adventure");
    private final int WIDTH = 1000, HEIGHT = 720;

    private Frame(String s) {
        super(s);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(situationPanel, BorderLayout.NORTH);

        // contains TextPanel + QuestPanel, ActionPanel
        JPanel left = new JPanel();
        // contains MapPanel, InventoryPanel
        JPanel right = new JPanel();
        left.setPreferredSize(new Dimension(750, 720));
        right.setPreferredSize(new Dimension(250, 720));
        add(left, BorderLayout.WEST);
        add(right, BorderLayout.EAST);

        // contains TextPanel, QuestPanel
        JPanel partition = new JPanel();
        partition.setPreferredSize(new Dimension(750,550));
        FlowLayout layout = (FlowLayout) partition.getLayout();
        layout.setVgap(0);
        layout.setHgap(0);

        // adds all __Panel classes to each JPanel
        left.add(partition, BorderLayout.NORTH);
        left.add(actionPanel, BorderLayout.SOUTH);

        partition.add(textPanel, BorderLayout.WEST);
        partition.add(questPanel, BorderLayout.EAST);

        right.add(mapPanel, BorderLayout.NORTH);
        right.add(inventoryPanel, BorderLayout.CENTER);
        right.add(barPanel, BorderLayout.SOUTH);

        pack();
    }
}
package org.sherwoodhs.ui.util;

import javax.swing.*;
import java.awt.*;

/**
 * Renders JList components as JTextAreas that can wrap lines
 */
public class CellRenderer implements ListCellRenderer {
    private JPanel panel;
    private JTextArea textArea;

    public CellRenderer() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        panel.add(textArea, BorderLayout.CENTER);
    }
    @Override
    public Component getListCellRendererComponent(final JList list, final Object value, final int index, final boolean isSelected, final boolean hasFocus) {
        textArea.setText((String) value);
        int width = list.getWidth();
        if (width > 0)
            textArea.setSize(width, Short.MAX_VALUE);
        return panel;
    }
}
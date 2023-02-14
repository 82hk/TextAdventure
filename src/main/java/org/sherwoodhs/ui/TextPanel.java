package org.sherwoodhs.ui;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    public static final TextPanel textPanel = new TextPanel();
    private DefaultListModel<String> textListModel = new DefaultListModel<>();
    private JList<String> textList;


    private TextPanel() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(650,550));

        textList = new JList<>(textListModel);
        textList.setSelectionModel(new DisabledItemSelectionModel());
        textList.setCellRenderer(new CellRenderer());
        add(textList);

        addText("Text");
    }
    /**
     * Adds one element to textList without clearing its contents, can contain escape sequences
     * @param text one element to be added to TextList
     */
    public void addText(String... text) {
        for (String element : text) {
            textListModel.addElement(element);
        }
    }
    /**
     * Adds a blank line to textList, akin to two <br> tags in HTML
     */
    public void addBlank() {
        textListModel.addElement("");
    }
    /**
     * Clears all content inside textList
     */
    public void clearAllText() {
        textListModel.clear();
    }
}
// renders JList components as JTextAreas that can wrap lines
class CellRenderer implements ListCellRenderer {
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
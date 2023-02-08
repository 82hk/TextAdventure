package org.sherwoodhs.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.regex.Pattern;

public class TextPanel extends JPanel {
    public static final TextPanel textPanel = new TextPanel();
    private DefaultListModel<String> textListModel = new DefaultListModel<>();
    private JList<String> textList;
    private TextPanel() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(650,550));
        setBorder(new TitledBorder("Dialogue"));

        textList = new JList<>(textListModel);
        textList.setSelectionModel(new DisabledItemSelectionModel());
        textList.setCellRenderer(new CellRenderer());
        add(textList);
    }
    /**
     * Adds one element to textList without clearing its contents, can contain escape sequences
     * @param s one element to be added to TextList
     */
    public void addText (String s) {
        parseEscapeSequences(s);
    }
    private void parseEscapeSequences(String s) {
        // split String s into a number of parts denoted by \
        String[] parts = s.split(Pattern.quote("\\"), -1);
        // if there are no escape sequences, return
        if (parts.length == 0)
            return;
        textListModel.addElement(parts[0]);
        // skip parts[0] since there will be no escape sequences there
        for (int i = 1; i < parts.length; i++) {
            // if the escape sequence is '\n', add that element on a separate line
            if (parts[i].charAt(0) == 'n') {
                textListModel.addElement(parts[i].substring(1));
            }
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
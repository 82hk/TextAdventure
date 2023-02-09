package org.sherwoodhs.ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.View;
import java.awt.*;

import static org.sherwoodhs.ui.TextPanel.textPanel;

public class TextPanel extends JPanel {
    public static final TextPanel textPanel = new TextPanel();
    private DefaultListModel<String> textListModel = new DefaultListModel<>();
    private JList<String> textList;
    private int currentLines = 0;
    private final int maximumLines = 33;
    private TextPanel() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(650,550));
        setBorder(new TitledBorder("Dialogue"));

        textList = new JList<>(textListModel);
        textList.setSelectionModel(new DisabledItemSelectionModel());
        textList.setCellRenderer(new CellRenderer());
        add(textList);

        addText("Text");
    }
    /**
     * Adds one element to textList without clearing its contents, can contain escape sequences
     * @param s one element to be added to TextList
     */
    public void addText (String... s) {
        parseEscapeSequences(s);
    }
    private void parseEscapeSequences(String... s) {
        for (String element : s) {
            textListModel.addElement(element);
        }
        update();
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

    /**
     * Recieves the amount of wrapped lines from getWrappedLines() in CellRenderer
     * @param currentLines represents the amount of lines in the JTextArea cast from a JList
     */
    public void setCurrentLines(int currentLines) {
        this.currentLines = currentLines;
        update();
    }

    /**
     * Deletes excess lines from JList
     */
    public void update() {
        System.out.println(currentLines);
        if (currentLines > maximumLines) {
            int overflow = currentLines - maximumLines;
            System.out.println(overflow);
            for (int i = 0; i < overflow; i++) {
                textListModel.remove(0);
            }
        }
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
        textPanel.setCurrentLines(getWrappedLines(textArea));
        textArea.setText((String) value);
        int width = list.getWidth();
        if (width > 0)
            textArea.setSize(width, Short.MAX_VALUE);
        return panel;
    }
    public static int getWrappedLines(JTextArea component) {
        View view = component.getUI().getRootView(component).getView(0);
        int preferredHeight = (int) view.getPreferredSpan(View.Y_AXIS);
        int lineHeight = component.getFontMetrics(component.getFont()).getHeight();
        return (preferredHeight / lineHeight);
    }
}
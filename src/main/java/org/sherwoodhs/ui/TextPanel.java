package org.sherwoodhs.ui;

//import org.sherwoodhs.ui.util.CellRenderer;
//import org.sherwoodhs.ui.util.DisabledItemSelectionModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import static org.sherwoodhs.ui.Frame.FRAME;

public class TextPanel extends JPanel implements Runnable {
    public static final TextPanel textPanel = new TextPanel();
    //private DefaultListModel<String> textListModel = new DefaultListModel<>();
    //private JList<String> textList;
    private JTextArea textArea = new JTextArea();

    private TextPanel() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(600,550));
        setBorder(new TitledBorder("Dialogue"));

        //textList = new JList<>(textListModel);
        //textList.setSelectionModel(new DisabledItemSelectionModel());
        //textList.setCellRenderer(new CellRenderer());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setText(" ");
        add(textArea);
    }
    /**
     * Adds one element to textList without clearing its contents, can contain escape sequences
     * @param s one element to be added to TextList
     */
    public void addText(String... s) {

        for (String element : s) {
            String letter = " ";
            for (int i = 0; i < element.length(); i++) {

                letter =  String.valueOf(element.charAt(i));

                textArea.append(letter);
                System.out.print(letter);

                try {
                    Thread.sleep(15);
                } catch (Exception e) {
                    System.out.println("Error.");
                    textArea.append("Error.");
                }
            }

        }
    }
    /**
     * Adds a blank line to textList, akin to two <br> tags in HTML
     */
    public void addBlank() {
        textArea.append("\n");
    }
    /**
     * Clears all content inside textList
     */
    public void clearAllText() {
        textArea.removeAll();
    }

    @Override
    public void run() { // would having the TextPanel run (animate) separately work?

    }
}
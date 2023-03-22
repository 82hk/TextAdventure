package org.sherwoodhs.ui;


import org.sherwoodhs.AdvGame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.sherwoodhs.ui.Frame.FRAME;

public class MenuPanel extends JPanel {

    public static final MenuPanel menuPanel = new MenuPanel();
    private MenuPanel() {
        super();
        setPreferredSize(new Dimension(250, 250));
        setBorder(new TitledBorder("Main Menu"));

        JButton start = new JButton(getWrappedText("Start")); // START
        start.setPreferredSize(new Dimension(150,40));
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FRAME.removeAll();
                FRAME.initGameLayout();
                AdvGame adv = AdvGame.getInstance();
                adv.startGame();

            }
        });

        JButton exit = new JButton(getWrappedText("Exit")); // EXIT
        start.setPreferredSize(new Dimension(150,40));
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.exit(0);
            }
        });

        add(start);
        add(exit);
    }

    public void startMenu() {
        FRAME.initMenuLayout();
        FRAME.setVisible(true);
    }

    private String getWrappedText(String s) {
        s = "<html><center>" + s + "</center></html>";
        return s;
    }

    public static MenuPanel getInstance() {
        return menuPanel;
    }
}

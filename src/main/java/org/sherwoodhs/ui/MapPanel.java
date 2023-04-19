package org.sherwoodhs.ui;;

import org.sherwoodhs.AdvGame;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {
    public static final MapPanel mapPanel = new MapPanel();

    ImageIcon placeholder = new ImageIcon("src/main/java/org/sherwoodhs/imgs/placeholder.png");
    ImageIcon temp = new ImageIcon("src/main/java/org/sherwoodhs/imgs/entrance/entrance.jpg");
    ImageIcon img = new ImageIcon("src/main/java/org/sherwoodhs/imgs/entrance/entrance.jpg");
    ImageIcon scaledImg = new ImageIcon(img.getImage().getScaledInstance(240, 240, Image.SCALE_DEFAULT));
    JLabel label = new JLabel(scaledImg, JLabel.CENTER);

    private MapPanel() {
        super();
        setPreferredSize(new Dimension(250, 250));
        add(label);
    }

    //use to update the image, there are a gazillion updateframe methods and im not gonna figure out how which ones to put it in
    public void updateImg(){
        try {
            img = AdvGame.getInstance().getCurrentSituation().getImg();
            scaledImg = new ImageIcon(img.getImage().getScaledInstance(240, 240, Image.SCALE_DEFAULT));

            scaledImg.getImage().flush();
            label.setIcon(scaledImg);
        } catch (NullPointerException e){
            label.setIcon(temp);
        }
    }
}
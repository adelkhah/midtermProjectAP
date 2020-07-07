package com;

import javax.swing.*;

public class Victory {
    JFrame jFrame = new JFrame("victory");
    public Victory(){
        Game.jFrame.setVisible(false);
        ImageIcon icon = new ImageIcon("src\\com\\vic.png");
        JLabel label = new JLabel(icon);
        jFrame.setSize(654,536);

        jFrame.add(label);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

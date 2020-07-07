package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class EnteringScreen implements ActionListener {
    JFrame jFrame;
    public EnteringScreen(){
        jFrame = new JFrame();
        ImageIcon icon = new ImageIcon("src\\com\\dota_heroes.png");
        JLabel label = new JLabel(icon);
        jFrame.setSize(1220,670);
        JButton jButton = new JButton("PLAY");
        jButton.setBounds(550,470,110,40);
        jButton.setBackground(Color.black);
        jButton.setForeground(Color.green);
        label.add(jButton);
        jButton.addActionListener(this);
        jFrame.add(label);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jFrame.dispose();
        StartGame.creat();
    }
}

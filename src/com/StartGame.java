package com;

import com.sun.nio.sctp.PeerAddressChangeNotification;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGame implements ActionListener {
    static JFrame jFrame;
    static int tedad = 0;
    static JLabel[] labels = new JLabel[5];
    static String[] names = new String[5];
    static JLabel label;
    static JButton jButton;
    static JButton jButtone = new JButton("Exit");
    static JButton jButtonr = new JButton("Remove");
    static JButton cont = new JButton("continue");
    static JButton jButton1 = new JButton("Start");
    static boolean sw = false;
    static void creat(){
        cont.setBounds(5,360,130,30);
        cont.setBackground(Color.black);
        cont.setForeground(Color.green);
        cont.addActionListener(new StartGame());


        jFrame = new JFrame();
        jFrame.setBackground(Color.black);
        ImageIcon icon = new ImageIcon("src\\com\\dota.jpg");
        label = new JLabel(icon);
        jFrame.setSize(1000,600);
        jButton = new JButton("Add \n Member");

        jButton1.setForeground(Color.GREEN);
        jButton1.setBackground(Color.black);
        jButtone.setForeground(Color.GREEN);
        jButtone.setBackground(Color.black);
        jButtone.setBounds(5,130,130,30);
        label.add(jButtone);
        jButtone.addActionListener(new StartGame());
        jButton1.setBounds(360,520,300,30);
        jButton.setBackground(Color.black);
        jButton.setForeground(Color.GREEN);
        jButton1.addActionListener(new StartGame());
        jButton.addActionListener(new StartGame());
        jButton.setBounds(5,30,130,30);
        jButtonr.addActionListener(new StartGame());
        jButtonr.setBounds(5,80,130,30);
        jButtonr.setBackground(Color.black);
        jButtonr.setForeground(Color.GREEN);
        labels[0] = new JLabel();
        labels[0].setBounds(440,50,200,50);
        labels[0].setForeground(Color.MAGENTA);
        labels[1] = new JLabel();
        labels[1].setBounds(440,50,200,100);
        labels[1].setForeground(Color.blue);
        labels[2] = new JLabel();
        labels[2].setBounds(440,50,200,150);
        labels[2].setForeground(Color.cyan);
        labels[3] = new JLabel();
        labels[3].setBounds(440,50,200,200);
        labels[3].setForeground(Color.black);
        label.add(jButton);
        label.add(cont);
        label.add(labels[0]);
        label.add(labels[1]);
        label.add(labels[2]);
        label.add(labels[3]);
        label.add(jButton1);
        label.add(jButtonr);
        jFrame.add(label);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(jButton) && !sw){
            new AddMember();
        }
        else if(e.getSource().equals(jButtonr) && !sw){
            tedad--;
            labels[tedad].setText("");
        }
        else if(e.getSource().equals(jButtone)){
            jFrame.dispose();
        }
        else if(e.getSource().equals(cont) && sw){
            jFrame.setVisible(false);
            Game.jFrame.setVisible(true);
        }
        else if(e.getSource().equals(jButton1) && !sw) {
            sw = true;
            jFrame.setVisible(false);
            Game.creat();
        }
    }

}

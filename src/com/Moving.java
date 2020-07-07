
package com;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Moving implements ActionListener {
    JFrame f = new JFrame("Moving forces");
    JButton jButton = new JButton("OK");
    JLabel label = new JLabel("how many soldier you want to move?");
    public Moving() {

        jButton.setBackground(Color.black);
        jButton.setForeground(Color.green);
        jButton.setBounds(95, 170, 70, 25);
        jButton.addActionListener(this);
        label.setBounds(30,20,250,30);

        SpinnerModel value =
                new SpinnerNumberModel(0, //initial value
                        0, //minimum value
                        Game.tedad_sarbaz_in_city[0][Game.ii][Game.jj]-1, //maximum value
                        1); //step
        JSpinner spinner = new JSpinner(value);
        spinner.setBounds(100, 100, 50, 30);
        f.add(jButton);
        f.add(spinner);
        f.add(label);
        f.setSize(300, 250);
        f.setLayout(null);
        f.setVisible(true);

        spinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                Game.nubmer_of_moving_soldier = (int) ((JSpinner) e.getSource()).getValue();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.dispose();
    }
}
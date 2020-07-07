package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class AddMember implements ActionListener {
    JFrame jFrame;
    JTextField jTextField;

    public AddMember(){
        ImageIcon imageIcon = new ImageIcon("src\\com\\images.jpg");
        JLabel jLabel = new JLabel(imageIcon);
        jFrame = new JFrame("Add Member");
        jFrame.setSize(300,210);
        JButton jButton = new JButton("Add");
        jButton.setBackground(Color.black);
        jButton.setForeground(Color.GREEN);
        jButton.setBounds(100,130,70,25);
        jTextField = new JTextField();
        jTextField.setBounds(80,3,140,25);
        jTextField.setBackground(Color.CYAN);
        jLabel.add(jTextField);
        jLabel.add(jButton);
        jFrame.add(jLabel);
        jFrame.setVisible(true);
        jButton.addActionListener(this);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(StartGame.tedad < 4) {
            StartGame.names[StartGame.tedad] = jTextField.getText();
            StartGame.labels[StartGame.tedad].setText( (StartGame.tedad + 1) + " _ " + StartGame.names[StartGame.tedad]);

            StartGame.tedad++;
        }
        jFrame.setVisible(false);

    }

}

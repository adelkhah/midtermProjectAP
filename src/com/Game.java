package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener{
    static int n = StartGame.tedad;
    static int[] cnt_city_harki = new int[5];
    static int[] max_cnt_harki = new int[5];
    static int[] sarbaz_alan_harki = new int[5];
    static int[][][] male_kie_city = new int[1000][7][6];
    static int[][][] tedad_sarbaz_in_city = new int[1000][7][6];

    static JButton undo = new JButton("Undo");

    static int nobat_kie = 0;
    static int doore_chandom = 0;
    static int marhale = 0;
    static int faz = 1;
    static int ii = -1;
    static int jj = -1;
    static int iii = -1;
    static int jjj = -1;
    static JButton menu = new JButton("Menu");
    static int nubmer_of_moving_soldier = 0;
    static JLabel vaziat = new JLabel("vaziat bazy : pick and place");
    static JLabel nobat = new JLabel("nobate kie : ");
    static JButton noMoving = new JButton("no move force");
    static JLabel[] attack_tos = new JLabel[4];
    static JLabel[] def_tos = new JLabel[3];
    static JFrame jFrame = new JFrame();
    static JLabel jLabel = new JLabel();
    static JButton back = new JButton("BACK");
    static JButton[][] jButton = new JButton[7][6];
    static JLabel labale_sarbazha = new JLabel();
    static JButton noattack = new JButton("no more attack");

    static void change_trun(){
        nobat_kie = (nobat_kie+1) % n;
        nobat.setText("nobate kie : " + StartGame.names[nobat_kie]);
        if(nobat_kie == 0){
            nobat.setForeground(Color.MAGENTA);
        }
        if(nobat_kie == 1){
            nobat.setForeground(Color.blue);
        }
        if(nobat_kie == 2){
            nobat.setForeground(Color.cyan);
        }
        if(nobat_kie == 3){
            nobat.setForeground(Color.black);
        }

    }

    static void makebutt(){


        menu.setBackground(Color.black);
        menu.setForeground(Color.green);
        menu.setBounds(1200,10,70,25);
        menu.addActionListener(new Game());
        jLabel.add(menu);
        nobat.setBounds(900,100,200,40);
        nobat.setText("nobate kie : " + StartGame.names[nobat_kie]);
        nobat.setForeground(Color.MAGENTA);
        jLabel.add(nobat);
        vaziat.setBounds(300,500,230,40);
        jLabel.add(vaziat);
        noMoving.setBounds(1000,400,130,40);
        noMoving.setBackground(Color.black);
        noMoving.setForeground(Color.green);
        noMoving.addActionListener(new Game());
        jLabel.add(noMoving);

        for(int i = 0; i < 3; i++){
            attack_tos[i] = new JLabel();
            attack_tos[i].setBounds(100,500,50,i*50 + 50);
            jLabel.add(attack_tos[i]);
        }
        attack_tos[3] = new JLabel("atk");
        attack_tos[3].setBounds(100,450,50,50);
        jLabel.add(attack_tos[3]);
        for(int i = 0; i < 2; i++){
            def_tos[i] = new JLabel();
            def_tos[i].setBounds(160,500,50,i*50 + 50);
            jLabel.add(def_tos[i]);
        }
        def_tos[2] = new JLabel("def");
        def_tos[2].setBounds(160,450,50,50);
        jLabel.add(def_tos[2]);

        back.setBackground(Color.black);
        back.setForeground(Color.green);
        back.setBounds(1000,300,130,40);
        back.addActionListener(new Game());
        jLabel.add(back);
        noattack.setBackground(Color.black);
        noattack.setForeground(Color.green);
        noattack.setBounds(1000,500,130,40);
        jLabel.add(noattack);
        noattack.addActionListener(new Game());
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
                jButton[i][j] = new JButton();
            }
        }

        for(int i = 0; i < 6; i++){
            jButton[i][0].setBackground(Color.gray);
        }
        for(int i = 0; i < 4; i++){
            for(int j = 4; j < 6; j++){
                jButton[i][j].setBackground(Color.green);
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 2; j < 4; j++){
                jButton[i][j].setBackground(Color.red);
            }
        }
        for(int j = 0; j < 6; j++){
            if(j == 2){
                jButton[6][j].setBackground(Color.yellow);
            }
            else {
                jButton[6][j].setBackground(Color.blue);
                for(int i = 0; i < 1000; i++) {
                    male_kie_city[i][6][j] = 1000;
                }
            }
        }
        for(int i = 0; i < 6; i++){
            if(i == 5 || i < 2){
                jButton[i][1].setBackground(Color.gray);
            }
            else{
                jButton[i][1].setBackground(Color.blue);
                for(int j = 0; j < 1000; j++) {
                    male_kie_city[j][i][1] = 1000;
                }

            }
        }

        for(int i = 3; i < 7; i++){
            for(int j = 2; j < 4; j++){
                if( (i == 3 && j == 2) || (i == 6 && j == 3) ){
                    jButton[i][j].setBackground(Color.blue);
                    for(int k = 0; k < 1000; k++) {
                        male_kie_city[k][i][j] = 1000;
                    }
                }
                else{
                    jButton[i][j].setBackground(Color.yellow);
                }
            }
        }
        for(int i = 4; i < 6; i++){
            for(int j = 4; j < 6; j++){
                jButton[i][j].setBackground(Color.blue);
                for(int k = 0; k < 1000; k++) {
                    male_kie_city[k][i][j] = 1000;
                }
            }
        }

        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
                jButton[i][j].setBounds(j*130 + 30,i*40 + 30 ,130,40);
            }
        }

        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
                jLabel.add(jButton[i][j]);
            }
        }

        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
                jButton[i][j].addActionListener(new Game());
            }
        }


        jFrame.setSize(1300,700);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        labale_sarbazha.setBounds(900,70,100,40);
        jLabel.add(labale_sarbazha);
        jFrame.add(jLabel);

        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);

    }

    static void update(){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
                if(jButton[i][j].getBackground() == Color.blue){
                    continue;
                }
                int id = male_kie_city[doore_chandom][i][j];
                jButton[i][j].setText(tedad_sarbaz_in_city[doore_chandom][i][j] + "");
                if(id == 0){
                    jButton[i][j].setForeground(Color.MAGENTA);
                }
                if(id == 1){
                    jButton[i][j].setForeground(Color.blue);
                }
                if(id == 2){
                    jButton[i][j].setForeground(Color.cyan);
                }
                if(id == 3){
                    jButton[i][j].setForeground(Color.black);
                }
            }
        }

    }

    static int which(){
        double x = -1;
        int id = 0;
        for(int i = 0; i < n; i++){
            if(cnt_city_harki[i] < max_cnt_harki[i]) {
                double y = Math.random();
                if (y > x) {
                    x = y;
                    id = i;
                }
            }
        }
        return id;

    }

    static void sarbaz_gozry(){
        labale_sarbazha.setText("sarbaz : " + sarbaz_alan_harki[nobat_kie]);


        boolean sw = true;
        for(int ii = 0; ii < n; ii++){
            if(sarbaz_alan_harki[ii] != 0){
                sw = false;
            }
        }

        if(sw){
            marhale = 1;
            nobat_kie = 0;
            EdameGame.bazy_kon();
            return;
        }
        if(sarbaz_alan_harki[nobat_kie] == 0){
            nobat_kie = (nobat_kie+1) % n;
            sarbaz_gozry();
        }


    }

    static void creat(){

        makebutt();
        if(n == 2){
            sarbaz_alan_harki[0] = 30;
            sarbaz_alan_harki[1] = 30;
        }
        if(n == 3){
            sarbaz_alan_harki[0] = 25;
            sarbaz_alan_harki[1] = 25;
            sarbaz_alan_harki[2] = 25;

        }
        if(n == 4){
            sarbaz_alan_harki[0] = 20;
            sarbaz_alan_harki[1] = 20;
            sarbaz_alan_harki[2] = 20;
            sarbaz_alan_harki[3] = 20;
        }
        int ma = 29;
        for(int i = 0; i < n; i++){
            max_cnt_harki[i] = ma/(n-i);
            ma -= max_cnt_harki[i];
        }

        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
                if(i == 6 && j != 2){
                    continue;
                }
                if(i == 5 && j == 4){
                  continue;
                }
                if(i == 5 && j == 5){
                    continue;
                }
                if(i == 4 && j == 4){
                    continue;
                }
                if(i == 4 && j == 5){
                    continue;
                }
                if(j == 1 && (i == 2 || i == 3 || i == 4)){
                    continue;
                }
                if(i == 3 && j == 2){
                    continue;
                }
                int y = which();
                male_kie_city[doore_chandom][i][j] = y;
                tedad_sarbaz_in_city[doore_chandom][i][j] = 1;
                sarbaz_alan_harki[y]--;
                cnt_city_harki[y]++;
            }
        }
        update();
        sarbaz_gozry();

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(marhale == 0){
            if(sarbaz_alan_harki[nobat_kie] == 0){
                change_trun();
                sarbaz_gozry();
                return;
            }
            for(int i = 0; i < 7; i++){
                for(int j = 0; j < 6; j++){
                    if(male_kie_city[doore_chandom][i][j] == nobat_kie && e.getSource().equals(jButton[i][j])){
                        tedad_sarbaz_in_city[doore_chandom][i][j]++;
                        jButton[i][j].setText(tedad_sarbaz_in_city[doore_chandom][i][j] + " ");
                        sarbaz_alan_harki[nobat_kie]--;
                        change_trun();
                        sarbaz_gozry();

                        return;


                    }
                }
            }
        }
        else if(marhale == 1 && faz == 1){

            for(int i = 0; i < 7; i++){
                for(int j = 0; j < 6; j++){
                    if(male_kie_city[doore_chandom][i][j] == nobat_kie && e.getSource().equals(jButton[i][j])){

                        tedad_sarbaz_in_city[doore_chandom][i][j]++;
                        jButton[i][j].setText(tedad_sarbaz_in_city[doore_chandom][i][j] + " ");
                        sarbaz_alan_harki[nobat_kie]--;

                        EdameGame.show_sarbaz();
                        return;

                    }
                }
            }
        }
        else if(marhale == 1 && faz == 2){
            if(e.getSource().equals(noattack)){
                faz = 3;
                vaziat.setText("vaziat bazy : enteghal niro ha");
                ii = -1;
                jj = -1;
                iii = -1;
                jjj = -1;
                return;
            }
            if(e.getSource().equals(back)){
                ii = -1;
                jj = -1;
            }
            if(ii == -1){
                for(int i = 0; i < 7; i++){
                    for(int j = 0; j < 6; j++){
                        if(male_kie_city[doore_chandom][i][j] == nobat_kie && e.getSource().equals(jButton[i][j])){
                            ii = i;
                            jj = j;
                        }
                    }
                }
            }
            else{
                for(int i = 0; i < 7; i++){
                    for(int j = 0; j < 6; j++){
                        if(male_kie_city[doore_chandom][i][j] == 1000){
                            continue;
                        }
                        if( ((i > ii || i < ii) && (j > jj || j < jj)) || (ii == i && jj == j)){
                            continue;
                        }
                        if(i > ii+1 || i < ii-1){
                            continue;
                        }
                        if(j > jj+1 || j < jj-1){
                            continue;
                        }
                        if(male_kie_city[0][i][j] != nobat_kie && e.getSource().equals(jButton[i][j])){
                            iii = i;
                            jjj = j;
                            EdameGame.attack();

                        }
                    }
                }
            }
        }
        else if(marhale == 1 && faz == 3){
            if(e.getSource().equals(back)){
                ii = -1;
                jj = -1;
            }
            if(e.getSource().equals(noMoving)){
                change_trun();
                faz = 1;
                vaziat.setText("vaziat bazy : sarbaz gozary");
                EdameGame.bazy_kon();
            }
            if(ii != -1){

                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (male_kie_city[0][i][j] == 1000) {
                            continue;
                        }

                        if (male_kie_city[0][i][j] == nobat_kie && e.getSource().equals(jButton[i][j])) {
                            iii = i;
                            jjj = j;
                            EdameGame.move_forces();
                        }
                    }
                }
            }
            if(ii == -1) {
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (male_kie_city[0][i][j] == 1000) {
                            continue;
                        }

                        if (male_kie_city[0][i][j] == nobat_kie && e.getSource().equals(jButton[i][j])) {
                            ii = i;
                            jj = j;
                            new Moving();
                        }
                    }
                }
            }


        }
        if(e.getSource().equals(menu)){
            jFrame.setVisible(false);
            StartGame.jFrame.setVisible(true);
        }

    }
}

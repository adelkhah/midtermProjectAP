package com;

import java.awt.*;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.Arrays;
import java.util.Random;

public class EdameGame {

    static int[][] mark = new int[7][6];

    static boolean asia(int id){
        boolean sw = true;
        for(int i = 0; i < 4; i++){
            for(int j = 4; j < 6; j++){
                if(id != Game.male_kie_city[0][i][j]){
                    sw = false;
                }
            }
        }

        return sw;
    }
    static boolean afrigha(int id){
        boolean sw = true;
        for(int i = 3; i < 7; i++){
            for(int j = 2; j < 4; j++){
                if((i==3 && j == 2) || (i == 6 && j == 3)){
                    continue;
                }
                if(Game.male_kie_city[0][i][j] != id){
                    sw = false;
                }
            }
        }

        return sw;
    }
    static boolean amrica(int id){
        boolean sw = true;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 2; j++){
                if(j == 1 && (i == 2 || i == 3 || i == 4)){
                    continue;
                }
                if(Game.male_kie_city[0][i][j] != id){
                    sw = false;
                }
            }
        }

        return sw;
    }
    static boolean oropa(int id){
        boolean sw = true;
        for(int i = 0; i < 3; i++){
            for(int j = 2; j < 4; j++){
                if(id != Game.male_kie_city[0][i][j]){
                    sw = false;
                }
            }
        }
        return sw;
    }

    static void show_sarbaz(){

        Game.labale_sarbazha.setText("sarbaz : " + Game.sarbaz_alan_harki[Game.nobat_kie]);
        Game.vaziat.setText("vaziat bazy : sarbaz gozary");
        Game.nobat.setText("nobate kie : " + StartGame.names[Game.nobat_kie]);
        if(Game.nobat_kie == 0){
            Game.nobat.setForeground(Color.MAGENTA);
        }
        if(Game.nobat_kie == 1){
            Game.nobat.setForeground(Color.blue);
        }
        if(Game.nobat_kie == 2){
            Game.nobat.setForeground(Color.cyan);
        }
        if(Game.nobat_kie == 3){
            Game.nobat.setForeground(Color.black);
        }
        if(Game.sarbaz_alan_harki[Game.nobat_kie] == 0){
            Game.faz = 2;
            Game.vaziat.setText("vaziat bazy : hamle");
        }
    }


    static void first_move(){

        int cnt = 0;
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
                if(Game.male_kie_city[0][i][j] == Game.nobat_kie){
                    cnt++;
                }
            }
        }
        cnt /= 3;
        if(afrigha(Game.nobat_kie)){
            cnt += 2;
        }
        if(amrica(Game.nobat_kie)){
            cnt += 3;
        }
        if(oropa(Game.nobat_kie)){
            cnt += 4;
        }
        if(asia(Game.nobat_kie)){
            cnt += 4;
        }
        Game.sarbaz_alan_harki[Game.nobat_kie] = cnt;
        show_sarbaz();
    }
    static void dfs(int x, int y){
        mark[x][y] = 1;
        //System.out.println(x + " " + y);
        if(x-1 >= 0 && Game.male_kie_city[0][x-1][y] == Game.male_kie_city[0][x][y] && mark[x-1][y] == 0){
            dfs(x-1,y);
        }
        if(x+1 < 7 && Game.male_kie_city[0][x+1][y] == Game.male_kie_city[0][x][y] && mark[x+1][y] == 0){
            dfs(x+1,y);
        }
        if(y-1 >= 0 && Game.male_kie_city[0][x][y-1] == Game.male_kie_city[0][x][y] && mark[x][y-1] == 0){
            dfs(x,y-1);
        }
        if(y+1 < 6 && Game.male_kie_city[0][x][y+1] == Game.male_kie_city[0][x][y] && mark[x][y+1] == 0){
            dfs(x,y+1);
        }

    }
    static void move_forces(){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
                mark[i][j] = 0;
            }
        }
        dfs(Game.ii,Game.jj);
        if(mark[Game.iii][Game.jjj] == 1){
            Game.tedad_sarbaz_in_city[0][Game.ii][Game.jj] -= Game.nubmer_of_moving_soldier;
            Game.tedad_sarbaz_in_city[0][Game.iii][Game.jjj] += Game.nubmer_of_moving_soldier;
            Game.ii = -1;
            Game.jj = -1;
            Game.jjj = -1;
            Game.iii = -1;
            Game.update();
            Game.change_trun();
            Game.faz = 1;
            Game.vaziat.setText("vaziat bazy : sarbaz gozary");
            bazy_kon();
        }

    }
    static void attack(){
        for(int i = 0; i < 3; i++){
            Game.attack_tos[i].setText("");
        }
        for(int i = 0; i < 2; i++){
            Game.def_tos[i].setText("");
        }
        int cnt_attack = Game.tedad_sarbaz_in_city[0][Game.ii][Game.jj];
        if(cnt_attack < 4){
            cnt_attack -= 1;
        }
        else{
            cnt_attack = 3;
        }
        int cnt_def = Game.tedad_sarbaz_in_city[0][Game.iii][Game.jjj];
        if(cnt_def > 1){
            cnt_def = 2;
        }
        Random rand = new Random();

        int[] att = new int[cnt_attack];
        int[] def = new int[cnt_def];
        for(int i = 0; i < cnt_attack; i++){
            att[i] = rand.nextInt(6) + 1;
            att[i] *= -1;
        }
        for(int i = 0; i < cnt_def; i++){
            def[i] = rand.nextInt(6) + 1;
            def[i] *= -1;
        }
        Arrays.sort(att);
        Arrays.sort(def);
        for(int i = 0; i < cnt_attack; i++){
            att[i] *= -1;
        }
        for(int i = 0; i < cnt_def; i++){
            def[i] *= -1;
        }

        for(int i = 0; i < cnt_attack; i++){
            Game.attack_tos[i].setText(att[i] + "");
            if(Game.male_kie_city[Game.doore_chandom][Game.ii][Game.jj]  == 0){
                Game.attack_tos[i].setForeground(Color.magenta);
            }
            if(Game.male_kie_city[Game.doore_chandom][Game.ii][Game.jj]  == 1){
                Game.attack_tos[i].setForeground(Color.blue);
            }
            if(Game.male_kie_city[Game.doore_chandom][Game.ii][Game.jj]  == 2){
                Game.attack_tos[i].setForeground(Color.cyan);
            }
            if(Game.male_kie_city[Game.doore_chandom][Game.ii][Game.jj]  == 3){
                Game.attack_tos[i].setForeground(Color.black);
            }
        }

        for(int i = 0; i < cnt_def; i++){
            Game.def_tos[i].setText(def[i] + "");
            if(Game.male_kie_city[Game.doore_chandom][Game.iii][Game.jjj]  == 0){
                Game.def_tos[i].setForeground(Color.magenta);
            }
            if(Game.male_kie_city[Game.doore_chandom][Game.iii][Game.jjj]  == 1){
                Game.def_tos[i].setForeground(Color.blue);
            }
            if(Game.male_kie_city[Game.doore_chandom][Game.iii][Game.jjj]  == 2){
                Game.def_tos[i].setForeground(Color.cyan);
            }
            if(Game.male_kie_city[Game.doore_chandom][Game.iii][Game.jjj]  == 3){
                Game.def_tos[i].setForeground(Color.black);
            }
        }

        int att_dead = 0;
        int def_dead = 0;
        for(int i = 0; i < Math.min(cnt_attack,cnt_def); i++){
            if(def[i] < att[i]){
                def_dead++;
            }
            else{
                att_dead++;
            }
        }

        Game.tedad_sarbaz_in_city[0][Game.ii][Game.jj] -= att_dead;
        Game.tedad_sarbaz_in_city[0][Game.iii][Game.jjj] -= def_dead;
        if(Game.tedad_sarbaz_in_city[0][Game.iii][Game.jjj] == 0){
            Game.tedad_sarbaz_in_city[0][Game.ii][Game.jj]--;
            Game.male_kie_city[0][Game.iii][Game.jjj] = Game.male_kie_city[0][Game.ii][Game.jj];
            Game.tedad_sarbaz_in_city[0][Game.iii][Game.jjj] = 1;
        }
        Game.update();
        Game.ii = -1;
        Game.jj = -1;
        Game.iii = -1;
        Game.jjj = -1;



    }
    static void bazy_kon() {
        for(int i = 0; i < 4; i++){
            if (afrigha(i) && asia(i) && oropa(i) && amrica(i)) {
                new Victory();
            }
        }
        first_move();


    }
}

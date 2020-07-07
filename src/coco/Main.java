package coco;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Myclass a = null;
        Myclass b = null;
//        a.name = "owiejwoiefj";
//        b.name = "fuck";
//        a.meme = "mim";
//        b.meme = "memememememem";
//        try{
//            FileOutputStream fos = new FileOutputStream("shit.ser");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(a);
//            oos.writeObject(b);
//            oos.close();
//            fos.close();
//        }
//        catch (Exception e){
//            System.out.println("shit this shit");
//        }

        try{
            FileInputStream fis = new FileInputStream("shit.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            a = (Myclass) ois.readObject();
            b = (Myclass) ois.readObject();
            ois.close();
            fis.close();
        }catch (Exception e){
            System.out.println("eoifjoiejf");
        }
        a.cout();
        b.cout();

    }
}

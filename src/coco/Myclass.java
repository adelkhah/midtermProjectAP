package coco;

import java.io.Serializable;

public class Myclass implements Serializable{
    String name;
    transient String meme;
    public void cout(){
        System.out.println(name + " " + meme);
    }
}
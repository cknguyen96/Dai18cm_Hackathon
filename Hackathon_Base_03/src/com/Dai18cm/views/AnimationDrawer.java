package com.Dai18cm.views;

import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Admin on 5/16/2016.
 */
public class AnimationDrawer extends GameDrawer {
    private Vector<Image> imageVector;
    private int imageIdx = 0;
    private int count = 0;
    public static final int TIME_PER_FRAME_ANIMATION = 50;

    public AnimationDrawer(String[] urls){
        this.imageVector = new Vector<Image>();
        for(String url : urls){
            try {
                Image image = ImageIO.read(new File(url));
                this.imageVector.add(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //Chua dung den
    public AnimationDrawer(Image[] images){
        this.imageVector = new Vector<Image>();
        for(Image image : images){
            this.imageVector.add(image);
        }
    }
    public AnimationDrawer(Vector<Image> images){
        this.imageVector = images;
    }

    @Override
    public void paint(GameObject gameObject, Graphics g) {
        Image image = imageVector.get(imageIdx);
        g.drawImage(image,
                gameObject.getX(), gameObject.getY(),
                gameObject.getWidth(), gameObject.getHeight(),
                null);
        count++;
        if (GameConfig.getInst().durationInMiliSeconds(count) >= TIME_PER_FRAME_ANIMATION) {
            count = 0;
            imageIdx++;
            if(imageIdx >= imageVector.size()) {
                onEndVector(gameObject);
            }
        }
    }
    //DUng xet dying
    protected void onEndVector(GameObject gameObject) {
        imageIdx = 0;
    }
}

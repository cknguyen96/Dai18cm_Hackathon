package com.Dai18cm.views;

import com.Dai18cm.models.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Admin on 5/16/2016.
 */
public class ImageDrawer extends GameDrawer {
    private Image image;

    public ImageDrawer(String url){
        try {
            this.image = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(GameObject gameObject, Graphics g) {
        g.drawImage(this.image, gameObject.getX(), gameObject.getY(),
                gameObject.getWidth(),gameObject.getHeight(), null);
    }
}

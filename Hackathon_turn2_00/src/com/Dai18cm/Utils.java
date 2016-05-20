package com.Dai18cm;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Admin on 5/16/2016.
 */
public class Utils {

    public static void playSound(String audioUrl, boolean repeat) {
        File soundFile = new File(audioUrl);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            if(repeat) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else {
                clip.loop(0);
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage loadImage(String url) {
        try {
            BufferedImage image = ImageIO.read(new File(url));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Vector<Image> loadSpriteSheet(String url, int count, int offsetX, int offsetY, int subWidth, int subHeight) {
        Vector<Image> bufferedImagesVector = new Vector<Image>();
        BufferedImage spriteSheetImage = loadImage(url);
        for(int i = 0; i < count; i++) {
            int x = (i+1) * offsetX + i * subWidth;
            int y = offsetY;
            BufferedImage subImage = spriteSheetImage.getSubimage(x, y, subWidth, subHeight);
            bufferedImagesVector.add(subImage);
        }
        return bufferedImagesVector;
    }
    public static Vector<Image> loadAnimationImage(int count, String[] urls){//count la so phan tu trong mang String urls
        Vector<Image> bufferedImages = new Vector<Image>();
        for(int i = 0; i < count; i++){
            try {
                Image tmp = ImageIO.read(new File(urls[i]));
                bufferedImages.add(tmp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bufferedImages;
    }
}

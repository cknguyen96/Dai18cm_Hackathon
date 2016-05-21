package com.Dai18cm;

import com.Dai18cm.gamescene.GameScene;
import com.Dai18cm.models.Status;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Vector;

/**
 * Created by Admin on 5/16/2016.
 */
public class Utils {

    public static Object readObjectToXML(){
        XMLDecoder d = null;
        try {
            d = new XMLDecoder(
                    new BufferedInputStream(
                            new FileInputStream("Test.xml")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Object result = d.readObject();
        d.close();
        return result;
    }

    public static void writeObjectToXML(GameScene gameScene){
        XMLEncoder e = null;
        try {
            e = new XMLEncoder(
                    new BufferedOutputStream(
                            new FileOutputStream("Test.xml")));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        e.writeObject(gameScene);
        e.close();
    }


    public static void writeFile(){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("resources/HighScore.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println(Status.highestScore);
        writer.close();
    }


    public static int readFile(){
        int res = 0;
        try {
            for (String line : Files.readAllLines(Paths.get("resources/HighScore.txt"))) {
                res = Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Status.highestScore = 0;
            Utils.writeFile();
        }
        return res;
    }

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

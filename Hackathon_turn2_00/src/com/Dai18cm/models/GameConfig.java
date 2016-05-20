package com.Dai18cm.models;

import java.awt.*;

/**
 * Created by Admin on 5/16/2016.
 */
public class GameConfig {

    public static final int DEFAULT_SCREEN_WIDTH = 800;
    public static final int DEFAULT_SCREEN_HEIGHT = 600;
    public static final int DEFAULT_THREAD_DELAY = 17;
    public static final int DEFAULT_SCREEN_GAME = 380;

    private int screenWidth;
    private int screenHeight;
    private int threadDelay;
    public boolean checkOutGame = false;

    public GameConfig(int screenWidth, int screenHeight, int threadDelay) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.threadDelay = threadDelay;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getThreadDelay() {
        return threadDelay;
    }

    public void setThreadDelay(int threadDelay) {
        this.threadDelay = threadDelay;
    }

    public int durationInMiliSeconds(int count) {
        return count * threadDelay;
    }
    public int durationInSeconds(int count) {
        return count * threadDelay / 1000;
    }
    //Kiem tra xem con trong Screen hay ko
//    public boolean isInScreen(GameObject gameObject) {
//        return gameObject.getX() > 0 && gameObject.getX() < this.screenWidth / 2
//                && gameObject.getY() > 0 && gameObject.getY() < this.screenHeight;
//    }

    public boolean isInScreen(Rectangle rect) {
        return rect.getX() > 0 && rect.getX() + rect.getWidth() < this.screenWidth / 2
                && rect.getY() > 0 && rect.getY()  + rect.getHeight()  < this.screenHeight;
    }

    //Singleton
    private static GameConfig inst;
    public static GameConfig getInst() {
        if (inst == null) {
            inst = new GameConfig(DEFAULT_SCREEN_WIDTH,
                    DEFAULT_SCREEN_HEIGHT,
                    DEFAULT_THREAD_DELAY);
        }
        return inst;
    }
}

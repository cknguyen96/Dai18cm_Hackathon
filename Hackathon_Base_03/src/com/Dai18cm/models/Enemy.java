package com.Dai18cm.models;

/**
 * Created by Admin on 5/16/2016.
 */
public class Enemy extends GameObject {
    public static final int DEFAULT_WIDTH = 25;
    public static final int DEFAULT_HEIGHT = 35;
    public static final int DEFAULT_SPEED = 4;


    public Enemy(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, speed);
    }

    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}

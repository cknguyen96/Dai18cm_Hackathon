package com.Dai18cm.models;

/**
 * Created by Admin on 5/16/2016.
 */
public class Player extends GameObject {

    public static final int DEFAULT_WIDTH = 80;
    public static final int DEFAULT_HEIGHT = 80;
    public static final int DEFAULT_SPEED = 10;
    protected int width  = DEFAULT_WIDTH;
    protected int height = DEFAULT_HEIGHT;

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }


    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }
}

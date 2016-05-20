package com.Dai18cm.models;

import com.Dai18cm.controllers.LevelType;

/**
 * Created by Admin on 5/19/2016.
 */
public class SunFlower extends GameObject {
    public static LevelType levelType = LevelType.LEVEL_0;
    public SunFlower(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public SunFlower(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, speed);
    }
}

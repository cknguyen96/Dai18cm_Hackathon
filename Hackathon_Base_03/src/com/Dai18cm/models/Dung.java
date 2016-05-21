package com.Dai18cm.models;

/**
 * Created by nhoxkem96 on 21/05/2016.
 */
public class Dung  extends GameObjectWithHP {
    public static final int DEFAULT_WIDTH = 25;
    public static final int DEFAULT_HEIGHT = 35;
    public static final int DEFAULT_SPEED = 4;
    public static final int DEFAULT_HP = 3;

    public Dung(int x, int y, int width, int height) {
        super(x, y, width, height);
        hp = DEFAULT_HP;
    }
}

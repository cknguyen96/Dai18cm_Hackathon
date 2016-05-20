package com.Dai18cm.models;

/**
 * Created by Admin on 5/16/2016.
 */
public class Status {
    public static final int DEFAULT_HP = 5;
    private static int score = 0;
    private static int hp = DEFAULT_HP;

    public static int getHp() {
        return hp;
    }

    public static int getScore() {
        return score;
    }

    public static void increaseScore() {
        score++;
    }

    public static void decreaseHP() {
        if(hp > 0) hp--;
    }

    public static void resetScore(){
        score = 0;
    }

    public static void resetHP(){
        hp = DEFAULT_HP;
    }
}

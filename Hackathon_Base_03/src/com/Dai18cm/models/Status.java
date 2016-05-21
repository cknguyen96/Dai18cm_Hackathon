package com.Dai18cm.models;

import com.Dai18cm.Utils;

/**
 * Created by Admin on 5/16/2016.
 */
public class Status {
    public static int highestScore = Utils.readFile();
    public static int playerScore = 0;
    public static final int DEFAULT_HP = 5;
    private static int score = 0;
    private static int hp = DEFAULT_HP;
    private static int currentLVScore = 0;

    public static int getCurrentLVScore() {
        return currentLVScore;
    }

    public static void setCurrentLVScore(int currentLVScore) {
        Status.currentLVScore = currentLVScore;
    }

    public static int getHp() {
        return hp;
    }

    public static int getScore() {
        return score;
    }


    public static void increaseScore() {
        score++;
        currentLVScore ++;
    }
    public static void increaseScore(int delta){
        score += delta;
        currentLVScore += delta;
    }

    public static void decreaseHP() {
        if(hp > 0) hp--;
    }

    public static void increaseHP(){
        if(hp < 5) hp++;
    }

    public static void resetScore(){
        score = 0;
        currentLVScore = 0;
    }

    public static void resetHP(){
        hp = DEFAULT_HP;
    }

    public static void decreaseScore(int delta){
        score -= delta;
        currentLVScore -= delta;
    }
}

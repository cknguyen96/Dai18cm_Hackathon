package com.Dai18cm;

import com.Dai18cm.controllers.EnemyControllerManager;
import com.Dai18cm.controllers.LevelType;
import com.Dai18cm.models.Status;
import com.Dai18cm.models.SunFlower;

/**
 * Created by Admin on 5/20/2016.
 */
public class LevelManager {
//    public static LevelType levelType = LevelType.LEVEL_0;
    private static int levelTypeByInt = 0;
    public static void decreaseLevel(){
        Status.decreaseScore(5);
        if(levelTypeByInt == 0) return;
        levelTypeByInt --;
    }
    public static void increaseLevel(){
        Status.increaseScore(5);
        if(levelTypeByInt == 3) return;
        levelTypeByInt ++;
    }
    public static void changeLevel(){
        if(Status.getCurrentLVScore() >= 10){
            levelTypeByInt ++;
            if(levelTypeByInt == 4) levelTypeByInt --;
            Status.setCurrentLVScore(0);
        }
        switch (levelTypeByInt){
            case 0:
                SunFlower.levelType = LevelType.LEVEL_0;
                EnemyControllerManager.getInst().levelChange(LevelType.LEVEL_0);
//                levelType = LevelType.LEVEL_0;
                break;
            case 1:
                SunFlower.levelType = LevelType.LEVEL_1;
                EnemyControllerManager.getInst().levelChange(LevelType.LEVEL_1);
//                levelType = LevelType.LEVEL_1;
                break;
            case 2:
                SunFlower.levelType = LevelType.LEVEL_2;
                EnemyControllerManager.getInst().levelChange(LevelType.LEVEL_2);
//                levelType = LevelType.LEVEL_2;
                break;
            case 3:
                SunFlower.levelType = LevelType.LEVEL_3;
                EnemyControllerManager.getInst().levelChange(LevelType.LEVEL_3);
//                levelType = LevelType.LEVEL_3;
                break;
        }
    }
    public static void reset(){
        levelTypeByInt = 0;
        Status.setCurrentLVScore(0);
    }
}
